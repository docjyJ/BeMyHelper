<!DOCTYPE html>
<html lang="fr">
<head>
    <c:url value="/register" var="register"/>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <jsp:include page="/WEB-INF/libs/bootstrap.jsp" />
</head>
<body>
<div class="container mt-5">
    <div class="row d-flex justify-content-center">
        <div class="col-12 col-md-8 col-lg-6">
            <div class="card mb-2">
                <div class="card-body p-5">
                    <h2 class="fw-bold mb-3">BeMyHelper</h2>
                    <p class="mb-4">Entrez votre nom d'utilisateur et votre Mot de passe !</p>
                    <form class="mb-4" method="post">
                        <jsp:include page="/WEB-INF/view/form/user.jsp">
                            <jsp:param name="user" value="${fn:escapeXml(requestScope.userFill)}"/>
                        </jsp:include>
                        <jsp:include page="/WEB-INF/view/form/pass.jsp"/>
                        <div class="d-grid">
                            <button class="btn btn-outline-dark" type="submit">Connexion</button>
                        </div>
                    </form>
                    <div>
                        <p class="mb-0  text-center">Vous n'avez pas de compte ?<br/>
                            <a href="${register}" class="text-primary fw-bold">Créez-vous un compte !</a></p>
                    </div>
                </div>
            </div>
            <c:if test="${ !empty requestScope.errorCode && requestScope.errorCode != 0 }">
                <div class="alert alert-danger" role="alert">
                    <c:if test="${ requestScope.errorCode == 1 }">
                        <c:out value="L'utilisateur '${ requestScope.userFill }' n'existe pas."/><br/>
                        <a href="${register}" class="text-primary fw-bold">Créez-vous un compte !</a>
                    </c:if>
                    <c:if test="${ requestScope.errorCode == 2 }">
                        Mots de passe incorrect.
                    </c:if>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>