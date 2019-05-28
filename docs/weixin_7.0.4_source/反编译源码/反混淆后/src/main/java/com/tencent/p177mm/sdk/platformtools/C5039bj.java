package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.bj */
public abstract class C5039bj<R> {
    long fmV;
    private final long ftP;
    private Object lock;
    private R result;
    long xBL;
    boolean xBM;
    private Runnable xzE;

    /* renamed from: com.tencent.mm.sdk.platformtools.bj$1 */
    class C50381 implements Runnable {
        C50381() {
        }

        public final void run() {
            AppMethodBeat.m2504i(52277);
            C4990ab.m7416i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + C5039bj.this.xBM);
            if (C5039bj.this.xBM) {
                C5039bj.this.run();
            } else {
                C5039bj.this.mo10373cC(C5039bj.this.run());
            }
            C5039bj.this.xBL = C5046bo.m7525az(C5039bj.this.fmV);
            AppMethodBeat.m2505o(52277);
        }
    }

    public abstract R run();

    public C5039bj() {
        this(0, null, (byte) 0);
    }

    public C5039bj(long j, R r) {
        this.lock = new Object();
        this.xBM = false;
        this.xzE = new C50381();
        this.ftP = j;
        this.result = r;
        this.xBM = true;
    }

    public C5039bj(long j, R r, byte b) {
        this.lock = new Object();
        this.xBM = false;
        this.xzE = new C50381();
        this.ftP = j;
        this.result = r;
    }

    /* renamed from: cC */
    public final void mo10373cC(R r) {
        C4990ab.m7416i("MicroMsg.SDK.SyncTask", "setResultFinish ");
        this.result = r;
        synchronized (this.lock) {
            C4990ab.m7416i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
            this.lock.notify();
        }
    }

    /* renamed from: b */
    public final R mo10372b(C7306ak c7306ak) {
        if (c7306ak == null) {
            C4990ab.m7410d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return run();
        }
        C4990ab.m7416i("MicroMsg.SDK.SyncTask", "sync task exec...");
        if (Thread.currentThread().getId() == c7306ak.getLooper().getThread().getId()) {
            C4990ab.m7416i("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        }
        this.fmV = C5046bo.m7588yz();
        try {
            synchronized (this.lock) {
                C4990ab.m7416i("MicroMsg.SDK.SyncTask", "sync task exec at synchronized");
                c7306ak.post(this.xzE);
                this.lock.wait(this.ftP);
            }
        } catch (InterruptedException e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.SyncTask", e, "", new Object[0]);
        }
        long az = C5046bo.m7525az(this.fmV);
        C4990ab.m7417i("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", this.result, Long.valueOf(az), Long.valueOf(this.xBL), Long.valueOf(az - this.xBL));
        return this.result;
    }
}
