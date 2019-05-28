package com.tencent.p177mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1414ab;

/* renamed from: com.tencent.mm.compatible.util.m */
public final class C41943m {
    /* renamed from: Mx */
    public static boolean m74078Mx() {
        AppMethodBeat.m2504i(93106);
        String str = C1414ab.get("ro.mediatek.platform");
        if (str == null || !(str.startsWith("MT") || str.startsWith("mt"))) {
            AppMethodBeat.m2505o(93106);
            return false;
        }
        AppMethodBeat.m2505o(93106);
        return true;
    }
}
