package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class g {
    private static Map<String, d> a = new ConcurrentHashMap();
    private static Map<Looper, d> b = new HashMap();
    private static boolean c = false;

    static {
        AppMethodBeat.i(126136);
        a();
        AppMethodBeat.o(126136);
    }

    public static void a(String str, d dVar) {
        AppMethodBeat.i(126131);
        Assert.assertNotNull("Scheduler type is null", str);
        String toUpperCase = str.toUpperCase(Locale.ENGLISH);
        if (a.containsKey(toUpperCase)) {
            IllegalStateException illegalStateException = new IllegalStateException("Fatal error! Duplicate scheduler type " + str.toUpperCase(Locale.ENGLISH));
        }
        a.put(toUpperCase, dVar);
        if (dVar instanceof h) {
            synchronized (g.class) {
                try {
                    b.put(((h) dVar).b, dVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(126131);
                }
            }
            return;
        }
        AppMethodBeat.o(126131);
    }

    public static void asT(String str) {
        AppMethodBeat.i(126132);
        a.remove(str.toUpperCase(Locale.ENGLISH));
        AppMethodBeat.o(126132);
    }

    public static d asU(String str) {
        AppMethodBeat.i(126133);
        Assert.assertNotNull("Scheduler type is null", str);
        d dVar = (d) a.get(str.toUpperCase(Locale.ENGLISH));
        Assert.assertNotNull("Scheduler type not found: " + str.toUpperCase(Locale.ENGLISH), dVar);
        AppMethodBeat.o(126133);
        return dVar;
    }

    public static synchronized d dMq() {
        d cVar;
        synchronized (g.class) {
            AppMethodBeat.i(126134);
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                a.w("Vending.SchedulerProvider", "This is not a handler thread! %s", Thread.currentThread());
                cVar = new c();
                AppMethodBeat.o(126134);
            } else {
                cVar = (d) b.get(myLooper);
                if (cVar == null) {
                    cVar = new h(myLooper, myLooper.toString());
                    b.put(myLooper, cVar);
                }
                AppMethodBeat.o(126134);
            }
        }
        return cVar;
    }

    static synchronized void a() {
        synchronized (g.class) {
            AppMethodBeat.i(126135);
            if (c) {
                AppMethodBeat.o(126135);
            } else {
                a.i("Vending.SchedulerProvider", "SchedulerProvider provided.", new Object[0]);
                c = true;
                a("Vending.UI", d.zYp);
                a("Vending.LOGIC", d.zYq);
                a("Vending.HEAVY_WORK", d.zYr);
                AppMethodBeat.o(126135);
            }
        }
    }
}
