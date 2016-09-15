package com.soagile.api.persistence.dao;

import com.soagile.api.common.interfaces.IByNameApi;
import com.soagile.api.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by soagile-pc on 10/08/2016.
 */
public interface IRoleJpaDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>, IByNameApi<Role> {

}