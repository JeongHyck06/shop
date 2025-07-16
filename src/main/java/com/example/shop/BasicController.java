package com.example.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello(){
        return "redirect:/index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "이 사이트는 사기 사이트입니다";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "내 사이트다";
    }
}
