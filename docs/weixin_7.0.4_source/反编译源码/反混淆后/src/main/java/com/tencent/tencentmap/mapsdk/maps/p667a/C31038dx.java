package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.dx */
public final class C31038dx {
    /* renamed from: a */
    public String f14106a;
    /* renamed from: b */
    public String f14107b;
    /* renamed from: c */
    public String f14108c;
    /* renamed from: d */
    public String f14109d;
    /* renamed from: e */
    public String f14110e;

    public C31038dx() {
        AppMethodBeat.m2504i(98750);
        try {
            this.f14106a = Build.MODEL;
            this.f14107b = VERSION.RELEASE;
            this.f14108c = C24373eu.m37732a();
            this.f14109d = C24373eu.m37740b();
            C24373eu.m37747e();
            this.f14110e = C24373eu.m37748f();
            AppMethodBeat.m2505o(98750);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(98750);
        }
    }
}
