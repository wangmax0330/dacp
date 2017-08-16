package com.pikia.component.web.service;

import com.pikia.component.service.ModelCrudService;
import com.pikia.system.domain.SystemUserDomain;

public interface SystemUserService extends ModelCrudService {
	public SystemUserDomain authenticate(String company, String userName, String password);

	public SystemUserDomain authenticate(String userName, String pwd);
}
