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

package com.rp.service;

import java.util.List;

import com.rp.domainobject.RequestDo;
import com.rp.entity.Request;


public interface RequestService {
	public void addRequest (RequestDo bookRequest);
	
	public void editRequest (RequestDo bookRequest);
	
	public List<RequestDo> getRequests ();
	
	public Request getRequest (Long requestId);
	
	public List<RequestDo> filterRequest (String bookName, String requestorName);

}
