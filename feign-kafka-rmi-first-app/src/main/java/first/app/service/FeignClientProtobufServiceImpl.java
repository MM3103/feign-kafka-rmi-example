package first.app.service;

import first.app.api.FeignClientProtobufService;
import first.app.feign.FoodProtobufFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import proto.FoodProto;

/**
 * Сервис для работы с feign client.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FeignClientProtobufServiceImpl implements FeignClientProtobufService {

    private final FoodProtobufFeignClient foodProtobufFeignClient;
    @Override
    public FoodProto.FoodProtoBuf getSalad() {
        return foodProtobufFeignClient.getSalad();
    }

    @Override
    public FoodProto.FoodProtoBuf createFood() {
        FoodProto.FoodProtoBuf food = FoodProto.FoodProtoBuf.newBuilder()
                .setName("Salat")
                .setCost(100)
                .setWeight(150)
                .build();
        return foodProtobufFeignClient.createFood(food);
    }
}
