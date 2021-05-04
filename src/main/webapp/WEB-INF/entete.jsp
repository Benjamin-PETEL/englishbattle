<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<div id="entete" class="container d-flex">
		<c:if test="${sessionScope.joueur ne null}">
		<img src="img/LogoEnglishBattleHeader.png" width ="180px" alt="English Battle">
		<p>Utilisateur :<span>${sessionScope.joueur.prenom}</span></p>
		<p>meilleur score : <span>${sessionScope.joueur.getMeilleurScore()}</span> verbes </p>
		<a href="deconnexion">Déconnexion</a>
		</c:if>
	</div> 
	