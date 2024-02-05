package first.app.controller;

import common.dto.FoodOrder;
import first.app.service.rmi.RmiServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rmiExample")
@RequiredArgsConstructor
public class RmiExampleController {

    private final RmiServiceImpl rmiService;

    @PatchMapping("/setCostFoodOrder")
    public Integer setCostFoodOrder(@RequestBody FoodOrder foodOrder) {
        return rmiService.setCostFoodOrder(foodOrder);
    }
}
