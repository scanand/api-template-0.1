package com.soagile.api.service.impl;

import com.soagile.api.common.persistence.service.AbstractService;
import com.soagile.api.persistence.dao.IRoleJpaDao;
import com.soagile.api.persistence.model.Role;
import com.soagile.api.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by soagile-pc on 10/08/2016.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements IRoleService {


    @Autowired
    private IRoleJpaDao dao;

    public RoleServiceImpl() {
        super();
    }

    // API

    // get/find

    @Override
    public Role findByName(final String name) {
        return getDao().findByName(name);
    }

    // create

    @Override
    public Role create(final Role entity) {
        return super.create(entity);
    }

    // Spring

    @Override
    protected final IRoleJpaDao getDao() {
        return dao;
    }

    protected JpaSpecificationExecutor<Role> getSpecificationExecutor() {
        return dao;
    }
}
