<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Upload Photo" />
</jsp:include>
	<body>
		<jsp:include page="header.jsp">
			<jsp:param name="title" value="Upload Photo" />
		</jsp:include>
		<main>
            <h3>Wil je nog een foto va jezelf uploaden?</h3>
            <form action="Controller?action=Mensen" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
                <input type="submit" value="upload" />
            </form>
		</main
		<jsp:include page="footer.jsp">
			<jsp:param name="title" value="Upload Photo" />
		</jsp:include>
	</body>
</html>
