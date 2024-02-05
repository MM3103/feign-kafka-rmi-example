package first.app.service;

import first.app.api.GrpcService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import proto.FoodProto;
import proto.FoodServiceGrpc;

@Slf4j
@Service
@RequiredArgsConstructor
public class GrpcServiceImpl implements GrpcService {
    @Override
    public void getSalad() {
        log.info("Grpc");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9022)
                .usePlaintext()
                .build();

        FoodServiceGrpc.FoodServiceBlockingStub stub = FoodServiceGrpc.newBlockingStub(channel);

        FoodProto.FoodProtoBuf request = FoodProto.FoodProtoBuf.newBuilder().build();
        FoodProto.FoodProtoBuf response = stub.getFood(request);

        log.info("Received food: " + response.getName() + ", Cost: " + response.getCost() + ", Weight: " + response.getWeight());

        channel.shutdown();
    }
}
