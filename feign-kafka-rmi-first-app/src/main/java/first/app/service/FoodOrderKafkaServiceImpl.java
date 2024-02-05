package first.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.InvalidProtocolBufferException;
import common.dto.FoodOrder;
import first.app.api.FoodOrderKafkaService;
import first.app.kafka.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import proto.FoodProto;
import test._1_0.TestRequestType;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodOrderKafkaServiceImpl implements FoodOrderKafkaService {

    private final Producer producer;

    public String createFoodOrderJson(FoodOrder foodOrder) throws JsonProcessingException {
        return producer.sendMessageJson(foodOrder);
    }

    public String createFoodOrderXml(TestRequestType testRequestType) {
        return producer.sendMessageXml(testRequestType);
    }

    public String createFoodOrderProtobuf() throws JsonProcessingException, InvalidProtocolBufferException {
        FoodProto.FoodProtoBuf food = FoodProto.FoodProtoBuf.newBuilder()
                .setName("Pizza")
                .setCost(100)
                .setWeight(150)
                .build();
        return producer.sendMessageProtobuf(food);
    }
}
