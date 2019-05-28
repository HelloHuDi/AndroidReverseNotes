package com.google.android.gms.auth;

public class GoogleAuthException extends Exception {
    public GoogleAuthException(String str) {
        super(str);
    }

    public GoogleAuthException(String str, Throwable th) {
        super(str, th);
    }

    public GoogleAuthException(Throwable th) {
        super(th);
    }
}
