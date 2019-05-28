package com.tencent.p659pb.common.p1102c;

/* renamed from: com.tencent.pb.common.c.e */
public abstract class C40955e<T> {
    private T mInstance;

    /* renamed from: mG */
    public abstract T mo13134mG();

    public final T get() {
        Object obj;
        synchronized (this) {
            if (this.mInstance == null) {
                this.mInstance = mo13134mG();
            }
            obj = this.mInstance;
        }
        return obj;
    }
}
