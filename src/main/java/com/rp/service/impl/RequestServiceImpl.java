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

package com.rp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.dao.RequestDAO;
import com.rp.domainobject.RequestDo;
import com.rp.entity.Request;
import com.rp.service.RequestService;

@Service ("RequestService")

public class RequestServiceImpl implements RequestService {
	
	private static Logger logger = Logger.getLogger (RequestService.class); 

	@Autowired
	private RequestDAO bookRequestDAO;

	@Override
	public void addRequest(RequestDo bookRequestDO) {
		Request bookRequest = new Request();
		bookRequest.setBookName(bookRequestDO.getBookName());
		bookRequest.setRequestorName(bookRequestDO.getRequestorName());
		bookRequest.setRequestorPhone(bookRequestDO.getRequestorPhone());
		bookRequest.setEmail(bookRequestDO.getEmail());
		bookRequest.setAuthor(bookRequestDO.getAuthor());
		bookRequest.setIsbnCode(bookRequestDO.getIsbnCode());
		bookRequest.setPublisher(bookRequest.getPublisher());
		bookRequest.setAdvanceAmount(bookRequestDO.getAdvanceAmount());
		bookRequest.setDateRequested(new Date());
		bookRequest.setRequestorAddress1(bookRequestDO.getRequestorAddress1());
		bookRequest.setRequestorAddress2(bookRequestDO.getRequestorAddress2());
		bookRequest.setCity(bookRequestDO.getCity());
		bookRequest.setState(bookRequestDO.getState());
		bookRequest.setZip(bookRequestDO.getZip());
		bookRequest.setSupplierId(bookRequestDO.getSupplierId());
		bookRequest.setNotified(bookRequestDO.getNotified());
		bookRequest.setDelivered(bookRequestDO.getDelivered());
	
		bookRequestDAO.addRequest(bookRequest);
		
	}

	@Override
	public void editRequest(RequestDo bookRequestDO) {
		Request bookRequest = bookRequestDAO.getRequest(bookRequestDO.getRequestId());
		bookRequest.setBookName(bookRequestDO.getBookName());
		bookRequest.setRequestorName(bookRequestDO.getRequestorName());
		bookRequest.setRequestorPhone(bookRequestDO.getRequestorPhone());
		bookRequest.setEmail(bookRequestDO.getEmail());
		bookRequest.setAuthor(bookRequestDO.getAuthor());
		bookRequest.setIsbnCode(bookRequestDO.getIsbnCode());
		bookRequest.setPublisher(bookRequestDO.getPublisher());
		bookRequest.setAdvanceAmount(bookRequestDO.getAdvanceAmount());
		bookRequest.setRequestorAddress1(bookRequestDO.getRequestorAddress1());
		bookRequest.setRequestorAddress2(bookRequestDO.getRequestorAddress2());
		bookRequest.setCity(bookRequestDO.getCity());
		bookRequest.setState(bookRequestDO.getState());
		bookRequest.setZip(bookRequestDO.getZip());
		bookRequest.setSupplierId(bookRequestDO.getSupplierId());
		bookRequest.setDateOrdered(bookRequestDO.getDateOrdered());
		bookRequest.setNotified(bookRequestDO.getNotified());
		bookRequest.setDelivered (bookRequestDO.getDelivered());
		logger.info("Deliverd " + bookRequestDO.getDelivered());
		if (bookRequestDO.getDelivered().equals ("1")) {
			logger.info("In");
			bookRequest.setDateDelivered(new Date());
		}
		//bookRequest.setDateRequested(bookRequestDO.getDateRequested());
		
		bookRequestDAO.editRequest(bookRequest);
	}

	@Override
	public List<RequestDo> getRequests() {
		List<RequestDo> requestDOList = new ArrayList<RequestDo> ();
		RequestDo requestDO;
		List<Request> requestList = bookRequestDAO.getRequests();
		for (Request bookRequest : requestList) {
			requestDO = new RequestDo ();
			requestDO.setRequestId(bookRequest.getRequestId());
			requestDO.setBookName(bookRequest.getBookName());
			requestDO.setRequestorName(bookRequest.getRequestorName());
			requestDO.setRequestorPhone(bookRequest.getRequestorPhone());
			requestDO.setEmail(bookRequest.getEmail());
			requestDO.setAuthor(bookRequest.getAuthor());
			requestDO.setIsbnCode(bookRequest.getIsbnCode());
			requestDO.setPublisher(requestDO.getPublisher());
			requestDO.setAdvanceAmount(bookRequest.getAdvanceAmount());
			requestDO.setRequestorAddress1(bookRequest.getRequestorAddress1());
			requestDO.setRequestorAddress2(bookRequest.getRequestorAddress2());
			requestDO.setCity(bookRequest.getCity());
			requestDO.setState(bookRequest.getState());
			requestDO.setZip(bookRequest.getZip());
			requestDO.setSupplierId(bookRequest.getSupplierId());
			requestDO.setDateOrdered(bookRequest.getDateOrdered());
			requestDO.setDateRequested(bookRequest.getDateRequested());
			requestDO.setNotified(bookRequest.getNotified());
			requestDO.setDelivered (bookRequest.getDelivered());
			
			requestDOList.add (requestDO);
		}
		return requestDOList;
	}

	@Override
	public Request getRequest(Long requestId) {
		return bookRequestDAO.getRequest(requestId);
	}

	@Override
	public List<RequestDo> filterRequest(String bookName,
			String requestorName) {
		List<RequestDo> requestDOList = new ArrayList<RequestDo> ();
		RequestDo requestDO;
		List<Request> requestList = bookRequestDAO.filterRequest(bookName, requestorName);
		for (Request bookRequest : requestList) {
			requestDO = new RequestDo ();
			requestDO.setRequestId(bookRequest.getRequestId());
			requestDO.setBookName(bookRequest.getBookName());
			requestDO.setRequestorName(bookRequest.getRequestorName());
			requestDO.setRequestorPhone(bookRequest.getRequestorPhone());
			requestDO.setEmail(bookRequest.getEmail());
			requestDO.setAuthor(bookRequest.getAuthor());
			requestDO.setIsbnCode(bookRequest.getIsbnCode());
			requestDO.setPublisher(requestDO.getPublisher());
			requestDO.setAdvanceAmount(bookRequest.getAdvanceAmount());
			requestDO.setRequestorAddress1(bookRequest.getRequestorAddress1());
			requestDO.setRequestorAddress2(bookRequest.getRequestorAddress2());
			requestDO.setCity(bookRequest.getCity());
			requestDO.setState(bookRequest.getState());
			requestDO.setZip(bookRequest.getZip());
			requestDO.setSupplierId(bookRequest.getSupplierId());
			requestDO.setDateOrdered(bookRequest.getDateOrdered());
			requestDO.setNotified(bookRequest.getNotified());
			requestDO.setDelivered (bookRequest.getDelivered());
			requestDO.setDateDelivered(bookRequest.getDateDelivered());
			
			requestDOList.add (requestDO);
		}
		
		logger.info ("Request List Size " + requestDOList.size());
		
		return requestDOList;
	}
	
}
