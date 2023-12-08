package fr.insat.bemyhelper.controller.entityManager;

import fr.insat.bemyhelper.model.NeederEntity;
import fr.insat.bemyhelper.model.RequestEntity;
import fr.insat.bemyhelper.model.UserEntity;

import java.util.List;

public interface RequestManager {
    void addNew(RequestEntity request);

    List<RequestEntity> listFromUser(NeederEntity user);

    List<RequestEntity> listValidated();

    RequestEntity getId(int id, UserEntity user);

}