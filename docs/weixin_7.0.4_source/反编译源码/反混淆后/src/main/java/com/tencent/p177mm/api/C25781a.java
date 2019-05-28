package com.tencent.p177mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.api.a */
public final class C25781a {
    /* renamed from: cC */
    public static String m40991cC(String str) {
        AppMethodBeat.m2504i(105476);
        if (C5046bo.isNullOrNil(str)) {
            str = "tempConv";
        }
        StringBuilder stringBuilder = new StringBuilder(C43217c.m76864XX());
        stringBuilder.append(C1178g.m2591x(str.getBytes())).append("/");
        stringBuilder.append("conv/");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(105476);
        return stringBuilder2;
    }
}
