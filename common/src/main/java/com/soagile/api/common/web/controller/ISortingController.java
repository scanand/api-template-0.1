package com.soagile.api.common.web.controller;

import com.soagile.api.common.persistence.model.IEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by BMGTS on 22/03/2016.
 */
public interface ISortingController<T extends IEntity>
{
    public List<T> findAllPaginatedAndSorted (final int page,final int size,final String sortBy, final String sortOrder );

    public List<T> findAllPaginated (final int page, final int size);

    public List<T> findAllSorted (final String sortBy, final String sortOrder);

    public List<T> findAll (final HttpServletRequest request );
}
