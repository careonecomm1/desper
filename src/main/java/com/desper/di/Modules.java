package com.desper.di;

import com.desper.controller.ActionTypeController;
import com.desper.resources.ActionTypeResource;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.hibernate.SessionFactory;

public class Modules extends AbstractModule {

    private final SessionFactory sessionFactory;

    public Modules(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected void configure() {
        // instances
        bind(SessionFactory.class).toInstance(this.sessionFactory);

        //sevices
        bind(ActionTypeController.class).in(Singleton.class);
        bind(ActionTypeResource.class).in(Singleton.class);
    }
}
