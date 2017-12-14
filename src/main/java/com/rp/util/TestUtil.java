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
package com.rp.util;


public class TestUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "65";
		//int i = 5;
		
		System.out.println ("String Padding " + String.format ("%05d", Integer.parseInt(s)));
		//System.out.println ("String Padding " + String.format ("%05d", i));

	}

}
