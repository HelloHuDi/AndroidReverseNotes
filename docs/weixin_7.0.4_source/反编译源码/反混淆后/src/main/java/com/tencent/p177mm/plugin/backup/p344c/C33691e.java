package com.tencent.p177mm.plugin.backup.p344c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.backup.c.e */
public final class C33691e {
    public static int jsI;
    public static int jsJ;
    public static int jsK;
    public static int jsL;
    public static int jsM;
    public static int jsN;
    public static int jsO;
    public static long jsP;
    public static long jsQ;
    public static long jsR;

    public static void reset() {
        AppMethodBeat.m2504i(17217);
        jsI = 0;
        jsJ = 0;
        jsK = 0;
        jsL = 0;
        jsM = 0;
        jsN = 0;
        jsO = 0;
        long anU = C5046bo.anU();
        jsP = anU;
        jsR = anU - jsQ;
        AppMethodBeat.m2505o(17217);
    }

    /* renamed from: rm */
    public static void m55032rm(int i) {
        switch (i) {
            case 1:
                jsK++;
                break;
            case 3:
                jsI++;
                break;
            case 34:
                jsM++;
                break;
            case C2275g.CTRL_INDEX /*37*/:
            case 40:
            case 42:
            case 48:
            case 66:
            case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                jsJ++;
                break;
            case 43:
                jsL++;
                break;
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                jsN++;
                break;
        }
        jsO++;
    }

    public static void aSS() {
        AppMethodBeat.m2504i(17218);
        C4990ab.m7410d("MicroMsg.TestInfo", C33691e.getInfo());
        AppMethodBeat.m2505o(17218);
    }

    public static void aST() {
        AppMethodBeat.m2504i(17219);
        C4990ab.m7410d("MicroMsg.TestInfo", "netTime" + (C5046bo.anU() - jsQ));
        AppMethodBeat.m2505o(17219);
    }

    private static String getInfo() {
        AppMethodBeat.m2504i(17220);
        String str = "total_count: " + jsO + "text_count: " + jsK + "normal_count : " + jsJ + " image_count: " + jsI + " voice_count : " + jsM + " video_count " + jsL + " app_count : " + jsN + " time: " + (C5046bo.anU() - jsP) + " net: " + jsR;
        AppMethodBeat.m2505o(17220);
        return str;
    }
}
