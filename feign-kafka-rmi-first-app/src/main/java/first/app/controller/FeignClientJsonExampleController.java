package first.app.controller;

import common.dto.patterns.iterator.Food;
import first.app.api.FeignClientJsonService;
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

    private final FeignClientJsonService feignClientJsonService;

    @GetMapping("/getJsonExample")
    public Food getSalad() {
        return feignClientJsonService.getSalad();
    }

    @PostMapping("/postJsonExample")
    public Food createFood(@RequestBody Food food) {
        return feignClientJsonService.createFood(food);
    }

}
