package com.kp.soi.app.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kp.soi.app.db.entity.clarity.SampleTable;
import com.kp.soi.app.db.entity.demo.DemoTable;
import com.kp.soi.app.db.entity.demo.DiagnosisTable;
//import com.kp.soi.app.db.entity.log.LogTable;
//import com.kp.soi.app.db.entity.log.LogType;
import com.kp.soi.app.db.repository.clarity.SampleTableJpaRepository;
import com.kp.soi.app.db.repository.demo.DemoTableJpaRepository;
//import com.kp.soi.app.db.repository.log.LogTableJpaRepository;
import com.kp.soi.app.dto.ModelClass;

import java.time.LocalDateTime;

@Service
public class JobServiceImpl {

	@Autowired 
	SampleTableJpaRepository sampleTableJpaRepository;
	
	@Autowired
	DemoTableJpaRepository demoTableJpaRepository;
	
//	@Autowired
//	LogTableJpaRepository logTableJpaRepository;
	
	
	@Autowired
	EntityManagerFactory emf;
	public List<ModelClass> fetchFromSource() {

	    EntityManager em = emf.createEntityManager();
	    javax.persistence.Query query = em.createQuery()
	}
	
	public List<SampleTable> findAllSampleTableList() {
		return sampleTableJpaRepository.findAll();
	}
	
	public List<DemoTable> findAllDemoTableList() {
		return demoTableJpaRepository.findAll();
	}
	
	public List<DiagnosisTable> findAllDxTableList() {
		return 
	}
	
	
	public static final String USERNAME= "Test";
	public static final String FILENAME= "Dashboard";
	
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
//		saveLog();
		return l;
	}
	
	
	public List<DiagnosisTable> upsertdx(List<DiagnosisTable> dxTableList ) {
		Map<Integer, DiagnosisTable> dxTableMap = dxTableList.stream().collect(Collectors.toMap(a->a.get(), a->a ));
		
	
	
	
	
//	@Transactional(transactionManager = "LogJpaTransactionManager", readOnly = false)
//	public List<LogTable> saveLog() {
//		LogTable newrecord = new LogTable(LogType.DASHBOARD, 0, 0, LocalDateTime.now(), USERNAME, FILENAME);
//		return logTableJpaRepository.saveAll(Collections.singletonList(newrecord));
//	}
}
