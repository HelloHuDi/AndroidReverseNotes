package com.tencent.pb.common.c;

public abstract class e<T> {
    private T mInstance;

    public abstract T mG();

    public final T get() {
        Object obj;
        synchronized (this) {
            if (this.mInstance == null) {
                this.mInstance = mG();
            }
            obj = this.mInstance;
        }
        return obj;
    }
}
