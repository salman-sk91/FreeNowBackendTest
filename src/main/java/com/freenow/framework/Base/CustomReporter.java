package com.freenow.framework.Base;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class CustomReporter implements ITestListener {

    private final boolean LogToStandardOutput = true;

    @Override
    public void onTestStart(final ITestResult testName) {

        Reporter.log("<br>");
        Reporter.log("----------------------------------------------------------", LogToStandardOutput);
        Reporter.log("</br>");
        Reporter.log("Initiating TestCase::" + testName.getName(), LogToStandardOutput);
        Reporter.log("</br>");
        Reporter.log("</br>");

    }

    @Override
    public void onTestSuccess(final ITestResult testName) {

        Reporter.log("<br>");
        final long ms = testName.getEndMillis() - testName.getStartMillis();
        Reporter.log("Execution Time :: " + ms + "  Milli Seconds", LogToStandardOutput);
        Reporter.log("</br>");
        Reporter.log("Completed TestCase :: " + testName.getName() + " => Status: PASS", LogToStandardOutput);
        Reporter.log("</br>");
        Reporter.log("----------------------------------------------------------", LogToStandardOutput);


    }

    @Override
    public void onTestFailure(final ITestResult testName) {

        Reporter.log("</br>");
        final long ms = testName.getEndMillis() - testName.getStartMillis();
        Reporter.log("Execution Time :: " + ms + "  Milli Seconds", LogToStandardOutput);
        Reporter.log("</br>");
        Reporter.log("Completed TestCase :: " + testName.getName() + " => Status: FAIL", LogToStandardOutput);
        Reporter.log("</br>");
        Reporter.log("----------------------------------------------------------", LogToStandardOutput);

    }

    @Override
    public void onTestSkipped(final ITestResult testName) {
        Reporter.log("</br>");
        final long ms = testName.getEndMillis() - testName.getStartMillis();
        Reporter.log("Execution Time :: " + ms + "  Milli Seconds", LogToStandardOutput);
        Reporter.log("</br>");
        Reporter.log("Completed TestCase :: " + testName.getName() + " => Status: SKIPPED", LogToStandardOutput);
        Reporter.log("</br>");
        Reporter.log("----------------------------------------------------------", LogToStandardOutput);
    }


}
