package com.tencent.p177mm.plugin.soter.p528d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.soter.d.a */
public final class C46261a {
    private static int rOf = -1;
    private static int rOg = -1;

    /* renamed from: EB */
    public static void m86635EB(int i) {
        rOf = i;
    }

    public static void cvN() {
        AppMethodBeat.m2504i(59319);
        if (rOf == -1) {
            C4990ab.m7412e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.m2505o(59319);
            return;
        }
        C7060h.pYm.mo8381e(12925, Integer.valueOf(rOf));
        AppMethodBeat.m2505o(59319);
    }

    public static void cvO() {
        AppMethodBeat.m2504i(59320);
        if (rOf == -1) {
            C4990ab.m7412e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.m2505o(59320);
            return;
        }
        C7060h.pYm.mo8381e(12926, Integer.valueOf(rOf));
        AppMethodBeat.m2505o(59320);
    }

    /* renamed from: d */
    public static void m86639d(int i, int i2, int i3, String str) {
        AppMethodBeat.m2504i(59321);
        if (rOf == -1) {
            C4990ab.m7412e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.m2505o(59321);
            return;
        }
        C7060h.pYm.mo8381e(13413, Integer.valueOf(rOf), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        rOf = -1;
        AppMethodBeat.m2505o(59321);
    }

    /* renamed from: e */
    public static void m86640e(int i, int i2, int i3, String str) {
        AppMethodBeat.m2504i(59322);
        if (rOf == -1) {
            C4990ab.m7412e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            AppMethodBeat.m2505o(59322);
            return;
        }
        C7060h.pYm.mo8381e(16992, Integer.valueOf(rOf), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        AppMethodBeat.m2505o(59322);
    }

    public static void cvP() {
        AppMethodBeat.m2504i(59323);
        rOg = (int) (System.currentTimeMillis() / 1000);
        AppMethodBeat.m2505o(59323);
    }

    /* renamed from: EC */
    public static void m86636EC(int i) {
        AppMethodBeat.m2504i(59324);
        if (rOg == -1) {
            C4990ab.m7412e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
            AppMethodBeat.m2505o(59324);
            return;
        }
        C7060h.pYm.mo8381e(12927, Integer.valueOf(rOg), Integer.valueOf(i));
        rOg = -1;
        AppMethodBeat.m2505o(59324);
    }

    /* renamed from: ED */
    public static void m86637ED(int i) {
        AppMethodBeat.m2504i(59325);
        if (rOg == -1) {
            C4990ab.m7412e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
            AppMethodBeat.m2505o(59325);
            return;
        }
        C7060h.pYm.mo8381e(16995, Integer.valueOf(rOg), Integer.valueOf(i));
        rOg = -1;
        AppMethodBeat.m2505o(59325);
    }

    /* renamed from: fG */
    public static void m86641fG(int i, int i2) {
        AppMethodBeat.m2504i(59326);
        C4990ab.m7419v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", Integer.valueOf(i), Integer.valueOf(i2));
        C7060h.pYm.mo8381e(14381, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(59326);
    }

    /* renamed from: fH */
    public static void m86642fH(int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(59327);
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
            C4990ab.m7417i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", Integer.valueOf(672), Integer.valueOf(i3), Long.valueOf(1));
            C7060h.pYm.mo8378a(672, (long) i3, 1, false);
        }
        AppMethodBeat.m2505o(59327);
    }

    /* renamed from: EE */
    public static void m86638EE(int i) {
        AppMethodBeat.m2504i(59328);
        C4990ab.m7417i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", Integer.valueOf(3), Integer.valueOf(i), C5046bo.m7574l(new Throwable()));
        HashMap hashMap = new HashMap();
        hashMap.put("sceneType", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        hashMap.put("scene", String.valueOf(i));
        C7060h.pYm.mo8382g("Soter", "Fingerprint pay add authentication task failed: ".concat(String.valueOf(r0)), hashMap);
        AppMethodBeat.m2505o(59328);
    }
}
