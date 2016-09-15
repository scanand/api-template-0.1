package com.soagile.api.common.interfaces;

/**
 * Created by BMGTS on 22/03/2016.
 */
public interface IByNameApi<T extends IWithName>
{
    T findByName (final String name);
}
