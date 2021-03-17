package com.kp.soi.app.db.entity.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MACM.DEMOTABLE")
public class DemoTable {
	
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_PATTERN_CONFIG_ID")
    private Integer eventPatternConfigId;
	
	@Column(name = "ITM_CORRELATION_ID")
    private String itmCorrelationId;

    @Column(name = "CORRELATION_TYPE")
    private String correlationType;

	public Integer getEventPatternConfigId() {
		return eventPatternConfigId;
	}

	public void setEventPatternConfigId(Integer eventPatternConfigId) {
		this.eventPatternConfigId = eventPatternConfigId;
	}

	public String getItmCorrelationId() {
		return itmCorrelationId;
	}

	public void setItmCorrelationId(String itmCorrelationId) {
		this.itmCorrelationId = itmCorrelationId;
	}

	public String getCorrelationType() {
		return correlationType;
	}

	public void setCorrelationType(String correlationType) {
		this.correlationType = correlationType;
	}
	
}