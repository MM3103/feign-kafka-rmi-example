package first.app.feign;

import common.dto.patterns.iterator.Food;
import first.app.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Test feign client with JSON.
 */
@FeignClient(value = "feignDemo", url = "${secondApp.url}", configuration = FeignConfig.class)
public interface FoodFeignClient {

    @GetMapping("food/getSalad")
    Food getSalad();

    @PostMapping("food/createFood")
    Food createFood(Food food);

}
