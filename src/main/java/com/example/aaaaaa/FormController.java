package com.example.aaaaaa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

    @GetMapping("/")
    public String home(Model model) {
    	model.addAttribute("message","hello");
        return "index"; // index.htmlを返す
    }
}
