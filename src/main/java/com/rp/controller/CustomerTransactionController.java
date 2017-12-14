/*
 *
 * @author dhiraj singh
 * @date Oct 22, 2014
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


public interface CustomerTransactionController {
	public String addTransactionForm (HttpServletRequest request, ModelMap map);
	public String listTransactions(ModelMap map, HttpServletRequest request);
	public String setTransactionDetails (HttpServletRequest request, ModelMap map);

}
