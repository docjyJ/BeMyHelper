<c:choose>
    <c:when test="${ param.state == 'Waiting'}">
        <span class="badge text-bg-warning"><i class="bi bi-clock"></i> Validation en cours</span>
    </c:when>
    <c:when test="${ param.state == 'Refused'}">
        <span class="badge text-bg-danger"><i class="bi bi-exclamation-circle"></i> Refusée</span>
    </c:when>
    <c:when test="${ param.state == 'Valided'}">
        <span class="badge text-bg-success"><i class="bi bi-search-heart"></i> Recherche de bénévole</span>
    </c:when>
    <c:when test="${ param.state == 'Accepted'}">
        <span class="badge text-bg-info"><i class="bi bi-clipboard2-heart"></i> Réalisation en cours</span>
    </c:when>
    <c:when test="${ param.state == 'Done'}">
        <span class="badge text-bg-secondary"><i class="bi bi-check2-square"></i> Tâche effectuée</span>
    </c:when>
</c:choose>