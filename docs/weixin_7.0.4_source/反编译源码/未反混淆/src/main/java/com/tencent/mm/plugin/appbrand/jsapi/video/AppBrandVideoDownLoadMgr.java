package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.cdndownloader.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.t.c;
import com.tencent.mm.t.d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandVideoDownLoadMgr {
    public static final String hYF;
    private static HashMap<String, String> hYG = new HashMap();
    static final Map<String, a> hYH = new ConcurrentHashMap();
    public static AppBrandVideoDownLoadMgr hYI;
    static d hYJ;

    static /* synthetic */ void al(String str, boolean z) {
        AppMethodBeat.i(131531);
        ak(str, z);
        AppMethodBeat.o(131531);
    }

    static {
        AppMethodBeat.i(131532);
        hYI = null;
        hYJ = null;
        if (hYI == null) {
            hYI = new AppBrandVideoDownLoadMgr();
        }
        String str = e.eSn;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        hYF = str + "wagamefiles/";
        d.a(a.bfc());
        d dVar = new d();
        hYJ = dVar;
        dVar.ewY = new c() {
            public final void onTaskSucc(String str, String str2, boolean z) {
                AppMethodBeat.i(131521);
                ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc save_path = %s, url = %s, is_resume = %s", str2, str, Boolean.valueOf(z));
                AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.hYI;
                AppBrandVideoDownLoadMgr.al(str, true);
                ((a) AppBrandVideoDownLoadMgr.hYH.get(str)).hYE.cv(str, str2);
                AppMethodBeat.o(131521);
            }

            public final void onTaskFail(String str, int i, boolean z) {
                AppMethodBeat.i(131522);
                ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail err_code = %s, url = %s,is_resume = %s", Integer.valueOf(i), str, Boolean.valueOf(z));
                AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.hYI;
                AppBrandVideoDownLoadMgr.al(str, false);
                ((a) AppBrandVideoDownLoadMgr.hYH.get(str)).hYE.bj(str, i);
                AppMethodBeat.o(131522);
            }
        };
        AppMethodBeat.o(131532);
    }

    /* Access modifiers changed, original: 0000 */
    @Keep
    public String genAdFileExist(String str, a aVar) {
        AppMethodBeat.i(131523);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(aVar.url)) {
            ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error source or videoUrl = %s", aVar.url);
            AppMethodBeat.o(131523);
            return null;
        }
        String BQ = BQ(aVar.url);
        if (bo.isNullOrNil(BQ)) {
            ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error urlFileMd5 = %s or videoUrl = %s", BQ, aVar.url);
            AppMethodBeat.o(131523);
            return null;
        } else if (bo.isNullOrNil(BO(BQ))) {
            String str2 = BP(str) + BQ + ".gad";
            File file = new File(str2);
            String v = g.v(file);
            if (!file.exists() || (!BQ.startsWith("unverify") && (v == null || !v.equalsIgnoreCase(BQ)))) {
                AppMethodBeat.o(131523);
                return null;
            }
            aVar.hYC = 0;
            aVar.hYD = com.tencent.mm.g.b.a.c.a.DownLoaded;
            AppMethodBeat.o(131523);
            return str2;
        } else {
            String str3 = "downloading";
            AppMethodBeat.o(131523);
            return str3;
        }
    }

    /* Access modifiers changed, original: 0000 */
    @Keep
    public String genAdFilePath(String str, a aVar) {
        String str2 = null;
        AppMethodBeat.i(131524);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(aVar.url)) {
            ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error source or videoUrl = %s", aVar.url);
            AppMethodBeat.o(131524);
        } else {
            String BQ = BQ(aVar.url);
            if (bo.isNullOrNil(BQ)) {
                ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error urlFileMd5 = %s or videoUrl = %s", BQ, aVar.url);
                AppMethodBeat.o(131524);
            } else if (bo.isNullOrNil(BO(BQ))) {
                aVar.startTimeStamp = bo.yz();
                aVar.hYD = com.tencent.mm.g.b.a.c.a.DownLoading;
                str2 = xY(str) + BQ + ".gad";
                synchronized (hYG) {
                    try {
                        hYG.put(BQ, str2);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(131524);
                    }
                }
            } else {
                AppMethodBeat.o(131524);
            }
        }
        return str2;
    }

    static void ak(String str, boolean z) {
        AppMethodBeat.i(131525);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(131525);
            return;
        }
        String BQ = BQ(str);
        synchronized (hYG) {
            try {
                if (hYG.containsKey(BQ)) {
                    hYG.remove(BQ);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(131525);
            }
        }
        a aVar = (a) hYH.get(str);
        if (aVar != null) {
            if (aVar.url.equalsIgnoreCase(str) && aVar.startTimeStamp > 0) {
                aVar.hYC = bo.az(aVar.startTimeStamp);
            }
            if (z) {
                aVar.hYD = com.tencent.mm.g.b.a.c.a.DownLoaded;
                return;
            }
            aVar.hYD = com.tencent.mm.g.b.a.c.a.DownLoadFail;
        }
        AppMethodBeat.o(131525);
    }

    private static String BO(String str) {
        String str2;
        AppMethodBeat.i(131526);
        synchronized (hYG) {
            try {
                if (hYG.containsKey(str)) {
                    str2 = (String) hYG.get(str);
                } else {
                    str2 = null;
                    AppMethodBeat.o(131526);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(131526);
            }
        }
        return str2;
    }

    private static String BP(String str) {
        AppMethodBeat.i(131527);
        String str2 = hYF + str + "/";
        AppMethodBeat.o(131527);
        return str2;
    }

    private static String xY(String str) {
        AppMethodBeat.i(131528);
        String BP = BP(str);
        j.aih(BP);
        try {
            new File(BP, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        AppMethodBeat.o(131528);
        return BP;
    }

    public final synchronized void report(String str) {
        AppMethodBeat.i(131529);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad report error videoUrl is nil");
            AppMethodBeat.o(131529);
        } else {
            a aVar = (a) hYH.get(str);
            if (aVar == null || aVar.hYC < 0 || !str.equalsIgnoreCase(aVar.url)) {
                ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad report error preLoadCostTime or videoUrl");
                AppMethodBeat.o(131529);
            } else {
                ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad report downLoadCostTime = %s,preLoadStatus = %s", Long.valueOf(aVar.hYC), aVar.hYD);
                com.tencent.mm.g.b.a.c eq = new com.tencent.mm.g.b.a.c().eq(str);
                eq.cTy = aVar.hYC;
                eq.cTz = aVar.hYD;
                eq.ajK();
                AppMethodBeat.o(131529);
            }
        }
    }

    private static String BQ(String str) {
        String queryParameter;
        AppMethodBeat.i(131530);
        Uri parse = Uri.parse(str);
        if (parse.getHost().equalsIgnoreCase("wxsnsdy.wxs.qq.com")) {
            queryParameter = parse.getQueryParameter("m");
        } else {
            queryParameter = "unverify" + ag.ck(str);
        }
        AppMethodBeat.o(131530);
        return queryParameter;
    }
}
