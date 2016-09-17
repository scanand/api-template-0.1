package com.soagile.api.web.util;

/**
 * Created by soagile-pc on 8/08/2016.
 */
public final class UmMappings {
    public static final String USERS = "users";
    public static final String PRIVILEGES = "privileges";
    public static final String ROLES = "roles";

    // discoverability

    public static final class Singural {

        public static final String USER = "user";
        public static final String PRIVILEGE = "privilege";
        public static final String ROLE = "role";

    }

    public static final String AUTHENTICATION = "authentication";

    private UmMappings() {
        throw new AssertionError();
    }

}
