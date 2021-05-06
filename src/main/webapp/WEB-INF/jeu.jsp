<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Partie</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/style.css">
	<link rel="icon" href="img/icon_EnglishBattle.ico" />
</head>

<body>
	<jsp:include page="entete.jsp" />
	<main>
		<form action="jeu" method="post">
			<h1>Question ${compteur}</h1>
			<p>${verbe.baseVerbale}</p>
			<input type="text" id="preterit" name="PRETERIT" placeHolder="preterit">
			<br>
			<input type="text" id="participePasse" name="PARTICIPEPASSE" placeHolder="participePasse">
			<br>
			<input type="submit" value="Valider" class="btn">
		</form>
	</main>
	
</body>
</html>