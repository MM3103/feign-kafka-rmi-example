package first.app.controller;

import first.app.FoodProto;
import first.app.feign.FoodProtobufFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feignProtobufExample")
@RequiredArgsConstructor
public class FeignClientProtobufExampleController {

    private final FoodProtobufFeignClient foodProtobufFeignClient;

    @GetMapping("/getProtobufExample")
    public FoodProto.FoodProtoBuf getSalad() {
        return foodProtobufFeignClient.getSalad();
    }

    @PostMapping("/postProtobufExample")
    public FoodProto.FoodProtoBuf createFood(@RequestBody FoodProto.FoodProtoBuf food) {
        return foodProtobufFeignClient.createFood(food);
    }

}
