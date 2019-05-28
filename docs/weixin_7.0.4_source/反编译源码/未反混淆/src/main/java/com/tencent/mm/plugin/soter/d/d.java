package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.i;

public final class d {
    public static e cvQ() {
        AppMethodBeat.i(59333);
        SharedPreferences doB = ah.doB();
        e eVar;
        if (doB == null) {
            eVar = new e();
            AppMethodBeat.o(59333);
            return eVar;
        }
        String string = doB.getString("cpu_id", "");
        String string2 = doB.getString("uid", "");
        if (bo.isNullOrNil(string) || bo.isNullOrNil(string2)) {
            ab.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
            i dQS = a.dQS();
            if (dQS != null) {
                string = dQS.rOh;
                string2 = String.valueOf(dQS.uid);
                if (!(bo.isNullOrNil(string) || bo.isNullOrNil(string2))) {
                    gu(string, string2);
                    eVar = new e(string, string2);
                    AppMethodBeat.o(59333);
                    return eVar;
                }
            }
            eVar = new e();
            AppMethodBeat.o(59333);
            return eVar;
        }
        ab.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
        eVar = new e(string, string2);
        AppMethodBeat.o(59333);
        return eVar;
    }

    public static void gu(String str, String str2) {
        AppMethodBeat.i(59334);
        SharedPreferences doB = ah.doB();
        if (doB == null) {
            AppMethodBeat.o(59334);
            return;
        }
        ab.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
        Editor edit = doB.edit();
        edit.putString("cpu_id", str);
        edit.putString("uid", str2);
        edit.apply();
        AppMethodBeat.o(59334);
    }
}
