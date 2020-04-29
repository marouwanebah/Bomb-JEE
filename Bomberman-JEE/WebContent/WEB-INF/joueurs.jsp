<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des joueurs</title>
	
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
		<h3>Joueurs de la manche N° ${numeroPartie} </h3>
	</div>
	<div>
		<table class="table">
		 <thead class="thead-gray">
			<tr>
				<th>PSEUDO</th><th>NOM</th><th>PRENOM</th><th>EMAIL</th><th>SCORE</th>
			</tr>
		</thead>
			<c:forEach items="${utilisateurs}" var="user">
				<tr>
					<td>${user._Username}</td>
					<td>${user._nom}</td>
					<td>${user._prenom}</td>
					<td>${user._email}</td>
					<td>${user._score}</td>
				</tr>
			</c:forEach>
		</table>
	
	</div>
	<c:import url="StaticFile/piedPage.jsp" />

</body>
</html>