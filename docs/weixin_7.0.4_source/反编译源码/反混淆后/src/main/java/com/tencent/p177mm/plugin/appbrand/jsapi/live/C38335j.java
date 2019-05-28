package com.tencent.p177mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.j */
public final class C38335j {
    private static boolean hLG;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.j$1 */
    static class C104571 implements ITXLiveBaseListener {
        C104571() {
        }

        public final void OnLog(int i, String str, String str2) {
            AppMethodBeat.m2504i(96128);
            switch (i) {
                case 0:
                    C4990ab.m7418v(str, str2);
                    AppMethodBeat.m2505o(96128);
                    return;
                case 1:
                    C4990ab.m7410d(str, str2);
                    AppMethodBeat.m2505o(96128);
                    return;
                case 2:
                    C4990ab.m7416i(str, str2);
                    AppMethodBeat.m2505o(96128);
                    return;
                case 3:
                    C4990ab.m7420w(str, str2);
                    AppMethodBeat.m2505o(96128);
                    return;
                case 4:
                    C4990ab.m7412e(str, str2);
                    AppMethodBeat.m2505o(96128);
                    return;
                case 5:
                    C4990ab.m7414f(str, str2);
                    AppMethodBeat.m2505o(96128);
                    return;
                default:
                    C4990ab.m7410d(str, str2);
                    AppMethodBeat.m2505o(96128);
                    return;
            }
        }
    }

    public static void aDJ() {
        AppMethodBeat.m2504i(96129);
        if (hLG) {
            AppMethodBeat.m2505o(96129);
            return;
        }
        TXLiveBase.setLogLevel(1);
        TXLiveBase.setConsoleEnabled(false);
        TXLiveBase.setListener(new C104571());
        hLG = true;
        AppMethodBeat.m2505o(96129);
    }
}
