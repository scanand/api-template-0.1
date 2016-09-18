package com.soagile.api.service.impl;

import com.soagile.api.common.persistence.service.AbstractService;
import com.soagile.api.persistence.dao.IPrivilegeJpaDao;
import com.soagile.api.persistence.model.Principal;
import com.soagile.api.persistence.model.Privilege;
import com.soagile.api.service.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by soagile-pc on 16/08/2016.
 */
@Service
@Transactional
public class PrivilegeServiceImpl extends AbstractService<Privilege> implements IPrivilegeService {

    @Autowired
    private IPrivilegeJpaDao dao;

    @Override
    public Privilege findByName(final String name) {
        return dao.findByName(name);
    }

    // TODO: 16/08/2016 is return type just JPADao or pagingAndsortinRepository
    @Override
    protected final IPrivilegeJpaDao getDao() {
        return dao;
    }

    protected JpaSpecificationExecutor<Privilege> getSpecificationExecutor() {
        return dao;
    }

}
