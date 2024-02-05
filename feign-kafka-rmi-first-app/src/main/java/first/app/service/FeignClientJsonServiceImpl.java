package first.app.service;


import common.dto.patterns.iterator.Food;
import first.app.api.FeignClientJsonService;
import first.app.feign.FoodFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с feign client.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FeignClientJsonServiceImpl implements FeignClientJsonService {

    private final FoodFeignClient foodFeignClient;

    @Override
    public Food getSalad() {
        return foodFeignClient.getSalad();
    }

    @Override
    public Food createFood(Food food) {
        return foodFeignClient.createFood(food);
    }
}
