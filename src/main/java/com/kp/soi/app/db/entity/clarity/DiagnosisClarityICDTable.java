package com.kp.soi.app.db.entity.clarity;

import javax.persistence.*;

import com.kp.soi.app.db.entity.clarity.DiagnosisClarityTable.DiagnosisClarityTableBuilder;

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


@Table(name = "HCCLSC.EDG_CURRENT_ICD10")
public class DiagnosisClarityICDTable {
	
	
	// Eg. CODE = S71.111S , S71.142S , S72.032S
	@Column(name = "CODE")
    private String code;

}
