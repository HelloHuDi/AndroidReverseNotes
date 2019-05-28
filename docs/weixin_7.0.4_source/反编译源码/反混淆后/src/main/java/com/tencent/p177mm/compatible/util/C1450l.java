package com.tencent.p177mm.compatible.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.compatible.util.l */
public final class C1450l {
    /* renamed from: IN */
    public static boolean m3082IN() {
        AppMethodBeat.m2504i(93105);
        if (C5046bo.m7532bc(Build.MANUFACTURER, "").toLowerCase().indexOf("samsung".toLowerCase()) >= 0) {
            AppMethodBeat.m2505o(93105);
            return true;
        }
        AppMethodBeat.m2505o(93105);
        return false;
    }
}
