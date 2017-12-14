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

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utility {

	public static boolean isValidEmail(String email){
		if(email == null) {
			System.out.println ("Email Address is null");
			return false;
		}
		if("".equals(email.trim()))return false;
		String regExpn = 
			"^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
			    +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
			      +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
			      +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
			      +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
			      +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
		Pattern patternObj = Pattern.compile(regExpn);
		Matcher matcherObj = patternObj.matcher(email);
        if (matcherObj.matches()){
              return true;
        }else{
              return false;
        }
	}
	
	
	public static String generatePasswordCode(){
		int size = 10;
		StringBuffer buffer = new StringBuffer();        
		for (int i = 0; i < size; i++){
			int ch = getRandomChar('0', 'z');
			if(Character.isLetterOrDigit(ch)){
				buffer.append((char)ch);
			}else{
				i--;
			}        	
		}
		return buffer.toString().toUpperCase();
	}

	public static int getRandomChar(int lo, int hi){
		java.util.Random rn = new java.util.Random();
		int n = hi - lo + 1;
		int i = rn.nextInt() % n;
		if (i < 0)
			i = -i;
		return lo + i;
	}	
}
