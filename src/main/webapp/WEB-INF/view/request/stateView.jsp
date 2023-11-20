<c:choose>
    <c:when test="${ param.state == 0}">
        <span class="badge text-bg-warning"><i class="bi bi-clock"></i> Validation en cours</span>
    </c:when>
    <c:when test="${ param.state == 1}">
        <span class="badge text-bg-danger"><i class="bi bi-exclamation-circle"></i> Refusée</span>
    </c:when>
    <c:when test="${ param.state == 2}">
        <span class="badge text-bg-success"><i class="bi bi-search-heart"></i> Recherche de bénévole</span>
    </c:when>
    <c:when test="${ param.state == 3}">
        <span class="badge text-bg-info"><i class="bi bi-clipboard2-heart"></i> Réalisation en cours</span>
    </c:when>
    <c:when test="${ param.state == 4}">
        <span class="badge text-bg-secondary"><i class="bi bi-check2-square"></i> Tâche effectuée</span>
    </c:when>
</c:choose>