package utils;

import org.testng.annotations.Test;
import tests.RegisterTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigRegisterData {
    private final String projectPath = System.getProperty("user.dir");
    private final Properties properties = new Properties();

    public void getProperties() throws IOException {
        FileInputStream file = new FileInputStream(projectPath + "/config/configRegisterData");
        properties.load(file);

        RegisterTest registerTest = new RegisterTest();
        registerTest.email = properties.getProperty("email");
        registerTest.firstName = properties.getProperty("firstName");
        registerTest.lastName = properties.getProperty("lastName");
        registerTest.password = properties.getProperty("password");
        registerTest.days = properties.getProperty("days");
        registerTest.months = properties.getProperty("months");
        registerTest.years = properties.getProperty("years");
        registerTest.address = properties.getProperty("address");
        registerTest.city = properties.getProperty("city");
        registerTest.state = properties.getProperty("state");
        registerTest.zip = properties.getProperty("zip");
        registerTest.country = properties.getProperty("country");
        registerTest.phone = properties.getProperty("phone");
    }
}
