package application;

import enums.BeastList;

public class Beast {
	protected int maxHp;
	protected int hp; //health of beast
	protected int speed;
	protected String name; //name of beast
	protected String nextAttack;

	public Beast(BeastList bs) {
		switch(bs) {
		case GORILLA: {
			this.maxHp = 100;
			this.hp = this.maxHp;
			this.name = "Gorilla";
			this.speed = 1;
			break;
		}
		case BEAR: {
			this.maxHp = 65;
			this.hp = this.maxHp;
			this.name = "Bear";
			this.speed = 2;
			break;
		}
		case LION: {
			this.maxHp = 50;
			this.hp = this.maxHp;
			this.name = "Lion";
			this.speed = 3;
			break;
		}
		case SNAKE: {
			this.maxHp = 40;
			this.hp = this.maxHp;
			this.name = "Snake";
			this.speed = 4;
			break;
		}
		case EAGLE: {
			this.maxHp = 40;
			this.hp = this.maxHp;
			this.name = "Eagle";
			this.speed = 5;
			break;
		}
		default: {
			System.out.println("Error creating beast...");
		}
		}
	}
	
	public int getmaxHp() {
		return maxHp;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
//	
//	@Override
//	public String toString() {
//		return "Name: "  + "\tHP: " + this.getHp() + "/" + this.getmaxHp();
//	}
	

}
