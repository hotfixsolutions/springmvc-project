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

package com.rp.dao;

import java.util.List;

import com.rp.entity.CustomerTransaction;
import com.rp.entity.CustomerTransactionDetails;


public interface CustomerTransactionDAO {
	public void saveTransaction(CustomerTransaction transaction);
	public void updateTransaction(CustomerTransaction transaction);
	public List<CustomerTransaction> listTransactions ();
	public CustomerTransaction getTransaction (Long coId);
	public void saveTransactionDetails (CustomerTransactionDetails transactionDetails);
	public void updateTransactionDetails (CustomerTransactionDetails transactionDetails);
	public CustomerTransactionDetails getTransactionDetails (Long codId);

}
