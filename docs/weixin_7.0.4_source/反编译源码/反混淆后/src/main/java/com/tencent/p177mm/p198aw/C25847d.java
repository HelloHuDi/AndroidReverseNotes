package com.tencent.p177mm.p198aw;

import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.TimeZone;

/* renamed from: com.tencent.mm.aw.d */
public final class C25847d {
    public static boolean aim() {
        AppMethodBeat.m2504i(108007);
        if (C25847d.aio() || C25847d.ain()) {
            AppMethodBeat.m2505o(108007);
            return true;
        }
        AppMethodBeat.m2505o(108007);
        return false;
    }

    public static boolean ain() {
        AppMethodBeat.m2504i(108008);
        C4990ab.m7417i("MicroMsg.Music.MusicHelperUtils", "isShakeMusicGlobalUser: %d", Integer.valueOf(C26373g.m41964Nu().getInt("ShakeMusicGlobalSwitch", 0)));
        if (C26373g.m41964Nu().getInt("ShakeMusicGlobalSwitch", 0) == 0) {
            AppMethodBeat.m2505o(108008);
            return false;
        }
        AppMethodBeat.m2505o(108008);
        return true;
    }

    public static boolean aio() {
        AppMethodBeat.m2504i(108009);
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            AppMethodBeat.m2505o(108009);
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!(C5046bo.isNullOrNil(networkCountryIso) || networkCountryIso.equalsIgnoreCase("cn"))) {
                AppMethodBeat.m2505o(108009);
                return false;
            }
        }
        AppMethodBeat.m2505o(108009);
        return true;
    }
}
