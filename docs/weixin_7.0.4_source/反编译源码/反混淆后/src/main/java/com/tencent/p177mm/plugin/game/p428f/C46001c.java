package com.tencent.p177mm.plugin.game.p428f;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.game.report.p850a.C9541b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C26183ky;
import com.tencent.p177mm.p230g.p231a.C37725gz;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C39211a;
import com.tencent.p177mm.plugin.game.model.C39211a.C3243a;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p642h.C5707g;
import com.tencent.p177mm.vending.p642h.C7369h;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.game.f.c */
public final class C46001c {
    private static int fMg = -1;
    private static volatile C5004al ftB;
    private static final Object iRa = new Object();
    private static int maxSize = -1;
    private static DisplayMetrics njz;
    private static int nnx = -1;
    private static Rect rect = new Rect();

    static {
        AppMethodBeat.m2504i(112322);
        AppMethodBeat.m2505o(112322);
    }

    public static int getScreenWidth(Context context) {
        AppMethodBeat.m2504i(112296);
        if (context == null) {
            AppMethodBeat.m2505o(112296);
            return 0;
        }
        if (njz == null) {
            njz = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(njz);
        }
        int i = njz.widthPixels;
        AppMethodBeat.m2505o(112296);
        return i;
    }

    /* renamed from: ax */
    public static int m85455ax(Context context, String str) {
        AppMethodBeat.m2504i(112297);
        int t = C46001c.m85464t(context, str, null);
        AppMethodBeat.m2505o(112297);
        return t;
    }

    /* renamed from: t */
    public static int m85464t(Context context, String str, String str2) {
        AppMethodBeat.m2504i(112298);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(112298);
            return 0;
        } else if (C46001c.m85456ay(context, str)) {
            AppMethodBeat.m2505o(112298);
            return 30;
        } else {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("show_bottom", false);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", str2);
            C46001c.m85465w(intent, context);
            AppMethodBeat.m2505o(112298);
            return 7;
        }
    }

    /* renamed from: ay */
    public static boolean m85456ay(Context context, String str) {
        int i = 2;
        AppMethodBeat.m2504i(112299);
        String queryParameter = Uri.parse(str).getQueryParameter("weapp");
        if (!C5046bo.isNullOrNil(queryParameter)) {
            try {
                Uri parse = Uri.parse(queryParameter);
                String authority = parse.getAuthority();
                if (C5046bo.isNullOrNil(authority)) {
                    C4990ab.m7420w("MicroMsg.GameCenterUtil", "targetAppId is null");
                    AppMethodBeat.m2505o(112299);
                    return false;
                }
                String queryParameter2 = parse.getQueryParameter("env_version");
                String queryParameter3 = parse.getQueryParameter("path");
                queryParameter2 = C5046bo.nullAsNil(queryParameter2);
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
                C4990ab.m7417i("MicroMsg.GameCenterUtil", "jumpWeApp, appId: %s, versionType: %d, path: %s", authority, Integer.valueOf(i), queryParameter3);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA;
                ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(context, null, authority, i, 0, queryParameter3, appBrandStatObject);
                AppMethodBeat.m2505o(112299);
                return true;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.GameCenterUtil", "checkJumpWeApp: " + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(112299);
        return false;
    }

    /* renamed from: a */
    public static void m85452a(Context context, C28229n c28229n, String str) {
        AppMethodBeat.m2504i(112300);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", c28229n.mWG.url);
        intent.putExtra("finishviewifloadfailed", true);
        intent.putExtra("show_full_screen", c28229n.mWG.mTC);
        intent.putExtra("disable_progress_bar", c28229n.mWG.mTC);
        int i = -1;
        switch (c28229n.mWG.orientation) {
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
        C26183ky c26183ky = new C26183ky();
        c26183ky.cGQ.type = 1;
        c26183ky.cGQ.context = context;
        c26183ky.cGQ.intent = intent;
        C4879a.xxA.mo10055m(c26183ky);
        AppMethodBeat.m2505o(112300);
    }

    /* renamed from: a */
    public static boolean m85453a(View view, Context context) {
        AppMethodBeat.m2504i(112301);
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            C4990ab.m7412e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            AppMethodBeat.m2505o(112301);
            return false;
        }
        String str = (String) view.getTag();
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.GameCenterUtil", "Invalid Jump URL");
            AppMethodBeat.m2505o(112301);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        C46001c.m85465w(intent, context);
        AppMethodBeat.m2505o(112301);
        return true;
    }

    /* renamed from: ej */
    public static Dialog m85459ej(Context context) {
        AppMethodBeat.m2504i(112302);
        View inflate = View.inflate(context, 2130969765, null);
        final C15532i c15532i = new C15532i(context, C25738R.style.f10959k0);
        c15532i.setContentView(inflate);
        c15532i.setCancelable(true);
        c15532i.setCanceledOnTouchOutside(false);
        c15532i.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(112293);
                c15532i.setOnCancelListener(null);
                AppMethodBeat.m2505o(112293);
            }
        });
        AppMethodBeat.m2505o(112302);
        return c15532i;
    }

    /* renamed from: Or */
    public static int m85447Or(String str) {
        AppMethodBeat.m2504i(112303);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.GameCenterUtil", "Null or Nil packageName");
            AppMethodBeat.m2505o(112303);
            return 0;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = C4996ah.getContext().getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.GameCenterUtil", "Exception: %s", e.toString());
            packageInfo = null;
        }
        if (packageInfo == null) {
            AppMethodBeat.m2505o(112303);
            return 0;
        }
        int i = packageInfo.versionCode;
        AppMethodBeat.m2505o(112303);
        return i;
    }

    /* renamed from: Os */
    public static int m85448Os(String str) {
        AppMethodBeat.m2504i(112304);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.GameCenterUtil", "Null or Nil path");
            AppMethodBeat.m2505o(112304);
            return 0;
        }
        PackageInfo packageArchiveInfo = C4996ah.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo == null) {
            AppMethodBeat.m2505o(112304);
            return 0;
        }
        int i = packageArchiveInfo.versionCode;
        AppMethodBeat.m2505o(112304);
        return i;
    }

    /* renamed from: Ot */
    public static synchronized void m85449Ot(String str) {
        synchronized (C46001c.class) {
            AppMethodBeat.m2504i(112305);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(112305);
            } else {
                C4990ab.m7411d("MicroMsg.GameCenterUtil", "pre download entrance image : %s", str);
                final C37725gz c37725gz = new C37725gz();
                c37725gz.cBH.f13665Cn = 1;
                c37725gz.cBH.url = str;
                C4879a.xxA.mo10055m(c37725gz);
                if (c37725gz.cBI.cBK) {
                    String str2 = c37725gz.cBI.cBJ + C1178g.m2591x(str.getBytes());
                    C17927a c17927a = new C17927a();
                    c17927a.ePH = true;
                    c17927a.ePJ = str2;
                    C25814c ahG = c17927a.ahG();
                    C32291o.ahp().mo43769a(str, null, ahG, new C1282i() {
                        /* renamed from: a */
                        public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
                            AppMethodBeat.m2504i(112294);
                            c37725gz.cBH.f13665Cn = 2;
                            c37725gz.cBH.url = str;
                            C4879a.xxA.mo10055m(c37725gz);
                            AppMethodBeat.m2505o(112294);
                        }
                    }, new C9014g() {
                        /* renamed from: sH */
                        public final void mo7596sH(String str) {
                        }

                        /* renamed from: a */
                        public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                            return null;
                        }

                        /* renamed from: b */
                        public final void mo7595b(String str, View view, C37477b c37477b) {
                            AppMethodBeat.m2504i(112295);
                            c37725gz.cBH.f13665Cn = 2;
                            c37725gz.cBH.url = str;
                            C4879a.xxA.mo10055m(c37725gz);
                            if (c37477b == null) {
                                AppMethodBeat.m2505o(112295);
                                return;
                            }
                            int i = c37477b.from;
                            if (c37477b.status != 0 || c37477b.bitmap == null) {
                                if (i == 2) {
                                    C7060h.pYm.mo8378a(858, 14, 1, false);
                                }
                            } else if (i == 2) {
                                C7060h.pYm.mo8378a(858, 13, 1, false);
                                AppMethodBeat.m2505o(112295);
                                return;
                            }
                            AppMethodBeat.m2505o(112295);
                        }
                    });
                }
                AppMethodBeat.m2505o(112305);
            }
        }
    }

    /* renamed from: ab */
    public static void m85454ab(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(112306);
        if (C5046bo.m7548ek(linkedList)) {
            AppMethodBeat.m2505o(112306);
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C40439f bT = C46494g.m87739bT(str, true);
            if (bT != null && C5046bo.isNullOrNil(bT.field_openId)) {
                linkedList2.add(str);
            }
        }
        if (!C5046bo.m7548ek(linkedList2)) {
            C34832a.bYL().addAll(linkedList2);
        }
        AppMethodBeat.m2505o(112306);
    }

    public static LinkedList<C40439f> bFF() {
        AppMethodBeat.m2504i(112307);
        Cursor dhE = C34832a.bYJ().dhE();
        LinkedList linkedList = new LinkedList();
        if (dhE == null) {
            C4990ab.m7412e("MicroMsg.GameCenterUtil", "getGameAppInfo failed: curosr is null");
        } else {
            if (dhE.moveToFirst()) {
                do {
                    C40439f c40439f = new C40439f();
                    c40439f.mo8995d(dhE);
                    linkedList.add(c40439f);
                } while (dhE.moveToNext());
            }
            dhE.close();
        }
        AppMethodBeat.m2505o(112307);
        return linkedList;
    }

    /* renamed from: b */
    public static int m85457b(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(112308);
        int a = C46001c.m85451a(context, str, str2, bundle, 0);
        AppMethodBeat.m2505o(112308);
        return a;
    }

    /* renamed from: a */
    public static int m85451a(Context context, String str, String str2, Bundle bundle, int i) {
        int t;
        AppMethodBeat.m2504i(112309);
        if (!C5046bo.isNullOrNil(str)) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            C3243a cm = C39211a.m66814cm(str, bundle.getInt("game_report_from_scene", 0));
            if (cm.bJt == 2 && !C5046bo.isNullOrNil(cm.url)) {
                t = C46001c.m85464t(context, cm.url, "game_center_detail");
                AppMethodBeat.m2505o(112309);
                return t;
            }
        }
        if (C5046bo.isNullOrNil(str2)) {
            int bEb = C20993e.bEb();
            if (bEb == 2) {
                t = C46001c.m85462m(context, str, i);
                AppMethodBeat.m2505o(112309);
                return t;
            } else if (bEb == 1) {
                C46001c.m85460g(context, bundle);
                AppMethodBeat.m2505o(112309);
                return 6;
            } else {
                String gQ = C5046bo.m7555gQ(context);
                if (C5046bo.isNullOrNil(gQ) || gQ.toLowerCase().equals("cn")) {
                    t = C46001c.m85462m(context, str, i);
                    AppMethodBeat.m2505o(112309);
                    return t;
                }
                C46001c.m85460g(context, bundle);
                AppMethodBeat.m2505o(112309);
                return 6;
            }
        }
        t = C46001c.m85464t(context, str2, "game_center_detail");
        AppMethodBeat.m2505o(112309);
        return t;
    }

    /* renamed from: m */
    public static int m85462m(Context context, String str, int i) {
        AppMethodBeat.m2504i(112310);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(112310);
            return 0;
        }
        String bEa = C20993e.bEa();
        if (C5046bo.isNullOrNil(bEa)) {
            bEa = "game.weixin.qq.com/cgi-bin/h5/static/gamecenter/detail.html?appid=".concat(String.valueOf(str));
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("appid", str);
            if (i > 0) {
                hashMap.put("ssid", String.valueOf(i));
            }
            bEa = C46001c.m85463p(bEa, hashMap);
        }
        int t = C46001c.m85464t(context, bEa, "game_center_detail");
        AppMethodBeat.m2505o(112310);
        return t;
    }

    /* renamed from: p */
    private static String m85463p(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(112311);
        if (C5046bo.isNullOrNil(str) || map.isEmpty()) {
            AppMethodBeat.m2505o(112311);
            return str;
        }
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str2 : map.keySet()) {
            buildUpon.appendQueryParameter(str2, (String) map.get(str2));
        }
        str = buildUpon.build().toString();
        AppMethodBeat.m2505o(112311);
        return str;
    }

    /* renamed from: g */
    public static void m85460g(Context context, Bundle bundle) {
        AppMethodBeat.m2504i(112312);
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.plugin.game.ui.GameDetailUI2");
        intent.putExtras(bundle);
        context.startActivity(intent);
        AppMethodBeat.m2505o(112312);
    }

    /* renamed from: w */
    public static void m85465w(Intent intent, Context context) {
        AppMethodBeat.m2504i(112313);
        if (C46001c.m85450Ou(intent.getStringExtra("rawUrl"))) {
            C46001c.m85466x(intent, context);
            AppMethodBeat.m2505o(112313);
            return;
        }
        C26183ky c26183ky = new C26183ky();
        c26183ky.cGQ.type = 0;
        c26183ky.cGQ.context = context;
        c26183ky.cGQ.intent = intent;
        C4879a.xxA.mo10055m(c26183ky);
        AppMethodBeat.m2505o(112313);
    }

    /* renamed from: x */
    public static void m85466x(Intent intent, Context context) {
        AppMethodBeat.m2504i(112314);
        C26183ky c26183ky = new C26183ky();
        c26183ky.cGQ.type = 2;
        c26183ky.cGQ.context = context;
        c26183ky.cGQ.intent = intent;
        C4879a.xxA.mo10055m(c26183ky);
        AppMethodBeat.m2505o(112314);
    }

    public static void aNR() {
        AppMethodBeat.m2504i(112315);
        if (ftB == null) {
            AppMethodBeat.m2505o(112315);
            return;
        }
        synchronized (iRa) {
            try {
                if (ftB != null) {
                    C5707g.asT("SubCoreGameCenter#WorkThread");
                    ftB.oAl.quit();
                    ftB = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(112315);
            }
        }
    }

    public static C5004al aNS() {
        AppMethodBeat.m2504i(112316);
        if (ftB == null) {
            synchronized (iRa) {
                try {
                    if (ftB == null) {
                        ftB = new C5004al("SubCoreGameCenter#WorkThread");
                        C5707g.m8573a("SubCoreGameCenter#WorkThread", new C7369h(ftB.oAl.getLooper(), "SubCoreGameCenter#WorkThread"));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(112316);
                    }
                }
            }
        }
        C5004al c5004al = ftB;
        AppMethodBeat.m2505o(112316);
        return c5004al;
    }

    public static int parseColor(String str) {
        AppMethodBeat.m2504i(112317);
        int i = 0;
        try {
            i = Color.parseColor(str);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.GameCenterUtil", "parseColor: " + e.getMessage());
        }
        AppMethodBeat.m2505o(112317);
        return i;
    }

    /* renamed from: eC */
    public static boolean m85458eC(String str, String str2) {
        AppMethodBeat.m2504i(112318);
        File file = new File(str);
        String v = C1178g.m2589v(file);
        boolean exists;
        if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(v)) {
            C4990ab.m7416i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 is null");
            exists = file.exists();
            AppMethodBeat.m2505o(112318);
            return exists;
        }
        C4990ab.m7417i("MicroMsg.GameCenterUtil", "checkPkgMD5Valid, md5 = %s, calculateMD5 = %s", str2, v);
        exists = str2.equalsIgnoreCase(v);
        AppMethodBeat.m2505o(112318);
        return exists;
    }

    /* renamed from: iQ */
    public static void m85461iQ(long j) {
        AppMethodBeat.m2504i(112319);
        C33913a.m55499a(j, false, null);
        AppMethodBeat.m2505o(112319);
    }

    public static String bFG() {
        AppMethodBeat.m2504i(112320);
        String a = ((C9541b) C1720g.m3528K(C9541b.class)).mo20807a(C11745a.clicfg_game_center_home_url_android, "");
        if (a == null || C5046bo.isNullOrNil(a.trim())) {
            C3243a bDL = C39211a.bDL();
            if (bDL.bJt != 2 || C5046bo.isNullOrNil(bDL.url)) {
                AppMethodBeat.m2505o(112320);
                return null;
            }
            C7060h.pYm.mo8378a(848, 12, 1, false);
            a = bDL.url;
            AppMethodBeat.m2505o(112320);
            return a;
        } else if (a.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
            C7060h.pYm.mo8378a(848, 11, 1, false);
            AppMethodBeat.m2505o(112320);
            return null;
        } else {
            C7060h.pYm.mo8378a(848, 10, 1, false);
            AppMethodBeat.m2505o(112320);
            return a;
        }
    }

    /* renamed from: Ou */
    private static boolean m85450Ou(String str) {
        AppMethodBeat.m2504i(112321);
        if (!((C9541b) C1720g.m3528K(C9541b.class)).mo20808a(C11745a.game_luggage)) {
            AppMethodBeat.m2505o(112321);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(112321);
            return false;
        } else {
            Uri parse = Uri.parse(str);
            if (parse.getHost() == null || !parse.getHost().equals("game.weixin.qq.com")) {
                AppMethodBeat.m2505o(112321);
                return false;
            }
            AppMethodBeat.m2505o(112321);
            return true;
        }
    }
}
