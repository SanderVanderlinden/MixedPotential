<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Mensen" />
</jsp:include>
	<body>
		<jsp:include page="header.jsp">
			<jsp:param name="title" value="Mensen" />
		</jsp:include>
		<main>
            <h3>People</h3>
            <div>
                <form method="post" action="Controller?action=MensenFiltered">
                    <p><strong>Zoek mensen, vul enkel velden in die je zeker weet!</strong></p>
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
                            <option name="">Unk</option>
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
                        <label for="nationaliteit">Nationaliteit</label>
                        <input type="text" id="nationaliteit" name="nationaliteit" placeholder="Belg">
                    </p>
                    <p>
                        <input type="submit" id="submitButton" value="Submit">
                    </p>
                </form>
            </div>
            <h3>People</h3>
			<div id="people">
                <table>
                    <tr>
                        <th>Voornaam</th>
                        <th>Familienaam</th>
                        <th>Geslacht</th>
                        <th>Geboortedatum</th>
                        <th>Nationaliteit</th>
                    </tr>
                <c:forEach items="${people}" var="person">
                    <tr>
                        <td><c:out value="${person.firstName}"/></td>
                        <td><c:out value="${person.lastName}"/></td>
                        <td><c:out value="${person.gender}"/></td>
                        <td><c:out value="${person.geboortedatum}"/></td>
                        <td><c:out value="${person.nationaliteit}"/></td>
                    </tr>
                </c:forEach>
            </table>
            </div>
		</main
		<jsp:include page="footer.jsp">
			<jsp:param name="title" value="Mensen" />
		</jsp:include>
	</body>
</html>
