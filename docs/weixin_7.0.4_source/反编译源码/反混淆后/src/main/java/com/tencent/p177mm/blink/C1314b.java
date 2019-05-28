package com.tencent.p177mm.blink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p238a.C6610c;
import com.tencent.p177mm.p217ci.C6455d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7361c;
import com.tencent.p177mm.vending.p642h.C5703d;
import com.tencent.p177mm.vending.p642h.C5707g;
import com.tencent.p177mm.vending.p642h.C7367c;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p642h.C7369h;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mm.blink.b */
public final class C1314b {
    private static C1314b ebe = new C1314b();
    private final Queue<C1316a> ebf = new LinkedList();
    private boolean ebg = false;
    private volatile boolean ebh = false;
    private boolean ebi = true;
    private volatile C7361c ebj = C5698f.dMn();
    private AtomicBoolean ebk = new AtomicBoolean(false);
    private C5004al ebl = new C5004al("pending-stage");

    /* renamed from: com.tencent.mm.blink.b$2 */
    public class C13122 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(57704);
            C1314b.m2816a(C1314b.this, C1313b.Timeout);
            AppMethodBeat.m2505o(57704);
        }
    }

    /* renamed from: com.tencent.mm.blink.b$b */
    public enum C1313b {
        Now,
        Timeout,
        FirstScreen;

        static {
            AppMethodBeat.m2505o(57709);
        }
    }

    /* renamed from: com.tencent.mm.blink.b$a */
    static class C1316a implements C7368e {
        private C5703d ceu;
        private Runnable mRunnable;

        public C1316a(Runnable runnable, C5703d c5703d) {
            this.mRunnable = runnable;
            this.ceu = c5703d;
        }

        public final Object call(Object obj) {
            AppMethodBeat.m2504i(57705);
            C4990ab.m7417i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", this.mRunnable, this.ceu.getType());
            this.mRunnable.run();
            AppMethodBeat.m2505o(57705);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            AppMethodBeat.m2504i(57706);
            String type;
            if (!(this.ceu instanceof C7367c)) {
                type = this.ceu.getType();
                AppMethodBeat.m2505o(57706);
                return type;
            } else if (C5703d.dMq() instanceof C7367c) {
                type = C5703d.zYp.f2009c;
                AppMethodBeat.m2505o(57706);
                return type;
            } else {
                type = C5703d.dMq().getType();
                AppMethodBeat.m2505o(57706);
                return type;
            }
        }
    }

    public C1314b() {
        AppMethodBeat.m2504i(57710);
        AppMethodBeat.m2505o(57710);
    }

    /* renamed from: a */
    static /* synthetic */ void m2816a(C1314b c1314b, C1313b c1313b) {
        AppMethodBeat.m2504i(57718);
        c1314b.mo4641a(c1313b);
        AppMethodBeat.m2505o(57718);
    }

    /* renamed from: b */
    static /* synthetic */ void m2818b(C1314b c1314b) {
        AppMethodBeat.m2504i(57717);
        c1314b.m2815HX();
        AppMethodBeat.m2505o(57717);
    }

    static {
        AppMethodBeat.m2504i(57719);
        AppMethodBeat.m2505o(57719);
    }

    /* renamed from: HQ */
    public static C1314b m2812HQ() {
        return ebe;
    }

    /* renamed from: HR */
    public final synchronized void mo4637HR() {
        this.ebg = true;
    }

    /* renamed from: HS */
    public final synchronized void mo4638HS() {
        AppMethodBeat.m2504i(57711);
        this.ebi = true;
        if (this.ebg) {
            m2814HW();
        }
        AppMethodBeat.m2505o(57711);
    }

    /* renamed from: HT */
    public final synchronized void mo4639HT() {
        this.ebi = false;
    }

    /* renamed from: HU */
    public final synchronized void mo4640HU() {
        AppMethodBeat.m2504i(57712);
        if (this.ebg) {
            this.ebg = false;
            m2814HW();
        }
        AppMethodBeat.m2505o(57712);
    }

    /* renamed from: o */
    public final synchronized void mo4642o(Runnable runnable) {
        AppMethodBeat.m2504i(57713);
        C5703d dMq = C5703d.dMq();
        if (!(dMq instanceof C7367c)) {
            C5707g.m8573a(dMq.getType(), dMq);
        }
        if (m2813HV()) {
            C4990ab.m7417i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement arrange runnable postToMainThread %s", runnable);
            this.ebj.mo15892c(new C1316a(runnable, dMq));
            AppMethodBeat.m2505o(57713);
        } else {
            C4990ab.m7417i("MicroMsg.FirstScreenArrangement", "arrange first screen runnable: %s, %s, %s, %s", Boolean.valueOf(this.ebg), Boolean.valueOf(this.ebi), Boolean.valueOf(this.ebh), this.ebf);
            this.ebf.add(new C1316a(runnable, dMq));
            AppMethodBeat.m2505o(57713);
        }
    }

    /* renamed from: HV */
    private synchronized boolean m2813HV() {
        boolean z;
        z = (!this.ebg || this.ebi) && this.ebh;
        return z;
    }

    /* renamed from: HW */
    private void m2814HW() {
        AppMethodBeat.m2504i(57714);
        mo4641a(C1313b.FirstScreen);
        m2815HX();
        AppMethodBeat.m2505o(57714);
    }

    /* JADX WARNING: Missing block: B:18:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(57715);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: HX */
    private synchronized void m2815HX() {
        AppMethodBeat.m2504i(57715);
        if (m2813HV()) {
            while (true) {
                C1316a c1316a = (C1316a) this.ebf.poll();
                if (c1316a == null) {
                    break;
                }
                C4990ab.m7417i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", c1316a.mRunnable, c1316a.ceu.getType());
                this.ebj.mo15892c(c1316a);
            }
        } else {
            AppMethodBeat.m2505o(57715);
        }
    }

    /* renamed from: a */
    public final void mo4641a(final C1313b c1313b) {
        AppMethodBeat.m2504i(57716);
        if (!this.ebk.compareAndSet(false, true)) {
            AppMethodBeat.m2505o(57716);
        } else if (c1313b == C1313b.Now) {
            C4990ab.m7417i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", c1313b);
            C6610c.m10890Sa().mo14821Sd();
            synchronized (this) {
                try {
                    this.ebh = true;
                    m2815HX();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57716);
                }
            }
        } else {
            C7369h c7369h = new C7369h(new C6455d(this.ebl.doN()), "pending-stage");
            synchronized (this) {
                try {
                    this.ebj.mo15891b(c7369h).mo15892c(new C5681a<Object, Void>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.m2504i(57703);
                            Object HY = m2825HY();
                            AppMethodBeat.m2505o(57703);
                            return HY;
                        }

                        /* renamed from: HY */
                        private Object m2825HY() {
                            AppMethodBeat.m2504i(57702);
                            C4990ab.m7417i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", c1313b);
                            C6610c.m10890Sa().mo14821Sd();
                            synchronized (this) {
                                try {
                                    C1314b.this.ebh = true;
                                    C1314b.m2818b(C1314b.this);
                                } finally {
                                    while (true) {
                                    }
                                    AppMethodBeat.m2505o(57702);
                                }
                            }
                            return null;
                        }
                    });
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57716);
                }
            }
        }
    }
}
