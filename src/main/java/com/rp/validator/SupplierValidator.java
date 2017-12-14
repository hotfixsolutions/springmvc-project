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
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rp.domainobject.SupplierDo;
import com.rp.util.Utility;


public class SupplierValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return SupplierDo.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object object, Errors errors) {
		SupplierDo supplier = (SupplierDo)object;
		
//		if(supplier.getEmailAddress().trim().equals("")){
//			errors.rejectValue("emailAddress", "error.email.empty");
//		} else 
		if(!Utility.isValidEmail(supplier.getEmailAddress())){
			errors.rejectValue("emailAddress", "error.invalid.email");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status",
		        "NotEmpty.supplierDO.status",
		        "Select supplier status.");
		String status = supplier.getStatus();
		if (status.equals ("-1")) {
			errors.rejectValue("status", "NotEmpty.supplierDO.status", "Select supplier status");
		}

	}

}
