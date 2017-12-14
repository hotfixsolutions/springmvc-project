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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RequestDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4588121781121635204L;

	private Long requestId;

	@NotEmpty (message="Book name cannot be left blank")
	private String bookName;

	private String author;

	private String publisher;

	private String isbnCode;

	@NotEmpty (message="Requestor name is required")
	private String requestorName;

	@NotEmpty (message="Requestor phone cannot be left blank")
	@Size(min=0, max=10)
	@Pattern(regexp="(^$|[0-9]{10})")
	private String requestorPhone;

	@Email
	private String email;

	private String requestorAddress1;

	private String requestorAddress2;

	private String city;

	private String state;

	private String zip;

	private Date dateRequested;

	private Date dateOrdered;

	private String notified;

	private String delivered;
	
	//@NumberFormat(style=Style.CURRENCY)
	private double advanceAmount;

	private Long supplierId;
	private Date dateDelivered;

	/**
	 * @return the requestId
	 */
	public Long getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 *            the requestId to set
	 */
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName
	 *            the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher
	 *            the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the isbnCode
	 */
	public String getIsbnCode() {
		return isbnCode;
	}

	/**
	 * @param isbnCode
	 *            the isbnCode to set
	 */
	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	/**
	 * @return the requestorName
	 */
	public String getRequestorName() {
		return requestorName;
	}

	/**
	 * @param requestorName
	 *            the requestorName to set
	 */
	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}

	/**
	 * @return the requestorPhone
	 */
	public String getRequestorPhone() {
		return requestorPhone;
	}

	/**
	 * @param requestorPhone
	 *            the requestorPhone to set
	 */
	public void setRequestorPhone(String requestorPhone) {
		this.requestorPhone = requestorPhone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the requestorAddress1
	 */
	public String getRequestorAddress1() {
		return requestorAddress1;
	}

	/**
	 * @param requestorAddress1
	 *            the requestorAddress1 to set
	 */
	public void setRequestorAddress1(String requestorAddress1) {
		this.requestorAddress1 = requestorAddress1;
	}

	/**
	 * @return the requestorAddress2
	 */
	public String getRequestorAddress2() {
		return requestorAddress2;
	}

	/**
	 * @param requestorAddress2
	 *            the requestorAddress2 to set
	 */
	public void setRequestorAddress2(String requestorAddress2) {
		this.requestorAddress2 = requestorAddress2;
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
	 * @return the dateRquested
	 */
	public Date getDateRequested() {
		return dateRequested;
	}

	/**
	 * @param dateRquested
	 *            the dateRquested to set
	 */
	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}

	/**
	 * @return the dateOrdered
	 */
	public Date getDateOrdered() {
		return dateOrdered;
	}

	/**
	 * @param dateOrdered
	 *            the dateOrdered to set
	 */
	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	/**
	 * @return the isNotified
	 */
	public String getNotified() {
		return notified;
	}

	/**
	 * @param isNotified
	 *            the isNotified to set
	 */
	public void setNotified(String isNotified) {
		this.notified = isNotified;
	}

	/**
	 * @return the isDelivered
	 */
	public String getDelivered() {
		return delivered;
	}

	/**
	 * @param isDelivered
	 *            the isDelivered to set
	 */
	public void setDelivered(String isDelivered) {
		this.delivered = isDelivered;
	}

	/**
	 * @return the advancedAmount
	 */
	public double getAdvanceAmount() {
		return advanceAmount;
	}

	/**
	 * @param advancedAmount
	 *            the advancedAmount to set
	 */
	public void setAdvanceAmount(double advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	/**
	 * @return the supplierId
	 */
	public Long getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId
	 *            the supplierId to set
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the dateDelivered
	 */
	public Date getDateDelivered() {
		return dateDelivered;
	}

	/**
	 * @param dateDelivered the dateDelivered to set
	 */
	public void setDateDelivered(Date dateDelivered) {
		this.dateDelivered = dateDelivered;
	}

}
