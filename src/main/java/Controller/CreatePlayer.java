package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.GestionJoueurs;
import beans.Knight;
import beans.Player;
import beans.Wizard;
import Controller.*;


/**
 * Servlet implementation class CreatePlayer
 */
@WebServlet("/CreatePlayer")
public class CreatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		new CreatePlayer();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve form data
		HttpSession session = request.getSession();
		String name = session.getId();
		int healthPoints = Integer.parseInt(request.getParameter("hp-input"));
		int magicPoints = 0;
		String playerType = request.getParameter("character");

		try {

			if (playerType.equals("wizard")) {
				magicPoints = Integer.parseInt(request.getParameter("magic-points"));
			}
		} catch (NumberFormatException e) {
			// Handle invalid parameters
			request.setAttribute("errorMessage", "Invalid parameter(s).");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		// Create new player object
		Player player = null;
		if (playerType.equals("knight")) {
			player = new Knight(name, healthPoints);
		} else if (playerType.equals("wizard")) {
			player = new Wizard(name, healthPoints, magicPoints);
		}
		GestionJoueurs.add(player);

		// Store player object and session ID in session
		request.setAttribute("player", player);
		request.setAttribute("sessionId", session.getId());

		// Forward to player info JSP page
		request.getRequestDispatcher("affichage.jsp").forward(request, response);
	}

}
