package com.kp.soi.app.db.entity.clarity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "SAMPLETABLE")
public class SampleTable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_PATTERN_CONFIG_ID")
    private Integer patternId;
	
	@Column(name = "ITM_CORRELATION_ID")
    private String itmCorrelationId;

    @Column(name = "CORRELATION_TYPE")
    private String correlationType;

	public Integer getPatternId() {
		return patternId;
	}

	public void setPatternId(Integer patternId) {
		this.patternId = patternId;
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
