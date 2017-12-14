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
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rp.dao.RequestDAO;
import com.rp.entity.Request;


@Repository("RequestDAO")
public class RequestDAOImpl implements RequestDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.livepoint.dao.BookRequestDAO#addBookRequest(com.livepoint.entity.
	 * BookRequest)
	 */
	@Override
	@Transactional
	public void addRequest(Request bookRequest) {
		hibernateTemplate.save(bookRequest);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.livepoint.dao.BookRequestDAO#editBookRequest(com.livepoint.entity
	 * .BookRequest)
	 */
	@Override
	@Transactional
	public void editRequest(Request bookRequest) {
		hibernateTemplate.update(bookRequest);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.livepoint.dao.BookRequestDAO#bookRequests()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional (readOnly=true)
	public List<Request> getRequests() {

		Criteria dc = sessionFactory.getCurrentSession()
				.createCriteria(Request.class);
		dc.add(Restrictions.disjunction().add(Restrictions.isNull("delivered"))
				.add(Restrictions.eq("delivered", "0"))
				.add(Restrictions.eq("delivered", "-1")));

		System.out.println("Criteria " + dc.toString());
		return dc.list();

		// String sql = "FROM " + BookRequest.class.getName() + " a ";
		// return getHibernateTemplate().find(sql);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.livepoint.dao.BookRequestDAO#bookRequest(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly=true)
	public Request getRequest(Long requestId) {
		return (Request) hibernateTemplate.get(Request.class, requestId);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional (readOnly=true)
	public List<Request> filterRequest(String bookName, String requestorName) {

		Criteria dc = sessionFactory.getCurrentSession()
				.createCriteria(Request.class);

		if ((bookName != null && !bookName.isEmpty())
				&& (requestorName != null && !requestorName.isEmpty())) {
			dc.add(Restrictions
					.disjunction()
					.add(Restrictions.like("bookName",
							"%" + bookName.toLowerCase() + "%").ignoreCase())
					.add(Restrictions.like("requestorName",
							"%" + requestorName.toLowerCase() + "%")
							.ignoreCase()));
		} else if (bookName != null && !bookName.isEmpty()) {
			dc.add(Restrictions.like("bookName",
					"%" + bookName.toLowerCase() + "%").ignoreCase());
		} else if (requestorName != null && !requestorName.isEmpty()) {
			dc.add(Restrictions.like("requestorName",
					"%" + requestorName.toLowerCase() + "%").ignoreCase());
		} else {
			System.out.println("Nothing to Filter");
			return getRequests();
		}

		System.out.println("Something " + dc.toString());

		List<Request> results = dc.list();
		return results;
	}

}
