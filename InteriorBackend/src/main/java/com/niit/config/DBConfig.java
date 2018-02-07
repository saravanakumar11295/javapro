package com.niit.config;


@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/DT255");
		dataSource.setUsername("dteja");
		dataSource.setPassword("dteja");
		
		System.out.println("---Data Source Created---");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		
		Properties hibernateProp=new Properties();
		
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addProperties(hibernateProp);
		
		System.out.println("Creating SessionFactory Bean");
		return factoryBuilder.buildSessionFactory();
	}
	
	
	@Bean(name="categoryDAO")
	public CategoryDAOImpl getCategoryDAO()
	{
		System.out.println("----DAO Implementation---");
		return new CategoryDAOImpl();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager----");
		return new HibernateTransactionManager(sessionFactory);
	}

	
}
