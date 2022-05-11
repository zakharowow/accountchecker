package checker;

import java.io.File;

public class GetDataAssistant {

    public static File getData(String dataType) {
        return new File("src/main/resources/" + dataType);
//        return new File(dataType);
    }
}
