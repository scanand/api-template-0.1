package com.soagile.api.web.controllers;

import com.soagile.api.common.persistence.service.IRawService;
import com.soagile.api.common.web.controller.AbstractController;
import com.soagile.api.common.web.controller.ISortingController;
import com.soagile.api.common.web.exception.MyResourceNotFoundException;
import com.soagile.api.service.IUserService;
import com.soagile.api.web.dto.UserDto;
import com.soagile.api.web.util.Um;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.soagile.api.web.util.UmMappings.USERS;


/***
 *
 *
 */
@Controller
@RequestMapping(value = USERS)
public class UserController extends AbstractController<UserDto> implements ISortingController<UserDto> {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService service;

    public UserController() {
        super(UserDto.class);
    }

    public UserController(Class<UserDto> clazzToSet) {
        super(clazzToSet);
    }

    @Override
    protected IRawService<UserDto> getService() {
        return service;
    }

    @Override
    @Secured(Um.Privileges.CAN_ROLE_READ)
    public List<UserDto> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        return getService().findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
    }

    @Override
    public List<UserDto> findAllPaginated(int page, int size) {
        return getService().findAllPaginated(page, size);
    }

    @Override
    public List<UserDto> findAllSorted(String sortBy, String sortOrder) {
        return getService().findAllSorted(sortBy, sortOrder);
    }

    /**
     * @param request
     * @return
     */
    @Override
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @Secured(Um.Privileges.CAN_USER_READ)
    public List<UserDto> findAll(HttpServletRequest request) {
        LOG.debug("findAll" +  "Start" );
        if (request.getParameterNames().hasMoreElements()) {
            throw new MyResourceNotFoundException();
        }
        return getService().findAll();
    }

    public UserDto findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @Secured(Um.Privileges.CAN_USER_WRITE)
    public void create(@RequestBody @Valid final UserDto resource) {
        createInternal(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @Secured(Um.Privileges.CAN_USER_WRITE)
    public void update(@PathVariable("id") final Long id, @RequestBody @Valid final UserDto resource) {
        updateInternal(id, resource);
    }

    // delete

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Secured(Um.Privileges.CAN_USER_WRITE)
    public void delete(@PathVariable("id") final Long id) {
        deleteByIdInternal(id);
    }
}
