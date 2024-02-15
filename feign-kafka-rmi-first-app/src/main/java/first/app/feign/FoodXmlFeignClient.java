package first.app.feign;

import first.app.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test._1_0.TestRequestType;

/**
 * Test feign client with XML.
 */
@FeignClient(value = "feignDemoXml", url = "${secondApp.url}", configuration = FeignConfig.class)
public interface FoodXmlFeignClient {

    @GetMapping(value = "/foodXml/getSaladXml")
    TestRequestType getSalad();

    @PostMapping(value = "/foodXml/createFoodXml", consumes = "application/xml")
    TestRequestType createFood(@RequestBody TestRequestType food);

}
