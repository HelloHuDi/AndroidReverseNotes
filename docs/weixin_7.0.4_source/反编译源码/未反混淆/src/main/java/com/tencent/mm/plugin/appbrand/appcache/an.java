package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.InputStream;
import org.json.JSONObject;

public final class an {
    public static final int VERSION;
    public static final String[] gTT;
    static final a gTU;
    private static Boolean gTV = null;

    enum a {
        CUSTOM,
        DEVELOP,
        STABLE;

        static {
            AppMethodBeat.o(114308);
        }
    }

    static {
        int i = -1;
        AppMethodBeat.i(114316);
        try {
            String avT = avT();
            if (!bo.isNullOrNil(avT) && e.ct(avT)) {
                i = new JSONObject(e.cy(avT)).optInt("version");
            }
        } catch (Exception e) {
        }
        if (i > 0) {
            VERSION = i;
            gTT = com.tencent.luggage.h.a.bRR;
            gTU = a.STABLE;
        } else {
            VERSION = 221;
            gTT = com.tencent.luggage.h.a.bRR;
            gTU = a.STABLE;
        }
        AppMethodBeat.o(114316);
    }

    public static void avS() {
        AppMethodBeat.i(114309);
        e.deleteFile(avT());
        AppMethodBeat.o(114309);
    }

    static String avT() {
        AppMethodBeat.i(114310);
        String w = j.w(new b(ah.getContext().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").dMD());
        AppMethodBeat.o(114310);
        return w;
    }

    public static boolean avU() {
        AppMethodBeat.i(114311);
        if (gTV == null) {
            gTV = Boolean.FALSE;
        }
        boolean booleanValue = gTV.booleanValue();
        AppMethodBeat.o(114311);
        return booleanValue;
    }

    public static void dD(boolean z) {
        AppMethodBeat.i(114312);
        as.amF("__appbrand_comm_lib__prefs").putBoolean("disable_develop_lib", z).commit();
        AppMethodBeat.o(114312);
    }

    public static InputStream openRead(String str) {
        AppMethodBeat.i(114313);
        String yk = l.yk(str);
        InputStream xw;
        switch (gTU) {
            case CUSTOM:
                xw = xw("wxa_library/local".concat(String.valueOf(yk)));
                AppMethodBeat.o(114313);
                return xw;
            case DEVELOP:
                xw = xw("wxa_library/develop".concat(String.valueOf(yk)));
                AppMethodBeat.o(114313);
                return xw;
            default:
                xw = xw("wxa_library".concat(String.valueOf(yk)));
                AppMethodBeat.o(114313);
                return xw;
        }
    }

    private static InputStream xw(String str) {
        AppMethodBeat.i(114314);
        try {
            InputStream open = ah.getContext().getAssets().open(str);
            AppMethodBeat.o(114314);
            return open;
        } catch (Exception e) {
            ab.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", str, e);
            AppMethodBeat.o(114314);
            return null;
        }
    }

    public static WxaPkgWrappingInfo avV() {
        AppMethodBeat.i(114315);
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.gVu = VERSION;
        wxaPkgWrappingInfo.gVw = true;
        AppMethodBeat.o(114315);
        return wxaPkgWrappingInfo;
    }
}
