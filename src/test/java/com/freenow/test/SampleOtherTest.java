package com.freenow.test;

import com.freenow.DataContainer.LocalDataContainer;
import com.freenow.framework.Base.BaseAPI;
import org.testng.annotations.Test;

public class SampleOtherTest extends BaseAPI {

    LocalDataContainer data = new LocalDataContainer();

    @Test
    public void verify_sample_other_test(){
    Log.info("In method: "+getClass().getSimpleName());
    }
}
