package com.google.p114b;

/* renamed from: com.google.b.f */
public abstract class C8739f extends Exception {
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

    C8739f() {
    }

    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
