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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "customerOutstanding")
@Immutable
public class CustomerOutstanding implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3866352155327007521L;

	@Id
	@Column
	private Long coId;

	@Column
	private Double totalPurchase;
	@Column
	private Double totalPayment;

	/**
	 * @return the coId
	 */
	public Long getCoId() {
		return coId;
	}

	/**
	 * @return the totalPurchase
	 */
	public Double getTotalPurchase() {
		return totalPurchase;
	}

	/**
	 * @return the totalPayment
	 */
	public Double getTotalPayment() {
		return totalPayment;
	}

}
