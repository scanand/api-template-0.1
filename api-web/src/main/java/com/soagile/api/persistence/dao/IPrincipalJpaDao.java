package com.soagile.api.persistence.dao;

import com.soagile.api.common.interfaces.IByNameApi;
import com.soagile.api.persistence.model.Principal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by soagile-pc on 8/08/2016.
 */
public interface IPrincipalJpaDao extends JpaRepository<Principal, Long>, JpaSpecificationExecutor<Principal>, IByNameApi<Principal> {
}
