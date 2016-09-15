package com.soagile.api.common.persistence.service;

import com.soagile.api.common.interfaces.IByNameApi;
import com.soagile.api.common.persistence.model.INameableEntity;

/**
 * Created by BMGTS on 22/03/2016.
 */
public interface IService<T extends INameableEntity> extends IRawService<T>, IByNameApi<T>
{

}
