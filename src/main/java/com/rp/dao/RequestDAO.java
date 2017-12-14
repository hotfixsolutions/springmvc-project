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

import com.rp.entity.Request;


public interface RequestDAO {
	public void addRequest (Request bookRequest);
	
	public void editRequest (Request bookRequest);
	
	public List<Request> getRequests();
	
	public Request getRequest (Long requestId);
	
	public List<Request> filterRequest(String bookName, String requestorName);
}
