package com.tencent.magicbrush.handler;

import android.support.annotation.Keep;
import com.tencent.magicbrush.p821d.C25714b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MBJsThreadHandler implements C17841a {
    private C17841a bSO;
    private final ReadWriteLock bSP = new ReentrantReadWriteLock();
    private volatile boolean mDestroyed = false;
    private long mNativeInst;

    private native long nativeCreate(long j);

    private native void nativeHandleMessage(long j, int i);

    public MBJsThreadHandler(C17841a c17841a) {
        AppMethodBeat.m2504i(115898);
        this.bSO = c17841a;
        AppMethodBeat.m2505o(115898);
    }

    @Keep
    public void sendMessage(int i) {
    }

    @Keep
    public void destroy() {
        AppMethodBeat.m2504i(115899);
        this.bSP.writeLock().lock();
        try {
            this.mDestroyed = true;
            this.mNativeInst = 0;
        } finally {
            this.bSP.writeLock().unlock();
            AppMethodBeat.m2505o(115899);
        }
    }

    /* renamed from: f */
    public final void mo33017f(Runnable runnable) {
        AppMethodBeat.m2504i(115900);
        this.bSO.mo33017f(runnable);
        AppMethodBeat.m2505o(115900);
    }

    /* renamed from: yE */
    public final boolean mo33018yE() {
        AppMethodBeat.m2504i(115901);
        boolean yE = this.bSO.mo33018yE();
        AppMethodBeat.m2505o(115901);
        return yE;
    }

    /* renamed from: a */
    public final <T> T mo41497a(Callable<T> callable) {
        AppMethodBeat.m2504i(115902);
        C25714b c25714b = new C25714b((Callable) callable);
        mo41499i(c25714b);
        Object obj = c25714b.get();
        AppMethodBeat.m2505o(115902);
        return obj;
    }

    /* renamed from: i */
    public final void mo41499i(Runnable runnable) {
        AppMethodBeat.m2504i(115903);
        if (this.bSO.mo33018yE()) {
            runnable.run();
            AppMethodBeat.m2505o(115903);
            return;
        }
        this.bSO.mo33017f(runnable);
        AppMethodBeat.m2505o(115903);
    }
}
