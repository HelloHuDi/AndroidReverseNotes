package com.tencent.mm.sdk.g.d;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.d;
import com.tencent.mm.sdk.g.a.f;
import com.tencent.mm.sdk.g.e;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public final class a extends FutureTask<Runnable> implements b, Comparable<a> {
    private static final String FORMAT;
    public volatile boolean bYT = true;
    public long cmn;
    private long cvc;
    public final String eOn;
    public long fpi;
    final int priority;
    public long startTime;
    public int token;
    private long waitTime;
    private final d xDT;
    public String xDU;
    final AtomicBoolean xEN = new AtomicBoolean(false);
    f xEO;
    public Throwable xEP;
    private Handler xEQ;
    public Runnable xzE;

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.i(52710);
        int compare = Long.compare(this.cmn, ((a) obj).cmn);
        AppMethodBeat.o(52710);
        return compare;
    }

    public a(Runnable runnable, String str, String str2, long j, d dVar, f fVar, Handler handler) {
        super(runnable, null);
        AppMethodBeat.i(52702);
        Assert.assertNotNull("FutureRunnable arg name is null!", str);
        this.xzE = runnable;
        this.eOn = str;
        this.cvc = j;
        this.priority = 5;
        this.cmn = SystemClock.uptimeMillis();
        this.xDT = dVar;
        this.xEO = fVar;
        this.token = hashCode();
        this.xDU = str2;
        this.xEQ = handler;
        AppMethodBeat.o(52702);
    }

    public final void run() {
        AppMethodBeat.i(52703);
        if (this.xEN.compareAndSet(false, true)) {
            this.startTime = SystemClock.uptimeMillis();
            this.waitTime = (this.startTime - this.cmn) - this.cvc;
            if (this.xDT != null) {
                this.xDT.a(this.xzE, this.token);
            }
            e dqt = dqt();
            if (!(this.xEQ == null || this.xEO == null)) {
                Message message = new Message();
                message.what = com.tencent.mm.sdk.g.d.xDN;
                message.obj = dqt;
                this.xEQ.sendMessageDelayed(message, 1800000);
            }
            try {
                super.run();
                this.bYT = false;
                this.fpi = SystemClock.uptimeMillis() - this.startTime;
                f(dqt);
                if (this.xEO != null) {
                    this.xEO.x(this.eOn, this.fpi, this.waitTime);
                }
                if (this.xDT != null) {
                    this.xDT.b(this.xzE, this.token);
                    AppMethodBeat.o(52703);
                    return;
                }
                AppMethodBeat.o(52703);
            } catch (Throwable th) {
                this.bYT = false;
                this.fpi = SystemClock.uptimeMillis() - this.startTime;
                f(dqt);
                if (this.xEO != null) {
                    this.xEO.x(this.eOn, this.fpi, this.waitTime);
                }
                if (this.xDT != null) {
                    this.xDT.b(this.xzE, this.token);
                }
                AppMethodBeat.o(52703);
            }
        } else {
            this.bYT = false;
            AppMethodBeat.o(52703);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void done() {
        AppMethodBeat.i(52704);
        super.done();
        try {
            if (!isCancelled()) {
                get();
            }
            AppMethodBeat.o(52704);
        } catch (Throwable th) {
            this.xEP = th;
            Error error;
            if (this.xEP instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) this.xEP;
                AppMethodBeat.o(52704);
            } else if (this.xEP instanceof Error) {
                error = (Error) this.xEP;
                AppMethodBeat.o(52704);
            } else {
                error = new Error(this.xEP);
                AppMethodBeat.o(52704);
            }
        }
    }

    private void f(e eVar) {
        AppMethodBeat.i(52705);
        if (this.xEQ != null) {
            this.xEQ.removeMessages(com.tencent.mm.sdk.g.d.xDN, eVar);
        }
        AppMethodBeat.o(52705);
    }

    public final boolean isRunning() {
        AppMethodBeat.i(52706);
        if (this.bYT && this.xEN.get()) {
            AppMethodBeat.o(52706);
            return true;
        }
        AppMethodBeat.o(52706);
        return false;
    }

    public final boolean dqs() {
        AppMethodBeat.i(52707);
        if (this.xEN.compareAndSet(false, true)) {
            this.bYT = false;
            AppMethodBeat.o(52707);
            return true;
        }
        AppMethodBeat.o(52707);
        return false;
    }

    static {
        AppMethodBeat.i(52711);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName=%s");
        stringBuilder.append("|addTime=%d");
        stringBuilder.append("|usedTime=%dms");
        stringBuilder.append("|waitTime=%dms");
        stringBuilder.append("|started=%b");
        stringBuilder.append("|isAlive=%b");
        stringBuilder.append("|loopTag=%s");
        FORMAT = stringBuilder.toString();
        AppMethodBeat.o(52711);
    }

    public final String toString() {
        AppMethodBeat.i(52708);
        String str = FORMAT;
        Object[] objArr = new Object[8];
        objArr[0] = this.eOn;
        objArr[1] = Long.valueOf(this.cmn);
        objArr[2] = Long.valueOf(this.fpi);
        objArr[3] = Long.valueOf(this.waitTime);
        objArr[4] = Boolean.valueOf(this.xEN.get());
        objArr[5] = Boolean.valueOf(this.bYT);
        objArr[6] = this.xDU;
        objArr[7] = this.xEP == null ? "" : "|throwable=" + this.xEP;
        String format = String.format(str, objArr);
        AppMethodBeat.o(52708);
        return format;
    }

    public final String getKey() {
        return this.eOn;
    }

    public final e dqt() {
        AppMethodBeat.i(52709);
        e eVar = new e(this.eOn);
        if (!this.bYT) {
            eVar.xDX = com.tencent.mm.sdk.g.e.a.FINISH;
        } else if (this.xEN.get()) {
            eVar.xDX = com.tencent.mm.sdk.g.e.a.RUNNING;
        } else {
            eVar.xDX = com.tencent.mm.sdk.g.e.a.WAITING;
        }
        eVar.xDY = this.cmn;
        eVar.startTime = this.startTime;
        eVar.iBv = this.fpi;
        AppMethodBeat.o(52709);
        return eVar;
    }
}
