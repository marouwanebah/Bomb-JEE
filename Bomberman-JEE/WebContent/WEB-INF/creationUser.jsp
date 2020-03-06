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
	
	<div class="container-fluid bandeauCreationCompte">
		<br />
		<h1>Création de votre compte Bomberman</h1>
	</div>
	<div class="container formulaireCreationCompte">
		<form method="post" action="creationCompte">
			<div class="form-row">
			  	<div class="form-group col-md-6">
			    	<label for="pseudo">Nom d'utilisateur</label>
			      	<input type="text" class="form-control" name="pseudo" placeholder="nom d'utilisateur">
			    </div>
			    <div class="form-group col-md-6">
			      	<label for="mdp">Mot de passe</label>
			      	<input type="password" class="form-control" name="passwd" placeholder="mot de passe">
			    </div>
			</div>
			
			<div class="form-row">
			  	<div class="form-group col-md-6">
			    	<label for="nom">Nom</label>
			      	<input type="text" class="form-control" name="nom" placeholder="nom">
			    </div>
			    <div class="form-group col-md-6">
			      	<label for="prenom">Prénom</label>
			      	<input type="text" class="form-control" name="prenom" placeholder="prénom">
			    </div>
			</div>
			  
			<div class="form-group">
			    <label for="email">Addresse e-mail&nbsp;<i class="fas fa-at"></i></label>
			    <input type="text" class="form-control" name="email" placeholder="ex : votrenom@example.com">
			</div>
			
		
			
			<div style="text-align:center;">
		  		<button type="submit" class="btn btn-primary">Créer mon compte &nbsp; <i class="fas fa-plus"></i></button>
		  	</div>
		</form>
	</div>
	
	<c:import url="StaticFile/piedPage.jsp" />

</body>
</html>