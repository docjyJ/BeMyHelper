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
    <c:if test="${sessionScope.userLogged.type == 'Needer'}">
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
</div>
</body>
</html>