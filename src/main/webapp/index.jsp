<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Game Website</title>
<link rel="stylesheet" href="style.css">
<script src="script.js"></script>
</head>
<body
	style="background-image: url('forrest.jpg'); background-size: cover; background-position: center center;">
	<header style="text-align: center;">
		<h1>Jeux Java EE</h1>
	</header>
	<main>
		<section class="choose-character"
			style="border-radius: 8px; backdrop-filter: blur(20px); background-color: rgba(255, 255, 255, 0.5); box-shadow: 0 1px 12px rgba(0, 0, 0, 0.25); border: 1px solid rgba(255, 255, 255, 0.3);">

			<h2>Choose your character</h2>
			<form id="character-form" action="CreatePlayer" method="post">
				<label for="character-select">Select a character:</label>
				 <select
					id="character-select" name="character">
					<option value="knight">Knight</option>
					<option value="wizard">Wizard</option>
				</select>
				<div>
					<label>Enter your magic points:</label> <input name="hp-input"
						type="number" value="100">
				</div>
				<div id="magic-points-container" class="hidden">
					<label for="magic-points-input">Enter your magic points:</label> <input
						id="magic-points-input" type="number" name="magic-points" min="1"
						value="5">
				</div>
				<button type="submit">Start Game</button>
			</form>
		</section>
	</main>
	<footer>
		<p> &copy; 2023 Nizar BENALLA. All rights reserved.</p>
	</footer>


</body>
</html>
