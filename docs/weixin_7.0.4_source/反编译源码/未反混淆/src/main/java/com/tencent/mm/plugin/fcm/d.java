package com.tencent.mm.plugin.fcm;

import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d {
    private static final String[] mqC = new String[]{"A53", "A53m", "A53t", "A33m", "A33", "A33t", "R7Plust", "R7Plus", "A59t", "A59s", "A59m", "R9PlustA", "R9PlusmA", "R9PlustmA", "R9tm", "R9m", "R9km", "A37t", "A37m", "R7sPlus", "R7Plusm", "A53", "A51kc", "A51", "A30"};

    public static final boolean e(g gVar) {
        int i;
        boolean z;
        AppMethodBeat.i(56441);
        if (VERSION.SDK_INT == 21 || VERSION.SDK_INT == 22) {
            if (bo.bc(Build.MANUFACTURER, "").toLowerCase().indexOf("oppo".toLowerCase()) >= 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                for (String str : mqC) {
                    if (str.equalsIgnoreCase(Build.DEVICE) || str.equalsIgnoreCase(Build.PRODUCT)) {
                        ab.i("OPPOFirebaseProblem", "for oppo firebase problem, %s", Build.MODEL);
                        i = 1;
                        break;
                    }
                }
            }
        }
        i = 0;
        if (i == 0 || GooglePlayServicesUtil.isGooglePlayServicesAvailable(gVar.cc) == 0) {
            z = false;
        } else {
            z = true;
        }
        ab.i("MicroMsg.FCM.OPPOFirebaseProblem", "isNoSupportFCM() result:%s", Boolean.valueOf(z));
        AppMethodBeat.o(56441);
        return z;
    }
}
