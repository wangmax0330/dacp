package com.pikia.component.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pikia.component.pagination.PaginationQueryContext;
import com.pikia.component.repository.ModelRepository;
import com.pikia.component.service.impl.ModelCrudServiceSupport;
import com.pikia.component.web.service.SystemUserService;
import com.pikia.system.domain.SystemUserDomain;
import com.pikia.system.repository.SystemUserRepository;

@Service
public class SystemUserServiceImpl extends ModelCrudServiceSupport implements SystemUserService {

	@Resource
	protected SystemUserRepository systemUserRepository;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Object getModel(Long id) {
		if (id == null || id.longValue() == 0) return null;
		// SystemUserDomain domain = (SystemUserDomain) modelContainer.getModel(
		// ModelUtils.asModelKey(ApsUserDomain.class, id), domainModelLoader,
		// false);
		SystemUserDomain userDomain = systemUserRepository.get(id);
		if (userDomain != null) userDomain.setInitialized(true);
		return userDomain;
	}

	@Override
	public List getPagedModelIds(PaginationQueryContext queryContext) {
		return null;
	}

	@Override
	public int getTotalCount(PaginationQueryContext queryContext) {
		return 0;
	}

	@Override
	protected ModelRepository getModelRepository() {
		return this.systemUserRepository;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public SystemUserDomain authenticate(String userName, String pwd) {
		SystemUserDomain userDomain = (SystemUserDomain) getModel(systemUserRepository.authUser(
				userName, pwd));
		if (userDomain != null) {
			return userDomain;
		} else {
			return null;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public SystemUserDomain authenticate(String company, String userName, String password) {
		SystemUserDomain userDomain = (SystemUserDomain) getModel(systemUserRepository.authUser(
				userName, password));
		if (userDomain != null) {
			// modelContainer.addModel(ModelUtils.asModelKey(ApsUserDomain.class,
			// userDomain.getId()),
			// userDomain, false);
			return userDomain;
		} else {
			return null;
		}
	}

	@Override
	public Object get(Long paramLong) {
		return null;
	}

}
