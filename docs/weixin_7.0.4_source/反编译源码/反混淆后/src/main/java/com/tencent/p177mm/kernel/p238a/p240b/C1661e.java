package com.tencent.p177mm.kernel.p238a.p240b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1736j;
import com.tencent.p177mm.kernel.p238a.p240b.C6597f.C6596a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p642h.C7369h;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.a.b.e */
public final class C1661e<T> {
    private static C1661e eLN = null;
    private Queue<C1660c> eLG = new LinkedList();
    private int eLH;
    private volatile C1659a eLI;
    private volatile boolean eLJ = false;
    private final byte[] eLK = new byte[0];
    private volatile C5681a<Void, C6596a> eLL;
    private volatile C1656c<T> eLM;

    /* renamed from: com.tencent.mm.kernel.a.b.e$a */
    public interface C1659a {
        /* renamed from: Ss */
        void mo5137Ss();

        /* renamed from: Sv */
        void mo5138Sv();
    }

    /* renamed from: com.tencent.mm.kernel.a.b.e$c */
    public static class C1660c {
        public HandlerThread cet;
        C7369h eLR;
        Handler handler;
    }

    /* renamed from: com.tencent.mm.kernel.a.b.e$b */
    public static class C1662b implements C1659a {
        private final byte[] eHH = new byte[]{(byte) 0};

        public C1662b() {
            AppMethodBeat.m2504i(123307);
            AppMethodBeat.m2505o(123307);
        }

        /* renamed from: Ss */
        public final void mo5137Ss() {
            AppMethodBeat.m2504i(123308);
            try {
                synchronized (this.eHH) {
                    if (this.eHH[0] == (byte) 0) {
                        C1736j.m3587i("MMSkeleton.Parallels", "Waiting for lock(%s)", this.eHH);
                        this.eHH.wait();
                    } else {
                        C1736j.m3587i("MMSkeleton.Parallels", "Not need wait for lock(%s)", this.eHH);
                    }
                }
                AppMethodBeat.m2505o(123308);
            } catch (InterruptedException e) {
                C4990ab.printErrStackTrace("MMSkeleton.Parallels", e, "", new Object[0]);
                AppMethodBeat.m2505o(123308);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(123308);
            }
        }

        /* renamed from: Sv */
        public final void mo5138Sv() {
            AppMethodBeat.m2504i(123309);
            synchronized (this.eHH) {
                try {
                    this.eHH[0] = (byte) 1;
                    this.eHH.notify();
                    C1736j.m3587i("MMSkeleton.Parallels", "Lock(%s) notified", this.eHH);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(123309);
                }
            }
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m3366c(C1661e c1661e) {
        AppMethodBeat.m2504i(123326);
        c1661e.active();
        AppMethodBeat.m2505o(123326);
    }

    /* renamed from: Sq */
    public static C1661e m3356Sq() {
        return eLN;
    }

    /* renamed from: Sr */
    public static C1661e m3357Sr() {
        AppMethodBeat.m2504i(123310);
        if (eLN == null) {
            eLN = new C1661e();
        }
        C1661e c1661e = eLN;
        AppMethodBeat.m2505o(123310);
        return c1661e;
    }

    private C1661e() {
        AppMethodBeat.m2504i(123311);
        AppMethodBeat.m2505o(123311);
    }

    public final synchronized void init(int i) {
        AppMethodBeat.m2504i(123312);
        for (int i2 = 0; i2 < i; i2++) {
            Queue queue = this.eLG;
            HandlerThread handlerThread = new HandlerThread("parallels-".concat(String.valueOf(i2)), -8);
            handlerThread.start();
            C1660c c1660c = new C1660c();
            c1660c.cet = handlerThread;
            queue.add(c1660c);
        }
        this.eLH = i;
        AppMethodBeat.m2505o(123312);
    }

    public final synchronized void prepare() {
        AppMethodBeat.m2504i(123313);
        for (int i = 0; i < this.eLH; i++) {
            C1660c c1660c = (C1660c) ((LinkedList) this.eLG).get(i);
            Handler handler = new Handler(c1660c.cet.getLooper());
            C7369h c7369h = new C7369h(handler, c1660c.cet.getName());
            c1660c.handler = handler;
            c1660c.eLR = c7369h;
        }
        AppMethodBeat.m2505o(123313);
    }

    /* renamed from: a */
    public final boolean mo5142a(C1659a c1659a, C5681a<Void, C6596a> c5681a, C1656c<T> c1656c) {
        AppMethodBeat.m2504i(123314);
        synchronized (this.eLK) {
            try {
                if (this.eLJ) {
                    C4990ab.m7420w("MMSkeleton.Parallels", "Arrange parallels task failed. It's busy on working.");
                    Assert.assertTrue(false);
                } else {
                    this.eLI = c1659a;
                    this.eLL = c5681a;
                    this.eLM = c1656c;
                    AppMethodBeat.m2505o(123314);
                    return true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(123314);
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void mo5141a(C1659a c1659a, C5681a<Void, C6596a> c5681a, C1656c<T> c1656c, String str) {
        AppMethodBeat.m2504i(123315);
        if (mo5142a(c1659a, (C5681a) c5681a, (C1656c) c1656c)) {
            c1656c.prepare();
            start(str);
            mo5139Ss();
        }
        AppMethodBeat.m2505o(123315);
    }

    /* renamed from: Ss */
    public final void mo5139Ss() {
        AppMethodBeat.m2504i(123316);
        this.eLI.mo5137Ss();
        AppMethodBeat.m2505o(123316);
    }

    public final void start(String str) {
        AppMethodBeat.m2504i(123317);
        C1736j.m3587i("MMSkeleton.Parallels", "Start working. For %s", str);
        synchronized (this.eLK) {
            try {
                this.eLJ = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(123317);
            }
        }
        active();
    }

    /* renamed from: St */
    public final synchronized List<C1660c> mo5140St() {
        LinkedList linkedList;
        AppMethodBeat.m2504i(123318);
        linkedList = new LinkedList(this.eLG);
        AppMethodBeat.m2505o(123318);
        return linkedList;
    }

    /* renamed from: Su */
    private synchronized C1660c m3358Su() {
        C1660c c1660c;
        AppMethodBeat.m2504i(123319);
        c1660c = (C1660c) this.eLG.poll();
        AppMethodBeat.m2505o(123319);
        return c1660c;
    }

    /* renamed from: a */
    private synchronized boolean m3363a(C1660c c1660c) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(123320);
            this.eLG.add(c1660c);
            C1736j.m3584d("MMSkeleton.Parallels", "Parallels check threads idle. %s of %s", Integer.valueOf(this.eLG.size()), Integer.valueOf(this.eLH));
            if (this.eLG.size() == this.eLH) {
                AppMethodBeat.m2505o(123320);
            } else {
                AppMethodBeat.m2505o(123320);
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    private void m3365b(C1660c c1660c) {
        AppMethodBeat.m2504i(123321);
        if (m3363a(c1660c)) {
            synchronized (this.eLK) {
                try {
                    if (this.eLJ) {
                        C1736j.m3587i("MMSkeleton.Parallels", "Parallels notify done", new Object[0]);
                    }
                    this.eLJ = false;
                    this.eLI.mo5138Sv();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(123321);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(123321);
    }

    private void active() {
        AppMethodBeat.m2504i(123322);
        while (true) {
            C1660c Su = m3358Su();
            if (Su != null) {
                C6596a Sp = this.eLM.mo5131Sp();
                if (Sp != null) {
                    m3360a(Su, Sp);
                } else {
                    m3365b(Su);
                    AppMethodBeat.m2505o(123322);
                    return;
                }
            }
            AppMethodBeat.m2505o(123322);
            return;
        }
    }

    /* renamed from: a */
    private void m3360a(final C1660c c1660c, final C6596a<T> c6596a) {
        AppMethodBeat.m2504i(123323);
        c1660c.eLR.mo10061o(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(123306);
                C6596a c6596a = c6596a;
                C5681a a = C1661e.this.eLL;
                if (!c6596a.eLB) {
                    c6596a.eMc.eMd.dOV();
                    if (!c6596a.eLB) {
                        a.call(c6596a);
                        C4990ab.m7411d("MMSkeleton.ParallelsDependencies", "consume call functional %s, node %s", a, c6596a);
                        c6596a.eLB = true;
                    }
                    c6596a.eMc.eMd.done();
                }
                C1661e.this.eLM.mo5132a(c6596a);
                c6596a = C1661e.this.eLM.mo5131Sp();
                if (c6596a == null) {
                    C1661e.m3361a(C1661e.this, c1660c);
                    AppMethodBeat.m2505o(123306);
                    return;
                }
                C1661e.m3362a(C1661e.this, c1660c, c6596a);
                C1661e.m3366c(C1661e.this);
                AppMethodBeat.m2505o(123306);
            }
        });
        AppMethodBeat.m2505o(123323);
    }
}
