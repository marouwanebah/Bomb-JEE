	<nav class="navbar navbar-dark bg-success">
  		<a class="navbar-brand" href="Accueil">
    		<img src="asset/images/bomberman.png" alt="Bomberman Game" width="70" height="70"  class="d-inline-block align-top" >
  		</a>
  			<h1 class="text-light"> Bomberman Game  </h1> 
   		<a class="navbar-brand" href="#">
    		<img src="asset/images/univLogo.png" alt="univ angers" width="75" height="70"  class="d-inline-block align-left" >	
  		</a>
	</nav>
	<div class="navbar navbar-dark bg-dark">
	  <div class="row">
	    <div class="col-sm">  <a class="text-light" href="Accueil">Accueil</a>   </div>
	    <div class="col-sm">  <a class="text-light" href="Users?action=users">Utilisateur</a>  </div>
	    <div class="col-sm">  <a class="text-light" href="Partie?action=parties">Historique</a>   </div>
	    <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <div class="col-sm">  <a align="right" class="text-light" href="Deconnexion">Deconnexion</a>   </div>
        </c:if>
	  </div>
	</div>
	<br>
	