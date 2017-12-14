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
package com.rp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rp.domainobject.PurchaseOrderDo;

/**
 * @author 
 * 
 */
public interface PurchaseOrderController {
	public String addPOForm(HttpServletRequest request, ModelMap map);

	public String listPurchaseOrders(ModelMap map, HttpServletRequest request);

	public String setPODetails(HttpServletRequest request, ModelMap map);

	public String addPurchaseOrder(
			@ModelAttribute("poDo") PurchaseOrderDo poDo, BindingResult result,
			HttpServletRequest request, ModelMap map);

	public String editPOForm(@ModelAttribute("poDo") PurchaseOrderDo poDo,
			BindingResult result, HttpServletRequest request, ModelMap map);
	
	public String editPO(@ModelAttribute("poDo") PurchaseOrderDo poDo,
			BindingResult result, HttpServletRequest request, ModelMap map);
	
	public String placePurchaseOrder (@ModelAttribute("poDo") PurchaseOrderDo poDo,
			BindingResult result, HttpServletRequest request, ModelMap map);
	

}
