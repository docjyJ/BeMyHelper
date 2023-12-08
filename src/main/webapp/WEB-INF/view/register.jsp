<!DOCTYPE html>
<html lang="fr">
<head>
    <c:url value="/login" var="login"/>
    <meta charset="UTF-8">
    <title>Inscription</title>
    <jsp:include page="/WEB-INF/libs/bootstrap.jsp"/>
</head>
<body>
<div class="container mt-5">
    <div class="row d-flex justify-content-center">
        <div class="col-12 col-md-8 col-lg-6">
            <div class="card mb-2">
                <div class="card-body p-5">
                    <h2 class="fw-bold mb-3">BeMyHelper</h2>
                    <p class="mb-4">Créez votre compte !</p>
                    <form class="mb-4" method="post">
                        <jsp:include page="/WEB-INF/view/form/names.jsp">
                            <jsp:param name="first" value="${fn:escapeXml(requestScope.firstFill)}"/>
                            <jsp:param name="last" value="${fn:escapeXml(requestScope.lastFill)}"/>
                        </jsp:include>
                        <jsp:include page="/WEB-INF/view/form/type.jsp">
                            <jsp:param name="type" value="${fn:escapeXml(requestScope.typeFill)}"/>
                        </jsp:include>
                        <jsp:include page="/WEB-INF/view/form/user.jsp">
                            <jsp:param name="user" value="${fn:escapeXml(requestScope.userFill)}"/>
                        </jsp:include>
                        <jsp:include page="/WEB-INF/view/form/pass.jsp"/>
                        <div class="d-grid">
                            <button class="btn btn-outline-dark" type="submit">Créer mon compte</button>
                        </div>
                    </form>
                    <div>
                        <p class="mb-0  text-center">
                            Vous avez déjà un compte ?<br/>
                            <a href="${login}" class="text-primary fw-bold">Connectez-vous !</a>
                        </p>
                    </div>
                </div>
            </div>
            <c:if test="${ !empty requestScope.errorCode && requestScope.errorCode != 0 }">
                <div class="alert alert-danger" role="alert">
                    <c:if test="${ requestScope.errorCode == 1 }">
                        <c:out value="L'utilisateur '${ requestScope.userFill }' existe déjà."/><br/>
                        <a href="${login}" class="text-primary fw-bold">Connectez-vous !</a>
                    </c:if>
                    <c:if test="${ requestScope.errorCode == 2 }">
                        Erreur durant la création du compte.
                    </c:if>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
