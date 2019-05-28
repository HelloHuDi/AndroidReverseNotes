package com.tencent.tinker.loader.hotplug.interceptor;

public abstract class Interceptor<T_TARGET> {
    private T_TARGET ADy = null;
    private volatile boolean mInstalled = false;

    protected interface ITinkerHotplugProxy {
    }

    public abstract T_TARGET dSm();

    public abstract void de(T_TARGET t_target);

    /* Access modifiers changed, original: protected */
    public T_TARGET df(T_TARGET t_target) {
        return t_target;
    }

    public final synchronized void dSn() {
        try {
            Object dSm = dSm();
            this.ADy = dSm;
            Object df = df(dSm);
            if (df != dSm) {
                de(df);
            } else {
                new StringBuilder("target: ").append(dSm).append(" was already hooked.");
            }
            this.mInstalled = true;
        } catch (Throwable th) {
            this.ADy = null;
            InterceptFailedException interceptFailedException = new InterceptFailedException(th);
        }
    }

    public final synchronized void uninstall() {
        if (this.mInstalled) {
            try {
                de(this.ADy);
                this.ADy = null;
                this.mInstalled = false;
            } catch (Throwable th) {
                InterceptFailedException interceptFailedException = new InterceptFailedException(th);
            }
        }
    }
}
