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

package com.rp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.dao.SupplierDAO;
import com.rp.domainobject.SupplierDo;
import com.rp.entity.Supplier;
import com.rp.service.SupplierService;

@Service("SupplierService")
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDAO supplierDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.livepoint.service.SupplierService#addSupplier(com.livepoint.domainobject
	 * .SupplierDo)
	 */
	@Override
	public void addSupplier(SupplierDo supplierDO) {
		Supplier supplier = new Supplier();
		supplier.setSupplierName(supplierDO.getSupplierName());
		supplier.setSupplierContact(supplierDO.getSupplierContact());
		supplier.setSupplierAddress1(supplierDO.getSupplierAddress1());
		supplier.setSupplierAddress2(supplierDO.getSupplierAddress2());
		supplier.setSupplierAddress3(supplierDO.getSupplierAddress3());
		supplier.setSupplierPhone1(supplierDO.getSupplierPhone1());
		supplier.setSupplierPhone2(supplierDO.getSupplierPhone2());
		supplier.setCity(supplierDO.getCity());
		supplier.setState(supplierDO.getState());
		supplier.setZip(supplierDO.getZip());
		supplier.setEmailAddress(supplierDO.getEmailAddress());
		supplier.setStatus(supplierDO.getStatus());

		supplierDAO.addSupplier(supplier);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.livepoint.service.SupplierService#editSupplier(com.livepoint.domainobject
	 * .SupplierDo)
	 */
	@Override
	public void editSupplier(SupplierDo supplierDO) {
		Supplier supplier = supplierDAO.getSupplier(supplierDO.getSupplierId());
		supplier.setSupplierName(supplierDO.getSupplierName());
		supplier.setSupplierContact(supplierDO.getSupplierContact());
		supplier.setSupplierAddress1(supplierDO.getSupplierAddress1());
		supplier.setSupplierAddress2(supplierDO.getSupplierAddress2());
		supplier.setSupplierAddress3(supplierDO.getSupplierAddress3());
		supplier.setSupplierPhone1(supplierDO.getSupplierPhone1());
		supplier.setSupplierPhone2(supplierDO.getSupplierPhone2());
		supplier.setEmailAddress(supplierDO.getEmailAddress());
		supplier.setCity(supplierDO.getCity());
		supplier.setState(supplierDO.getState());
		supplier.setZip(supplierDO.getZip());
		supplier.setStatus(supplierDO.getStatus());
	
		supplierDAO.editSupplier(supplier);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.livepoint.service.SupplierService#getSupplierList()
	 */
	@Override
	public List<SupplierDo> getSupplierList() {
		List<SupplierDo> supplierDOList = new ArrayList<SupplierDo>();
		SupplierDo supplierDO;
		List<Supplier> supplierList = supplierDAO.getSupplierList();
		for (Supplier supplier : supplierList) {
			supplierDO = new SupplierDo();
			supplierDO.setSupplierId(supplier.getSupplierId());
			supplierDO.setSupplierName(supplier.getSupplierName());
			supplierDO.setSupplierContact(supplier.getSupplierContact());
			supplierDO.setSupplierAddress1(supplier.getSupplierAddress1());
			supplierDO.setSupplierAddress2(supplier.getSupplierAddress2());
			supplierDO.setSupplierAddress3(supplier.getSupplierAddress3());
			supplierDO.setSupplierPhone1(supplier.getSupplierPhone1());
			supplierDO.setSupplierPhone2(supplier.getSupplierPhone2());
			supplierDO.setEmailAddress(supplier.getEmailAddress());
			supplierDO.setCity(supplier.getCity());
			supplierDO.setState(supplier.getState());
			supplierDO.setZip(supplier.getZip());
			supplierDO.setStatus(supplier.getStatus());

			supplierDOList.add(supplierDO);
		}
		return supplierDOList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.livepoint.service.SupplierService#getSupplier(java.lang.Long)
	 */
	@Override
	public Supplier getSupplier(Long supplierId) {
		System.out.println("Id " + supplierId);
		Supplier supplier = supplierDAO.getSupplier(supplierId);
		System.out.println("In Service " + supplier.getSupplierName() + "/"
				+ supplier.getSupplierId());
		return supplier;
	}

}
