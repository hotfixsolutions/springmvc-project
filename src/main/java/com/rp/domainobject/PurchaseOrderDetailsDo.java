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

import org.hibernate.validator.constraints.NotEmpty;

public class PurchaseOrderDetailsDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5373093553505125947L;

	/**
	 * 
	 */

	private Long poItemId;

	@NotEmpty (message="Book name cannot be left blank")
	private String bookName;

	@NotEmpty (message="Order quantity cannot be left blank")
	@Size(min=0, max=4)
	@Pattern(regexp="(^$|[0-9]{4})")
	private int orderQuantity;

	private int receivedQuantity;

	private String status;

	private long tmpPoItemId;

	private Long poId;

	private String author;

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
	 * @return the poItemId
	 */
	public Long getPoItemId() {
		return poItemId;
	}

	/**
	 * @param poItemId
	 *            the poItemId to set
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
	 * @param bookName
	 *            the bookName to set
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
	 * @param orderQuantity
	 *            the orderQuantity to set
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
	 * @param receivedQuantity
	 *            the receivedQuantity to set
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
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the tmpPoItemId
	 */
	public long getTmpPoItemId() {
		return tmpPoItemId;
	}

	/**
	 * @param tmpPoItemId
	 *            the tmpPoItemId to set
	 */
	public void setTmpPoItemId(long tmpPoItemId) {
		this.tmpPoItemId = tmpPoItemId;
	}

	/**
	 * @return the poId
	 */
	public Long getPoId() {
		return poId;
	}

	/**
	 * @param poId
	 *            the poId to set
	 */
	public void setPoId(Long poId) {
		this.poId = poId;
	}

	@Override
	public String toString() {
		return "Purchase Order Details Domain Object [poId=" + poId
				+ ",poItemID=" + poItemId + ", bookName=" + bookName
				+ ", orderQty=" + orderQuantity + "]";
	}

}
