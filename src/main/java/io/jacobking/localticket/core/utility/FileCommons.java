package io.jacobking.localticket.core.utility;

public class FileCommons {

    private static final String USER_HOME = System.getProperty("user.home");
    public static final String LOCAL_TICKET = "LocalTicket";
    public static final String DATABASE_NAME = "lt-db.sqlite";
    public static final String PROFILE_NAME = "profile.config";

    public static final String CONFIG_NAME = "config.properties";

    public static final String README_NAME = "README.txt";
    public static final String MAIN_DIRECTORY = String.format("%s\\%s", USER_HOME, LOCAL_TICKET);

    public static final String DATABASE_DIRECTORY = String.format("%s\\%s", MAIN_DIRECTORY, DATABASE_NAME);
    public static final String PROFILE_DIRECTORY = String.format("%s\\%s", MAIN_DIRECTORY, PROFILE_NAME);

    public static final String CONFIG_DIRECTORY = String.format("%s\\%s", MAIN_DIRECTORY, CONFIG_NAME);

    public static final String README_DIRECTORY = String.format("%s\\%s", MAIN_DIRECTORY, README_NAME);

    public static final String[] README_COMMENTS = {
            String.format("LocalTicket (%s)", Version.CURRENT),
            String.format("Released on %s", Version.CURRENT.getReleaseDate()),
            "Developed by JacobDevelopment",
            "GitHub Repository: https://github.com/JacobDevelopment/LocalTicket",
            "--------------------------------------------------------------------"
    };
}
