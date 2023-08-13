package first.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import common.dto.FoodOrder;
import first.app.rmi.RmiServiceImpl;
import first.app.service.FoodOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodOrderController {

    private final FoodOrderService foodOrderService;

    private final RmiServiceImpl rmiService;

    @PostMapping("/createFoodOrder")
    public String createFoodOrder(@RequestBody FoodOrder foodOrder) throws JsonProcessingException {
        log.info("create food order request received");
        return foodOrderService.createFoodOrder(foodOrder);
    }

    @PatchMapping("/setCostFoodOrder")
    public Integer setCostFoodOrder(@RequestBody FoodOrder foodOrder) {
        return rmiService.setCostFoodOrder(foodOrder);
    }

}
