package com.tencent.mm.accessibility;

public class AccessibilityCaptureNotSupportException extends Exception {
    public AccessibilityCaptureNotSupportException(String str) {
        super(str);
    }

    public AccessibilityCaptureNotSupportException(String str, Throwable th) {
        super(str, th);
    }

    public AccessibilityCaptureNotSupportException(Throwable th) {
        super(th);
    }
}
