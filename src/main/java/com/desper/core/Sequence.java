package com.desper.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dsl_sequences")
public class Sequence implements com.desper.core.Entity<Long> {
    @Id
    private Long id;
    @Column(name = "seq_cpn_id")
    private Long campaignId;
    @Column(name = "seq_order_day")
    private Long orderDay;

    public Sequence() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public Long getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(Long orderDay) {
        this.orderDay = orderDay;
    }
}
