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
<body style="background-image: url(asset/images/bomberman.png);   background-repeat: no-repeat;
  background-attachment: fixed;    " >

	<c:import url="StaticFile/tetePage.jsp"></c:import>
	<c:if test="${ !empty user }">
		<c:out value=" username = ${user.email } passwords = ${user.motDePasse }"></c:out>
	</c:if>
	<div class="text-center">
    	<form method="post"   >
        	<fieldset>
        	
            	<label for="peusoUser">Nom d'utilisateur </label>
                <br />
                <input type="text" id="nomClient" name="nomClient" value="" size="23" maxlength="20" required placeholder="Nom d'utilisateur ou email"/>
         		<br />
             	<label for="motDePass">Mot de passe </label>
       			<br />
       			<input  type="password" id="motDePass" size="23" name="motDePass"  required placeholder="Mot de passe"/>
 				<br />
 			</fieldset>
     		<input class=" center btn btn-info" type="submit" value="Valider"  />
   			<br>
			<a href="/Bomberman-JEE/CreationUser">Créer Compte</a>
   			<br />
		</form>
	</div>


	
</body>
<c:import url="StaticFile/piedPage.jsp"></c:import>
</html>