package com.soagile.api.persistence.dao;

import com.soagile.api.common.interfaces.IByNameApi;
import com.soagile.api.persistence.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by soagile-pc on 16/08/2016.
 */
public interface IPrivilegeJpaDao extends JpaRepository<Privilege, Long> , JpaSpecificationExecutor<Privilege>, IByNameApi<Privilege> {
}
