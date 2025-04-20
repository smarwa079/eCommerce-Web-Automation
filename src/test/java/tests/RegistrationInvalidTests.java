package tests;

import data.RegistrationDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the system shows an error when the first name field is left empty during registration.")
    @Test(priority = 1, dataProvider = "emptyFirstNameRegistrationData", dataProviderClass = RegistrationDataProvider.class)
    public void emptyFirstName(HashMap<String, String> testData)
    {
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

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the system shows an error when the last name field is less than 3 characters during registration.")
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

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the system shows an error when the date of birth is set to a future date during registration.")
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

        Assert.assertEquals(registrationPage.getDateOfBirthErrorMessage(), "Customer must be 18 years old.");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the system shows an error when the email format is invalid during registration.")
    @Test(priority = 4, dataProvider = "invalidEmailFormatRegistrationData", dataProviderClass = RegistrationDataProvider.class)
    public void invalidEmailFormat(HashMap<String, String> testData) {
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

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the system shows an error when the email format is missing '@' during registration.")
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

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the system shows an error when the postal code contains only letters during registration.")
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

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the system shows an error when the password format is weak during registration.")
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