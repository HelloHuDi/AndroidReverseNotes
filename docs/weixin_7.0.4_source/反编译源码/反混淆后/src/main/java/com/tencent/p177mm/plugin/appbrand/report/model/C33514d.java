package com.tencent.p177mm.plugin.appbrand.report.model;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.page.C2412aq;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.report.model.C2440i.C2441a;
import com.tencent.p177mm.plugin.appbrand.report.model.C2440i.C2442b;
import com.tencent.p177mm.plugin.appbrand.report.model.C2440i.C2444c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Deque;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.d */
public final class C33514d implements C27284h, C2440i {
    private final String iAY;
    private final SparseArray<C2441a> iAZ = new SparseArray();
    private final Deque<C2441a> iBa = new LinkedList();
    private boolean iBb = true;
    private String iBc;
    private C2441a iBd;

    public C33514d(String str) {
        AppMethodBeat.m2504i(132592);
        this.iAY = str;
        AppMethodBeat.m2505o(132592);
    }

    /* renamed from: b */
    private synchronized void m54733b(C27242w c27242w, C27242w c27242w2) {
        AppMethodBeat.m2504i(132593);
        boolean DC = mo6355DC(c27242w2.aBm());
        this.iBd = m54735j(c27242w2);
        this.iBd.iBl = new C2444c(1, c27242w.aBm());
        int hashCode = c27242w.hashCode();
        while (!isEmpty() && aLo().iBk != hashCode) {
            aLn();
        }
        if (DC) {
            m54732a(new C2441a(c27242w));
        }
        m54735j(c27242w).iBm = new C2442b(c27242w2.aBm());
        m54735j(c27242w).iBl = null;
        AppMethodBeat.m2505o(132593);
    }

    /* renamed from: i */
    private synchronized void m54734i(C27242w c27242w) {
        C2442b c2442b;
        AppMethodBeat.m2504i(132594);
        this.iBc = c27242w.aBm();
        this.iBb = false;
        m54732a(new C2441a(c27242w));
        C2441a aLo = aLo();
        if (C5046bo.isNullOrNil(this.iAY)) {
            c2442b = null;
        } else {
            c2442b = new C2442b(this.iAY);
        }
        aLo.iBm = c2442b;
        AppMethodBeat.m2505o(132594);
    }

    private synchronized void aLm() {
        this.iBd = null;
        this.iBc = null;
        this.iBb = false;
    }

    /* renamed from: a */
    public final void mo6358a(C27242w c27242w, C27242w c27242w2, C2412aq c2412aq) {
        AppMethodBeat.m2504i(132595);
        synchronized (this) {
            try {
                if (this.iBb) {
                    m54734i(c27242w);
                } else if (c2412aq == C2412aq.NAVIGATE_BACK) {
                    m54733b(c27242w, c27242w2);
                    AppMethodBeat.m2505o(132595);
                } else {
                    if (this.iBd != null) {
                        aLm();
                    }
                    if (c27242w2 != null) {
                        C2441a j = m54735j(c27242w2);
                        if (j != null) {
                            j.iBl = new C2444c(2, c27242w.aBm());
                        }
                    }
                    C2441a c2441a = new C2441a(c27242w);
                    c2441a.iBm = c27242w2 == null ? null : new C2442b(c27242w2.aBm());
                    m54732a(c2441a);
                    AppMethodBeat.m2505o(132595);
                }
            } finally {
                AppMethodBeat.m2505o(132595);
            }
        }
    }

    /* renamed from: b */
    public final void mo6359b(C27242w c27242w) {
        AppMethodBeat.m2504i(132596);
        synchronized (this) {
            try {
                C2441a j = m54735j(c27242w);
                if (j == null) {
                } else {
                    Pair l = C33516e.m54743l(c27242w);
                    j.iBl = new C2444c(((Integer) l.first).intValue(), (String) l.second);
                    AppMethodBeat.m2505o(132596);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(132596);
            }
        }
    }

    /* renamed from: j */
    private C2441a m54735j(C27242w c27242w) {
        AppMethodBeat.m2504i(132597);
        C2441a aLo = aLo();
        if (aLo == null) {
            aLo = new C2441a(c27242w);
            AppMethodBeat.m2505o(132597);
            return aLo;
        } else if (aLo.iBk == c27242w.hashCode()) {
            AppMethodBeat.m2505o(132597);
            return aLo;
        } else {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
            AppMethodBeat.m2505o(132597);
            return aLo;
        }
    }

    /* renamed from: c */
    public final synchronized void mo6360c(C27242w c27242w) {
        AppMethodBeat.m2504i(132598);
        if (this.iBb) {
            m54734i(c27242w);
            AppMethodBeat.m2505o(132598);
        } else {
            aLm();
            AppMethodBeat.m2505o(132598);
        }
    }

    /* renamed from: a */
    private synchronized void m54732a(C2441a c2441a) {
        AppMethodBeat.m2504i(132599);
        this.iBa.offerFirst(c2441a);
        this.iAZ.put(c2441a.iBk, c2441a);
        AppMethodBeat.m2505o(132599);
    }

    private synchronized C2441a aLn() {
        C2441a c2441a;
        AppMethodBeat.m2504i(132600);
        c2441a = (C2441a) this.iBa.pollFirst();
        if (c2441a != null) {
            this.iAZ.remove(c2441a.iBk);
        }
        AppMethodBeat.m2505o(132600);
        return c2441a;
    }

    public final synchronized C2441a aLo() {
        C2441a c2441a;
        AppMethodBeat.m2504i(132601);
        c2441a = (C2441a) this.iBa.peekFirst();
        AppMethodBeat.m2505o(132601);
        return c2441a;
    }

    private synchronized boolean isEmpty() {
        boolean isEmpty;
        AppMethodBeat.m2504i(132602);
        isEmpty = this.iBa.isEmpty();
        AppMethodBeat.m2505o(132602);
        return isEmpty;
    }

    /* renamed from: DC */
    public final synchronized boolean mo6355DC(String str) {
        boolean z;
        AppMethodBeat.m2504i(132603);
        if (C5046bo.isNullOrNil(this.iBc) || !this.iBc.equals(str)) {
            z = false;
            AppMethodBeat.m2505o(132603);
        } else {
            z = true;
            AppMethodBeat.m2505o(132603);
        }
        return z;
    }

    /* renamed from: k */
    public final synchronized C2441a mo6357k(C27242w c27242w) {
        C2441a c2441a;
        AppMethodBeat.m2504i(132604);
        c2441a = (C2441a) this.iAZ.get(c27242w.hashCode());
        if (c2441a == null && this.iBd != null && this.iBd.iBk == c27242w.hashCode()) {
            c2441a = this.iBd;
            AppMethodBeat.m2505o(132604);
        } else {
            AppMethodBeat.m2505o(132604);
        }
        return c2441a;
    }
}
