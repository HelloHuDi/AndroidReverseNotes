package com.google.b;

public abstract class f extends Exception {
    protected static final boolean byh;
    protected static final StackTraceElement[] byi = new StackTraceElement[0];

    static {
        boolean z;
        if (System.getProperty("surefire.test.class.path") != null) {
            z = true;
        } else {
            z = false;
        }
        byh = z;
    }

    f() {
    }

    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
