package com.tencent.p177mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelvideo.k */
public final class C1883k {
    public static final String ale() {
        AppMethodBeat.m2504i(50727);
        String str = C1720g.m3536RP().eJM + "draft/";
        AppMethodBeat.m2505o(50727);
        return str;
    }

    /* renamed from: tX */
    public static final String m3987tX(String str) {
        AppMethodBeat.m2504i(50728);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50728);
            return null;
        }
        String str2 = C1883k.ale() + str;
        AppMethodBeat.m2505o(50728);
        return str2;
    }

    /* renamed from: tY */
    public static final String m3988tY(String str) {
        AppMethodBeat.m2504i(50729);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50729);
            return null;
        }
        String str2 = C1883k.ale() + str + ".thumb";
        AppMethodBeat.m2505o(50729);
        return str2;
    }
}
