package com.tencent.p177mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p147g.C37400c;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.C18996ai.C2045a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.p177mm.plugin.appbrand.appusage.C26779s;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C42384a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.C46539ey;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.config.p */
public final class C26842p extends C7296k {
    private static volatile C26842p hhE;

    /* renamed from: com.tencent.mm.plugin.appbrand.config.p$1 */
    static class C268431 implements C2045a<AppBrandSysConfigWC> {
        C268431() {
        }

        public final /* synthetic */ Object newInstance() {
            AppMethodBeat.m2504i(129882);
            AppBrandSysConfigWC appBrandSysConfigWC = new AppBrandSysConfigWC();
            AppMethodBeat.m2505o(129882);
            return appBrandSysConfigWC;
        }
    }

    public static C26842p ayH() {
        AppMethodBeat.m2504i(129883);
        if (hhE == null) {
            synchronized (C26842p.class) {
                try {
                    if (hhE == null) {
                        hhE = new C26842p();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(129883);
                    }
                }
            }
        }
        C26842p c26842p = hhE;
        AppMethodBeat.m2505o(129883);
        return c26842p;
    }

    public static void release() {
        synchronized (C26842p.class) {
            hhE = null;
        }
    }

    private C26842p() {
    }

    /* renamed from: b */
    public final void mo15641b(String str, int i, Object obj) {
        AppMethodBeat.m2504i(129884);
        C42340f.auO().mo15641b(str, i, obj);
        AppMethodBeat.m2505o(129884);
    }

    /* renamed from: c */
    public final void mo10116c(C4931a c4931a) {
        AppMethodBeat.m2504i(129885);
        mo10114a(c4931a, C45673m.aNS().oAl.getLooper());
        AppMethodBeat.m2505o(129885);
    }

    /* renamed from: a */
    public final void mo10114a(C4931a c4931a, Looper looper) {
        AppMethodBeat.m2504i(129886);
        if (c4931a == null) {
            AppMethodBeat.m2505o(129886);
            return;
        }
        C42340f.auO().mo10114a(c4931a, looper);
        AppMethodBeat.m2505o(129886);
    }

    /* renamed from: d */
    public final void mo10117d(C4931a c4931a) {
        AppMethodBeat.m2504i(129887);
        if (c4931a == null) {
            AppMethodBeat.m2505o(129887);
            return;
        }
        C42340f.auO().mo10117d(c4931a);
        AppMethodBeat.m2505o(129887);
    }

    /* renamed from: k */
    public static boolean m42734k(String str, int i, boolean z) {
        AppMethodBeat.m2504i(129888);
        boolean k = C42340f.auO().mo21574k(str, i, z);
        AppMethodBeat.m2505o(129888);
        return k;
    }

    /* renamed from: zh */
    public static C45536u m42735zh(String str) {
        AppMethodBeat.m2504i(129889);
        if (C5046bo.isNullOrNil(str) || !C1720g.m3531RK()) {
            AppMethodBeat.m2505o(129889);
            return null;
        }
        WxaAttributes d = C42340f.auO().mo21572d(str, "appId", "nickname", "signature", "brandIconURL", "dynamicInfo", "versionInfo", "appInfo", "registerSource", "bindWxaInfo");
        if (d != null) {
            C45536u c45536u = new C45536u();
            c45536u.username = str;
            c45536u.appId = d.field_appId;
            c45536u.nickname = d.field_nickname;
            c45536u.signature = d.field_signature;
            c45536u.hix = d.field_brandIconURL;
            c45536u.hic = d.ayK().hic;
            c45536u.bQl = d.ayL() == null ? -1 : d.ayL().bQl;
            c45536u.hhP = d.ayM();
            try {
                c45536u.bQe = d.ayJ().fmr;
                c45536u.hgD = d.ayJ().hgD;
                c45536u.hgE = d.ayJ().hgE;
            } catch (NullPointerException e) {
                C4990ab.m7413e("MicroMsg.WxaAttrStorageHelper", "assembleProfileAttrs, NULL appInfo, username = %s", str);
            }
            try {
                c45536u.fwb = C5046bo.isNullOrNil(d.field_registerSource) ? "" : new JSONObject(d.field_registerSource).optString("RegisterBody", "");
            } catch (Exception e2) {
            }
            AppMethodBeat.m2505o(129889);
            return c45536u;
        }
        AppMethodBeat.m2505o(129889);
        return null;
    }

    /* renamed from: a */
    public static AppBrandRecentTaskInfo m42732a(String str, String str2, int i, long j) {
        int i2;
        long j2;
        String str3;
        String str4;
        String str5;
        String str6;
        AppMethodBeat.m2504i(129890);
        WxaAttributes d = C42340f.auO().mo21572d(str2, "appId", "nickname", "shortNickname", "smallHeadURL", "appInfo", "versionInfo");
        int i3 = 0;
        if (d == null) {
            i2 = 0;
        } else {
            try {
                i2 = d.ayJ().fmr;
            } catch (NullPointerException e) {
                C4990ab.m7413e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo, NULL appInfo, username = %s", str2);
            }
        }
        i3 = i2;
        int i4 = 0;
        if (d == null) {
            i2 = 0;
        } else {
            try {
                i2 = d.ayL().axy;
            } catch (NullPointerException e2) {
            }
        }
        i4 = i2;
        long j3 = 0;
        if (d == null) {
            j2 = 0;
        } else {
            try {
                j2 = d.ayJ().haQ;
            } catch (NullPointerException e3) {
            }
        }
        j3 = j2;
        long j4 = 0;
        if (C33097a.m54090np(i)) {
            if (d == null) {
                j2 = 0;
            } else {
                try {
                    j2 = d.ayJ().haR;
                } catch (NullPointerException e4) {
                }
            }
            j4 = j2;
        }
        String valueOf = String.valueOf(str);
        if (d == null) {
            str3 = "";
        } else {
            str3 = d.field_appId;
        }
        if (d == null) {
            str4 = "";
        } else {
            str4 = d.field_nickname;
        }
        if (d == null) {
            str5 = "";
        } else {
            str5 = d.field_shortNickname;
        }
        if (d == null) {
            str6 = "";
        } else {
            str6 = d.field_smallHeadURL;
        }
        AppBrandRecentTaskInfo appBrandRecentTaskInfo = new AppBrandRecentTaskInfo(valueOf, str2, str3, str4, str5, str6, i3, i, i4, j3, j4, ((C26779s) C42340f.m74878E(C26779s.class)).mo44551aF(str2, i), j);
        AppMethodBeat.m2505o(129890);
        return appBrandRecentTaskInfo;
    }

    /* renamed from: zi */
    public static C42384a m42736zi(String str) {
        AppMethodBeat.m2504i(129891);
        if (C42340f.auO() != null) {
            WxaAttributes d = C42340f.auO().mo21572d(str, new String[0]);
            if (d != null) {
                C42384a c42384a = new C42384a();
                c42384a.hbV = d.ayK().hib.hbV;
                c42384a.hbW = d.ayK().hib.hbW;
                c42384a.hbX = d.ayK().hib.hbX;
                AppMethodBeat.m2505o(129891);
                return c42384a;
            }
        }
        AppMethodBeat.m2505o(129891);
        return null;
    }

    /* renamed from: zj */
    public static AppBrandSysConfigWC m42737zj(String str) {
        AppMethodBeat.m2504i(129892);
        WxaAttributes e = C42340f.auO().mo21573e(str, new String[0]);
        if (e != null) {
            AppBrandSysConfigWC c = C26842p.m42733c(e);
            AppMethodBeat.m2505o(129892);
            return c;
        }
        AppMethodBeat.m2505o(129892);
        return null;
    }

    /* renamed from: c */
    private static AppBrandSysConfigWC m42733c(WxaAttributes wxaAttributes) {
        AppBrandSysConfigWC appBrandSysConfigWC;
        AppMethodBeat.m2504i(129893);
        if (wxaAttributes != null) {
            try {
                AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) new C268431().newInstance();
                appBrandSysConfigLU.cwz = wxaAttributes.field_nickname;
                appBrandSysConfigLU.hgW = wxaAttributes.field_smallHeadURL;
                appBrandSysConfigLU.appId = wxaAttributes.field_appId;
                appBrandSysConfigLU.hgX = wxaAttributes.ayK().hib.hgX;
                appBrandSysConfigLU.bQv = wxaAttributes.ayK().hib.bQv;
                appBrandSysConfigLU.bQy = wxaAttributes.ayK().hib.bQy;
                appBrandSysConfigLU.bQz = wxaAttributes.ayK().hib.bQz;
                appBrandSysConfigLU.bQA = wxaAttributes.ayK().hib.bQA;
                appBrandSysConfigLU.bQB = wxaAttributes.ayK().hib.bQB;
                appBrandSysConfigLU.bQC = wxaAttributes.ayK().hib.bQC;
                appBrandSysConfigLU.bQx = wxaAttributes.ayK().hib.bQx;
                appBrandSysConfigLU.bQw = wxaAttributes.ayK().hib.bQw;
                appBrandSysConfigLU.bQD = (long) wxaAttributes.ayK().hib.hif;
                appBrandSysConfigLU.bQE = wxaAttributes.ayK().hib.hig;
                appBrandSysConfigLU.bQF = (ArrayList) C37400c.m63005c(new ArrayList(), wxaAttributes.ayJ().hhT);
                appBrandSysConfigLU.bQG = (ArrayList) C37400c.m63005c(new ArrayList(), wxaAttributes.ayJ().hhU);
                appBrandSysConfigLU.bQI = (ArrayList) C37400c.m63005c(new ArrayList(), wxaAttributes.ayJ().hhW);
                appBrandSysConfigLU.bQH = (ArrayList) C37400c.m63005c(new ArrayList(), wxaAttributes.ayJ().hhV);
                appBrandSysConfigLU.bQJ = (ArrayList) C37400c.m63005c(new ArrayList(), wxaAttributes.ayJ().hhX);
                appBrandSysConfigLU.bQR = new C46539ey();
                appBrandSysConfigLU.bQR.vGQ = wxaAttributes.ayJ().haQ;
                appBrandSysConfigLU.bQR.vGX = wxaAttributes.ayJ().hhR;
                appBrandSysConfigLU.hhb = wxaAttributes.ayK().hib.hhb;
                appBrandSysConfigLU.hhc = wxaAttributes.ayK().hib.hhc;
                appBrandSysConfigLU.bQK = wxaAttributes.ayK().hib.bQK;
                appBrandSysConfigLU.bQQ = new String[]{wxaAttributes.field_roundedSquareIconURL, wxaAttributes.field_brandIconURL, wxaAttributes.field_bigHeadURL};
                appBrandSysConfigLU.nickname = wxaAttributes.field_nickname;
                appBrandSysConfigLU.bQM = wxaAttributes.ayK().hib.bQM;
                appBrandSysConfigWC = (AppBrandSysConfigWC) appBrandSysConfigLU;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WxaAttrStorageHelper", "assembleSysConfig, <init> e = %s", e);
                AppMethodBeat.m2505o(129893);
                return null;
            }
        }
        appBrandSysConfigWC = null;
        if (appBrandSysConfigWC != null) {
            boolean z;
            appBrandSysConfigWC.bQL = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("ClientBenchmarkLevel", -1);
            String str = appBrandSysConfigWC.appId;
            C33134c xH = ((C0997b) C37384e.m62985B(C0997b.class)).mo3976xH();
            if (C5046bo.isNullOrNil(str) || xH == null) {
                z = false;
            } else {
                z = Boolean.parseBoolean(xH.get(str + "_AppDebugEnabled", "false"));
            }
            appBrandSysConfigWC.bQp = z;
            appBrandSysConfigWC.bQq = "1".equals(C42340f.m74880xH().get(appBrandSysConfigWC.appId + "_PerformancePanelEnabled", AppEventsConstants.EVENT_PARAM_VALUE_NO));
        }
        AppMethodBeat.m2505o(129893);
        return appBrandSysConfigWC;
    }

    /* renamed from: zk */
    public static long m42738zk(String str) {
        AppMethodBeat.m2504i(129894);
        WxaAttributes d = C42340f.auO().mo21572d(str, "appInfo");
        if (d == null || d.ayJ() == null) {
            AppMethodBeat.m2505o(129894);
            return 0;
        }
        long j = d.ayJ().haQ;
        AppMethodBeat.m2505o(129894);
        return j;
    }

    /* renamed from: zl */
    public static String[] m42739zl(String str) {
        AppMethodBeat.m2504i(129895);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129895);
            return null;
        }
        if (C42340f.auO().mo21572d(str, "roundedSquareIconURL", "bigHeadURL") == null) {
            AppMethodBeat.m2505o(129895);
            return null;
        }
        String[] strArr = new String[]{C42340f.auO().mo21572d(str, "roundedSquareIconURL", "bigHeadURL").field_roundedSquareIconURL, C42340f.auO().mo21572d(str, "roundedSquareIconURL", "bigHeadURL").field_bigHeadURL};
        AppMethodBeat.m2505o(129895);
        return strArr;
    }

    /* renamed from: zm */
    public static String m42740zm(String str) {
        AppMethodBeat.m2504i(129896);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129896);
            return null;
        }
        WxaAttributes d = C42340f.auO().mo21572d(str, "appId");
        if (d == null) {
            AppMethodBeat.m2505o(129896);
            return null;
        }
        String str2 = d.field_appId;
        AppMethodBeat.m2505o(129896);
        return str2;
    }

    /* renamed from: zn */
    public static String m42741zn(String str) {
        AppMethodBeat.m2504i(129897);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129897);
            return null;
        }
        WxaAttributes e = C42340f.auO().mo21573e(str, "nickname");
        if (e == null) {
            AppMethodBeat.m2505o(129897);
            return null;
        }
        String str2 = e.field_nickname;
        AppMethodBeat.m2505o(129897);
        return str2;
    }

    /* renamed from: zo */
    public static String m42742zo(String str) {
        AppMethodBeat.m2504i(129898);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129898);
            return null;
        }
        WxaAttributes e = C42340f.auO().mo21573e(str, "username");
        if (e == null) {
            AppMethodBeat.m2505o(129898);
            return null;
        }
        String str2 = e.field_username;
        AppMethodBeat.m2505o(129898);
        return str2;
    }

    /* renamed from: zp */
    public static void m42743zp(String str) {
        AppMethodBeat.m2504i(129899);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129899);
            return;
        }
        C26844q auO = C42340f.auO();
        if (!C5046bo.isNullOrNil(str)) {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("syncVersion", "");
            contentValues.put("syncTimeSecond", Long.valueOf(0));
            auO.bSd.update("WxaAttributesTable", contentValues, String.format(Locale.US, "%s=?", new Object[]{"username"}), new String[]{str});
        }
        AppMethodBeat.m2505o(129899);
    }

    /* renamed from: zq */
    public static void m42744zq(String str) {
        AppMethodBeat.m2504i(129900);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129900);
            return;
        }
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        C42340f.auO().mo16760a((C4925c) wxaAttributes, "username");
        AppMethodBeat.m2505o(129900);
    }
}
