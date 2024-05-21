package com.example.aaaaaa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @Autowired
    private Typing typingGame;

    @PostMapping("/check")
    public String check(@RequestParam("userInput") String userInput, Model model) {
        typingGame.checkInput(userInput);
        model.addAttribute("score", typingGame.getScore());
        model.addAttribute("miss", typingGame.getMiss());
        return "result";
    }
}
