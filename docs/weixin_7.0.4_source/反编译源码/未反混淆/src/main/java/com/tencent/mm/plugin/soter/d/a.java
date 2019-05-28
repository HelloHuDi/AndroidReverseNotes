package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

public final class a {
    private static int rOf = -1;
    private static int rOg = -1;

    public static void EB(int i) {
        rOf = i;
    }

    public static void cvN() {
        AppMethodBeat.i(59319);
        if (rOf == -1) {
            ab.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.o(59319);
            return;
        }
        h.pYm.e(12925, Integer.valueOf(rOf));
        AppMethodBeat.o(59319);
    }

    public static void cvO() {
        AppMethodBeat.i(59320);
        if (rOf == -1) {
            ab.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.o(59320);
            return;
        }
        h.pYm.e(12926, Integer.valueOf(rOf));
        AppMethodBeat.o(59320);
    }

    public static void d(int i, int i2, int i3, String str) {
        AppMethodBeat.i(59321);
        if (rOf == -1) {
            ab.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.o(59321);
            return;
        }
        h.pYm.e(13413, Integer.valueOf(rOf), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        rOf = -1;
        AppMethodBeat.o(59321);
    }

    public static void e(int i, int i2, int i3, String str) {
        AppMethodBeat.i(59322);
        if (rOf == -1) {
            ab.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.o(59322);
            return;
        }
        h.pYm.e(16992, Integer.valueOf(rOf), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        AppMethodBeat.o(59322);
    }

    public static void cvP() {
        AppMethodBeat.i(59323);
        rOg = (int) (System.currentTimeMillis() / 1000);
        AppMethodBeat.o(59323);
    }

    public static void EC(int i) {
        AppMethodBeat.i(59324);
        if (rOg == -1) {
            ab.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
            AppMethodBeat.o(59324);
            return;
        }
        h.pYm.e(12927, Integer.valueOf(rOg), Integer.valueOf(i));
        rOg = -1;
        AppMethodBeat.o(59324);
    }

    public static void ED(int i) {
        AppMethodBeat.i(59325);
        if (rOg == -1) {
            ab.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
            AppMethodBeat.o(59325);
            return;
        }
        h.pYm.e(16995, Integer.valueOf(rOg), Integer.valueOf(i));
        rOg = -1;
        AppMethodBeat.o(59325);
    }

    public static void fG(int i, int i2) {
        AppMethodBeat.i(59326);
        ab.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", Integer.valueOf(i), Integer.valueOf(i2));
        h.pYm.e(14381, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(59326);
    }

    public static void fH(int i, int i2) {
        int i3;
        AppMethodBeat.i(59327);
        switch (i2) {
            case 4:
                i3 = 1;
                break;
            case 5:
                i3 = 3;
                break;
            case 9:
                i3 = 2;
                break;
            case 10:
                i3 = 4;
                break;
            case 26:
                if (i != 3) {
                    i3 = -1;
                    break;
                } else {
                    i3 = 0;
                    break;
                }
            case 1001:
                i3 = 5;
                break;
            default:
                i3 = -1;
                break;
        }
        if (i3 != -1) {
            ab.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", Integer.valueOf(672), Integer.valueOf(i3), Long.valueOf(1));
            h.pYm.a(672, (long) i3, 1, false);
        }
        AppMethodBeat.o(59327);
    }

    public static void EE(int i) {
        AppMethodBeat.i(59328);
        ab.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", Integer.valueOf(3), Integer.valueOf(i), bo.l(new Throwable()));
        HashMap hashMap = new HashMap();
        hashMap.put("sceneType", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        hashMap.put("scene", String.valueOf(i));
        h.pYm.g("Soter", "Fingerprint pay add authentication task failed: ".concat(String.valueOf(r0)), hashMap);
        AppMethodBeat.o(59328);
    }
}
