package com.tencent.tmassistantsdk.downloadservice;

public class StopRequestException extends Exception {
    protected static final long serialVersionUID = 1;
    public final int mFinalErrCode;

    public StopRequestException(int i, String str) {
        super(str);
        this.mFinalErrCode = i;
    }

    public StopRequestException(int i, Throwable th) {
        super(th);
        this.mFinalErrCode = i;
    }
}
