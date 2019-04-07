package application;

import enums.Moves;

public class DamageSystem {
	private int damage;
	private int heal;
	private int turnDuration;
	private int blindStack;
	private double buff;
	private double accuracy;
	private double chance;
	private String description;
	private boolean hit = false;
	private boolean asleep = false;
	private boolean depleted = false;
	private boolean dots = false;
	public Beast[] beastPrintOrder = new Beast[2];

	public DamageSystem(Beast b1, Beast b2) {
		this.beastPrintOrder[0] = b1;
		this.beastPrintOrder[1] = b2;

	}

	public void attack(Beast b1, Beast b2, Moves m) {

		switch(m) {

		case SCRATCH: {
			damage = 10;
			accuracy = .9;
			description = "Uses claws to scratch the opponent.";
			break;
			//retrieve b1's attack move, and inflict its affect to b2.

		}
		case BITE: {
			damage = 15;
			heal = 5;
			accuracy = .8;
			description = "Bites the opponent to recover 5 hp.";
			break;

		}
		case HIBERNATE: {
			damage = 0;
			heal = 20;
			accuracy = 1;
			asleep = true;
			description = "Goes to sleep to heal 20 hp. Asleep for next turn.";
			break;
		}
		case ROAR: {
			damage = 0;
			accuracy = 1;
			buff = .3;
			turnDuration = 1;
			description = "Releases an intimidating roar. Buffs damage of your next attack by 30% for the next turn.";
			break;
		}
		case JAB: {
			damage = 10;
			accuracy = .9;
			description = "Throws a quick jab to damage the opponent.";
			break;
		}
		case FEAST: {
			damage = 0;
			heal = b1.getmaxHp() - b1.getHp();
			accuracy = 1;
			depleted = true;
			description = "Devours secret sauce. Recovers hp back to max. Usable only once.";
			break;
		}
		case HAYMAKER: {
			damage = 15;
			accuracy = .65;
			description = "Wildly swings to attack the opponent.";
			break;
		}
		case RAGE: {
			damage = 0;
			accuracy = 1;
			buff = .3;
			turnDuration = 2;
			description = "Becomes overwhelmed with blistering fury. "
					+ "	Reduces incoming damage taken by 30 percent for the next two turns.";
			break;
		}
		case MAUL: {
			damage = 25;
			accuracy = .65;
			description = "Ferociously lacerates the opponent.";
			break;
		}
		case AMBUSH: {
			damage = 10;
			accuracy = 1;
			chance = .4;
			description = "Stealthily ambushes the opponent. Has a 40 percent chance to cause the opponent to lose a turn.";
			break;
		}
		case POISON_FANG: {
			damage = 5;
			accuracy = .8;
			chance = .7;
			dots = true;
			description = "Sinks fangs into the opponent. Has a 70 percent chance to poison the opponent (poison deals 5 damage at the end of every turn).";
			break;
		}
		case CONSTRICT: {
			damage = 5;
			accuracy = .8;
			dots = true;
			description = "Tightly binds the opponent (Causes constriction damage at the end of every turn).";
			break;
		}
		case BLIND: {
			damage = 0;
			accuracy = .4;
			description = "Blinds the opponent. Reduces the accuracy of the opponent by 20 percent the first time. "
					+ "Reduces the accuracy of the opponent by 15 percent the second time. "
					+ "This ability can only stack twice.";
			break;
		}
		case LEECH: {
			damage = 5;
			accuracy = .9;
			description = "Sucks the life out of the opponent. Recovers 5 hp.";
			break;
		}
		case PECK: {
			damage = 5;
			accuracy = .85;
			chance = .5;
			description = "Pecks the opponent in the eyes. Chance to reduce the opponent's accuracy by 7 percent.";
			break;
		}
		case LOCK_ON: {
			damage = 0;
			accuracy = 1;
			description = "Focuses intensely to increase the damage of your next attack by 30 percent.";
			break;
		}
		case SKYDIVE: {
			damage = 12;
			accuracy = .8;
			description = "Flies high in the sky. Becomes untargetable for this turn. Attacks on the next turn.";
			break;
		}
		case SLASH: {
			damage = 7;
			accuracy = .8;
			description = "Savagely tears into the opponent's flesh.";
			break;
		}
		default: {
			System.out.println("No damage inflicted.");
			break;
		}

		}
		System.out.println(b1.getName() + " used " + m + "!");
		if(Math.random()*100 > accuracy) {
			//used for number of stacks for blind effect
			if(m == Moves.BLIND) {
				blindStack++;
			}

			//Inflict damage
			if(b2.getHp() - damage < 0) {
				b2.setHp(0);
			}
			else {
				b2.setHp(b2.getHp() - damage);
			}

			//Prevents showing damage when dealing no damage
			if(m == Moves.HIBERNATE || m == Moves.FEAST || m == Moves.LOCK_ON || m == Moves.ROAR || m == Moves.RAGE) {
			}
			else {
				System.out.println(b2.getName() + " took " + damage + " damage!");
			}

			//prevents healing over max hp
			if(heal > 0) {
				//				System.out.println("Heal amount: " + heal);
				//				System.out.println(b1.getName() + " max hp: " + b1.getmaxHp());
				//				System.out.println(b2.getName() + " max hp: " + b2.getmaxHp());
				if(b1.getHp() <= b1.maxHp) {
					if(b1.getHp() + heal >= b1.maxHp) {
						int overheal = (b1.getHp() + heal) % b1.maxHp;
						System.out.println(b1.getName() + " healed " + (heal - overheal) + " hp!");
						b1.setHp(b1.getHp() + (heal - overheal));
						heal = 0;
					}
					else {
						System.out.println(b1.getName() + " healed " + heal + " hp!");
						b1.setHp(b1.getHp() + heal);
						heal = 0;
					}
				}
				else {
					System.out.println("Already at max hp!");
				}
			}

			for(int i = 0; i < beastPrintOrder.length; i++) {
				System.out.println("Name: " + beastPrintOrder[i].getName() + 
						"\tHP: " + beastPrintOrder[i].getHp() + 
						"/" + 
						beastPrintOrder[i].getmaxHp());

			}

			System.out.println();
		}
		else {
			System.out.println("Attack missed!");
		}


	}
}
