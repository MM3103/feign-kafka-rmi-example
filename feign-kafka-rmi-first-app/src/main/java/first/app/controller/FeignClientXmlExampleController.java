package first.app.controller;

import first.app.api.FeignClientXmlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test._1_0.TestRequestType;

@RestController
@RequestMapping("/feignXmlExample")
@RequiredArgsConstructor
public class FeignClientXmlExampleController {

    private final FeignClientXmlService feignClientXmlService;

    @GetMapping(value = "/getXmlExample")
    public TestRequestType getSalad() {
        return feignClientXmlService.getSalad();
    }

    @PostMapping(value = "/postXmlExample")
    public TestRequestType createFood(@RequestBody TestRequestType food) {
        return feignClientXmlService.createFood(food);
    }

}
