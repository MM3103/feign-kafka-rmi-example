package second.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import second.app.FoodProto;

@RestController
@RequestMapping("/foodProtobuf")
@Slf4j
public class FoodProtobufController {

    @GetMapping(value = "/getSaladProtobuf")
    public FoodProto.FoodProtoBuf getSalad() {
        FoodProto.FoodProtoBuf food = FoodProto.FoodProtoBuf.newBuilder()
                .setName("Salat")
                .setCost(100)
                .setWeight(150)
                .build();
        log.info("Выдано новое блюдо " + food.getName());
        return food;
    }

    @PostMapping(value = "/createFoodProtobuf", consumes = "application/x-protobuf")
    public FoodProto.FoodProtoBuf createFood(@RequestBody FoodProto.FoodProtoBuf food) {
        log.info("Приготовлено новое блюдо " + food.getName());
        return food;
    }
}
