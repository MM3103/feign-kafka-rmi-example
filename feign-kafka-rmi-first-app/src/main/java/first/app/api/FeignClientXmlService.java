package first.app.api;

import org.springframework.web.bind.annotation.RequestBody;
import test._1_0.TestRequestType;

/**
 * Сервис для работы с feign client.
 */
public interface FeignClientXmlService {

    TestRequestType getSalad();

    TestRequestType createFood(@RequestBody TestRequestType food);
}
