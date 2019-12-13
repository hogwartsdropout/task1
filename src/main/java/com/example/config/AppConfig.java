package com.example.config;

import javax.sql.DataSource;

import com.example.entity.Car;
import com.example.entity.Customer;
import com.example.entity.Order;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.example.dao.ITestDao;
import com.example.dao.TestDao;
import com.example.entity.Person;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.example.repository")
@ComponentScan("com.example")
public class AppConfig {
    @Bean
    public ITestDao personDao() {
        return new TestDao();
    }

    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(getDataSource())
                .addAnnotatedClasses(Person.class, Customer.class, Car.class, Order.class)
                .buildSessionFactory();
//		org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration()
//				.addAnnotatedClass(com.concretepage.entity.Person.class)
//				.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
//				.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
//				.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/mydatabase")
//				.setProperty("hibernate.connection.username", "postgres")
//				.setProperty("hibernate.id.new_generator_mappings","false")
//				.setProperty("hibernate.connection.password", "RAPtor1234");
//		return cfg.buildSessionFactory();

    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/mydatabase");
        dataSource.setUsername("postgres");
        dataSource.setPassword("RAPtor1234");


        return dataSource;
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager hibTransMan() {
        HibernateTransactionManager htm = new HibernateTransactionManager(sessionFactory());
        htm.setDataSource(getDataSource());
        return htm;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(getDataSource());
        lcemfb.setPackagesToScan("com.example.entity");
        lcemfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        return lcemfb;
    }
}