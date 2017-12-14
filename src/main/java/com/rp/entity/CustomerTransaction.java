/**
 * 
 */
package com.rp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customerTransaction")
public class CustomerTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4289133410803534605L;

	@Id
	@GenericGenerator(name = "pkgenerator", strategy = "increment")
	@GeneratedValue(generator = "pkgenerator")
	private Long coId;
	@Column
	private String customerName;
	@Column
	private String customerPhone1;
	@Column
	private String customerPhone2;
	@Column
	private String customerAddress1;
	@Column
	private String customerAddress2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zip;
	@Column
	private Date dateCreated;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "coId")
	private CustomerOutstanding customerOutstanding;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name = "coId")
	private Set<CustomerTransactionDetails> transactionDetails = new HashSet<CustomerTransactionDetails>();

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
	public Set<CustomerTransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}

	/**
	 * @param transactionDetails
	 *            the transactionDetails to set
	 */
	public void setTransactionDetails(
			Set<CustomerTransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	/**
	 * @return the customerOutstanding
	 */
	public CustomerOutstanding getCustomerOutstanding() {
		return customerOutstanding;
	}

	/**
	 * @param customerOutstanding
	 *            the customerOutstanding to set
	 */
	public void setCustomerOutstanding(CustomerOutstanding customerOutstanding) {
		this.customerOutstanding = customerOutstanding;
	}

	/**
	 * @return the outstandingAmount
	 */

	@Override
	public String toString() {
		return "CustomerTransaction [CustomerName=" + customerName
				+ ", Outstanding=]";
	}

}