<div class="mb-3">
    <label for="type" class="form-label">Type</label>
    <select class="form-select" id="type" name="type" required>
        <option ${param.type != 'Needer' && param.type != 'Helper' && param.type != 'Valider' ? 'selected' : ''}
                value="">Choisir votre type...</option>
        <option ${param.type == 'Needer' ? 'selected' : ''} value="Needer">Demandeur d'aide</option>
        <option ${param.type == 'Helper' ? 'selected' : ''} value="Helper">Bénévole</option>
        <option ${param.type == 'Valider' ? 'selected' : ''} value="Valider">Administrateur</option>
    </select>
</div>