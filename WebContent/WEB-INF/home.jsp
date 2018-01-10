<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Library</title>
</head>
<body>
    <form method="post" action="home">
        <p>
            <label for="firstname">Nom : </label>
            <input type="text" name="firstname" id="firstname" />
        </p>
        <p>
            <label for="lastname">Prénom : </label>
            <input type="text" name="lastname" id="lastname" />
        </p>
        <p>
            <label for="native_country">Pays: </label>
            <input type="text" name="native_country" id="native_country" />
        </p>
        
        <input type="submit"  value="Ajouter"/>
    </form>
        <c:forEach var="author" items="${ authors }">
            <li><c:out value="${ author.firstname }" /> <c:out value="${ author.lastname }" /> <c:out value="${ author.nativeCountry }" />  </li>
        </c:forEach>
     
</body>
</html>