package com.kp.soi.app.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.kp.soi.app.db.repository.clarity", 
		entityManagerFactoryRef = "clarityEntityManagerFactory",
		transactionManagerRef = "clarityJpaTransactionManager")
public class ConfigJpaClarity {


	@Qualifier("clarityEntityManagerFactory")
	@Bean
	public EntityManagerFactory clarityEntityManagerFactory(@Autowired @Qualifier("clarityDataSource") DataSource dataSource) {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.ORACLE);
		adapter.setShowSql(true);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		Map<String, Object> jpaProperties = new HashMap<>();
		factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		factory.setPersistenceUnitName("clarity");
		factory.setJpaPropertyMap(jpaProperties);
		factory.setJpaVendorAdapter(adapter);
		factory.setPackagesToScan("com.kp.soi.app.db.entity.clarity");
		factory.setDataSource(dataSource);
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
	@Qualifier("clarityJpaTransactionManager")
	@Bean
	public JpaTransactionManager clarityJpaTransactionManager(@Autowired @Qualifier("clarityEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	
}