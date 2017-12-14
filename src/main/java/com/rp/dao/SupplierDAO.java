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

package com.rp.dao;

import java.util.List;

import com.rp.entity.Supplier;


public interface SupplierDAO {
	public void addSupplier (Supplier supplier);
	
	public void editSupplier (Supplier supplier);
	
	public List<Supplier> getSupplierList ();
	
	public Supplier getSupplier (Long supplierId);

}
