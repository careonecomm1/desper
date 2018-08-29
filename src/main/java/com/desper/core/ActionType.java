package com.desper.core;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "dsl_actions_types")
@NamedQueries({
        @NamedQuery(
                name = "com.desper.core.ActionType.findAllActionTypes",
                query = "Select h from ActionType h"
        )
})
public class ActionType implements com.desper.core.Entity<Long> {
    @Id
    private Long id;
    @Column(name = "att_name")
    private String name;
    @Column(name = "att_label")
    private String label;

    public ActionType() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
