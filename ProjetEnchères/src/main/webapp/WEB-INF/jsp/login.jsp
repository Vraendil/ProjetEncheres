<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI Enchère - Connexion</title>
<link rel="stylesheet" href="styles/stylelogin.css">
<link rel="icon" href="https://capecia-formations.fr/wp-content/uploads/2019/09/LogoENIcertification-print.png" type="image/x-icon">
</head>
<body>
<%@ include file = "navbar.jsp" %>
<section class="main">

<div class="head">

<h2>Connexion</h2>
</div>
 <c:if test="${connexionNecessaire ne null}">
 	<p style="text-color:white;">${connexionNecessaire}</p>
 </c:if>
 <section class="login-form">
      <form class="login" action="<%=request.getContextPath()%>/login" method="POST"> 
      	<c:if test="${lienEnchere ne null and nomVendeur ne null}">
      		<input type ="hidden" name = "lienEnchere" value="${lienEnchere}">
      		<input type ="hidden" name = "nomVendeur" value="${nomVendeur}">
      	</c:if>
        <div class="input-field">
          <label for="email">Email : </label>
          <input class="input" name="email" id="email" placeholder="email" required="required">
        </div>

        <div class="input-field">
          <label for="mdp">Mot de passe : </label>
          <input class="input" name="mdp" id="mdp" type="password" placeholder="Mot De Passe"required>
        </div>
        
        <c:if test="${not empty requestScope.erreur}">
 			<p>${requestScope.erreur}</p>
 		</c:if>
    
        <div>
          <button class="btn-login" type="submit">Connexion</button>
        </div>

        <div>
          <a href ="<%=request.getContextPath() %>/register"><button class="btn-login" type="button"> 
            Créer un compte
          </button></a>
        </div>
        
        <label for="option1">
        	<input type="checkbox" id="saveMail" name="saveMail" value="saveMail"> Se souvenir de moi?
    	</label>
      </form>
    </section>
</section>
</body>
</html>