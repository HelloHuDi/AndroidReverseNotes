package com.tencent.p177mm.plugin.webview.p1068e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.e.a */
public enum C22784a {
    ;

    private C22784a(String str) {
    }

    static {
        AppMethodBeat.m2505o(10131);
    }

    /* renamed from: a */
    public static void m34564a(String str, long j, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(10130);
        if (j <= 0) {
            AppMethodBeat.m2505o(10130);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str).append(",");
        stringBuilder.append(i2).append(",");
        stringBuilder.append(i);
        stringBuilder.append(",").append(i3).append(",").append(currentTimeMillis).append(",").append(i4).append(",").append(i5);
        C4990ab.m7416i("MicroMsg.AuthReport", stringBuilder.toString());
        C7060h.pYm.mo8381e(16488, str, Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3), Long.valueOf(currentTimeMillis), Integer.valueOf(i4), Integer.valueOf(0), Integer.valueOf(i5));
        AppMethodBeat.m2505o(10130);
    }
}
