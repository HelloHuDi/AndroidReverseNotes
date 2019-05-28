package com.tencent.mm.plugin.appbrand.report.model;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.aw;
import com.tencent.mm.plugin.appbrand.jsapi.bi;
import com.tencent.mm.plugin.appbrand.jsapi.bl;
import com.tencent.mm.plugin.appbrand.jsapi.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.h;
import com.tencent.mm.plugin.appbrand.jsapi.g.p;
import com.tencent.mm.plugin.appbrand.jsapi.g.v;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.k;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo;
import com.tencent.mm.plugin.appbrand.jsapi.o.g;
import com.tencent.mm.plugin.appbrand.jsapi.storage.i;
import com.tencent.mm.plugin.appbrand.jsapi.storage.l;
import com.tencent.mm.plugin.appbrand.jsapi.storage.n;
import com.tencent.mm.plugin.appbrand.jsapi.storage.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j {
    private static final Set<String> iBn = new HashSet();
    private static final String[] iBo = new String[]{com.tencent.mm.plugin.appbrand.jsapi.g.b.NAME, c.NAME, d.NAME, e.NAME, com.tencent.mm.plugin.appbrand.jsapi.audio.d.NAME, com.tencent.mm.plugin.appbrand.jsapi.i.e.NAME, f.NAME, com.tencent.mm.plugin.appbrand.jsapi.audio.e.NAME, com.tencent.mm.plugin.appbrand.jsapi.k.a.NAME, com.tencent.mm.plugin.appbrand.jsapi.b.e.NAME, com.tencent.mm.plugin.appbrand.jsapi.audio.f.NAME, "getCurrentRoute", h.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.f.NAME, i.NAME, "getSystemInfo", "hideToast", p.NAME, "onAccelerometerChange", "onCompassChange", com.tencent.mm.plugin.appbrand.jsapi.d.h.a.NAME, "onMapRegionChange", "onSocketClose", "onSocketError", "onSocketMessage", "onSocketOpen", "onTouchEnd", "onTouchMove", "onTouchStart", "onVideoTimeUpdate", com.tencent.mm.plugin.appbrand.jsapi.audio.h.NAME, k.NAME, l.NAME, "reportIDKey", com.tencent.mm.plugin.appbrand.jsapi.o.f.NAME, g.NAME, n.NAME, o.NAME, "showModal", "showToast", "syncAudioEvent", com.tencent.mm.plugin.appbrand.jsapi.b.k.NAME, v.NAME, bl.NAME};
    private static final Set<String> iBp = new HashSet(Arrays.asList(iBo));
    private static final ThreadPoolExecutor iBq = new ThreadPoolExecutor(TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
        public final Thread newThread(Runnable runnable) {
            AppMethodBeat.i(132615);
            Thread a = com.tencent.mm.sdk.g.d.a(runnable, "AppBrandJsApiInvokeReportWorkerThread", 1);
            if (a.isDaemon()) {
                a.setDaemon(false);
            }
            AppMethodBeat.o(132615);
            return a;
        }
    }) {
        /* Access modifiers changed, original: protected|final */
        public final void afterExecute(Runnable runnable, Throwable th) {
            AppMethodBeat.i(132616);
            super.afterExecute(runnable, th);
            if (runnable instanceof a) {
                j.iBr.a((a) runnable);
            }
            AppMethodBeat.o(132616);
        }
    };
    private static final b iBr = new b();
    private static final Pattern iBs = Pattern.compile(".*\"errMsg\":\"[^:]+:([^\"]+)\".*");

    static final class b implements android.support.v4.f.k.a<a> {
        private final Queue<a> cnx;

        private b() {
            AppMethodBeat.i(132620);
            this.cnx = new ConcurrentLinkedQueue();
            AppMethodBeat.o(132620);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final /* synthetic */ Object aA() {
            AppMethodBeat.i(132624);
            a aLu = aLu();
            AppMethodBeat.o(132624);
            return aLu;
        }

        public final /* synthetic */ boolean release(Object obj) {
            AppMethodBeat.i(132623);
            boolean a = a((a) obj);
            AppMethodBeat.o(132623);
            return a;
        }

        public final a aLu() {
            AppMethodBeat.i(132621);
            a aVar = (a) this.cnx.poll();
            if (aVar == null) {
                aVar = new a();
                AppMethodBeat.o(132621);
                return aVar;
            }
            AppMethodBeat.o(132621);
            return aVar;
        }

        public final boolean a(a aVar) {
            AppMethodBeat.i(132622);
            boolean offer = this.cnx.offer(aVar);
            AppMethodBeat.o(132622);
            return offer;
        }
    }

    static final class a implements Runnable {
        String appId;
        String cBp;
        String csu;
        String hAP;
        String iBt;
        int iBu;
        long iBv;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        private String aLt() {
            AppMethodBeat.i(132618);
            String str = "";
            if (bo.isNullOrNil(this.cBp) || bo.isNullOrNil(this.iBt)) {
                AppMethodBeat.o(132618);
            } else {
                try {
                    String str2 = this.iBt;
                    int i = -1;
                    switch (str2.hashCode()) {
                        case -316023509:
                            if (str2.equals(com.tencent.mm.plugin.appbrand.jsapi.e.g.NAME)) {
                                i = 0;
                                break;
                            }
                            break;
                    }
                    switch (i) {
                        case 0:
                            com.tencent.mm.aa.c lx = com.tencent.mm.aa.h.lx(this.cBp);
                            str = String.format("%s;%s;%s;%s;%s;%s;%s", new Object[]{lx.optString("latitude"), lx.optString("longitude"), lx.optString("speed"), lx.optString("accuracy"), lx.optString("altitude"), lx.optString("verticalAccuracy"), lx.optString("horizontalAccuracy")});
                            break;
                    }
                } catch (com.tencent.mm.aa.g e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e, "get keyParam error!", new Object[0]);
                }
                AppMethodBeat.o(132618);
            }
            return str;
        }

        private String b(com.tencent.mm.aa.c cVar) {
            AppMethodBeat.i(132619);
            com.tencent.mm.aa.i iVar = new com.tencent.mm.aa.i();
            try {
                String str = this.iBt;
                int i = -1;
                switch (str.hashCode()) {
                    case -1701611132:
                        if (str.equals(JsApiChooseImage.NAME)) {
                            i = 0;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        iVar.g("sizeType", cVar.optString("sizeType"));
                        break;
                }
            } catch (com.tencent.mm.aa.g e) {
                ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e, "get keyParam error!", new Object[0]);
            }
            String str2 = null;
            try {
                str2 = URLEncoder.encode(iVar.toString(), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
            }
            AppMethodBeat.o(132619);
            return str2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:46:0x0146  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0154  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            String str;
            Throwable e;
            String aLt;
            String str2;
            String str3;
            String str4;
            String str5;
            String nullAsNil;
            int DF;
            String nullAsNil2;
            String cV;
            AppBrandSysConfigWC wJ;
            AppMethodBeat.i(132617);
            AppBrandStatObject wK = com.tencent.mm.plugin.appbrand.a.wK(this.appId);
            if (wK == null) {
                ab.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "statObject is Null!");
                AppMethodBeat.o(132617);
                return;
            }
            if (!j.iBp.contains(this.iBt)) {
                str = "";
                String str6 = "";
                if (!(bo.isNullOrNil(this.hAP) || bo.isNullOrNil(this.iBt))) {
                    try {
                        com.tencent.mm.aa.c lx = com.tencent.mm.aa.h.lx(this.hAP);
                        String b = b(lx);
                        try {
                            if (lx.has("url") && (this.iBt.equals(aw.NAME) || this.iBt.equals(com.tencent.mm.plugin.appbrand.jsapi.k.j.NAME) || this.iBt.equals(com.tencent.mm.plugin.appbrand.jsapi.k.h.NAME) || this.iBt.equals(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID) || this.iBt.equals("connectSocket") || this.iBt.equals("uploadFile") || this.iBt.equals("downloadFile"))) {
                                str = lx.optString("url");
                                str6 = b;
                            } else if (this.iBt.equals("authorize")) {
                                try {
                                    com.tencent.mm.aa.a ly = com.tencent.mm.aa.h.ly(lx.optString("scope"));
                                    LinkedList linkedList = new LinkedList();
                                    for (int i = 0; i < ly.length(); i++) {
                                        linkedList.add(ly.optString(i));
                                    }
                                    str = linkedList.toString();
                                    str6 = b;
                                } catch (Exception e2) {
                                    ab.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "Exception %s", e2.getMessage());
                                    AppMethodBeat.o(132617);
                                    return;
                                }
                            } else if (this.iBt.equals(com.tencent.mm.plugin.appbrand.jsapi.share.c.NAME)) {
                                try {
                                    str = URLEncoder.encode(bo.nullAsNil(lx.toString()), "UTF-8");
                                    str6 = b;
                                } catch (UnsupportedEncodingException e3) {
                                    ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e3, "", new Object[0]);
                                    str6 = b;
                                }
                            } else if (this.iBt.equals(com.tencent.mm.plugin.appbrand.jsapi.l.e.NAME)) {
                                str = lx.optString("package");
                                str6 = b;
                            } else if (this.iBt.equals(bi.NAME)) {
                                str = com.tencent.mm.plugin.appbrand.n.xa(this.appId).gPc;
                                str6 = b;
                            } else if (this.iBt.equals(as.NAME)) {
                                str = lx.optString("phoneNumber");
                                str6 = b;
                            } else if (this.iBt.equals(JsApiChooseVideo.NAME)) {
                                str = lx.optString("maxDuration");
                                str6 = b;
                            } else if (this.iBt.equals(com.tencent.mm.plugin.appbrand.jsapi.t.h.NAME)) {
                                str = lx.optString("src");
                                try {
                                    str = URLEncoder.encode(lx.optString("src"), "UTF-8");
                                    str6 = b;
                                } catch (Exception e22) {
                                    ab.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e22.toString());
                                    str6 = b;
                                }
                            } else if (this.iBt.equals("showKeyboard")) {
                                str = lx.optString("confirmType");
                                str6 = b;
                            } else {
                                if (this.iBt.equals(com.tencent.mm.plugin.appbrand.jsapi.audio.k.NAME)) {
                                    str = lx.optString("volume");
                                    if (bo.isNullOrNil(str) || str.equalsIgnoreCase("1")) {
                                        com.tencent.mm.plugin.report.service.h.pYm.a(952, 1, 1, false);
                                        str6 = b;
                                    } else {
                                        com.tencent.mm.plugin.report.service.h.pYm.a(952, 0, 1, false);
                                    }
                                }
                                str6 = b;
                            }
                        } catch (com.tencent.mm.aa.g e4) {
                            e = e4;
                            str6 = b;
                        }
                    } catch (com.tencent.mm.aa.g e5) {
                        e = e5;
                    }
                }
                aLt = aLt();
                str2 = "";
                if (!bo.isNullOrNil(this.csu) && this.csu.contains(".html")) {
                    str2 = this.csu.substring(0, this.csu.lastIndexOf(".html") + 5);
                }
                str3 = "";
                try {
                    str3 = URLEncoder.encode(bo.nullAsNil(str2), "UTF-8");
                } catch (UnsupportedEncodingException e6) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e6, "encode page path error!", new Object[0]);
                }
                str4 = "";
                try {
                    str4 = URLEncoder.encode(bo.nullAsNil(str), "UTF-8");
                } catch (UnsupportedEncodingException e7) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e7, "encode keyParam path error!", new Object[0]);
                }
                str5 = "";
                try {
                    str5 = URLEncoder.encode(bo.nullAsNil(aLt), "UTF-8");
                } catch (UnsupportedEncodingException e8) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e8, "encode keyResult path error!", new Object[0]);
                }
                nullAsNil = bo.nullAsNil(this.iBt);
                DF = j.DF(j.DE(this.cBp));
                nullAsNil2 = bo.nullAsNil(wK.cst);
                cV = com.tencent.mm.plugin.appbrand.report.c.cV(ah.getContext());
                if (wK.scene == 0) {
                    wK.scene = 1000;
                }
                wJ = com.tencent.mm.plugin.appbrand.a.wJ(this.appId);
                if (wJ != null) {
                    int i2 = wJ.hhd.gVu;
                    int i3 = wJ.hhd.gVt + 1;
                    int Dw = com.tencent.mm.plugin.appbrand.report.c.Dw(this.appId);
                    ab.d("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "jsapi invoke fields, scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d, appType %d, keyResult %s, keyRequest %s", Integer.valueOf(wK.scene), nullAsNil2, this.appId, Integer.valueOf(i2), Integer.valueOf(i3), str2, cV, nullAsNil, str, Integer.valueOf(DF), Integer.valueOf(this.iBu), Integer.valueOf(0), Long.valueOf(this.iBv), Integer.valueOf(0), r10, Integer.valueOf(wK.iAo), Integer.valueOf(Dw), aLt, str6);
                    Object[] objArr = new Object[]{Integer.valueOf(wK.scene), nullAsNil2, this.appId, Integer.valueOf(i2), Integer.valueOf(i3), str3, cV, nullAsNil, str4, Integer.valueOf(DF), Integer.valueOf(this.iBu), Integer.valueOf(0), Long.valueOf(this.iBv), Integer.valueOf(0), r10, Integer.valueOf(wK.iAo), Integer.valueOf(wK.cOq), wK.cOr, Integer.valueOf(Dw), str5, str6};
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    str2 = com.tencent.mm.plugin.report.service.h.s(objArr);
                    if (!ah.bqo()) {
                        com.tencent.mm.plugin.report.service.h.b(13542, str2, false, true);
                    } else if (com.tencent.mm.plugin.report.a.c.pXd) {
                        boolean z = com.tencent.mm.plugin.report.a.c.pXe;
                        com.tencent.mm.plugin.report.service.e.a(13542, str2, z, z, true);
                    } else {
                        com.tencent.mm.plugin.report.service.e.a(13542, str2, false, false, true);
                    }
                    if (j.iBn.contains(nullAsNil)) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(15761, objArr);
                    }
                }
            }
            AppMethodBeat.o(132617);
            ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e, "get keyParam error!", new Object[0]);
            aLt = aLt();
            str2 = "";
            str2 = this.csu.substring(0, this.csu.lastIndexOf(".html") + 5);
            str3 = "";
            str3 = URLEncoder.encode(bo.nullAsNil(str2), "UTF-8");
            str4 = "";
            str4 = URLEncoder.encode(bo.nullAsNil(str), "UTF-8");
            str5 = "";
            str5 = URLEncoder.encode(bo.nullAsNil(aLt), "UTF-8");
            nullAsNil = bo.nullAsNil(this.iBt);
            DF = j.DF(j.DE(this.cBp));
            nullAsNil2 = bo.nullAsNil(wK.cst);
            cV = com.tencent.mm.plugin.appbrand.report.c.cV(ah.getContext());
            if (wK.scene == 0) {
            }
            wJ = com.tencent.mm.plugin.appbrand.a.wJ(this.appId);
            if (wJ != null) {
            }
            AppMethodBeat.o(132617);
        }
    }

    public static void aLp() {
    }

    static {
        InputStream open;
        AppMethodBeat.i(132629);
        try {
            open = ah.getContext().getAssets().open("15007_api_list.txt");
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e, "open read 15007_api_list.txt", new Object[0]);
            open = null;
        }
        if (open != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(open);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!bo.isNullOrNil(readLine)) {
                        iBn.add(readLine);
                    }
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e2, "readLine()", new Object[0]);
                    bo.b(bufferedReader);
                    bo.b(inputStreamReader);
                } catch (Throwable th) {
                    bo.b(bufferedReader);
                    bo.b(inputStreamReader);
                    AppMethodBeat.o(132629);
                }
            }
            bo.b(bufferedReader);
            bo.b(inputStreamReader);
        }
        AppMethodBeat.o(132629);
    }

    public static boolean DD(String str) {
        AppMethodBeat.i(132625);
        if (iBp.contains(str)) {
            AppMethodBeat.o(132625);
            return true;
        }
        AppMethodBeat.o(132625);
        return false;
    }

    public static void a(String str, String str2, String str3, String str4, int i, long j, String str5) {
        AppMethodBeat.i(132626);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(132626);
            return;
        }
        a aLu = iBr.aLu();
        aLu.appId = str;
        aLu.csu = str2;
        aLu.iBt = str3;
        aLu.hAP = str4;
        aLu.iBu = i;
        aLu.iBv = j;
        aLu.cBp = str5;
        iBq.submit(aLu);
        AppMethodBeat.o(132626);
    }

    public static String DE(String str) {
        AppMethodBeat.i(132627);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(132627);
            return str2;
        }
        Matcher matcher = iBs.matcher(str);
        if (matcher.matches()) {
            str2 = bo.nullAsNil(matcher.group(1));
            AppMethodBeat.o(132627);
            return str2;
        }
        str2 = "";
        AppMethodBeat.o(132627);
        return str2;
    }

    static /* synthetic */ int DF(String str) {
        AppMethodBeat.i(132628);
        if (bo.isNullOrNil(str) || str.startsWith("ok") || !str.startsWith("fail")) {
            AppMethodBeat.o(132628);
            return 1;
        }
        AppMethodBeat.o(132628);
        return 2;
    }
}
