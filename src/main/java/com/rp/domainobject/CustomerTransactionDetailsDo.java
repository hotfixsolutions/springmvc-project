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

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class CustomerTransactionDetailsDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5950153317275160444L;
	/**
	 * 
	 */

	private Long codId;
	@NotEmpty (message="Description cannot be left blank")
	private String transactionDescription;
	private double transactionAmount;
	private Date transactionDate;
	private String transactionType;
	private Long coId;
	private Long codTmpId;
	@NotEmpty (message="Order quantity cannot be left blank")
	@Size(min=0, max=4)
	@Pattern(regexp="(^$|[0-9]{4})")
	private int transactionQuantity;
	private String transactionRemarks;
	private String transactionDateString;

	/**
	 * @return the codId
	 */
	public Long getCodId() {
		return codId;
	}

	/**
	 * @param codId
	 *            the codId to set
	 */
	public void setCodId(Long codId) {
		this.codId = codId;
	}

	/**
	 * @return the transactionDescription
	 */
	public String getTransactionDescription() {
		return transactionDescription;
	}

	/**
	 * @param transactionDescription
	 *            the transactionDescription to set
	 */
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	/**
	 * @return the transactionAmount
	 */
	public double getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount
	 *            the transactionAmount to set
	 */
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate
	 *            the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType
	 *            the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

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
	 * @return the codTmpId
	 */
	public Long getCodTmpId() {
		return codTmpId;
	}

	/**
	 * @param codTmpId
	 *            the codTmpId to set
	 */
	public void setCodTmpId(Long codTmpId) {
		this.codTmpId = codTmpId;
	}

	/**
	 * @return the transactionQuantity
	 */
	public int getTransactionQuantity() {
		return transactionQuantity;
	}

	/**
	 * @param transactionQuantity
	 *            the transactionQuantity to set
	 */
	public void setTransactionQuantity(int transactionQuantity) {
		this.transactionQuantity = transactionQuantity;
	}

	/**
	 * @return the transactionRemarks
	 */
	public String getTransactionRemarks() {
		return transactionRemarks;
	}

	/**
	 * @param transactionRemarks
	 *            the transactionRemarks to set
	 */
	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}

	/**
	 * @return the transactionDateString
	 */
	public String getTransactionDateString() {
		return transactionDateString;
	}

	/**
	 * @param transactionDateString the transactionDateString to set
	 */
	public void setTransactionDateString(String transactionDateString) {
		this.transactionDateString = transactionDateString;
	}

}
