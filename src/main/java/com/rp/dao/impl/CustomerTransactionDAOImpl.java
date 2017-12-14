/*
 *
 * @author dhiraj singh
 
 *
 * The contents of this file are copyrighted by Hotfix Solutions. 
 * The contents of this file represents the real and intellectual property of Hotfix Solutions.
 * Any source code, configuration parameters, documentation, 
 * data or database schema may not be copied, modified, 
 * reused or distributed without the written consent of Hotfix Solutions.
 *
 */
package com.rp.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rp.controller.CustomerTransactionController;
import com.rp.dao.CustomerTransactionDAO;
import com.rp.entity.CustomerTransaction;
import com.rp.entity.CustomerTransactionDetails;


@Repository ("CustomerTransactionDAO")
public class CustomerTransactionDAOImpl implements CustomerTransactionDAO {
	private static Logger logger = Logger
			.getLogger(CustomerTransactionController.class);
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	/* (non-Javadoc)
	 * @see com.rp.dao.CustomerTransactionDAO#saveTransaction(com.rp.entity.CustomerTransaction)
	 */
	@Override
	@Transactional
	public void saveTransaction(CustomerTransaction transaction) {
		hibernateTemplate.save(transaction);

	}

	/* (non-Javadoc)
	 * @see com.rp.dao.CustomerTransactionDAO#updateTransaction(com.rp.entity.CustomerTransaction)
	 */
	@Override
	@Transactional
	public void updateTransaction(CustomerTransaction transaction) {
		hibernateTemplate.update(transaction);

	}

	/* (non-Javadoc)
	 * @see com.rp.dao.CustomerTransactionDAO#listTransactions()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CustomerTransaction> listTransactions() {
		logger.info("In list transaction");
		Criteria dc = sessionFactory.getCurrentSession().createCriteria(
				CustomerTransaction.class);
		logger.info (" Transaction List Size " + dc.list().size());
		return dc.list();
	}

	/* (non-Javadoc)
	 * @see com.rp.dao.CustomerTransactionDAO#getTransaction(java.lang.Long)
	 */
	@Override
	@Transactional
	public CustomerTransaction getTransaction(Long coId) {
		return (CustomerTransaction) hibernateTemplate.get(CustomerTransaction.class, coId);
	}

	/* (non-Javadoc)
	 * @see com.rp.dao.CustomerTransactionDAO#saveTransactionDetails(com.rp.entity.CustomerTransactionDetails)
	 */
	@Override
	public void saveTransactionDetails(
			CustomerTransactionDetails transactionDetails) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.rp.dao.CustomerTransactionDAO#updateTransactionDetails(com.rp.entity.CustomerTransactionDetails)
	 */
	@Override
	public void updateTransactionDetails(
			CustomerTransactionDetails transactionDetails) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.rp.dao.CustomerTransactionDAO#getTransactionDetails(java.lang.Long)
	 */
	@Override
	public CustomerTransactionDetails getTransactionDetails(Long codId) {
		// TODO Auto-generated method stub
		return null;
	}

}
