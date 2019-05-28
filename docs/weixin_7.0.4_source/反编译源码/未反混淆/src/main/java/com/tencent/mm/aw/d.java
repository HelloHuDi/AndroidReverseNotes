package com.tencent.mm.aw;

import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.TimeZone;

public final class d {
    public static boolean aim() {
        AppMethodBeat.i(108007);
        if (aio() || ain()) {
            AppMethodBeat.o(108007);
            return true;
        }
        AppMethodBeat.o(108007);
        return false;
    }

    public static boolean ain() {
        AppMethodBeat.i(108008);
        ab.i("MicroMsg.Music.MusicHelperUtils", "isShakeMusicGlobalUser: %d", Integer.valueOf(g.Nu().getInt("ShakeMusicGlobalSwitch", 0)));
        if (g.Nu().getInt("ShakeMusicGlobalSwitch", 0) == 0) {
            AppMethodBeat.o(108008);
            return false;
        }
        AppMethodBeat.o(108008);
        return true;
    }

    public static boolean aio() {
        AppMethodBeat.i(108009);
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            AppMethodBeat.o(108009);
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) ah.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!(bo.isNullOrNil(networkCountryIso) || networkCountryIso.equalsIgnoreCase("cn"))) {
                AppMethodBeat.o(108009);
                return false;
            }
        }
        AppMethodBeat.o(108009);
        return true;
    }
}
