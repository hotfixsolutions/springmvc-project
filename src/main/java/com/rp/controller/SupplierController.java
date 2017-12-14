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

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rp.domainobject.SupplierDo;


public interface SupplierController {
	public String addSupplierForm(
			@ModelAttribute("supplierDO") SupplierDo supplierDO,
			BindingResult result, HttpServletRequest request, ModelMap map);

	public String addSupplier(
			@ModelAttribute("supplierDO") @Valid SupplierDo supplierDO,
			BindingResult result, HttpServletRequest request, ModelMap map);

	public String listSupplier(ModelMap map, HttpServletRequest request);

	public String viewSupplierDetails(ModelMap map, HttpServletRequest request);

	public String editSupplierForm(
			@ModelAttribute("supplierDO") SupplierDo supplierDO,
			BindingResult result, HttpServletRequest request, ModelMap map);

	public String editSupplier(
			@ModelAttribute("supplierDO") @Valid SupplierDo supplierDO,
			BindingResult result, HttpServletRequest request, ModelMap map);
	
	public String listSuppliers (ModelMap map, HttpServletRequest request);
	
	public Map<String, Object[]> dataTableSupplierView (ModelMap map, HttpServletRequest request);
}
