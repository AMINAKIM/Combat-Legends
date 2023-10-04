package beans;

public abstract class Character implements Comparable<Character> {

	private String name;

	private int pv;

	public String getName() {
		return name;
	}

	public Character(String name, int pv) {
		this.name = name;
		if (pv < 0) {
			throw new IllegalStateException("PV < 0");
		}
		this.pv = pv;
	}

	public int getPv() {
		return pv;
	}

	public boolean isAlive() {
		return pv > 0;
	}

	public void takeDamage(int amount) {
		pv -= amount;
	}

	abstract void attack(Character character);

	@Override
	public String toString() {
		return "Character{" + "name='" + name + '\'' + ", pv=" + pv + '}';
	}

	public int compareTo(Character o) {
		return Integer.compare(this.pv, o.pv);
	}
}
