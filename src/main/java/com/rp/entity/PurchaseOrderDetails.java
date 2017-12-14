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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="purchaseOrderDetails")
public class PurchaseOrderDetails {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long poItemId;

	@Column(name="bookName")
	private String bookName;
	
	@Column (name="orderQty")
	private int orderQuantity;
	
	@Column (name="receivedQty")
	private int receivedQuantity;
	
	@Column(name="status")
	private String status;
	
	@Column private Long poId;
	
	@Column private String author;
	
	/**
	 * @return the poItemId
	 */
	public Long getPoItemId() {
		return poItemId;
	}

	/**
	 * @param poItemId the poItemId to set
	 */
	public void setPoItemId(Long poItemId) {
		this.poItemId = poItemId;
	}


	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the orderQuantity
	 */
	public int getOrderQuantity() {
		return orderQuantity;
	}

	/**
	 * @param orderQuantity the orderQuantity to set
	 */
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	/**
	 * @return the receivedQuantity
	 */
	public int getReceivedQuantity() {
		return receivedQuantity;
	}

	/**
	 * @param receivedQuantity the receivedQuantity to set
	 */
	public void setReceivedQuantity(int receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
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
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Purchase Order Details [poId=" + poId + ",poItemID=" + poItemId 
				+ ", bookName=" + bookName + ", orderQty="
				+ orderQuantity + "]";
	}
	
}
