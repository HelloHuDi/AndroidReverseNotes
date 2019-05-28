package com.tencent.mm.d.a;

import android.os.Process;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8ScriptException;
import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class a implements c {
    private static int chl = 0;
    private MultiContextV8 chm;
    private d chn;
    private CountDownLatch cho;
    private MemoryManager chp;
    private x chq;
    f chr;
    String chs;
    byte[] cht;
    private final Map<Integer, h> chu;
    private final ConcurrentLinkedQueue<Runnable> chv;
    private volatile int mTid;

    public abstract MultiContextV8 Co();

    public abstract d Cp();

    public abstract void Cq();

    a() {
        this(null, null);
    }

    a(String str, byte[] bArr) {
        this.mTid = -1;
        this.chs = str;
        this.cht = bArr;
        this.chu = new HashMap();
        this.chv = new ConcurrentLinkedQueue();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.cho = new CountDownLatch(1);
        Object[] objArr = new Object[1];
        int i = chl;
        chl = i + 1;
        objArr[0] = Integer.valueOf(i);
        new Thread(String.format("JSRuntimeLooper#%d", objArr)) {
            public final void run() {
                AppMethodBeat.i(113796);
                a.this.mTid = Process.myTid();
                a.this.chn = a.this.Cp();
                a.this.chn.a(new com.tencent.mm.d.a.d.a() {
                    public final void b(V8ScriptException v8ScriptException) {
                        AppMethodBeat.i(113795);
                        a.this.a(v8ScriptException);
                        AppMethodBeat.o(113795);
                    }
                });
                countDownLatch.countDown();
                a.this.cho.countDown();
                long currentTimeMillis = System.currentTimeMillis();
                ab.i("MicroMsg.AbstractJSRuntime", "prepareV8WhenThreadStart");
                a.this.chm = a.this.Co();
                a.this.chq = new x(a.this.chm);
                a.this.chq;
                a.this.chp = a.this.chm.createMemoryManager();
                ab.i("MicroMsg.AbstractJSRuntime", "v8 init cost:%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                V8Locker v8Locker = a.this.chm.getV8Locker();
                if (v8Locker.hasLock()) {
                    ab.i("MicroMsg.AbstractJSRuntime", "has lock release");
                    v8Locker.release();
                }
                v8Locker.acquire();
                a.this.chn.loop();
                a.e(a.this);
                a.this.chp.release();
                a.this.chq;
                a.this.Cq();
                AppMethodBeat.o(113796);
            }
        }.start();
        try {
            countDownLatch.await(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            ab.i("MicroMsg.AbstractJSRuntime", "init latch.await InterruptedException:%s", e);
        }
    }

    public final f Cr() {
        if (this.chr == null) {
            this.chr = new s();
        }
        return this.chr;
    }

    public final void setThreadPriority(int i) {
        int i2 = this.mTid;
        if (i2 > 0) {
            try {
                Process.setThreadPriority(i2, i);
                ab.d("MicroMsg.AbstractJSRuntime", "setThreadPriority priority=%d tid=%d", Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AbstractJSRuntime", e, "setThreadPriority priority=%d tid=%d", Integer.valueOf(i), Integer.valueOf(i2));
            }
        }
    }

    public final void pause() {
        this.chn.pause();
    }

    public final void resume() {
        this.chn.resume();
    }

    public final void quit() {
        this.chn.quit();
        this.mTid = -1;
    }

    public final void k(Runnable runnable) {
        Ct();
        this.chn.m(runnable);
    }

    public final void f(Runnable runnable, long j) {
        Ct();
        this.chn.g(runnable, j);
    }

    public final boolean Cs() {
        return this.chn.Cs();
    }

    public final void l(Runnable runnable) {
        this.chv.add(runnable);
    }

    public final l gm(final int i) {
        return new l(this, Cr(), new com.tencent.mm.d.a.l.a() {
            public final V8Context Cu() {
                AppMethodBeat.i(113794);
                if (a.this.chm == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("createContext mV8 not ready!");
                    AppMethodBeat.o(113794);
                    throw illegalStateException;
                }
                V8Context createContext = a.this.chm.createContext(i);
                AppMethodBeat.o(113794);
                return createContext;
            }
        });
    }

    public final void a(int i, h hVar) {
        this.chu.put(Integer.valueOf(i), hVar);
    }

    private void Ct() {
        if (this.chn == null && this.cho != null) {
            ab.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
            try {
                this.cho.await(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                ab.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread latch.await InterruptedException:%s", e);
            }
            ab.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
        }
    }

    private void a(V8ScriptException v8ScriptException) {
        h hVar = (h) this.chu.get(Integer.valueOf(v8ScriptException.getContextTag()));
        if (hVar != null) {
            hVar.C(v8ScriptException.getJSMessage(), v8ScriptException.getJSStackTrace());
        } else {
            ab.w("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null");
        }
    }

    public final long getIsolatePtr() {
        return this.chm.getIsolatePtr();
    }

    public final void waitForDebugger(String str) {
        m mVar = new m(this.chm, this);
        mVar.cid.k(new com.tencent.mm.d.a.m.AnonymousClass1(str));
        mVar.cid.l(new Runnable() {
            public final void run() {
                AppMethodBeat.i(113853);
                if (m.this.cie != null) {
                    m.this.cie.cancel();
                }
                AppMethodBeat.o(113853);
            }
        });
    }

    static /* synthetic */ void e(a aVar) {
        while (true) {
            Runnable runnable = (Runnable) aVar.chv.poll();
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (V8ScriptException e) {
                    aVar.a(e);
                } catch (UndeclaredThrowableException e2) {
                    ab.e("MicroMsg.AbstractJSRuntime", "doPostedCleanUpJob UndeclaredThrowableException: %s %s", e2, e2.getCause());
                }
            } else {
                return;
            }
        }
    }
}
