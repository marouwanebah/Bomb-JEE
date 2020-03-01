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
<body style="background-image: url(asset/images/bomberman.png);   background-repeat: no-repeat;" >
	<c:import url="StaticFile/tetePage.jsp"></c:import>
	<c:if test="${!empty user }">
		<c:out value=" username = ${user.email } passwords = ${user.motDePasse }"></c:out>
	</c:if>
	
	<div class="container-fluid ">
		<div class="row">
			<div class="col-sm justify-content" >
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				<h1> Bienvenue au jeu <br>
					   Bomberman
				</h1>
			</div>
			<div class="col-sm  ">
				<form method="post"   >

		            <input type="text" id="nomClient" name="nomClient" value="" size="20" maxlength="20" required placeholder="Nom d'utilisateur ou email"/>
	
		       		<input  type="password" id="motDePass" size="18" name="motDePass"  required placeholder="Mot de passe"/>
		 	
		     		<input class="text-center" type="submit" value="Valider"  />
		     		
					<a href="/Bomberman-JEE/CreationUser">Créer Compte</a>
		   			<br />
				</form>
				
				<br><br><br><br> <img alt="bomberman" class="img-fluid" src="asset/images/Capture.png" >
			</div>
		</div>
	</div>
	<c:import url="StaticFile/piedPage.jsp"></c:import>
</body>

</html>