<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Bienvenue</title>
    <jsp:include page="/WEB-INF/libs/bootstrap.jsp" />
</head>
<body>
<jsp:include page="/WEB-INF/view/nav.jsp"/>
<div class="container mt-5">
    <div class="row d-flex justify-content-center">
        <div class="col-12 col-md-8 col-lg-6">
            <div class="card mb-2">
                <div class="card-body p-5">
                    <h2 class="fw-bold mb-3">BeMyHelper</h2>
                    <p class="mb-4">Vous êtes ${ sessionScope.userLogged.firstName } ${ sessionScope.userLogged.lastName } !</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>