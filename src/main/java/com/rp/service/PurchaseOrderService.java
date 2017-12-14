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
package com.rp.service;

import java.util.List;

import com.rp.domainobject.PurchaseOrderDo;
import com.rp.entity.PurchaseOrder;


public interface PurchaseOrderService {
	public void savePurchaseOrder (PurchaseOrderDo purchaseOrderDo);
	public void editPurchaseOrder (PurchaseOrderDo purchaseOrderDo);
	public List<PurchaseOrderDo> listPurchaseOrder();
	public PurchaseOrder getPurchaseOrder (Long poId);

}
