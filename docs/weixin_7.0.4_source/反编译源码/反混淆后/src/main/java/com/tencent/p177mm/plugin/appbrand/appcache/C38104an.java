package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.luggage.p1591h.C41712a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.InputStream;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.an */
public final class C38104an {
    public static final int VERSION;
    public static final String[] gTT;
    static final C33072a gTU;
    private static Boolean gTV = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.an$a */
    enum C33072a {
        CUSTOM,
        DEVELOP,
        STABLE;

        static {
            AppMethodBeat.m2505o(114308);
        }
    }

    static {
        int i = -1;
        AppMethodBeat.m2504i(114316);
        try {
            String avT = C38104an.avT();
            if (!C5046bo.isNullOrNil(avT) && C5730e.m8628ct(avT)) {
                i = new JSONObject(C5730e.m8631cy(avT)).optInt("version");
            }
        } catch (Exception e) {
        }
        if (i > 0) {
            VERSION = i;
            gTT = C41712a.bRR;
            gTU = C33072a.STABLE;
        } else {
            VERSION = 221;
            gTT = C41712a.bRR;
            gTU = C33072a.STABLE;
        }
        AppMethodBeat.m2505o(114316);
    }

    public static void avS() {
        AppMethodBeat.m2504i(114309);
        C5730e.deleteFile(C38104an.avT());
        AppMethodBeat.m2505o(114309);
    }

    static String avT() {
        AppMethodBeat.m2504i(114310);
        String w = C5736j.m8649w(new C5728b(C4996ah.getContext().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").dMD());
        AppMethodBeat.m2505o(114310);
        return w;
    }

    public static boolean avU() {
        AppMethodBeat.m2504i(114311);
        if (gTV == null) {
            gTV = Boolean.FALSE;
        }
        boolean booleanValue = gTV.booleanValue();
        AppMethodBeat.m2505o(114311);
        return booleanValue;
    }

    /* renamed from: dD */
    public static void m64445dD(boolean z) {
        AppMethodBeat.m2504i(114312);
        C5018as.amF("__appbrand_comm_lib__prefs").putBoolean("disable_develop_lib", z).commit();
        AppMethodBeat.m2505o(114312);
    }

    public static InputStream openRead(String str) {
        AppMethodBeat.m2504i(114313);
        String yk = C42367l.m74946yk(str);
        InputStream xw;
        switch (gTU) {
            case CUSTOM:
                xw = C38104an.m64446xw("wxa_library/local".concat(String.valueOf(yk)));
                AppMethodBeat.m2505o(114313);
                return xw;
            case DEVELOP:
                xw = C38104an.m64446xw("wxa_library/develop".concat(String.valueOf(yk)));
                AppMethodBeat.m2505o(114313);
                return xw;
            default:
                xw = C38104an.m64446xw("wxa_library".concat(String.valueOf(yk)));
                AppMethodBeat.m2505o(114313);
                return xw;
        }
    }

    /* renamed from: xw */
    private static InputStream m64446xw(String str) {
        AppMethodBeat.m2504i(114314);
        try {
            InputStream open = C4996ah.getContext().getAssets().open(str);
            AppMethodBeat.m2505o(114314);
            return open;
        } catch (Exception e) {
            C4990ab.m7419v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", str, e);
            AppMethodBeat.m2505o(114314);
            return null;
        }
    }

    public static WxaPkgWrappingInfo avV() {
        AppMethodBeat.m2504i(114315);
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.gVu = VERSION;
        wxaPkgWrappingInfo.gVw = true;
        AppMethodBeat.m2505o(114315);
        return wxaPkgWrappingInfo;
    }
}
