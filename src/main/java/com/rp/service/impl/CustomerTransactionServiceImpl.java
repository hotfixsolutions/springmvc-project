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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.dao.CustomerTransactionDAO;
import com.rp.domainobject.CustomerOutstandingDo;
import com.rp.domainobject.CustomerTransactionDetailsDo;
import com.rp.domainobject.CustomerTransactionDo;
import com.rp.entity.CustomerTransaction;
import com.rp.entity.CustomerTransactionDetails;
import com.rp.service.CustomerTransactionService;


@Service ("CustomerTransactionService")
public class CustomerTransactionServiceImpl implements
		CustomerTransactionService {
	private static Logger logger = Logger.getLogger (CustomerTransactionService.class); 

	@Autowired CustomerTransactionDAO transactionDao;
	
	/* (non-Javadoc)
	 * @see com.rp.service.CustomerTransactionService#editTransaction(com.rp.domainobject.CustomerTransactionDo)
	 */
	@Override
	public void editTransaction(CustomerTransactionDo transactionDo) {
		CustomerTransaction transaction = new CustomerTransaction ();
		transaction.setCustomerName(transactionDo.getCustomerName());
		transaction.setCustomerAddress1(transactionDo.getCustomerAddress1());
		transaction.setCustomerAddress2(transactionDo.getCustomerAddress2());
		transaction.setCustomerPhone1(transactionDo.getCustomerPhone1());
		transaction.setCustomerPhone2(transactionDo.getCustomerPhone2());
		transaction.setCity (transactionDo.getCity());
		transaction.setState (transactionDo.getState());
		transaction.setZip(transactionDo.getZip());
		transaction.setCoId (transactionDo.getCoId());
		Set<CustomerTransactionDetails> transactionDetailsSet = new HashSet<CustomerTransactionDetails>();
		for (CustomerTransactionDetailsDo transactionDetailsDo : transactionDo.getTransactionDetails()) {
			CustomerTransactionDetails transactionDetails = new CustomerTransactionDetails();
			if(transactionDetailsDo.getCodId() > 0){
				transactionDetails.setCodId(transactionDetailsDo.getCodId());
			}

			transactionDetails.setTransactionDescription(transactionDetailsDo.getTransactionDescription());
			transactionDetails.setTransactionAmount(transactionDetailsDo.getTransactionAmount());
			transactionDetails.setTransactionDate(transactionDetailsDo.getTransactionDate());
			transactionDetails.setTransactionQuantity(transactionDetailsDo.getTransactionQuantity());
			transactionDetails.setTransactionType(transactionDetailsDo.getTransactionType());
			transactionDetails.setTransactionRemarks(transactionDetailsDo.getTransactionRemarks());
			transactionDetails.setCoId(transactionDetailsDo.getCoId());
			transactionDetailsSet.add(transactionDetails);
		}
		transaction.setTransactionDetails(transactionDetailsSet);

		transactionDao.updateTransaction(transaction);
	}

	/* (non-Javadoc)
	 * @see com.rp.service.CustomerTransactionService#listTransaction()
	 */
	@Override
	public List<CustomerTransactionDo> listTransaction() {
		List<CustomerTransaction> transactions = transactionDao.listTransactions();
		logger.info ("Transaction Size " + transactions.size());
		List<CustomerTransactionDo> transactionsDo = new ArrayList<CustomerTransactionDo>();
		for (CustomerTransaction transaction : transactions) {
			CustomerTransactionDo transactionDo = new CustomerTransactionDo();
			transactionDo.setCustomerName(transaction.getCustomerName());
			transactionDo.setCustomerAddress1(transaction.getCustomerAddress1());
			transactionDo.setCustomerAddress2(transaction.getCustomerAddress2());
			transactionDo.setCustomerPhone1(transaction.getCustomerPhone1());
			transactionDo.setCustomerPhone2(transaction.getCustomerPhone2());
			transactionDo.setCity (transaction.getCity());
			transactionDo.setState (transaction.getState());
			transactionDo.setZip(transaction.getZip());
			transactionDo.setCoId (transaction.getCoId());
			
			CustomerOutstandingDo outstandingDo = new CustomerOutstandingDo();
			outstandingDo.setCoId(transaction.getCustomerOutstanding().getCoId());
			outstandingDo.setTotalPayment(transaction.getCustomerOutstanding().getTotalPayment());
			outstandingDo.setTotalPurchase(transaction.getCustomerOutstanding().getTotalPurchase());

			transactionDo.setCustomerOutstanding(outstandingDo);
			
			logger.info("Customer " + transaction.getCustomerName() + " Outstanding is [" + outstandingDo.getTotalPurchase()
					+ " - " + outstandingDo.getTotalPayment() + "]");
			
			transactionsDo.add(transactionDo);
		}
		return transactionsDo;
	}

	/* (non-Javadoc)
	 * @see com.rp.service.CustomerTransactionService#getTransaction(java.lang.Long)
	 */
	@Override
	public CustomerTransaction getTransaction(Long coId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.rp.service.CustomerTransactionService#saveTransacation(com.rp.domainobject.CustomerTransactionDo)
	 */
	@Override
	public void saveTransaction(CustomerTransactionDo transactionDo) {
		CustomerTransaction transaction = new CustomerTransaction ();
		transaction.setCustomerName(transactionDo.getCustomerName());
		transaction.setCustomerAddress1(transactionDo.getCustomerAddress1());
		transaction.setCustomerAddress2(transactionDo.getCustomerAddress2());
		transaction.setCustomerPhone1(transactionDo.getCustomerPhone1());
		transaction.setCustomerPhone2(transactionDo.getCustomerPhone2());
		transaction.setCity (transactionDo.getCity());
		transaction.setState (transactionDo.getState());
		transaction.setZip(transactionDo.getZip());
		Set<CustomerTransactionDetails> transactionDetailsSet = new HashSet<CustomerTransactionDetails>();
		for (CustomerTransactionDetailsDo transactionDetailsDo : transactionDo.getTransactionDetails()) {
			CustomerTransactionDetails transactionDetails = new CustomerTransactionDetails();
			transactionDetails.setTransactionDescription(transactionDetailsDo.getTransactionDescription());
			transactionDetails.setTransactionAmount(transactionDetailsDo.getTransactionAmount());
			transactionDetails.setTransactionDate(transactionDetailsDo.getTransactionDate());
			transactionDetails.setTransactionQuantity(transactionDetailsDo.getTransactionQuantity());
			transactionDetails.setTransactionType(transactionDetailsDo.getTransactionType());
			transactionDetails.setTransactionRemarks(transactionDetailsDo.getTransactionRemarks());
			transactionDetails.setCoId(transactionDetailsDo.getCoId());
			transactionDetailsSet.add(transactionDetails);
		}
		transaction.setTransactionDetails(transactionDetailsSet);
		
		transactionDao.saveTransaction(transaction);
	}

}
