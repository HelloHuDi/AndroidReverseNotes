package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.ConcurrentLinkedQueue;

class w implements d {
    private static final ThreadLocal<w> chH = new ThreadLocal();
    private final Thread ciK = Thread.currentThread();
    private final ConcurrentLinkedQueue<Runnable> ciL = new ConcurrentLinkedQueue();
    private boolean ciM;
    private a ciN;
    private boolean mPaused;

    static {
        AppMethodBeat.i(113918);
        AppMethodBeat.o(113918);
    }

    public static w CE() {
        AppMethodBeat.i(113905);
        if (chH.get() != null) {
            RuntimeException runtimeException = new RuntimeException("Only one Looper may be created per thread");
            AppMethodBeat.o(113905);
            throw runtimeException;
        }
        w wVar = new w();
        chH.set(wVar);
        AppMethodBeat.o(113905);
        return wVar;
    }

    w() {
        AppMethodBeat.i(113906);
        AppMethodBeat.o(113906);
    }

    public final void loop() {
        AppMethodBeat.i(113907);
        ab.i("MicroMsg.V8JSRuntimeLooper", "loop start");
        while (!this.ciK.isInterrupted()) {
            synchronized (this.ciL) {
                while (true) {
                    try {
                        if (!isPaused() && !Cx()) {
                            break;
                        }
                        this.ciL.wait();
                    } catch (InterruptedException e) {
                        ab.i("MicroMsg.V8JSRuntimeLooper", "wait interrupted ; loop end");
                        this.ciK.interrupt();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(113907);
                        }
                    }
                }
            }
            Cy();
        }
        synchronized (this) {
            try {
                this.ciM = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(113907);
            }
        }
        Cz();
    }

    public final boolean Cs() {
        AppMethodBeat.i(113908);
        if (Thread.currentThread().getId() == this.ciK.getId()) {
            AppMethodBeat.o(113908);
            return true;
        }
        AppMethodBeat.o(113908);
        return false;
    }

    /* JADX WARNING: Missing block: B:12:0x0030, code skipped:
            if (java.lang.Thread.currentThread().getId() != r5.ciK.getId()) goto L_0x0042;
     */
    /* JADX WARNING: Missing block: B:13:0x0032, code skipped:
            n(r6);
     */
    /* JADX WARNING: Missing block: B:14:0x0035, code skipped:
            CA();
            com.tencent.matrix.trace.core.AppMethodBeat.o(113909);
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
            com.tencent.matrix.trace.core.AppMethodBeat.o(113909);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(Runnable runnable) {
        AppMethodBeat.i(113909);
        if (runnable == null) {
            AppMethodBeat.o(113909);
            return;
        }
        synchronized (this) {
            try {
                if (this.ciM) {
                    ab.i("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(113909);
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
            CA();
     */
    /* JADX WARNING: Missing block: B:28:0x004f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(113910);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(Runnable runnable, long j) {
        AppMethodBeat.i(113910);
        if (runnable == null) {
            AppMethodBeat.o(113910);
        } else if (j != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
            AppMethodBeat.o(113910);
            throw illegalStateException;
        } else {
            synchronized (this) {
                try {
                    if (this.ciM) {
                        ab.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed but looper end");
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(113910);
                }
            }
        }
    }

    public final void pause() {
        AppMethodBeat.i(113911);
        ab.i("MicroMsg.V8JSRuntimeLooper", "pause");
        synchronized (this) {
            try {
                this.mPaused = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(113911);
            }
        }
    }

    public final void resume() {
        AppMethodBeat.i(113912);
        ab.i("MicroMsg.V8JSRuntimeLooper", "resume");
        this.mPaused = false;
        synchronized (this.ciL) {
            try {
                this.ciL.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(113912);
            }
        }
    }

    public final void quit() {
        AppMethodBeat.i(113913);
        ab.i("MicroMsg.V8JSRuntimeLooper", "quit");
        this.ciK.interrupt();
        AppMethodBeat.o(113913);
    }

    public final void a(a aVar) {
        this.ciN = aVar;
    }

    /* Access modifiers changed, original: protected */
    public boolean Cx() {
        AppMethodBeat.i(113914);
        boolean isEmpty = this.ciL.isEmpty();
        AppMethodBeat.o(113914);
        return isEmpty;
    }

    private synchronized boolean isPaused() {
        return this.mPaused;
    }

    /* Access modifiers changed, original: protected */
    public void Cz() {
        AppMethodBeat.i(113915);
        ab.i("MicroMsg.V8JSRuntimeLooper", "loop end");
        AppMethodBeat.o(113915);
    }

    /* Access modifiers changed, original: protected */
    public void CA() {
    }

    /* Access modifiers changed, original: protected */
    public void Cy() {
        AppMethodBeat.i(113916);
        while (true) {
            Runnable runnable = (Runnable) this.ciL.poll();
            if (runnable != null) {
                n(runnable);
            } else {
                AppMethodBeat.o(113916);
                return;
            }
        }
    }

    private void n(Runnable runnable) {
        AppMethodBeat.i(113917);
        try {
            runnable.run();
            AppMethodBeat.o(113917);
        } catch (V8ScriptException e) {
            if (this.ciN != null) {
                this.ciN.b(e);
            }
            AppMethodBeat.o(113917);
        } catch (UndeclaredThrowableException e2) {
            ab.e("MicroMsg.V8JSRuntimeLooper", "runTask UndeclaredThrowableException: %s %s", e2, e2.getCause());
            AppMethodBeat.o(113917);
        }
    }
}
