package com.koreait.surl_project_11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String main() {
        return "main";
    }

    @GetMapping("home")
    @ResponseBody
    public String home() {
        return "Hello World";
    }
}
