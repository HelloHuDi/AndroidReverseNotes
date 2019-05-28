package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;

public final class j {
    private static boolean hLG;

    public static void aDJ() {
        AppMethodBeat.i(96129);
        if (hLG) {
            AppMethodBeat.o(96129);
            return;
        }
        TXLiveBase.setLogLevel(1);
        TXLiveBase.setConsoleEnabled(false);
        TXLiveBase.setListener(new ITXLiveBaseListener() {
            public final void OnLog(int i, String str, String str2) {
                AppMethodBeat.i(96128);
                switch (i) {
                    case 0:
                        ab.v(str, str2);
                        AppMethodBeat.o(96128);
                        return;
                    case 1:
                        ab.d(str, str2);
                        AppMethodBeat.o(96128);
                        return;
                    case 2:
                        ab.i(str, str2);
                        AppMethodBeat.o(96128);
                        return;
                    case 3:
                        ab.w(str, str2);
                        AppMethodBeat.o(96128);
                        return;
                    case 4:
                        ab.e(str, str2);
                        AppMethodBeat.o(96128);
                        return;
                    case 5:
                        ab.f(str, str2);
                        AppMethodBeat.o(96128);
                        return;
                    default:
                        ab.d(str, str2);
                        AppMethodBeat.o(96128);
                        return;
                }
            }
        });
        hLG = true;
        AppMethodBeat.o(96129);
    }
}
