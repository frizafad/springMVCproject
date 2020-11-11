package com.frizafad.stringproject.init;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("com.frizafad.stringproject")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfig {
    @Resource
    Environment env;
    

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSource.setUrl(env.getRequiredProperty("db.url"));
        dataSource.setUsername(env.getRequiredProperty("db.username"));
        dataSource.setPassword(env.getRequiredProperty("db.password"));
        return dataSource();
    }

    private Properties hibernateProperties() {
        Properties p = new Properties();
        p.put("hibernate.dialect",env.getRequiredProperty("hibernate.dialect"));
        p.put("hibernate.show_sql",env.getRequiredProperty("hibernate.show_sql"));
        p.put("hibernate.format_sql",env.getRequiredProperty("hibernate.format_sql"));
        return p;
    }

    @Bean
    public LocalSessionFactoryBean sessionfactory(){
    	LocalSessionFactoryBean factorybean = new LocalSessionFactoryBean();
    	factorybean.setDataSource((dataSource()));
    	factorybean.setPackagesToScan(env.getProperty("com.frizafad.stringproject.model"));
    	factorybean.setHibernateProperties(hibernateProperties());
    	return factorybean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory s){
        HibernateTransactionManager hibernateTxManager=new HibernateTransactionManager();
        hibernateTxManager.setSessionFactory(s);
        return  hibernateTxManager;
    }
    
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
  
}
