/**
 * 
 */
package com.rp.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.dao.PurchaseOrderDAO;
import com.rp.domainobject.PurchaseOrderDetailsDo;
import com.rp.domainobject.PurchaseOrderDo;
import com.rp.entity.PurchaseOrder;
import com.rp.entity.PurchaseOrderDetails;
import com.rp.service.PurchaseOrderService;


@Service("PurchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	private static Logger logger = Logger.getLogger (PurchaseOrderService.class); 
	
	@Autowired
	private PurchaseOrderDAO poDAO;
	
	/* (non-Javadoc)
	 * @see com.rp.service.PurchaseOrderService#savePurchaseOrder(com.rp.domainobject.PurchaseOrderDo)
	 */
	@Override
	public void savePurchaseOrder(PurchaseOrderDo purchaseOrderDo) {
		logger.info ("In Purchase Order Service -- Save Purchase Order");
		String MMddyyyy_FORMAT = "MM/dd/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(MMddyyyy_FORMAT);

		PurchaseOrder po = new PurchaseOrder();
		logger.info("Padded String " + String.format("%05d", Integer.parseInt(purchaseOrderDo.getPoName())));
		po.setPoName(purchaseOrderDo.getPoPrefix() + String.format("%05d", Integer.parseInt(purchaseOrderDo.getPoName())));
		po.setDateCreated(new Date());
		po.setDateReceived(purchaseOrderDo.getDateReceived());
		logger.info ("PO Date " + purchaseOrderDo.getPoDateString());
		try {
			po.setPoDate(sdf.parse (purchaseOrderDo.getPoDateString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		po.setPoEmailDate(purchaseOrderDo.getPoEmailDate());
		po.setPoGoodsReceived(purchaseOrderDo.getPoGoodsReceived());
		po.setPoStatus("0");
		po.setSupplierId(purchaseOrderDo.getSupplierId());
		PurchaseOrderDetails poDetails = null;
		Set<PurchaseOrderDetails> setPODetails = new HashSet<PurchaseOrderDetails>();
		for (PurchaseOrderDetailsDo poDetailsDo : purchaseOrderDo.getPoDetails()) {
			poDetails = new PurchaseOrderDetails ();
			if(poDetailsDo.getPoItemId() > 0){
				poDetails.setPoItemId(poDetailsDo.getPoItemId());
			}
			poDetails.setBookName(poDetailsDo.getBookName());
			poDetails.setOrderQuantity(poDetailsDo.getOrderQuantity());
			poDetails.setAuthor (poDetailsDo.getAuthor());
			poDetails.setPoId (poDetailsDo.getPoId());
			setPODetails.add(poDetails);
		}
		po.setPoDetails(setPODetails);
		for (PurchaseOrderDetails pdetails: po.getPoDetails()) {
			logger.info (pdetails.toString());
		}

		poDAO.savePurchaseOrder(po);
		
	}

	/* (non-Javadoc)
	 * @see com.rp.service.PurchaseOrderService#editPurchaseOrder(com.rp.domainobject.PurchaseOrderDo)
	 */
	@Override
	public void editPurchaseOrder(PurchaseOrderDo purchaseOrderDo) {
		logger.info ("In Purchase Order Service -- Edit Purchase Order");
		String MMddyyyy_FORMAT = "MM/dd/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(MMddyyyy_FORMAT);

		PurchaseOrder po = new PurchaseOrder();
		po.setPoName(purchaseOrderDo.getPoPrefix() + String.format("%05d", Integer.parseInt(purchaseOrderDo.getPoName())));
		po.setDateCreated(purchaseOrderDo.getDateCreated());
		po.setDateReceived(purchaseOrderDo.getDateReceived());
		try {
			po.setPoDate(sdf.parse (purchaseOrderDo.getPoDateString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		po.setPoEmailDate(purchaseOrderDo.getPoEmailDate());
		po.setPoGoodsReceived(purchaseOrderDo.getPoGoodsReceived());
		po.setPoStatus(purchaseOrderDo.getPoStatus());
		po.setSupplierId(purchaseOrderDo.getSupplierId());
		po.setPoId(purchaseOrderDo.getPoId());
		PurchaseOrderDetails poDetails = null;
		Set<PurchaseOrderDetails> setPODetails = new HashSet<PurchaseOrderDetails>();
		for (PurchaseOrderDetailsDo poDetailsDo : purchaseOrderDo.getPoDetails()) {
			poDetails = new PurchaseOrderDetails ();
			if(poDetailsDo.getPoItemId() > 0){
				poDetails.setPoItemId(poDetailsDo.getPoItemId());
			}
			poDetails.setBookName(poDetailsDo.getBookName());
			poDetails.setOrderQuantity(poDetailsDo.getOrderQuantity());
			poDetails.setAuthor (poDetailsDo.getAuthor());
			poDetails.setPoId (poDetailsDo.getPoId());
			setPODetails.add(poDetails);
		}
		po.setPoDetails(setPODetails);
		
		poDAO.editPurchaseOrder(po);
	}

	/* (non-Javadoc)
	 * @see com.rp.service.PurchaseOrderService#listPurchaseOrder()
	 */
	@Override
	public List<PurchaseOrderDo> listPurchaseOrder() {
		List<PurchaseOrder> pos = poDAO.listPurchaseOrder();
		List<PurchaseOrderDo> purchaseOrderDo = new ArrayList<PurchaseOrderDo>();
		PurchaseOrderDo poDo = null;
		for (PurchaseOrder po : pos) {
			poDo = new PurchaseOrderDo();
			try {
				BeanUtils.copyProperties(poDo, po);
				logger.info(poDo.toString());
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			DateFormat formatter = new SimpleDateFormat ("MM/dd/yyyy");
			poDo.setPoDateString (formatter.format (poDo.getPoDate()));
			String poName = poDo.getPoName();
			int i = poName.lastIndexOf("/");
			if (i > 0 ) {
				poDo.setPoPrefix(poName.substring (0, (i+1)));
				poDo.setPoName(poName.substring (i+1));
				logger.info ("Po Prefix " + poDo.getPoPrefix() + " Po Name " + poDo.getPoName());
			}
			purchaseOrderDo.add(poDo);
		}
		return purchaseOrderDo;
	}

	/* (non-Javadoc)
	 * @see com.rp.service.PurchaseOrderService#getPurchaseOrder(java.lang.Long)
	 */
	@Override
	public PurchaseOrder getPurchaseOrder(Long poId) {
		return poDAO.getPurchaseOrder(poId);
	}

}
