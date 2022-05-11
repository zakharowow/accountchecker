package checker;

import static checker.Cleaner.*;
import static checker.ProviderChecker.checkProviders;
import static checker.ProviderFactory.providerList;

public class Main {
    public static void main(String[] args) {
        System.setProperty("JAVA_TOOL_OPTIONS", "encoding=UTF8");
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        clearLogs();
        ProviderFactory.generateProviderList();
        checkProviders(providerList);
        clearFolder();
    }
}
