package com.soagile.api.common.persistence.service;

import com.soagile.api.common.interfaces.IOperations;
import com.soagile.api.common.persistence.model.IEntity;
import org.springframework.data.domain.Page;

/**
 * Created by BMGTS on 22/03/2016.
 */
public interface IRawService<T extends IEntity> extends IOperations<T>
{
    Page<T> findAllPaginatedAndSortedRaw ( final int page, final int size, final String sortBy, final String sortOrder);
}
