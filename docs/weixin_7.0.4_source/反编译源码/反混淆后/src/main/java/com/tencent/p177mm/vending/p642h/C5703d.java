package com.tencent.p177mm.vending.p642h;

import android.os.Looper;
import com.tencent.p177mm.vending.p643i.C5708a;
import com.tencent.p177mm.vending.p643i.C5709b;

/* renamed from: com.tencent.mm.vending.h.d */
public abstract class C5703d {
    public static final C7369h zYp = new C7369h(Looper.getMainLooper(), "Vending.UI");
    public static final C7369h zYq = new C7369h(C5709b.dMs().f1355a.getLooper(), "Vending.LOGIC");
    public static final C7369h zYr = new C7369h(C5708a.dMr().f1353a.getLooper(), "Vending.HEAVY_WORK");

    public abstract void cancel();

    public abstract String getType();

    /* renamed from: l */
    public abstract void mo10060l(Runnable runnable, long j);

    /* renamed from: o */
    public abstract void mo10061o(Runnable runnable);

    static {
        C5707g.m8572a();
    }

    public static synchronized C5703d dMq() {
        C5703d dMq;
        synchronized (C5703d.class) {
            dMq = C5707g.dMq();
        }
        return dMq;
    }
}
