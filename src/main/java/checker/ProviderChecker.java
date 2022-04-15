package checker;

import java.util.List;

import static checker.ExceptionAssistant.writeExceptionInLog;

public class ProviderChecker {

    public static void checkProviders(List<Provider> providerList) {
        for (Provider provider : providerList) {
            checkProvider(provider);
        }
    }

    private static void checkProvider(Provider provider) {
        try {
            double balance = BalancePuller.getAccountBalance(provider);
            if (balance < provider.getBalanceThreshold()) {
                String message = String.format("Пополни баланс %s. На счёте %s рублей.", provider.getName(), balance);
                Reporter.sendReport(provider, message);
            }
        } catch (Exception e) {
            writeExceptionInLog(e);
        }
    }


}
