package com.qaexample;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TestListeners extends RunListener {
    @Override
    public void testStarted(Description description) {
        System.out.println("[TEST START] " + description.getDisplayName());
    }

    @Override
    public void testFinished(Description description) {
        System.out.println("[TEST FINISHED] " + description.getDisplayName());
    }

    @Override
    public void testFailure(Failure failure) {
        System.err.println("[TEST FAILED] " + failure.getDescription() + " - " + failure.getMessage());
    }
}
