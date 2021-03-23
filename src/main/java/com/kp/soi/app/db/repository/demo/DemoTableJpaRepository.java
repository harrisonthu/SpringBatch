package com.kp.soi.app.db.repository.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.soi.app.db.entity.demo.DemoTable;

public interface DemoTableJpaRepository extends JpaRepository<DemoTable, Integer> {

	
	
}