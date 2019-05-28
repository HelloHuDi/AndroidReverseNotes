package com.tencent.mm.plugin.appbrand.report.model;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.report.model.i.a;
import com.tencent.mm.plugin.appbrand.report.model.i.b;
import com.tencent.mm.plugin.appbrand.report.model.i.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Deque;
import java.util.LinkedList;

public final class d implements h, i {
    private final String iAY;
    private final SparseArray<a> iAZ = new SparseArray();
    private final Deque<a> iBa = new LinkedList();
    private boolean iBb = true;
    private String iBc;
    private a iBd;

    public d(String str) {
        AppMethodBeat.i(132592);
        this.iAY = str;
        AppMethodBeat.o(132592);
    }

    private synchronized void b(w wVar, w wVar2) {
        AppMethodBeat.i(132593);
        boolean DC = DC(wVar2.aBm());
        this.iBd = j(wVar2);
        this.iBd.iBl = new c(1, wVar.aBm());
        int hashCode = wVar.hashCode();
        while (!isEmpty() && aLo().iBk != hashCode) {
            aLn();
        }
        if (DC) {
            a(new a(wVar));
        }
        j(wVar).iBm = new b(wVar2.aBm());
        j(wVar).iBl = null;
        AppMethodBeat.o(132593);
    }

    private synchronized void i(w wVar) {
        b bVar;
        AppMethodBeat.i(132594);
        this.iBc = wVar.aBm();
        this.iBb = false;
        a(new a(wVar));
        a aLo = aLo();
        if (bo.isNullOrNil(this.iAY)) {
            bVar = null;
        } else {
            bVar = new b(this.iAY);
        }
        aLo.iBm = bVar;
        AppMethodBeat.o(132594);
    }

    private synchronized void aLm() {
        this.iBd = null;
        this.iBc = null;
        this.iBb = false;
    }

    public final void a(w wVar, w wVar2, aq aqVar) {
        AppMethodBeat.i(132595);
        synchronized (this) {
            try {
                if (this.iBb) {
                    i(wVar);
                } else if (aqVar == aq.NAVIGATE_BACK) {
                    b(wVar, wVar2);
                    AppMethodBeat.o(132595);
                } else {
                    if (this.iBd != null) {
                        aLm();
                    }
                    if (wVar2 != null) {
                        a j = j(wVar2);
                        if (j != null) {
                            j.iBl = new c(2, wVar.aBm());
                        }
                    }
                    a aVar = new a(wVar);
                    aVar.iBm = wVar2 == null ? null : new b(wVar2.aBm());
                    a(aVar);
                    AppMethodBeat.o(132595);
                }
            } finally {
                AppMethodBeat.o(132595);
            }
        }
    }

    public final void b(w wVar) {
        AppMethodBeat.i(132596);
        synchronized (this) {
            try {
                a j = j(wVar);
                if (j == null) {
                } else {
                    Pair l = e.l(wVar);
                    j.iBl = new c(((Integer) l.first).intValue(), (String) l.second);
                    AppMethodBeat.o(132596);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(132596);
            }
        }
    }

    private a j(w wVar) {
        AppMethodBeat.i(132597);
        a aLo = aLo();
        if (aLo == null) {
            aLo = new a(wVar);
            AppMethodBeat.o(132597);
            return aLo;
        } else if (aLo.iBk == wVar.hashCode()) {
            AppMethodBeat.o(132597);
            return aLo;
        } else {
            ab.printErrStackTrace("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
            AppMethodBeat.o(132597);
            return aLo;
        }
    }

    public final synchronized void c(w wVar) {
        AppMethodBeat.i(132598);
        if (this.iBb) {
            i(wVar);
            AppMethodBeat.o(132598);
        } else {
            aLm();
            AppMethodBeat.o(132598);
        }
    }

    private synchronized void a(a aVar) {
        AppMethodBeat.i(132599);
        this.iBa.offerFirst(aVar);
        this.iAZ.put(aVar.iBk, aVar);
        AppMethodBeat.o(132599);
    }

    private synchronized a aLn() {
        a aVar;
        AppMethodBeat.i(132600);
        aVar = (a) this.iBa.pollFirst();
        if (aVar != null) {
            this.iAZ.remove(aVar.iBk);
        }
        AppMethodBeat.o(132600);
        return aVar;
    }

    public final synchronized a aLo() {
        a aVar;
        AppMethodBeat.i(132601);
        aVar = (a) this.iBa.peekFirst();
        AppMethodBeat.o(132601);
        return aVar;
    }

    private synchronized boolean isEmpty() {
        boolean isEmpty;
        AppMethodBeat.i(132602);
        isEmpty = this.iBa.isEmpty();
        AppMethodBeat.o(132602);
        return isEmpty;
    }

    public final synchronized boolean DC(String str) {
        boolean z;
        AppMethodBeat.i(132603);
        if (bo.isNullOrNil(this.iBc) || !this.iBc.equals(str)) {
            z = false;
            AppMethodBeat.o(132603);
        } else {
            z = true;
            AppMethodBeat.o(132603);
        }
        return z;
    }

    public final synchronized a k(w wVar) {
        a aVar;
        AppMethodBeat.i(132604);
        aVar = (a) this.iAZ.get(wVar.hashCode());
        if (aVar == null && this.iBd != null && this.iBd.iBk == wVar.hashCode()) {
            aVar = this.iBd;
            AppMethodBeat.o(132604);
        } else {
            AppMethodBeat.o(132604);
        }
        return aVar;
    }
}
