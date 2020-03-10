<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Registreer slachtoffer" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Registreer slachtoffer" />
</jsp:include>
<main>
    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li><c:out value="${error}"/></li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form method="post" action="Controller?action=SendForm">
        <p><strong>Velden met een * zijn verplicht</strong></p>
        <p>
            <label for="firstName">Voornaam*</label>
            <input type="text" id="firstName" name="firstName" placeholder="First name">
        </p>
        <p>
            <label for="lastName">Familienaam*</label>
            <input type="text" id="lastName" name="lastName" placeholder="Last name">
        </p>
        <p>
            <label for="gender">Geslacht*</label>
            <select id="gender" name="gender">
                <option name="male">Man</option>
                <option name="female">Vrouw</option>
                <option name="other">Anders</option>
            </select>
        </p>
        <p>
            <label for="geboortedatum">Geboortedatum*</label>
            <input type="date" id="geboortedatum" name="geboortedatum">
        </p>
        <p>
            <label for="geboorteplaats">Geboorteplaats</label>
            <input type="text" id="geboorteplaats" name="geboorteplaats" placeholder="Geboorteplaats">
        </p>
        <p>
            <label for="nationaliteit">Nationaliteit</label>
            <input type="text" id="nationaliteit" name="nationaliteit" placeholder="Belg">
        </p>
        <p>
            <label for="identiteitskaartnummer">Identiteitskaartnummer</label>
            <input type="text" id="identiteitskaartnummer" name="identiteitskaartnummer" placeholder="000-0000000-00">
        </p>
        <p>
            <label for="permission">Rode Kruis Vlaanderen mag deze info openbaar maken voor 7 dagen, zodat anderen kunnen zien dat ik veilig ben*</label>
            <select id="permission" name="permission">
                <option name="ja">Ja</option>
                <option name="nee">Nee</option>
            </select>
        </p>
        <p>
            <input type="submit" id="submitButton" value="Submit">
        </p>
    </form>
</main
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Registreer slachtoffer" />
</jsp:include>
</body>
</html>