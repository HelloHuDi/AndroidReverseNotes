package com.tencent.p177mm.sdk.p604g.p608d;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C4969e;
import com.tencent.p177mm.sdk.p604g.C4969e.C4968a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p605a.C4942d;
import com.tencent.p177mm.sdk.p604g.p605a.C4944f;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.sdk.g.d.a */
public final class C7304a extends FutureTask<Runnable> implements C4967b, Comparable<C7304a> {
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
    private final C4942d xDT;
    public String xDU;
    final AtomicBoolean xEN = new AtomicBoolean(false);
    C4944f xEO;
    public Throwable xEP;
    private Handler xEQ;
    public Runnable xzE;

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.m2504i(52710);
        int compare = Long.compare(this.cmn, ((C7304a) obj).cmn);
        AppMethodBeat.m2505o(52710);
        return compare;
    }

    public C7304a(Runnable runnable, String str, String str2, long j, C4942d c4942d, C4944f c4944f, Handler handler) {
        super(runnable, null);
        AppMethodBeat.m2504i(52702);
        Assert.assertNotNull("FutureRunnable arg name is null!", str);
        this.xzE = runnable;
        this.eOn = str;
        this.cvc = j;
        this.priority = 5;
        this.cmn = SystemClock.uptimeMillis();
        this.xDT = c4942d;
        this.xEO = c4944f;
        this.token = hashCode();
        this.xDU = str2;
        this.xEQ = handler;
        AppMethodBeat.m2505o(52702);
    }

    public final void run() {
        AppMethodBeat.m2504i(52703);
        if (this.xEN.compareAndSet(false, true)) {
            this.startTime = SystemClock.uptimeMillis();
            this.waitTime = (this.startTime - this.cmn) - this.cvc;
            if (this.xDT != null) {
                this.xDT.mo10145a(this.xzE, this.token);
            }
            C4969e dqt = dqt();
            if (!(this.xEQ == null || this.xEO == null)) {
                Message message = new Message();
                message.what = C7305d.xDN;
                message.obj = dqt;
                this.xEQ.sendMessageDelayed(message, 1800000);
            }
            try {
                super.run();
                this.bYT = false;
                this.fpi = SystemClock.uptimeMillis() - this.startTime;
                m12283f(dqt);
                if (this.xEO != null) {
                    this.xEO.mo10171x(this.eOn, this.fpi, this.waitTime);
                }
                if (this.xDT != null) {
                    this.xDT.mo10146b(this.xzE, this.token);
                    AppMethodBeat.m2505o(52703);
                    return;
                }
                AppMethodBeat.m2505o(52703);
            } catch (Throwable th) {
                this.bYT = false;
                this.fpi = SystemClock.uptimeMillis() - this.startTime;
                m12283f(dqt);
                if (this.xEO != null) {
                    this.xEO.mo10171x(this.eOn, this.fpi, this.waitTime);
                }
                if (this.xDT != null) {
                    this.xDT.mo10146b(this.xzE, this.token);
                }
                AppMethodBeat.m2505o(52703);
            }
        } else {
            this.bYT = false;
            AppMethodBeat.m2505o(52703);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void done() {
        AppMethodBeat.m2504i(52704);
        super.done();
        try {
            if (!isCancelled()) {
                get();
            }
            AppMethodBeat.m2505o(52704);
        } catch (Throwable th) {
            this.xEP = th;
            Error error;
            if (this.xEP instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) this.xEP;
                AppMethodBeat.m2505o(52704);
            } else if (this.xEP instanceof Error) {
                error = (Error) this.xEP;
                AppMethodBeat.m2505o(52704);
            } else {
                error = new Error(this.xEP);
                AppMethodBeat.m2505o(52704);
            }
        }
    }

    /* renamed from: f */
    private void m12283f(C4969e c4969e) {
        AppMethodBeat.m2504i(52705);
        if (this.xEQ != null) {
            this.xEQ.removeMessages(C7305d.xDN, c4969e);
        }
        AppMethodBeat.m2505o(52705);
    }

    public final boolean isRunning() {
        AppMethodBeat.m2504i(52706);
        if (this.bYT && this.xEN.get()) {
            AppMethodBeat.m2505o(52706);
            return true;
        }
        AppMethodBeat.m2505o(52706);
        return false;
    }

    public final boolean dqs() {
        AppMethodBeat.m2504i(52707);
        if (this.xEN.compareAndSet(false, true)) {
            this.bYT = false;
            AppMethodBeat.m2505o(52707);
            return true;
        }
        AppMethodBeat.m2505o(52707);
        return false;
    }

    static {
        AppMethodBeat.m2504i(52711);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName=%s");
        stringBuilder.append("|addTime=%d");
        stringBuilder.append("|usedTime=%dms");
        stringBuilder.append("|waitTime=%dms");
        stringBuilder.append("|started=%b");
        stringBuilder.append("|isAlive=%b");
        stringBuilder.append("|loopTag=%s");
        FORMAT = stringBuilder.toString();
        AppMethodBeat.m2505o(52711);
    }

    public final String toString() {
        AppMethodBeat.m2504i(52708);
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
        AppMethodBeat.m2505o(52708);
        return format;
    }

    public final String getKey() {
        return this.eOn;
    }

    public final C4969e dqt() {
        AppMethodBeat.m2504i(52709);
        C4969e c4969e = new C4969e(this.eOn);
        if (!this.bYT) {
            c4969e.xDX = C4968a.FINISH;
        } else if (this.xEN.get()) {
            c4969e.xDX = C4968a.RUNNING;
        } else {
            c4969e.xDX = C4968a.WAITING;
        }
        c4969e.xDY = this.cmn;
        c4969e.startTime = this.startTime;
        c4969e.iBv = this.fpi;
        AppMethodBeat.m2505o(52709);
        return c4969e;
    }
}
