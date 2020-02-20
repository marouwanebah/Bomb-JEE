<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil du jeu Bomberman </title>

<!-- CSS -->
<!-- Bootstrap CSS CDN -->
 <link type="text/css" rel="stylesheet" href="asset/css/style.css" />
  <link rel="stylesheet" href="asset/css/bootstrap.min.css">
</head>
<body>

	<c:import url="StaticFile/tetePage.jsp"></c:import>


	

	<div class="center">
    	<form method="post"   >
        	<fieldset>
        	<legend class="border border-primary bg-primary">Connection </legend>
            	<label for="peusoUser">Nom d'utilisateur </label>
                <br />
                <input type="text" id="nomClient" name="nomClient" value="" size="20" maxlength="20" />
         		<br />
             	<label for="motDePass">Mot de passe </label>
       			<br />
       			<input  type="password" id="motDePass" name="motDePass"  />
 				<br />
 			</fieldset>
     		<input class=" center btn btn-primary" type="submit" value="Valider"  />
   			<br>
			<a href="/Bomberman-JEE/CreationUser">Créer Compte</a>
   			<br />
		</form>
	</div>


	<c:import url="StaticFile/piedPage.jsp"></c:import>
</body>
	
</html>