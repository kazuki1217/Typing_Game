package com.example.aaaaaa;

import java.util.Scanner;

public class Typing {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] words = { "apple", "banana", "orange", "grape", "melon" };
		int score = 0;
		int miss = 0;

		while (true) {
			String word = words[(int) (Math.random() * words.length)];
			System.out.println(word);
			String input = scanner.nextLine();

			if (input.equals("q")) {
				break;
			}

			if (input.equals(word)) {
				score++;
			} else {
				miss++;
				System.out.println("Miss");
			}
		}

		System.out.println("score: " + score);
		System.out.println("miss:"+ miss);
	}
}
