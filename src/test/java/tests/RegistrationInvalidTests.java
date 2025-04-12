package tests;

import data.RegistrationDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.SignInPage;
import utils.BaseTest;
import utils.PageBase;

public class RegistrationInvalidTests extends BaseTest {

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

    @Test(priority =1, dataProvider ="registrationData2", dataProviderClass = RegistrationDataProvider.class)
    public void invalidFirstName(String firstName, String lastName, String day, String month, String year, String street, String postalCode, String city, String state,String country, String phone, String email, String password)
    {
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

    //BUG
    @Test(priority = 2, dataProvider = "registrationData3", dataProviderClass = RegistrationDataProvider.class)
    public void invalidLastName(String firstName, String lastName, String day, String month, String year, String street, String postalCode, String city, String state, String country, String phone, String email, String password) {
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

    @Test(priority = 3, dataProvider = "registrationData4", dataProviderClass = RegistrationDataProvider.class)
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

    //BUG
    @Test(priority = 4, dataProvider = "registrationData5", dataProviderClass = RegistrationDataProvider.class)
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

    @Test(priority = 6, dataProvider = "registrationData7", dataProviderClass = RegistrationDataProvider.class)
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

    //BUG
    @Test(priority = 5, dataProvider = "registrationData6", dataProviderClass = RegistrationDataProvider.class)
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

    @Test(priority = 6, dataProvider = "registrationData8", dataProviderClass = RegistrationDataProvider.class)
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







