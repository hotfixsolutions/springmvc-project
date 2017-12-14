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
import java.util.Map;

import org.springframework.mail.SimpleMailMessage;

import com.rp.entity.State;

public interface UtilityService {

	public List<State> getStateList();

	public boolean sendMail(String fromAddress, String toAddress,
			String emailText, String subject);
	
	public void send (final SimpleMailMessage msg, 
                     final Map<Object, Object> hTemplateVariables, final String template);
}
