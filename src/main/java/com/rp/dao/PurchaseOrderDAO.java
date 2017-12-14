/**
 * 
 */
package com.rp.dao;

import java.util.List;

import com.rp.entity.PurchaseOrder;
import com.rp.entity.PurchaseOrderDetails;


public interface PurchaseOrderDAO {
	public void savePurchaseOrder (PurchaseOrder purchaseOrder);
	public void editPurchaseOrder (PurchaseOrder purchaseOrder);
	public List<PurchaseOrder> listPurchaseOrder ();
	public PurchaseOrder getPurchaseOrder (Long poId);
	public void savePurchaseOrderDetails (PurchaseOrderDetails poDetails);
	public void editPurchaseOrderDetails (PurchaseOrderDetails poDetails);
	public void detelPurchaseOrderDetails (Long poItemId);
	public void getPurchaseOrderDetails (Long poItemId);

}
