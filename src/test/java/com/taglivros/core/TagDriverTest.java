package com.taglivros.core;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class TagDriverTest {

    @Test
    public void chromeDriverIsCreated(){
        assertNotNull(TagDriver.driver);
    }

    @After
    public void CloseDriver(){
        if (TagDriver.driver != null)
        {
            TagDriver.driver.close();
        }
    }
}