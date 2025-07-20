package com.example.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class BasicController {
    private final ItemRepository itemRepository;

    public BasicController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

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

    @GetMapping("/write")
    String write(){
        return "write";
    }
    @PostMapping("/add")
    String addPost(@RequestParam String title, Integer price){
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        return "redirect:/list";
    }

}
