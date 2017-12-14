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

package com.rp.dao;

import java.util.List;

import com.rp.entity.State;


public interface UtilityDAO {

	/**
	 * This method will get the state name and state code.
	 * @return the list of state
	 */
	public List<State> getStateList();
	
	
	/**
	 * This method will get state code as a request and get the corresponding state name.
	 * @param stateCode
	 * @return the state name
	 */
	public State getStateName(String stateCode);
	

}
