package checker;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.util.Objects;

import static checker.ExceptionAssistant.writeExceptionInLog;

public class GetDataAssistant {

    public static String getData(String dataType) {
        String fileContent = null;
        try (InputStream is = GetDataAssistant.class.getClassLoader().getResourceAsStream(dataType)) {
            BufferedInputStream bis = new BufferedInputStream(Objects.requireNonNull(is));
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            int result = bis.read();
            while (result != -1) {
                buf.write((byte) result);
                result = bis.read();
            }
            fileContent = buf.toString();
        } catch (IOException e) {
            writeExceptionInLog(e);
        }
        return new Gson().fromJson(fileContent, JsonObject.class).toString();
    }
}
