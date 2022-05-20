package checker;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BalancePuller {
    static Duration timeout = Duration.ofSeconds(10);

    public static double[] getAccountBalance(Provider provider) {
        double[] balanceData = new double[3];
        Selenide.open(provider.getUrl());
        $(byName(provider.getLogAttribute())).shouldBe(visible, timeout).setValue(provider.getLogin());
        $(byName(provider.getPassAttribute())).shouldBe(visible, timeout).setValue(provider.getPassword());
        $(byAttribute("type", "submit")).click();
        balanceData[0] = formatSum(provider, $(byXpath(provider.getTariffPath())));
        balanceData[1] = formatSum(provider, $(byXpath(provider.getBalancePath())));
        balanceData[2] = balanceData[0] - balanceData[1];
        return balanceData;
    }

    private static double formatSum(Provider provider, SelenideElement element) {
        return Double.parseDouble(element.shouldBe(visible, timeout).text().split(" ")[0]);
    }

}
