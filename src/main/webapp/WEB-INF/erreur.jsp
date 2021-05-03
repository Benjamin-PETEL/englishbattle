<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Erreur</title>
</head>
<body>

Une erreur est survenue !!! 
<br>
<br>

<c:if test="${utilisateurNonTrouve ne null}">
	Erreur: ${utilisateurNonTrouve}
</c:if>

<c:if test="${utilisateurNonConnecte ne null}">
	Erreur: ${utilisateurNonConnecte}
</c:if>

<br>
<br>
<a href="index">Retour a l'index</a>

</body>
</html>