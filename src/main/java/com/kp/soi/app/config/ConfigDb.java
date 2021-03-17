package com.kp.soi.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@Configuration
@EnableTransactionManagement
public class ConfigDb {

	@Autowired
	Environment env;
	
    @Qualifier("clarityDataSource")
    @Bean
    public javax.sql.DataSource clarityDataSource() {
        org.springframework.jdbc.datasource.DriverManagerDataSource ds = new org.springframework.jdbc.datasource.DriverManagerDataSource();
        ds.setDriverClassName(env.getProperty("clarity.datasource.driver", "oracle.jdbc.OracleDriver"));
        ds.setUrl(env.getRequiredProperty("clarity.datasource.url"));
        ds.setUsername(env.getRequiredProperty("clarity.datasource.username"));
        ds.setPassword(env.getRequiredProperty("clarity.datasource.password"));
        return ds;
    }

    @Primary
    @Qualifier("demoDataSource")
    @Bean
    public javax.sql.DataSource demoDataSource() {
    	org.springframework.jdbc.datasource.DriverManagerDataSource ds = new org.springframework.jdbc.datasource.DriverManagerDataSource();
        ds.setDriverClassName(env.getProperty("demo.datasource.driver", "oracle.jdbc.OracleDriver"));
        ds.setUrl(env.getRequiredProperty("demo.datasource.url"));
        ds.setUsername(env.getRequiredProperty("demo.datasource.username"));
        ds.setPassword(env.getRequiredProperty("demo.datasource.password"));
        return ds;
    }
    
//    @Qualifier("clarityTransactionManager")
//    @Bean
//    public PlatformTransactionManager clarityTransactionManager (@Autowired DataSource clarityDataSource) throws Exception {
//    	DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//    	transactionManager.setDataSource(clarityDataSource);
//    	return transactionManager;
//    }
//
//    @Qualifier("demoTransactionManager")
//    @Bean
//    public PlatformTransactionManager demoTransactionManager (@Autowired DataSource demoDataSource) throws Exception {
//    	DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//    	transactionManager.setDataSource(demoDataSource);
//    	return transactionManager;
//    }
//    


}