package com.tencent.mm.plugin.game.f;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c {
    private static int fMg = -1;
    private static volatile al ftB;
    private static final Object iRa = new Object();
    private static int maxSize = -1;
    private static DisplayMetrics njz;
    private static int nnx = -1;
    private static Rect rect = new Rect();

    static {
        AppMethodBeat.i(112322);
        AppMethodBeat.o(112322);
    }

    public static int getScreenWidth(Context context) {
        AppMethodBeat.i(112296);
        if (context == null) {
            AppMethodBeat.o(112296);
            return 0;
        }
        if (njz == null) {
            njz = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(njz);
        }
        int i = njz.widthPixels;
        AppMethodBeat.o(112296);
        return i;
    }

    public static int ax(Context context, String str) {
        AppMethodBeat.i(112297);
        int t = t(context, str, null);
        AppMethodBeat.o(112297);
        return t;
    }

    public static int t(Context context, String str, String str2) {
        AppMethodBeat.i(112298);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(112298);
            return 0;
        } else if (ay(context, str)) {
            AppMethodBeat.o(112298);
            return 30;
        } else {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("show_bottom", false);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", str2);
            w(intent, context);
            AppMethodBeat.o(112298);
            return 7;
        }
    }

    public static boolean ay(Context context, String str) {
        int i = 2;
        AppMethodBeat.i(112299);
        String queryParameter = Uri.parse(str).getQueryParameter("weapp");
        if (!bo.isNullOrNil(queryParameter)) {
            try {
                Uri parse = Uri.parse(queryParameter);
                String authority = parse.getAuthority();
                if (bo.isNullOrNil(authority)) {
                    ab.w("MicroMsg.GameCenterUtil", "targetAppId is null");
                    AppMethodBeat.o(112299);
                    return false;
                }
                String queryParameter2 = parse.getQueryParameter("env_version");
                String queryParameter3 = parse.getQueryParameter("path");
                queryParameter2 = bo.nullAsNil(queryParameter2);
                Object obj = -1;
                switch (queryParameter2.hashCode()) {
                    case 110628630:
                        if (queryParameter2.equals("trial")) {
                            int obj2 = 1;
                            break;
                        }
                        break;
                    case 1559690845:
                        if (queryParameter2.equals("develop")) {
                            obj2 = null;
                            break;
                        }
                        break;
                }
                switch (obj2) {
                    case null:
                        i = 1;
                        break;
                    case 1:
                        break;
                    default:
                        i = 0;
                        break;
                }
                ab.i("MicroMsg.GameCenterUtil", "jumpWeApp, appId: %s, versionType: %d, path: %s", authority, Integer.valueOf(i), queryParameter3);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA;
                ((e) g.K(e.class)).a(context, null, authority, i, 0, queryParameter3, appBrandStatObject);
                AppMethodBeat.o(112299);
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.GameCenterUtil", "checkJumpWeApp: " + e.getMessage());
            }
        }
        AppMethodBeat.o(112299);
        return false;
    }

    public static void a(Context context, n nVar, String str) {
        AppMethodBeat.i(112300);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", nVar.mWG.url);
        intent.putExtra("finishviewifloadfailed", true);
        intent.putExtra("show_full_screen", nVar.mWG.mTC);
        intent.putExtra("disable_progress_bar", nVar.mWG.mTC);
        int i = -1;
        switch (nVar.mWG.orientation) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 1001;
                break;
            case 4:
                i = 1002;
                break;
        }
        intent.putExtra("screen_orientation", i);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str);
        intent.putExtra("open_game_float", true);
        ky kyVar = new ky();
        kyVar.cGQ.type = 1;
        kyVar.cGQ.context = context;
        kyVar.cGQ.intent = intent;
        a.xxA.m(kyVar);
        AppMethodBeat.o(112300);
    }

    public static boolean a(View view, Context context) {
        AppMethodBeat.i(112301);
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            ab.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            AppMethodBeat.o(112301);
            return false;
        }
        String str = (String) view.getTag();
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            AppMethodBeat.o(112301);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        w(intent, context);
        AppMethodBeat.o(112301);
        return true;
    }

    public static Dialog ej(Context context) {
        AppMethodBeat.i(112302);
        View inflate = View.inflate(context, R.layout.a5b, null);
        final i iVar = new i(context, R.style.k0);
        iVar.setContentView(inflate);
        iVar.setCancelable(true);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(112293);
                iVar.setOnCancelListener(null);
                AppMethodBeat.o(112293);
            }
        });
        AppMethodBeat.o(112302);
        return iVar;
    }

    public static int Or(String str) {
        AppMethodBeat.i(112303);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
            AppMethodBeat.o(112303);
            return 0;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = ah.getContext().getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            ab.w("MicroMsg.GameCenterUtil", "Exception: %s", e.toString());
            packageInfo = null;
        }
        if (packageInfo == null) {
            AppMethodBeat.o(112303);
            return 0;
        }
        int i = packageInfo.versionCode;
        AppMethodBeat.o(112303);
        return i;
    }

    public static int Os(String str) {
        AppMethodBeat.i(112304);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.GameCenterUtil", "Null or Nil path");
            AppMethodBeat.o(112304);
            return 0;
        }
        PackageInfo packageArchiveInfo = ah.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo == null) {
            AppMethodBeat.o(112304);
            return 0;
        }
        int i = packageArchiveInfo.versionCode;
        AppMethodBeat.o(112304);
        return i;
    }

    public static synchronized void Ot(String str) {
        synchronized (c.class) {
            AppMethodBeat.i(112305);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(112305);
            } else {
                ab.d("MicroMsg.GameCenterUtil", "pre download entrance image : %s", str);
                final gz gzVar = new gz();
                gzVar.cBH.Cn = 1;
                gzVar.cBH.url = str;
                a.xxA.m(gzVar);
                if (gzVar.cBI.cBK) {
                    String str2 = gzVar.cBI.cBJ + com.tencent.mm.a.g.x(str.getBytes());
                    com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                    aVar.ePH = true;
                    aVar.ePJ = str2;
                    com.tencent.mm.at.a.a.c ahG = aVar.ahG();
                    o.ahp().a(str, null, ahG, new com.tencent.mm.at.a.c.i() {
                        public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                            AppMethodBeat.i(112294);
                            gzVar.cBH.Cn = 2;
                            gzVar.cBH.url = str;
                            a.xxA.m(gzVar);
                            AppMethodBeat.o(112294);
                        }
                    }, new com.tencent.mm.at.a.c.g() {
                        public final void sH(String str) {
                        }

                        public final Bitmap a(String str, View view, b bVar) {
                            return null;
                        }

                        public final void b(String str, View view, b bVar) {
                            AppMethodBeat.i(112295);
                            gzVar.cBH.Cn = 2;
                            gzVar.cBH.url = str;
                            a.xxA.m(gzVar);
                            if (bVar == null) {
                                AppMethodBeat.o(112295);
                                return;
                            }
                            int i = bVar.from;
                            if (bVar.status != 0 || bVar.bitmap == null) {
                                if (i == 2) {
                                    h.pYm.a(858, 14, 1, false);
                                }
                            } else if (i == 2) {
                                h.pYm.a(858, 13, 1, false);
                                AppMethodBeat.o(112295);
                                return;
                            }
                            AppMethodBeat.o(112295);
                        }
                    });
                }
                AppMethodBeat.o(112305);
            }
        }
    }

    public static void ab(LinkedList<String> linkedList) {
        AppMethodBeat.i(112306);
        if (bo.ek(linkedList)) {
            AppMethodBeat.o(112306);
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, true);
            if (bT != null && bo.isNullOrNil(bT.field_openId)) {
                linkedList2.add(str);
            }
        }
        if (!bo.ek(linkedList2)) {
            com.tencent.mm.plugin.s.a.bYL().addAll(linkedList2);
        }
        AppMethodBeat.o(112306);
    }

    public static LinkedList<f> bFF() {
        AppMethodBeat.i(112307);
        Cursor dhE = com.tencent.mm.plugin.s.a.bYJ().dhE();
        LinkedList linkedList = new LinkedList();
        if (dhE == null) {
            ab.e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
        } else {
            if (dhE.moveToFirst()) {
                do {
                    f fVar = new f();
                    fVar.d(dhE);
                    linkedList.add(fVar);
                } while (dhE.moveToNext());
            }
            dhE.close();
        }
        AppMethodBeat.o(112307);
        return linkedList;
    }

    public static int b(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(112308);
        int a = a(context, str, str2, bundle, 0);
        AppMethodBeat.o(112308);
        return a;
    }

    public static int a(Context context, String str, String str2, Bundle bundle, int i) {
        int t;
        AppMethodBeat.i(112309);
        if (!bo.isNullOrNil(str)) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            com.tencent.mm.plugin.game.model.a.a cm = com.tencent.mm.plugin.game.model.a.cm(str, bundle.getInt("game_report_from_scene", 0));
            if (cm.bJt == 2 && !bo.isNullOrNil(cm.url)) {
                t = t(context, cm.url, "game_center_detail");
                AppMethodBeat.o(112309);
                return t;
            }
        }
        if (bo.isNullOrNil(str2)) {
            int bEb = com.tencent.mm.plugin.game.model.e.bEb();
            if (bEb == 2) {
                t = m(context, str, i);
                AppMethodBeat.o(112309);
                return t;
            } else if (bEb == 1) {
                g(context, bundle);
                AppMethodBeat.o(112309);
                return 6;
            } else {
                String gQ = bo.gQ(context);
                if (bo.isNullOrNil(gQ) || gQ.toLowerCase().equals("cn")) {
                    t = m(context, str, i);
                    AppMethodBeat.o(112309);
                    return t;
                }
                g(context, bundle);
                AppMethodBeat.o(112309);
                return 6;
            }
        }
        t = t(context, str2, "game_center_detail");
        AppMethodBeat.o(112309);
        return t;
    }

    public static int m(Context context, String str, int i) {
        AppMethodBeat.i(112310);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(112310);
            return 0;
        }
        String bEa = com.tencent.mm.plugin.game.model.e.bEa();
        if (bo.isNullOrNil(bEa)) {
            bEa = "game.weixin.qq.com/cgi-bin/h5/static/gamecenter/detail.html?appid=".concat(String.valueOf(str));
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", str);
            if (i > 0) {
                hashMap.put("ssid", String.valueOf(i));
            }
            bEa = p(bEa, hashMap);
        }
        int t = t(context, bEa, "game_center_detail");
        AppMethodBeat.o(112310);
        return t;
    }

    private static String p(String str, Map<String, String> map) {
        AppMethodBeat.i(112311);
        if (bo.isNullOrNil(str) || map.isEmpty()) {
            AppMethodBeat.o(112311);
            return str;
        }
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str2 : map.keySet()) {
            buildUpon.appendQueryParameter(str2, (String) map.get(str2));
        }
        str = buildUpon.build().toString();
        AppMethodBeat.o(112311);
        return str;
    }

    public static void g(Context context, Bundle bundle) {
        AppMethodBeat.i(112312);
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.plugin.game.ui.GameDetailUI2");
        intent.putExtras(bundle);
        context.startActivity(intent);
        AppMethodBeat.o(112312);
    }

    public static void w(Intent intent, Context context) {
        AppMethodBeat.i(112313);
        if (Ou(intent.getStringExtra("rawUrl"))) {
            x(intent, context);
            AppMethodBeat.o(112313);
            return;
        }
        ky kyVar = new ky();
        kyVar.cGQ.type = 0;
        kyVar.cGQ.context = context;
        kyVar.cGQ.intent = intent;
        a.xxA.m(kyVar);
        AppMethodBeat.o(112313);
    }

    public static void x(Intent intent, Context context) {
        AppMethodBeat.i(112314);
        ky kyVar = new ky();
        kyVar.cGQ.type = 2;
        kyVar.cGQ.context = context;
        kyVar.cGQ.intent = intent;
        a.xxA.m(kyVar);
        AppMethodBeat.o(112314);
    }

    public static void aNR() {
        AppMethodBeat.i(112315);
        if (ftB == null) {
            AppMethodBeat.o(112315);
            return;
        }
        synchronized (iRa) {
            try {
                if (ftB != null) {
                    com.tencent.mm.vending.h.g.asT("SubCoreGameCenter#WorkThread");
                    ftB.oAl.quit();
                    ftB = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(112315);
            }
        }
    }

    public static al aNS() {
        AppMethodBeat.i(112316);
        if (ftB == null) {
            synchronized (iRa) {
                try {
                    if (ftB == null) {
                        ftB = new al("SubCoreGameCenter#WorkThread");
                        com.tencent.mm.vending.h.g.a("SubCoreGameCenter#WorkThread", new com.tencent.mm.vending.h.h(ftB.oAl.getLooper(), "SubCoreGameCenter#WorkThread"));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(112316);
                    }
                }
            }
        }
        al alVar = ftB;
        AppMethodBeat.o(112316);
        return alVar;
    }

    public static int parseColor(String str) {
        AppMethodBeat.i(112317);
        int i = 0;
        try {
            i = Color.parseColor(str);
        } catch (Exception e) {
            ab.e("MicroMsg.GameCenterUtil", "parseColor: " + e.getMessage());
        }
        AppMethodBeat.o(112317);
        return i;
    }

    public static boolean eC(String str, String str2) {
        AppMethodBeat.i(112318);
        File file = new File(str);
        String v = com.tencent.mm.a.g.v(file);
        boolean exists;
        if (bo.isNullOrNil(str2) || bo.isNullOrNil(v)) {
            ab.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
            exists = file.exists();
            AppMethodBeat.o(112318);
            return exists;
        }
        ab.i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", str2, v);
        exists = str2.equalsIgnoreCase(v);
        AppMethodBeat.o(112318);
        return exists;
    }

    public static void iQ(long j) {
        AppMethodBeat.i(112319);
        com.tencent.mm.plugin.downloader.h.a.a(j, false, null);
        AppMethodBeat.o(112319);
    }

    public static String bFG() {
        AppMethodBeat.i(112320);
        String a = ((com.tencent.mm.game.report.a.b) g.K(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_game_center_home_url_android, "");
        if (a == null || bo.isNullOrNil(a.trim())) {
            com.tencent.mm.plugin.game.model.a.a bDL = com.tencent.mm.plugin.game.model.a.bDL();
            if (bDL.bJt != 2 || bo.isNullOrNil(bDL.url)) {
                AppMethodBeat.o(112320);
                return null;
            }
            h.pYm.a(848, 12, 1, false);
            a = bDL.url;
            AppMethodBeat.o(112320);
            return a;
        } else if (a.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
            h.pYm.a(848, 11, 1, false);
            AppMethodBeat.o(112320);
            return null;
        } else {
            h.pYm.a(848, 10, 1, false);
            AppMethodBeat.o(112320);
            return a;
        }
    }

    private static boolean Ou(String str) {
        AppMethodBeat.i(112321);
        if (!((com.tencent.mm.game.report.a.b) g.K(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.a.a.a.game_luggage)) {
            AppMethodBeat.o(112321);
            return false;
        } else if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(112321);
            return false;
        } else {
            Uri parse = Uri.parse(str);
            if (parse.getHost() == null || !parse.getHost().equals("game.weixin.qq.com")) {
                AppMethodBeat.o(112321);
                return false;
            }
            AppMethodBeat.o(112321);
            return true;
        }
    }
}
