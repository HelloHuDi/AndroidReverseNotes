package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.a.e;
import com.tencent.luggage.g.c;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ai;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.protocal.protobuf.ey;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

public final class p extends k {
    private static volatile p hhE;

    public static p ayH() {
        AppMethodBeat.i(129883);
        if (hhE == null) {
            synchronized (p.class) {
                try {
                    if (hhE == null) {
                        hhE = new p();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(129883);
                    }
                }
            }
        }
        p pVar = hhE;
        AppMethodBeat.o(129883);
        return pVar;
    }

    public static void release() {
        synchronized (p.class) {
            hhE = null;
        }
    }

    private p() {
    }

    public final void b(String str, int i, Object obj) {
        AppMethodBeat.i(129884);
        f.auO().b(str, i, obj);
        AppMethodBeat.o(129884);
    }

    public final void c(a aVar) {
        AppMethodBeat.i(129885);
        a(aVar, m.aNS().oAl.getLooper());
        AppMethodBeat.o(129885);
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(129886);
        if (aVar == null) {
            AppMethodBeat.o(129886);
            return;
        }
        f.auO().a(aVar, looper);
        AppMethodBeat.o(129886);
    }

    public final void d(a aVar) {
        AppMethodBeat.i(129887);
        if (aVar == null) {
            AppMethodBeat.o(129887);
            return;
        }
        f.auO().d(aVar);
        AppMethodBeat.o(129887);
    }

    public static boolean k(String str, int i, boolean z) {
        AppMethodBeat.i(129888);
        boolean k = f.auO().k(str, i, z);
        AppMethodBeat.o(129888);
        return k;
    }

    public static u zh(String str) {
        AppMethodBeat.i(129889);
        if (bo.isNullOrNil(str) || !g.RK()) {
            AppMethodBeat.o(129889);
            return null;
        }
        WxaAttributes d = f.auO().d(str, "appId", "nickname", "signature", "brandIconURL", "dynamicInfo", "versionInfo", "appInfo", "registerSource", "bindWxaInfo");
        if (d != null) {
            u uVar = new u();
            uVar.username = str;
            uVar.appId = d.field_appId;
            uVar.nickname = d.field_nickname;
            uVar.signature = d.field_signature;
            uVar.hix = d.field_brandIconURL;
            uVar.hic = d.ayK().hic;
            uVar.bQl = d.ayL() == null ? -1 : d.ayL().bQl;
            uVar.hhP = d.ayM();
            try {
                uVar.bQe = d.ayJ().fmr;
                uVar.hgD = d.ayJ().hgD;
                uVar.hgE = d.ayJ().hgE;
            } catch (NullPointerException e) {
                ab.e("MicroMsg.WxaAttrStorageHelper", "assembleProfileAttrs, NULL appInfo, username = %s", str);
            }
            try {
                uVar.fwb = bo.isNullOrNil(d.field_registerSource) ? "" : new JSONObject(d.field_registerSource).optString("RegisterBody", "");
            } catch (Exception e2) {
            }
            AppMethodBeat.o(129889);
            return uVar;
        }
        AppMethodBeat.o(129889);
        return null;
    }

    public static AppBrandRecentTaskInfo a(String str, String str2, int i, long j) {
        int i2;
        long j2;
        String str3;
        String str4;
        String str5;
        String str6;
        AppMethodBeat.i(129890);
        WxaAttributes d = f.auO().d(str2, "appId", "nickname", "shortNickname", "smallHeadURL", "appInfo", "versionInfo");
        int i3 = 0;
        if (d == null) {
            i2 = 0;
        } else {
            try {
                i2 = d.ayJ().fmr;
            } catch (NullPointerException e) {
                ab.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo, NULL appInfo, username = %s", str2);
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
        if (j.a.np(i)) {
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
        AppBrandRecentTaskInfo appBrandRecentTaskInfo = new AppBrandRecentTaskInfo(valueOf, str2, str3, str4, str5, str6, i3, i, i4, j3, j4, ((s) f.E(s.class)).aF(str2, i), j);
        AppMethodBeat.o(129890);
        return appBrandRecentTaskInfo;
    }

    public static com.tencent.mm.plugin.appbrand.backgroundfetch.a zi(String str) {
        AppMethodBeat.i(129891);
        if (f.auO() != null) {
            WxaAttributes d = f.auO().d(str, new String[0]);
            if (d != null) {
                com.tencent.mm.plugin.appbrand.backgroundfetch.a aVar = new com.tencent.mm.plugin.appbrand.backgroundfetch.a();
                aVar.hbV = d.ayK().hib.hbV;
                aVar.hbW = d.ayK().hib.hbW;
                aVar.hbX = d.ayK().hib.hbX;
                AppMethodBeat.o(129891);
                return aVar;
            }
        }
        AppMethodBeat.o(129891);
        return null;
    }

    public static AppBrandSysConfigWC zj(String str) {
        AppMethodBeat.i(129892);
        WxaAttributes e = f.auO().e(str, new String[0]);
        if (e != null) {
            AppBrandSysConfigWC c = c(e);
            AppMethodBeat.o(129892);
            return c;
        }
        AppMethodBeat.o(129892);
        return null;
    }

    private static AppBrandSysConfigWC c(WxaAttributes wxaAttributes) {
        AppBrandSysConfigWC appBrandSysConfigWC;
        AppMethodBeat.i(129893);
        if (wxaAttributes != null) {
            try {
                AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) new ai.a<AppBrandSysConfigWC>() {
                    public final /* synthetic */ Object newInstance() {
                        AppMethodBeat.i(129882);
                        AppBrandSysConfigWC appBrandSysConfigWC = new AppBrandSysConfigWC();
                        AppMethodBeat.o(129882);
                        return appBrandSysConfigWC;
                    }
                }.newInstance();
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
                appBrandSysConfigLU.bQF = (ArrayList) c.c(new ArrayList(), wxaAttributes.ayJ().hhT);
                appBrandSysConfigLU.bQG = (ArrayList) c.c(new ArrayList(), wxaAttributes.ayJ().hhU);
                appBrandSysConfigLU.bQI = (ArrayList) c.c(new ArrayList(), wxaAttributes.ayJ().hhW);
                appBrandSysConfigLU.bQH = (ArrayList) c.c(new ArrayList(), wxaAttributes.ayJ().hhV);
                appBrandSysConfigLU.bQJ = (ArrayList) c.c(new ArrayList(), wxaAttributes.ayJ().hhX);
                appBrandSysConfigLU.bQR = new ey();
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
                ab.e("MicroMsg.WxaAttrStorageHelper", "assembleSysConfig, <init> e = %s", e);
                AppMethodBeat.o(129893);
                return null;
            }
        }
        appBrandSysConfigWC = null;
        if (appBrandSysConfigWC != null) {
            boolean z;
            appBrandSysConfigWC.bQL = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("ClientBenchmarkLevel", -1);
            String str = appBrandSysConfigWC.appId;
            c xH = ((b) e.B(b.class)).xH();
            if (bo.isNullOrNil(str) || xH == null) {
                z = false;
            } else {
                z = Boolean.parseBoolean(xH.get(str + "_AppDebugEnabled", "false"));
            }
            appBrandSysConfigWC.bQp = z;
            appBrandSysConfigWC.bQq = "1".equals(f.xH().get(appBrandSysConfigWC.appId + "_PerformancePanelEnabled", AppEventsConstants.EVENT_PARAM_VALUE_NO));
        }
        AppMethodBeat.o(129893);
        return appBrandSysConfigWC;
    }

    public static long zk(String str) {
        AppMethodBeat.i(129894);
        WxaAttributes d = f.auO().d(str, "appInfo");
        if (d == null || d.ayJ() == null) {
            AppMethodBeat.o(129894);
            return 0;
        }
        long j = d.ayJ().haQ;
        AppMethodBeat.o(129894);
        return j;
    }

    public static String[] zl(String str) {
        AppMethodBeat.i(129895);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129895);
            return null;
        }
        if (f.auO().d(str, "roundedSquareIconURL", "bigHeadURL") == null) {
            AppMethodBeat.o(129895);
            return null;
        }
        String[] strArr = new String[]{f.auO().d(str, "roundedSquareIconURL", "bigHeadURL").field_roundedSquareIconURL, f.auO().d(str, "roundedSquareIconURL", "bigHeadURL").field_bigHeadURL};
        AppMethodBeat.o(129895);
        return strArr;
    }

    public static String zm(String str) {
        AppMethodBeat.i(129896);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129896);
            return null;
        }
        WxaAttributes d = f.auO().d(str, "appId");
        if (d == null) {
            AppMethodBeat.o(129896);
            return null;
        }
        String str2 = d.field_appId;
        AppMethodBeat.o(129896);
        return str2;
    }

    public static String zn(String str) {
        AppMethodBeat.i(129897);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129897);
            return null;
        }
        WxaAttributes e = f.auO().e(str, "nickname");
        if (e == null) {
            AppMethodBeat.o(129897);
            return null;
        }
        String str2 = e.field_nickname;
        AppMethodBeat.o(129897);
        return str2;
    }

    public static String zo(String str) {
        AppMethodBeat.i(129898);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129898);
            return null;
        }
        WxaAttributes e = f.auO().e(str, "username");
        if (e == null) {
            AppMethodBeat.o(129898);
            return null;
        }
        String str2 = e.field_username;
        AppMethodBeat.o(129898);
        return str2;
    }

    public static void zp(String str) {
        AppMethodBeat.i(129899);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129899);
            return;
        }
        q auO = f.auO();
        if (!bo.isNullOrNil(str)) {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("syncVersion", "");
            contentValues.put("syncTimeSecond", Long.valueOf(0));
            auO.bSd.update("WxaAttributesTable", contentValues, String.format(Locale.US, "%s=?", new Object[]{"username"}), new String[]{str});
        }
        AppMethodBeat.o(129899);
    }

    public static void zq(String str) {
        AppMethodBeat.i(129900);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129900);
            return;
        }
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        f.auO().a((com.tencent.mm.sdk.e.c) wxaAttributes, "username");
        AppMethodBeat.o(129900);
    }
}
