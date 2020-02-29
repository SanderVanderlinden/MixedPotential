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
			<div id="people">
                <table>
                    <tr>
                        <th>Voornaam</th>
                        <th>Familienaam</th>
                        <th>Geslacht</th>
                        <th>Status</th>
                    </tr>
                <c:forEach items="${people}" var="person">
                    <tr>
                        <td><c:out value="${person.firstName}"/></td>
                        <td><c:out value="${person.lastName}"/></td>
                        <td><c:out value="${person.gender}"/></td>
                        <td><c:out value="${person.role}"/></td>
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
