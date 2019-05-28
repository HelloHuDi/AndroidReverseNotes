package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p1087t.C40640c;
import com.tencent.p177mm.p1087t.C40641d;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p232b.p233a.C42090c;
import com.tencent.p177mm.p230g.p232b.p233a.C42090c.C42089a;
import com.tencent.p177mm.plugin.cdndownloader.p1245h.C20204a;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr */
public class AppBrandVideoDownLoadMgr {
    public static final String hYF;
    private static HashMap<String, String> hYG = new HashMap();
    static final Map<String, C27127a> hYH = new ConcurrentHashMap();
    public static AppBrandVideoDownLoadMgr hYI;
    static C40641d hYJ;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr$1 */
    static class C425921 implements C40640c {
        C425921() {
        }

        public final void onTaskSucc(String str, String str2, boolean z) {
            AppMethodBeat.m2504i(131521);
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc save_path = %s, url = %s, is_resume = %s", str2, str, Boolean.valueOf(z));
            AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.hYI;
            AppBrandVideoDownLoadMgr.m75406al(str, true);
            ((C27127a) AppBrandVideoDownLoadMgr.hYH.get(str)).hYE.mo34713cv(str, str2);
            AppMethodBeat.m2505o(131521);
        }

        public final void onTaskFail(String str, int i, boolean z) {
            AppMethodBeat.m2504i(131522);
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail err_code = %s, url = %s,is_resume = %s", Integer.valueOf(i), str, Boolean.valueOf(z));
            AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.hYI;
            AppBrandVideoDownLoadMgr.m75406al(str, false);
            ((C27127a) AppBrandVideoDownLoadMgr.hYH.get(str)).hYE.mo34712bj(str, i);
            AppMethodBeat.m2505o(131522);
        }
    }

    /* renamed from: al */
    static /* synthetic */ void m75406al(String str, boolean z) {
        AppMethodBeat.m2504i(131531);
        AppBrandVideoDownLoadMgr.m75405ak(str, z);
        AppMethodBeat.m2505o(131531);
    }

    static {
        AppMethodBeat.m2504i(131532);
        hYI = null;
        hYJ = null;
        if (hYI == null) {
            hYI = new AppBrandVideoDownLoadMgr();
        }
        String str = C6457e.eSn;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        hYF = str + "wagamefiles/";
        C40641d.m70195a(C20204a.bfc());
        C40641d c40641d = new C40641d();
        hYJ = c40641d;
        c40641d.ewY = new C425921();
        AppMethodBeat.m2505o(131532);
    }

    /* Access modifiers changed, original: 0000 */
    @Keep
    public String genAdFileExist(String str, C27127a c27127a) {
        AppMethodBeat.m2504i(131523);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(c27127a.url)) {
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error source or videoUrl = %s", c27127a.url);
            AppMethodBeat.m2505o(131523);
            return null;
        }
        String BQ = AppBrandVideoDownLoadMgr.m75404BQ(c27127a.url);
        if (C5046bo.isNullOrNil(BQ)) {
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error urlFileMd5 = %s or videoUrl = %s", BQ, c27127a.url);
            AppMethodBeat.m2505o(131523);
            return null;
        } else if (C5046bo.isNullOrNil(AppBrandVideoDownLoadMgr.m75402BO(BQ))) {
            String str2 = AppBrandVideoDownLoadMgr.m75403BP(str) + BQ + ".gad";
            File file = new File(str2);
            String v = C1178g.m2589v(file);
            if (!file.exists() || (!BQ.startsWith("unverify") && (v == null || !v.equalsIgnoreCase(BQ)))) {
                AppMethodBeat.m2505o(131523);
                return null;
            }
            c27127a.hYC = 0;
            c27127a.hYD = C42089a.DownLoaded;
            AppMethodBeat.m2505o(131523);
            return str2;
        } else {
            String str3 = "downloading";
            AppMethodBeat.m2505o(131523);
            return str3;
        }
    }

    /* Access modifiers changed, original: 0000 */
    @Keep
    public String genAdFilePath(String str, C27127a c27127a) {
        String str2 = null;
        AppMethodBeat.m2504i(131524);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(c27127a.url)) {
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error source or videoUrl = %s", c27127a.url);
            AppMethodBeat.m2505o(131524);
        } else {
            String BQ = AppBrandVideoDownLoadMgr.m75404BQ(c27127a.url);
            if (C5046bo.isNullOrNil(BQ)) {
                C4990ab.m7417i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error urlFileMd5 = %s or videoUrl = %s", BQ, c27127a.url);
                AppMethodBeat.m2505o(131524);
            } else if (C5046bo.isNullOrNil(AppBrandVideoDownLoadMgr.m75402BO(BQ))) {
                c27127a.startTimeStamp = C5046bo.m7588yz();
                c27127a.hYD = C42089a.DownLoading;
                str2 = AppBrandVideoDownLoadMgr.m75407xY(str) + BQ + ".gad";
                synchronized (hYG) {
                    try {
                        hYG.put(BQ, str2);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(131524);
                    }
                }
            } else {
                AppMethodBeat.m2505o(131524);
            }
        }
        return str2;
    }

    /* renamed from: ak */
    static void m75405ak(String str, boolean z) {
        AppMethodBeat.m2504i(131525);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(131525);
            return;
        }
        String BQ = AppBrandVideoDownLoadMgr.m75404BQ(str);
        synchronized (hYG) {
            try {
                if (hYG.containsKey(BQ)) {
                    hYG.remove(BQ);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(131525);
            }
        }
        C27127a c27127a = (C27127a) hYH.get(str);
        if (c27127a != null) {
            if (c27127a.url.equalsIgnoreCase(str) && c27127a.startTimeStamp > 0) {
                c27127a.hYC = C5046bo.m7525az(c27127a.startTimeStamp);
            }
            if (z) {
                c27127a.hYD = C42089a.DownLoaded;
                return;
            }
            c27127a.hYD = C42089a.DownLoadFail;
        }
        AppMethodBeat.m2505o(131525);
    }

    /* renamed from: BO */
    private static String m75402BO(String str) {
        String str2;
        AppMethodBeat.m2504i(131526);
        synchronized (hYG) {
            try {
                if (hYG.containsKey(str)) {
                    str2 = (String) hYG.get(str);
                } else {
                    str2 = null;
                    AppMethodBeat.m2505o(131526);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(131526);
            }
        }
        return str2;
    }

    /* renamed from: BP */
    private static String m75403BP(String str) {
        AppMethodBeat.m2504i(131527);
        String str2 = hYF + str + "/";
        AppMethodBeat.m2505o(131527);
        return str2;
    }

    /* renamed from: xY */
    private static String m75407xY(String str) {
        AppMethodBeat.m2504i(131528);
        String BP = AppBrandVideoDownLoadMgr.m75403BP(str);
        C15428j.aih(BP);
        try {
            new File(BP, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(131528);
        return BP;
    }

    public final synchronized void report(String str) {
        AppMethodBeat.m2504i(131529);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad report error videoUrl is nil");
            AppMethodBeat.m2505o(131529);
        } else {
            C27127a c27127a = (C27127a) hYH.get(str);
            if (c27127a == null || c27127a.hYC < 0 || !str.equalsIgnoreCase(c27127a.url)) {
                C4990ab.m7416i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad report error preLoadCostTime or videoUrl");
                AppMethodBeat.m2505o(131529);
            } else {
                C4990ab.m7417i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad report downLoadCostTime = %s,preLoadStatus = %s", Long.valueOf(c27127a.hYC), c27127a.hYD);
                C42090c eq = new C42090c().mo67645eq(str);
                eq.cTy = c27127a.hYC;
                eq.cTz = c27127a.hYD;
                eq.ajK();
                AppMethodBeat.m2505o(131529);
            }
        }
    }

    /* renamed from: BQ */
    private static String m75404BQ(String str) {
        String queryParameter;
        AppMethodBeat.m2504i(131530);
        Uri parse = Uri.parse(str);
        if (parse.getHost().equalsIgnoreCase("wxsnsdy.wxs.qq.com")) {
            queryParameter = parse.getQueryParameter("m");
        } else {
            queryParameter = "unverify" + C4995ag.m7428ck(str);
        }
        AppMethodBeat.m2505o(131530);
        return queryParameter;
    }
}
