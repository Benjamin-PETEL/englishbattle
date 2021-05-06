<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
	<title>Merci de votre inscription</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/style.css">
	<link rel="icon" href="img/icon_EnglishBattle.ico" />
</head>


<body>
	<main>
		<h1>Merci pour votre inscription!</h1>
		<div>Nom : ${joueur.nom}  </div>
		<div>Prenom : ${joueur.prenom}  </div>
		<div>Email : ${joueur.email}  </div>
		<div>Ville : ${joueur.ville.nom}  </div>
		<div>Nom : ${joueur.niveau.nom}  </div>
		<form action="jeu" method="post">
			<button class="btn" type="submit">Jouer</button>
		</form>
	</main>

</body>
</html>