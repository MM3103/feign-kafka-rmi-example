package first.app.feign;

import first.app.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import proto.FoodProto;

/**
 * Test feign client with ProtoBuf.
 */
@FeignClient(value = "feignDemoProtobuf", url = "localhost:8485/foodProtobuf", configuration = FeignConfig.class)
public interface FoodProtobufFeignClient {

    @GetMapping(value = "/getSaladProtobuf")
    FoodProto.FoodProtoBuf getSalad();

    @PostMapping(value = "/createFoodProtobuf", consumes = "application/x-protobuf", produces = "application/x-protobuf")
    FoodProto.FoodProtoBuf createFood(FoodProto.FoodProtoBuf food);

}
