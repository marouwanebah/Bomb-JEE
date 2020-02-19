<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil du jeu Bomberman </title>
 <link type="text/css" rel="stylesheet" href="asset/css/style.css" />
</head>
<body>
	
	<img src="asset/images/bomberman.png" alt="Bomberman Game" width="80" height="110" > 
	<h1>Bomberman Game </h1>
	
	
	<div class="center">
    	<form method="post" >
        	<fieldset>
        	<legend>connection </legend>
            	<label for="peusoUser">Pseudo </label>
                <br />
                <input type="text" id="nomClient" name="nomClient" value="" size="20" maxlength="20" />
         		<br />
             	<label for="motDePass">Mot de passe </label>
       			<br />
       			<input type="password" id="motDePass" name="motDePass"  />
 				<br />
 			</fieldset>
     		<input type="submit" value="Valider"  />
   			
			<a href="url">Créer Compte</a>
   			<br />
		</form>
	</div>

</body>
</html>