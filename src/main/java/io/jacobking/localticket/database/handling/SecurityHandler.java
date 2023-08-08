package io.jacobking.localticket.database.handling;

import io.jacobking.jooq.tables.records.SecurityRecord;
import io.jacobking.localticket.database.ConnectionPool;
import org.jooq.DSLContext;

import static io.jacobking.jooq.tables.Security.SECURITY;

public class SecurityHandler {

    private final DSLContext dsl;

    public SecurityHandler(ConnectionPool connectionPool) {
        this.dsl = connectionPool.getDSL();
    }

    public boolean isUser(final String username) {
        return dsl.fetchExists(SECURITY, SECURITY.USERNAME.equalIgnoreCase(username));
    }

    public boolean isFirstLogin() {
        return dsl.fetchCount(SECURITY) == 0;
    }

    public boolean save(final String username, final String password, int permissions, int loginAttempts) {
        return dsl.insertInto(SECURITY)
                .set(SECURITY.USERNAME, username)
                .set(SECURITY.PASSWORD, password)
                .set(SECURITY.PERMISSIONS, permissions)
                .set(SECURITY.LOGIN_ATTEMPTS, loginAttempts)
                .set(SECURITY.FIRST_LOGIN, false)
                .execute() == 1;
    }

    public boolean verify(final String username, final String password) {
        return dsl.fetchExists(
                SECURITY.where(SECURITY.USERNAME.eq(username)
                        .and(SECURITY.PASSWORD.eq(password)))
        );
    }

    public void decrementLoginAttempts(final String username) {
        final Integer loginAttempts = dsl.select(SECURITY.LOGIN_ATTEMPTS)
                .from(SECURITY)
                .where(SECURITY.USERNAME.equalIgnoreCase(username))
                .fetchOneInto(Integer.class);


        if (loginAttempts == null)
            return;

        Password4J.

        System.out.println(loginAttempts);
        final int newAmount = loginAttempts - 1;
        if (newAmount <= 0) {
            // TODO: Implement policy to delete all passwords saved in the password table upon hitting this amount.
            return;
        }

        dsl.update(SECURITY)
                .set(SECURITY.LOGIN_ATTEMPTS, newAmount)
                .where(SECURITY.USERNAME.eq(username))
                .execute();
    }
}
