package data;

import org.testng.annotations.DataProvider;

public class PaymentDataProvider
{
    @DataProvider(name = "BankData")
    public Object[][] provideBankData() {
        return new Object[][]{
                {"Bank5 Connect", "Yara/", "111FQR"}
        };
    }
}
