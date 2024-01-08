package first.app.feign;

import first.app.FoodProto;
import first.app.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Test feign client.
 */
@FeignClient(value = "feignDemoProtobuf", url = "localhost:8485/foodProtobuf", configuration = FeignConfig.class)
public interface FoodProtobufFeignClient {

    @GetMapping(value = "/getSaladProtobuf")
    FoodProto.FoodProtoBuf getSalad();

    @PostMapping(value = "/createFoodProtobuf", consumes = "application/x-protobuf")
    FoodProto.FoodProtoBuf createFood(FoodProto.FoodProtoBuf food);

}
