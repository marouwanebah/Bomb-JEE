<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des utilisateurs</title>
	
	<!-- CSS -->
	<!-- Bootstrap CSS CDN -->
 	<link type="text/css" rel="stylesheet" href="asset/css/style.css" />
	<link rel="stylesheet" href="asset/css/bootstrap.min.css">
	 <script type="text/javascript">
 	function confirmer(url){
 		var rep=confirm("Etes vous sûr de vouloir supprimer?");
 		if(rep==true){
 			document.location=url;
 		}
 	}
 </script>
</head>
<body>
	<c:import url="StaticFile/tetePage.jsp" />
	
	<c:out value=""></c:out>
	<div class="center">
		<br />
		<h1>Utilisateurs </h1>
	</div>
	<div>
		<table class="table">
		 <thead class="thead-gray">
			<tr>
				<th>PSEUDO</th><th>NOM</th><th>PRENOM</th><th>EMAIL</th><th>DATE CREATION</th><th>VICTOIRES</th><th>DEFAITES</th><th colspan="2">ACTION</th>
			</tr>
		</thead>
			<c:forEach items="${utilisateurs}" var="user">
				<tr>
					<td>${user._Username}</td>
					<td>${user._nom}</td>
					<td>${user._prenom}</td>
					<td>${user._email}</td>
					<td>${user._dateCreation}</td>
					<td align="right">${user._nbreVictoires}</td>
					<td align="right">${user._nbreDefaites}</td>
					<c:if test="${sessionScope.sessionUtilisateur._role=='admin'}">
						<td><a href="javascript:confirmer('User?action=delete&pseudo=${user._Username }')">Supprimer</a></td>
						<td><a href="User?action=edit&mode=edit&pseudo=${user._Username }">Editer</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	
	</div>
	<c:import url="StaticFile/piedPage.jsp" />

</body>
</html>