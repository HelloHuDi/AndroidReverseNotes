package com.tencent.mm.plugin.appbrand.r;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        AppMethodBeat.i(91136);
        if (str == null) {
            ab.e("Luggage.AndroidPackageUtil", "getPackageInfo fail, packageName is null");
            AppMethodBeat.o(91136);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                AppMethodBeat.o(91136);
            } catch (NameNotFoundException e) {
                ab.printErrStackTrace("Luggage.AndroidPackageUtil", e, "", new Object[0]);
                AppMethodBeat.o(91136);
            }
        }
        return packageInfo;
    }
}
