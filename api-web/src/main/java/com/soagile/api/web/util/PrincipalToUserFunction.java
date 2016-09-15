package com.soagile.api.web.util;

import com.google.common.base.Function;
import com.soagile.api.persistence.model.Principal;
import com.soagile.api.persistence.model.User;

public final class PrincipalToUserFunction implements Function<Principal, User> {

    @Override
    public final User apply(final Principal principal) {
        return new User(principal);
    }

}
