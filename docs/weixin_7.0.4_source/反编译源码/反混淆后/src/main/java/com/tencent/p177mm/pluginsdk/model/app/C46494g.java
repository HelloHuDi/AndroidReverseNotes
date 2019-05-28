package com.tencent.p177mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a.C3753a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C30033c.C23234a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.model.app.g */
public final class C46494g {
    /* renamed from: Uq */
    public static C40439f m87721Uq(String str) {
        AppMethodBeat.m2504i(139134);
        C40439f bT = C46494g.m87739bT(str, true);
        AppMethodBeat.m2505o(139134);
        return bT;
    }

    /* renamed from: dX */
    public static C40439f m87742dX(String str, int i) {
        C40439f c40439f = null;
        AppMethodBeat.m2504i(79261);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
            AppMethodBeat.m2505o(79261);
        } else if (C3753a.bYQ() == null) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.m2505o(79261);
        } else {
            c40439f = C3753a.bYQ().mo25133Uq(str);
            if (C46494g.m87730a(c40439f, i)) {
                C3753a.bYQ().mo25135Us(str);
            }
            AppMethodBeat.m2505o(79261);
        }
        return c40439f;
    }

    /* renamed from: bS */
    public static C40439f m87738bS(String str, boolean z) {
        AppMethodBeat.m2504i(79262);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
            AppMethodBeat.m2505o(79262);
            return null;
        }
        C13114a bYQ = C3753a.bYQ();
        C40439f Ur;
        if (bYQ == null) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.m2505o(79262);
            return null;
        } else if (z) {
            Ur = bYQ.mo25134Ur(str);
            AppMethodBeat.m2505o(79262);
            return Ur;
        } else {
            Ur = bYQ.mo25133Uq(str);
            if (Ur == null) {
                Ur = bYQ.mo25134Ur(str);
                AppMethodBeat.m2505o(79262);
                return Ur;
            }
            bYQ.mo25135Us(str);
            AppMethodBeat.m2505o(79262);
            return Ur;
        }
    }

    /* renamed from: bT */
    public static C40439f m87739bT(String str, boolean z) {
        C40439f c40439f = null;
        AppMethodBeat.m2504i(79263);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
            AppMethodBeat.m2505o(79263);
        } else if (C3753a.bYQ() == null) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.m2505o(79263);
        } else {
            c40439f = C3753a.bYQ().mo25133Uq(str);
            if (z && C46494g.m87747g(c40439f)) {
                C3753a.bYQ().mo25135Us(str);
            }
            AppMethodBeat.m2505o(79263);
        }
        return c40439f;
    }

    /* renamed from: g */
    private static boolean m87747g(C40439f c40439f) {
        AppMethodBeat.m2504i(79264);
        if (c40439f == null || c40439f.field_appName == null || c40439f.field_appName.length() == 0) {
            AppMethodBeat.m2505o(79264);
            return true;
        }
        AppMethodBeat.m2505o(79264);
        return false;
    }

    /* renamed from: a */
    private static boolean m87730a(C40439f c40439f, int i) {
        return c40439f == null || c40439f.field_appVersion < i;
    }

    /* renamed from: b */
    public static Bitmap m87732b(String str, int i, float f) {
        AppMethodBeat.m2504i(79265);
        Bitmap a;
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getAppIcon, appId is null");
            AppMethodBeat.m2505o(79265);
            return null;
        } else if (!C1720g.m3534RN().mo5161QY()) {
            AppMethodBeat.m2505o(79265);
            return null;
        } else if (C1720g.m3536RP().isSDCardAvailable()) {
            a = C3753a.bYQ().mo25136a(str, i, f);
            if (a == null) {
                C4990ab.m7420w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
                C3753a.bYQ().mo25142cN(str, i);
                AppMethodBeat.m2505o(79265);
                return null;
            } else if (a.isRecycled()) {
                AppMethodBeat.m2505o(79265);
                return null;
            } else {
                AppMethodBeat.m2505o(79265);
                return a;
            }
        } else if (C4996ah.getContext() == null) {
            AppMethodBeat.m2505o(79265);
            return null;
        } else if (C4996ah.getContext().getResources() == null) {
            AppMethodBeat.m2505o(79265);
            return null;
        } else {
            switch (i) {
                case 1:
                case 3:
                case 4:
                case 5:
                    a = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ao_);
                    if (a == null || a.isRecycled()) {
                        AppMethodBeat.m2505o(79265);
                        return null;
                    }
                    AppMethodBeat.m2505o(79265);
                    return a;
                case 2:
                    AppMethodBeat.m2505o(79265);
                    return null;
                default:
                    C4990ab.m7412e("MicroMsg.AppInfoLogic", "getAppIcon, unknown iconType = ".concat(String.valueOf(i)));
                    AppMethodBeat.m2505o(79265);
                    return null;
            }
        }
    }

    /* renamed from: b */
    public static List<C40439f> m87735b(Context context, long j, boolean z) {
        AppMethodBeat.m2504i(79266);
        ArrayList arrayList = new ArrayList();
        C35796i bYJ = C34832a.bYJ();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppInfo");
        stringBuilder.append(" where ");
        stringBuilder.append(" ( appSupportContentType & ").append(j).append(" ) != 0");
        stringBuilder.append(" and  ( svrAppSupportContentType & ").append(j).append(" ) != 0");
        stringBuilder.append(" and  ( appInfoFlag & 8192 ) != 0");
        stringBuilder.append(" and status != 4");
        if (!z) {
            stringBuilder.append(" and  ( appInfoFlag & 16384 ) == 0");
        }
        C4990ab.m7419v("MicroMsg.AppInfoStorage", "getAppInfoByContentFlag sql %s", stringBuilder.toString());
        Cursor rawQuery = bYJ.rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
            rawQuery = null;
        }
        if (rawQuery == null) {
            AppMethodBeat.m2505o(79266);
        } else {
            while (rawQuery.moveToNext()) {
                C40439f c40439f = new C40439f();
                c40439f.mo8995d(rawQuery);
                if (c40439f.field_status == 1) {
                    if (!C46494g.m87757u(context, c40439f.field_appId)) {
                        c40439f.field_status = 4;
                        C3753a.bYQ().mo25144e(c40439f);
                    } else if (!C5046bo.isNullOrNil(c40439f.field_signature)) {
                        arrayList.add(c40439f);
                    }
                } else if (c40439f.field_signature != null) {
                    arrayList.add(c40439f);
                }
            }
            rawQuery.close();
            AppMethodBeat.m2505o(79266);
        }
        return arrayList;
    }

    /* renamed from: o */
    public static boolean m87754o(Context context, long j) {
        AppMethodBeat.m2504i(79267);
        if (C46494g.m87735b(context, j, true).size() == 0) {
            AppMethodBeat.m2505o(79267);
            return false;
        }
        AppMethodBeat.m2505o(79267);
        return true;
    }

    /* renamed from: ad */
    public static boolean m87731ad(Context context, int i) {
        AppMethodBeat.m2504i(79268);
        Long aik = C23234a.aik(String.valueOf(i));
        if (aik == null) {
            AppMethodBeat.m2505o(79268);
            return false;
        } else if (C46494g.m87735b(context, aik.longValue(), true).size() == 0) {
            AppMethodBeat.m2505o(79268);
            return false;
        } else {
            AppMethodBeat.m2505o(79268);
            return true;
        }
    }

    /* renamed from: a */
    public static List<C40439f> m87722a(Context context, boolean z, int i) {
        AppMethodBeat.m2504i(79270);
        List<C40439f> arrayList = new ArrayList();
        if (C3753a.bYQ() == null) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.m2505o(79270);
        } else {
            arrayList = C46494g.m87748gJ(1, i);
            int[] iArr = null;
            if (z) {
                iArr = new int[]{5};
            }
            if (iArr == null) {
                AppMethodBeat.m2505o(79270);
            } else {
                Cursor x = C3753a.bYQ().mo25146x(iArr);
                if (x != null) {
                    while (x.moveToNext()) {
                        C40439f c40439f = new C40439f();
                        c40439f.mo8995d(x);
                        if (c40439f.field_status == 1) {
                            if (!C46494g.m87757u(context, c40439f.field_appId)) {
                                c40439f.field_status = 4;
                                C3753a.bYQ().mo25144e(c40439f);
                            } else if (!C5046bo.isNullOrNil(c40439f.field_signature)) {
                                arrayList.add(c40439f);
                            }
                        } else if (c40439f.field_signature != null) {
                            arrayList.add(c40439f);
                        }
                    }
                    x.close();
                }
                AppMethodBeat.m2505o(79270);
            }
        }
        return arrayList;
    }

    /* renamed from: gJ */
    public static List<C40439f> m87748gJ(int i, int i2) {
        AppMethodBeat.m2504i(79271);
        ArrayList arrayList = new ArrayList();
        if (C3753a.bYQ() == null) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
            AppMethodBeat.m2505o(79271);
        } else {
            Cursor eQ = C3753a.bYQ().mo25145eQ(i, i2);
            if (eQ == null) {
                AppMethodBeat.m2505o(79271);
            } else {
                while (eQ.moveToNext()) {
                    C40439f c40439f = new C40439f();
                    c40439f.mo8995d(eQ);
                    arrayList.add(c40439f);
                }
                eQ.close();
                AppMethodBeat.m2505o(79271);
            }
        }
        return arrayList;
    }

    /* renamed from: Kw */
    public static int m87720Kw(int i) {
        AppMethodBeat.m2504i(79272);
        ArrayList arrayList = new ArrayList();
        if (C3753a.bYQ() == null) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
            AppMethodBeat.m2505o(79272);
            return 0;
        }
        Cursor eQ = C3753a.bYQ().mo25145eQ(0, i);
        if (eQ == null) {
            AppMethodBeat.m2505o(79272);
            return 0;
        }
        int count = eQ.getCount();
        eQ.close();
        AppMethodBeat.m2505o(79272);
        return count;
    }

    public static List<C40439f> dhB() {
        AppMethodBeat.m2504i(79273);
        ArrayList arrayList = new ArrayList();
        if (C3753a.bYQ() == null) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
            AppMethodBeat.m2505o(79273);
        } else {
            Cursor bYP = C3753a.bYQ().bYP();
            if (bYP == null) {
                AppMethodBeat.m2505o(79273);
            } else {
                while (bYP.moveToNext()) {
                    C40439f c40439f = new C40439f();
                    c40439f.mo8995d(bYP);
                    if (!C5046bo.isNullOrNil(c40439f.field_openId)) {
                        arrayList.add(c40439f);
                    }
                }
                bYP.close();
                AppMethodBeat.m2505o(79273);
            }
        }
        return arrayList;
    }

    /* renamed from: u */
    public static boolean m87757u(Context context, String str) {
        AppMethodBeat.m2504i(79274);
        if (context == null || str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
            AppMethodBeat.m2505o(79274);
            return false;
        }
        boolean a = C46494g.m87726a(context, C46494g.m87739bT(str, true));
        AppMethodBeat.m2505o(79274);
        return a;
    }

    /* renamed from: a */
    public static boolean m87726a(Context context, C40439f c40439f) {
        AppMethodBeat.m2504i(79275);
        if (c40439f == null) {
            C4990ab.m7420w("MicroMsg.AppInfoLogic", "app is null");
            AppMethodBeat.m2505o(79275);
            return false;
        } else if (c40439f.field_packageName == null || c40439f.field_packageName.length() == 0) {
            C4990ab.m7420w("MicroMsg.AppInfoLogic", "field_packageName is null");
            AppMethodBeat.m2505o(79275);
            return false;
        } else {
            boolean u = C35799p.m58695u(context, c40439f.field_packageName);
            AppMethodBeat.m2505o(79275);
            return u;
        }
    }

    /* renamed from: dg */
    public static boolean m87743dg(String str) {
        AppMethodBeat.m2504i(79276);
        if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
            AppMethodBeat.m2505o(79276);
            return false;
        }
        AppMethodBeat.m2505o(79276);
        return true;
    }

    /* renamed from: r */
    public static String m87755r(Context context, String str, int i) {
        AppMethodBeat.m2504i(79277);
        String b = C46494g.m87733b(context, C46494g.m87742dX(str, i), null);
        AppMethodBeat.m2505o(79277);
        return b;
    }

    /* renamed from: b */
    public static String m87733b(Context context, C40439f c40439f, String str) {
        AppMethodBeat.m2504i(79279);
        if (context == null || c40439f == null) {
            AppMethodBeat.m2505o(79279);
            return str;
        }
        String fK = C46494g.m87746fK(context);
        String str2 = null;
        if (fK.equalsIgnoreCase("zh_CN")) {
            str2 = c40439f.field_appName;
        }
        if (fK.equalsIgnoreCase("en")) {
            str2 = C5046bo.isNullOrNil(c40439f.field_appName_en) ? c40439f.field_appName : c40439f.field_appName_en;
        }
        if (fK.equalsIgnoreCase("zh_TW") || fK.equalsIgnoreCase("zh_HK")) {
            if (fK.equalsIgnoreCase("zh_HK")) {
                str2 = C5046bo.isNullOrNil(c40439f.field_appName_hk) ? c40439f.field_appName_tw : c40439f.field_appName_hk;
            }
            if (C5046bo.isNullOrNil(str2)) {
                str2 = C5046bo.isNullOrNil(c40439f.field_appName_tw) ? c40439f.field_appName : c40439f.field_appName_tw;
            }
        }
        if (C5046bo.isNullOrNil(str2)) {
            str2 = C5046bo.isNullOrNil(c40439f.field_appName_en) ? c40439f.field_appName : c40439f.field_appName_en;
        }
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(79279);
            return str;
        }
        AppMethodBeat.m2505o(79279);
        return str2;
    }

    /* renamed from: c */
    public static String m87741c(Context context, C40439f c40439f, String str) {
        AppMethodBeat.m2504i(79280);
        if (context == null || c40439f == null) {
            AppMethodBeat.m2505o(79280);
            return str;
        }
        String fK = C46494g.m87746fK(context);
        String str2 = null;
        if (fK.equalsIgnoreCase("zh_CN")) {
            str2 = c40439f.field_appName;
        }
        if (fK.equalsIgnoreCase("en")) {
            str2 = C5046bo.isNullOrNil(c40439f.field_appName_en) ? c40439f.field_appName : c40439f.field_appName_en;
        }
        if (fK.equalsIgnoreCase("zh_TW") || fK.equalsIgnoreCase("zh_HK")) {
            if (fK.equalsIgnoreCase("zh_HK")) {
                str2 = C5046bo.isNullOrNil(c40439f.field_appName_hk) ? c40439f.field_appName_tw : c40439f.field_appName_hk;
            }
            if (C5046bo.isNullOrNil(str2)) {
                str2 = C5046bo.isNullOrNil(c40439f.field_appName_tw) ? c40439f.field_appName : c40439f.field_appName_tw;
            }
        }
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(79280);
            return str;
        }
        AppMethodBeat.m2505o(79280);
        return str2;
    }

    /* renamed from: fK */
    public static String m87746fK(Context context) {
        AppMethodBeat.m2504i(79281);
        String g = C4988aa.m7402g(context.getSharedPreferences(C4996ah.doA(), 0));
        if (g == null || g.length() == 0 || g.equalsIgnoreCase("zh_CN")) {
            g = "zh_CN";
            AppMethodBeat.m2505o(79281);
            return g;
        }
        AppMethodBeat.m2505o(79281);
        return g;
    }

    /* renamed from: dk */
    public static boolean m87744dk(String str) {
        AppMethodBeat.m2504i(79282);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(79282);
            return false;
        }
        C40439f bT = C46494g.m87739bT(str, false);
        if (bT == null) {
            C4990ab.m7420w("MicroMsg.AppInfoLogic", "app is null, appId = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(79282);
            return false;
        }
        boolean xy = bT.mo63847xy();
        AppMethodBeat.m2505o(79282);
        return xy;
    }

    /* renamed from: h */
    public static boolean m87749h(C40439f c40439f) {
        AppMethodBeat.m2504i(79283);
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
            AppMethodBeat.m2505o(79283);
            return false;
        } else if ((c40439f.field_appInfoFlag & 1) > 0) {
            AppMethodBeat.m2505o(79283);
            return true;
        } else {
            AppMethodBeat.m2505o(79283);
            return false;
        }
    }

    /* renamed from: i */
    public static boolean m87750i(C40439f c40439f) {
        if (c40439f == null || (c40439f.field_appInfoFlag & 2) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    private static boolean m87751j(C40439f c40439f) {
        AppMethodBeat.m2504i(79284);
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
            AppMethodBeat.m2505o(79284);
            return false;
        } else if (c40439f.field_appId.equals("wx7fa037cc7dfabad5")) {
            AppMethodBeat.m2505o(79284);
            return true;
        } else if ((c40439f.field_appInfoFlag & 8) > 0) {
            AppMethodBeat.m2505o(79284);
            return true;
        } else {
            AppMethodBeat.m2505o(79284);
            return false;
        }
    }

    public static boolean aiF(String str) {
        AppMethodBeat.m2504i(79285);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(79285);
            return false;
        }
        boolean j = C46494g.m87751j(C46494g.m87739bT(str, true));
        AppMethodBeat.m2505o(79285);
        return j;
    }

    /* renamed from: k */
    public static boolean m87752k(C40439f c40439f) {
        AppMethodBeat.m2504i(79286);
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
            AppMethodBeat.m2505o(79286);
            return false;
        }
        boolean z;
        if ((c40439f.field_appInfoFlag & 64) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7419v("MicroMsg.AppInfoLogic", "canReadMMMsg, appid = %s, ret = %b", c40439f.field_appId, Boolean.valueOf(z));
        AppMethodBeat.m2505o(79286);
        return z;
    }

    /* renamed from: b */
    public static boolean m87737b(C40439f c40439f, int i) {
        AppMethodBeat.m2504i(79287);
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
            AppMethodBeat.m2505o(79287);
            return false;
        }
        boolean z;
        if ((c40439f.field_appInfoFlag & i) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.AppInfoLogic", "isAppHasFlag, appid = %s, flag = %s, ret = %b", c40439f.field_appId, Integer.valueOf(i), Boolean.valueOf(z));
        C4990ab.m7416i("MicroMsg.AppInfoLogic", "appInfoFlag = " + c40439f.field_appInfoFlag);
        AppMethodBeat.m2505o(79287);
        return z;
    }

    /* renamed from: l */
    public static boolean m87753l(C40439f c40439f) {
        AppMethodBeat.m2504i(79288);
        if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
            AppMethodBeat.m2505o(79288);
            return false;
        }
        Object obj;
        if ((c40439f.field_appInfoFlag & 128) > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (1 == obj) {
            String str = c40439f.field_appId;
            HashMap hashMap = new HashMap();
            C1853r.m3857m(hashMap);
            if (hashMap.containsKey(str)) {
                str = (String) hashMap.get(str);
            } else {
                str = null;
            }
            if (str == null || str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                AppMethodBeat.m2505o(79288);
                return true;
            }
            AppMethodBeat.m2505o(79288);
            return false;
        }
        AppMethodBeat.m2505o(79288);
        return false;
    }

    /* renamed from: a */
    public static boolean m87727a(Context context, String str, WXMediaMessage wXMediaMessage, int i, C14875aj c14875aj, Bundle bundle) {
        AppMethodBeat.m2504i(79289);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "launch app failed: context is null");
            if (c14875aj != null) {
                c14875aj.mo6036dR(false);
            }
            AppMethodBeat.m2505o(79289);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "launch app failed: appid is null or nil");
            if (c14875aj != null) {
                c14875aj.mo6036dR(false);
            }
            AppMethodBeat.m2505o(79289);
            return false;
        } else if (wXMediaMessage == null) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "launch app failed: wxMsg is null");
            if (c14875aj != null) {
                c14875aj.mo6036dR(false);
            }
            AppMethodBeat.m2505o(79289);
            return false;
        } else {
            C40439f dX;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                dX = C46494g.m87742dX(str, BaseClientBuilder.API_PRIORITY_OTHER);
            } else {
                dX = C46494g.m87738bS(str, false);
            }
            if (dX == null) {
                C4990ab.m7413e("MicroMsg.AppInfoLogic", "get appinfo is null, appid is : [%s]", str);
                if (c14875aj != null) {
                    c14875aj.mo6036dR(false);
                }
                AppMethodBeat.m2505o(79289);
                return false;
            } else if (dX.field_status == 3) {
                C4990ab.m7412e("MicroMsg.AppInfoLogic", "requestAppShow fail, app is in blacklist, packageName = " + dX.field_packageName);
                if (c14875aj != null) {
                    c14875aj.mo6036dR(false);
                }
                AppMethodBeat.m2505o(79289);
                return false;
            } else {
                boolean a = C46494g.m87728a(context, dX.field_packageName, wXMediaMessage, str, dX.field_openId, i, c14875aj, bundle);
                AppMethodBeat.m2505o(79289);
                return a;
            }
        }
    }

    /* renamed from: a */
    public static boolean m87728a(Context context, String str, WXMediaMessage wXMediaMessage, String str2, String str3, int i, C14875aj c14875aj, Bundle bundle) {
        AppMethodBeat.m2504i(79290);
        C4990ab.m7410d("MicroMsg.AppInfoLogic", "request pkg = " + str + ", openId = " + str3);
        boolean a = C46494g.m87729a(context, str, str2, C46494g.m87740c(context, wXMediaMessage, str3), i, c14875aj, bundle);
        AppMethodBeat.m2505o(79290);
        return a;
    }

    /* renamed from: a */
    public static boolean m87729a(Context context, String str, String str2, Req req, int i, C14875aj c14875aj, Bundle bundle) {
        AppMethodBeat.m2504i(79291);
        if (req == null) {
            C4990ab.m7416i("MicroMsg.AppInfoLogic", "launchApp failed, req is null.");
            if (c14875aj != null) {
                c14875aj.mo6036dR(false);
            }
            AppMethodBeat.m2505o(79291);
            return false;
        } else if (TextUtils.isEmpty(str) || !C35799p.m58695u(context, str)) {
            C4990ab.m7416i("MicroMsg.AppInfoLogic", "launchApp failed, pkg is null or application has not installed.");
            C30379h.m48465bQ(context, context.getString(C25738R.string.aob));
            if (c14875aj != null) {
                c14875aj.mo6036dR(false);
            }
            AppMethodBeat.m2505o(79291);
            return false;
        } else {
            C4990ab.m7417i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) with appId(%s)", str, str2);
            if (C5046bo.nullAsNil(C4996ah.getPackageName()).equals(str)) {
                C4990ab.m7416i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
                if (c14875aj != null) {
                    c14875aj.mo6036dR(false);
                }
                AppMethodBeat.m2505o(79291);
                return false;
            }
            final Req req2 = req;
            final String str3 = str;
            final Context context2 = context;
            final C14875aj c14875aj2 = c14875aj;
            final C300701 c300701 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(79255);
                    Bundle bundle = new Bundle();
                    req2.toBundle(bundle);
                    C35799p.m58687at(bundle);
                    C35799p.m58688au(bundle);
                    Args args = new Args();
                    args.targetPkgName = str3;
                    args.bundle = bundle;
                    boolean send = MMessageActV2.send(context2, args);
                    if (c14875aj2 != null) {
                        c14875aj2.mo6036dR(send);
                    }
                    AppMethodBeat.m2505o(79255);
                }
            };
            if (i == 2) {
                C4990ab.m7417i("MicroMsg.AppInfoLogic", "launchApp with show confirm dialog(%s).", str);
                c300701.run();
                AppMethodBeat.m2505o(79291);
                return true;
            }
            String string;
            String string2;
            String string3;
            String str4;
            if (bundle != null) {
                string = bundle.getString("current_page_url", "");
                string2 = bundle.getString("current_page_appid", "");
            } else {
                string = "";
                string2 = "";
            }
            C40439f bT = C46494g.m87739bT(str2, true);
            if (bT == null || C5046bo.isNullOrNil(C46494g.m87733b(context, bT, null))) {
                string3 = context.getString(C25738R.string.cle);
            } else {
                string3 = context.getString(C25738R.string.clf, new Object[]{C46494g.m87733b(context, bT, null)});
            }
            if (str2 == null) {
                str4 = "";
            } else {
                str4 = str2;
            }
            C46494g.aiG(str4);
            C4990ab.m7417i("MicroMsg.AppInfoLogic", "launchApp with args(showType : %s, pkg : %s)", Integer.valueOf(i), str);
            final String str5 = str;
            final String str6 = str;
            final String str7 = string;
            final String str8 = string2;
            final String str9 = str4;
            final C14875aj c14875aj3 = c14875aj;
            C30379h.m48445a(context, string3, "", context.getString(C25738R.string.cld), context.getString(C25738R.string.f9076or), false, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(79256);
                    C7060h.pYm.mo8381e(14102, Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), str5, string, string2);
                    if ("wx073f4a4daff0abe8".equalsIgnoreCase(str4)) {
                        C7060h.pYm.mo8381e(15413, Integer.valueOf(2), "", "");
                    }
                    c300701.run();
                    AppMethodBeat.m2505o(79256);
                }
            }, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(79257);
                    C7060h.pYm.mo8381e(14102, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str6, str7, str8);
                    if ("wx073f4a4daff0abe8".equalsIgnoreCase(str9)) {
                        C7060h.pYm.mo8381e(15413, Integer.valueOf(3), "", "");
                    }
                    if (c14875aj3 != null) {
                        c14875aj3.mo6036dR(false);
                    }
                    AppMethodBeat.m2505o(79257);
                }
            });
            AppMethodBeat.m2505o(79291);
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m87736b(Context context, Intent intent, String str) {
        AppMethodBeat.m2504i(79293);
        boolean a = C46494g.m87725a(context, intent, str, null, null);
        AppMethodBeat.m2505o(79293);
        return a;
    }

    /* renamed from: a */
    public static boolean m87724a(Context context, Intent intent, String str, C14875aj c14875aj) {
        AppMethodBeat.m2504i(79294);
        boolean a = C46494g.m87725a(context, intent, str, c14875aj, null);
        AppMethodBeat.m2505o(79294);
        return a;
    }

    /* renamed from: a */
    public static boolean m87725a(Context context, Intent intent, String str, C14875aj c14875aj, Bundle bundle) {
        AppMethodBeat.m2504i(79295);
        boolean a = C46494g.m87723a(context, intent, str, 0, c14875aj, bundle);
        AppMethodBeat.m2505o(79295);
        return a;
    }

    /* renamed from: a */
    public static boolean m87723a(Context context, Intent intent, String str, int i, C14875aj c14875aj, Bundle bundle) {
        AppMethodBeat.m2504i(79296);
        if (context == null || intent == null) {
            C4990ab.m7416i("MicroMsg.AppInfoLogic", "launchApp failed, context or intent is null.");
            if (c14875aj != null) {
                c14875aj.mo6036dR(false);
            }
            AppMethodBeat.m2505o(79296);
            return false;
        }
        String string;
        String string2;
        if (bundle != null) {
            string = bundle.getString("current_page_url", "");
            string2 = bundle.getString("current_page_appid", "");
        } else {
            string = "";
            string2 = "";
        }
        List H = C5046bo.m7502H(context, intent);
        if (H == null || H.isEmpty()) {
            C4990ab.m7420w("MicroMsg.AppInfoLogic", "launchApp failed, not activity can resolve the intent.");
            if (c14875aj != null) {
                c14875aj.mo6036dR(false);
            }
            AppMethodBeat.m2505o(79296);
            return false;
        }
        Object b;
        if (TextUtils.isEmpty(intent.getPackage()) && H.size() == 1) {
            b = C46494g.m87734b((ResolveInfo) H.get(0));
        } else {
            b = intent.getPackage();
        }
        C4990ab.m7411d("MicroMsg.AppInfoLogic", "launchApp, wxpkg : %s.", C4996ah.getPackageName());
        if (C5046bo.nullAsNil(C4996ah.getPackageName()).equals(b)) {
            C4990ab.m7416i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
            if (c14875aj != null) {
                c14875aj.mo6036dR(false);
            }
            AppMethodBeat.m2505o(79296);
            return false;
        }
        C4990ab.m7417i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) by wechat with intent", b);
        if (i == 2) {
            context.startActivity(intent);
            if (c14875aj != null) {
                c14875aj.mo6036dR(true);
            }
            AppMethodBeat.m2505o(79296);
            return true;
        }
        String string3;
        if (TextUtils.isEmpty(str)) {
            string3 = context.getString(C25738R.string.cle);
        } else {
            string3 = context.getString(C25738R.string.clf, new Object[]{str});
        }
        final Context context2 = context;
        final Intent intent2 = intent;
        final C14875aj c14875aj2 = c14875aj;
        final C14875aj c14875aj3 = c14875aj;
        C30379h.m48445a(context, string3, "", context.getString(C25738R.string.cld), context.getString(C25738R.string.f9076or), false, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(79258);
                context2.startActivity(intent2);
                C7060h.pYm.mo8381e(14102, Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), b, string, string2);
                if (c14875aj2 != null) {
                    c14875aj2.mo6036dR(true);
                }
                AppMethodBeat.m2505o(79258);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(79259);
                C7060h.pYm.mo8381e(14102, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), b, string, string2);
                if (c14875aj3 != null) {
                    c14875aj3.mo6036dR(false);
                }
                AppMethodBeat.m2505o(79259);
            }
        });
        AppMethodBeat.m2505o(79296);
        return true;
    }

    /* renamed from: c */
    public static Req m87740c(Context context, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.m2504i(79297);
        Req req = new Req();
        if (context == null) {
            context = C4996ah.getContext();
        }
        req.message = wXMediaMessage;
        req.transaction = C1178g.m2591x((C5046bo.anU()).getBytes());
        req.openId = str;
        req.lang = C4988aa.m7402g(context.getSharedPreferences(C4996ah.doA(), 0));
        req.country = (String) C1720g.m3536RP().mo5239Ry().get(274436, null);
        AppMethodBeat.m2505o(79297);
        return req;
    }

    /* renamed from: b */
    public static String m87734b(ResolveInfo resolveInfo) {
        AppMethodBeat.m2504i(79298);
        if (resolveInfo == null) {
            AppMethodBeat.m2505o(79298);
            return null;
        }
        String str = resolveInfo.resolvePackageName;
        if (TextUtils.isEmpty(str) && resolveInfo.activityInfo != null) {
            str = resolveInfo.activityInfo.packageName;
        }
        AppMethodBeat.m2505o(79298);
        return str;
    }

    /* renamed from: fJ */
    public static List<C40439f> m87745fJ(Context context) {
        AppMethodBeat.m2504i(79269);
        ArrayList arrayList = new ArrayList();
        if (C3753a.bYQ() == null) {
            C4990ab.m7412e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.m2505o(79269);
        } else {
            Cursor bYN = C3753a.bYQ().bYN();
            if (bYN == null) {
                AppMethodBeat.m2505o(79269);
            } else {
                while (bYN.moveToNext()) {
                    C40439f c40439f = new C40439f();
                    c40439f.mo8995d(bYN);
                    if (c40439f.field_status == 1) {
                        if (!C46494g.m87757u(context, c40439f.field_appId)) {
                            c40439f.field_status = 4;
                            C3753a.bYQ().mo25144e(c40439f);
                        } else if (!C5046bo.isNullOrNil(c40439f.field_signature)) {
                            arrayList.add(c40439f);
                        }
                    } else if (c40439f.field_signature != null) {
                        arrayList.add(c40439f);
                    }
                }
                bYN.close();
                AppMethodBeat.m2505o(79269);
            }
        }
        return arrayList;
    }

    /* renamed from: t */
    public static String m87756t(Context context, String str) {
        AppMethodBeat.m2504i(79278);
        String b = C46494g.m87733b(context, C46494g.m87739bT(str, true), null);
        AppMethodBeat.m2505o(79278);
        return b;
    }

    private static void aiG(String str) {
        AppMethodBeat.m2504i(79292);
        if ("wx073f4a4daff0abe8".equalsIgnoreCase(str)) {
            C7060h.pYm.mo8381e(15413, Integer.valueOf(1), "", "");
        }
        AppMethodBeat.m2505o(79292);
    }
}
