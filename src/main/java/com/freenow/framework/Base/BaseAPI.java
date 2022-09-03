package com.freenow.framework.Base;

import org.testng.annotations.BeforeClass;

public class BaseAPI extends ConfigurationHelper {

    @BeforeClass
    public void setUp(){

        super.loadProperties();

    }
}
