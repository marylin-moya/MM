package com.devops.blog.runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import selenium.DriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;


public class RunCukesTest extends AbstractTestNGCucumberTests {
    private static Logger log = Logger.getLogger("RunCukesTest");

    @AfterTest
    public void afterExecution() {
        log.info("After method executed after all features");
        try {
        } catch (Exception e) {
            log.error("Unable to logout after execution", e);
        } finally {
            DriverManager.getInstance().quitDriver();
        }
    }
}
