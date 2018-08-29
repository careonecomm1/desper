package com.desper.dao;

import com.desper.core.ActionType;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class ActionTypeDao extends EntityDao<ActionType>{

    @Inject
    public ActionTypeDao(SessionFactory factory) {
        super(factory);
    }

    public Optional<ActionType> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public ActionType create(ActionType actionType) {
        return persist(actionType);
    }

    public Optional<List<ActionType>> findAllActionTypes() {

        return Optional.ofNullable(list(namedQuery("com.desper.core.ActionType.findAllActionTypes")));
    }
}
