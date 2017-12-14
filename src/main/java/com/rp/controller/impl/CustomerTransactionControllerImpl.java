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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rp.controller.CustomerTransactionController;
import com.rp.domainobject.CustomerTransactionDetailsDo;
import com.rp.service.CustomerTransactionService;
import com.rp.service.UtilityService;

/**
 * @author dhiraj singh
 *
 */
@Controller("CustomerTransactionController")
@RequestMapping("/transaction/")
public class CustomerTransactionControllerImpl implements
		CustomerTransactionController {

	private static Logger logger = Logger
			.getLogger(CustomerTransactionController.class);

	@Autowired
	private CustomerTransactionService transactionService;

	@Autowired
	private UtilityService utilityService;

	/* (non-Javadoc)
	 * @see com.rp.controller.CustomerTransactionController#addTransactionForm(javax.servlet.http.HttpServletRequest, org.springframework.ui.ModelMap)
	 */
	@Override
	@RequestMapping ("/addTransaction")
	public String addTransactionForm(HttpServletRequest request, ModelMap map) {
		map.put("stateList", utilityService.getStateList());
		return "addTransaction";
	}

	/* (non-Javadoc)
	 * @see com.rp.controller.CustomerTransactionController#listTransactions(org.springframework.ui.ModelMap, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@RequestMapping("/list")
	public String listTransactions(ModelMap map, HttpServletRequest request) {
		logger.info("In Manage Transactions");
		map.put("transactionList", transactionService.listTransaction());
		return "manageTransaction";
	}

	/* (non-Javadoc)
	 * @see com.rp.controller.CustomerTransactionController#setTransactionDetails(javax.servlet.http.HttpServletRequest, org.springframework.ui.ModelMap)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@RequestMapping(value = "/addTransactionDetails", method = RequestMethod.POST)
	@ResponseBody
	public String setTransactionDetails(HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession(false);
		if(session == null ){
			return "redirect:/home/index.html";
		}

		long pid = Long.parseLong(request.getParameter("pid"));

		Set<CustomerTransactionDetailsDo> transactionSetFromSession = (Set<CustomerTransactionDetailsDo>) session.getAttribute("transactionDetailsSet");
		Set<CustomerTransactionDetailsDo> updatedTransactionSet = new HashSet<CustomerTransactionDetailsDo>();

		if (pid > 0) {
			if (transactionSetFromSession != null) {
				for (CustomerTransactionDetailsDo transactionDetails : transactionSetFromSession) {
					if (transactionDetails.getCodId() == pid) {
						continue;
					} else {
						updatedTransactionSet.add(transactionDetails);
					}
				}
				session.setAttribute("transactionDetailsSet", updatedTransactionSet);
			}
		} else {
			String tmpStr = request.getParameter("tmpId");
			logger.info("tmpPocId : " + tmpStr);
			if (tmpStr != null && !tmpStr.equals("")) {
				long tmpId = Long.parseLong(tmpStr);
				if (transactionSetFromSession != null) {
					for (CustomerTransactionDetailsDo transactionDetails : transactionSetFromSession) {
						if (transactionDetails.getCodTmpId() == tmpId) {
							continue;
						} else {
							updatedTransactionSet.add(transactionDetails);
						}
					}
					session.setAttribute("transactionDetailsSet", updatedTransactionSet);
				}
			}
		}
	
		String MMddyyyy_FORMAT = "MM/dd/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(MMddyyyy_FORMAT);

		CustomerTransactionDetailsDo transactionDetails = new CustomerTransactionDetailsDo();
		transactionDetails.setCodId(pid);
		transactionDetails.setTransactionDateString (request.getParameter("transactionDateString"));
		transactionDetails.setTransactionType(request.getParameter("transactionType"));
		transactionDetails.setTransactionQuantity(Integer.parseInt(request.getParameter("transactionQuantity")));
		transactionDetails.setTransactionDescription(request.getParameter("transactionDescription"));
		transactionDetails.setTransactionAmount(Double.parseDouble(request.getParameter("transactionAmount")));
		transactionDetails.setTransactionRemarks(request.getParameter("transactionRemarks"));
		try {
			transactionDetails.setTransactionDate(sdf.parse (transactionDetails.getTransactionDateString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Set<CustomerTransactionDetailsDo> transactionDetailsSet = null;
		int tmpId = 1;
		Object object = session.getAttribute("transactionDetailsSet");
		if (object == null) {
			transactionDetailsSet = new HashSet<CustomerTransactionDetailsDo>();
			session.setAttribute("pocTmpId", "2");
			transactionDetails.setCodTmpId(Long.parseLong("1"));
			transactionDetailsSet.add(transactionDetails);
		} else {
			tmpId = Integer.parseInt((String) session.getAttribute("pocTmpId"));
			transactionDetailsSet = (Set<CustomerTransactionDetailsDo>) session.getAttribute("transactionDetailsSet");
			transactionDetails.setCodTmpId(System.currentTimeMillis());
			session.setAttribute("pocTmpId", String.valueOf(++tmpId));
			transactionDetailsSet.add(transactionDetails);
		}

		session.setAttribute("transactionDetailsSet", transactionDetailsSet);
		return String.valueOf(transactionDetails.getCodTmpId());
	}

}
