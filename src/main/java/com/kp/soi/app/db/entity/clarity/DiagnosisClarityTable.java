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

@Table(name = "HCCLSC.PAT_ENC_DX")
public class DiagnosisClarityTable {
	
	@Id
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
    
    @Column(name = "CONTACT_DATE")
    private String contactDate;
}
