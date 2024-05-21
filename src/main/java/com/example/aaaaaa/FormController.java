package com.example.aaaaaa;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

    private final String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Pack my box with five dozen liquor jugs.",
            "How razorback-jumping frogs can level six piqued gymnasts!",
            "Jackdaws love my big sphinx of quartz."
    };

    @GetMapping("/")
    public String home(Model model) {
        Random random = new Random();
        String randomSentence = sentences[random.nextInt(sentences.length)];
        model.addAttribute("sentence", randomSentence);
        return "index";
    }
}
