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

package com.rp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rp.domainobject.RequestDo;
import com.rp.util.Utility;


public class RequestValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return RequestDo.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object object, Errors errors) {

		RequestDo bookRequest = (RequestDo) object;
		
		if (bookRequest.getEmail() != null && !bookRequest.getEmail().isEmpty()) {
			if(!Utility.isValidEmail(bookRequest.getEmail())) {
				System.out.println ("Errors With Email");
				errors.rejectValue("email", "error.invalid.email");
			}
		}
	}
}
