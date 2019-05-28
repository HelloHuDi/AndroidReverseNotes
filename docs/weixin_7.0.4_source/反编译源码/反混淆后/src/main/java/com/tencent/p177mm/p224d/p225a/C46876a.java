package com.tencent.p177mm.p224d.p225a;

import android.os.Process;
import com.eclipsesource.p097v8.MultiContextV8;
import com.eclipsesource.p097v8.V8Context;
import com.eclipsesource.p097v8.V8Locker;
import com.eclipsesource.p097v8.V8ScriptException;
import com.eclipsesource.p097v8.utils.MemoryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C32488l.C32493a;
import com.tencent.p177mm.p224d.p225a.C9254d.C9255a;
import com.tencent.p177mm.p224d.p225a.C9260m.C92612;
import com.tencent.p177mm.p224d.p225a.C9260m.C92631;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.d.a.a */
public abstract class C46876a implements C45301c {
    private static int chl = 0;
    private MultiContextV8 chm;
    private C9254d chn;
    private CountDownLatch cho;
    private MemoryManager chp;
    private C26067x chq;
    C9256f chr;
    String chs;
    byte[] cht;
    private final Map<Integer, C33211h> chu;
    private final ConcurrentLinkedQueue<Runnable> chv;
    private volatile int mTid;

    /* renamed from: Co */
    public abstract MultiContextV8 mo43932Co();

    /* renamed from: Cp */
    public abstract C9254d mo43933Cp();

    /* renamed from: Cq */
    public abstract void mo43934Cq();

    C46876a() {
        this(null, null);
    }

    C46876a(String str, byte[] bArr) {
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

            /* renamed from: com.tencent.mm.d.a.a$2$1 */
            class C324801 implements C9255a {
                C324801() {
                }

                /* renamed from: b */
                public final void mo20674b(V8ScriptException v8ScriptException) {
                    AppMethodBeat.m2504i(113795);
                    C46876a.this.m89162a(v8ScriptException);
                    AppMethodBeat.m2505o(113795);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(113796);
                C46876a.this.mTid = Process.myTid();
                C46876a.this.chn = C46876a.this.mo43933Cp();
                C46876a.this.chn.mo20667a(new C324801());
                countDownLatch.countDown();
                C46876a.this.cho.countDown();
                long currentTimeMillis = System.currentTimeMillis();
                C4990ab.m7416i("MicroMsg.AbstractJSRuntime", "prepareV8WhenThreadStart");
                C46876a.this.chm = C46876a.this.mo43932Co();
                C46876a.this.chq = new C26067x(C46876a.this.chm);
                C46876a.this.chq;
                C46876a.this.chp = C46876a.this.chm.createMemoryManager();
                C4990ab.m7417i("MicroMsg.AbstractJSRuntime", "v8 init cost:%d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                V8Locker v8Locker = C46876a.this.chm.getV8Locker();
                if (v8Locker.hasLock()) {
                    C4990ab.m7416i("MicroMsg.AbstractJSRuntime", "has lock release");
                    v8Locker.release();
                }
                v8Locker.acquire();
                C46876a.this.chn.loop();
                C46876a.m89167e(C46876a.this);
                C46876a.this.chp.release();
                C46876a.this.chq;
                C46876a.this.mo43934Cq();
                AppMethodBeat.m2505o(113796);
            }
        }.start();
        try {
            countDownLatch.await(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            C4990ab.m7417i("MicroMsg.AbstractJSRuntime", "init latch.await InterruptedException:%s", e);
        }
    }

    /* renamed from: Cr */
    public final C9256f mo76047Cr() {
        if (this.chr == null) {
            this.chr = new C45303s();
        }
        return this.chr;
    }

    public final void setThreadPriority(int i) {
        int i2 = this.mTid;
        if (i2 > 0) {
            try {
                Process.setThreadPriority(i2, i);
                C4990ab.m7411d("MicroMsg.AbstractJSRuntime", "setThreadPriority priority=%d tid=%d", Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AbstractJSRuntime", e, "setThreadPriority priority=%d tid=%d", Integer.valueOf(i), Integer.valueOf(i2));
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

    /* renamed from: k */
    public final void mo73187k(Runnable runnable) {
        m89155Ct();
        this.chn.mo20670m(runnable);
    }

    /* renamed from: f */
    public final void mo73184f(Runnable runnable, long j) {
        m89155Ct();
        this.chn.mo20668g(runnable, j);
    }

    /* renamed from: Cs */
    public final boolean mo73182Cs() {
        return this.chn.mo20666Cs();
    }

    /* renamed from: l */
    public final void mo73188l(Runnable runnable) {
        this.chv.add(runnable);
    }

    /* renamed from: gm */
    public final C32488l mo73186gm(final int i) {
        return new C32488l(this, mo76047Cr(), new C32493a() {
            /* renamed from: Cu */
            public final V8Context mo53127Cu() {
                AppMethodBeat.m2504i(113794);
                if (C46876a.this.chm == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("createContext mV8 not ready!");
                    AppMethodBeat.m2505o(113794);
                    throw illegalStateException;
                }
                V8Context createContext = C46876a.this.chm.createContext(i);
                AppMethodBeat.m2505o(113794);
                return createContext;
            }
        });
    }

    /* renamed from: a */
    public final void mo73183a(int i, C33211h c33211h) {
        this.chu.put(Integer.valueOf(i), c33211h);
    }

    /* renamed from: Ct */
    private void m89155Ct() {
        if (this.chn == null && this.cho != null) {
            C4990ab.m7416i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
            try {
                this.cho.await(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                C4990ab.m7417i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread latch.await InterruptedException:%s", e);
            }
            C4990ab.m7416i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
        }
    }

    /* renamed from: a */
    private void m89162a(V8ScriptException v8ScriptException) {
        C33211h c33211h = (C33211h) this.chu.get(Integer.valueOf(v8ScriptException.getContextTag()));
        if (c33211h != null) {
            c33211h.mo5989C(v8ScriptException.getJSMessage(), v8ScriptException.getJSStackTrace());
        } else {
            C4990ab.m7420w("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null");
        }
    }

    public final long getIsolatePtr() {
        return this.chm.getIsolatePtr();
    }

    public final void waitForDebugger(String str) {
        C9260m c9260m = new C9260m(this.chm, this);
        c9260m.cid.mo73187k(new C92631(str));
        c9260m.cid.mo73188l(new C92612());
    }

    /* renamed from: e */
    static /* synthetic */ void m89167e(C46876a c46876a) {
        while (true) {
            Runnable runnable = (Runnable) c46876a.chv.poll();
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (V8ScriptException e) {
                    c46876a.m89162a(e);
                } catch (UndeclaredThrowableException e2) {
                    C4990ab.m7413e("MicroMsg.AbstractJSRuntime", "doPostedCleanUpJob UndeclaredThrowableException: %s %s", e2, e2.getCause());
                }
            } else {
                return;
            }
        }
    }
}
