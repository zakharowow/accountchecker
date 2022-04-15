package checker;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static checker.ExceptionAssistant.writeExceptionInLog;
import static checker.GetDataAssistant.getData;

@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public class ProviderFactory {
    static List<Provider> providerList = new ArrayList<>();

    public static void generateProviderList() {
        try {
            List<Map<String, Object>> dataList = JsonPath.from(getData("providerdata")).getList("providers");
            for (Map<String, Object> providerData : dataList) {
                providerList.add(new Provider(providerData));
            }
            if (providerList.size() == 0) {
                writeExceptionInLog(new NullPointerException("Список провайдеров пуст"));
            }
        } catch (JsonPathException e) {
            writeExceptionInLog(e);
        }
    }
}
