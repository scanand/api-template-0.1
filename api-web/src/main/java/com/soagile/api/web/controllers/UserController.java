package com.soagile.api.web.controllers;

import com.soagile.api.common.persistence.service.IRawService;
import com.soagile.api.common.web.controller.AbstractController;
import com.soagile.api.common.web.controller.ISortingController;
import com.soagile.api.common.web.exception.MyResourceNotFoundException;
import com.soagile.api.persistence.model.User;
import com.soagile.api.service.IUserService;
import com.soagile.api.web.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
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
public class UserController extends AbstractController<User> implements ISortingController<User> {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService service;

    public UserController() {
        super(User.class);
    }

    public UserController(Class<User> clazzToSet) {
        super(clazzToSet);
    }

    @Override
    protected IRawService<User> getService() {
        return service;
    }

    @Override
    public List<User> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        return getService().findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
    }

    @Override
    public List<User> findAllPaginated(int page, int size) {
        return getService().findAllPaginated(page, size);
    }

    @Override
    public List<User> findAllSorted(String sortBy, String sortOrder) {
        return getService().findAllSorted(sortBy, sortOrder);
    }

    /**
     * @param request
     * @return
     */
    @Override
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll(HttpServletRequest request) {
        LOG.debug("findAll" +  "Start" );
        if (request.getParameterNames().hasMoreElements()) {
            throw new MyResourceNotFoundException();
        }
        return getService().findAll();
    }

    public User findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid final User resource) {
        createInternal(resource);
    }
}
