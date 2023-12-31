package io.jacobking.localticket.core.utility;

public final class Checks {
    private Checks() {

    }

    public static void notNull(final Object object, final String name) {
        if (object == null) {
            throw new IllegalArgumentException(name + " is null!");
        }
    }

    public static void notEmpty(final String string, final String name) {
        notNull(string, name);
        if (string.isEmpty()) {
            throw new IllegalArgumentException(name + " is empty!");
        }
    }

    public static void noneNull(final Object... objects) {
        for (final Object object : objects) {
            if (object == null) {
                throw new IllegalArgumentException("One of the passed objects is null!");
            }
        }
    }
}
