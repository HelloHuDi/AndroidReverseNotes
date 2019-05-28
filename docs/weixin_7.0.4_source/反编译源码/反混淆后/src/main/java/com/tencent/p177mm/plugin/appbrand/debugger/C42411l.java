package com.tencent.p177mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.protocal.protobuf.cql;
import com.tencent.p177mm.protocal.protobuf.cqt;
import com.tencent.p177mm.protocal.protobuf.cra;
import com.tencent.p177mm.protocal.protobuf.crf;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.l */
public final class C42411l {
    private boolean hjA;
    private boolean hjB;
    private final HashMap<String, Method> hjC = new HashMap();
    private final HashMap<String, cra> hjD = new HashMap();
    LinkedList<Pair<String, ValueCallback<String>>> hjE = new LinkedList();
    final LinkedList<C42416o> hjF = new LinkedList();
    final Map<String, C19166k> hjG = new HashMap();
    final LinkedList<cqt> hjH = new LinkedList();
    final HashMap<Integer, C26846b> hjI = new HashMap();
    int hjJ = 0;
    long hjK = 0;
    C45126b hjn;
    final cql hjo = new cql();
    private String hjp;
    private int hjq = 0;
    private int hjr = 0;
    crf hjs;
    C45537m hjt;
    AtomicInteger hju = new AtomicInteger(0);
    long hjv = 0;
    long hjw = 0;
    long hjx;
    long hjy = System.currentTimeMillis();
    AtomicInteger hjz = new AtomicInteger(0);
    final Object mLock = new Object();
    private int mStatus = 0;

    public C42411l() {
        AppMethodBeat.m2504i(101823);
        AppMethodBeat.m2505o(101823);
    }

    /* renamed from: a */
    public final void mo67920a(C45126b c45126b, String str) {
        boolean z = true;
        AppMethodBeat.m2504i(101824);
        this.hjn = c45126b;
        this.hjt = C26852t.m42769zP(str);
        AppBrandSysConfigLU xZ = this.hjn.mo34954xL().mo43489xZ();
        if (xZ != null) {
            xZ.bQs = this.hjt.bQs;
            xZ.bQf = true;
            C38414a c38414a = (C38414a) c45126b.mo34954xL().mo14986aa(C38414a.class);
            if (c38414a != null) {
                if (xZ.bQs) {
                    z = false;
                }
                c38414a.iof = z;
            }
        }
        AppMethodBeat.m2505o(101824);
    }

    public final synchronized String ayY() {
        return this.hjp;
    }

    /* renamed from: zI */
    public final synchronized void mo67937zI(String str) {
        this.hjp = str;
    }

    public final synchronized int ayZ() {
        return this.hjq;
    }

    /* renamed from: nG */
    public final synchronized void mo67933nG(int i) {
        this.hjq = i;
    }

    public final synchronized int aza() {
        return this.hjr;
    }

    /* renamed from: nH */
    public final synchronized void mo67934nH(int i) {
        if (this.hjr < i) {
            this.hjr = i;
        }
    }

    /* renamed from: cU */
    public final synchronized void mo67928cU(int i, int i2) {
        if (this.hjr >= i && this.hjr <= i2) {
            this.hjr = i2;
        }
    }

    public final synchronized void setStatus(int i) {
        this.mStatus = i;
    }

    private synchronized int getStatus() {
        return this.mStatus;
    }

    public final synchronized boolean isBusy() {
        return this.hjA;
    }

    /* renamed from: dJ */
    public final synchronized void mo67929dJ(boolean z) {
        this.hjA = z;
    }

    public final synchronized boolean isReady() {
        boolean z;
        AppMethodBeat.m2504i(101825);
        if (getStatus() == 3) {
            z = true;
            AppMethodBeat.m2505o(101825);
        } else {
            z = false;
            AppMethodBeat.m2505o(101825);
        }
        return z;
    }

    public final synchronized boolean azb() {
        return this.hjB;
    }

    /* renamed from: dK */
    public final synchronized void mo67930dK(boolean z) {
        this.hjB = z;
    }

    public final boolean azc() {
        AppMethodBeat.m2504i(101826);
        if (getStatus() == 4) {
            AppMethodBeat.m2505o(101826);
            return true;
        }
        AppMethodBeat.m2505o(101826);
        return false;
    }

    public final boolean azd() {
        AppMethodBeat.m2504i(101827);
        if (getStatus() == 5) {
            AppMethodBeat.m2505o(101827);
            return true;
        }
        AppMethodBeat.m2505o(101827);
        return false;
    }

    /* renamed from: nI */
    public final void mo67935nI(int i) {
        this.hjK += (long) i;
    }

    public final boolean aze() {
        return this.hjt.hjO == 3;
    }
}
