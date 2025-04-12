package data;

import org.testng.annotations.DataProvider;

public class RegistrationDataProvider
{
    @DataProvider(name = "registrationValidData")
    public Object[][] provideRegistrationData() {
        return new Object[][] {
                {"marwa", "salah", "27", "8", "1996", "123 main st.", "12345", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwass80@gmail.com", "m_Salah1234"}
        };
    }

    @DataProvider(name = "registrationData2")
    public Object[][] provideRegistrationData2() {
        return new Object[][] {
                {"", "salah", "27", "8", "1996", "123 main st.", "12345", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwass800@hiyahs000.com", "m_Salah1234"}
        };
    }

    @DataProvider(name = "registrationData3")
    public Object[][] provideRegistrationData3() {
        return new Object[][] {
                {"Marwa", "sa", "27", "8", "1996", "123 main st.", "12345", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwass800@hiyahs000.com", "m_Salah1234"}
        };
    }

    @DataProvider(name = "registrationData4")
    public Object[][] provideRegistrationData4() {
        return new Object[][] {
                {"Marwa", "Salah", "27", "8", "2028", "123 main st.", "12345", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwass700@hiyahs000.com", "m_Salah1234"}
        };
    }

    @DataProvider(name = "registrationData5")
    public Object[][] provideRegistrationData5() {
        return new Object[][] {
                {"Marwa", "Salah", "27", "8", "2000", "123 main st.", "12345", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwass700@hiyahs000", "m_Salah1234"}
        };
    }

    @DataProvider(name = "registrationData6")
    public Object[][] provideRegistrationData6() {
        return new Object[][] {
                {"Marwa", "Salah", "27", "8", "2000", "123 main st.", "fffff", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwa.salah@gmail.com", "m_Salah1234"}
        };
    }

    @DataProvider(name = "registrationData7")
    public Object[][] provideRegistrationData7() {
        return new Object[][] {
                {"Marwa", "Salah", "27", "8", "2000", "123 main st.", "fffff", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwa.salahgmail.com", "m_Salah1234"}
        };
    }

    @DataProvider(name = "registrationData8")
    public Object[][] provideRegistrationData8() {
        return new Object[][] {
                {"Marwa", "Salah", "27", "8", "2000", "123 main st.", "fffff", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwa.salah@gmail.com", "m_salah1234"}
        };
    }
}
