package com.tencent.p177mm.vending.p642h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p640f.C5687a;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.vending.h.g */
public class C5707g {
    /* renamed from: a */
    private static Map<String, C5703d> f1350a = new ConcurrentHashMap();
    /* renamed from: b */
    private static Map<Looper, C5703d> f1351b = new HashMap();
    /* renamed from: c */
    private static boolean f1352c = false;

    static {
        AppMethodBeat.m2504i(126136);
        C5707g.m8572a();
        AppMethodBeat.m2505o(126136);
    }

    /* renamed from: a */
    public static void m8573a(String str, C5703d c5703d) {
        AppMethodBeat.m2504i(126131);
        Assert.assertNotNull("Scheduler type is null", str);
        String toUpperCase = str.toUpperCase(Locale.ENGLISH);
        if (f1350a.containsKey(toUpperCase)) {
            IllegalStateException illegalStateException = new IllegalStateException("Fatal error! Duplicate scheduler type " + str.toUpperCase(Locale.ENGLISH));
        }
        f1350a.put(toUpperCase, c5703d);
        if (c5703d instanceof C7369h) {
            synchronized (C5707g.class) {
                try {
                    f1351b.put(((C7369h) c5703d).f2008b, c5703d);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(126131);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(126131);
    }

    public static void asT(String str) {
        AppMethodBeat.m2504i(126132);
        f1350a.remove(str.toUpperCase(Locale.ENGLISH));
        AppMethodBeat.m2505o(126132);
    }

    public static C5703d asU(String str) {
        AppMethodBeat.m2504i(126133);
        Assert.assertNotNull("Scheduler type is null", str);
        C5703d c5703d = (C5703d) f1350a.get(str.toUpperCase(Locale.ENGLISH));
        Assert.assertNotNull("Scheduler type not found: " + str.toUpperCase(Locale.ENGLISH), c5703d);
        AppMethodBeat.m2505o(126133);
        return c5703d;
    }

    public static synchronized C5703d dMq() {
        C5703d c7367c;
        synchronized (C5707g.class) {
            AppMethodBeat.m2504i(126134);
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                C5687a.m8543w("Vending.SchedulerProvider", "This is not a handler thread! %s", Thread.currentThread());
                c7367c = new C7367c();
                AppMethodBeat.m2505o(126134);
            } else {
                c7367c = (C5703d) f1351b.get(myLooper);
                if (c7367c == null) {
                    c7367c = new C7369h(myLooper, myLooper.toString());
                    f1351b.put(myLooper, c7367c);
                }
                AppMethodBeat.m2505o(126134);
            }
        }
        return c7367c;
    }

    /* renamed from: a */
    static synchronized void m8572a() {
        synchronized (C5707g.class) {
            AppMethodBeat.m2504i(126135);
            if (f1352c) {
                AppMethodBeat.m2505o(126135);
            } else {
                C5687a.m8542i("Vending.SchedulerProvider", "SchedulerProvider provided.", new Object[0]);
                f1352c = true;
                C5707g.m8573a("Vending.UI", C5703d.zYp);
                C5707g.m8573a("Vending.LOGIC", C5703d.zYq);
                C5707g.m8573a("Vending.HEAVY_WORK", C5703d.zYr);
                AppMethodBeat.m2505o(126135);
            }
        }
    }
}
