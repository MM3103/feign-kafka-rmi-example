package first.app.feign;

import common.dto.Book;
import first.app.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Test feign client.
 */
@FeignClient(value = "feignDemo", url="localhost:8485/book",configuration = FeignConfig.class)
public interface TestFeignClient {

    @GetMapping("/getBook")
    Book getBook();

    @PostMapping("/createBook")
    Book createBook(Book book);

}
