package fr.insat.bemyhelper.controller.implementation;

import fr.insat.bemyhelper.controller.entityManager.RequestManager;
import fr.insat.bemyhelper.model.NeederEntity;
import fr.insat.bemyhelper.model.RequestEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

class RequestImp implements RequestManager {
    private final EntityManager em;
    RequestImp(EntityManager em) {
        this.em = em;
    }
    @Override
    public int addNew(NeederEntity user, String description) {
        return 0;
    }

    @Override
    public List<RequestEntity> listFromUser(NeederEntity user) {
        return null;
    }

    @Override
    public List<RequestEntity> listValided() {
        return null;
    }
}
