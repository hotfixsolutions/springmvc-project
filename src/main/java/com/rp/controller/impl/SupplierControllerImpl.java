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

package com.rp.controller.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rp.controller.SupplierController;
import com.rp.domainobject.SupplierDo;
import com.rp.entity.Supplier;
import com.rp.service.SupplierService;
import com.rp.service.UtilityService;
import com.rp.validator.SupplierValidator;

@Controller("SupplierController")
@RequestMapping("/supplier")
public class SupplierControllerImpl implements SupplierController {

	@Autowired
	private SupplierService supplierService;
	@Autowired
	private UtilityService utilityService;
	@Autowired
	private SupplierValidator supplierValidator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.livepoint.controller.SupplierController#addSupplierForm(com.livepoint
	 * .domainobject.SupplierDo, org.springframework.validation.BindingResult,
	 * javax.servlet.http.HttpServletRequest, org.springframework.ui.ModelMap)
	 */
	@Override
	@RequestMapping("/supplierForm")
	public String addSupplierForm(
			@ModelAttribute("supplierDO") SupplierDo supplierDO,
			BindingResult result, HttpServletRequest request, ModelMap map) {

		map.put("stateList", utilityService.getStateList());
		System.out.println("In Add Supplier Form");
		return "addSupplierForm";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.livepoint.controller.SupplierController#addSupplier(com.livepoint
	 * .domainobject.SupplierDo, org.springframework.validation.BindingResult,
	 * javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@RequestMapping("/addSupplier")
	public String addSupplier(
			@ModelAttribute("supplierDO") @Valid SupplierDo supplierDO,
			BindingResult result, HttpServletRequest request, ModelMap map) {

		supplierValidator.validate(supplierDO, result);
		if (result.hasErrors()) {
			map.put("stateList", utilityService.getStateList());
			return "addSupplierForm";
		}

		supplierService.addSupplier(supplierDO);

		return "redirect:/supplier/list.html";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.livepoint.controller.SupplierController#listSupplier(org.springframework
	 * .ui.ModelMap, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@RequestMapping("/list")
	public String listSupplier(ModelMap map, HttpServletRequest request) {

		map.put("supplierList", supplierService.getSupplierList());
		return "manageSuppliers";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.livepoint.controller.SupplierController#viewSupplierDetails(org.
	 * springframework.ui.ModelMap, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@RequestMapping("/viewSupplierDetails")
	public String viewSupplierDetails(ModelMap map, HttpServletRequest request) {

		map.put("supplierData", supplierService.getSupplier(Long
				.parseLong(request.getParameter("supplierId"))));
		return "viewSupplierDetail";
	}

	@Override
	@RequestMapping("/editSupplierForm")
	public String editSupplierForm(
			@ModelAttribute("supplierDO") SupplierDo supplierDO,
			BindingResult result, HttpServletRequest request, ModelMap map) {
		System.out.println("Supplier ID " + request.getParameter("supplierId"));
		Supplier supplier = supplierService.getSupplier(Long.parseLong(request
				.getParameter("supplierId")));
		System.out.println("Supplier Name Entity Before Bean Utils "
				+ supplier.getSupplierName());
		try {
			BeanUtils.copyProperties(supplierDO, supplier);
			System.out.println("Supplier Name DO"
					+ supplierDO.getSupplierName());
			System.out.println("Supplier Name Entity"
					+ supplier.getSupplierName());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		map.put("stateList", utilityService.getStateList());

		return "editSupplierForm";
	}

	@Override
	@RequestMapping("/editSupplier")
	public String editSupplier(
			@ModelAttribute("supplierDO") @Valid SupplierDo supplierDO,
			BindingResult result, HttpServletRequest request, ModelMap map) {
		supplierValidator.validate(supplierDO, result);
		if (result.hasErrors()) {
			map.put("stateList", utilityService.getStateList());
			return "editSupplierForm";
		}

		supplierService.editSupplier(supplierDO);

		return "redirect:/supplier/list.html";

	}

	@Override
	@RequestMapping("/listSuppliers")
	public String listSuppliers(ModelMap map, HttpServletRequest request) {

		// return Collections.singletonMap("aaData",
		// getJSONForRequest(requestList));

		return "supplierList";
	}

	private Object[] getJSONForRequest(Collection<SupplierDo> requestList) {
		Object[] rArray = new Object[requestList.size()];
		int i = 0;
		for (SupplierDo request : requestList) {
			Object[] bRequest = new String[] { request.getSupplierName(),
					request.getSupplierContact(), request.getEmailAddress(),
					request.getSupplierPhone1(),
					request.getSupplierId().toString() };
			rArray[i] = bRequest;
			i++;
		}
		return rArray;
	}

	@Override
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/dtSupplierView")
	@ResponseBody
	public Map<String, Object[]> dataTableSupplierView(ModelMap map,
			HttpServletRequest request) {
		Collection<SupplierDo> requestList = supplierService.getSupplierList();
		return Collections.singletonMap("aaData",
				getJSONForRequest(requestList));
	}
}
