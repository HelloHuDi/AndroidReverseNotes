package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;

/* renamed from: com.tencent.tencentmap.mapsdk.a.w */
public class C31016w extends C41027s {
    /* renamed from: b */
    private static volatile C31016w f14036b;

    /* renamed from: a */
    public static C31016w m49806a(Context context) {
        AppMethodBeat.m2504i(98290);
        if (f14036b == null) {
            synchronized (C31016w.class) {
                try {
                    if (f14036b == null) {
                        f14036b = new C31016w(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(98290);
                    }
                }
            }
        }
        C31016w c31016w = f14036b;
        AppMethodBeat.m2505o(98290);
        return c31016w;
    }

    private C31016w(Context context) {
        AppMethodBeat.m2504i(98291);
        if (context == null) {
            AppMethodBeat.m2505o(98291);
            return;
        }
        this.f16426a = context.getSharedPreferences("com.tencent.tencentmap.mapsdk.maps.offlinemap", 0);
        m49807c();
        AppMethodBeat.m2505o(98291);
    }

    /* renamed from: c */
    private void m49807c() {
        AppMethodBeat.m2504i(98292);
        if (f14036b == null) {
            AppMethodBeat.m2505o(98292);
            return;
        }
        mo65086a(new String[]{"taiwanClearCacheVersion", "taiwanStyle", "taiwanVersion", "mapPoiIcon"});
        String a = mo65080a("sdkVersion");
        if (a == null) {
            AppMethodBeat.m2505o(98292);
            return;
        }
        if (C36520ic.m60481b("4.1.0", a) > 0) {
            mo65081a();
        }
        AppMethodBeat.m2505o(98292);
    }
}
