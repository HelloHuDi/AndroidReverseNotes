package com.google.android.gms.common.api;

public class Response<T extends Result> {
    private T zzdm;

    protected Response(T t) {
        this.zzdm = t;
    }

    /* Access modifiers changed, original: protected */
    public T getResult() {
        return this.zzdm;
    }

    public void setResult(T t) {
        this.zzdm = t;
    }
}
