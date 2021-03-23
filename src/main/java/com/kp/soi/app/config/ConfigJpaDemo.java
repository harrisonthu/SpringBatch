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
import org.springframework.context.annotation.Primary;
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
		basePackages = "com.kp.soi.app.db.repository.demo", 
		entityManagerFactoryRef = "demoEntityManagerFactory",
		transactionManagerRef = "demoJpaTransactionManager")
public class ConfigJpaDemo {

	@Primary
	@Qualifier("demoEntityManagerFactory")
	@Bean
	public EntityManagerFactory demoEntityManagerFactory(@Autowired @Qualifier("demoDataSource") DataSource dataSource) {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.ORACLE);
		adapter.setShowSql(true);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		Map<String, Object> jpaProperties = new HashMap<>();
		// Oracle DB requires update data to manually commit
//		jpaProperties.put("hibernate.connection.autocommit", true);
		factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		factory.setPersistenceUnitName("demo");
		factory.setJpaPropertyMap(jpaProperties);
		factory.setJpaVendorAdapter(adapter);
		factory.setPackagesToScan("com.kp.soi.app.db.entity.demo");
		factory.setDataSource(dataSource);
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
//	@Primary
	@Qualifier("demoJpaTransactionManager")
	@Bean
	public JpaTransactionManager demoJpaTransactionManager(@Autowired @Qualifier("demoEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
}