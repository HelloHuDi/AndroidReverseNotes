package com.tencent.p177mm.p224d.p225a;

import com.eclipsesource.p097v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C9254d.C9255a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.d.a.w */
class C16537w implements C9254d {
    private static final ThreadLocal<C16537w> chH = new ThreadLocal();
    private final Thread ciK = Thread.currentThread();
    private final ConcurrentLinkedQueue<Runnable> ciL = new ConcurrentLinkedQueue();
    private boolean ciM;
    private C9255a ciN;
    private boolean mPaused;

    static {
        AppMethodBeat.m2504i(113918);
        AppMethodBeat.m2505o(113918);
    }

    /* renamed from: CE */
    public static C16537w m25411CE() {
        AppMethodBeat.m2504i(113905);
        if (chH.get() != null) {
            RuntimeException runtimeException = new RuntimeException("Only one Looper may be created per thread");
            AppMethodBeat.m2505o(113905);
            throw runtimeException;
        }
        C16537w c16537w = new C16537w();
        chH.set(c16537w);
        AppMethodBeat.m2505o(113905);
        return c16537w;
    }

    C16537w() {
        AppMethodBeat.m2504i(113906);
        AppMethodBeat.m2505o(113906);
    }

    public final void loop() {
        AppMethodBeat.m2504i(113907);
        C4990ab.m7416i("MicroMsg.V8JSRuntimeLooper", "loop start");
        while (!this.ciK.isInterrupted()) {
            synchronized (this.ciL) {
                while (true) {
                    try {
                        if (!isPaused() && !mo30506Cx()) {
                            break;
                        }
                        this.ciL.wait();
                    } catch (InterruptedException e) {
                        C4990ab.m7416i("MicroMsg.V8JSRuntimeLooper", "wait interrupted ; loop end");
                        this.ciK.interrupt();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(113907);
                        }
                    }
                }
            }
            mo30507Cy();
        }
        synchronized (this) {
            try {
                this.ciM = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(113907);
            }
        }
        mo30508Cz();
    }

    /* renamed from: Cs */
    public final boolean mo20666Cs() {
        AppMethodBeat.m2504i(113908);
        if (Thread.currentThread().getId() == this.ciK.getId()) {
            AppMethodBeat.m2505o(113908);
            return true;
        }
        AppMethodBeat.m2505o(113908);
        return false;
    }

    /* JADX WARNING: Missing block: B:12:0x0030, code skipped:
            if (java.lang.Thread.currentThread().getId() != r5.ciK.getId()) goto L_0x0042;
     */
    /* JADX WARNING: Missing block: B:13:0x0032, code skipped:
            m25412n(r6);
     */
    /* JADX WARNING: Missing block: B:14:0x0035, code skipped:
            mo30505CA();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(113909);
     */
    /* JADX WARNING: Missing block: B:19:0x0042, code skipped:
            r5.ciL.offer(r6);
            r1 = r5.ciL;
     */
    /* JADX WARNING: Missing block: B:20:0x0049, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            r5.ciL.notify();
     */
    /* JADX WARNING: Missing block: B:23:0x004f, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:26:0x0053, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(113909);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: m */
    public final void mo20670m(Runnable runnable) {
        AppMethodBeat.m2504i(113909);
        if (runnable == null) {
            AppMethodBeat.m2505o(113909);
            return;
        }
        synchronized (this) {
            try {
                if (this.ciM) {
                    C4990ab.m7416i("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(113909);
            }
        }
    }

    /* JADX WARNING: Missing block: B:15:0x0032, code skipped:
            r4.ciL.offer(r5);
            r1 = r4.ciL;
     */
    /* JADX WARNING: Missing block: B:16:0x0039, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:18:?, code skipped:
            r4.ciL.notify();
     */
    /* JADX WARNING: Missing block: B:19:0x003f, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:20:0x0040, code skipped:
            mo30505CA();
     */
    /* JADX WARNING: Missing block: B:28:0x004f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(113910);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public final void mo20668g(Runnable runnable, long j) {
        AppMethodBeat.m2504i(113910);
        if (runnable == null) {
            AppMethodBeat.m2505o(113910);
        } else if (j != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
            AppMethodBeat.m2505o(113910);
            throw illegalStateException;
        } else {
            synchronized (this) {
                try {
                    if (this.ciM) {
                        C4990ab.m7416i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed but looper end");
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(113910);
                }
            }
        }
    }

    public final void pause() {
        AppMethodBeat.m2504i(113911);
        C4990ab.m7416i("MicroMsg.V8JSRuntimeLooper", "pause");
        synchronized (this) {
            try {
                this.mPaused = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(113911);
            }
        }
    }

    public final void resume() {
        AppMethodBeat.m2504i(113912);
        C4990ab.m7416i("MicroMsg.V8JSRuntimeLooper", "resume");
        this.mPaused = false;
        synchronized (this.ciL) {
            try {
                this.ciL.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(113912);
            }
        }
    }

    public final void quit() {
        AppMethodBeat.m2504i(113913);
        C4990ab.m7416i("MicroMsg.V8JSRuntimeLooper", "quit");
        this.ciK.interrupt();
        AppMethodBeat.m2505o(113913);
    }

    /* renamed from: a */
    public final void mo20667a(C9255a c9255a) {
        this.ciN = c9255a;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Cx */
    public boolean mo30506Cx() {
        AppMethodBeat.m2504i(113914);
        boolean isEmpty = this.ciL.isEmpty();
        AppMethodBeat.m2505o(113914);
        return isEmpty;
    }

    private synchronized boolean isPaused() {
        return this.mPaused;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Cz */
    public void mo30508Cz() {
        AppMethodBeat.m2504i(113915);
        C4990ab.m7416i("MicroMsg.V8JSRuntimeLooper", "loop end");
        AppMethodBeat.m2505o(113915);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: CA */
    public void mo30505CA() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Cy */
    public void mo30507Cy() {
        AppMethodBeat.m2504i(113916);
        while (true) {
            Runnable runnable = (Runnable) this.ciL.poll();
            if (runnable != null) {
                m25412n(runnable);
            } else {
                AppMethodBeat.m2505o(113916);
                return;
            }
        }
    }

    /* renamed from: n */
    private void m25412n(Runnable runnable) {
        AppMethodBeat.m2504i(113917);
        try {
            runnable.run();
            AppMethodBeat.m2505o(113917);
        } catch (V8ScriptException e) {
            if (this.ciN != null) {
                this.ciN.mo20674b(e);
            }
            AppMethodBeat.m2505o(113917);
        } catch (UndeclaredThrowableException e2) {
            C4990ab.m7413e("MicroMsg.V8JSRuntimeLooper", "runTask UndeclaredThrowableException: %s %s", e2, e2.getCause());
            AppMethodBeat.m2505o(113917);
        }
    }
}
