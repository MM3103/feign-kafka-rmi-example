package first.app.controller;

import common.dto.patterns.iterator.Food;
import first.app.feign.FoodFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feignJsonExample")
@RequiredArgsConstructor
public class FeignClientJsonExampleController {

    private final FoodFeignClient foodFeignClient;

    @GetMapping("/getJsonExample")
    public Food getSalad(){
        return foodFeignClient.getSalad();
    }

    @PostMapping("/postJsonExample")
    public Food createFood(@RequestBody Food food){
        return foodFeignClient.createFood(food);
    }

}
