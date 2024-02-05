package second.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proto.FoodProto;

@RestController
@RequestMapping("/foodProtobuf")
@Slf4j
public class FoodProtobufController {

    @GetMapping(value = "/getSaladProtobuf", produces = "application/x-protobuf")
    public FoodProto.FoodProtoBuf getSalad() {
        FoodProto.FoodProtoBuf food = FoodProto.FoodProtoBuf.newBuilder()
                .setName("Salat")
                .setCost(100)
                .setWeight(150)
                .build();
        log.info("Выдано новое блюдо " + food.getName());
        return food;
    }

    @PostMapping(value = "/createFoodProtobuf", consumes = "application/x-protobuf", produces = "application/x-protobuf")
    public FoodProto.FoodProtoBuf createFood(@RequestBody FoodProto.FoodProtoBuf food) {
        FoodProto.FoodProtoBuf newfood = FoodProto.FoodProtoBuf.newBuilder()
                .setName("новый" + food.getName())
                .setCost(food.getCost() + 10)
                .setWeight(food.getWeight() + 10)
                .build();
        log.info("Приготовлено новое блюдо " + newfood.getName());
        return newfood;
    }
}
