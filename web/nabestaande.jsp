<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Registreer nabestaande" />
</jsp:include>
	<body>
		<jsp:include page="header.jsp">
			<jsp:param name="title" value="Registreer nabestaande" />
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
			<form method="post" action="Controller?action=SendFormNabestaande">
				<p>
					<label for="firstName">First name</label>
					<input type="text" id="firstName" name="firstName" placeholder="First name">
				</p>
				<p>
					<label for="lastName">Last name</label>
					<input type="text" id="lastName" name="lastName" placeholder="Last name">
				</p>
				<p>
					<label for="gender">Gender</label>
					<select id="gender" name="gender">
						<option name="male">Male</option>
						<option name="female">Female</option>
						<option name="other">Other</option>
					</select>
				</p>
				<p>
					<input type="submit" id="submitButton" value="Submit">
				</p>
			</form>
		</main
		<jsp:include page="footer.jsp">
			<jsp:param name="title" value="Registreer nabestaande" />
		</jsp:include>
	</body>
</html>
