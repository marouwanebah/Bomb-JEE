<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Creation Utilisateur</title>
	
	<!-- CSS -->
	<!-- Bootstrap CSS CDN -->
 	<link type="text/css" rel="stylesheet" href="asset/css/style.css" />
	<link rel="stylesheet" href="asset/css/bootstrap.min.css">
</head>
<body>
	<c:import url="StaticFile/tetePage.jsp" />
	
	<c:out value=""></c:out>
	<div class="center">
		<br />
		<h1>Création Compte </h1>
	</div>
	<c:out value="${user }"></c:out>
	<div class="container formulaireCreationCompte">
		<form method="post">
			<div class="form-row">
			  	<div class="form-group col-md-6">
			    	<label for="pseudo">Nom d'utilisateur</label>
			      	<input type="text" class="form-control" name="pseudo" placeholder="Nom d'utilisateur" required>
			    </div>
			    <div class="form-group col-md-6">
			      	<label for="mdp">Mot de passe</label>
			      	<input type="password" class="form-control" name="motDePasse" placeholder="Mot de passe" required>
			    </div>
			</div>
			
			<div class="form-row">
			  	<div class="form-group col-md-6">
			    	<label for="nom">Nom</label>
			      	<input type="text" class="form-control" name="nom" placeholder="Nom" required>
			    </div>
			    <div class="form-group col-md-6">
			      	<label for="prenom">Prénom</label>
			      	<input type="text" class="form-control" name="prenom" placeholder="Prénom" required>
			    </div>
			</div>
			  
			<div class="form-group">
			    <label for="email">Adresse e-mail&nbsp;<i class="fas fa-at"></i></label>
			    <input type="text" class="form-control" name="email" placeholder="ex : votrenom@example.com" required>
			</div>
			
		
			
			<div style="text-align:center;">
		  		<button type="submit" class="btn btn-dark">Créer mon compte &nbsp; <i class="fas fa-plus"></i></button>
		  	</div>
		</form>
	</div>

	<c:import url="StaticFile/piedPage.jsp" />

</body>
</html>