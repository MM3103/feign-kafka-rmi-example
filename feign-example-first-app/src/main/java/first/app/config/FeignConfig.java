package first.app.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import first.app.feign.SecurityFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeignConfig implements RequestInterceptor {

    private final SecurityFeignClient securityFeignClient;

    @Override
    public void apply(RequestTemplate template) {
        template.header(HttpHeaders.AUTHORIZATION, "Bearer " + getToken());
    }

    private String getToken() {
        return securityFeignClient.getToken("admin", "admin");
    }
}
