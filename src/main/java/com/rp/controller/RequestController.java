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

import com.rp.domainobject.RequestDo;

public interface RequestController {
	public String addBookRequestForm(
			@ModelAttribute("requestDO") RequestDo bookRequestDO,
			BindingResult result, HttpServletRequest request, ModelMap map);

	public String addBookRequest(
			@ModelAttribute("requestDO") @Valid RequestDo bookRequestDO,
			BindingResult result, HttpServletRequest request, ModelMap map);

	public String listBookRequest(ModelMap map, HttpServletRequest request);

	public String viewBookRequestDetails(ModelMap map,
			HttpServletRequest request);

	public String editBookRequestForm(
			@ModelAttribute("requestDO") RequestDo bookRequestDO,
			BindingResult result, HttpServletRequest request, ModelMap map);

	public String editBookRequest(
			@ModelAttribute("requestDO") @Valid RequestDo bookRequestDO,
			BindingResult result, HttpServletRequest request, ModelMap map);

	public String filterRequest(
			@ModelAttribute("requestDO") RequestDo bookRequestDO,
			BindingResult result, HttpServletRequest request, ModelMap map);

	public String saveAndEmailRequest(
			@ModelAttribute("requestDO") @Valid RequestDo bookRequestDO,
			BindingResult result, HttpServletRequest request, ModelMap map);
	
	public Map<String, Object[]> listRequestForTableView (ModelMap map, HttpServletRequest request);
	
	public String listRequests (ModelMap map, HttpServletRequest request);

}
