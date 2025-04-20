package data;

import org.testng.annotations.DataProvider;
import utils.JsonDataReader;

import java.io.IOException;
import java.util.HashMap;

public class RegistrationDataProvider
{
    private static final String DATA_FILE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\RegistrationData.json";

    @DataProvider(name = "emptyFirstNameRegistrationData")
    public Object[][] provideEmptyFirstNameRegistrationData() throws IOException {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "emptyFirstName");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "shortLastNameRegistrationData")
    public Object[][] provideShortLastNameRegistrationData() throws IOException {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "shortLastName");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "futureDateOfBirthRegistrationData")
    public Object[][] provideFutureDateOfBirthRegistrationData() throws IOException {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "futureDateOfBirth");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "invalidEmailFormatRegistrationData")
    public Object[][] provideInvalidEmailRegistrationData() throws IOException {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "invalidEmailFormat");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "invalidPostalCodeRegistrationData")
    public Object[][] provideInvalidPostalCodeRegistrationData() throws IOException {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "invalidPostalCode");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "missingAtInEmailRegistrationData")
    public Object[][] provideInvalidEmailFormatRegistrationData() throws IOException {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "missingAtInEmail");
        return new Object[][] {{ testData }};
    }

    @DataProvider(name = "weakPasswordRegistrationData")
    public Object[][] provideWeakPasswordRegistrationData() throws IOException {
        HashMap<String, String> testData = JsonDataReader.readJsonData(DATA_FILE_PATH, "invalidPasswordFormat");
        return new Object[][] {{ testData }};
    }
}