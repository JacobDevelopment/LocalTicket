package io.jacobking.localticket.core.utility;

import java.util.Arrays;

public final class StringUtil {
    private StringUtil() {

    }

    public static String repeat(final char character, final int amount) {
        final char[] characters = new char[amount + 1];
        Arrays.fill(characters, character);
        return new String(characters);
    }
}
