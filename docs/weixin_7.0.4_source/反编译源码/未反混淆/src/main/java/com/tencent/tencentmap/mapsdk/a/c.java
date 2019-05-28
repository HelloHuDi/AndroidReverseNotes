package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ag;
import com.tencent.tencentmap.mapsdk.maps.a.an;

public final class c {
    private static c n = null;
    private Context a = null;
    private String b = "";
    private String c = "";
    private byte d = (byte) -1;
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";
    private long j = 0;
    private String k = "";
    private String l = "";
    private String m = "";

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final synchronized byte c() {
        return this.d;
    }

    private synchronized void n() {
        this.d = (byte) 1;
    }

    private synchronized String o() {
        return this.e;
    }

    private synchronized void d(String str) {
        this.e = str;
    }

    public final synchronized String d() {
        return this.f;
    }

    public final synchronized void a(String str) {
        this.f = str;
    }

    public final synchronized String e() {
        return this.g;
    }

    private synchronized void e(String str) {
        this.g = str;
    }

    public final synchronized String f() {
        return this.h;
    }

    private synchronized void f(String str) {
        this.h = str;
    }

    public final synchronized String g() {
        return this.i;
    }

    public final synchronized void b(String str) {
        this.i = str;
    }

    public final synchronized long h() {
        return this.j;
    }

    public final synchronized void a(long j) {
        this.j = j;
    }

    public final synchronized String i() {
        String str;
        AppMethodBeat.i(97769);
        if ("".equals(this.k)) {
            try {
                this.k = a.b(this.a, "IMEI_DENGTA", "");
            } catch (Exception e) {
            }
        }
        str = this.k;
        AppMethodBeat.o(97769);
        return str;
    }

    private synchronized void g(String str) {
        AppMethodBeat.i(97770);
        if (!"".equals(str)) {
            try {
                a.a(this.a, "IMEI_DENGTA", str);
            } catch (Exception e) {
            }
        }
        this.k = str;
        AppMethodBeat.o(97770);
    }

    public final synchronized String j() {
        return this.l;
    }

    public final synchronized String k() {
        return this.m;
    }

    public final synchronized void c(String str) {
        this.m = str;
    }

    private synchronized void h(String str) {
        this.l = str;
    }

    private c() {
    }

    public final synchronized Context l() {
        return this.a;
    }

    public static synchronized void a(Context context) {
        synchronized (c.class) {
            AppMethodBeat.i(97771);
            if (context != null) {
                if (n == null) {
                    n = new c();
                }
                synchronized (n) {
                    try {
                        ag.e("init cominfo", new Object[0]);
                        n.a = context;
                        e.a(context);
                        n.b = e.a();
                        c cVar = n;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Android ");
                        stringBuffer.append(e.b());
                        stringBuffer.append(",level ");
                        stringBuffer.append(e.c());
                        cVar.c = stringBuffer.toString();
                        n.n();
                        n.d(a.d(context));
                        if (a.a != null) {
                            n.a(a.a);
                        }
                        n.e("beacon_tmap");
                        n.f("1.6.7");
                        n.b("unknown");
                        n.g(e.b(context));
                        if (an.d() == null || "".equals(an.d())) {
                            cVar = n;
                            cVar.h(cVar.o());
                        } else {
                            n.h(an.d());
                        }
                        n.c(e.b(a.a(context)));
                    } catch (Throwable th) {
                        AppMethodBeat.o(97771);
                    }
                }
                AppMethodBeat.o(97771);
            } else {
                AppMethodBeat.o(97771);
            }
        }
    }

    public static synchronized c m() {
        c cVar;
        synchronized (c.class) {
            cVar = n;
        }
        return cVar;
    }
}
