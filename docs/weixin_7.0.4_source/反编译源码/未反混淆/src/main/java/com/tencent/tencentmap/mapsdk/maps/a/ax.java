package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.b;
import com.tencent.tencentmap.mapsdk.a.c;
import com.tencent.tencentmap.mapsdk.a.d;
import com.tencent.tencentmap.mapsdk.a.e;
import com.tencent.tencentmap.mapsdk.a.g;
import com.tencent.tencentmap.mapsdk.maps.a.v.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public final class ax extends Observable implements s, w, x {
    private static ax a = null;
    private as b = null;
    private au c = null;
    private au d = null;
    private boolean e = true;
    private boolean f = false;
    private Context g;
    private be h;
    private boolean i;
    private int j = 0;
    private List<ar> k = null;
    private Object l = new Object();
    private g m = null;

    public static synchronized ax a(Context context, be beVar, ay ayVar) {
        ax axVar;
        synchronized (ax.class) {
            AppMethodBeat.i(98526);
            if (a == null) {
                ag.e(" create ua instance ", new Object[0]);
                a = new ax(context, beVar, ayVar);
            }
            ag.e(" return ua instance ", new Object[0]);
            axVar = a;
            AppMethodBeat.o(98526);
        }
        return axVar;
    }

    public static synchronized ax d() {
        ax axVar;
        synchronized (ax.class) {
            axVar = a;
        }
        return axVar;
    }

    public static synchronized be a(Context context, boolean z) {
        bf a;
        synchronized (ax.class) {
            AppMethodBeat.i(98527);
            a = bf.a(context, z);
            AppMethodBeat.o(98527);
        }
        return a;
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        AppMethodBeat.i(98528);
        ag.e(" onUA: %s,%b,%d,%d,%b,%b", str, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z2), Boolean.valueOf(z3));
        ax d = d();
        if (d != null && !d.m()) {
            d.k.add(new ar(str, z, j, j2, map, z2));
            AppMethodBeat.o(98528);
            return true;
        } else if (!i()) {
            AppMethodBeat.o(98528);
            return false;
        } else if (d.b.a(str)) {
            ag.c("onUserAction return false, because eventName:[%s] is not allowed in server strategy!", str);
            AppMethodBeat.o(98528);
            return false;
        } else if (!z || (z && d.b.b(str))) {
            au k = z2 ? d.k() : d.j();
            if (k != null) {
                av a = e.a(d.g, str, z, j, j2, map, z3);
                if (a == null) {
                    ag.c("createdRecordBean bean is null, return false!", new Object[0]);
                    AppMethodBeat.o(98528);
                    return false;
                }
                boolean a2 = k.a(a);
                AppMethodBeat.o(98528);
                return a2;
            }
            AppMethodBeat.o(98528);
            return false;
        } else {
            ag.c("onUserAction return false, because eventName:[%s] is sampled by svr rate!", str);
            AppMethodBeat.o(98528);
            return false;
        }
    }

    public static boolean a(boolean z) {
        AppMethodBeat.i(98529);
        ax d = d();
        if (d == null) {
            ag.c(" ua module not ready!", new Object[0]);
            AppMethodBeat.o(98529);
            return false;
        } else if (i()) {
            boolean b = d.b(z);
            AppMethodBeat.o(98529);
            return b;
        } else {
            AppMethodBeat.o(98529);
            return false;
        }
    }

    private static boolean i() {
        boolean z = false;
        AppMethodBeat.i(98530);
        ax d = d();
        if (d == null) {
            ag.d("isModuleAble:not init ua", new Object[0]);
            AppMethodBeat.o(98530);
        } else {
            z = d.e();
            if (z && d.l()) {
                z = d.m();
            }
            AppMethodBeat.o(98530);
        }
        return z;
    }

    public final synchronized boolean e() {
        return this.i;
    }

    private ax(Context context, be beVar, ay ayVar) {
        AppMethodBeat.i(98531);
        if (context == null) {
            ag.c(" the context is null! init UserActionRecord failed!", new Object[0]);
            this.g = null;
            AppMethodBeat.o(98531);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.g = applicationContext;
        } else {
            this.g = context;
        }
        if (c.m() == null) {
            c.a(this.g);
        }
        if (this.k == null) {
            this.k = Collections.synchronizedList(new ArrayList(5));
        }
        this.h = beVar;
        if (beVar != null) {
            beVar.a(ayVar);
        }
        t a = t.a(this.g);
        a.a((s) this);
        a.a((w) this);
        a.a((x) this);
        a.a(0, beVar);
        a.a(1, beVar);
        this.b = new as();
        this.c = new ao(context);
        this.d = new aw(context);
        this.e = true;
        new d().a(this.g);
        this.m = new g();
        AppMethodBeat.o(98531);
    }

    private synchronized au j() {
        return this.c;
    }

    private synchronized au k() {
        return this.d;
    }

    private synchronized boolean l() {
        return this.e;
    }

    private synchronized boolean m() {
        return this.f;
    }

    private synchronized void n() {
        this.f = true;
    }

    public final boolean b(boolean z) {
        AppMethodBeat.i(98532);
        synchronized (this.l) {
            try {
                if ((e() ? e.j(this.g) : -1) > 0) {
                    if (this.h != null) {
                        az apVar = new ap(this.g);
                        apVar.a(z);
                        this.h.a(apVar);
                    }
                    AppMethodBeat.o(98532);
                    return true;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(98532);
            }
        }
        AppMethodBeat.o(98532);
        return false;
    }

    public final void c() {
        AppMethodBeat.i(98533);
        Context context = this.g;
        ag.a(" RecordDAO.deleteRecords() start", new Object[0]);
        int a = p.a(context, new int[]{1});
        ag.e(" ua first clean :%d", Integer.valueOf(a));
        ag.e(" ua remove strategy :%d", Integer.valueOf(e.i(this.g)));
        AppMethodBeat.o(98533);
    }

    private synchronized void c(boolean z) {
        AppMethodBeat.i(98534);
        if (z != e()) {
            au j = j();
            if (j != null) {
                j.a(z);
            }
            j = k();
            if (j != null) {
                j.a(z);
            }
            this.i = z;
        }
        AppMethodBeat.o(98534);
    }

    public final be f() {
        return this.h;
    }

    public final as g() {
        return this.b;
    }

    public final void b() {
        AppMethodBeat.i(98535);
        n();
        try {
            v e = t.a(this.g).e();
            if (e != null) {
                a b = e.b(1);
                if (!(b == null || this.b == null)) {
                    Set d = b.d();
                    if (d != null && d.size() > 0) {
                        this.b.a(d);
                    }
                    d = b.f();
                    if (d != null && d.size() > 0) {
                        this.b.b(d);
                    }
                }
                if (!e() || b == null) {
                    ag.b("event module is disable", new Object[0]);
                } else {
                    if (((e() ? e.j(this.g) : -1) > 0 ? 1 : 0) != 0) {
                        ag.e(" asyn up module %d", Integer.valueOf(1));
                        b.a().a(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(98525);
                                ax.this.b(true);
                                AppMethodBeat.o(98525);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th) {
            ag.a(th);
            ag.d(" common query end error %s", th.toString());
        }
        o();
        if (h() < 2) {
            bf a = bf.a(this.g);
            if (a.a() && a.b()) {
                p();
                q();
                if (this.b.j()) {
                    this.m.setChanged();
                    this.m.notifyObservers(this.g);
                }
            }
        }
        AppMethodBeat.o(98535);
    }

    private synchronized void o() {
        AppMethodBeat.i(98536);
        if (this.k != null && this.k.size() > 0) {
            for (ar arVar : this.k) {
                a(arVar.a, arVar.b, arVar.c, arVar.d, arVar.e, arVar.f, false);
            }
            this.k.clear();
        }
        AppMethodBeat.o(98536);
    }

    private void p() {
        AppMethodBeat.i(98537);
        try {
            if (e() || this.b.f()) {
                t a = t.a(this.g);
                if (a != null) {
                    a b = a.e().b(1);
                    if (b != null) {
                        String b2 = b.b();
                        if (!(b2 == null || "".equals(b2.trim()))) {
                            new at(this.g).b();
                        }
                    }
                }
                AppMethodBeat.o(98537);
                return;
            }
            AppMethodBeat.o(98537);
        } catch (Exception e) {
            ag.c(" startHeart failed! " + e.getMessage(), new Object[0]);
            AppMethodBeat.o(98537);
        }
    }

    private void q() {
        boolean z;
        AppMethodBeat.i(98538);
        if (this.b.i()) {
            if ("".equals(com.tencent.tencentmap.mapsdk.a.a.b(this.g, "LAUEVE_DENGTA", ""))) {
                z = true;
            } else {
                ag.a("AppLaunchedEvent has been uploaded!", new Object[0]);
                AppMethodBeat.o(98538);
                return;
            }
        }
        z = false;
        if (e.a(this.g) == null) {
            ag.c(" DeviceInfo == null?,return", new Object[0]);
            AppMethodBeat.o(98538);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("A33", e.g(this.g));
        hashMap.put("A63", "Y");
        if (com.tencent.tencentmap.mapsdk.a.a.b(this.g)) {
            hashMap.put("A21", "Y");
        } else {
            hashMap.put("A21", "N");
        }
        if (t.a(this.g).g()) {
            hashMap.put("A45", "Y");
        } else {
            hashMap.put("A45", "N");
        }
        if (com.tencent.tencentmap.mapsdk.a.a.g(this.g)) {
            hashMap.put("A66", "F");
        } else {
            hashMap.put("A66", "B");
        }
        hashMap.put("A68", com.tencent.tencentmap.mapsdk.a.a.h(this.g));
        hashMap.put("A85", com.tencent.tencentmap.mapsdk.a.a.b ? "Y" : "N");
        hashMap.put("A9", e.d());
        hashMap.put("A14", e.e());
        boolean a = a("rqd_applaunched", true, 0, 0, hashMap, true, false);
        if (z && a) {
            com.tencent.tencentmap.mapsdk.a.a.a(this.g, "LAUEVE_DENGTA", e.g());
        }
        AppMethodBeat.o(98538);
    }

    public final void a(v vVar) {
        AppMethodBeat.i(98539);
        if (vVar != null) {
            a b = vVar.b(1);
            if (b != null) {
                boolean a = b.a();
                if (e() != a) {
                    ag.f("UAR onCommonStrategyChange setUsable:%b ", Boolean.valueOf(a));
                    c(a);
                }
            }
        }
        AppMethodBeat.o(98539);
    }

    public final void a() {
        AppMethodBeat.i(98540);
        a(h() + 1);
        AppMethodBeat.o(98540);
    }

    public final synchronized int h() {
        return this.j;
    }

    private synchronized void a(int i) {
        this.j = i;
    }

    public final void a(Map<String, String> map) {
        AppMethodBeat.i(98541);
        if (!(map == null || map.size() <= 0 || this.b == null)) {
            this.b.a((Map) map);
        }
        AppMethodBeat.o(98541);
    }
}
