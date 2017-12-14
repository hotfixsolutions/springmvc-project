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

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class SupplierDo implements Serializable {

	
	private static final long serialVersionUID = 3479693770248687373L;

	private Long supplierId;

	@NotEmpty
	private String supplierName;
	@NotEmpty
	@Size(min=0, max=10)
	@Pattern(regexp="(^$|[0-9]{10})")
	private String supplierPhone1;
	private String supplierPhone2;
	private String supplierAddress1;
	private String supplierAddress2;
	private String supplierAddress3;
	private String city;
	private String state;
	private String zip;
	@NotEmpty
	@Email
	private String emailAddress;
	@NotEmpty
	private String supplierContact;
	private String status;

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
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * @param supplierName
	 *            the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * @return the supplierPhone1
	 */
	public String getSupplierPhone1() {
		return supplierPhone1;
	}

	/**
	 * @param supplierPhone1
	 *            the supplierPhone1 to set
	 */
	public void setSupplierPhone1(String supplierPhone1) {
		this.supplierPhone1 = supplierPhone1;
	}

	/**
	 * @return the supplierPhone2
	 */
	public String getSupplierPhone2() {
		return supplierPhone2;
	}

	/**
	 * @param supplierPhone2
	 *            the supplierPhone2 to set
	 */
	public void setSupplierPhone2(String supplierPhone2) {
		this.supplierPhone2 = supplierPhone2;
	}

	/**
	 * @return the supplierAddress1
	 */
	public String getSupplierAddress1() {
		return supplierAddress1;
	}

	/**
	 * @param supplierAddress1
	 *            the supplierAddress1 to set
	 */
	public void setSupplierAddress1(String supplierAddress1) {
		this.supplierAddress1 = supplierAddress1;
	}

	/**
	 * @return the supplierAddress2
	 */
	public String getSupplierAddress2() {
		return supplierAddress2;
	}

	/**
	 * @param supplierAddress2
	 *            the supplierAddress2 to set
	 */
	public void setSupplierAddress2(String supplierAddress2) {
		this.supplierAddress2 = supplierAddress2;
	}

	/**
	 * @return the supplierAddress3
	 */
	public String getSupplierAddress3() {
		return supplierAddress3;
	}

	/**
	 * @param supplierAddress3
	 *            the supplierAddress3 to set
	 */
	public void setSupplierAddress3(String supplierAddress3) {
		this.supplierAddress3 = supplierAddress3;
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
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the supplierContact
	 */
	public String getSupplierContact() {
		return supplierContact;
	}

	/**
	 * @param supplierContact
	 *            the supplierContact to set
	 */
	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
