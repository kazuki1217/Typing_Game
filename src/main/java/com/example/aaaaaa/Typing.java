package com.example.aaaaaa;

import org.springframework.stereotype.Component;

@Component
public class Typing {
	private String[] words = { "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "=", "[", "]", "{", "}", "|",
			";", ":", "\"", "'" };
	private String word = "aaaa";
	private int score = 0;
	private int miss = 0;

	public String getRandomWord() {
		return words[(int) (Math.random() * words.length)];
	}

	public void checkInput(String input) {
		//	    if (input.equals("q")) {
		//	        return;
		//	    }

		if (input.equals(word)) {
			score++; // 入力が正しい場合にスコアをインクリメント
		} else {
			miss++;
		}
		String word = getRandomWord();
		setWord(word);
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public int getScore() {
		return score;
	}

	public int getMiss() {
		return miss;
	}
}
