package first.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Security feign client.
 */
@FeignClient(value = "feignSecurity", url="localhost:8485/security")
public interface SecurityFeignClient {

    @GetMapping("/getToken")
    String getToken(@RequestParam String username, @RequestParam String password);
}
