package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.dv */
public final class C46778dv {
    /* renamed from: a */
    public String f18116a = "";
    /* renamed from: b */
    public int f18117b = 0;
    /* renamed from: c */
    public String f18118c = "";
    /* renamed from: d */
    public String f18119d = "";
    /* renamed from: e */
    public int f18120e;

    public C46778dv() {
        AppMethodBeat.m2504i(98748);
        try {
            this.f18116a = C46772bt.m88735a().getPackageName();
            PackageInfo packageInfo = C46772bt.m88735a().getPackageManager().getPackageInfo(this.f18116a, 0);
            this.f18117b = packageInfo.versionCode;
            this.f18118c = packageInfo.versionName;
            this.f18120e = C46772bt.m88739c();
            this.f18119d = "";
            AppMethodBeat.m2505o(98748);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(98748);
        }
    }
}
