package data;

import org.testng.annotations.DataProvider;
import utils.JsonDataReader;

import java.util.HashMap;

public class RegistrationDataProvider
{
    private static final String DATA_FILE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\RegistrationData.json";

    @DataProvider(name = "emptyFirstNameRegistrationData")
    public Object[][] provideEmptyFirstNameRegistrationData()
    {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "emptyFirstName");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "LastNameSpecialCharactersRegistrationData")
    public Object[][] provideLastNameSpecialCharactersRegistrationData()
    {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "lastNameSpecialCharacters");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "futureDateOfBirthRegistrationData")
    public Object[][] provideFutureDateOfBirthRegistrationData()
    {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "futureDateOfBirth");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "invalidEmailFormatRegistrationData")
    public Object[][] provideInvalidEmailRegistrationData()
    {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "invalidEmailFormat");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "invalidPostalCodeRegistrationData")
    public Object[][] provideInvalidPostalCodeRegistrationData()
    {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "invalidPostalCode");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "missingAtInEmailRegistrationData")
    public Object[][] provideInvalidEmailFormatRegistrationData()
    {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "missingAtInEmail");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "weakPasswordRegistrationData")
    public Object[][] provideWeakPasswordRegistrationData()
    {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "invalidPasswordFormat");
        return new Object[][] {{ testData }};
    }
}