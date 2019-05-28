package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.a;
import com.tencent.tencentmap.mapsdk.a.b;
import com.tencent.tencentmap.mapsdk.a.e;

public final class u implements Runnable {
    private static long a = 0;
    private Context b = null;

    public u(Context context) {
        this.b = context;
    }

    private static synchronized long a() {
        long j;
        synchronized (u.class) {
            j = a;
        }
        return j;
    }

    public static synchronized void a(long j) {
        synchronized (u.class) {
            a = j;
        }
    }

    public final void run() {
        s[] i;
        int i2;
        AppMethodBeat.i(100559);
        y h = e.h(this.b);
        if (!(h == null || h.b() != 101 || h.c() == null)) {
            try {
                bd f = t.a(this.b).f();
                if (f != null) {
                    f.a(101, h.c(), false);
                    ag.e("common strategy setted by local db", new Object[0]);
                }
            } catch (Throwable th) {
                ag.a(th);
            }
        }
        t a = t.a(this.b);
        if (a.j() == 0) {
            ag.e("stepCheckApp", new Object[0]);
            a.a(1);
            ag.e("isAppFirstRun : %b", Boolean.valueOf(a.c(this.b)));
            if (a.c(this.b)) {
                ag.e("clear all ao: %d", Integer.valueOf(p.a(this.b, null)));
                synchronized (a) {
                    try {
                        ag.e("appfirstRun", new Object[0]);
                        i = a.i();
                        a.h();
                    } catch (Throwable th2) {
                        AppMethodBeat.o(100559);
                    }
                }
                if (i != null) {
                    ag.e("notify listener first run", new Object[0]);
                    for (s c : i) {
                        c.c();
                    }
                }
            } else {
                long a2 = a();
                if (a2 > 0) {
                    ag.e("sleep: %d", Long.valueOf(a2));
                    try {
                        Thread.sleep(a2);
                    } catch (InterruptedException e) {
                        ag.a(e);
                    }
                }
            }
        }
        synchronized (a) {
            try {
                ag.e("stepStartQuery", new Object[0]);
                i = a.i();
                a.a(2);
            } finally {
                AppMethodBeat.o(100559);
            }
        }
        if (i != null) {
            ag.e("notify listener query start", new Object[0]);
            for (s c2 : i) {
                c2.a();
            }
        }
        if (!v.a().g()) {
            be c3 = t.c();
            i2 = 0;
            while (c3 == null) {
                i2++;
                if (i2 >= 5) {
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                    ag.a(e2);
                }
                c3 = t.c();
            }
            if (c3 == null) {
                ag.h("no uphandler ,no upload!", new Object[0]);
            } else if (a(this.b)) {
                ag.c("startQuery: query times arrive max, return!", new Object[0]);
                t.a(this.b).b();
            } else {
                c3.a(new bb(this.b));
            }
        }
        ag.h("common query end!", new Object[0]);
        synchronized (a) {
            try {
                i = a.i();
                a.a(3);
            } finally {
                AppMethodBeat.o(100559);
            }
        }
        if (i != null) {
            ag.e("notify listener query end", new Object[0]);
            for (s b : i) {
                b.b();
            }
        }
        v e3 = t.a(this.b).e();
        if (e3 == null) {
            ag.d("magic should never null ? comStrategy", new Object[0]);
            return;
        }
        long c4 = (long) (e3.c() * 60000);
        if (c4 > 0) {
            b.a().a(this, c4);
            ag.h("next time: %d", Long.valueOf(c4));
            t.a(this.b).a(4);
            return;
        }
        ag.h("stop loop query", new Object[0]);
        AppMethodBeat.o(100559);
    }

    private static boolean a(Context context) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(100560);
        try {
            int parseInt = Integer.parseInt(a.b(context, "querytimes", AppEventsConstants.EVENT_PARAM_VALUE_NO));
            if (!e.g().equals(a.b(context, "initsdkdate", ""))) {
                a.b(context, e.g());
                parseInt = 0;
            }
            if (parseInt <= v.a().f()) {
                a.a(context, String.valueOf(parseInt + 1));
            } else {
                z = true;
                try {
                    ag.e(" sdk init max times", new Object[0]);
                    z2 = true;
                } catch (Exception e) {
                    ag.c(" set init times failed! ", new Object[0]);
                    z2 = z;
                    AppMethodBeat.o(100560);
                    return z2;
                }
            }
        } catch (Exception e2) {
            z = false;
            ag.c(" set init times failed! ", new Object[0]);
            z2 = z;
            AppMethodBeat.o(100560);
            return z2;
        }
        AppMethodBeat.o(100560);
        return z2;
    }
}
