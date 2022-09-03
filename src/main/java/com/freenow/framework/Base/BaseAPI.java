package com.freenow.framework.Base;

import org.testng.annotations.BeforeClass;
import java.util.logging.Logger;

public class BaseAPI extends ConfigurationHelper {

    protected Logger Log = Logger.getLogger(this.getClass().getName());

    @BeforeClass
    public void setUp(){

        super.loadProperties();

    }
}
