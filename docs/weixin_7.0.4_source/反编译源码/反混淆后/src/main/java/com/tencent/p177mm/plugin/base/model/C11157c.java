package com.tencent.p177mm.plugin.base.model;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.base.model.c */
public final class C11157c {
    public static String decrypt(String str) {
        AppMethodBeat.m2504i(79081);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(79081);
            return null;
        }
        String aw = C5046bo.m7524aw(C4996ah.getContext(), Process.myPid());
        C4990ab.m7417i("MicroMsg.ShortcutUtil", "process name: %s", aw);
        if (str.startsWith("shortcut_") && str.length() > 9) {
            aw = str.substring(9);
            if (aw != null && aw.length() > 0) {
                str = C42781b.m75867da(new String(C42781b.m75857Fu(aw)), C1427q.m3026LK());
                AppMethodBeat.m2505o(79081);
                return str;
            }
        }
        AppMethodBeat.m2505o(79081);
        return str;
    }

    /* renamed from: db */
    public static String m18864db(String str, String str2) {
        AppMethodBeat.m2504i(79082);
        String x = C1178g.m2591x((C1178g.m2591x(str.getBytes()) + C42781b.m75867da(str2, str)).getBytes());
        AppMethodBeat.m2505o(79082);
        return x;
    }

    /* renamed from: Fv */
    public static String m18863Fv(String str) {
        AppMethodBeat.m2504i(79083);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(79083);
            return null;
        }
        String aw = C5046bo.m7524aw(C4996ah.getContext(), Process.myPid());
        C4990ab.m7417i("MicroMsg.ShortcutUtil", "process name: %s", aw);
        aw = C42781b.m75867da(str, C1427q.m3026LK());
        if (C5046bo.isNullOrNil(aw)) {
            AppMethodBeat.m2505o(79083);
            return null;
        }
        String str2 = "shortcut_" + C42781b.m75858V(aw.getBytes());
        AppMethodBeat.m2505o(79083);
        return str2;
    }
}
