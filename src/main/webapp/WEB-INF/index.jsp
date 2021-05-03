<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>English Battle</title>
</head>
<body>
    <h1>Bienvenue sur English Battle !</h1>
    <form action="login" method="POST" >
        <div>
            <label for="email">Email</label>
            <input name ="email" type="email">
        </div>
        <div>
            <label for="mdp">Mot de passe</label>
            <input type="text" name="mdp">
        </div>
        <input type="submit">        

    </form>
    <a href="inscription">Inscription</a>
    <h2>Hall of Fame</h2>

</body>
</html>