package com.google.firebase.iid;

public final class d extends Exception {
    final int errorCode;

    public d(int i, String str) {
        super(str);
        this.errorCode = i;
    }
}
