package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.tencentmap.mapsdk.p666a.C41003a;
import java.util.HashMap;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.aq */
public final class C46768aq {
    /* renamed from: a */
    private static C46768aq f18065a = null;
    /* renamed from: b */
    private String f18066b = "";
    /* renamed from: c */
    private String f18067c = "";
    /* renamed from: d */
    private String f18068d = "";
    /* renamed from: e */
    private String f18069e = "";
    /* renamed from: f */
    private String f18070f = "";
    /* renamed from: g */
    private String f18071g = "";

    /* renamed from: a */
    public static synchronized C46768aq m88698a(Context context) {
        C46768aq c46768aq;
        synchronized (C46768aq.class) {
            AppMethodBeat.m2504i(98499);
            if (f18065a == null) {
                f18065a = new C46768aq(context);
            }
            c46768aq = f18065a;
            AppMethodBeat.m2505o(98499);
        }
        return c46768aq;
    }

    /* renamed from: a */
    public final synchronized String mo75336a() {
        return this.f18066b;
    }

    /* renamed from: b */
    public final synchronized String mo75337b() {
        return this.f18067c;
    }

    /* renamed from: c */
    public final synchronized String mo75338c() {
        return this.f18068d;
    }

    /* renamed from: d */
    public final synchronized String mo75339d() {
        return this.f18069e;
    }

    /* renamed from: e */
    public final synchronized String mo75340e() {
        return this.f18070f;
    }

    /* renamed from: f */
    public final String mo75341f() {
        return this.f18071g;
    }

    private C46768aq(Context context) {
        AppMethodBeat.m2504i(98500);
        if (context == null) {
            C16205ag.m24687d(" DetailUserInfo context == null? pls check!", new Object[0]);
        }
        C16205ag.m24685b(" start to create DetailUserInfo", new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        C24349e.m37573a(context);
        this.f18066b = C24349e.m37594b(context);
        C16205ag.m24685b(" imei:" + this.f18066b, new Object[0]);
        if (!"".equals(this.f18066b)) {
            try {
                if ("".equals(C41003a.m71119b(context, "IMEI_DENGTA", ""))) {
                    C41003a.m71118a(context, "IMEI_DENGTA", this.f18066b);
                }
            } catch (Exception e) {
            }
        }
        this.f18069e = C24349e.m37605d(context);
        this.f18070f = C41003a.m71119b(context, "QIMEI_DENGTA", "");
        if ("".equals(this.f18070f)) {
            this.f18070f = this.f18066b.equals("") ? this.f18069e : this.f18066b;
        }
        if (C31019an.f14042a == null) {
            C31019an.f14042a = new HashMap();
        }
        C31019an.f14042a.put("A3", this.f18070f);
        this.f18067c = C24349e.m37608e(context);
        if ("".equals(this.f18067c)) {
            StringBuilder stringBuilder = new StringBuilder();
            String e2 = C24349e.m37609e("/sys/class/net/eth0/address");
            e2 = (e2.trim().equals("") || e2.length() < 17) ? "" : e2.toLowerCase().substring(0, 17);
            this.f18067c = stringBuilder.append(e2).toString();
        }
        this.f18068d = C24349e.m37602c(context);
        new StringBuilder().append(C24349e.m37604d());
        new StringBuilder().append(C24349e.m37607e()).append("m");
        this.f18071g = C24349e.m37610f();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        C16205ag.m24685b(" detail create cost: %d  values:\n %s", Long.valueOf(currentTimeMillis2), toString());
        AppMethodBeat.m2505o(98500);
    }
}
