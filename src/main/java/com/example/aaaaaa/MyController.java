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

	@Autowired
	private StopWatch stopWatch;

	@Autowired
	private GameResultRepository gameResultRepository;

	@GetMapping("/")
	public String index(Model model) {
		typing.reset();	
		stopWatch.start();
		model.addAttribute("word", typing.getWord()); 
		return "index";
	}

	@PostMapping("/typing")
	public String typing(@RequestParam("userInput") String userInput, Model model) {
		typing.checkInput(userInput);
		model.addAttribute("score", typing.getScore());
		model.addAttribute("miss", typing.getMiss());
		model.addAttribute("word", typing.getWord());
		if ((typing.getScore() + typing.getMiss()) < 10) {
			return "typing";
		} else {
			
			stopWatch.stop();
			model.addAttribute("elapsedTime", stopWatch.getElapsedTime());
			
			GameResult gameresult = new GameResult();
			gameresult.setScore(typing.getScore());
			gameresult.setMiss(typing.getMiss());
			System.out.println((stopWatch.getElapsedTime()));

			gameresult.setElapsedTime(stopWatch.getElapsedTime());
			gameResultRepository.save(gameresult);
			model.addAttribute("results", gameResultRepository.findAll());
			return "result";

		}

	}

}
