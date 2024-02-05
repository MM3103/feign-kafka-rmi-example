package first.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.InvalidProtocolBufferException;
import common.dto.FoodOrder;
import first.app.service.FoodOrderKafkaServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test._1_0.TestRequestType;

@Slf4j
@RestController
@RequestMapping("/kafkaExample")
@RequiredArgsConstructor
public class KafkaExampleController {

    private final FoodOrderKafkaServiceImpl foodOrderService;

    @PostMapping("/createFoodOrder")
    public String createFoodOrder(@RequestBody FoodOrder foodOrder) throws JsonProcessingException {
        log.info("create food order request received");
        return foodOrderService.createFoodOrderJson(foodOrder);
    }

    @PostMapping(value = "/createFoodOrderXml", consumes = "application/xml")
    public String createFoodOrderXml(@RequestBody TestRequestType testRequestType) {
        log.info("create food order request received");
        return foodOrderService.createFoodOrderXml(testRequestType);
    }

    @GetMapping(value = "/createFoodOrderProtobuf")
    public String createFoodOrderProtobuf() throws JsonProcessingException, InvalidProtocolBufferException {
        log.info("create food order request received");
        return foodOrderService.createFoodOrderProtobuf();
    }

}
