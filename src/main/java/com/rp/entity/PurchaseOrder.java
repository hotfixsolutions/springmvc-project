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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="purchaseOrder")
public class PurchaseOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2819418385575574233L;
	
	@Id
	@GenericGenerator(name = "pkgenerator", strategy = "increment")
	@GeneratedValue(generator = "pkgenerator")
	private Long poId;
	
	@Column (name="poName")
	private String poName;
	
	@Column (name="supplierId")
	private Long supplierId;
	
	@Column (name="poDate")
	private Date poDate;
	
	@Column (name="dateCreated")
	private Date dateCreated;
	
	@Column (name="poEmailDate") 
	private Date poEmailDate;
	
	@Column (name="poGoodsReceived")
	private String poGoodsReceived;
	
	@Column (name="dateReceived")
	private Date dateReceived;
	
	@Column (name="poStatus")
	private String poStatus;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	//@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name = "poId")
	private Set<PurchaseOrderDetails> poDetails = new HashSet<PurchaseOrderDetails>();

	/**
	 * @return the poId
	 */
	public Long getPoId() {
		return poId;
	}

	/**
	 * @param poId the poId to set
	 */
	public void setPoId(Long poId) {
		this.poId = poId;
	}

	/**
	 * @return the poName
	 */
	public String getPoName() {
		return poName;
	}

	/**
	 * @param poName the poName to set
	 */
	public void setPoName(String poName) {
		this.poName = poName;
	}

	/**
	 * @return the supplierId
	 */
	public Long getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the poDate
	 */
	public Date getPoDate() {
		return poDate;
	}

	/**
	 * @param poDate the poDate to set
	 */
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the poEmailDate
	 */
	public Date getPoEmailDate() {
		return poEmailDate;
	}

	/**
	 * @param poEmailDate the poEmailDate to set
	 */
	public void setPoEmailDate(Date poEmailDate) {
		this.poEmailDate = poEmailDate;
	}

	/**
	 * @return the poGoodsReceived
	 */
	public String getPoGoodsReceived() {
		return poGoodsReceived;
	}

	/**
	 * @param poGoodsReceived the poGoodsReceived to set
	 */
	public void setPoGoodsReceived(String poGoodsReceived) {
		this.poGoodsReceived = poGoodsReceived;
	}

	/**
	 * @return the dateReceived
	 */
	public Date getDateReceived() {
		return dateReceived;
	}

	/**
	 * @param dateReceived the dateReceived to set
	 */
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	/**
	 * @return the poStatus
	 */
	public String getPoStatus() {
		return poStatus;
	}

	/**
	 * @param poStatus the poStatus to set
	 */
	public void setPoStatus(String poStatus) {
		this.poStatus = poStatus;
	}

	/**
	 * @return the poDetails
	 */
	public Set<PurchaseOrderDetails> getPoDetails() {
		return poDetails;
	}

	/**
	 * @param poDetails the poDetails to set
	 */
	public void setPoDetails(Set<PurchaseOrderDetails> poDetails) {
		this.poDetails = poDetails;
	}
	
	@Override
	public String toString() {
		return "Purchase Order [poID=" + poId + ", creationDate="
				+ dateCreated + ", PO Details =" + poDetails.size() + "]";
	}

}
