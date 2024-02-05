package second.app.controller;

import common.dto.patterns.iterator.Food;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
@Slf4j
public class FoodController {

    @GetMapping("/getSalad")
    public Food getSalad(){
        Food food = new Food("Салат",100,150);
        log.info("Выдано новое блюдо " + food.getName());
        return food;
    }

    @PostMapping("/createFood")
    public Food createFood(@RequestBody Food food){
        log.info("Приготовлено новое блюдо " + food.getName());
        return food;
    }

}
