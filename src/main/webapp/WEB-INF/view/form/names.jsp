<div class="mb-3 row">
    <div class="col">
        <label for="first" class="form-label">Prénom</label>
        <input type="text" class="form-control" placeholder="Garcin" id="first" name="first"
               required minlength="3" maxlength="64" pattern="[A-Za-z-]*" value="${param.first}"/>
    </div>
    <div class="col">
        <label for="last" class="form-label">Nom de famille</label>
        <input type="text" class="form-control" placeholder="Lazare" id="last" name="last"
               required minlength="3" maxlength="64" pattern="[A-Za-z-]*" value="${param.last}"/>
    </div>
</div>