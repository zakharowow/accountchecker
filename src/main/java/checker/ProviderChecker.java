package checker;

import java.text.DecimalFormat;
import java.util.List;

import static checker.ExceptionAssistant.writeExceptionInLog;

public class ProviderChecker {

    public static void checkProviders(List<Provider> providerList) {
        for (Provider provider : providerList) {
            checkProvider(provider);
        }
    }

    private static void checkProvider(Provider provider) {
        double[] balanceData;
        try {
            balanceData = BalancePuller.getAccountBalance(provider);
            if (balanceData[1] < provider.getBalanceThreshold()) {
                String message = String.format("Оператор %s. Договор %s. На счёте %s рублей. Нужно доплатить %s рублей.", provider.getName(), provider.getLogin(), balanceData[1], new DecimalFormat("##.##").format(Math.abs(balanceData[2])));
                Reporter.sendReport(provider, message);
            }
        } catch (Exception e) {
            writeExceptionInLog(e);
        }
    }


}
