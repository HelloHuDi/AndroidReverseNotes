package com.tencent.p177mm.plugin.appbrand.report;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.luggage.p147g.C37400c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10211f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C16674d.C16675a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.report.c */
public final class C19690c {
    public static final String iAf = C16675a.Unknown.value;
    public static final String iAg = C16675a.Wifi.value;
    public static final String iAh = C16675a.Mobile_2g.value;
    public static final String iAi = C16675a.Mobile_3g.value;
    public static final String iAj = C16675a.Mobile_4g.value;

    /* renamed from: cV */
    public static String m30503cV(Context context) {
        AppMethodBeat.m2504i(132546);
        String cW = C42674j.m75576cW(context);
        AppMethodBeat.m2505o(132546);
        return cW;
    }

    /* renamed from: a */
    public static void m30495a(int i, String str, String str2, int i2, String str3, String str4) {
        AppMethodBeat.m2504i(132547);
        C4990ab.m7411d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %snearbyAppIdCount %s, nearbyAppIdList %s", Integer.valueOf(13533), Integer.valueOf(i), C5046bo.nullAsNil(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3);
        C7060h.pYm.mo8381e(13533, Integer.valueOf(i), C5046bo.nullAsNil(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3, Integer.valueOf(0), str4);
        AppMethodBeat.m2505o(132547);
    }

    /* renamed from: a */
    public static void m30498a(String str, int i, int i2, long j, boolean z) {
        AppMethodBeat.m2504i(132548);
        String cW = C42674j.m75576cW(C4996ah.getContext());
        if (C5046bo.isNullOrNil(cW)) {
            cW = iAf;
        }
        C4990ab.m7411d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s, useModule %b, appType %s", Integer.valueOf(13537), Integer.valueOf(1000), "", "", str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", cW, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Long.valueOf(j), Long.valueOf(C5046bo.anT()), Boolean.valueOf(z), Integer.valueOf(C19690c.m30493Dw(str)));
        C7060h c7060h = C7060h.pYm;
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
        c7060h.mo8381e(13537, objArr);
        AppMethodBeat.m2505o(132548);
    }

    /* renamed from: a */
    public static void m30500a(String str, String str2, int i, String str3, long j, int i2, int i3) {
        AppMethodBeat.m2504i(132549);
        AppBrandStatObject wK = C10048a.m17637wK(str);
        if (wK == null) {
            C4990ab.m7412e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
            AppMethodBeat.m2505o(132549);
            return;
        }
        int i4;
        String str4 = "";
        if (!C5046bo.isNullOrNil(str2)) {
            if (str2.contains(".html")) {
                str4 = str2.substring(0, str2.lastIndexOf(".html") + 5);
            }
        }
        String str5 = "";
        try {
            str5 = C18178q.encode(C5046bo.nullAsNil(str4), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7413e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, encode page path error!, appId = %s", str);
            C4990ab.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
        }
        AppBrandSysConfigWC wJ = C10048a.m17636wJ(str);
        if (wJ == null) {
            i4 = 0;
        } else {
            i4 = wJ.hhd.gVu;
        }
        int i5 = wJ == null ? 0 : wJ.hhd.gVt + 1;
        String nullAsNil = C5046bo.nullAsNil(str3);
        if (i == 18) {
            if (!C5046bo.isNullOrNil(str3)) {
                if (str3.contains(".html")) {
                    nullAsNil = str3.substring(0, str3.lastIndexOf(".html") + 5);
                }
            }
            try {
                nullAsNil = C18178q.encode(C5046bo.nullAsNil(nullAsNil), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                C4990ab.m7412e("MicroMsg.AppBrandReporterManager", "encode actionNote error!");
                C4990ab.printErrStackTrace("MicroMsg.AppBrandReporterManager", e2, "", new Object[0]);
            }
        }
        String nullAsNil2 = C5046bo.nullAsNil(wK.cst);
        String str6 = null;
        try {
            str6 = C5046bo.nullAsNil(C10048a.m17635wI(str).atI().mo32993xz());
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.AppBrandReporterManager", "innerMenuClickReport, get runtime by %s, e = %s", str, e3);
        }
        if (wK.scene == 0) {
            wK.scene = 1000;
        }
        int i6 = wK.cOq;
        String str7 = wK.cOr;
        int Dw = C19690c.m30493Dw(str);
        C4990ab.m7411d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, sessionId : %s, appid : %s, appversion : %d, appState : %d, usedState : %d, pagePath : %s, action : %d, actionNote : %s,actionTime : %s, actionResult : %d, actionErrorcode : %d, preScene : %d, preSceneNote : %s, appType : %d", Integer.valueOf(13539), Integer.valueOf(wK.scene), nullAsNil2, str6, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(wK.iAo), str4, Integer.valueOf(i), nullAsNil, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str7, Integer.valueOf(Dw));
        C7060h.pYm.mo8381e(13539, Integer.valueOf(wK.scene), nullAsNil2, str6, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(wK.iAo), str5, Integer.valueOf(i), nullAsNil, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str7, Integer.valueOf(Dw));
        AppMethodBeat.m2505o(132549);
    }

    /* renamed from: a */
    public static void m30499a(String str, String str2, int i, int i2, String str3, String str4, int i3, String str5, long j, int i4, int i5) {
        AppMethodBeat.m2504i(132550);
        int i6 = 3;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(132550);
            return;
        }
        String str6 = "";
        if (!C5046bo.isNullOrNil(str4)) {
            if (str4.contains(".html")) {
                String str7 = str4;
                str6 = str7.substring(0, str4.lastIndexOf(".html") + 5);
            }
        }
        String str8 = "";
        try {
            str8 = C18178q.encode(C5046bo.nullAsNil(str6), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7412e("MicroMsg.AppBrandReporterManager", "encode page path error!");
            C4990ab.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
        }
        String nullAsNil = C5046bo.nullAsNil(str3);
        String nullAsNil2 = C5046bo.nullAsNil(str5);
        String nullAsNil3 = C5046bo.nullAsNil(str2);
        int Dw = C19690c.m30493Dw(str2);
        if (i > 0) {
            i6 = i - 1;
            boolean aI = C42340f.auT().mo73331aI(str, i6);
            if (C42340f.auU().mo44551aF(str, i6)) {
                i6 = 1;
            } else if (aI) {
                i6 = 2;
            } else {
                i6 = 3;
            }
        }
        C4990ab.m7411d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d, appType %d", Integer.valueOf(13540), Integer.valueOf(i2), nullAsNil, nullAsNil3, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str6, Integer.valueOf(i3), nullAsNil2, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(Dw));
        C7060h.pYm.mo8381e(13540, Integer.valueOf(i2), nullAsNil, nullAsNil3, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str8, Integer.valueOf(i3), nullAsNil2, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(Dw));
        AppMethodBeat.m2505o(132550);
    }

    /* renamed from: br */
    public static void m30502br(String str, int i) {
        AppMethodBeat.m2504i(132551);
        C19690c.m30494K(str, i, 0);
        AppMethodBeat.m2505o(132551);
    }

    /* renamed from: K */
    public static void m30494K(String str, int i, int i2) {
        AppMethodBeat.m2504i(132552);
        if ("@LibraryAppId".equals(str)) {
            AppMethodBeat.m2505o(132552);
            return;
        }
        int i3;
        int i4;
        int i5 = 1000;
        CharSequence charSequence = "";
        int i6 = 0;
        if (C5046bo.isNullOrNil(str)) {
            i3 = 1000;
            i4 = 0;
        } else {
            int i7;
            AppBrandStatObject wK = C10048a.m17637wK(str);
            if (wK != null) {
                int i8 = wK.scene == 0 ? 1000 : wK.scene;
                charSequence = C5046bo.nullAsNil(wK.cst);
                i7 = wK.iAo;
                i5 = i8;
            } else {
                i7 = 0;
            }
            AppBrandSysConfigWC wJ = C10048a.m17636wJ(str);
            if (!(wJ == null || wJ.hhd == null)) {
                i6 = wJ.hhd.gVu;
            }
            if (!(i2 != 0 || wJ == null || wJ.hhd == null)) {
                i2 = wJ.hhd.gVt + 1;
            }
            i3 = C19690c.m30493Dw(str);
            i4 = i7;
        }
        C4990ab.m7411d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s, appType %s", Integer.valueOf(13541), Integer.valueOf(i5), charSequence, str, Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(i3));
        C7060h.pYm.mo8381e(13541, Integer.valueOf(i5), charSequence, str, Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(3), "", Integer.valueOf(i3));
        if (!TextUtils.isEmpty(charSequence) && charSequence.contains("isWidget=1")) {
            C10211f.m17850n(i, str, charSequence);
        }
        AppMethodBeat.m2505o(132552);
    }

    /* renamed from: pG */
    public static void m30505pG(int i) {
        AppMethodBeat.m2504i(132553);
        List a = ((C10118af) C1720g.m3528K(C10118af.class)).mo21470a(BaseClientBuilder.API_PRIORITY_OTHER, C10117a.DESC);
        StringBuilder stringBuilder = new StringBuilder();
        a = C37400c.m63004C(a);
        List subList = a.subList(0, Math.min(20, a.size()));
        for (int i2 = 0; i2 < subList.size(); i2++) {
            stringBuilder.append(((LocalUsageInfo) subList.get(i2)).appId);
            if (i2 != subList.size() - 1) {
                stringBuilder.append("#");
            }
        }
        C4990ab.m7416i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] scene=".concat(String.valueOf(i)));
        C4990ab.m7416i("MicroMsg.AppBrandReporterManager", "[reportEnterMyWxaList] appIdStr=".concat(String.valueOf(stringBuilder)));
        C7060h.pYm.mo8381e(13800, Integer.valueOf(i), Integer.valueOf(((C10118af) C1720g.m3528K(C10118af.class)).getCount()), stringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(132553);
    }

    /* renamed from: a */
    public static void m30496a(long j, boolean z, boolean z2) {
        int i;
        AppMethodBeat.m2504i(132554);
        if (z2) {
            i = 775;
        } else {
            i = 367;
        }
        int i2 = j <= FaceGestureDetGLThread.BRIGHTNESS_DURATION ? z ? 8 : 1 : j <= 3000 ? z ? 9 : 2 : j <= 4000 ? z ? 10 : 3 : j <= 5000 ? z ? 11 : 4 : j <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME ? z ? 12 : 5 : z2 ? j <= 7000 ? z ? 19 : 14 : j <= 8000 ? z ? 20 : 15 : j <= 9000 ? z ? 21 : 16 : j <= 10000 ? z ? 22 : 17 : z ? 23 : 18 : z ? 13 : 6;
        C7060h.pYm.mo8378a((long) i, (long) i2, 1, false);
        if (z) {
            C7060h.pYm.mo8378a((long) i, 7, 1, false);
        } else {
            C7060h.pYm.mo8378a((long) i, 0, 1, false);
        }
        C4990ab.m7419v("MicroMsg.AppBrandReporterManager", "startApp cost %s msec(hasDownload : %b).", Long.valueOf(j), Boolean.valueOf(z));
        AppMethodBeat.m2505o(132554);
    }

    public static void aLb() {
        int i;
        AppMethodBeat.m2504i(132555);
        int gX = C5046bo.m7564gX(((C6624h) C1720g.m3533RM().mo5224Rn()).f1233cc);
        C4990ab.m7417i("MicroMsg.AppBrandReporterManager", "report now process mem : %d", Integer.valueOf(C5046bo.m7564gX(((C6624h) C1720g.m3533RM().mo5224Rn()).f1233cc)));
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
        C7060h.pYm.mo8378a(386, 1, 1, false);
        C7060h.pYm.mo8378a(386, (long) i, 1, false);
        AppMethodBeat.m2505o(132555);
    }

    /* renamed from: pH */
    public static void m30506pH(int i) {
        AppMethodBeat.m2504i(132556);
        if (i == 10) {
            C7060h.pYm.mo8378a(386, 8, 1, false);
            AppMethodBeat.m2505o(132556);
            return;
        }
        if (i == 15) {
            C7060h.pYm.mo8378a(386, 7, 1, false);
        }
        AppMethodBeat.m2505o(132556);
    }

    /* renamed from: eA */
    public static void m30504eA(boolean z) {
        AppMethodBeat.m2504i(132557);
        C7060h.pYm.mo8375a(482, 482, 1, z ? 2 : 3, 1, 1, false);
        AppMethodBeat.m2505o(132557);
    }

    /* renamed from: a */
    public static void m30497a(String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(132558);
        C7060h.pYm.mo8381e(14369, str, Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(1));
        AppMethodBeat.m2505o(132558);
    }

    /* renamed from: pI */
    public static void m30507pI(int i) {
        AppMethodBeat.m2504i(132559);
        C7060h.pYm.mo15419k(807, (long) i, 1);
        AppMethodBeat.m2505o(132559);
    }

    /* renamed from: aa */
    public static void m30501aa(int i, String str) {
        AppMethodBeat.m2504i(132560);
        C7060h.pYm.mo8381e(15651, Integer.valueOf(i), C5046bo.nullAsNil(str));
        AppMethodBeat.m2505o(132560);
    }

    /* renamed from: pJ */
    public static void m30508pJ(int i) {
        AppMethodBeat.m2504i(132561);
        C7060h.pYm.mo15419k(891, (long) i, 1);
        AppMethodBeat.m2505o(132561);
    }

    /* renamed from: Dw */
    public static int m30493Dw(String str) {
        AppMethodBeat.m2504i(132562);
        if ("@LibraryAppId".equals(str)) {
            AppMethodBeat.m2505o(132562);
            return 0;
        }
        int Dy = C19691d.m30510Dy(str);
        if (Dy < 0) {
            if (C4996ah.bqo()) {
                WxaAttributes e = C42340f.auO().mo21573e(str, "appInfo");
                if (e != null) {
                    Dy = e.ayJ().fmr;
                    C19691d.m30511bs(str, Dy);
                } else {
                    C4990ab.m7416i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = attrs!");
                }
            } else {
                C41243o wI = C10048a.m17635wI(str);
                AppBrandInitConfigWC atI = wI == null ? null : wI.atI();
                if (atI != null) {
                    Dy = atI.bQe;
                    C19691d.m30511bs(str, Dy);
                } else {
                    C4990ab.m7417i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = initConfig! appServiceType:%s", Integer.valueOf(Dy));
                }
            }
        }
        Dy += 1000;
        AppMethodBeat.m2505o(132562);
        return Dy;
    }
}
