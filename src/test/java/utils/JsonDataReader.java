package utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class JsonDataReader
{
    public static HashMap<String, String> readJsonData(String filePath, String testCaseName)
    {
        HashMap<String, String> testCaseData = null;

        File srcFile = new File(filePath);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<HashMap<String, String>> testDataList = objectMapper.readValue(srcFile, new TypeReference<List<HashMap<String, String>>>() {});

            for (HashMap<String, String> testCase : testDataList)
            {
                String currentTestCaseName = (String) testCase.get("testCase");

                if (currentTestCaseName.equalsIgnoreCase(testCaseName)) {
                    testCaseData = testCase;
                    break;
                }
                LogUtils.info("Data for test case: ", testCaseName, " read successfully");
            }
        } catch (IOException e) {
            LogUtils.error("Error while reading JSON data: ", e.getMessage());
        }
        return testCaseData;
    }
}
