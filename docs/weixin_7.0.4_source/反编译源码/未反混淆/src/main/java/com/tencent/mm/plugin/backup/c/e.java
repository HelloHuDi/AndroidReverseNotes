package com.tencent.mm.plugin.backup.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import org.xwalk.core.XWalkEnvironment;

public final class e {
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
        AppMethodBeat.i(17217);
        jsI = 0;
        jsJ = 0;
        jsK = 0;
        jsL = 0;
        jsM = 0;
        jsN = 0;
        jsO = 0;
        long anU = bo.anU();
        jsP = anU;
        jsR = anU - jsQ;
        AppMethodBeat.o(17217);
    }

    public static void rm(int i) {
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
            case g.CTRL_INDEX /*37*/:
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
        AppMethodBeat.i(17218);
        ab.d("MicroMsg.TestInfo", getInfo());
        AppMethodBeat.o(17218);
    }

    public static void aST() {
        AppMethodBeat.i(17219);
        ab.d("MicroMsg.TestInfo", "netTime" + (bo.anU() - jsQ));
        AppMethodBeat.o(17219);
    }

    private static String getInfo() {
        AppMethodBeat.i(17220);
        String str = "total_count: " + jsO + "text_count: " + jsK + "normal_count : " + jsJ + " image_count: " + jsI + " voice_count : " + jsM + " video_count " + jsL + " app_count : " + jsN + " time: " + (bo.anU() - jsP) + " net: " + jsR;
        AppMethodBeat.o(17220);
        return str;
    }
}
