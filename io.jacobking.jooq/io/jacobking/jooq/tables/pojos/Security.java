/*
 * This file is generated by jOOQ.
 */
package io.jacobking.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Security implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String username;
    private final String password;
    private final Integer permissions;
    private final Integer loginAttempts;
    private final Boolean firstLogin;

    public Security(Security value) {
        this.username = value.username;
        this.password = value.password;
        this.permissions = value.permissions;
        this.loginAttempts = value.loginAttempts;
        this.firstLogin = value.firstLogin;
    }

    public Security(
        String username,
        String password,
        Integer permissions,
        Integer loginAttempts,
        Boolean firstLogin
    ) {
        this.username = username;
        this.password = password;
        this.permissions = permissions;
        this.loginAttempts = loginAttempts;
        this.firstLogin = firstLogin;
    }

    /**
     * Getter for <code>SECURITY.USERNAME</code>.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Getter for <code>SECURITY.PASSWORD</code>.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Getter for <code>SECURITY.PERMISSIONS</code>.
     */
    public Integer getPermissions() {
        return this.permissions;
    }

    /**
     * Getter for <code>SECURITY.LOGIN_ATTEMPTS</code>.
     */
    public Integer getLoginAttempts() {
        return this.loginAttempts;
    }

    /**
     * Getter for <code>SECURITY.FIRST_LOGIN</code>.
     */
    public Boolean getFirstLogin() {
        return this.firstLogin;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Security other = (Security) obj;
        if (this.username == null) {
            if (other.username != null)
                return false;
        }
        else if (!this.username.equals(other.username))
            return false;
        if (this.password == null) {
            if (other.password != null)
                return false;
        }
        else if (!this.password.equals(other.password))
            return false;
        if (this.permissions == null) {
            if (other.permissions != null)
                return false;
        }
        else if (!this.permissions.equals(other.permissions))
            return false;
        if (this.loginAttempts == null) {
            if (other.loginAttempts != null)
                return false;
        }
        else if (!this.loginAttempts.equals(other.loginAttempts))
            return false;
        if (this.firstLogin == null) {
            if (other.firstLogin != null)
                return false;
        }
        else if (!this.firstLogin.equals(other.firstLogin))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.username == null) ? 0 : this.username.hashCode());
        result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
        result = prime * result + ((this.permissions == null) ? 0 : this.permissions.hashCode());
        result = prime * result + ((this.loginAttempts == null) ? 0 : this.loginAttempts.hashCode());
        result = prime * result + ((this.firstLogin == null) ? 0 : this.firstLogin.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Security (");

        sb.append(username);
        sb.append(", ").append(password);
        sb.append(", ").append(permissions);
        sb.append(", ").append(loginAttempts);
        sb.append(", ").append(firstLogin);

        sb.append(")");
        return sb.toString();
    }
}