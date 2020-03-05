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
		<c:if test="${mode=='ajout' }">
			<h1>Création Compte </h1>
		</c:if>
		<c:if test="${mode=='edit' }">
			<h1>Modification Compte </h1>
		</c:if>
	</div>
	<div class="container formulaireCreationCompte">
		<form action="User" method="post">
			<div class="form-row">
				<input type="hidden" value="${mode}" name="mode">
			  		<c:if test="${mode=='ajout' }">
					  	<div class="form-group col-md-6">
					    	<label for="pseudo">Nom d'utilisateur</label>
					      	<input type="text" class="form-control" name="pseudo" placeholder="Nom d'utilisateur" value="${user._Username}" required>
					    </div>
					</c:if>
					<c:if test="${mode=='edit' }">
					  	<div class="form-group col-md-6">
					    	<label for="pseudo">Nom d'utilisateur</label>
					      	<b>${user._Username}</b><input type="hidden" class="form-control" name="pseudo" placeholder="Nom d'utilisateur" value="${user._Username}" required>
					    </div>
					</c:if>
			    <div class="form-group col-md-6">
			      	<label for="mdp">Mot de passe</label>
			      	<input type="password" class="form-control" name="motDePasse" placeholder="Mot de passe" value="${user._motDePasse}" required>
			    </div>
			</div>
			
			<div class="form-row">
			  	<div class="form-group col-md-6">
			    	<label for="nom">Nom</label>
			      	<input type="text" class="form-control" name="nom" placeholder="Nom" value="${user._nom}" required>
			    </div>
			    <div class="form-group col-md-6">
			      	<label for="prenom">Prénom</label>
			      	<input type="text" class="form-control" name="prenom" placeholder="Prénom" value="${user._prenom}" required>
			    </div>
			</div>
			  
			<div class="form-group">
			    <label for="email">Adresse e-mail&nbsp;<i class="fas fa-at"></i></label>
			    <input type="text" class="form-control" name="email" placeholder="ex : votrenom@example.com" value="${user._email}" required>
			</div>
			
		
			
			<div style="text-align:center;">
		  		<input type="submit" name="action" value="Enregistrer" class="btn btn-dark">
		  	</div>
		</form>
	</div>
	<div>
		
	</div>
	<c:import url="StaticFile/piedPage.jsp" />

</body>
</html>