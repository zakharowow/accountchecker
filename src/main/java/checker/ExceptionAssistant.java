package checker;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ExceptionAssistant {
    public static void writeExceptionInLog(Exception e) {
        try (PrintStream printStream = new PrintStream("error.txt")){
            e.printStackTrace(printStream);
        } catch (FileNotFoundException ex) {
            //ignored
        }
    }
}
