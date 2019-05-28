package com.tencent.p177mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.p607c.C4960c;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.sdk.platformtools.al */
public class C5004al {
    private static C7306ak xzh = null;
    private C7306ak mcy = null;
    public HandlerThread oAl = null;
    private String threadName = null;

    /* renamed from: com.tencent.mm.sdk.platformtools.al$a */
    public interface C5002a {
        boolean acf();

        boolean acg();
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.al$b */
    public interface C5003b {
        /* renamed from: wM */
        void mo5264wM();
    }

    /* renamed from: a */
    static /* synthetic */ void m7438a(C5004al c5004al, String str) {
        AppMethodBeat.m2504i(52140);
        c5004al.m7435Az(str);
        AppMethodBeat.m2505o(52140);
    }

    /* renamed from: Az */
    private void m7435Az(String str) {
        AppMethodBeat.m2504i(52118);
        this.mcy = null;
        if (C5046bo.isNullOrNil(str)) {
            str = "MMHandlerThread";
        }
        this.threadName = str;
        this.oAl = C4960c.anN(this.threadName);
        this.oAl.start();
        AppMethodBeat.m2505o(52118);
    }

    /* renamed from: Ma */
    public static void m7436Ma(int i) {
        AppMethodBeat.m2504i(52119);
        try {
            Process.setThreadPriority(i);
            C4990ab.m7417i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", Integer.valueOf(i));
            AppMethodBeat.m2505o(52119);
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", Integer.valueOf(i), e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
            AppMethodBeat.m2505o(52119);
        }
    }

    public final void doK() {
        AppMethodBeat.m2504i(52120);
        if (this.oAl == null || !this.oAl.isAlive()) {
            C4990ab.m7412e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
            AppMethodBeat.m2505o(52120);
            return;
        }
        int threadId = this.oAl.getThreadId();
        try {
            if (19 == Process.getThreadPriority(threadId)) {
                C4990ab.m7420w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
                AppMethodBeat.m2505o(52120);
                return;
            }
            Process.setThreadPriority(threadId, 19);
            C4990ab.m7417i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.m2505o(52120);
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", Integer.valueOf(threadId));
            C4990ab.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
            AppMethodBeat.m2505o(52120);
        }
    }

    public final int doL() {
        AppMethodBeat.m2504i(52121);
        if (this.oAl == null) {
            AppMethodBeat.m2505o(52121);
            return -1;
        }
        int threadId = this.oAl.getThreadId();
        AppMethodBeat.m2505o(52121);
        return threadId;
    }

    /* renamed from: Bn */
    public final void mo10299Bn() {
        AppMethodBeat.m2504i(52122);
        if (this.oAl == null || !this.oAl.isAlive()) {
            C4990ab.m7412e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
            AppMethodBeat.m2505o(52122);
            return;
        }
        int threadId = this.oAl.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                C4990ab.m7420w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
                AppMethodBeat.m2505o(52122);
                return;
            }
            Process.setThreadPriority(threadId, -8);
            C4990ab.m7417i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.m2505o(52122);
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            C4990ab.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
            AppMethodBeat.m2505o(52122);
        }
    }

    public final void doM() {
        AppMethodBeat.m2504i(52123);
        if (this.oAl == null || !this.oAl.isAlive()) {
            C4990ab.m7412e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
            AppMethodBeat.m2505o(52123);
            return;
        }
        int threadId = this.oAl.getThreadId();
        try {
            if (Process.getThreadPriority(threadId) == 0) {
                C4990ab.m7420w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
                AppMethodBeat.m2505o(52123);
                return;
            }
            Process.setThreadPriority(threadId, 0);
            C4990ab.m7417i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.m2505o(52123);
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", Integer.valueOf(threadId));
            C4990ab.printErrStackTrace("MicroMsg.MMHandlerThread", e, "", new Object[0]);
            AppMethodBeat.m2505o(52123);
        }
    }

    public C5004al() {
        AppMethodBeat.m2504i(52124);
        C4990ab.m7417i("MicroMsg.MMHandlerThread", "init stack:%s", C5046bo.dpG());
        m7435Az(null);
        AppMethodBeat.m2505o(52124);
    }

    public C5004al(String str) {
        AppMethodBeat.m2504i(52125);
        m7435Az(str);
        AppMethodBeat.m2505o(52125);
    }

    public final Looper getLooper() {
        AppMethodBeat.m2504i(138961);
        Looper looper = this.oAl.getLooper();
        AppMethodBeat.m2505o(138961);
        return looper;
    }

    public final C7306ak doN() {
        AppMethodBeat.m2504i(52127);
        if (this.mcy == null) {
            this.mcy = new C7306ak(this.oAl.getLooper());
        }
        C7306ak c7306ak = this.mcy;
        AppMethodBeat.m2505o(52127);
        return c7306ak;
    }

    /* renamed from: a */
    public final int mo10301a(final C5003b c5003b) {
        int a;
        AppMethodBeat.m2504i(52128);
        C4990ab.m7417i("MicroMsg.MMHandlerThread", "syncReset tid[%d] stack:%s", Long.valueOf(Thread.currentThread().getId()), C5046bo.dpG());
        Assert.assertTrue("syncReset should in mainThread", C5004al.isMainThread());
        long id = this.oAl.getId();
        final byte[] bArr = new byte[0];
        final String str = this.threadName;
        C5002a c50051 = new C5002a() {
            public final boolean acg() {
                AppMethodBeat.m2504i(52113);
                C4990ab.m7416i("MicroMsg.MMHandlerThread", "syncReset onPostExecute");
                AppMethodBeat.m2505o(52113);
                return true;
            }

            public final boolean acf() {
                AppMethodBeat.m2504i(52114);
                C4990ab.m7417i("MicroMsg.MMHandlerThread", "syncReset doInBackground tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                if (c5003b != null) {
                    c5003b.mo5264wM();
                }
                C4990ab.m7417i("MicroMsg.MMHandlerThread", "syncReset doInBackground callback done tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                C5004al.this.oAl.quit();
                C4990ab.m7417i("MicroMsg.MMHandlerThread", "syncReset init start old tid[%d]", Long.valueOf(C5004al.this.oAl.getId()));
                C5004al.m7438a(C5004al.this, str);
                C4990ab.m7417i("MicroMsg.MMHandlerThread", "syncReset init done new tid[%d]", Long.valueOf(C5004al.this.oAl.getId()));
                synchronized (bArr) {
                    try {
                        C4990ab.m7417i("MicroMsg.MMHandlerThread", "syncReset notify tid[%d]", Long.valueOf(Thread.currentThread().getId()));
                        bArr.notify();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(52114);
                    }
                }
                return true;
            }
        };
        synchronized (bArr) {
            try {
                a = mo10300a(c50051);
                C4990ab.m7417i("MicroMsg.MMHandlerThread", "syncReset postAtFrontOfWorker ret[%d], oldTid[%d], curTid[%d]", Integer.valueOf(a), Long.valueOf(id), Long.valueOf(this.oAl.getId()));
                if (a == 0 && id == r4) {
                    bArr.wait();
                }
            } catch (Exception e) {
                C4990ab.m7411d("MicroMsg.MMHandlerThread", "syncReset lock wait end with exception[%s]", e.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.m2505o(52128);
            }
        }
        AppMethodBeat.m2505o(52128);
        return a;
    }

    public final boolean quit() {
        AppMethodBeat.m2504i(138962);
        boolean quit = this.oAl.quit();
        AppMethodBeat.m2505o(138962);
        return quit;
    }

    /* renamed from: aa */
    public int mo10302aa(Runnable runnable) {
        AppMethodBeat.m2504i(52130);
        if (runnable == null) {
            AppMethodBeat.m2505o(52130);
            return -1;
        }
        doN().post(runnable);
        AppMethodBeat.m2505o(52130);
        return 0;
    }

    /* renamed from: ae */
    public final int mo10303ae(Runnable runnable) {
        AppMethodBeat.m2504i(52131);
        doN().postAtFrontOfQueueV2(runnable);
        AppMethodBeat.m2505o(52131);
        return 0;
    }

    /* renamed from: m */
    public final int mo10310m(Runnable runnable, long j) {
        AppMethodBeat.m2504i(52132);
        if (runnable == null) {
            AppMethodBeat.m2505o(52132);
            return -1;
        }
        doN().postDelayed(runnable, j);
        AppMethodBeat.m2505o(52132);
        return 0;
    }

    /* renamed from: a */
    public final int mo10300a(final C5002a c5002a) {
        AppMethodBeat.m2504i(52133);
        if (new C7306ak(this.oAl.getLooper()).postAtFrontOfQueueV2(new Runnable() {

            /* renamed from: com.tencent.mm.sdk.platformtools.al$2$1 */
            class C50001 implements Runnable {
                C50001() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(52115);
                    c5002a.acg();
                    AppMethodBeat.m2505o(52115);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(52116);
                c5002a.acf();
                C5004al.m7440ag(new C50001());
                AppMethodBeat.m2505o(52116);
            }

            public final String toString() {
                AppMethodBeat.m2504i(52117);
                String str = super.toString() + "|" + c5002a.toString();
                AppMethodBeat.m2505o(52117);
                return str;
            }
        })) {
            AppMethodBeat.m2505o(52133);
            return 0;
        }
        AppMethodBeat.m2505o(52133);
        return -2;
    }

    public static boolean isMainThread() {
        AppMethodBeat.m2504i(52134);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            AppMethodBeat.m2505o(52134);
            return true;
        }
        AppMethodBeat.m2505o(52134);
        return false;
    }

    public final boolean doO() {
        AppMethodBeat.m2504i(52135);
        if (Thread.currentThread().getId() == this.oAl.getId()) {
            AppMethodBeat.m2505o(52135);
            return true;
        }
        AppMethodBeat.m2505o(52135);
        return false;
    }

    private static C7306ak doP() {
        AppMethodBeat.m2504i(52136);
        if (xzh == null) {
            xzh = new C7306ak(Looper.getMainLooper());
        }
        C7306ak c7306ak = xzh;
        AppMethodBeat.m2505o(52136);
        return c7306ak;
    }

    /* renamed from: d */
    public static void m7441d(Runnable runnable) {
        AppMethodBeat.m2504i(52137);
        if (runnable == null) {
            AppMethodBeat.m2505o(52137);
            return;
        }
        C5004al.doP().post(runnable);
        AppMethodBeat.m2505o(52137);
    }

    /* renamed from: n */
    public static void m7442n(Runnable runnable, long j) {
        AppMethodBeat.m2504i(52138);
        if (runnable == null) {
            AppMethodBeat.m2505o(52138);
            return;
        }
        C5004al.doP().postDelayed(runnable, j);
        AppMethodBeat.m2505o(52138);
    }

    /* renamed from: af */
    public static void m7439af(Runnable runnable) {
        AppMethodBeat.m2504i(52139);
        if (runnable == null) {
            AppMethodBeat.m2505o(52139);
            return;
        }
        C5004al.doP().removeCallbacks(runnable);
        AppMethodBeat.m2505o(52139);
    }

    /* renamed from: ag */
    static /* synthetic */ void m7440ag(Runnable runnable) {
        AppMethodBeat.m2504i(52141);
        C5004al.doP().postAtFrontOfQueueV2(runnable);
        AppMethodBeat.m2505o(52141);
    }
}
