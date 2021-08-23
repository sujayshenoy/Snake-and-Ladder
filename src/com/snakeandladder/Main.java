package com.snakeandladder;
import java.util.*;
import static java.util.Map.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Snake and Ladder Game");
		
	}
	
	Game g = new Game(); //new game with initial position 0 is created
	
}

class Game{
	int position = 0;
	
	//Positions of Snakes and Ladders
	Map<Integer,Integer> ladders = Map.ofEntries(
										entry(1,38),
										entry(4,14),
										entry(9,31),
										entry(21,42),
										entry(28,84),
										entry(51,67),
										entry(72,91),
										entry(80,99)
									);
	
	Map<Integer,Integer> snakes = Map.ofEntries(
										entry(17,7),
										entry(54,34),
										entry(62,19),
										entry(64,60),
										entry(87,36),
										entry(93,73),
										entry(95,75),
										entry(98,79)
									);
	
}
