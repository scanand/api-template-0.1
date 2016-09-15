package com.soagile.api.service.impl;

import com.google.common.collect.Lists;
import com.soagile.api.common.web.RestPreconditions;
import com.soagile.api.persistence.model.Principal;
import com.soagile.api.persistence.model.User;
import com.soagile.api.service.IPrincipalService;
import com.soagile.api.service.IUserService;
import com.soagile.api.web.dto.UserDto;
import com.soagile.api.web.util.PrincipalToUserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IPrincipalService principalService;

    /**
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public User findOne(long id) {
        final Principal one = principalService.findOne(id);
        if (one == null) {
            return null;
        }
        return new User(one);
    }

    /**
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {

        final List<Principal> principals = principalService.findAll();
        final List<User> allUsers = Lists.transform(principals, new PrincipalToUserFunction());
        return Lists.newArrayList(allUsers);
    }


    /**
     * @param dto
     * @return
     */
    @Override
    public User create(final User dto) {
        final Principal newPrincipal = new Principal(dto);
        principalService.create(newPrincipal);
        dto.setId(newPrincipal.getId());
        return dto;
    }

    private final UserDto convert(final Principal principal) {
        return new UserDto(principal);
    }


    @Override
    public User findByName(final String name) {
        final Principal principal = principalService.findByName(name);
        return new User(principal);
    }

    @Override
    public Page<User> findAllPaginatedAndSortedRaw(final int page, final int size, final String sortBy, final String sortOrder) {
        final Page<Principal> principalsPaginatedAndSorted = principalService.findAllPaginatedAndSortedRaw(page, size, sortBy, sortOrder);
        final List<User> usersPaginatedAndSorted = Lists.transform( principalsPaginatedAndSorted.getContent(), new PrincipalToUserFunction());


        final PageRequest pageRequest = new PageRequest(page, size, constructSort(sortBy, sortOrder));

        return new PageImpl<User>( usersPaginatedAndSorted, pageRequest,principalsPaginatedAndSorted.getTotalElements());
    }

    @Override
    public List<User> findAllSorted(final String sortBy, final String sortOrder) {
        final List<Principal> allSorted = principalService.findAllSorted(sortBy, sortOrder);
        return Lists.transform(allSorted, new PrincipalToUserFunction());
    }

    @Override
    public List<User> findAllPaginated(final int page, final int size) {
        final List<Principal> principals = principalService.findAllPaginated(page, size);
        return  Lists.transform(principals, new PrincipalToUserFunction());
    }

    @Override
    public List<User> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder) {
        return findAllPaginatedAndSortedRaw(page, size, sortBy, sortOrder).getContent();
    }

    @Override
    public void update(final User resource) {
        final Principal principal = RestPreconditions.checkNotNull(principalService.findOne(resource.getId()));
        principal.setName(resource.getName());
        principal.setRoles(resource.getRoles());
        principalService.update(principal);
    }

    @Override
    public void delete(final long id) {
        principalService.delete(id);
    }

    @Override
    public void deleteAll() {
        principalService.deleteAll();
    }

    @Override
    public long count() {
        return principalService.count();
    }

    final Sort constructSort(final String sortBy, final String sortOrder) {
        Sort sortInfo = null;
        if (sortBy != null) {
            sortInfo = new Sort(Sort.Direction.fromString(sortOrder), sortBy);
        }
        return sortInfo;
    }
}