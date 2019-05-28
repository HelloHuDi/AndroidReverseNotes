package com.facebook;

public class FacebookOperationCanceledException extends FacebookException {
    static final long serialVersionUID = 1;

    public FacebookOperationCanceledException(String str) {
        super(str);
    }

    public FacebookOperationCanceledException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookOperationCanceledException(Throwable th) {
        super(th);
    }
}
