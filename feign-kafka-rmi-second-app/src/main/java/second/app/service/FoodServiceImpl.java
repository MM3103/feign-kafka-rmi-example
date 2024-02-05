package second.app.service;

import io.grpc.stub.StreamObserver;
import proto.FoodProto;
import proto.FoodServiceGrpc;

public class FoodServiceImpl extends FoodServiceGrpc.FoodServiceImplBase {
    @Override
    public void getFood(FoodProto.FoodProtoBuf request, StreamObserver<FoodProto.FoodProtoBuf> responseObserver) {
        // Обработка запроса и формирование ответа
        FoodProto.FoodProtoBuf food = FoodProto.FoodProtoBuf.newBuilder()
                .setName("Salat")
                .setCost(20)
                .setWeight(200)
                .build();
        responseObserver.onNext(food);
        responseObserver.onCompleted();
    }
}

