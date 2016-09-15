package com.soagile.api.common.persistence.service;

import com.soagile.api.common.persistence.model.INameableEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by BMGTS on 29/03/2016.
 */
public abstract class AbstractService<T extends INameableEntity> extends AbstractRawService<T> implements IService<T> {

}
