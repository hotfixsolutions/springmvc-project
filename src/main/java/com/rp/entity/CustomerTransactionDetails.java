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
package com.rp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerTransactionDetails")
public class CustomerTransactionDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4884127845222460135L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long codId;
	@Column
	private String transactionDescription;
	@Column
	private double transactionAmount;
	@Column
	private Date transactionDate;
	@Column
	private String transactionType;
	@Column
	private Long coId;
	@Column
	private int transactionQuantity;
	@Column
	private String transactionRemarks;

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

}
