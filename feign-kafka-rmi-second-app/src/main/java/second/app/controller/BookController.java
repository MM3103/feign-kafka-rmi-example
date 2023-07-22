package second.app.controller;

import common.dto.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    @GetMapping("/getBook")
    public Book getBook(){
        log.info("getBook run");
        return new Book("Random book","Random author",23);
    }

    @PostMapping("/createBook")
    public Book createBook(@RequestBody Book book){
        log.info("createBook run");
        return book;
    }

}
