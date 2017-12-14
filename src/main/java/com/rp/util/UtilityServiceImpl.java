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

import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.rp.dao.UtilityDAO;
import com.rp.entity.State;
import com.rp.service.UtilityService;

@Service("UtilityService")
public class UtilityServiceImpl implements UtilityService {

	@Autowired
	private UtilityDAO utilityDAO;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;
	@Autowired
	private JavaMailSender mailSenderGmail;

	@Override
	public List<State> getStateList() {
		return utilityDAO.getStateList();
	}

	@Override
	public boolean sendMail(String fromAddress, String toAddress,
			String emailText, String subject) {
		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, false);
			helper.setFrom(fromAddress);
			helper.setSubject(subject);
			helper.setTo(toAddress);
			helper.setText(emailText, true);

			mailSender.send(helper.getMimeMessage());
			return true;
		} catch (MailException ex) {
			// log it and go on
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
    /**
     * Sends e-mail using Velocity template for the body and 
     * the properties passed in as Velocity variables.
     * 
     * @param   msg                 The e-mail message to be sent, except for the body.
     * @param   hTemplateVariables  Variables to use when processing the template. 
     */
	@Override
    public void send(final SimpleMailMessage msg, 
                     final Map<Object, Object> hTemplateVariables, final String template) {
        System.out.println ("In Mail Send");

		MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
               message.setTo(msg.getTo());
               message.setFrom(msg.getFrom());
               message.setSubject(msg.getSubject());
               System.out.println ("body={} before ");
               String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, hTemplateVariables);
               
               System.out.println ("body={}" +  body);

               message.setText(body, true);
            }
         };
         
         mailSenderGmail.send(preparator);
        
        System.out.println ("Sent e-mail to " +  msg.getTo().toString());
    }
}
