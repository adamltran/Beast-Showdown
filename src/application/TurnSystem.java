package application;

import java.util.Scanner;

import enums.BeastList;
import enums.Moves;

/*Need to implement:
 *	attack turns according to speed
 *	attack effects at the end of turns
 *	attacks that don't do damage
 *	attacks that skip turns
 *	attack buffs on self for the next specified number of turns
 */
public class TurnSystem {
	
	Scanner scan = new Scanner(System.in);
	
	public TurnSystem() {
	}
	public void turn(Beast b1, Beast b2, DamageSystem ds) {
		
		//TAKE IN USER INPUT HERE
		System.out.print("Enter " + b1.getName() + "'s attack: ");
		String mb1 = scan.nextLine();
		System.out.println();
		
		//TAKE IN USER INPUT HERE
		System.out.print("Enter " + b2.getName() + "'s attack: ");
		String mb2 = scan.nextLine();
		System.out.println();
		
		
		if(b1.getSpeed() > b2.getSpeed()) {
			//take in user input for selected attack
			//take in cpu input for selected attack
			//execute b1's selected attack, followed by b1's selected attack
			ds.attack(b1, b2, isValidAttack(mb1));
			ds.attack(b2, b1, isValidAttack(mb2));
		}
		else {
			ds.attack(b2, b1, isValidAttack(mb2));
			ds.attack(b1, b2, isValidAttack(mb1));
		}
	}
	
	public Moves isValidAttack(String s) {
		switch(s) {
		case "SCRATCH": {
			return Moves.SCRATCH;
			//retrieve b1's attack move, and inflict its affect to b2.
		}
		case "BITE": {
			return Moves.BITE;
		}
		case "HIBERNATE": {
			return Moves.HIBERNATE;
		}
		case "FEAST": {
			return Moves.FEAST;
		}
		default: {
			System.out.println("Invalid input.");
			break;
		}
		}
		return Moves.AMBUSH;
	}
}
