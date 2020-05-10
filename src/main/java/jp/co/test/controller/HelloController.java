package jp.co.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "jp.co.hello world";
    }

}
