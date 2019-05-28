package com.tencent.mm.sdk.platformtools;

import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimeZone;

public final class bq {
    public static boolean dpN() {
        AppMethodBeat.i(115249);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.doA(), 0);
        ah.getContext();
        String h = aa.h(sharedPreferences);
        String dor = aa.dor();
        if (!h.equals("language_default")) {
            dor = h;
        }
        if (dor.equals("zh_CN")) {
            if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
                AppMethodBeat.o(115249);
                return true;
            }
            TelephonyManager telephonyManager = (TelephonyManager) ah.getContext().getSystemService("phone");
            if (telephonyManager != null) {
                dor = telephonyManager.getNetworkCountryIso();
                if (!(bo.isNullOrNil(dor) || dor.contains("cn") || dor.contains("CN"))) {
                    AppMethodBeat.o(115249);
                    return true;
                }
            }
            AppMethodBeat.o(115249);
            return false;
        }
        AppMethodBeat.o(115249);
        return true;
    }
}
