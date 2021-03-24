package com.kp.soi.app.db.entity.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;



@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MA__SOR_DIAGNOIS_MOCK")
public class DiagnosisTable {
	
	
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAT_ID")
    private Integer padId;

	@Column(name = "PAT_ENC_CSN_ID")
    private Integer padEncCsnId;

    @Column(name = "DX_ID")
    private Integer dxId;
    
    @Column(name = "PRIMARY_DX_YN")
    private String primaryDxYn;
    
    @Column(name = "DX_CHRONIC_YN")
    private String dxChronicYn;
    
	// Eg. CODE = S71.111S , S71.142S , S72.032S
	@Column(name = "CODE")
    private String code;

	@Column(name = "DX_NAME")
    private String dxName;
	
    @Column(name = "CONTACT_DATE")
    private String contactDate;
	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
}
