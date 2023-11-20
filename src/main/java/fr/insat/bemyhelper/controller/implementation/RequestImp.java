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
    public int addNew(RequestEntity request) {
        em.getTransaction().begin();
        em.merge(request);
        em.flush();
        em.getTransaction().commit();
        return 1;
    }

    @Override
    public List<RequestEntity> listFromUser(NeederEntity needer) {
        return em.createQuery("FROM RequestEntity r WHERE r.needer = :needer", RequestEntity.class)
                .setParameter("needer", needer)
                .getResultList();
    }

    @Override
    public List<RequestEntity> listValided() {
        return em.createQuery("FROM RequestEntity r WHERE r.state = :state", RequestEntity.class)
                .setParameter("state", 2)
                .getResultList();
    }
}
