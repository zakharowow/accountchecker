package checker;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class BalancePuller {

    public static double [] getAccountBalance(Provider provider) {
        double [] balanceData = new double [3];
        Selenide.open(provider.getUrl());
        $(byName(provider.getLogAttribute())).setValue(provider.getLogin());
        $(byName(provider.getPassAttribute())).setValue(provider.getPassword());
        $(byAttribute("type", "submit")).click();
        balanceData[0] = Double.parseDouble($(byXpath(provider.getTariffPath())).text().split(" ")[0]);
        balanceData[1] = Double.parseDouble($(byXpath(provider.getBalancePath())).text().split(" ")[0]);
        balanceData[2] = balanceData[0] - balanceData[1];
        return balanceData;
    }
}
