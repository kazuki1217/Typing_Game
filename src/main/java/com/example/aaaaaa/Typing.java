package com.example.aaaaaa;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Typing {
	private String[] words = { "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "=", "[", "]", "{", "}", "|",
			";", ":", "\"", "'" };
	private String word = "@";
	private int score = 0;
	private int miss = 0;

	public String getRandomWord() {
		return words[(int) (Math.random() * words.length)];
	}

	public void reset() {
		score = 0; //入力が正しい場合
		miss = 0; //入力が間違えの場合
		word = "@";

	}

	public void checkInput(String userInput) {

		if (userInput.equals(word)) {
			score++;
		} else {
			miss++;
		}

		if ((score + miss) % 10 == 0) {
			String[] homePosition = { "Set home position", "Return to home position", "Reset to home position",
					"Back to starting point", "Revert to home position", "Position reset to home",
					"Restore default position", "Set cursor to home", "Recenter to home position",
					"Position reset to default" };
			int randomIndex = (int) (Math.random() * homePosition.length);
			setWord(homePosition[randomIndex]); // homeからランダムな値を選んでセット
		} else {
			String newWord = getRandomWord(); // ランダムな単語を取得
			setWord(newWord);
		}
	}

}
