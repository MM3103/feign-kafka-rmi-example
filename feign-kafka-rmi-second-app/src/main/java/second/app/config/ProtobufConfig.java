package second.app.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProtobufConfig {
    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

/*    @Bean
    public void restTemplate(RestTemplate rt, ProtobufHttpMessageConverter protobufHttpMessageConverter) {
        rt.getMessageConverters().add(protobufHttpMessageConverter);
    }*/
}
