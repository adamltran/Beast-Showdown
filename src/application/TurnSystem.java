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

	String mb1;
	String mb2;
	Scanner scan = new Scanner(System.in);

	public TurnSystem() {
	}

	public boolean isValidMove(String s) {
		if(s.compareTo("SCRATCH") == 0 ||
				s.compareTo("FEAST") == 0 ||
				s.compareTo("HAYMAKER") == 0){
			System.out.println("move was valid!");
			return true;
		}
		return false;
	}

	public Moves usesMove(String s) {
		Moves m = null;
		if(isValidMove(s)) {
			System.out.println("inside loopio");
			switch(s) {
			case "SCRATCH": {
				m =  Moves.SCRATCH;
				break;
				//retrieve b1's attack move, and inflict its affect to b2.
			}
			case "FEAST": {
				m = Moves.FEAST;
				break;
			}
			case "HAYMAKER": {
				m = Moves.HAYMAKER;
				break;
			}
			}
		}
		else if(!isValidMove(s)) {
			System.out.println("in usesMove");
			invalidInput(s);
		}

		return m;
	}



	public void turn(Beast b1, Beast b2, DamageSystem ds) {

		//TAKE IN USER INPUT HERE
		System.out.print("Enter " + b1.getName() + "'s attack: ");
		mb1 = scan.nextLine();
		System.out.println();
		if(!isValidMove(mb1)) {
			invalidInput(mb1);
		}

		//TAKE IN USER INPUT HERE
		System.out.print("Enter " + b2.getName() + "'s attack: ");
		mb2 = scan.nextLine();
		System.out.println();
		if(!isValidMove(mb2)) {
			invalidInput(mb2);
		}

		attackOrder(b1, b2, ds);
		
	}

	public void attackOrder(Beast b1, Beast b2, DamageSystem ds) {
		if(b1.getSpeed() > b2.getSpeed()) {
			//take in user input for selected attack
			//take in cpu input for selected attack
			//execute b1's selected attack, followed by b1's selected attack
			ds.attack(b1, b2, usesMove(mb1));
			ds.attack(b2, b1, usesMove(mb2));
		}
		else {
			ds.attack(b2, b1, usesMove(mb2));
			ds.attack(b1, b2, usesMove(mb1));
		}
	}
	
	//only applicable for typing attacks, not for button choosing, so won't matter later...
	public void invalidInput(String s) {
		System.out.println("Invalid input, you entered " + s + ". Please enter a valid attack.");
		s = scan.nextLine();
		if(!isValidMove(mb1)) {
			mb1 = s;
		}
		else {
			mb2 = s;
		}
		usesMove(s);
	}
}
