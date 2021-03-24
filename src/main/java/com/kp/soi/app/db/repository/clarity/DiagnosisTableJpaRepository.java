package com.kp.soi.app.db.repository.clarity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kp.soi.app.db.entity.demo.DiagnosisTable;


@Repository
public interface DiagnosisTableJpaRepository extends JpaRepository<DiagnosisTable, Integer> {

	
	//@Query(value = "Select s from SampleTable s join SampleTable1 s1 on s1.getID() = s.getID()" join SampleTable2 s2 ON s2.getID()= s.getID() where CLARITY)
	//List<HCCLSC.PAT_ENC_DX> selectQuery();
	
	
}
