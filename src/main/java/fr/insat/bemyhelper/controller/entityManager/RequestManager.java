package fr.insat.bemyhelper.controller.entityManager;

import fr.insat.bemyhelper.model.NeederEntity;
import fr.insat.bemyhelper.model.RequestEntity;

import java.util.List;

public interface RequestManager {
    int addNew(RequestEntity request);

    List<RequestEntity> listFromUser(NeederEntity user);

    List<RequestEntity> listValided();

}