package com.example.aaaaaa;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Typing {
    private String[] words = {"apple", "banana", "orange", "grape", "melon"};
    private int score = 0;
    private int miss = 0;
    private Scanner scanner = new Scanner(System.in);

    public String getRandomWord() {
        return words[(int) (Math.random() * words.length)];
    }

    public void checkInput(String input) {
        if (input.equals("q")) {
            return;
        }

        String word = getRandomWord();
        System.out.println(word); // コンソールに表示する代わりに、ビューに表示するためにこの行をコメントアウトします。

        if (input.equals(word)) {
            score++;
        } else {
            miss++;
        }
    }

    public int getScore() {
        return score;
    }

    public int getMiss() {
        return miss;
    }
}
