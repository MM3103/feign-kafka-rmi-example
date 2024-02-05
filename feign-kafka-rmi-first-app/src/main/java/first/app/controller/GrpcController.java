package first.app.controller;

import first.app.api.GrpcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/GrpsExample")
@RequiredArgsConstructor
public class GrpcController {

    private final GrpcService grpcService;

    @GetMapping(value = "/getFoodGrps")
    public void getSalad() {
        grpcService.getSalad();
    }
}
