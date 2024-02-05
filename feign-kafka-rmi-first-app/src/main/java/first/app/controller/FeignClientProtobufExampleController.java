package first.app.controller;

import first.app.api.FeignClientProtobufService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proto.FoodProto;

@RestController
@RequestMapping("/feignProtobufExample")
@RequiredArgsConstructor
public class FeignClientProtobufExampleController {

    private final FeignClientProtobufService feignClientProtobufService;

    @GetMapping("/getProtobufExample")
    public FoodProto.FoodProtoBuf getSalad() {
        return feignClientProtobufService.getSalad();
    }

    @GetMapping(value = "/postProtobufExample", produces = "application/x-protobuf")
    public FoodProto.FoodProtoBuf createFood() {
        return feignClientProtobufService.createFood();
    }

}
