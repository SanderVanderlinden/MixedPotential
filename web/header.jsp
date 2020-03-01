<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
    <img alt="Books" src="images/banner.jpg">
    <h1><span>Registreer en stel je naasten gerust!</span></h1>
    <nav>
        <ul>
            <c:choose>
                <c:when test="${param.title=='Registreer slachtoffer'}">
                    <li id="actual"><a class="actuala" href="Controller">Slachtoffer</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="Controller">Slachtoffer</a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${param.title=='Registreer nabestaande'}">
                    <li id="actual"><a class="actuala" href="Controller?action=Nabestaande">Nabestaande</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="Controller?action=Nabestaande">Nabestaande</a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${param.title=='Mensen'}">
                    <li id="actual"><a class="actuala" href="Controller?action=Mensen">Mensen</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="Controller?action=Mensen">Mensen</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
    <h2>
        ${param.title}
    </h2>

</header>