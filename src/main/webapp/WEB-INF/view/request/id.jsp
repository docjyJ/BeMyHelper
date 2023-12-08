<%--@elvariable id="userLogged" type="fr.insat.bemyhelper.model.UserEntity"--%>
<%--@elvariable id="item" type="fr.insat.bemyhelper.model.RequestEntity"--%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <jsp:include page="/WEB-INF/libs/bootstrap.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/view/nav.jsp"/>
<div class="container mt-5">
    <c:if test="${ !empty requestScope.errorCode && requestScope.errorCode != 0 }">
        <c:if test="${ requestScope.errorCode == 1 }">
            <div class="alert alert-danger" role="alert">
                Échec de la création de la demande...
            </div>
        </c:if>
        <c:if test="${ requestScope.errorCode == 2 }">
            <div class="alert alert-success" role="alert">
                Demande créée avec succès ! Un opérateur va valider votre demande...
            </div>
        </c:if>
    </c:if>


    <div class="card mb-2">
        <div class="card-body p-5">
            <p><c:out value="Id : ${item.id}"/></p>
            <p><c:out value="Description : ${item.description}"/></p>
            <p><c:out value="Demandeur : ${item.needer.user.fullName} (@${item.neederUserName})"/></p>
            <c:if test="${item.helper != null}">
                <p><c:out value="Aidant : ${item.helper.user.fullName} (@${item.helperUserName})"/></p>
            </c:if>
            <p><jsp:include page="/WEB-INF/view/request/stateView.jsp">
                <jsp:param name="state" value="${item.state}"/>
            </jsp:include></p>
            <c:if test="${userLogged.AHelper}">
                <c:if test="${item.state == 2}">
                    <form>
                        <button class="btn btn-outline-dark" type="submit">Accepté la demande</button>
                    </form>
                </c:if>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>