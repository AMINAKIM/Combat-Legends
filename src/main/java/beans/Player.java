package beans;

public abstract class Player extends Character {

	private int experience;

	public Player(String name, int pv) {
		super(name, pv);
	}

	public void attack(Character character) {
		character.takeDamage(10);
		this.experience += 10;
	}

	@Override
	public String toString() {
		return "Player{" + "experience=" + experience + "} " + super.toString();
	}
}
