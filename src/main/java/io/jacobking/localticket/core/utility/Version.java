package io.jacobking.localticket.core.utility;

public final class Version {

    public static final Version CURRENT = new Version(0, 0, 0, "8/3/2023");

    private final int major;
    private final int minor;
    private final int patch;
    private final String releaseDate;
    private Version(int major, int minor, int patch, String releaseDate) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String toString() {
        return String.format("v%d.%d.%d", major, minor, patch);
    }

}
