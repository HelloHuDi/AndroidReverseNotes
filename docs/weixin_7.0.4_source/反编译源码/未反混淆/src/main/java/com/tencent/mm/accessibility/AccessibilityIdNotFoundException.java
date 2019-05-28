package com.tencent.mm.accessibility;

public class AccessibilityIdNotFoundException extends AccessibilityCaptureNotSupportException {
    public AccessibilityIdNotFoundException() {
        super("Unable to find accessibility id");
    }

    public AccessibilityIdNotFoundException(String str) {
        super(str);
    }

    public AccessibilityIdNotFoundException(Throwable th) {
        super("Unable to find accessibility id", th);
    }

    public AccessibilityIdNotFoundException(String str, Throwable th) {
        super(str, th);
    }
}
