package com.tencent.d.f;

public abstract class j<T> {
    private volatile T mInstance;

    public abstract T mG();

    public final T get() {
        T t = this.mInstance;
        if (t == null) {
            synchronized (this) {
                t = this.mInstance;
                if (t == null) {
                    t = mG();
                    this.mInstance = t;
                }
            }
        }
        return t;
    }
}
