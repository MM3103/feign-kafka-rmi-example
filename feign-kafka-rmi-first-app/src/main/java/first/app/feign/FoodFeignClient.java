package first.app.feign;

import common.dto.patterns.iterator.Food;
import first.app.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Test feign client with JSON.
 */
@FeignClient(value = "feignDemo", url = "localhost:8485/food", configuration = FeignConfig.class)
public interface FoodFeignClient {

    @GetMapping("/getSalad")
    Food getSalad();

    @PostMapping("/createFood")
    Food createFood(Food food);

}
