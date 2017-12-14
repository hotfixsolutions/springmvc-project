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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.rp.dao.SupplierDAO;
import com.rp.entity.Supplier;

@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	/* (non-Javadoc)
	 * @see com.livepoint.dao.SupplierDAO#addSupplier(com.livepoint.entity.Supplier)
	 */
	@Override
	public void addSupplier(Supplier supplier) {
		hibernateTemplate.save(supplier);

	}

	/* (non-Javadoc)
	 * @see com.livepoint.dao.SupplierDAO#editSupplier(com.livepoint.entity.Supplier)
	 */
	@Override
	public void editSupplier(Supplier supplier) {
		hibernateTemplate.update(supplier);
	}

	/* (non-Javadoc)
	 * @see com.livepoint.dao.SupplierDAO#getSupplierList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getSupplierList() {
		String sql = "FROM " + Supplier.class.getName() + " a ";
		return hibernateTemplate.find(sql);
	}

	/* (non-Javadoc)
	 * @see com.livepoint.dao.SupplierDAO#getSupplier(java.lang.Long)
	 */
	@Override
	public Supplier getSupplier(Long supplierId) {
		Supplier supplier = hibernateTemplate.get (Supplier.class, supplierId);
		System.out.println ("supplier name and id " + supplier.getSupplierName() + "/" + supplier.getSupplierId());
		return supplier;
		//return (Supplier) hibernateTemplate.get (Supplier.class, supplierId);
	}

}
