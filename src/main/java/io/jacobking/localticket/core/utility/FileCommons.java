package io.jacobking.localticket.core.utility;

public class FileCommons {

    private static final String USER_HOME = System.getProperty("user.home");
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String CONFIG_FILE_NAME = "settings.config";
    private static final String DIRECTORY_NAME = "LocalTicket";

    public static final String DATABASE_NAME = "LocalTicket.db";
    public static final String MAIN_DIRECTORY = String.format("%s%s%s", USER_HOME, FILE_SEPARATOR, DIRECTORY_NAME);
    public static final String CONFIG_PATH = String.format("%s%s%s", MAIN_DIRECTORY, FILE_SEPARATOR, CONFIG_FILE_NAME);

    public static final String DATABASE_DIRECTORY = String.format("%s%s%s", MAIN_DIRECTORY, FILE_SEPARATOR, "DATABASE");

    public static final String DATABASE_PATH = String.format("%s%s%s", DATABASE_DIRECTORY, FILE_SEPARATOR, DATABASE_NAME);
}
