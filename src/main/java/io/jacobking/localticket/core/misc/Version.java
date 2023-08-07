package io.jacobking.localticket.core.misc;

import io.jacobking.localticket.core.utility.StringUtil;

public final class Version {

    public static final Version CURRENT = new Version(0, 0, 0, "8/3/2023")
            .addChange("Completed versioning semantics.")
            .addChange("Added config creation.")
            .addChange("Started production of database handling.")
            .addChange("Added login screen, beginning the authentication process.");

    public static final Version PAST = null;

    private final int major;
    private final int minor;
    private final int patch;
    private final String releaseDate;
    private final StringBuilder changelog;
    private Version(int major, int minor, int patch, String releaseDate) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.releaseDate = releaseDate;
        this.changelog = new StringBuilder();
        addBaseToChangelog();
    }

    private void addBaseToChangelog() {
        this.changelog.append(this);
        this.changelog.append(("\n"));
        this.changelog.append(StringUtil.repeat('-', 30));
    }

    public boolean isNewestVersion() {
        final int currentTotal = (major + minor + patch);
        final int pastTotal = PAST.major + PAST.minor + PAST.patch;
        return currentTotal > pastTotal;
    }

    public Version addChange(final String change) {
        this.changelog.append("\n");
        this.changelog.append("- ");
        this.changelog.append(change);
        return this;
    }

    public String getChangelog() {
        return changelog.toString();
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String toString() {
        return String.format("v%d.%d.%d", major, minor, patch);
    }

}
