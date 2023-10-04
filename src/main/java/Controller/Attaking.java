package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import beans.Enemy;
import beans.GestionJoueurs;
import beans.Loot;
import beans.Player;

/**
 * Servlet implementation class Attaking
 */
@WebServlet("/Attaking")
public class Attaking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Player> players;
	private Enemy enemy;

	public void init() throws ServletException {
		// Initialize the players and enemy
		enemy = new Enemy("enemy", 50, Loot.POTION);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		players = GestionJoueurs.getArr();

		// Check if enemy is alive and any player is alive
		boolean anyPlayerAlive = hasPlayerAlive(players);

		if (enemy.isAlive() && anyPlayerAlive) {
			// Get attacking player
			Player attackingPlayer = players.stream()
					.filter(user -> user.getName().equals(request.getParameter("playerId"))).reduce((a, b) -> {
						throw new IllegalStateException("Multiple elements: " + a + ", " + b);
					}).get();
			int index = players.indexOf(attackingPlayer);

			// Player attacks enemy
			attackingPlayer.attack(enemy);

			if (enemy.isAlive() && attackingPlayer.isAlive()) {
				// Enemy counter-attacks player
				enemy.attack(attackingPlayer);
			}
			GestionJoueurs.set(attackingPlayer, index);
			request.setAttribute("player", attackingPlayer);
			request.setAttribute("sessionId", request.getSession().getId());
		}
		anyPlayerAlive = hasPlayerAlive(players);
		if (!enemy.isAlive()) {
			request.getRequestDispatcher("win.jsp").forward(request, response);
		} else if (!anyPlayerAlive) {
			request.getRequestDispatcher("lose.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("Results.jsp").forward(request, response);
		}
	}

	private boolean hasPlayerAlive(List<Player> players) {
		boolean anyAlive = false;

		for (Player player : players) {
			if (player.isAlive()) {
				anyAlive = true;
			}
		}

		return anyAlive;
	}
}
