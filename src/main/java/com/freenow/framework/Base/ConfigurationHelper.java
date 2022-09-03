package com.freenow.framework.Base;

import com.freenow.framework.Exception.FrameworkException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationHelper {

    static Properties testProps;

    public void loadProperties(){
        try {
            final String propertyFileLocation = System.getProperty("user.dir")  + "/src/test/resources/testConfig.properties";
            final FileReader reader = new FileReader(propertyFileLocation);
            testProps = new Properties();
            testProps.load(reader);
        } catch (IOException e) {
            throw new FrameworkException("Unable to load the properties file "+e);
        }
    }

    public static Object getProperty(final String property) {
        return testProps.get(property);
    }


}
