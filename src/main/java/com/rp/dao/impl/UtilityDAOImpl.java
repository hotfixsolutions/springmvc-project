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

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rp.dao.UtilityDAO;
import com.rp.entity.State;

@Repository("UtilityDAO")
public class UtilityDAOImpl implements UtilityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rp.dao.UtilityDAO#getStateList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<State> getStateList() {
		Criteria dc = sessionFactory.getCurrentSession().createCriteria(
				State.class);
		
		return dc.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rp.dao.UtilityDAO#getStateName(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=true)
	public State getStateName(String stateCode) {
		return (State) hibernateTemplate.get(State.class, stateCode);
	}

}
