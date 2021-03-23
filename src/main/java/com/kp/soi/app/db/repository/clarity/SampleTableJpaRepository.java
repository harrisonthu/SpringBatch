package com.kp.soi.app.db.repository.clarity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kp.soi.app.db.entity.clarity.SampleTable;

@Repository
public interface SampleTableJpaRepository extends JpaRepository<SampleTable, Integer> {

}