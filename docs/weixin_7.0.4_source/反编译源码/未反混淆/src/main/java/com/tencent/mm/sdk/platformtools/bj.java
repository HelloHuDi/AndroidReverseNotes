package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class bj<R> {
    long fmV;
    private final long ftP;
    private Object lock;
    private R result;
    long xBL;
    boolean xBM;
    private Runnable xzE;

    public abstract R run();

    public bj() {
        this(0, null, (byte) 0);
    }

    public bj(long j, R r) {
        this.lock = new Object();
        this.xBM = false;
        this.xzE = new Runnable() {
            public final void run() {
                AppMethodBeat.i(52277);
                ab.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + bj.this.xBM);
                if (bj.this.xBM) {
                    bj.this.run();
                } else {
                    bj.this.cC(bj.this.run());
                }
                bj.this.xBL = bo.az(bj.this.fmV);
                AppMethodBeat.o(52277);
            }
        };
        this.ftP = j;
        this.result = r;
        this.xBM = true;
    }

    public bj(long j, R r, byte b) {
        this.lock = new Object();
        this.xBM = false;
        this.xzE = /* anonymous class already generated */;
        this.ftP = j;
        this.result = r;
    }

    public final void cC(R r) {
        ab.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
        this.result = r;
        synchronized (this.lock) {
            ab.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
            this.lock.notify();
        }
    }

    public final R b(ak akVar) {
        if (akVar == null) {
            ab.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return run();
        }
        ab.i("MicroMsg.SDK.SyncTask", "sync task exec...");
        if (Thread.currentThread().getId() == akVar.getLooper().getThread().getId()) {
            ab.i("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        }
        this.fmV = bo.yz();
        try {
            synchronized (this.lock) {
                ab.i("MicroMsg.SDK.SyncTask", "sync task exec at synchronized");
                akVar.post(this.xzE);
                this.lock.wait(this.ftP);
            }
        } catch (InterruptedException e) {
            ab.printErrStackTrace("MicroMsg.SDK.SyncTask", e, "", new Object[0]);
        }
        long az = bo.az(this.fmV);
        ab.i("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", this.result, Long.valueOf(az), Long.valueOf(this.xBL), Long.valueOf(az - this.xBL));
        return this.result;
    }
}
