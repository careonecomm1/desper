package com.desper.dao;

import com.desper.core.Action;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class ActionDao extends EntityDao<Action>{

    @Inject
    public ActionDao(SessionFactory factory) {
        super(factory);
    }

    public Optional<Action> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public Action create(Action action) {
        return persist(action);
    }

    public Optional<List<Action>> findActionsBySequence(Long sequenceId) {

        return Optional.ofNullable(list(namedQuery("com.desper.core.Action.findActionsBySequence")));
    }

    public void delete(Action action){
        currentSession().delete(action);
    }
}
