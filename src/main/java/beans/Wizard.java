package beans;

public class Wizard extends Player {

	private int mp;

	public int getMp() {
		return mp;
	}

	public Wizard(String name, int pv, int mp) {
		super(name, pv);
		this.mp = mp;
	}

	public void attack(Character character) {
		if (mp > 10) {
			super.attack(character);
			this.mp -= 10;
		}
	}

	@Override
	public String toString() {
		return "Wizard{" + "mp=" + mp + "} " + super.toString();
	}
}
