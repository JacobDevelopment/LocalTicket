package io.jacobking.localticket.core.utility;

import java.io.*;
import java.util.Properties;

public class FileIO {

    private FileIO() {

    }

    public static boolean createFile(final String path) throws IOException {
        Checks.notEmpty(path, "File path");
        return new File(path).createNewFile();
    }

    public static boolean doesFileExist(final String path) {
        Checks.notEmpty(path, "File path");
        return new File(path).exists();
    }

    public static boolean createDirectory(final String path) {
        Checks.notEmpty(path, "Directory path");
        return new File(path).mkdir();
    }

    public static boolean doesDirectoryExist(final String path) {
        Checks.notEmpty(path, "Directory path");
        final File file = new File(path);
        if (!file.isDirectory())
            return false;
        return file.exists();
    }

    public static void writeToFile(final File file, final String... comments) throws FileNotFoundException {
        Checks.notNull(file, "Target file");
        try (final PrintWriter printWriter = new PrintWriter(file)) {
            for (final String comment : comments) {
                printWriter.println(comment);
            }
        }
    }

    public static void writeProperties(final Properties properties, final String fileName, final String comments) throws IOException {
        Checks.notNull(properties, "Properties");
        Checks.notEmpty(fileName, "File Name");
        properties.store(new FileOutputStream(fileName), comments);
    }
}
