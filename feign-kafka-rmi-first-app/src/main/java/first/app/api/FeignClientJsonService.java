package first.app.api;

import common.dto.patterns.iterator.Food;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Сервис для работы с feign client.
 */
public interface FeignClientJsonService {

    Food getSalad();

    Food createFood(@RequestBody Food food);
}
