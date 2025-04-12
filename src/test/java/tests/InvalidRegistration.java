package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.SignInPage;
import utils.BaseTest;
import utils.PageBase;

public class InvalidRegistration extends BaseTest {

    PageBase pageBase;
    SignInPage signInPage;
    RegistrationPage registrationPage;

@BeforeMethod
    public void registrationPage() {
    pageBase = new PageBase(driver);
    pageBase.clickOnSignInLink();
    signInPage = new SignInPage(driver);
    signInPage.clickOnRegisterLink();
}

@DataProvider(name = "registrationData2")
    public Object[][] provideRegistrationData2() {
        return new Object[][] {
                {"", "salah", "27", "8", "1996", "123 main st.", "12345", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwass800@hiyahs000.com", "m_Salah1234"}
        };
    }

@Test(priority =1, dataProvider ="registrationData2")
    public void invalidFirstName(String firstName, String lastName, String day, String month, String year, String street, String postalCode, String city, String state,String country, String phone, String email, String password){
     registrationPage = new RegistrationPage(driver);
     registrationPage.enterFirstName(firstName);
     registrationPage.enterLastName(lastName);
     registrationPage.selectDateOfBirth(day, month, year);
     registrationPage.enterStreet(street);
     registrationPage.enterPostalCode(postalCode);
     registrationPage.enterCity(city);
     registrationPage.enterState(state);
     registrationPage.selectCountry(country);
     registrationPage.enterPhone(phone);
     registrationPage.enterEmail(email);
     registrationPage.enterPassword(password);
     registrationPage.clickOnRegisterButton();
    System.out.println(registrationPage.getFirstNameErrorMessage());
    Assert.assertEquals(registrationPage.getFirstNameErrorMessage(), "First name is required");
    }
 @DataProvider(name = "registrationData3")
    public Object[][] provideRegistrationData3() {
        return new Object[][] {
                {"Marwa", "sa", "27", "8", "1996", "123 main st.", "12345", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwass800@hiyahs000.com", "m_Salah1234"}
        };
    }
    //BUG
@Test(priority = 2, dataProvider = "registrationData3")
public void invalidLastName(String firstName, String lastName, String day, String month, String year, String street, String postalCode, String city, String state, String country, String phone, String email, String password){
    registrationPage = new RegistrationPage(driver);
    registrationPage.enterFirstName(firstName);
    registrationPage.enterLastName(lastName);
    registrationPage.selectDateOfBirth(day, month, year);
    registrationPage.enterStreet(street);
    registrationPage.enterPostalCode(postalCode);
    registrationPage.enterCity(city);
    registrationPage.enterState(state);
    registrationPage.selectCountry(country);
    registrationPage.enterPhone(phone);
    registrationPage.enterEmail(email);
    registrationPage.enterPassword(password);
    registrationPage.clickOnRegisterButton();
    Assert.assertEquals(registrationPage.getLastNameErrorMessage(), "Last name can't be less than 3 characters");
}
    @DataProvider(name = "registrationData4")
    public Object[][] provideRegistrationData4() {
        return new Object[][] {
                {"Marwa", "Salah", "27", "8", "2028", "123 main st.", "12345", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwass700@hiyahs000.com", "m_Salah1234"}
        };
    }

    @Test(priority = 3, dataProvider = "registrationData4")
    public void invalidDateOfBirth(String firstName, String lastName, String day, String month, String year, String street, String postalCode, String city, String state, String country, String phone, String email, String password){
        registrationPage = new RegistrationPage(driver);
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.selectDateOfBirth(day, month, year);
        registrationPage.enterStreet(street);
        registrationPage.enterPostalCode(postalCode);
        registrationPage.enterCity(city);
        registrationPage.enterState(state);
        registrationPage.selectCountry(country);
        registrationPage.enterPhone(phone);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickOnRegisterButton();
        System.out.println(registrationPage.getDateOfBirthErrorMessage());
        Assert.assertEquals(registrationPage.getDateOfBirthErrorMessage(), "Customer must be 18 years old.");
    }
    @DataProvider(name = "registrationData5")
    public Object[][] provideRegistrationData5() {
        return new Object[][] {
                {"Marwa", "Salah", "27", "8", "2000", "123 main st.", "12345", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwass700@hiyahs000", "m_Salah1234"}
        };
    }

    //BUG
    @Test(priority = 4, dataProvider = "registrationData5")
    public void invalidEmail(String firstName, String lastName, String day, String month, String year, String street, String postalCode, String city, String state, String country, String phone, String email, String password){
        registrationPage = new RegistrationPage(driver);
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.selectDateOfBirth(day, month, year);
        registrationPage.enterStreet(street);
        registrationPage.enterPostalCode(postalCode);
        registrationPage.enterCity(city);
        registrationPage.enterState(state);
        registrationPage.selectCountry(country);
        registrationPage.enterPhone(phone);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickOnRegisterButton();
        Assert.assertEquals(registrationPage.getEmailErrorMessage(), "Missing Top-Level Domain (TLD)");
    }
    @DataProvider(name = "registrationData7")
    public Object[][] provideRegistrationData7() {
        return new Object[][] {
                {"Marwa", "Salah", "27", "8", "2000", "123 main st.", "fffff", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwa.salahgmail.com", "m_Salah1234"}
        };
    }
    @Test(priority = 6, dataProvider = "registrationData7")
    public void invalidEmail2(String firstName, String lastName, String day, String month, String year, String street, String postalCode, String city, String state, String country, String phone, String email, String password) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.selectDateOfBirth(day, month, year);
        registrationPage.enterStreet(street);
        registrationPage.enterPostalCode(postalCode);
        registrationPage.enterCity(city);
        registrationPage.enterState(state);
        registrationPage.selectCountry(country);
        registrationPage.enterPhone(phone);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickOnRegisterButton();

        Assert.assertEquals(registrationPage.getEmailErrorMessage(), "Missing @");

    }

    @DataProvider(name = "registrationData6")
    public Object[][] provideRegistrationData6() {
        return new Object[][] {
                {"Marwa", "Salah", "27", "8", "2000", "123 main st.", "fffff", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwa.salah@gmail.com", "m_Salah1234"}
        };
    }

    //BUG
    @Test(priority = 5, dataProvider = "registrationData6")
    public void invalidPostalcode(String firstName, String lastName, String day, String month, String year, String street, String postalCode, String city, String state, String country, String phone, String email, String password){
    registrationPage = new RegistrationPage(driver);
    registrationPage.enterFirstName(firstName);
    registrationPage.enterLastName(lastName);
    registrationPage.selectDateOfBirth(day, month, year);
    registrationPage.enterStreet(street);
    registrationPage.enterPostalCode(postalCode);
    registrationPage.enterCity(city);
    registrationPage.enterState(state);
    registrationPage.selectCountry(country);
    registrationPage.enterPhone(phone);
    registrationPage.enterEmail(email);
    registrationPage.enterPassword(password);
    registrationPage.clickOnRegisterButton();
    Assert.assertEquals(registrationPage.getPostalCodeErrorMessage(), "Postal code can't contain only letters");
    }
    @DataProvider(name = "registrationData8")
    public Object[][] provideRegistrationData8() {
        return new Object[][] {
                {"Marwa", "Salah", "27", "8", "2000", "123 main st.", "fffff", "Zamalek", "cairo",
                        "Egypt", "01235675901", "marwa.salah@gmail.com", "m_salah1234"}
        };
    }
    @Test(priority = 6, dataProvider = "registrationData8" )

    public void invalidPassword(String firstName, String lastName, String day, String month, String year, String street, String postalCode, String city, String state, String country, String phone, String email, String password) {
    registrationPage = new RegistrationPage(driver);
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.selectDateOfBirth(day, month, year);
        registrationPage.enterStreet(street);
        registrationPage.enterPostalCode(postalCode);
        registrationPage.enterCity(city);
        registrationPage.enterState(state);
        registrationPage.selectCountry(country);
        registrationPage.enterPhone(phone);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickOnRegisterButton();
        Assert.assertFalse(registrationPage.getPasswordSuccessMessage().contains("text-success"));
    }

}







