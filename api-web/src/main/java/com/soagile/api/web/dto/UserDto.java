package com.soagile.api.web.dto;

import com.soagile.api.common.interfaces.INameableDto;
import com.soagile.api.common.persistence.model.INameableEntity;
import com.soagile.api.persistence.model.Principal;
import com.soagile.api.persistence.model.Role;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

/**
 * Created by BMGTS on 22/03/2016.
 */

@XmlRootElement
@XStreamAlias("user")

public class UserDto implements INameableEntity, INameableDto
{
    @XStreamAsAttribute
    private Long id;

    @Size(min = 2, max = 30)
    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    private String password;

    @Min(0)
    @Max(99)
    private int age;

    @XStreamImplicit
    private Set<Role> roles;

    public UserDto() {
        super();
    }

    public UserDto(String name, String password, Set<Role> roles) {

        super();

        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public UserDto( final Principal principal) {
        super();

        this.name = principal.getName();
        this.id = principal.getId();
        this.roles = principal.getRoles();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long idToSet) {
        id = idToSet;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(final String nameToSet) {
        name = nameToSet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String passwordToSet) {
        password = passwordToSet;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Set<Role> rolesToSet) {
        roles = rolesToSet;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UserDto other = (UserDto) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).toString();
    }

}
