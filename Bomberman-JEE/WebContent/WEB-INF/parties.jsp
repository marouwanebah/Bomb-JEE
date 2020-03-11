<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Historique des parties</title>
	
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
		<h2>Historique des parties </h2>
	</div>
	<div>
		<table class="table">
		 <thead class="thead-gray">
			<tr>
				<th>MANCHE N°</th><th>DATE CREATION</th><th>GAGNANT</th><th>ETAT</th><th>LEVEL</th><th>DATE DEBUT</th><th>DATE FIN</th><th>ACTION</th>
			</tr>
		</thead>
			<c:forEach items="${parties}" var="partie">
				<tr>
					<td>${partie._numeroPartie}</td>
					<td>${partie._dateCreationPartie}</td>
					<td>${partie._gagnantPartie}</td>
					<td>${partie._etatPartie._libelleEtatPartie}</td>
					<td>${partie._levelPartie._libelleLevelPartie}</td>
					<td>${partie._dateDebutPartie}</td>
					<td>${partie._dateFinPartie}</td>
					<td><a href="Partie?action=joueurs&numeroPartie=${partie._numeroPartie }">Joueurs</a></td>
				</tr>
			</c:forEach>
		</table>
	
	</div>
	<c:import url="StaticFile/piedPage.jsp" />

</body>
</html>