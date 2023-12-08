<%--@elvariable id="userLogged" type="fr.insat.bemyhelper.model.UserEntity"--%>
<%--@elvariable id="requestsList" type="java.util.List<fr.insat.bemyhelper.model.RequestEntity>"--%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <c:url value="/request" var="request"/>
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


    <c:if test="${userLogged.ANeeder}">
        <div class="card mb-2">
            <div class="card-body p-5">
                <h2 class="fw-bold mb-3">Nouvelle demande</h2>
                <p class="mb-4">Expliquer votre demande en quelque mots</p>
                <form class="mb-4" method="post" action="request">
                    <div class="mb-3">
                        <div class="input-group">
                            <span class="input-group-text">Description</span>
                            <textarea class="form-control" aria-label="With textarea" name="description" required
                                      maxlength="255"></textarea>
                        </div>
                    </div>
                    <div class="d-grid">
                        <button class="btn btn-outline-dark" type="submit">Envoyé ma demande</button>
                    </div>
                </form>
            </div>
        </div>
    </c:if>
    <div class="card mb-2">
        <div class="card-body p-5">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Demandeur</th>
                        <th scope="col">Statue</th>
                        <th scope="col">Description</th>
                        <th scope="col">#</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ requestsList }" var="item" varStatus="status">
                        <tr>
                            <td>@<c:out value="${item.neederUserName} ${item.needer.user.fullName}"/></td>
                            <td><jsp:include page="/WEB-INF/view/request/stateView.jsp">
                                <jsp:param name="state" value="${item.state}"/>
                            </jsp:include></td>
                            <td><p><c:out value="${item.description}"/></p></td>
                            <th><a class="btn btn-outline-primary" href="${request}/${item.id}" role="button">Link</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>