package beans;

import java.util.ArrayList;
import java.util.List;

public class GestionJoueurs {
	static List<Player> arr = new ArrayList<>();

	public GestionJoueurs() {
		// TODO Auto-generated constructor stub
	}

	public static void set(Player player, int i) {
		arr.set(i, player);
	}

	public static void add(Player player) {
		arr.add(player);
	}

	public static List<Player> getArr() {
		return arr;
	}
}