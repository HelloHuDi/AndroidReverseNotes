package com.google.android.gms.common.api;

public final class BatchResultToken<R extends Result> {
    protected final int mId;

    BatchResultToken(int i) {
        this.mId = i;
    }
}
