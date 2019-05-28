package com.tencent.mm.pluginsdk.model.app;

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
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class g {
    public static f Uq(String str) {
        AppMethodBeat.i(139134);
        f bT = bT(str, true);
        AppMethodBeat.o(139134);
        return bT;
    }

    public static f dX(String str, int i) {
        f fVar = null;
        AppMethodBeat.i(79261);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
            AppMethodBeat.o(79261);
        } else if (a.bYQ() == null) {
            ab.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.o(79261);
        } else {
            fVar = a.bYQ().Uq(str);
            if (a(fVar, i)) {
                a.bYQ().Us(str);
            }
            AppMethodBeat.o(79261);
        }
        return fVar;
    }

    public static f bS(String str, boolean z) {
        AppMethodBeat.i(79262);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
            AppMethodBeat.o(79262);
            return null;
        }
        com.tencent.mm.plugin.s.a.a bYQ = a.bYQ();
        f Ur;
        if (bYQ == null) {
            ab.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.o(79262);
            return null;
        } else if (z) {
            Ur = bYQ.Ur(str);
            AppMethodBeat.o(79262);
            return Ur;
        } else {
            Ur = bYQ.Uq(str);
            if (Ur == null) {
                Ur = bYQ.Ur(str);
                AppMethodBeat.o(79262);
                return Ur;
            }
            bYQ.Us(str);
            AppMethodBeat.o(79262);
            return Ur;
        }
    }

    public static f bT(String str, boolean z) {
        f fVar = null;
        AppMethodBeat.i(79263);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
            AppMethodBeat.o(79263);
        } else if (a.bYQ() == null) {
            ab.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.o(79263);
        } else {
            fVar = a.bYQ().Uq(str);
            if (z && g(fVar)) {
                a.bYQ().Us(str);
            }
            AppMethodBeat.o(79263);
        }
        return fVar;
    }

    private static boolean g(f fVar) {
        AppMethodBeat.i(79264);
        if (fVar == null || fVar.field_appName == null || fVar.field_appName.length() == 0) {
            AppMethodBeat.o(79264);
            return true;
        }
        AppMethodBeat.o(79264);
        return false;
    }

    private static boolean a(f fVar, int i) {
        return fVar == null || fVar.field_appVersion < i;
    }

    public static Bitmap b(String str, int i, float f) {
        AppMethodBeat.i(79265);
        Bitmap a;
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppInfoLogic", "getAppIcon, appId is null");
            AppMethodBeat.o(79265);
            return null;
        } else if (!com.tencent.mm.kernel.g.RN().QY()) {
            AppMethodBeat.o(79265);
            return null;
        } else if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
            a = a.bYQ().a(str, i, f);
            if (a == null) {
                ab.w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
                a.bYQ().cN(str, i);
                AppMethodBeat.o(79265);
                return null;
            } else if (a.isRecycled()) {
                AppMethodBeat.o(79265);
                return null;
            } else {
                AppMethodBeat.o(79265);
                return a;
            }
        } else if (ah.getContext() == null) {
            AppMethodBeat.o(79265);
            return null;
        } else if (ah.getContext().getResources() == null) {
            AppMethodBeat.o(79265);
            return null;
        } else {
            switch (i) {
                case 1:
                case 3:
                case 4:
                case 5:
                    a = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ao_);
                    if (a == null || a.isRecycled()) {
                        AppMethodBeat.o(79265);
                        return null;
                    }
                    AppMethodBeat.o(79265);
                    return a;
                case 2:
                    AppMethodBeat.o(79265);
                    return null;
                default:
                    ab.e("MicroMsg.AppInfoLogic", "getAppIcon, unknown iconType = ".concat(String.valueOf(i)));
                    AppMethodBeat.o(79265);
                    return null;
            }
        }
    }

    public static List<f> b(Context context, long j, boolean z) {
        AppMethodBeat.i(79266);
        ArrayList arrayList = new ArrayList();
        i bYJ = com.tencent.mm.plugin.s.a.bYJ();
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
        ab.v("MicroMsg.AppInfoStorage", "getAppInfoByContentFlag sql %s", stringBuilder.toString());
        Cursor rawQuery = bYJ.rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            ab.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
            rawQuery = null;
        }
        if (rawQuery == null) {
            AppMethodBeat.o(79266);
        } else {
            while (rawQuery.moveToNext()) {
                f fVar = new f();
                fVar.d(rawQuery);
                if (fVar.field_status == 1) {
                    if (!u(context, fVar.field_appId)) {
                        fVar.field_status = 4;
                        a.bYQ().e(fVar);
                    } else if (!bo.isNullOrNil(fVar.field_signature)) {
                        arrayList.add(fVar);
                    }
                } else if (fVar.field_signature != null) {
                    arrayList.add(fVar);
                }
            }
            rawQuery.close();
            AppMethodBeat.o(79266);
        }
        return arrayList;
    }

    public static boolean o(Context context, long j) {
        AppMethodBeat.i(79267);
        if (b(context, j, true).size() == 0) {
            AppMethodBeat.o(79267);
            return false;
        }
        AppMethodBeat.o(79267);
        return true;
    }

    public static boolean ad(Context context, int i) {
        AppMethodBeat.i(79268);
        Long aik = c.a.aik(String.valueOf(i));
        if (aik == null) {
            AppMethodBeat.o(79268);
            return false;
        } else if (b(context, aik.longValue(), true).size() == 0) {
            AppMethodBeat.o(79268);
            return false;
        } else {
            AppMethodBeat.o(79268);
            return true;
        }
    }

    public static List<f> a(Context context, boolean z, int i) {
        AppMethodBeat.i(79270);
        List<f> arrayList = new ArrayList();
        if (a.bYQ() == null) {
            ab.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.o(79270);
        } else {
            arrayList = gJ(1, i);
            int[] iArr = null;
            if (z) {
                iArr = new int[]{5};
            }
            if (iArr == null) {
                AppMethodBeat.o(79270);
            } else {
                Cursor x = a.bYQ().x(iArr);
                if (x != null) {
                    while (x.moveToNext()) {
                        f fVar = new f();
                        fVar.d(x);
                        if (fVar.field_status == 1) {
                            if (!u(context, fVar.field_appId)) {
                                fVar.field_status = 4;
                                a.bYQ().e(fVar);
                            } else if (!bo.isNullOrNil(fVar.field_signature)) {
                                arrayList.add(fVar);
                            }
                        } else if (fVar.field_signature != null) {
                            arrayList.add(fVar);
                        }
                    }
                    x.close();
                }
                AppMethodBeat.o(79270);
            }
        }
        return arrayList;
    }

    public static List<f> gJ(int i, int i2) {
        AppMethodBeat.i(79271);
        ArrayList arrayList = new ArrayList();
        if (a.bYQ() == null) {
            ab.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
            AppMethodBeat.o(79271);
        } else {
            Cursor eQ = a.bYQ().eQ(i, i2);
            if (eQ == null) {
                AppMethodBeat.o(79271);
            } else {
                while (eQ.moveToNext()) {
                    f fVar = new f();
                    fVar.d(eQ);
                    arrayList.add(fVar);
                }
                eQ.close();
                AppMethodBeat.o(79271);
            }
        }
        return arrayList;
    }

    public static int Kw(int i) {
        AppMethodBeat.i(79272);
        ArrayList arrayList = new ArrayList();
        if (a.bYQ() == null) {
            ab.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
            AppMethodBeat.o(79272);
            return 0;
        }
        Cursor eQ = a.bYQ().eQ(0, i);
        if (eQ == null) {
            AppMethodBeat.o(79272);
            return 0;
        }
        int count = eQ.getCount();
        eQ.close();
        AppMethodBeat.o(79272);
        return count;
    }

    public static List<f> dhB() {
        AppMethodBeat.i(79273);
        ArrayList arrayList = new ArrayList();
        if (a.bYQ() == null) {
            ab.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
            AppMethodBeat.o(79273);
        } else {
            Cursor bYP = a.bYQ().bYP();
            if (bYP == null) {
                AppMethodBeat.o(79273);
            } else {
                while (bYP.moveToNext()) {
                    f fVar = new f();
                    fVar.d(bYP);
                    if (!bo.isNullOrNil(fVar.field_openId)) {
                        arrayList.add(fVar);
                    }
                }
                bYP.close();
                AppMethodBeat.o(79273);
            }
        }
        return arrayList;
    }

    public static boolean u(Context context, String str) {
        AppMethodBeat.i(79274);
        if (context == null || str == null || str.length() == 0) {
            ab.e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
            AppMethodBeat.o(79274);
            return false;
        }
        boolean a = a(context, bT(str, true));
        AppMethodBeat.o(79274);
        return a;
    }

    public static boolean a(Context context, f fVar) {
        AppMethodBeat.i(79275);
        if (fVar == null) {
            ab.w("MicroMsg.AppInfoLogic", "app is null");
            AppMethodBeat.o(79275);
            return false;
        } else if (fVar.field_packageName == null || fVar.field_packageName.length() == 0) {
            ab.w("MicroMsg.AppInfoLogic", "field_packageName is null");
            AppMethodBeat.o(79275);
            return false;
        } else {
            boolean u = p.u(context, fVar.field_packageName);
            AppMethodBeat.o(79275);
            return u;
        }
    }

    public static boolean dg(String str) {
        AppMethodBeat.i(79276);
        if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
            AppMethodBeat.o(79276);
            return false;
        }
        AppMethodBeat.o(79276);
        return true;
    }

    public static String r(Context context, String str, int i) {
        AppMethodBeat.i(79277);
        String b = b(context, dX(str, i), null);
        AppMethodBeat.o(79277);
        return b;
    }

    public static String b(Context context, f fVar, String str) {
        AppMethodBeat.i(79279);
        if (context == null || fVar == null) {
            AppMethodBeat.o(79279);
            return str;
        }
        String fK = fK(context);
        String str2 = null;
        if (fK.equalsIgnoreCase("zh_CN")) {
            str2 = fVar.field_appName;
        }
        if (fK.equalsIgnoreCase("en")) {
            str2 = bo.isNullOrNil(fVar.field_appName_en) ? fVar.field_appName : fVar.field_appName_en;
        }
        if (fK.equalsIgnoreCase("zh_TW") || fK.equalsIgnoreCase("zh_HK")) {
            if (fK.equalsIgnoreCase("zh_HK")) {
                str2 = bo.isNullOrNil(fVar.field_appName_hk) ? fVar.field_appName_tw : fVar.field_appName_hk;
            }
            if (bo.isNullOrNil(str2)) {
                str2 = bo.isNullOrNil(fVar.field_appName_tw) ? fVar.field_appName : fVar.field_appName_tw;
            }
        }
        if (bo.isNullOrNil(str2)) {
            str2 = bo.isNullOrNil(fVar.field_appName_en) ? fVar.field_appName : fVar.field_appName_en;
        }
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(79279);
            return str;
        }
        AppMethodBeat.o(79279);
        return str2;
    }

    public static String c(Context context, f fVar, String str) {
        AppMethodBeat.i(79280);
        if (context == null || fVar == null) {
            AppMethodBeat.o(79280);
            return str;
        }
        String fK = fK(context);
        String str2 = null;
        if (fK.equalsIgnoreCase("zh_CN")) {
            str2 = fVar.field_appName;
        }
        if (fK.equalsIgnoreCase("en")) {
            str2 = bo.isNullOrNil(fVar.field_appName_en) ? fVar.field_appName : fVar.field_appName_en;
        }
        if (fK.equalsIgnoreCase("zh_TW") || fK.equalsIgnoreCase("zh_HK")) {
            if (fK.equalsIgnoreCase("zh_HK")) {
                str2 = bo.isNullOrNil(fVar.field_appName_hk) ? fVar.field_appName_tw : fVar.field_appName_hk;
            }
            if (bo.isNullOrNil(str2)) {
                str2 = bo.isNullOrNil(fVar.field_appName_tw) ? fVar.field_appName : fVar.field_appName_tw;
            }
        }
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(79280);
            return str;
        }
        AppMethodBeat.o(79280);
        return str2;
    }

    public static String fK(Context context) {
        AppMethodBeat.i(79281);
        String g = aa.g(context.getSharedPreferences(ah.doA(), 0));
        if (g == null || g.length() == 0 || g.equalsIgnoreCase("zh_CN")) {
            g = "zh_CN";
            AppMethodBeat.o(79281);
            return g;
        }
        AppMethodBeat.o(79281);
        return g;
    }

    public static boolean dk(String str) {
        AppMethodBeat.i(79282);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(79282);
            return false;
        }
        f bT = bT(str, false);
        if (bT == null) {
            ab.w("MicroMsg.AppInfoLogic", "app is null, appId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(79282);
            return false;
        }
        boolean xy = bT.xy();
        AppMethodBeat.o(79282);
        return xy;
    }

    public static boolean h(f fVar) {
        AppMethodBeat.i(79283);
        if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
            AppMethodBeat.o(79283);
            return false;
        } else if ((fVar.field_appInfoFlag & 1) > 0) {
            AppMethodBeat.o(79283);
            return true;
        } else {
            AppMethodBeat.o(79283);
            return false;
        }
    }

    public static boolean i(f fVar) {
        if (fVar == null || (fVar.field_appInfoFlag & 2) == 0) {
            return true;
        }
        return false;
    }

    private static boolean j(f fVar) {
        AppMethodBeat.i(79284);
        if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
            AppMethodBeat.o(79284);
            return false;
        } else if (fVar.field_appId.equals("wx7fa037cc7dfabad5")) {
            AppMethodBeat.o(79284);
            return true;
        } else if ((fVar.field_appInfoFlag & 8) > 0) {
            AppMethodBeat.o(79284);
            return true;
        } else {
            AppMethodBeat.o(79284);
            return false;
        }
    }

    public static boolean aiF(String str) {
        AppMethodBeat.i(79285);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(79285);
            return false;
        }
        boolean j = j(bT(str, true));
        AppMethodBeat.o(79285);
        return j;
    }

    public static boolean k(f fVar) {
        AppMethodBeat.i(79286);
        if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
            AppMethodBeat.o(79286);
            return false;
        }
        boolean z;
        if ((fVar.field_appInfoFlag & 64) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.v("MicroMsg.AppInfoLogic", "canReadMMMsg, appid = %s, ret = %b", fVar.field_appId, Boolean.valueOf(z));
        AppMethodBeat.o(79286);
        return z;
    }

    public static boolean b(f fVar, int i) {
        AppMethodBeat.i(79287);
        if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
            AppMethodBeat.o(79287);
            return false;
        }
        boolean z;
        if ((fVar.field_appInfoFlag & i) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.AppInfoLogic", "isAppHasFlag, appid = %s, flag = %s, ret = %b", fVar.field_appId, Integer.valueOf(i), Boolean.valueOf(z));
        ab.i("MicroMsg.AppInfoLogic", "appInfoFlag = " + fVar.field_appInfoFlag);
        AppMethodBeat.o(79287);
        return z;
    }

    public static boolean l(f fVar) {
        AppMethodBeat.i(79288);
        if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
            AppMethodBeat.o(79288);
            return false;
        }
        Object obj;
        if ((fVar.field_appInfoFlag & 128) > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (1 == obj) {
            String str = fVar.field_appId;
            HashMap hashMap = new HashMap();
            r.m(hashMap);
            if (hashMap.containsKey(str)) {
                str = (String) hashMap.get(str);
            } else {
                str = null;
            }
            if (str == null || str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                AppMethodBeat.o(79288);
                return true;
            }
            AppMethodBeat.o(79288);
            return false;
        }
        AppMethodBeat.o(79288);
        return false;
    }

    public static boolean a(Context context, String str, WXMediaMessage wXMediaMessage, int i, aj ajVar, Bundle bundle) {
        AppMethodBeat.i(79289);
        if (context == null) {
            ab.e("MicroMsg.AppInfoLogic", "launch app failed: context is null");
            if (ajVar != null) {
                ajVar.dR(false);
            }
            AppMethodBeat.o(79289);
            return false;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppInfoLogic", "launch app failed: appid is null or nil");
            if (ajVar != null) {
                ajVar.dR(false);
            }
            AppMethodBeat.o(79289);
            return false;
        } else if (wXMediaMessage == null) {
            ab.e("MicroMsg.AppInfoLogic", "launch app failed: wxMsg is null");
            if (ajVar != null) {
                ajVar.dR(false);
            }
            AppMethodBeat.o(79289);
            return false;
        } else {
            f dX;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                dX = dX(str, BaseClientBuilder.API_PRIORITY_OTHER);
            } else {
                dX = bS(str, false);
            }
            if (dX == null) {
                ab.e("MicroMsg.AppInfoLogic", "get appinfo is null, appid is : [%s]", str);
                if (ajVar != null) {
                    ajVar.dR(false);
                }
                AppMethodBeat.o(79289);
                return false;
            } else if (dX.field_status == 3) {
                ab.e("MicroMsg.AppInfoLogic", "requestAppShow fail, app is in blacklist, packageName = " + dX.field_packageName);
                if (ajVar != null) {
                    ajVar.dR(false);
                }
                AppMethodBeat.o(79289);
                return false;
            } else {
                boolean a = a(context, dX.field_packageName, wXMediaMessage, str, dX.field_openId, i, ajVar, bundle);
                AppMethodBeat.o(79289);
                return a;
            }
        }
    }

    public static boolean a(Context context, String str, WXMediaMessage wXMediaMessage, String str2, String str3, int i, aj ajVar, Bundle bundle) {
        AppMethodBeat.i(79290);
        ab.d("MicroMsg.AppInfoLogic", "request pkg = " + str + ", openId = " + str3);
        boolean a = a(context, str, str2, c(context, wXMediaMessage, str3), i, ajVar, bundle);
        AppMethodBeat.o(79290);
        return a;
    }

    public static boolean a(Context context, String str, String str2, Req req, int i, aj ajVar, Bundle bundle) {
        AppMethodBeat.i(79291);
        if (req == null) {
            ab.i("MicroMsg.AppInfoLogic", "launchApp failed, req is null.");
            if (ajVar != null) {
                ajVar.dR(false);
            }
            AppMethodBeat.o(79291);
            return false;
        } else if (TextUtils.isEmpty(str) || !p.u(context, str)) {
            ab.i("MicroMsg.AppInfoLogic", "launchApp failed, pkg is null or application has not installed.");
            h.bQ(context, context.getString(R.string.aob));
            if (ajVar != null) {
                ajVar.dR(false);
            }
            AppMethodBeat.o(79291);
            return false;
        } else {
            ab.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) with appId(%s)", str, str2);
            if (bo.nullAsNil(ah.getPackageName()).equals(str)) {
                ab.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
                if (ajVar != null) {
                    ajVar.dR(false);
                }
                AppMethodBeat.o(79291);
                return false;
            }
            final Req req2 = req;
            final String str3 = str;
            final Context context2 = context;
            final aj ajVar2 = ajVar;
            final AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(79255);
                    Bundle bundle = new Bundle();
                    req2.toBundle(bundle);
                    p.at(bundle);
                    p.au(bundle);
                    Args args = new Args();
                    args.targetPkgName = str3;
                    args.bundle = bundle;
                    boolean send = MMessageActV2.send(context2, args);
                    if (ajVar2 != null) {
                        ajVar2.dR(send);
                    }
                    AppMethodBeat.o(79255);
                }
            };
            if (i == 2) {
                ab.i("MicroMsg.AppInfoLogic", "launchApp with show confirm dialog(%s).", str);
                anonymousClass1.run();
                AppMethodBeat.o(79291);
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
            f bT = bT(str2, true);
            if (bT == null || bo.isNullOrNil(b(context, bT, null))) {
                string3 = context.getString(R.string.cle);
            } else {
                string3 = context.getString(R.string.clf, new Object[]{b(context, bT, null)});
            }
            if (str2 == null) {
                str4 = "";
            } else {
                str4 = str2;
            }
            aiG(str4);
            ab.i("MicroMsg.AppInfoLogic", "launchApp with args(showType : %s, pkg : %s)", Integer.valueOf(i), str);
            final String str5 = str;
            final String str6 = str;
            final String str7 = string;
            final String str8 = string2;
            final String str9 = str4;
            final aj ajVar3 = ajVar;
            h.a(context, string3, "", context.getString(R.string.cld), context.getString(R.string.or), false, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(79256);
                    com.tencent.mm.plugin.report.service.h.pYm.e(14102, Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), str5, string, string2);
                    if ("wx073f4a4daff0abe8".equalsIgnoreCase(str4)) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(15413, Integer.valueOf(2), "", "");
                    }
                    anonymousClass1.run();
                    AppMethodBeat.o(79256);
                }
            }, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(79257);
                    com.tencent.mm.plugin.report.service.h.pYm.e(14102, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str6, str7, str8);
                    if ("wx073f4a4daff0abe8".equalsIgnoreCase(str9)) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(15413, Integer.valueOf(3), "", "");
                    }
                    if (ajVar3 != null) {
                        ajVar3.dR(false);
                    }
                    AppMethodBeat.o(79257);
                }
            });
            AppMethodBeat.o(79291);
            return true;
        }
    }

    public static boolean b(Context context, Intent intent, String str) {
        AppMethodBeat.i(79293);
        boolean a = a(context, intent, str, null, null);
        AppMethodBeat.o(79293);
        return a;
    }

    public static boolean a(Context context, Intent intent, String str, aj ajVar) {
        AppMethodBeat.i(79294);
        boolean a = a(context, intent, str, ajVar, null);
        AppMethodBeat.o(79294);
        return a;
    }

    public static boolean a(Context context, Intent intent, String str, aj ajVar, Bundle bundle) {
        AppMethodBeat.i(79295);
        boolean a = a(context, intent, str, 0, ajVar, bundle);
        AppMethodBeat.o(79295);
        return a;
    }

    public static boolean a(Context context, Intent intent, String str, int i, aj ajVar, Bundle bundle) {
        AppMethodBeat.i(79296);
        if (context == null || intent == null) {
            ab.i("MicroMsg.AppInfoLogic", "launchApp failed, context or intent is null.");
            if (ajVar != null) {
                ajVar.dR(false);
            }
            AppMethodBeat.o(79296);
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
        List H = bo.H(context, intent);
        if (H == null || H.isEmpty()) {
            ab.w("MicroMsg.AppInfoLogic", "launchApp failed, not activity can resolve the intent.");
            if (ajVar != null) {
                ajVar.dR(false);
            }
            AppMethodBeat.o(79296);
            return false;
        }
        Object b;
        if (TextUtils.isEmpty(intent.getPackage()) && H.size() == 1) {
            b = b((ResolveInfo) H.get(0));
        } else {
            b = intent.getPackage();
        }
        ab.d("MicroMsg.AppInfoLogic", "launchApp, wxpkg : %s.", ah.getPackageName());
        if (bo.nullAsNil(ah.getPackageName()).equals(b)) {
            ab.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
            if (ajVar != null) {
                ajVar.dR(false);
            }
            AppMethodBeat.o(79296);
            return false;
        }
        ab.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) by wechat with intent", b);
        if (i == 2) {
            context.startActivity(intent);
            if (ajVar != null) {
                ajVar.dR(true);
            }
            AppMethodBeat.o(79296);
            return true;
        }
        String string3;
        if (TextUtils.isEmpty(str)) {
            string3 = context.getString(R.string.cle);
        } else {
            string3 = context.getString(R.string.clf, new Object[]{str});
        }
        final Context context2 = context;
        final Intent intent2 = intent;
        final aj ajVar2 = ajVar;
        final aj ajVar3 = ajVar;
        h.a(context, string3, "", context.getString(R.string.cld), context.getString(R.string.or), false, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(79258);
                context2.startActivity(intent2);
                com.tencent.mm.plugin.report.service.h.pYm.e(14102, Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), b, string, string2);
                if (ajVar2 != null) {
                    ajVar2.dR(true);
                }
                AppMethodBeat.o(79258);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(79259);
                com.tencent.mm.plugin.report.service.h.pYm.e(14102, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), b, string, string2);
                if (ajVar3 != null) {
                    ajVar3.dR(false);
                }
                AppMethodBeat.o(79259);
            }
        });
        AppMethodBeat.o(79296);
        return true;
    }

    public static Req c(Context context, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.i(79297);
        Req req = new Req();
        if (context == null) {
            context = ah.getContext();
        }
        req.message = wXMediaMessage;
        req.transaction = com.tencent.mm.a.g.x((bo.anU()).getBytes());
        req.openId = str;
        req.lang = aa.g(context.getSharedPreferences(ah.doA(), 0));
        req.country = (String) com.tencent.mm.kernel.g.RP().Ry().get(274436, null);
        AppMethodBeat.o(79297);
        return req;
    }

    public static String b(ResolveInfo resolveInfo) {
        AppMethodBeat.i(79298);
        if (resolveInfo == null) {
            AppMethodBeat.o(79298);
            return null;
        }
        String str = resolveInfo.resolvePackageName;
        if (TextUtils.isEmpty(str) && resolveInfo.activityInfo != null) {
            str = resolveInfo.activityInfo.packageName;
        }
        AppMethodBeat.o(79298);
        return str;
    }

    public static List<f> fJ(Context context) {
        AppMethodBeat.i(79269);
        ArrayList arrayList = new ArrayList();
        if (a.bYQ() == null) {
            ab.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.o(79269);
        } else {
            Cursor bYN = a.bYQ().bYN();
            if (bYN == null) {
                AppMethodBeat.o(79269);
            } else {
                while (bYN.moveToNext()) {
                    f fVar = new f();
                    fVar.d(bYN);
                    if (fVar.field_status == 1) {
                        if (!u(context, fVar.field_appId)) {
                            fVar.field_status = 4;
                            a.bYQ().e(fVar);
                        } else if (!bo.isNullOrNil(fVar.field_signature)) {
                            arrayList.add(fVar);
                        }
                    } else if (fVar.field_signature != null) {
                        arrayList.add(fVar);
                    }
                }
                bYN.close();
                AppMethodBeat.o(79269);
            }
        }
        return arrayList;
    }

    public static String t(Context context, String str) {
        AppMethodBeat.i(79278);
        String b = b(context, bT(str, true), null);
        AppMethodBeat.o(79278);
        return b;
    }

    private static void aiG(String str) {
        AppMethodBeat.i(79292);
        if ("wx073f4a4daff0abe8".equalsIgnoreCase(str)) {
            com.tencent.mm.plugin.report.service.h.pYm.e(15413, Integer.valueOf(1), "", "");
        }
        AppMethodBeat.o(79292);
    }
}
