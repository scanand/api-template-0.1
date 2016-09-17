package com.soagile.api.service.impl;

import com.soagile.api.common.persistence.service.AbstractService;
import com.soagile.api.common.security.SpringSecurityUtil;
import com.soagile.api.persistence.dao.IPrincipalJpaDao;
import com.soagile.api.persistence.model.Principal;
import com.soagile.api.service.IPrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PrincipalServiceImpl extends AbstractService<Principal> implements IPrincipalService {


    @Autowired
    private IPrincipalJpaDao dao;

    @Override
    public Principal findByName(String name) {
        return dao.findByName(name);
    }

    public IPrincipalJpaDao getDao() {
        return dao;
    }

    protected JpaSpecificationExecutor<Principal> getSpecificationExecutor() {
        return dao;
    }

    @Override
    @Transactional(readOnly = true)
    public Principal getCurrentPrincipal() {
        final String principalName = SpringSecurityUtil.getNameOfCurrentPrincipal();
        return getDao().findByName(principalName);
    }
}
