package first.app.controller;

import common.model.Book;
import first.app.feign.TestFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestFeignClient testFeignClient;

    @GetMapping("/getBook")
    public Book getBook(){
        return testFeignClient.getBook();
    }

    @GetMapping("/getBookName")
    public String getBookName(){
        return testFeignClient.getBook().getName();
    }

    @GetMapping("/getBookSize")
    public Integer getBookSize(){
        return testFeignClient.getBook().getSize();
    }

    @GetMapping("/getBookAuthor")
    public String getBookAuthor(){
        return testFeignClient.getBook().getAuthor();
    }

    @PostMapping("/createBook")
    public Book createBook(@RequestBody Book book){
        return testFeignClient.createBook(book);
    }

}
