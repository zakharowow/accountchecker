package checker;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BalancePuller {

    public static double getAccountBalance(Provider provider) {
        Selenide.open(provider.getUrl());
        $(byName(provider.getLogAttribute())).setValue(provider.getLogin());
        $(byName(provider.getPassAttribute())).setValue(provider.getPassword());
        $(byAttribute("type", "submit")).click();
        String balance = $(byXpath(provider.getBalancePath())).text().split(" ")[0];
        return Double.parseDouble(balance);
    }
}
