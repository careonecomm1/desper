package com.desper.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dsl_sequence_actions")
public class SequenceAction implements com.desper.core.Entity<Long> {
    @Id
    private Long id;
    @Column(name = "sqa_act_id")
    private Long actionId;
    @Column(name = "sqa_seq_id")
    private Long sequenceId;

    public SequenceAction() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public Long getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
    }
}
