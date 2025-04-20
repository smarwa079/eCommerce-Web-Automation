package tests;

import data.RegistrationDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.SignInPage;
import utils.BaseTest;
import utils.PageBase;

import java.util.HashMap;

public class RegistrationInvalidTests extends BaseTest
{
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

    @Test(priority = 1, dataProvider = "emptyFirstNameRegistrationData", dataProviderClass = RegistrationDataProvider.class)
    public void emptyFirstName(HashMap<String, String> testData) {
        registrationPage = new RegistrationPage(driver);

        registrationPage.enterFirstName(testData.get("firstName"));
        registrationPage.enterLastName(testData.get("lastName"));
        registrationPage.selectDateOfBirth(testData.get("day"), testData.get("month"), testData.get("year"));
        registrationPage.enterStreet(testData.get("street"));
        registrationPage.enterPostalCode(testData.get("postalCode"));
        registrationPage.enterCity(testData.get("city"));
        registrationPage.enterState(testData.get("state"));
        registrationPage.selectCountry(testData.get("country"));
        registrationPage.enterPhone(testData.get("phone"));
        registrationPage.enterEmail(testData.get("email"));
        registrationPage.enterPassword(testData.get("password"));
        registrationPage.clickOnRegisterButton();

        System.out.println(registrationPage.getFirstNameErrorMessage());
        Assert.assertEquals(registrationPage.getFirstNameErrorMessage(), "First name is required");
    }

    @Test(priority = 2, dataProvider = "shortLastNameRegistrationData", dataProviderClass = RegistrationDataProvider.class)
    public void shortLastName(HashMap<String, String> testData) {
        registrationPage = new RegistrationPage(driver);

        registrationPage.enterFirstName(testData.get("firstName"));
        registrationPage.enterLastName(testData.get("lastName"));
        registrationPage.selectDateOfBirth(testData.get("day"), testData.get("month"), testData.get("year"));
        registrationPage.enterStreet(testData.get("street"));
        registrationPage.enterPostalCode(testData.get("postalCode"));
        registrationPage.enterCity(testData.get("city"));
        registrationPage.enterState(testData.get("state"));
        registrationPage.selectCountry(testData.get("country"));
        registrationPage.enterPhone(testData.get("phone"));
        registrationPage.enterEmail(testData.get("email"));
        registrationPage.enterPassword(testData.get("password"));
        registrationPage.clickOnRegisterButton();

        Assert.assertEquals(registrationPage.getLastNameErrorMessage(), "Last name can't be less than 3 characters");
    }

    @Test(priority = 3, dataProvider = "futureDateOfBirthRegistrationData", dataProviderClass = RegistrationDataProvider.class)
    public void futureDateOfBirth(HashMap<String, String> testData) {
        registrationPage = new RegistrationPage(driver);

        registrationPage.enterFirstName(testData.get("firstName"));
        registrationPage.enterLastName(testData.get("lastName"));
        registrationPage.selectDateOfBirth(testData.get("day"), testData.get("month"), testData.get("year"));
        registrationPage.enterStreet(testData.get("street"));
        registrationPage.enterPostalCode(testData.get("postalCode"));
        registrationPage.enterCity(testData.get("city"));
        registrationPage.enterState(testData.get("state"));
        registrationPage.selectCountry(testData.get("country"));
        registrationPage.enterPhone(testData.get("phone"));
        registrationPage.enterEmail(testData.get("email"));
        registrationPage.enterPassword(testData.get("password"));
        registrationPage.clickOnRegisterButton();

        System.out.println(registrationPage.getDateOfBirthErrorMessage());
        Assert.assertEquals(registrationPage.getDateOfBirthErrorMessage(), "Customer must be 18 years old.");
    }

    @Test(priority = 4, dataProvider = "invalidEmailFormatRegistrationData", dataProviderClass = RegistrationDataProvider.class)
    public void invalidEmail(HashMap<String, String> testData) {
        registrationPage = new RegistrationPage(driver);

        registrationPage.enterFirstName(testData.get("firstName"));
        registrationPage.enterLastName(testData.get("lastName"));
        registrationPage.selectDateOfBirth(testData.get("day"), testData.get("month"), testData.get("year"));
        registrationPage.enterStreet(testData.get("street"));
        registrationPage.enterPostalCode(testData.get("postalCode"));
        registrationPage.enterCity(testData.get("city"));
        registrationPage.enterState(testData.get("state"));
        registrationPage.selectCountry(testData.get("country"));
        registrationPage.enterPhone(testData.get("phone"));
        registrationPage.enterEmail(testData.get("email"));
        registrationPage.enterPassword(testData.get("password"));
        registrationPage.clickOnRegisterButton();

        Assert.assertEquals(registrationPage.getEmailErrorMessage(), "Missing Top-Level Domain (TLD)");
    }

    @Test(priority = 5, dataProvider = "invalidPostalCodeRegistrationData", dataProviderClass = RegistrationDataProvider.class)
    public void invalidPostalCode(HashMap<String, String> testData) {
        registrationPage = new RegistrationPage(driver);

        registrationPage.enterFirstName(testData.get("firstName"));
        registrationPage.enterLastName(testData.get("lastName"));
        registrationPage.selectDateOfBirth(testData.get("day"), testData.get("month"), testData.get("year"));
        registrationPage.enterStreet(testData.get("street"));
        registrationPage.enterPostalCode(testData.get("postalCode"));
        registrationPage.enterCity(testData.get("city"));
        registrationPage.enterState(testData.get("state"));
        registrationPage.selectCountry(testData.get("country"));
        registrationPage.enterPhone(testData.get("phone"));
        registrationPage.enterEmail(testData.get("email"));
        registrationPage.enterPassword(testData.get("password"));
        registrationPage.clickOnRegisterButton();

        Assert.assertEquals(registrationPage.getPostalCodeErrorMessage(), "Postal code can't contain only letters");
    }

    @Test(priority = 6, dataProvider = "missingAtInEmailRegistrationData", dataProviderClass = RegistrationDataProvider.class)
    public void missingAtInEmail(HashMap<String, String> testData) {
        registrationPage = new RegistrationPage(driver);

        registrationPage.enterFirstName(testData.get("firstName"));
        registrationPage.enterLastName(testData.get("lastName"));
        registrationPage.selectDateOfBirth(testData.get("day"), testData.get("month"), testData.get("year"));
        registrationPage.enterStreet(testData.get("street"));
        registrationPage.enterPostalCode(testData.get("postalCode"));
        registrationPage.enterCity(testData.get("city"));
        registrationPage.enterState(testData.get("state"));
        registrationPage.selectCountry(testData.get("country"));
        registrationPage.enterPhone(testData.get("phone"));
        registrationPage.enterEmail(testData.get("email"));
        registrationPage.enterPassword(testData.get("password"));
        registrationPage.clickOnRegisterButton();

        Assert.assertEquals(registrationPage.getEmailErrorMessage(), "Missing @");
    }

    @Test(priority = 7, dataProvider = "weakPasswordRegistrationData", dataProviderClass = RegistrationDataProvider.class)
    public void weakPassword(HashMap<String, String> testData) {
        registrationPage = new RegistrationPage(driver);

        registrationPage.enterFirstName(testData.get("firstName"));
        registrationPage.enterLastName(testData.get("lastName"));
        registrationPage.selectDateOfBirth(testData.get("day"), testData.get("month"), testData.get("year"));
        registrationPage.enterStreet(testData.get("street"));
        registrationPage.enterPostalCode(testData.get("postalCode"));
        registrationPage.enterCity(testData.get("city"));
        registrationPage.enterState(testData.get("state"));
        registrationPage.selectCountry(testData.get("country"));
        registrationPage.enterPhone(testData.get("phone"));
        registrationPage.enterEmail(testData.get("email"));
        registrationPage.enterPassword(testData.get("password"));
        registrationPage.clickOnRegisterButton();

        Assert.assertFalse(registrationPage.getPasswordSuccessMessage().contains("text-success"));
    }
}