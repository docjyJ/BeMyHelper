<div class="mb-3">
    <label for="user" class="form-label ">Nom d'utilisateur</label>
    <div class="input-group">
        <span class="input-group-text" id="basic-addon1">@</span>
        <input type="text" class="form-control" id="user" name="user"
               placeholder="GareSaintLazare" required minlength="4" maxlength="16" pattern="\w*"
               value="${param.user}"/>
    </div>
</div>