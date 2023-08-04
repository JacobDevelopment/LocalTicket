package io.jacobking.localticket.database.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryList {
    private final List<QueryParameter> queryParameters = new ArrayList<>();

    private int index = 0;

    public void add(final Object object) {
        queryParameters.add(new QueryParameter(++index, object));
    }

    public void applyTo(final PreparedStatement preparedStatement) throws SQLException {
        for (final QueryParameter parameter : queryParameters) {
            preparedStatement.setObject(parameter.getIndex(), parameter.getObject());
        }
    }

}
