<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${sessionScope.joueur eq null }">
		<a href="inscription">Inscription</a>
		<br>
		<a href="index">Connexion</a>
		<br>
	</c:when>
	<c:when test="${sessionScope.joueur ne null }">
		<a href="deconnexion">Deconnexion</a>
	</c:when>
</c:choose>