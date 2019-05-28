package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.c.c;
import junit.framework.Assert;

public class al {
    private static ak xzh = null;
    private ak mcy = null;
    public HandlerThread oAl = null;
    private String threadName = null;

    public interface a {
        boolean acf();

        boolean acg();
    }

    public interface b {
        void wM();
    }

    static /* synthetic */ void a(al alVar, String str) {
        AppMethodBeat.i(52140);
        alVar.Az(str);
        AppMethodBeat.o(52140);
    }

    private void Az(String str) {
        AppMethodBeat.i(52118);
        this.mcy = null;
        if (bo.isNullOrNil(str)) {
            str = "MMHandlerThread";
        }
        this.threadName = str;
        this.oAl = c.anN(this.threadName);
        this.oAl.start();
        AppMethodBeat.o(52118);
    }

    public static void Ma(int i) {
        AppMethodBeat.i(52119);
        try {
            Process.setThreadPriority(i);
            ab.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", Integer.valueOf(i));
            AppMethodBeat.o(52119);
        } catch (Exception e) {
            ab.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", Integer.valueOf(i), e.getMessage());
            ab.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
            AppMethodBeat.o(52119);
        }
    }

    public final void doK() {
        AppMethodBeat.i(52120);
        if (this.oAl == null || !this.oAl.isAlive()) {
            ab.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
            AppMethodBeat.o(52120);
            return;
        }
        int threadId = this.oAl.getThreadId();
        try {
            if (19 == Process.getThreadPriority(threadId)) {
                ab.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
                AppMethodBeat.o(52120);
                return;
            }
            Process.setThreadPriority(threadId, 19);
            ab.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.o(52120);
        } catch (Exception e) {
            ab.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", Integer.valueOf(threadId));
            ab.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
            AppMethodBeat.o(52120);
        }
    }

    public final int doL() {
        AppMethodBeat.i(52121);
        if (this.oAl == null) {
            AppMethodBeat.o(52121);
            return -1;
        }
        int threadId = this.oAl.getThreadId();
        AppMethodBeat.o(52121);
        return threadId;
    }

    public final void Bn() {
        AppMethodBeat.i(52122);
        if (this.oAl == null || !this.oAl.isAlive()) {
            ab.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
            AppMethodBeat.o(52122);
            return;
        }
        int threadId = this.oAl.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                ab.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
                AppMethodBeat.o(52122);
                return;
            }
            Process.setThreadPriority(threadId, -8);
            ab.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.o(52122);
        } catch (Exception e) {
            ab.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            ab.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
            AppMethodBeat.o(52122);
        }
    }

    public final void doM() {
        AppMethodBeat.i(52123);
        if (this.oAl == null || !this.oAl.isAlive()) {
            ab.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
            AppMethodBeat.o(52123);
            return;
        }
        int threadId = this.oAl.getThreadId();
        try {
            if (Process.getThreadPriority(threadId) == 0) {
                ab.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
                AppMethodBeat.o(52123);
                return;
            }
            Process.setThreadPriority(threadId, 0);
            ab.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.o(52123);
        } catch (Exception e) {
            ab.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", Integer.valueOf(threadId));
            ab.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
            AppMethodBeat.o(52123);
        }
    }

    public al() {
        AppMethodBeat.i(52124);
        ab.i("MicroMsg.MMHandlerThread", "init stack:%s", bo.dpG());
        Az(null);
        AppMethodBeat.o(52124);
    }

    public al(String str) {
        AppMethodBeat.i(52125);
        Az(str);
        AppMethodBeat.o(52125);
    }

    public final Looper getLooper() {
        AppMethodBeat.i(138961);
        Looper looper = this.oAl.getLooper();
        AppMethodBeat.o(138961);
        return looper;
    }

    public final ak doN() {
        AppMethodBeat.i(52127);
        if (this.mcy == null) {
            this.mcy = new ak(this.oAl.getLooper());
        }
        ak akVar = this.mcy;
        AppMethodBeat.o(52127);
        return akVar;
    }

    public final int a(final b bVar) {
        int a;
        AppMethodBeat.i(52128);
        ab.i("MicroMsg.MMHandlerThread", "syncReset tid[%d] stack:%s", Long.valueOf(Thread.currentThread().getId()), bo.dpG());
        Assert.assertTrue("syncReset should in mainThread", isMainThread());
        long id = this.oAl.getId();
        final byte[] bArr = new byte[0];
        final String str = this.threadName;
        a anonymousClass1 = new a() {
            public final boolean acg() {
                AppMethodBeat.i(52113);
                ab.i("MicroMsg.MMHandlerThread", "syncReset onPostExecute");
                AppMethodBeat.o(52113);
                return true;
            }

            public final boolean acf() {
                AppMethodBeat.i(52114);
                ab.i("MicroMsg.MMHandlerThread", "syncReset doInBackground tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                if (bVar != null) {
                    bVar.wM();
                }
                ab.i("MicroMsg.MMHandlerThread", "syncReset doInBackground callback done tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                al.this.oAl.quit();
                ab.i("MicroMsg.MMHandlerThread", "syncReset init start old tid[%d]", Long.valueOf(al.this.oAl.getId()));
                al.a(al.this, str);
                ab.i("MicroMsg.MMHandlerThread", "syncReset init done new tid[%d]", Long.valueOf(al.this.oAl.getId()));
                synchronized (bArr) {
                    try {
                        ab.i("MicroMsg.MMHandlerThread", "syncReset notify tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                        bArr.notify();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(52114);
                    }
                }
                return true;
            }
        };
        synchronized (bArr) {
            try {
                a = a(anonymousClass1);
                ab.i("MicroMsg.MMHandlerThread", "syncReset postAtFrontOfWorker ret[%d], oldTid[%d], curTid[%d]", Integer.valueOf(a), Long.valueOf(id), Long.valueOf(this.oAl.getId()));
                if (a == 0 && id == r4) {
                    bArr.wait();
                }
            } catch (Exception e) {
                ab.d("MicroMsg.MMHandlerThread", "syncReset lock wait end with exception[%s]", e.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.o(52128);
            }
        }
        AppMethodBeat.o(52128);
        return a;
    }

    public final boolean quit() {
        AppMethodBeat.i(138962);
        boolean quit = this.oAl.quit();
        AppMethodBeat.o(138962);
        return quit;
    }

    public int aa(Runnable runnable) {
        AppMethodBeat.i(52130);
        if (runnable == null) {
            AppMethodBeat.o(52130);
            return -1;
        }
        doN().post(runnable);
        AppMethodBeat.o(52130);
        return 0;
    }

    public final int ae(Runnable runnable) {
        AppMethodBeat.i(52131);
        doN().postAtFrontOfQueueV2(runnable);
        AppMethodBeat.o(52131);
        return 0;
    }

    public final int m(Runnable runnable, long j) {
        AppMethodBeat.i(52132);
        if (runnable == null) {
            AppMethodBeat.o(52132);
            return -1;
        }
        doN().postDelayed(runnable, j);
        AppMethodBeat.o(52132);
        return 0;
    }

    public final int a(final a aVar) {
        AppMethodBeat.i(52133);
        if (new ak(this.oAl.getLooper()).postAtFrontOfQueueV2(new Runnable() {
            public final void run() {
                AppMethodBeat.i(52116);
                aVar.acf();
                al.ag(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(52115);
                        aVar.acg();
                        AppMethodBeat.o(52115);
                    }
                });
                AppMethodBeat.o(52116);
            }

            public final String toString() {
                AppMethodBeat.i(52117);
                String str = super.toString() + "|" + aVar.toString();
                AppMethodBeat.o(52117);
                return str;
            }
        })) {
            AppMethodBeat.o(52133);
            return 0;
        }
        AppMethodBeat.o(52133);
        return -2;
    }

    public static boolean isMainThread() {
        AppMethodBeat.i(52134);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            AppMethodBeat.o(52134);
            return true;
        }
        AppMethodBeat.o(52134);
        return false;
    }

    public final boolean doO() {
        AppMethodBeat.i(52135);
        if (Thread.currentThread().getId() == this.oAl.getId()) {
            AppMethodBeat.o(52135);
            return true;
        }
        AppMethodBeat.o(52135);
        return false;
    }

    private static ak doP() {
        AppMethodBeat.i(52136);
        if (xzh == null) {
            xzh = new ak(Looper.getMainLooper());
        }
        ak akVar = xzh;
        AppMethodBeat.o(52136);
        return akVar;
    }

    public static void d(Runnable runnable) {
        AppMethodBeat.i(52137);
        if (runnable == null) {
            AppMethodBeat.o(52137);
            return;
        }
        doP().post(runnable);
        AppMethodBeat.o(52137);
    }

    public static void n(Runnable runnable, long j) {
        AppMethodBeat.i(52138);
        if (runnable == null) {
            AppMethodBeat.o(52138);
            return;
        }
        doP().postDelayed(runnable, j);
        AppMethodBeat.o(52138);
    }

    public static void af(Runnable runnable) {
        AppMethodBeat.i(52139);
        if (runnable == null) {
            AppMethodBeat.o(52139);
            return;
        }
        doP().removeCallbacks(runnable);
        AppMethodBeat.o(52139);
    }

    static /* synthetic */ void ag(Runnable runnable) {
        AppMethodBeat.i(52141);
        doP().postAtFrontOfQueueV2(runnable);
        AppMethodBeat.o(52141);
    }
}
