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
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rp.controller.RequestController;
import com.rp.domainobject.RequestDo;
import com.rp.entity.Request;
import com.rp.entity.Supplier;
import com.rp.service.RequestService;
import com.rp.service.SupplierService;
import com.rp.service.UtilityService;
import com.rp.validator.RequestValidator;


@Controller("RequestController")
@RequestMapping("/request")
public class RequestControllerImpl implements RequestController {

	@Autowired
	private RequestService bookRequestService;
	@Autowired
	private RequestValidator bookRequestValidator;
	@Autowired
	private UtilityService utilityService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private SimpleMailMessage mailMessage;
	
	private static Logger logger = Logger.getLogger(RequestController.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.livepoint.controller.BookRequestController#addBookRequestForm(com
	 * .livepoint.domainobject.RequestDo,
	 * org.springframework.validation.BindingResult,
	 * javax.servlet.http.HttpServletRequest, org.springframework.ui.ModelMap)
	 */
	@Override
	@RequestMapping(value = "/addRequestForm")
	public String addBookRequestForm(
			@ModelAttribute("requestDO") RequestDo requestDO,
			BindingResult result, HttpServletRequest request, ModelMap map) {
		map.put("stateList", utilityService.getStateList());
		map.put("supplierList", supplierService.getSupplierList());
		logger.info("In Add Book Request Form");
		return "addRequestForm";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.livepoint.controller.BookRequestController#addBookRequest(com.livepoint
	 * .domainobject.RequestDo, org.springframework.validation.BindingResult,
	 * javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@RequestMapping(value = "/addRequest")
	public String addBookRequest(
			@ModelAttribute("requestDO") @Valid RequestDo requestDO,
			BindingResult result, HttpServletRequest request, ModelMap map) {

		bookRequestValidator.validate(requestDO, result);
		if (result.hasErrors()) {
			map.put("stateList", utilityService.getStateList());
			map.put("supplierList", supplierService.getSupplierList());
			return "addRequestForm";
		}

		bookRequestService.addRequest(requestDO);

		return "redirect:/request/list.html";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.livepoint.controller.BookRequestController#listBookRequest(org.
	 * springframework.ui.ModelMap, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@RequestMapping(value = "/list")
	public String listBookRequest(ModelMap map, HttpServletRequest request) {
		map.put("requestList", bookRequestService.getRequests());
		return "manageRequests";
	}

	@Override
	@RequestMapping(value = "/viewRequestDetail")
	public String viewBookRequestDetails(ModelMap map,
			HttpServletRequest request) {
		map.put("requestData", bookRequestService.getRequest(Long
				.parseLong(request.getParameter("requestid"))));
		map.put("supplierList", supplierService.getSupplierList());
		return "viewRequestDetail";
	}

	@Override
	@RequestMapping(value = "/editRequestForm")
	public String editBookRequestForm(
			@ModelAttribute("requestDO") RequestDo requestDO,
			BindingResult result, HttpServletRequest request, ModelMap map) {
		Request bookRequest = bookRequestService.getRequest(Long
				.parseLong(request.getParameter("requestid")));
		try {
			BeanUtils.copyProperties(requestDO, bookRequest);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		map.put("stateList", utilityService.getStateList());
		map.put("supplierList", supplierService.getSupplierList());
		return "editRequestForm";
	}

	@Override
	@RequestMapping(value = "/editRequest")
	public String editBookRequest(
			@ModelAttribute("requestDO") @Valid RequestDo requestDO,
			BindingResult result, HttpServletRequest request, ModelMap map) {
		if (result.hasErrors()) {
			map.put("stateList", utilityService.getStateList());
			map.put("supplierList", supplierService.getSupplierList());

			return "editRequestForm";
		}

		bookRequestService.editRequest(requestDO);

		return "redirect:/request/list.html";

	}

	@Override
	@RequestMapping(value = "/filterRequest")
	public String filterRequest(
			@ModelAttribute("requestDO") RequestDo requestDO,
			BindingResult result, HttpServletRequest request, ModelMap map) {
		String requestorName = requestDO.getRequestorName();
		String bookName = requestDO.getBookName();
		requestDO = new RequestDo();
		map.put("requestDO", requestDO);
		map.put("requestList",
				bookRequestService.filterRequest(bookName, requestorName));

		return "manageRequests";
	}

	@Override
	@RequestMapping(value = "/mailRequest")
	public String saveAndEmailRequest(
			@ModelAttribute("requestDO") @Valid RequestDo requestDO,
			BindingResult result, HttpServletRequest request, ModelMap map) {
		if (result.hasErrors()) {
			map.put("stateList", utilityService.getStateList());
			map.put("supplierList", supplierService.getSupplierList());

			return "editRequestForm";
		}

		bookRequestService.editRequest(requestDO);

		Supplier supplier = supplierService.getSupplier(requestDO
				.getSupplierId());

		Map<Object, Object> mailMap = new HashMap<Object, Object>();
		mailMessage.setTo(supplier.getEmailAddress());
		mailMap.put("contactPerson", supplier.getSupplierContact());
		mailMap.put("bookName", requestDO.getBookName());

		utilityService.send(mailMessage, mailMap, "emailBody.vm");

		// map.put("supplierList", supplierService.getSupplierList());

		return "redirect:/request/list.html";
	}
	
	
	@Override
	@RequestMapping(method={RequestMethod.POST,RequestMethod.GET} ,value = "/dataTableView")
	@ResponseBody
	public Map<String, Object[]> listRequestForTableView(ModelMap map,
			HttpServletRequest request) {
		Collection<RequestDo> requestList = bookRequestService.getRequests();

		return Collections.singletonMap("aaData", getJSONForRequest(requestList));
	}

	private Object[] getJSONForRequest(Collection<RequestDo> requestList) {
		Object[] rArray = new Object[requestList.size()];
		int i = 0;
		for (RequestDo request : requestList) {
			Object[] bRequest = new String[] { request.getBookName(),
					request.getRequestorName(), request.getRequestorPhone(),
					request.getRequestId().toString()};
			rArray[i] = bRequest;
			i++;
		}
		return rArray;
	}

	/* (non-Javadoc)
	 * @see com.rp.controller.RequestController#listRequests(org.springframework.ui.ModelMap, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@RequestMapping(value = "/dtView")
	public String listRequests(ModelMap map, HttpServletRequest request) {
		return "manageTableRequests";
	}

}
