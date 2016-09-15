package com.soagile.api.common.web.controller;

import com.soagile.api.common.persistence.model.IEntity;
import com.soagile.api.common.web.RestPreconditions;

/**
 * Created by BMGTS on 21/03/2016.
 */
public abstract class AbstractController <T extends IEntity> extends AbstractReadOnlyController<T>
{

    public AbstractController (final Class<T> clazzToSet )
    {
        super(clazzToSet);
    }


    protected final void createInternal( final T resource) {

        RestPreconditions.checkRequestElementNotNull(resource);
        RestPreconditions.checkRequestState(resource.getId() == null, "resource="+resource.getId() +" is not valid..");
        getService().create(resource);
    }
    /**
     * - note: the operation is IDEMPOTENT <br/>
     */
    protected final void updateInternal(final long id, final T resource) {
        RestPreconditions.checkRequestElementNotNull(resource);
        RestPreconditions.checkNotNull(resource.getId());
        RestPreconditions.checkIfBadRequest(resource.getId() == id, resource.getClass().getSimpleName() +"id and URI dont match");
        RestPreconditions.checkNotNull(getService().findOne(resource.getId()));

        getService().update(resource);
    }

    // delete/remove

    protected final void deleteByIdInternal(final long id) {
        getService().delete(id);
    }

}
