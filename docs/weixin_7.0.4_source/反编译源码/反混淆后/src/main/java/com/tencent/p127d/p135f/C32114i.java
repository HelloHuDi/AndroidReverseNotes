package com.tencent.p127d.p135f;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p132e.p133a.p134a.C25599a;

/* renamed from: com.tencent.d.f.i */
public final class C32114i {
    /* renamed from: cd */
    public static C25599a m52252cd(Context context, String str) {
        AppMethodBeat.m2504i(114621);
        C25599a c25599a = new C25599a();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            c25599a.ceO = str;
            c25599a.versionName = packageInfo.versionName;
            c25599a.versionCode = packageInfo.versionCode;
        } catch (Throwable th) {
        }
        AppMethodBeat.m2505o(114621);
        return c25599a;
    }
}
