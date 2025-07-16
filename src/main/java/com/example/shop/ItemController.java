package com.example.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model) {
        var result = itemRepository.findAll();
        System.out.println(result);
        model.addAttribute("name", "홍길동");
        return "list";
    }
}
