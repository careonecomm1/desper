package com.desper.core;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "dsl_actions")
public class Action implements com.desper.core.Entity<Long> {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "act_att_id")
    private Long actionTypeId;
    @Column(name = "act_name")
    private String name;
    @Column(name = "act_description")
    private String description;
    @Column(name = "act_associated_element")
    private String associatedElement;

    public Action() {
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

    public Long getActionTypeId() {
        return actionTypeId;
    }

    public void setActionTypeId(Long actionTypeId) {
        this.actionTypeId = actionTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssociatedElement() {
        return associatedElement;
    }

    public void setAssociatedElement(String associatedElement) {
        this.associatedElement = associatedElement;
    }
}
