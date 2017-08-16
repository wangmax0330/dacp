package com.pikia.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pikia.component.service.ModelCrudService;
import com.pikia.component.web.controller.ModelCrudControllerSupport;
import com.pikia.component.web.service.SystemUserService;
import com.pikia.component.web.util.MD5Util;
import com.pikia.component.web.util.ResponseUtils;
import com.pikia.system.domain.SystemUserDomain;

@Controller
public class SystemUserController extends ModelCrudControllerSupport {
	protected final Logger logger = Logger.getLogger(SystemUserController.class);
	@Resource
	private SystemUserService systemUserService;

	@RequestMapping(value = { "/d-front/company/login" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			if ((StringUtils.isNotBlank(userName)) && (StringUtils.isNotBlank(password))) {
				SystemUserDomain user = this.systemUserService.authenticate(userName, password);
				if (user == null) {
					user = this.systemUserService.authenticate(userName,
							MD5Util.getMD5ofStr(password));
				}
				if ((user != null) && ((user.isAdmin()))) {
					this.sessionService.setCurrentUser(request.getSession(), user);
					int role = 0;
					if (user.isAdmin()) {
						role = 1;
					}
					ResponseUtils.writeMessage(response, "{\"isSuc\":1,\"uid\":" + user.getId()
							+ ",\"role\":" + role + "}");
				} else {
					ResponseUtils.writeJsonErrorMessage(response, "请求成功", new String[] { "" });
				}
			}
		} catch (Exception ex) {
			this.logger.error("Error occurred in method login", ex);
			ResponseUtils.writeJsonErrorMessage(response, ex.getMessage(), new String[] { "" });
		}
	}

	@RequestMapping(value = { "/d-front/logout" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			// SystemUserDomain sessionUser = (SystemUserDomain)
			// this.sessionService.getCurrentUser(
			// request, SystemUserDomain.class);
			// if (sessionUser == null) {
			// return "/login";
			// }
			// sessionUser.setInitialized(true);
			this.sessionService.setCurrentUser(request.getSession(), null);
		} catch (Exception e) {
			this.logger.error(e, e);
		}
		return "/login";
	}

	@Override
	protected ModelCrudService getModelCrudService() {
		return null;
	}
}
