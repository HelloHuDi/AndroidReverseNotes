package com.tencent.magicbrush.handler;

import android.support.annotation.Keep;
import com.tencent.magicbrush.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MBJsThreadHandler implements a {
    private a bSO;
    private final ReadWriteLock bSP = new ReentrantReadWriteLock();
    private volatile boolean mDestroyed = false;
    private long mNativeInst;

    private native long nativeCreate(long j);

    private native void nativeHandleMessage(long j, int i);

    public MBJsThreadHandler(a aVar) {
        AppMethodBeat.i(115898);
        this.bSO = aVar;
        AppMethodBeat.o(115898);
    }

    @Keep
    public void sendMessage(int i) {
    }

    @Keep
    public void destroy() {
        AppMethodBeat.i(115899);
        this.bSP.writeLock().lock();
        try {
            this.mDestroyed = true;
            this.mNativeInst = 0;
        } finally {
            this.bSP.writeLock().unlock();
            AppMethodBeat.o(115899);
        }
    }

    public final void f(Runnable runnable) {
        AppMethodBeat.i(115900);
        this.bSO.f(runnable);
        AppMethodBeat.o(115900);
    }

    public final boolean yE() {
        AppMethodBeat.i(115901);
        boolean yE = this.bSO.yE();
        AppMethodBeat.o(115901);
        return yE;
    }

    public final <T> T a(Callable<T> callable) {
        AppMethodBeat.i(115902);
        b bVar = new b((Callable) callable);
        i(bVar);
        Object obj = bVar.get();
        AppMethodBeat.o(115902);
        return obj;
    }

    public final void i(Runnable runnable) {
        AppMethodBeat.i(115903);
        if (this.bSO.yE()) {
            runnable.run();
            AppMethodBeat.o(115903);
            return;
        }
        this.bSO.f(runnable);
        AppMethodBeat.o(115903);
    }
}
