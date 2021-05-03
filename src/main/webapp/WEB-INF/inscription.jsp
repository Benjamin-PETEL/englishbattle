<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscrition Joueur</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <section>
        <header>
        <img src="img/LogoEnglishBattle.png" alt="logo" width="350px">
        <h1>Inscription</h1>
    </header>
        <form action="inscription" method="post">
            <div>
                <label for="nom">Nom</label>
                <input type="text" id="nom" name="NOM" placeHolder="Nom">
            </div>
           <div>
                <label for="prenom">Prenom</label>
                <input type="text" id="prenom" name="PRENOM" placeHolder="Prenom">
            </div>
              <div> 
                <label for="nom">Email</label>
                <input type="text" id="email" name="EMAIL" placeHolder="Email">
            </div>
            <div>
                <label for="nom">Ville</label>
                <select name="ID_VILLE">
           
          <c:forEach var="ville" items="${villes}">
           
                <option value="${ville.idVille }">${ville.nom }</option>

                </c:forEach>
             </select>
            </div>
            <div>
            <label for="nom">Niveau Joueur</label>
            <select name="ID_NIVEAU">  
                  <c:forEach var="niveau" items="${niveaux}">
           
               			 <option value="${niveau.idNiveau }">${niveau.nom }</option>

                </c:forEach> 
     
            </select>
            </div>
            <div>
                <label for="nom">Mot de passe</label>
                <input type="text" id="Mdp" name="MDP" placeHolder="Mdp">
            </div>
            <button class="btn" type="submit">Inscription</button>
        </form>
</section>
</body>
</html>