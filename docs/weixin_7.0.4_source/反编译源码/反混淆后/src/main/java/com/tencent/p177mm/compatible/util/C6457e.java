package com.tencent.p177mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5034bd;
import com.tencent.p177mm.sdk.platformtools.C5034bd.C5033a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: com.tencent.mm.compatible.util.e */
public final class C6457e extends C1761b {
    public static final String euO = C1448h.getExternalStorageDirectory().getParent();
    public static String euP = (eSn + "appbrand/");
    public static String euQ = (eSn + "Download/");
    public static String euR;
    public static String euS = (eSn + "vusericon/");
    public static String euT = (eSn + "Game/");
    public static String euU = (eSn + "CDNTemp/");
    public static String euV = (eSn + "Download/VoiceRemind");
    public static String euW = (eSn + "watchdog/");
    public static String euX = (eSn + "xlog");
    public static String euY = (eSn + "avatar/");
    public static String euZ = (eSn + "exdevice/");
    public static String evA = (eSn + "wxacache/");
    public static String evB = (eSn + "wxafiles/");
    public static String evC = (eSn + "wxajscahce/");
    public static String evD = (eSn + "wxanewfiles/");
    public static String eva = (eSn + "newyear/");
    public static String evb = (eSn + "expose/");
    public static String evc = (eSn + "f2flucky/");
    public static String evd = (eSn + "WebviewCache/");
    public static String eve = (eSn + "pattern_recognition/");
    public static String evf = (eSn + "sniffer/");
    public static String evg = (eSn + "browser/");
    public static String evh = (eSn + "card/");
    public static String evi;
    public static String evj = (eSn + "CheckResUpdate/");
    public static String evk = (eSn + "crash/");
    public static String evl = (eSn + "diskcache/");
    public static String evm = (eSn + "FailMsgFileCache/");
    public static String evn = (eSn + "fts/");
    public static String evo = (eSn + "Handler/");
    public static String evp = (eSn + "MixAudio/");
    public static String evq = (eSn + "preloadedRes/");
    public static String evr = (eSn + "recovery/");
    public static String evs = (eSn + "share/");
    public static String evt = (eSn + "sns_ad_landingpages/");
    public static String evu = (eSn + "SQLTrace/");
    public static String evv = (eSn + "tracedog/");
    public static String evw = (eSn + "vproxy/");
    public static String evx = (eSn + "wagamefiles/");
    public static String evy = (eSn + "wallet/");
    public static String evz = (eSn + "wepkg/");

    /* renamed from: com.tencent.mm.compatible.util.e$1 */
    static class C14441 implements Comparator<C5033a> {
        C14441() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            C5033a c5033a = (C5033a) obj;
            C5033a c5033a2 = (C5033a) obj2;
            long j = (c5033a.xBx * c5033a.xBy) - (c5033a2.xBx * c5033a2.xBy);
            if (j < 0) {
                return 1;
            }
            if (j > 0) {
                return -1;
            }
            return 0;
        }
    }

    static {
        AppMethodBeat.m2504i(93069);
        AppMethodBeat.m2505o(93069);
    }

    /* renamed from: kw */
    public static void m10679kw(String str) {
        AppMethodBeat.m2504i(93068);
        C4990ab.m7416i("MicroMsg.CConstants", "initSdCardPath start SDCARD_ROOT: " + eSl);
        if (C5046bo.isNullOrNil(str)) {
            int i;
            ArrayList dpo = C5034bd.dpo();
            int size = dpo.size();
            for (i = 0; i < size; i++) {
                C4990ab.m7416i("MicroMsg.CConstants", "initSdCardPath start list i = " + i + " StatMountParse: " + dpo.get(i));
            }
            if (size > 1) {
                Collections.sort(dpo, new C14441());
            }
            if (!(size <= 0 || dpo.get(0) == null || C5046bo.isNullOrNil(((C5033a) dpo.get(0)).xBt))) {
                eSl = ((C5033a) dpo.get(0)).xBt;
                for (i = 0; i < size; i++) {
                    C4990ab.m7416i("MicroMsg.CConstants", "initSdCardPath end list i = " + i + " StatMountParse: " + dpo.get(i));
                }
            }
        } else {
            eSl = str;
        }
        eSn = eSl + eSm;
        euQ = eSn + "Download/";
        euS = eSn + "vusericon/";
        euT = eSn + "Game/";
        euU = eSn + "CDNTemp/";
        euW = eSn + "watchdog/";
        euX = eSn + "xlog";
        eSo = eSn + "crash/";
        euY = eSn + "avatar/";
        evi = eSn + "Cache/";
        String str2 = eSn + "WeChat/";
        String str3 = eSn + "WeiXin/";
        if (C1173e.m2561ct(str2) || !(C1173e.m2561ct(str3) || C4988aa.dor().equals("zh_CN"))) {
            str3 = str2;
        }
        euR = str3;
        C4990ab.m7416i("MicroMsg.CConstants", "initSdCardPath end SDCARD_ROOT: " + eSl);
        AppMethodBeat.m2505o(93068);
    }
}
