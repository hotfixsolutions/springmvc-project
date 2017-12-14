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


public class PurchaseOrderDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -654015471680139008L;
	private Long poId;
	
	private String poName;
	
	private Long supplierId;
	
	private Date poDate;
	
	private Date dateCreated;
	
	private Date poEmailDate;
	
	private String poGoodsReceived;
	
	private Date dateReceived;
	
	private String poStatus;
	
	private String poDateString;
	
	private String poPrefix;
	
	private Set<PurchaseOrderDetailsDo> poDetails = new HashSet<PurchaseOrderDetailsDo>();

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
	public Set<PurchaseOrderDetailsDo> getPoDetails() {
		return poDetails;
	}

	/**
	 * @param poDetails the poDetails to set
	 */
	public void setPoDetails(Set<PurchaseOrderDetailsDo> poDetails) {
		this.poDetails = poDetails;
	}
	
	/**
	 * @return the poDateString
	 */
	public String getPoDateString() {
		return poDateString;
	}

	/**
	 * @param poDateString the poDateString to set
	 */
	public void setPoDateString(String poDateString) {
		this.poDateString = poDateString;
	}

	/**
	 * @return the poPrefix
	 */
	public String getPoPrefix() {
		return poPrefix;
	}

	/**
	 * @param poPrefix the poPrefix to set
	 */
	public void setPoPrefix(String poPrefix) {
		this.poPrefix = poPrefix;
	}

	@Override
	public String toString() {
		return "Purchase Order Domain Object [poID=" + poId + ", poName=" + poName + ", creationDate="
				+ dateCreated + ", PO Details =" + poDetails.size()  + "]";
	}

}
