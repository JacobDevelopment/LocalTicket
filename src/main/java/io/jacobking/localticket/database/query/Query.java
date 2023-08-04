package io.jacobking.localticket.database.query;

import io.jacobking.localticket.core.utility.Checks;
import io.jacobking.localticket.database.ConnectionPool;
import io.jacobking.localticket.database.Database;
import io.jacobking.localticket.database.parameter.QueryList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Query {
    private final QueryList queryList = new QueryList();
    private final ConnectionPool pool = Database.getInstance().getConnectionPool();
    private final String query;
    private Connection connection;

    public Query(String query) {
        this.query = query;
        this.connection = pool.getConnection();
    }

    public Query(String query, Connection connection) {
        this.query = query;
        this.connection = connection;
    }


    public Query setConnection(final Connection connection) {
        Checks.notNull(connection, "Connection");
        this.connection = connection;
        return this;
    }

    public Query parameters(final Object... objects) {
        Checks.noneNull(objects);
        for (final Object object : objects) {
            this.queryList.add(object);
        }
        return this;
    }

    public static Query build(final String query) {
        Checks.notNull(query,"SQL Query");
        return new Query(query);
    }

    public boolean execute() {
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            queryList.applyTo(preparedStatement);
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
