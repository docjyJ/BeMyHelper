package fr.insat.bemyhelper.controller.implementation;

import fr.insat.bemyhelper.controller.entityManager.RequestManager;
import fr.insat.bemyhelper.model.NeederEntity;
import fr.insat.bemyhelper.model.RequestEntity;
import fr.insat.bemyhelper.model.UserEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

class RequestImp implements RequestManager {
    private final EntityManager em;
    RequestImp(EntityManager em) {
        this.em = em;
    }
    @Override
    public void addNew(RequestEntity request) {
        em.getTransaction().begin();
        em.merge(request);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public List<RequestEntity> listFromUser(NeederEntity needer) {

        return em.createQuery("FROM RequestEntity r WHERE r.needer = :needer", RequestEntity.class)
                .setParameter("needer", needer)
                .getResultList();
    }

    @Override
    public List<RequestEntity> listValidated() {
        return em.createQuery("FROM RequestEntity r WHERE r.state = :state", RequestEntity.class)
                .setParameter("state", 2)
                .getResultList();
    }

    @Override
    public RequestEntity getId(int id, UserEntity user) {
        RequestEntity a = em.find(RequestEntity.class, id);
        if(a == null) return null;
        if(user.isANeeder()) {
            if(user.getUserName().equals(a.getNeederUserName())) return a;
            else return null;
        }
        if(user.isAHelper()) {
            if(a.getState() == 2 || user.getUserName().equals(a.getHelperUserName())) return a;
            else return null;
        }
        return null;
    }
}
