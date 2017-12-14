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

package com.rp.domainobject;

import java.io.Serializable;

public class CustomerOutstandingDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2250722373144644157L;

	private Long coId;
	private Double totalPurchase;
	private Double totalPayment;

	/**
	 * @return the coId
	 */
	public Long getCoId() {
		return coId;
	}

	/**
	 * @param coId
	 *            the coId to set
	 */
	public void setCoId(Long coId) {
		this.coId = coId;
	}

	/**
	 * @return the totalPurchase
	 */
	public Double getTotalPurchase() {
		return totalPurchase;
	}

	/**
	 * @param totalPurchase
	 *            the totalPurchase to set
	 */
	public void setTotalPurchase(Double totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	/**
	 * @return the totalPayment
	 */
	public Double getTotalPayment() {
		return totalPayment;
	}

	/**
	 * @param totalPayment
	 *            the totalPayment to set
	 */
	public void setTotalPayment(Double totalPayment) {
		this.totalPayment = totalPayment;
	}

}
