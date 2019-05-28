package com.tencent.p177mm.plugin.soter.p528d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C30972i;

/* renamed from: com.tencent.mm.plugin.soter.d.d */
public final class C13720d {
    public static C29254e cvQ() {
        AppMethodBeat.m2504i(59333);
        SharedPreferences doB = C4996ah.doB();
        C29254e c29254e;
        if (doB == null) {
            c29254e = new C29254e();
            AppMethodBeat.m2505o(59333);
            return c29254e;
        }
        String string = doB.getString("cpu_id", "");
        String string2 = doB.getString("uid", "");
        if (C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(string2)) {
            C4990ab.m7420w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
            C30972i dQS = C40997a.dQS();
            if (dQS != null) {
                string = dQS.rOh;
                string2 = String.valueOf(dQS.uid);
                if (!(C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(string2))) {
                    C13720d.m21910gu(string, string2);
                    c29254e = new C29254e(string, string2);
                    AppMethodBeat.m2505o(59333);
                    return c29254e;
                }
            }
            c29254e = new C29254e();
            AppMethodBeat.m2505o(59333);
            return c29254e;
        }
        C4990ab.m7416i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
        c29254e = new C29254e(string, string2);
        AppMethodBeat.m2505o(59333);
        return c29254e;
    }

    /* renamed from: gu */
    public static void m21910gu(String str, String str2) {
        AppMethodBeat.m2504i(59334);
        SharedPreferences doB = C4996ah.doB();
        if (doB == null) {
            AppMethodBeat.m2505o(59334);
            return;
        }
        C4990ab.m7416i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
        Editor edit = doB.edit();
        edit.putString("cpu_id", str);
        edit.putString("uid", str2);
        edit.apply();
        AppMethodBeat.m2505o(59334);
    }
}
