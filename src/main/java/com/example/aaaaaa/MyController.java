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
		typing.reset(); // Typingクラス内のメンバ変数をリセット
		model.addAttribute("word", typing.getWord()); //初期値aaaaが表示
		return "index";
	}

	@PostMapping("/typing")
	public String typing(@RequestParam("userInput") String userInput, Model model) {
		//    	userInputは入力した値
		typing.checkInput(userInput);
		model.addAttribute("score", typing.getScore());
		model.addAttribute("miss", typing.getMiss());
		model.addAttribute("word", typing.getWord());
		if ((typing.getScore() + typing.getMiss()) <= 16) {
			return "typing";
		} else {
			return "result";

		}
	}

	@GetMapping("/result")
	public String result(Model model) {
		model.addAttribute("score", typing.getScore());
		model.addAttribute("miss", typing.getMiss());
		return "result";
	}
}
