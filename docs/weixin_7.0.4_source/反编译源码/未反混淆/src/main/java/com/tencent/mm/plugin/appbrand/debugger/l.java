package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.a.a.b;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.l.a;
import com.tencent.mm.protocal.protobuf.cql;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.crf;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class l {
    private boolean hjA;
    private boolean hjB;
    private final HashMap<String, Method> hjC = new HashMap();
    private final HashMap<String, cra> hjD = new HashMap();
    LinkedList<Pair<String, ValueCallback<String>>> hjE = new LinkedList();
    final LinkedList<o> hjF = new LinkedList();
    final Map<String, k> hjG = new HashMap();
    final LinkedList<cqt> hjH = new LinkedList();
    final HashMap<Integer, b> hjI = new HashMap();
    int hjJ = 0;
    long hjK = 0;
    b hjn;
    final cql hjo = new cql();
    private String hjp;
    private int hjq = 0;
    private int hjr = 0;
    crf hjs;
    m hjt;
    AtomicInteger hju = new AtomicInteger(0);
    long hjv = 0;
    long hjw = 0;
    long hjx;
    long hjy = System.currentTimeMillis();
    AtomicInteger hjz = new AtomicInteger(0);
    final Object mLock = new Object();
    private int mStatus = 0;

    public l() {
        AppMethodBeat.i(101823);
        AppMethodBeat.o(101823);
    }

    public final void a(b bVar, String str) {
        boolean z = true;
        AppMethodBeat.i(101824);
        this.hjn = bVar;
        this.hjt = t.zP(str);
        AppBrandSysConfigLU xZ = this.hjn.xL().xZ();
        if (xZ != null) {
            xZ.bQs = this.hjt.bQs;
            xZ.bQf = true;
            a aVar = (a) bVar.xL().aa(a.class);
            if (aVar != null) {
                if (xZ.bQs) {
                    z = false;
                }
                aVar.iof = z;
            }
        }
        AppMethodBeat.o(101824);
    }

    public final synchronized String ayY() {
        return this.hjp;
    }

    public final synchronized void zI(String str) {
        this.hjp = str;
    }

    public final synchronized int ayZ() {
        return this.hjq;
    }

    public final synchronized void nG(int i) {
        this.hjq = i;
    }

    public final synchronized int aza() {
        return this.hjr;
    }

    public final synchronized void nH(int i) {
        if (this.hjr < i) {
            this.hjr = i;
        }
    }

    public final synchronized void cU(int i, int i2) {
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

    public final synchronized void dJ(boolean z) {
        this.hjA = z;
    }

    public final synchronized boolean isReady() {
        boolean z;
        AppMethodBeat.i(101825);
        if (getStatus() == 3) {
            z = true;
            AppMethodBeat.o(101825);
        } else {
            z = false;
            AppMethodBeat.o(101825);
        }
        return z;
    }

    public final synchronized boolean azb() {
        return this.hjB;
    }

    public final synchronized void dK(boolean z) {
        this.hjB = z;
    }

    public final boolean azc() {
        AppMethodBeat.i(101826);
        if (getStatus() == 4) {
            AppMethodBeat.o(101826);
            return true;
        }
        AppMethodBeat.o(101826);
        return false;
    }

    public final boolean azd() {
        AppMethodBeat.i(101827);
        if (getStatus() == 5) {
            AppMethodBeat.o(101827);
            return true;
        }
        AppMethodBeat.o(101827);
        return false;
    }

    public final void nI(int i) {
        this.hjK += (long) i;
    }

    public final boolean aze() {
        return this.hjt.hjO == 3;
    }
}
