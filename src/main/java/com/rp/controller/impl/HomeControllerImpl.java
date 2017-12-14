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
package com.rp.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rp.controller.HomeController;

@Controller ("HomeController")
@RequestMapping("/home")
public class HomeControllerImpl implements HomeController {

	/* (non-Javadoc)
	 * @see com.rp.controller.HomeController#home(org.springframework.ui.ModelMap)
	 */
	@RequestMapping("/index.html")
	public String home(ModelMap map) {
		return "adminHome";
	}

}
