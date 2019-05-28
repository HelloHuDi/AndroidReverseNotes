package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d {
    public static final h zYp = new h(Looper.getMainLooper(), "Vending.UI");
    public static final h zYq = new h(b.dMs().a.getLooper(), "Vending.LOGIC");
    public static final h zYr = new h(a.dMr().a.getLooper(), "Vending.HEAVY_WORK");

    public abstract void cancel();

    public abstract String getType();

    public abstract void l(Runnable runnable, long j);

    public abstract void o(Runnable runnable);

    static {
        g.a();
    }

    public static synchronized d dMq() {
        d dMq;
        synchronized (d.class) {
            dMq = g.dMq();
        }
        return dMq;
    }
}
