package checker;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Provider {
    @NonNull
    @Getter
    String name, url, login, password, logAttribute, passAttribute, balancePath, tariffPath;
    @Getter
    double balanceThreshold;

    Provider(Map<String, Object> providerData) {
        this.name = (String) providerData.get("name");
        this.url = (String) providerData.get("url");
        this.login = (String) providerData.get("login");
        this.password = (String) providerData.get("password");
        this.logAttribute = (String) providerData.get("logAttribute");
        this.passAttribute = (String) providerData.get("passAttribute");
        this.balancePath = (String) providerData.get("balancePath");
        this.tariffPath = (String) providerData.get("tariffPath");
        this.balanceThreshold = (int) providerData.get("balanceThreshold");
    }
}
