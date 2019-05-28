package com.tencent.p177mm.plugin.fcm;

import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fcm.d */
public final class C3111d {
    private static final String[] mqC = new String[]{"A53", "A53m", "A53t", "A33m", "A33", "A33t", "R7Plust", "R7Plus", "A59t", "A59s", "A59m", "R9PlustA", "R9PlusmA", "R9PlustmA", "R9tm", "R9m", "R9km", "A37t", "A37m", "R7sPlus", "R7Plusm", "A53", "A51kc", "A51", "A30"};

    /* renamed from: e */
    public static final boolean m5354e(C1681g c1681g) {
        int i;
        boolean z;
        AppMethodBeat.m2504i(56441);
        if (VERSION.SDK_INT == 21 || VERSION.SDK_INT == 22) {
            if (C5046bo.m7532bc(Build.MANUFACTURER, "").toLowerCase().indexOf("oppo".toLowerCase()) >= 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                for (String str : mqC) {
                    if (str.equalsIgnoreCase(Build.DEVICE) || str.equalsIgnoreCase(Build.PRODUCT)) {
                        C4990ab.m7417i("OPPOFirebaseProblem", "for oppo firebase problem, %s", Build.MODEL);
                        i = 1;
                        break;
                    }
                }
            }
        }
        i = 0;
        if (i == 0 || GooglePlayServicesUtil.isGooglePlayServicesAvailable(c1681g.f1233cc) == 0) {
            z = false;
        } else {
            z = true;
        }
        C4990ab.m7417i("MicroMsg.FCM.OPPOFirebaseProblem", "isNoSupportFCM() result:%s", Boolean.valueOf(z));
        AppMethodBeat.m2505o(56441);
        return z;
    }
}
