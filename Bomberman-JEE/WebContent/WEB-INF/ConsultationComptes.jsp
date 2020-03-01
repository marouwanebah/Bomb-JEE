<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultation des comptes </title>

	<!-- CSS -->
	<!-- Bootstrap CSS CDN -->
 <link type="text/css" rel="stylesheet" href="asset/css/style.css" />
 <link rel="stylesheet" href="asset/css/bootstrap.min.css">
</head>
<body>
	<c:import url="StaticFile/tetePage.jsp" />
	
	
	<div class="text-center">
		<h1>Historique des parties </h1>
	</div>
	
	<div class="container-fluid">
		<div class="row  text-center font-weight-bold">
			<div class="col-md btn btn-outline-danger"> <h3>Joueur </h3></div> 
			<div class="col-md btn btn-outline-danger"> <h3>Defaite</h3> </div> 
			<div class="col-md btn btn-outline-danger"> <h3>Victoire</h3> </div> 
			<div class="col-md btn btn-outline-danger">  <h3>Total </h3></div>
			<div class="col-md btn btn-outline-danger"> <h3>Score</h3></div> 				
		</div>

		<c:forEach var="utilisateur" items="${ utilisateurs }">
			<div class="row text-center  "> 
				<div class="col-md text-center "  ><c:out  value="${ utilisateur._prenom }" /> <c:out value="${ utilisateur._nom }" /> </div> 
				<div class="col-md"> <c:out  value="${ utilisateur.nombre_de_defaite }" />  </div> 
				<div class="col-md">  <c:out  value="${ utilisateur.nombre_de_victoire }" /> </div> 
				<div class="col-md text-danger"> <c:out  value="${ utilisateur.nombre_de_jeu }" /> </div> 
				<div class="col-md text-primary"> <c:out  value="${ utilisateur.nombre_de_victoire-utilisateur.nombre_de_defaite}" />  </div> 
			</div>
		</c:forEach>
  
	</div>
	
	
	
	<c:import url="StaticFile/piedPage.jsp" />
</body>
</html>