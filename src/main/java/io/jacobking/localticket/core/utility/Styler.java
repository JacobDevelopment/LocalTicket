package io.jacobking.localticket.core.utility;

public class Styler {

    private final StringBuilder styleBuilder;

    private Styler(final String initialStyle) {
        this.styleBuilder = new StringBuilder(initialStyle);
    }

    private Styler() {
        this.styleBuilder = new StringBuilder();
    }

    public static Styler build(final String style) {
        return new Styler(style);
    }

    public static Styler build() {
        return new Styler();
    }

    public Styler addStyle(final String style) {
        this.styleBuilder.append(style);
        return this;
    }

    public String construct() {
        return styleBuilder.toString();
    }

}
