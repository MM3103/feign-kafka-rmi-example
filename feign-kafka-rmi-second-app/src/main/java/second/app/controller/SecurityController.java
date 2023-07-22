package second.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import second.app.service.SecurityService;

@RestController
@RequestMapping("/security")
@Slf4j
@RequiredArgsConstructor
public class SecurityController {

    private final SecurityService securityService;

    @GetMapping("/getToken")
    public String getToken(@RequestParam String username, @RequestParam String password){
        String token = securityService.getToken(username, password);
        log.info("Try to get auth token: " + token);
        return token;
    }
}
