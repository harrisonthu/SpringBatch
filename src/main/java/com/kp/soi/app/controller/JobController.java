package com.kp.soi.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kp.soi.app.db.entity.clarity.SampleTable;
import com.kp.soi.app.db.entity.demo.DemoTable;
import com.kp.soi.app.service.JobServiceImpl;

@RestController
@RequestMapping("job")
public class JobController {

	@Autowired 
	JobServiceImpl jobService;
	
	
    @GetMapping(value = "/invokejob", produces = MediaType.APPLICATION_JSON_VALUE)
    public String handle() throws Exception {
        return "Batch job has been invoked";
    }
    
    @GetMapping(value = "/findallsampltTablelist", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SampleTable> findAllSampleTableList() {
    	return jobService.findAllSampleTableList();
    }
    
    @GetMapping(value = "/findAllDemoTableList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DemoTable> findAllDemoTableList() {
    	return jobService.findAllDemoTableList();
    }
    
    @PostMapping(value = "/upsertSampleToDemo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String upsertSampleToDemo() {
    	 List<DemoTable> savedList = jobService.upsert(jobService.findAllDemoTableList());
    	 return savedList.size()+" records were copied!";
    }
    
    
//    HTTP verbs 
//    GET - Read something
//    POST - insert
//    PUT - update
//    DELETE - remove
    
    
}
