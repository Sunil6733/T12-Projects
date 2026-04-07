package com.example;

import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class TestListeners extends RunListener {

    @Override
    public void testStarted(org.junit.runner.Description description) {
        System.out.println("✓ Test started: " + description.getMethodName());
    }

    @Override
    public void testFailure(Failure failure) {
        System.out.println("✗ Test failed: " + failure.getDescription().getMethodName());
        System.out.println("  Error: " + failure.getMessage());
    }

    @Override
    public void testFinished(org.junit.runner.Description description) {
        System.out.println("✓ Test finished: " + description.getMethodName());
    }

    public void onTestStart() {
        System.out.println("=== Test Execution Started ===");
    }

    public void onTestEnd() {
        System.out.println("=== Test Execution Completed ===");
    }
}
