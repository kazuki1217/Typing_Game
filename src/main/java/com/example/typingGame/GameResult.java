package com.example.typingGame;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameResult {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OrderColumn
	private Long id;
	
	@OrderColumn
	private int score;
	
	@OrderColumn
	private int miss;
	
	@OrderColumn
	private long elapsedTime;
}
