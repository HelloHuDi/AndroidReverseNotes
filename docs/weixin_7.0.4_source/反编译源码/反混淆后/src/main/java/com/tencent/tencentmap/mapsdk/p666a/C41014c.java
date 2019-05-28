package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16205ag;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31019an;

/* renamed from: com.tencent.tencentmap.mapsdk.a.c */
public final class C41014c {
    /* renamed from: n */
    private static C41014c f16379n = null;
    /* renamed from: a */
    private Context f16380a = null;
    /* renamed from: b */
    private String f16381b = "";
    /* renamed from: c */
    private String f16382c = "";
    /* renamed from: d */
    private byte f16383d = (byte) -1;
    /* renamed from: e */
    private String f16384e = "";
    /* renamed from: f */
    private String f16385f = "";
    /* renamed from: g */
    private String f16386g = "";
    /* renamed from: h */
    private String f16387h = "";
    /* renamed from: i */
    private String f16388i = "";
    /* renamed from: j */
    private long f16389j = 0;
    /* renamed from: k */
    private String f16390k = "";
    /* renamed from: l */
    private String f16391l = "";
    /* renamed from: m */
    private String f16392m = "";

    /* renamed from: a */
    public final String mo65047a() {
        return this.f16381b;
    }

    /* renamed from: b */
    public final String mo65050b() {
        return this.f16382c;
    }

    /* renamed from: c */
    public final synchronized byte mo65052c() {
        return this.f16383d;
    }

    /* renamed from: n */
    private synchronized void m71225n() {
        this.f16383d = (byte) 1;
    }

    /* renamed from: o */
    private synchronized String m71226o() {
        return this.f16384e;
    }

    /* renamed from: d */
    private synchronized void m71219d(String str) {
        this.f16384e = str;
    }

    /* renamed from: d */
    public final synchronized String mo65054d() {
        return this.f16385f;
    }

    /* renamed from: a */
    public final synchronized void mo65049a(String str) {
        this.f16385f = str;
    }

    /* renamed from: e */
    public final synchronized String mo65055e() {
        return this.f16386g;
    }

    /* renamed from: e */
    private synchronized void m71220e(String str) {
        this.f16386g = str;
    }

    /* renamed from: f */
    public final synchronized String mo65056f() {
        return this.f16387h;
    }

    /* renamed from: f */
    private synchronized void m71221f(String str) {
        this.f16387h = str;
    }

    /* renamed from: g */
    public final synchronized String mo65057g() {
        return this.f16388i;
    }

    /* renamed from: b */
    public final synchronized void mo65051b(String str) {
        this.f16388i = str;
    }

    /* renamed from: h */
    public final synchronized long mo65058h() {
        return this.f16389j;
    }

    /* renamed from: a */
    public final synchronized void mo65048a(long j) {
        this.f16389j = j;
    }

    /* renamed from: i */
    public final synchronized String mo65059i() {
        String str;
        AppMethodBeat.m2504i(97769);
        if ("".equals(this.f16390k)) {
            try {
                this.f16390k = C41003a.m71119b(this.f16380a, "IMEI_DENGTA", "");
            } catch (Exception e) {
            }
        }
        str = this.f16390k;
        AppMethodBeat.m2505o(97769);
        return str;
    }

    /* renamed from: g */
    private synchronized void m71222g(String str) {
        AppMethodBeat.m2504i(97770);
        if (!"".equals(str)) {
            try {
                C41003a.m71118a(this.f16380a, "IMEI_DENGTA", str);
            } catch (Exception e) {
            }
        }
        this.f16390k = str;
        AppMethodBeat.m2505o(97770);
    }

    /* renamed from: j */
    public final synchronized String mo65060j() {
        return this.f16391l;
    }

    /* renamed from: k */
    public final synchronized String mo65061k() {
        return this.f16392m;
    }

    /* renamed from: c */
    public final synchronized void mo65053c(String str) {
        this.f16392m = str;
    }

    /* renamed from: h */
    private synchronized void m71223h(String str) {
        this.f16391l = str;
    }

    private C41014c() {
    }

    /* renamed from: l */
    public final synchronized Context mo65062l() {
        return this.f16380a;
    }

    /* renamed from: a */
    public static synchronized void m71218a(Context context) {
        synchronized (C41014c.class) {
            AppMethodBeat.m2504i(97771);
            if (context != null) {
                if (f16379n == null) {
                    f16379n = new C41014c();
                }
                synchronized (f16379n) {
                    try {
                        C16205ag.m24688e("init cominfo", new Object[0]);
                        f16379n.f16380a = context;
                        C24349e.m37573a(context);
                        f16379n.f16381b = C24349e.m37577a();
                        C41014c c41014c = f16379n;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Android ");
                        stringBuffer.append(C24349e.m37593b());
                        stringBuffer.append(",level ");
                        stringBuffer.append(C24349e.m37601c());
                        c41014c.f16382c = stringBuffer.toString();
                        f16379n.m71225n();
                        f16379n.m71219d(C41003a.m71124d(context));
                        if (C41003a.f16325a != null) {
                            f16379n.mo65049a(C41003a.f16325a);
                        }
                        f16379n.m71220e("beacon_tmap");
                        f16379n.m71221f("1.6.7");
                        f16379n.mo65051b("unknown");
                        f16379n.m71222g(C24349e.m37594b(context));
                        if (C31019an.m49827d() == null || "".equals(C31019an.m49827d())) {
                            c41014c = f16379n;
                            c41014c.m71223h(c41014c.m71226o());
                        } else {
                            f16379n.m71223h(C31019an.m49827d());
                        }
                        f16379n.mo65053c(C24349e.m37596b(C41003a.m71114a(context)));
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(97771);
                    }
                }
                AppMethodBeat.m2505o(97771);
            } else {
                AppMethodBeat.m2505o(97771);
            }
        }
    }

    /* renamed from: m */
    public static synchronized C41014c m71224m() {
        C41014c c41014c;
        synchronized (C41014c.class) {
            c41014c = f16379n;
        }
        return c41014c;
    }
}
