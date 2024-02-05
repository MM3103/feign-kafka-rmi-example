package first.app.service;

import first.app.api.FeignClientXmlService;
import first.app.feign.FoodXmlFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test._1_0.TestRequestType;

/**
 * Сервис для работы с feign client.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FeignClientXmlServiceImpl implements FeignClientXmlService {

    private final FoodXmlFeignClient foodXmlFeignClient;
    @Override
    public TestRequestType getSalad() {
        return foodXmlFeignClient.getSalad();
    }

    @Override
    public TestRequestType createFood(TestRequestType food) {
        return foodXmlFeignClient.createFood(food);
    }
}
