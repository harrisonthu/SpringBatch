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

@Table(name = "HCCLSC.CLARITY_EDG")
public class DiagnosisClarityEDGTable {

	@Column(name = "DX_NAME")
    private String dxName;

}
