package com.tencent.p127d.p135f;

/* renamed from: com.tencent.d.f.j */
public abstract class C37322j<T> {
    private volatile T mInstance;

    /* renamed from: mG */
    public abstract T mo19824mG();

    public final T get() {
        T t = this.mInstance;
        if (t == null) {
            synchronized (this) {
                t = this.mInstance;
                if (t == null) {
                    t = mo19824mG();
                    this.mInstance = t;
                }
            }
        }
        return t;
    }
}
