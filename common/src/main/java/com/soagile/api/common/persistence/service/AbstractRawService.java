package com.soagile.api.common.persistence.service;

import com.google.common.base.Preconditions;
import com.soagile.api.common.base.ServicePreconditions;
import com.soagile.api.common.persistence.model.IEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by BMGTS on 29/03/2016.
 */
@Transactional
public abstract class AbstractRawService<T extends IEntity> implements IRawService<T> {

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return newArrayList(getDao().findAll());
    }

    protected abstract PagingAndSortingRepository<T, Long> getDao();
    protected abstract JpaSpecificationExecutor<T> getSpecificationExecutor();


    public T create(final T entity) {
        Preconditions.checkNotNull(entity);

        final T persistedEntity = getDao().save(entity);

        return persistedEntity;
    }

    @Transactional(readOnly = true)
    @Override
    public T findOne(final long id) {
        return getDao().findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<T> findAllPaginatedAndSortedRaw(final int page, final int size, final String sortBy, final String sortOrder) {
        final Sort sortInfo = constructSort ( sortBy, sortOrder);
        return getDao().findAll(new PageRequest(page,size,sortInfo));
    }

    // TODO: 17/08/2016 Default the params in case of null
    private Sort constructSort(final String sortBy, final String sortOrder) {
        Sort sortInfo = null;

        if(StringUtils.isNotBlank( sortBy  ) ) {
            sortInfo = new Sort( Sort.Direction.fromString(sortOrder),sortBy);
        }
        return sortInfo;
    }

    @Override
    public List<T> findAllSorted(final String sortBy, final String sortOrder) {
        final Sort orders = constructSort(sortBy, sortOrder);
        final ArrayList<T> list = new ArrayList<T>();
        final Iterable<T> iterable = getDao().findAll(orders);
        iterable.forEach(list :: add );
        return list;
    }

    @Override
    public List<T> findAllPaginated(final int page, final int size) {
        final PageRequest pageRequest = new PageRequest(page, size, null);
        final List<T> content = getDao().findAll(pageRequest).getContent();
        if (content == null) {
            return new ArrayList<T>();
        }
        return content;
    }


    @Override
    public List<T> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder) {
        final Sort orders = constructSort(sortBy, sortOrder);

        final List<T> content = getDao().findAll(new PageRequest(page, size, orders)).getContent();
        if (content == null) {
            return new ArrayList<T>();
        }
        return content;
    }

    @Override
    public void update(final T resource) {
        Preconditions.checkNotNull(resource);
        getDao().save(resource);

    }

    @Override
    public void delete(final long id) {
        final T entity = getDao().findOne(id);
        ServicePreconditions.checkEntityExists(entity);

        getDao().delete(entity);
    }

    @Override
    public void deleteAll() {
        getDao().deleteAll();
    }

    @Override
    public long count() {
        return getDao().count();
    }
}
