package com.example.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model) {
        var result = itemRepository.findAll();
        System.out.println(result);
        model.addAttribute("items", result);
        var a = new Item();
        System.out.println(a);
        return "list";
    }

    @PostMapping("/add")
    String addPost(@RequestParam String title, Integer price){
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepository.findById(Long.valueOf(id));
        if(result.isPresent()) {
            System.out.println(result.get());
            model.addAttribute("data",result.get());
        }
        else {
            return "redirect:/list";
        }
//        System.out.println(result.get());
        return "detail.html";
    }
}