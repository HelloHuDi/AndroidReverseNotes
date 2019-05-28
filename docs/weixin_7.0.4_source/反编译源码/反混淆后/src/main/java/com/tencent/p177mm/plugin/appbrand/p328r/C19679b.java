package com.tencent.p177mm.plugin.appbrand.p328r;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.r.b */
public final class C19679b {
    public static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.m2504i(91136);
        if (str == null) {
            C4990ab.m7412e("Luggage.AndroidPackageUtil", "getPackageInfo fail, packageName is null");
            AppMethodBeat.m2505o(91136);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                AppMethodBeat.m2505o(91136);
            } catch (NameNotFoundException e) {
                C4990ab.printErrStackTrace("Luggage.AndroidPackageUtil", e, "", new Object[0]);
                AppMethodBeat.m2505o(91136);
            }
        }
        return packageInfo;
    }
}
