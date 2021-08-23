package com.snakeandladder;
import java.util.*;
import static java.util.Map.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Snake and Ladder Game");
		
		//new game with initial position 0 is created
		Game g = new Game();
		
		System.out.println("Press Enter to roll the die");
		System.out.println("'STOP' to stop playing");
		Scanner s = new Scanner(System.in);
		//g.position = 100;
		
		while(true) {
			String resp = s.nextLine();
			if(resp.equals("STOP")) {
				System.out.println("Stopping Game\nGame Terminated Successfully");
				break;
			}
			else if ( g.position > 100 ) {
				System.out.println("GG!! You Won");
				System.out.println("Do you want to play again?? Y/N");
				if(s.nextLine().equals("N") || s.nextLine().equals("n")) {
					System.out.println("Stopping Game\nGame Terminated Successfully");
					break;
				}
				else {
					g.position = 0;
				}
			}
			else {
				if(g.noPlayFlag == 0) {
					g.play();
				}
				else {
					System.out.println("You cannot play this turn");
					g.noPlayFlag = 0;
				}
			}
			System.out.println("Press Enter to roll the die again");
			System.out.println("'STOP' to stop playing");
		}
		
	}
	
}

class Game{
	int position = 0;
	int noPlayFlag = 0;
	
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
	
	List<Integer> noPlay = List.of(3,13,25,37,41,61,74,97);
	
	public int rollDie() {
		int numberOnDie = (int)Math.floor(Math.random()*((6-1)+1)+1);
		System.out.println("Die Says: "+numberOnDie);
		return numberOnDie;
	}
	
	public int checkLadder(int pos) {
		
		for(Integer item : ladders.keySet()) {
			if(pos == item) {
				System.out.println("Ladder Hit");
				pos = ladders.get(item);
				return pos;
			}
		}
		
		return 0;
	}
	
	public int checkSnake(int pos) {
		
		for(Integer item : snakes.keySet()) {
			if(pos == item) {
				System.out.println("Snake Hit");
				pos = snakes.get(item);
				return pos;
			}
		}
		
		return 0;
	}
	
	public int checkNoPlay(int pos) {
		
		for(Integer item : noPlay) {
			if(pos == item) {
				System.out.println("No Play");
				noPlayFlag = 1;
				return pos;
			}
		}
		
		return 0;
	}
	
	public void play() {
		
		int dieNumber = rollDie();
		
		int ladderPos = checkLadder(position+dieNumber);
		int snakePos = checkSnake(position+dieNumber);
		int noPlayPos = checkNoPlay(position+dieNumber);
		if( ladderPos > 0) {
			position = ladderPos;
		}
		else if ( snakePos > 0 ){
			position = snakePos;
		}
		else if (noPlayPos > 0){
			position = noPlayPos;				
		}
		else {
			position += dieNumber;
		}
		
		printCurrentPosition();
	
	}
	
	public void printCurrentPosition() {
		System.out.println("Position: "+position);
	}
	
}
