package checker;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static checker.ExceptionAssistant.writeExceptionInLog;

public class Cleaner {
    static File[] foldersArray;
    static File buildFolder;

    public static void clearFolder() {
        buildFolder = new File("build");
        foldersArray = new File("build").listFiles();
        if (foldersArray != null) {
            for (File element : foldersArray) {
                deleteFile(element);
            }
        }
        deleteFile(buildFolder);
    }

    public static void clearLogs(){
        deleteFile(new File("error.txt"));
    }
    private static void deleteFile(File element){
        try {
            if (element.isFile()) {
                FileUtils.deleteQuietly(element);
            } else {
                FileUtils.deleteDirectory(element);
            }
        } catch (IOException e) {
            writeExceptionInLog(e);
        }
    }
}
