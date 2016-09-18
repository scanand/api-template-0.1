package com.soagile.api.web.controllers;

import com.google.common.net.HttpHeaders;
import com.soagile.api.common.util.LinkUtil;
import com.soagile.api.common.util.WebConstants;
import com.soagile.api.web.util.UmMappings;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@Controller
public class RootController {

    public RootController() {
        super();
    }

    // API

    // search

    @RequestMapping(value = WebConstants.PATH_SEP, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void rootWithPathSeparator(final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
        rootInternal(uriBuilder, response);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void rootBare(final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
        rootInternal(uriBuilder, response);
    }

    @SuppressWarnings("unused")
    private void rootInternal(final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
        final String userUriNew = uriBuilder.path("/" + UmMappings.USERS).build().toUriString();

        final String userUri = LinkUtil.createLinkHeader(WebConstants.PATH_SEP + UmMappings.USERS, LinkUtil.REL_COLLECTION);
        final String roleUri = LinkUtil.createLinkHeader(WebConstants.PATH_SEP + UmMappings.ROLES, LinkUtil.REL_COLLECTION);
        final String privilegeUri = LinkUtil.createLinkHeader(WebConstants.PATH_SEP + UmMappings.PRIVILEGES, LinkUtil.REL_COLLECTION);
        final String discoveredOperations = LinkUtil.gatherLinkHeaders(userUri, roleUri, privilegeUri);
        response.addHeader(HttpHeaders.LINK, discoveredOperations);
    }

}
