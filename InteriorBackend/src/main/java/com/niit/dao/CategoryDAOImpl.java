package com.niit.dao;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO { 
	public class CategoryDAOImpl implements CategoryDAO 
	{

		@Autowired
		SessionFactory sessionFactory;
		
		
		@Transactional
		@Override
		public boolean addCategory(Category category) 
		{	
			sessionFactory.getCurrentSession().save(category);
			return false;
		}


	
}
