package io.jacobking.localticket.database.parameter;

public class QueryParameter {

    private final int index;
    private final Object object;

    public QueryParameter(int index, Object object) {
        this.index = index;
        this.object = object;
    }

    public int getIndex() {
        return index;
    }

    public Object getObject() {
        return object;
    }
}
