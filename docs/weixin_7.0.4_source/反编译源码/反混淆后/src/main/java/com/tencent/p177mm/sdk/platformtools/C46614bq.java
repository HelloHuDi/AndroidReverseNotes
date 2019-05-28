package com.tencent.p177mm.sdk.platformtools;

import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimeZone;

/* renamed from: com.tencent.mm.sdk.platformtools.bq */
public final class C46614bq {
    public static boolean dpN() {
        AppMethodBeat.m2504i(115249);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
        C4996ah.getContext();
        String h = C4988aa.m7405h(sharedPreferences);
        String dor = C4988aa.dor();
        if (!h.equals("language_default")) {
            dor = h;
        }
        if (dor.equals("zh_CN")) {
            if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
                AppMethodBeat.m2505o(115249);
                return true;
            }
            TelephonyManager telephonyManager = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
            if (telephonyManager != null) {
                dor = telephonyManager.getNetworkCountryIso();
                if (!(C5046bo.isNullOrNil(dor) || dor.contains("cn") || dor.contains("CN"))) {
                    AppMethodBeat.m2505o(115249);
                    return true;
                }
            }
            AppMethodBeat.m2505o(115249);
            return false;
        }
        AppMethodBeat.m2505o(115249);
        return true;
    }
}
