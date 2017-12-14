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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.rp.dao.UtilityDAO;
import com.rp.entity.State;

public class ApplicationCacheServlet extends HttpServlet {

	private static final long serialVersionUID = 6216790912125747028L;

//	protected final static Logger log = Logger
//			.getLogger(ApplicationCacheServlet.class);
	private static ServletContext context = null;
	private static UtilityDAO utilityDAO;
	private static Map<String, Object> constantsMap = new HashMap<String, Object>();

	// contain the role as key and respective url list as value.
	private static Map<String, List<String>> roleUrlMasterMap;

	private static String admin = "tR System Administrators";
	private static String customer = "Customer Administrator";
	private static String giveaway = "Giveaway Administrator";
	private static String annonymousRole = "ROLE_ANONYMOUS";
	private static String userAccountAdmin = "tR User Account Administrator";

	@Override
	public void init() throws ServletException {
		super.init();
//		if (log.isDebugEnabled()) {
//			log.debug("ApplicationCacheServlet.init()");
//		}

		context = getServletContext();
		ApplicationContext springAppContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext());
		utilityDAO = (UtilityDAO) springAppContext.getBean("UtilityDAO");

		setStates();
		setSystemParameterCache();
		setRolesName();
		setUrlMasterCache();

	}

	public static void setStates() {
		List<State> stateList = utilityDAO.getStateList();
		constantsMap.put("stateList", stateList);
		context.setAttribute("constantsMap", constantsMap);
	}

	public static void setSystemParameterCache() {
		// List<SystemParameter> systemParameters=
		// systemParameterDAO.getAllSystemParameters();
		// for (Iterator<SystemParameter> iterator =
		// systemParameters.iterator(); iterator.hasNext();) {
		// SystemParameter parameter = (SystemParameter) iterator.next();
		// constantsMap.put(parameter.getParamName(),
		// parameter.getCurrentValue());
		// }
		// context.setAttribute("constantsMap", constantsMap);
	}

	public static void setRolesName() {
		context.setAttribute("adminRole", admin);
		context.setAttribute("customerRole", customer);
		context.setAttribute("giveawayRole", giveaway);
		context.setAttribute("userAccountAdmin", userAccountAdmin);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getConstantMap() {
		return (Map<String, Object>) context.getAttribute("constantsMap");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String syncStatus = syncParameter();
		response.sendRedirect(context.getContextPath()
				+ "/system/showParameter.html?syncStatus=" + syncStatus);

	}

	@Override
	public void destroy() {
		super.destroy();
	}

	public static void setUrlMasterCache() {
		roleUrlMasterMap = new HashMap<String, List<String>>();
		//
		// List< String> list = urlMasterAccessDAO.getUrlsForRole(admin);
		// roleUrlMasterMap.put(admin, list);
		//
		// List< String> list1 = urlMasterAccessDAO.getUrlsForRole(giveaway );
		// roleUrlMasterMap.put(giveaway, list1);
		//
		// List< String> list2 = urlMasterAccessDAO.getUrlsForRole(customer);
		// roleUrlMasterMap.put(customer , list2);
		//
		// List< String> list3 =
		// urlMasterAccessDAO.getUrlsForRole(annonymousRole);
		// roleUrlMasterMap.put(annonymousRole, list3);
		//
		// List< String> list4 =
		// urlMasterAccessDAO.getUrlsForRole(userAccountAdmin);
		// roleUrlMasterMap.put(userAccountAdmin, list4);
		//

	}

	public static List<String> getUrlListForRoles(String roles) {
		List<String> list = new ArrayList<String>();

		if (roles.contains(admin))
			list.addAll(roleUrlMasterMap.get(admin));

		if (roles.contains(giveaway))
			list.addAll(roleUrlMasterMap.get(giveaway));

		if (roles.contains(customer))
			list.addAll(roleUrlMasterMap.get(customer));

		if (roles.contains(annonymousRole))
			list.addAll(roleUrlMasterMap.get(annonymousRole));

		if (roles.contains(userAccountAdmin))
			list.addAll(roleUrlMasterMap.get(userAccountAdmin));

		return list;
	}

	public static void setRetailChain() {
		// List<CustomerType> customerTypes = utilityDAO.getRetailChain();
		// constantsMap.put("customerTypeList", customerTypes);
		// context.setAttribute("constantsMap", constantsMap);
	}

	public static String syncParameter() {
		String syncStatus = "";
//		if (log.isDebugEnabled()) {
//			log.debug("-------------- SyncParameter() called--------------------");
//		}
		// List<SystemParameter> systemParameters =
		// systemParameterDAO.getSystemParameterNeedToSyncList();
		// if(systemParameters != null && systemParameters.size() > 0){
		// if(log.isDebugEnabled()){
		// log.debug("-------------- SyncParameter found--------------------");
		// }
		// setSystemParameterCache();
		// if(log.isDebugEnabled()){
		// log.debug("-------------- SyncParameters updated--------------------");
		// }
		// // added by amrish to load new entries from database .
		// setStates();
		// setSystemParameterCache();
		// setRolesName();
		// setUrlMasterCache();
		// // End Add section by Amrish
		//
		// // update the current date to system parameter if mobile or server
		// parameter need to be synchronised
		// SystemParameter systemParameter =
		// systemParameterDAO.getSystemParameter("SYSTEM_PARAM_SYNCHRONISED_TIME");
		// if(systemParameter != null){
		// SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		// systemParameter.setCurrentValue(fmt.format(new Date()));
		// systemParameterDAO.updateSystemParameterValue(systemParameter);
		// }
		// syncStatus = "Synchronization Done!";
		// }else{
		// // send message that no parameter need to synchronize
		// syncStatus = "No parameter to sync";
		// }
		return syncStatus;
	}
}
