package second.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

@SpringBootApplication
@Slf4j
@OpenAPIDefinition(info = @Info(title = "Project Api", version = "1.0", description = "Second app"))
public class SecondAppStarter {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        final ApplicationContext ctx = SpringApplication.run(SecondAppStarter.class, args);

        final TimeZone tz = Calendar.getInstance().getTimeZone();
        log.info("======= TIMEZONE_NAME: {} =======", tz.getDisplayName());
        log.info("======= TIMEZONE_ID: {} =======", tz.getID());
        log.info("For inspect the beans provided by Spring Boot toggle logger debug mode:");

        final String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (final String beanName : beanNames) {
            log.debug("BeanName {}", beanName);
        }

        log.info("*****************************************");
        log.info("***** FeignClientExample second application started *****");
        log.info("*****************************************");
    }
}
