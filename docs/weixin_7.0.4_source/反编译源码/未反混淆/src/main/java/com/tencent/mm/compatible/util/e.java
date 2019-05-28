package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class e extends b {
    public static final String euO = h.getExternalStorageDirectory().getParent();
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

    static {
        AppMethodBeat.i(93069);
        AppMethodBeat.o(93069);
    }

    public static void kw(String str) {
        AppMethodBeat.i(93068);
        ab.i("MicroMsg.CConstants", "initSdCardPath start SDCARD_ROOT: " + eSl);
        if (bo.isNullOrNil(str)) {
            int i;
            ArrayList dpo = bd.dpo();
            int size = dpo.size();
            for (i = 0; i < size; i++) {
                ab.i("MicroMsg.CConstants", "initSdCardPath start list i = " + i + " StatMountParse: " + dpo.get(i));
            }
            if (size > 1) {
                Collections.sort(dpo, new Comparator<a>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        a aVar = (a) obj;
                        a aVar2 = (a) obj2;
                        long j = (aVar.xBx * aVar.xBy) - (aVar2.xBx * aVar2.xBy);
                        if (j < 0) {
                            return 1;
                        }
                        if (j > 0) {
                            return -1;
                        }
                        return 0;
                    }
                });
            }
            if (!(size <= 0 || dpo.get(0) == null || bo.isNullOrNil(((a) dpo.get(0)).xBt))) {
                eSl = ((a) dpo.get(0)).xBt;
                for (i = 0; i < size; i++) {
                    ab.i("MicroMsg.CConstants", "initSdCardPath end list i = " + i + " StatMountParse: " + dpo.get(i));
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
        if (com.tencent.mm.a.e.ct(str2) || !(com.tencent.mm.a.e.ct(str3) || aa.dor().equals("zh_CN"))) {
            str3 = str2;
        }
        euR = str3;
        ab.i("MicroMsg.CConstants", "initSdCardPath end SDCARD_ROOT: " + eSl);
        AppMethodBeat.o(93068);
    }
}
