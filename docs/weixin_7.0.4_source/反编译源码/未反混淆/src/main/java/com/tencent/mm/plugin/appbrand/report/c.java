package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.q.d.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.UnsupportedEncodingException;
import java.util.List;

public final class c {
    public static final String iAf = a.Unknown.value;
    public static final String iAg = a.Wifi.value;
    public static final String iAh = a.Mobile_2g.value;
    public static final String iAi = a.Mobile_3g.value;
    public static final String iAj = a.Mobile_4g.value;

    public static String cV(Context context) {
        AppMethodBeat.i(132546);
        String cW = j.cW(context);
        AppMethodBeat.o(132546);
        return cW;
    }

    public static void a(int i, String str, String str2, int i2, String str3, String str4) {
        AppMethodBeat.i(132547);
        ab.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %snearbyAppIdCount %s, nearbyAppIdList %s", Integer.valueOf(13533), Integer.valueOf(i), bo.nullAsNil(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3);
        h.pYm.e(13533, Integer.valueOf(i), bo.nullAsNil(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3, Integer.valueOf(0), str4);
        AppMethodBeat.o(132547);
    }

    public static void a(String str, int i, int i2, long j, boolean z) {
        AppMethodBeat.i(132548);
        String cW = j.cW(ah.getContext());
        if (bo.isNullOrNil(cW)) {
            cW = iAf;
        }
        ab.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s, useModule %b, appType %s", Integer.valueOf(13537), Integer.valueOf(1000), "", "", str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", cW, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Long.valueOf(j), Long.valueOf(bo.anT()), Boolean.valueOf(z), Integer.valueOf(Dw(str)));
        h hVar = h.pYm;
        Object[] objArr = new Object[16];
        objArr[0] = Integer.valueOf(1000);
        objArr[1] = "";
        objArr[2] = "";
        objArr[3] = str;
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(0);
        objArr[6] = Integer.valueOf(0);
        objArr[7] = "";
        objArr[8] = cW;
        objArr[9] = Integer.valueOf(i);
        objArr[10] = Integer.valueOf(i2);
        objArr[11] = Integer.valueOf(0);
        objArr[12] = Long.valueOf(j);
        objArr[13] = Long.valueOf(r2);
        objArr[14] = Integer.valueOf(z ? 1 : 0);
        objArr[15] = Integer.valueOf(r1);
        hVar.e(13537, objArr);
        AppMethodBeat.o(132548);
    }

    public static void a(String str, String str2, int i, String str3, long j, int i2, int i3) {
        AppMethodBeat.i(132549);
        AppBrandStatObject wK = com.tencent.mm.plugin.appbrand.a.wK(str);
        if (wK == null) {
            ab.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
            AppMethodBeat.o(132549);
            return;
        }
        int i4;
        String str4 = "";
        if (!bo.isNullOrNil(str2)) {
            if (str2.contains(".html")) {
                str4 = str2.substring(0, str2.lastIndexOf(".html") + 5);
            }
        }
        String str5 = "";
        try {
            str5 = q.encode(bo.nullAsNil(str4), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, encode page path error!, appId = %s", str);
            ab.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
        }
        AppBrandSysConfigWC wJ = com.tencent.mm.plugin.appbrand.a.wJ(str);
        if (wJ == null) {
            i4 = 0;
        } else {
            i4 = wJ.hhd.gVu;
        }
        int i5 = wJ == null ? 0 : wJ.hhd.gVt + 1;
        String nullAsNil = bo.nullAsNil(str3);
        if (i == 18) {
            if (!bo.isNullOrNil(str3)) {
                if (str3.contains(".html")) {
                    nullAsNil = str3.substring(0, str3.lastIndexOf(".html") + 5);
                }
            }
            try {
                nullAsNil = q.encode(bo.nullAsNil(nullAsNil), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                ab.e("MicroMsg.AppBrandReporterManager", "encode actionNote error!");
                ab.printErrStackTrace("MicroMsg.AppBrandReporterManager", e2, "", new Object[0]);
            }
        }
        String nullAsNil2 = bo.nullAsNil(wK.cst);
        String str6 = null;
        try {
            str6 = bo.nullAsNil(com.tencent.mm.plugin.appbrand.a.wI(str).atI().xz());
        } catch (Exception e3) {
            ab.e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, get runtime by %s, e = %s", str, e3);
        }
        if (wK.scene == 0) {
            wK.scene = 1000;
        }
        int i6 = wK.cOq;
        String str7 = wK.cOr;
        int Dw = Dw(str);
        ab.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, sessionId : %s, appid : %s, appversion : %d, appState : %d, usedState : %d, pagePath : %s, action : %d, actionNote : %s,actionTime : %s, actionResult : %d, actionErrorcode : %d, preScene : %d, preSceneNote : %s, appType : %d", Integer.valueOf(13539), Integer.valueOf(wK.scene), nullAsNil2, str6, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(wK.iAo), str4, Integer.valueOf(i), nullAsNil, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str7, Integer.valueOf(Dw));
        h.pYm.e(13539, Integer.valueOf(wK.scene), nullAsNil2, str6, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(wK.iAo), str5, Integer.valueOf(i), nullAsNil, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str7, Integer.valueOf(Dw));
        AppMethodBeat.o(132549);
    }

    public static void a(String str, String str2, int i, int i2, String str3, String str4, int i3, String str5, long j, int i4, int i5) {
        AppMethodBeat.i(132550);
        int i6 = 3;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(132550);
            return;
        }
        String str6 = "";
        if (!bo.isNullOrNil(str4)) {
            if (str4.contains(".html")) {
                String str7 = str4;
                str6 = str7.substring(0, str4.lastIndexOf(".html") + 5);
            }
        }
        String str8 = "";
        try {
            str8 = q.encode(bo.nullAsNil(str6), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
            ab.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
        }
        String nullAsNil = bo.nullAsNil(str3);
        String nullAsNil2 = bo.nullAsNil(str5);
        String nullAsNil3 = bo.nullAsNil(str2);
        int Dw = Dw(str2);
        if (i > 0) {
            i6 = i - 1;
            boolean aI = f.auT().aI(str, i6);
            if (f.auU().aF(str, i6)) {
                i6 = 1;
            } else if (aI) {
                i6 = 2;
            } else {
                i6 = 3;
            }
        }
        ab.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d, appType %d", Integer.valueOf(13540), Integer.valueOf(i2), nullAsNil, nullAsNil3, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str6, Integer.valueOf(i3), nullAsNil2, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(Dw));
        h.pYm.e(13540, Integer.valueOf(i2), nullAsNil, nullAsNil3, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str8, Integer.valueOf(i3), nullAsNil2, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(Dw));
        AppMethodBeat.o(132550);
    }

    public static void br(String str, int i) {
        AppMethodBeat.i(132551);
        K(str, i, 0);
        AppMethodBeat.o(132551);
    }

    public static void K(String str, int i, int i2) {
        AppMethodBeat.i(132552);
        if ("@LibraryAppId".equals(str)) {
            AppMethodBeat.o(132552);
            return;
        }
        int i3;
        int i4;
        int i5 = 1000;
        CharSequence charSequence = "";
        int i6 = 0;
        if (bo.isNullOrNil(str)) {
            i3 = 1000;
            i4 = 0;
        } else {
            int i7;
            AppBrandStatObject wK = com.tencent.mm.plugin.appbrand.a.wK(str);
            if (wK != null) {
                int i8 = wK.scene == 0 ? 1000 : wK.scene;
                charSequence = bo.nullAsNil(wK.cst);
                i7 = wK.iAo;
                i5 = i8;
            } else {
                i7 = 0;
            }
            AppBrandSysConfigWC wJ = com.tencent.mm.plugin.appbrand.a.wJ(str);
            if (!(wJ == null || wJ.hhd == null)) {
                i6 = wJ.hhd.gVu;
            }
            if (!(i2 != 0 || wJ == null || wJ.hhd == null)) {
                i2 = wJ.hhd.gVt + 1;
            }
            i3 = Dw(str);
            i4 = i7;
        }
        ab.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s, appType %s", Integer.valueOf(13541), Integer.valueOf(i5), charSequence, str, Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(i3));
        h.pYm.e(13541, Integer.valueOf(i5), charSequence, str, Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(3), "", Integer.valueOf(i3));
        if (!TextUtils.isEmpty(charSequence) && charSequence.contains("isWidget=1")) {
            com.tencent.mm.plugin.appbrand.dynamic.f.n(i, str, charSequence);
        }
        AppMethodBeat.o(132552);
    }

    public static void pG(int i) {
        AppMethodBeat.i(132553);
        List a = ((af) g.K(af.class)).a(BaseClientBuilder.API_PRIORITY_OTHER, af.a.DESC);
        StringBuilder stringBuilder = new StringBuilder();
        a = com.tencent.luggage.g.c.C(a);
        List subList = a.subList(0, Math.min(20, a.size()));
        for (int i2 = 0; i2 < subList.size(); i2++) {
            stringBuilder.append(((LocalUsageInfo) subList.get(i2)).appId);
            if (i2 != subList.size() - 1) {
                stringBuilder.append("#");
            }
        }
        ab.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] scene=".concat(String.valueOf(i)));
        ab.i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] appIdStr=".concat(String.valueOf(stringBuilder)));
        h.pYm.e(13800, Integer.valueOf(i), Integer.valueOf(((af) g.K(af.class)).getCount()), stringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(132553);
    }

    public static void a(long j, boolean z, boolean z2) {
        int i;
        AppMethodBeat.i(132554);
        if (z2) {
            i = 775;
        } else {
            i = 367;
        }
        int i2 = j <= FaceGestureDetGLThread.BRIGHTNESS_DURATION ? z ? 8 : 1 : j <= 3000 ? z ? 9 : 2 : j <= 4000 ? z ? 10 : 3 : j <= 5000 ? z ? 11 : 4 : j <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME ? z ? 12 : 5 : z2 ? j <= 7000 ? z ? 19 : 14 : j <= 8000 ? z ? 20 : 15 : j <= 9000 ? z ? 21 : 16 : j <= 10000 ? z ? 22 : 17 : z ? 23 : 18 : z ? 13 : 6;
        h.pYm.a((long) i, (long) i2, 1, false);
        if (z) {
            h.pYm.a((long) i, 7, 1, false);
        } else {
            h.pYm.a((long) i, 0, 1, false);
        }
        ab.v("MicroMsg.AppBrandReporterManager", "startApp cost %s msec(hasDownload : %b).", Long.valueOf(j), Boolean.valueOf(z));
        AppMethodBeat.o(132554);
    }

    public static void aLb() {
        int i;
        AppMethodBeat.i(132555);
        int gX = bo.gX(((com.tencent.mm.kernel.b.h) g.RM().Rn()).cc);
        ab.i("MicroMsg.AppBrandReporterManager", "report now process mem : %d", Integer.valueOf(bo.gX(((com.tencent.mm.kernel.b.h) g.RM().Rn()).cc)));
        if (gX <= 90) {
            i = 2;
        } else if (gX <= 130) {
            i = 3;
        } else if (gX <= ErrorCode.NEEDDOWNLOAD_TRUE) {
            i = 4;
        } else if (gX <= 210) {
            i = 5;
        } else {
            i = 6;
        }
        h.pYm.a(386, 1, 1, false);
        h.pYm.a(386, (long) i, 1, false);
        AppMethodBeat.o(132555);
    }

    public static void pH(int i) {
        AppMethodBeat.i(132556);
        if (i == 10) {
            h.pYm.a(386, 8, 1, false);
            AppMethodBeat.o(132556);
            return;
        }
        if (i == 15) {
            h.pYm.a(386, 7, 1, false);
        }
        AppMethodBeat.o(132556);
    }

    public static void eA(boolean z) {
        AppMethodBeat.i(132557);
        h.pYm.a(482, 482, 1, z ? 2 : 3, 1, 1, false);
        AppMethodBeat.o(132557);
    }

    public static void a(String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(132558);
        h.pYm.e(14369, str, Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(1));
        AppMethodBeat.o(132558);
    }

    public static void pI(int i) {
        AppMethodBeat.i(132559);
        h.pYm.k(807, (long) i, 1);
        AppMethodBeat.o(132559);
    }

    public static void aa(int i, String str) {
        AppMethodBeat.i(132560);
        h.pYm.e(15651, Integer.valueOf(i), bo.nullAsNil(str));
        AppMethodBeat.o(132560);
    }

    public static void pJ(int i) {
        AppMethodBeat.i(132561);
        h.pYm.k(891, (long) i, 1);
        AppMethodBeat.o(132561);
    }

    public static int Dw(String str) {
        AppMethodBeat.i(132562);
        if ("@LibraryAppId".equals(str)) {
            AppMethodBeat.o(132562);
            return 0;
        }
        int Dy = d.Dy(str);
        if (Dy < 0) {
            if (ah.bqo()) {
                WxaAttributes e = f.auO().e(str, "appInfo");
                if (e != null) {
                    Dy = e.ayJ().fmr;
                    d.bs(str, Dy);
                } else {
                    ab.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = attrs!");
                }
            } else {
                o wI = com.tencent.mm.plugin.appbrand.a.wI(str);
                AppBrandInitConfigWC atI = wI == null ? null : wI.atI();
                if (atI != null) {
                    Dy = atI.bQe;
                    d.bs(str, Dy);
                } else {
                    ab.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = initConfig! appServiceType:%s", Integer.valueOf(Dy));
                }
            }
        }
        Dy += 1000;
        AppMethodBeat.o(132562);
        return Dy;
    }
}
