package com.example.aaaaaa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @Autowired
    private Typing typing;
  

    @GetMapping("/")
    public String index(Model model) {
    	model.addAttribute("word", typing.getWord());
    	return "index";
    }
    
    @PostMapping("/check")
    public String check(@RequestParam("userInput") String userInput, Model model) {
        typing.checkInput(userInput);
        model.addAttribute("score", typing.getScore());
        model.addAttribute("miss", typing.getMiss());
        model.addAttribute("word", typing.getWord());
        return "result";
    }
}
