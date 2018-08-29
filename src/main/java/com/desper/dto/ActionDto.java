package com.desper.dto;

public class ActionDto implements Identifiable {
    private Long id;
    private Long actionTypeId;
    private String name;
    private String description;
    private String associatedElement;

    public ActionDto() {
    }

    public ActionDto(Long id, Long actionTypeId, String name, String description, String associatedElement) {
        this.id = id;
        this.actionTypeId = actionTypeId;
        this.name = name;
        this.description = description;
        this.associatedElement = associatedElement;
    }

    public Long getId() {
        return id;
    }

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

    public void setAssociatedElement(String asociatedElement) {
        this.associatedElement = asociatedElement;
    }
}
