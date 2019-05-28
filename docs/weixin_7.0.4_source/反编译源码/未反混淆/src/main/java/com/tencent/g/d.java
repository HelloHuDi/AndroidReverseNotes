package com.tencent.g;

public abstract class d<T extends e> {
    private T[] AHz = dSC();
    private final Object mLock = new Object();
    private int qyr;

    public abstract T[] dSC();

    public abstract T dSD();

    public final T dSE() {
        T dSF = dSF();
        if (dSF == null) {
            return dSD();
        }
        dSF.reset();
        return dSF;
    }

    public final void a(T t) {
        synchronized (this.mLock) {
            if (this.qyr < this.AHz.length) {
                this.AHz[this.qyr] = t;
                this.qyr++;
            }
        }
    }

    private T dSF() {
        T t = null;
        synchronized (this.mLock) {
            if (this.qyr > 0) {
                this.qyr--;
                t = this.AHz[this.qyr];
                this.AHz[this.qyr] = null;
            }
        }
        return t;
    }
}
