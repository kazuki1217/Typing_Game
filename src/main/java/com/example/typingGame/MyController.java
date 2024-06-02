package com.example.typingGame;

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
		if ((typing.getScore() + typing.getMiss()) < 11) {
			return "typing";
		} else {

//			経過時間をビューへ送る
			stopWatch.stop();
			model.addAttribute("elapsedTime", stopWatch.getElapsedTime());

//			gameResultエンティティにスコア、ミス、経過時間の情報を送り、DBへ保存
			GameResult gameResult = new GameResult(null, typing.getScore(), typing.getMiss(),
					stopWatch.getElapsedTime());
			gameResultRepository.save(gameResult);
			
//			全てのスコア、ミス、経過時間の情報をビューへ送る
			model.addAttribute("results", gameResultRepository.findAll());
			return "result";

		}

	}

}
