package second.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test._1_0.TestRequestType;

@RestController
@RequestMapping("/foodXml")
@Slf4j
public class FoodXmlController {

    @GetMapping(value = "/getSaladXml")
    public TestRequestType getSalad() {
        TestRequestType food = new TestRequestType();
        food.setFoodName("Салат");
        food.setCost(100);
        food.setWeight(150);
        log.info("Выдано новое блюдо " + food.getFoodName());
        return food;
    }

    @PostMapping(value = "/createFoodXml", consumes = "application/xml")
    public TestRequestType createFood(@RequestBody TestRequestType testRequestType) {
        log.info("Приготовлено новое блюдо " + testRequestType.getFoodName());
        return testRequestType;
    }
}
