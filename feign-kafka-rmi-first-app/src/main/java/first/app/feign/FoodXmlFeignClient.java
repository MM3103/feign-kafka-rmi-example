package first.app.feign;

import feign.Headers;
import first.app.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test._1_0.TestRequestType;

/**
 * Test feign client.
 */
@FeignClient(value = "feignDemoXml", url = "localhost:8485/foodXml", configuration = FeignConfig.class)
public interface FoodXmlFeignClient {

    @GetMapping(value = "/getSaladXml")
    TestRequestType getSalad();

    //@Headers("Content-Type: application/xml")
    @PostMapping(value = "/createFoodXml", consumes = "application/xml")
    TestRequestType createFood(@RequestBody String food);

}
