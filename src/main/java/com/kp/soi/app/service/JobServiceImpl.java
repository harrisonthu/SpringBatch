package com.kp.soi.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kp.soi.app.db.entity.clarity.SampleTable;
import com.kp.soi.app.db.entity.demo.DemoTable;
import com.kp.soi.app.db.repository.clarity.SampleTableJpaRepository;
import com.kp.soi.app.db.repository.demo.DemoTableJpaRepository;

@Service
public class JobServiceImpl {

	@Autowired 
	SampleTableJpaRepository sampleTableJpaRepository;
	
	@Autowired
	DemoTableJpaRepository demoTableJpaRepository;
	
	public List<SampleTable> findAllSampleTableList() {
		return sampleTableJpaRepository.findAll();
	}
	
	
	public List<DemoTable> findAllDemoTableList() {
		return demoTableJpaRepository.findAll();
	}
	
	@Transactional(transactionManager = "demoJpaTransactionManager", readOnly = false)
	public List<DemoTable> upsert(List<DemoTable> demoTableList ) {
		Map<Integer, DemoTable> demoTableMap = demoTableList.stream().collect(Collectors.toMap(a->a.getEventPatternConfigId(), a->a ));
		
		List<DemoTable> listToCopy = new LinkedList<>();
		for(SampleTable sampleTable : findAllSampleTableList()) {
			int pk = sampleTable.getPatternId();
			if ( demoTableMap.get(pk) == null ) {
				DemoTable demoTable  = new DemoTable();
				demoTable.setEventPatternConfigId(sampleTable.getPatternId());
				demoTable.setItmCorrelationId(sampleTable.getItmCorrelationId());
				demoTable.setCorrelationType(sampleTable.getCorrelationType());
				listToCopy.add(demoTable);
			}
		}
		List<DemoTable> l = demoTableJpaRepository.saveAll(listToCopy);
		return l;
	}
	
}