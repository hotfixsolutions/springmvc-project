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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CustomerTransactionDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 510726956747500893L;
	/**
	 * 
	 */

	private Long coId;
	private String customerName;
	private String customerPhone1;
	private String customerPhone2;
	private String customerAddress1;
	private String customerAddress2;
	private String city;
	private String state;
	private String zip;
	private Date dateCreated;
	private Double outstandingAmount;
	private CustomerOutstandingDo customerOutstanding;

	private Set<CustomerTransactionDetailsDo> transactionDetails = new HashSet<CustomerTransactionDetailsDo>();

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
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerPhone1
	 */
	public String getCustomerPhone1() {
		return customerPhone1;
	}

	/**
	 * @param customerPhone1
	 *            the customerPhone1 to set
	 */
	public void setCustomerPhone1(String customerPhone1) {
		this.customerPhone1 = customerPhone1;
	}

	/**
	 * @return the customerPhone2
	 */
	public String getCustomerPhone2() {
		return customerPhone2;
	}

	/**
	 * @param customerPhone2
	 *            the customerPhone2 to set
	 */
	public void setCustomerPhone2(String customerPhone2) {
		this.customerPhone2 = customerPhone2;
	}

	/**
	 * @return the customerAddress1
	 */
	public String getCustomerAddress1() {
		return customerAddress1;
	}

	/**
	 * @param customerAddress1
	 *            the customerAddress1 to set
	 */
	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	/**
	 * @return the customerAddress2
	 */
	public String getCustomerAddress2() {
		return customerAddress2;
	}

	/**
	 * @param customerAddress2
	 *            the customerAddress2 to set
	 */
	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *            the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the transactionDetails
	 */
	public Set<CustomerTransactionDetailsDo> getTransactionDetails() {
		return transactionDetails;
	}

	/**
	 * @param transactionDetails
	 *            the transactionDetails to set
	 */
	public void setTransactionDetails(
			Set<CustomerTransactionDetailsDo> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	
	/**
	 * @return the outstandingAmount
	 */
	public Double getOutstandingAmount() {
		return outstandingAmount;
	}

	/**
	 * @param outstandingAmount the outstandingAmount to set
	 */
	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	/**
	 * @return the customerOutstanding
	 */
	public CustomerOutstandingDo getCustomerOutstanding() {
		return customerOutstanding;
	}

	/**
	 * @param customerOutstanding the customerOutstanding to set
	 */
	public void setCustomerOutstanding(CustomerOutstandingDo customerOutstanding) {
		this.customerOutstanding = customerOutstanding;
	}

}