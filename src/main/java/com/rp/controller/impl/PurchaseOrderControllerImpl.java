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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.rp.controller.PurchaseOrderController;
import com.rp.domainobject.PurchaseOrderDetailsDo;
import com.rp.domainobject.PurchaseOrderDo;
import com.rp.entity.PurchaseOrder;
import com.rp.entity.PurchaseOrderDetails;
import com.rp.entity.Supplier;
import com.rp.service.PurchaseOrderService;
import com.rp.service.SupplierService;
import com.rp.service.UtilityService;

@Controller("PurchaseOrderController")
@RequestMapping("/po/")
public class PurchaseOrderControllerImpl implements PurchaseOrderController {

	private static Logger logger = Logger
			.getLogger(PurchaseOrderController.class);

	@Autowired
	private PurchaseOrderService poService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private SimpleMailMessage mailMessage;
	@Autowired
	private UtilityService utilityService;


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rp.controller.PurchaseOrderController#addPOForm(com.rp.domainobject
	 * .PurchaseOrderDo, org.springframework.validation.BindingResult,
	 * javax.servlet.http.HttpServletRequest, org.springframework.ui.ModelMap)
	 */
	@Override
	@RequestMapping("/addPOForm")
	public String addPOForm(HttpServletRequest request, ModelMap map) {
		map.put("supplierList", supplierService.getSupplierList());

		return "addPO";
	}

	@Override
	@RequestMapping("/list")
	public String listPurchaseOrders(ModelMap map, HttpServletRequest request) {
		map.put("poList", poService.listPurchaseOrder());
		map.put("supplierList", supplierService.getSupplierList());
		return "managePO";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rp.controller.PurchaseOrderController#setPODetails(javax.servlet.
	 * http.HttpServletRequest, org.springframework.ui.ModelMap)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@RequestMapping(value = "/addPODetails", method = RequestMethod.POST)
	@ResponseBody
	public String setPODetails(HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession(false);
		if(session == null ){
			return "redirect:/home/index.html";
		}

		
		long pid = Long.parseLong(request.getParameter("pid"));
		logger.info("++++++ pid ++++ " + pid);
		Set<PurchaseOrderDetailsDo> pocSetFromSession = (Set<PurchaseOrderDetailsDo>) session.getAttribute("PODetailsSet");
		Set<PurchaseOrderDetailsDo> updatedPOCSet = new HashSet<PurchaseOrderDetailsDo>();
		if (pid > 0) {
			if (pocSetFromSession != null) {
				for (PurchaseOrderDetailsDo poc : pocSetFromSession) {
					if (poc.getPoItemId() == pid) {
						continue;
					} else {
						updatedPOCSet.add(poc);
					}
				}
				session.setAttribute("PODetailsSet", updatedPOCSet);
			}
		} else {
			String tmpPocIdStr = request.getParameter("tmpPocId");
			logger.info("tmpPocId : " + tmpPocIdStr);
			if (tmpPocIdStr != null && !tmpPocIdStr.equals("")) {
				long tmpPocId = Long.parseLong(tmpPocIdStr);
				if (pocSetFromSession != null) {
					for (PurchaseOrderDetailsDo poc : pocSetFromSession) {
						if (poc.getTmpPoItemId() == tmpPocId) {
							continue;
						} else {
							updatedPOCSet.add(poc);
						}
					}
					session.setAttribute("PODetailsSet", updatedPOCSet);
				}
			}
		}
		PurchaseOrderDetailsDo poc = new PurchaseOrderDetailsDo();
		poc.setPoItemId(pid);
		poc.setBookName(request.getParameter("bookName"));
		poc.setOrderQuantity(Integer.parseInt(request.getParameter("orderQuantity")));
		poc.setAuthor(request.getParameter("author"));

		Set<PurchaseOrderDetailsDo> pocSet = null;
		int tmpId = 1;
		Object object = session.getAttribute("PODetailsSet");
		if (object == null) {
			pocSet = new HashSet<PurchaseOrderDetailsDo>();
			session.setAttribute("pocTmpId", "2");
			poc.setTmpPoItemId(Long.parseLong("1"));
			pocSet.add(poc);
		} else {
			tmpId = Integer.parseInt((String) session.getAttribute("pocTmpId"));
			pocSet = (Set<PurchaseOrderDetailsDo>) session.getAttribute("PODetailsSet");
			poc.setTmpPoItemId(System.currentTimeMillis());
			session.setAttribute("pocTmpId", String.valueOf(++tmpId));
			pocSet.add(poc);
		}

		session.setAttribute("PODetailsSet", pocSet);
		return String.valueOf(poc.getTmpPoItemId());
	}

	/* (non-Javadoc)
	 * @see com.rp.controller.PurchaseOrderController#addPurchaseOrder(com.rp.domainobject.PurchaseOrderDo, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest, org.springframework.ui.ModelMap)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@RequestMapping(value="/addPurchaseOrder", method=RequestMethod.POST)
	public String addPurchaseOrder(
			@ModelAttribute("poDo") PurchaseOrderDo poDo, BindingResult result,
			HttpServletRequest request, ModelMap map) {
		logger.info("<---------- add Purchase Order ---------->");
		HttpSession session = request.getSession(false);
		if(session == null ){
			return "redirect:/home/index.html";
		}

		Set<PurchaseOrderDetailsDo> poDetailsSet = (Set<PurchaseOrderDetailsDo>)session.getAttribute("PODetailsSet");
		if(poDetailsSet != null && poDetailsSet.size() > 0) {
			poDo.setPoDetails(poDetailsSet);
		}
		logger.info("Purchase Order Date String " + poDo.getPoDateString());
		
		poService.savePurchaseOrder(poDo);

		return "redirect:/po/list.html";
	}

	/* (non-Javadoc)
	 * @see com.rp.controller.PurchaseOrderController#editPOForm(com.rp.domainobject.PurchaseOrderDo, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest, org.springframework.ui.ModelMap)
	 */
	@Override
	@RequestMapping (value="/editPOForm")
	public String editPOForm(@ModelAttribute("poDo") PurchaseOrderDo poDo,
			BindingResult result, HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession(false);
		if(session == null ){
			return "redirect:/home/index.html";
		}

		PurchaseOrder po = poService.getPurchaseOrder(Long
				.parseLong(request.getParameter("poId")));
		try {
			BeanUtils.copyProperties(poDo, po);
			DateFormat formatter = new SimpleDateFormat ("MM/dd/yyyy");
			logger.info ("PO Date " + poDo.getPoDate() + " String Format " + formatter.format(poDo.getPoDate()));
			poDo.setPoDateString (formatter.format (poDo.getPoDate()));
			String poName = poDo.getPoName();
			int i = poName.lastIndexOf("/");
			if (i > 0 ) {
				poDo.setPoPrefix(poName.substring (0, (i+1)));
				poDo.setPoName(poName.substring (i+1));
				logger.info ("Po Prefix " + poDo.getPoPrefix() + " Po Name " + poDo.getPoName());
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		map.put("supplierList", supplierService.getSupplierList());
		int tmpId = 1;

		Set<PurchaseOrderDetailsDo> pocSet = new HashSet<PurchaseOrderDetailsDo>();
		for (PurchaseOrderDetails poDetails : po.getPoDetails()) {
			PurchaseOrderDetailsDo details = new PurchaseOrderDetailsDo();
			details.setPoId(poDetails.getPoId());
			details.setPoItemId(poDetails.getPoItemId());
			details.setBookName (poDetails.getBookName());
			details.setOrderQuantity(poDetails.getOrderQuantity());
			details.setAuthor(poDetails.getAuthor());
			details.setStatus(poDetails.getStatus());
			details.setTmpPoItemId(System.currentTimeMillis() + poDetails.getPoItemId());
			session.setAttribute("pocTmpId", String.valueOf(++tmpId));
			pocSet.add(details);
		}
		session.setAttribute("PODetailsSet", pocSet);
		
		return "editPO";
	}

	/* (non-Javadoc)
	 * @see com.rp.controller.PurchaseOrderController#editPO(com.rp.domainobject.PurchaseOrderDo, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest, org.springframework.ui.ModelMap)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@RequestMapping (value="/editPurchaseOrder")
	public String editPO(@ModelAttribute("poDo") PurchaseOrderDo poDo,
			BindingResult result, HttpServletRequest request, ModelMap map) {
		logger.info("<---------- Edit Purchase Order ---------->");
		HttpSession session = request.getSession(false);
		if(session == null ){
			return "redirect:/home/index.html";
		}


		Set<PurchaseOrderDetailsDo> poDetailsSet = (Set<PurchaseOrderDetailsDo>)session.getAttribute("PODetailsSet");
		if(poDetailsSet != null && poDetailsSet.size() > 0) {
			poDo.setPoDetails(poDetailsSet);
		}
		
		poService.editPurchaseOrder(poDo);

	
		
		return "redirect:/po/list.html";
	}

	/* (non-Javadoc)
	 * @see com.rp.controller.PurchaseOrderController#placePurchaseOrder(com.rp.domainobject.PurchaseOrderDo, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest, org.springframework.ui.ModelMap)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@RequestMapping (value="/placePurchaseOrder")
	public String placePurchaseOrder(
			@ModelAttribute("poDo") PurchaseOrderDo poDo, BindingResult result,
			HttpServletRequest request, ModelMap map) {
		HttpSession session = request.getSession(false);
		Set<PurchaseOrderDetailsDo> poDetailsSet = (Set<PurchaseOrderDetailsDo>)session.getAttribute("PODetailsSet");
		if(poDetailsSet != null && poDetailsSet.size() > 0) {
			poDo.setPoDetails(poDetailsSet);
		}
		poDo.setPoStatus ("1");
		String MMddyyyy_FORMAT = "MM/dd/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(MMddyyyy_FORMAT);
		try {
			poDo.setPoDate(sdf.parse (poDo.getPoDateString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("PO Date " + poDo.getPoDate());
		poService.editPurchaseOrder(poDo);
		
		Supplier supplier = supplierService.getSupplier(poDo.getSupplierId());
		Map<Object, Object> mailMap = new HashMap<Object, Object>();
		mailMessage.setTo(supplier.getEmailAddress());
		mailMap.put("contactPerson", supplier.getSupplierContact());
		mailMap.put("poDetails", poDetailsSet);
		mailMap.put ("po", poDo);
		mailMap.put ("poDate", poDo.getPoDate());
		utilityService.send(mailMessage, mailMap, "purchaseOrder.vm");

		return "redirect:/po/list.html";
	}

}
