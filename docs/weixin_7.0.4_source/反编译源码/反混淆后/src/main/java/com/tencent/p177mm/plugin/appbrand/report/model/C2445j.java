package com.tencent.p177mm.plugin.appbrand.report.model;

import android.support.p057v4.p065f.C37122k.C8387a;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C17868c;
import com.tencent.p177mm.p1174aa.C41723a;
import com.tencent.p177mm.p1174aa.C41724g;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.jsapi.C16635aw;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19327bi;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38274bl;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45573as;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C16633h;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C33242d;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C38261f;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C42473k;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C45574e;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseVideo;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1226o.C19461f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1226o.C19462g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19311e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C42479k;
import com.tencent.p177mm.plugin.appbrand.jsapi.p303d.C33289h.C33294a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19389c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C2292v;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C33323p;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44698h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C19400k;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C38309e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C45604f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C2300h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33340j;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C27106h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C19410e;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C27077c;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C24703l;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C27087n;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C38386o;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C42573f;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C45620i;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.report.p498a.C3730c;
import com.tencent.p177mm.plugin.report.service.C3744e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.j */
public final class C2445j {
    private static final Set<String> iBn = new HashSet();
    private static final String[] iBo = new String[]{C44697b.NAME, C19389c.NAME, C19392d.NAME, C19394e.NAME, C33242d.NAME, C38309e.NAME, C45604f.NAME, C45574e.NAME, C33333a.NAME, C19311e.NAME, C38261f.NAME, "getCurrentRoute", C44698h.NAME, C42573f.NAME, C45620i.NAME, "getSystemInfo", "hideToast", C33323p.NAME, "onAccelerometerChange", "onCompassChange", C33294a.NAME, "onMapRegionChange", "onSocketClose", "onSocketError", "onSocketMessage", "onSocketOpen", "onTouchEnd", "onTouchMove", "onTouchStart", "onVideoTimeUpdate", C16633h.NAME, C19400k.NAME, C24703l.NAME, "reportIDKey", C19461f.NAME, C19462g.NAME, C27087n.NAME, C38386o.NAME, "showModal", "showToast", "syncAudioEvent", C42479k.NAME, C2292v.NAME, C38274bl.NAME};
    private static final Set<String> iBp = new HashSet(Arrays.asList(iBo));
    private static final ThreadPoolExecutor iBq = new ThreadPoolExecutor(TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new C24471()) {
        /* Access modifiers changed, original: protected|final */
        public final void afterExecute(Runnable runnable, Throwable th) {
            AppMethodBeat.m2504i(132616);
            super.afterExecute(runnable, th);
            if (runnable instanceof C2449a) {
                C2445j.iBr.mo6363a((C2449a) runnable);
            }
            AppMethodBeat.m2505o(132616);
        }
    };
    private static final C2448b iBr = new C2448b();
    private static final Pattern iBs = Pattern.compile(".*\"errMsg\":\"[^:]+:([^\"]+)\".*");

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.j$1 */
    static class C24471 implements ThreadFactory {
        C24471() {
        }

        public final Thread newThread(Runnable runnable) {
            AppMethodBeat.m2504i(132615);
            Thread a = C7305d.m12285a(runnable, "AppBrandJsApiInvokeReportWorkerThread", 1);
            if (a.isDaemon()) {
                a.setDaemon(false);
            }
            AppMethodBeat.m2505o(132615);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.j$b */
    static final class C2448b implements C8387a<C2449a> {
        private final Queue<C2449a> cnx;

        private C2448b() {
            AppMethodBeat.m2504i(132620);
            this.cnx = new ConcurrentLinkedQueue();
            AppMethodBeat.m2505o(132620);
        }

        /* synthetic */ C2448b(byte b) {
            this();
        }

        /* renamed from: aA */
        public final /* synthetic */ Object mo6364aA() {
            AppMethodBeat.m2504i(132624);
            C2449a aLu = aLu();
            AppMethodBeat.m2505o(132624);
            return aLu;
        }

        public final /* synthetic */ boolean release(Object obj) {
            AppMethodBeat.m2504i(132623);
            boolean a = mo6363a((C2449a) obj);
            AppMethodBeat.m2505o(132623);
            return a;
        }

        public final C2449a aLu() {
            AppMethodBeat.m2504i(132621);
            C2449a c2449a = (C2449a) this.cnx.poll();
            if (c2449a == null) {
                c2449a = new C2449a();
                AppMethodBeat.m2505o(132621);
                return c2449a;
            }
            AppMethodBeat.m2505o(132621);
            return c2449a;
        }

        /* renamed from: a */
        public final boolean mo6363a(C2449a c2449a) {
            AppMethodBeat.m2504i(132622);
            boolean offer = this.cnx.offer(c2449a);
            AppMethodBeat.m2505o(132622);
            return offer;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.j$a */
    static final class C2449a implements Runnable {
        String appId;
        String cBp;
        String csu;
        String hAP;
        String iBt;
        int iBu;
        long iBv;

        private C2449a() {
        }

        /* synthetic */ C2449a(byte b) {
            this();
        }

        private String aLt() {
            AppMethodBeat.m2504i(132618);
            String str = "";
            if (C5046bo.isNullOrNil(this.cBp) || C5046bo.isNullOrNil(this.iBt)) {
                AppMethodBeat.m2505o(132618);
            } else {
                try {
                    String str2 = this.iBt;
                    int i = -1;
                    switch (str2.hashCode()) {
                        case -316023509:
                            if (str2.equals(C2275g.NAME)) {
                                i = 0;
                                break;
                            }
                            break;
                    }
                    switch (i) {
                        case 0:
                            C17868c lx = C41725h.m73458lx(this.cBp);
                            str = String.format("%s;%s;%s;%s;%s;%s;%s", new Object[]{lx.optString("latitude"), lx.optString("longitude"), lx.optString("speed"), lx.optString("accuracy"), lx.optString("altitude"), lx.optString("verticalAccuracy"), lx.optString("horizontalAccuracy")});
                            break;
                    }
                } catch (C41724g e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e, "get keyParam error!", new Object[0]);
                }
                AppMethodBeat.m2505o(132618);
            }
            return str;
        }

        /* renamed from: b */
        private String m4687b(C17868c c17868c) {
            AppMethodBeat.m2504i(132619);
            C41726i c41726i = new C41726i();
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
                        c41726i.mo67475g("sizeType", c17868c.optString("sizeType"));
                        break;
                }
            } catch (C41724g e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e, "get keyParam error!", new Object[0]);
            }
            String str2 = null;
            try {
                str2 = URLEncoder.encode(c41726i.toString(), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
            }
            AppMethodBeat.m2505o(132619);
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
            AppMethodBeat.m2504i(132617);
            AppBrandStatObject wK = C10048a.m17637wK(this.appId);
            if (wK == null) {
                C4990ab.m7412e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "statObject is Null!");
                AppMethodBeat.m2505o(132617);
                return;
            }
            if (!C2445j.iBp.contains(this.iBt)) {
                str = "";
                String str6 = "";
                if (!(C5046bo.isNullOrNil(this.hAP) || C5046bo.isNullOrNil(this.iBt))) {
                    try {
                        C17868c lx = C41725h.m73458lx(this.hAP);
                        String b = m4687b(lx);
                        try {
                            if (lx.has("url") && (this.iBt.equals(C16635aw.NAME) || this.iBt.equals(C33340j.NAME) || this.iBt.equals(C2300h.NAME) || this.iBt.equals(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID) || this.iBt.equals("connectSocket") || this.iBt.equals("uploadFile") || this.iBt.equals("downloadFile"))) {
                                str = lx.optString("url");
                                str6 = b;
                            } else if (this.iBt.equals("authorize")) {
                                try {
                                    C41723a ly = C41725h.m73459ly(lx.optString("scope"));
                                    LinkedList linkedList = new LinkedList();
                                    for (int i = 0; i < ly.length(); i++) {
                                        linkedList.add(ly.optString(i));
                                    }
                                    str = linkedList.toString();
                                    str6 = b;
                                } catch (Exception e2) {
                                    C4990ab.m7413e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "Exception %s", e2.getMessage());
                                    AppMethodBeat.m2505o(132617);
                                    return;
                                }
                            } else if (this.iBt.equals(C27077c.NAME)) {
                                try {
                                    str = URLEncoder.encode(C5046bo.nullAsNil(lx.toString()), "UTF-8");
                                    str6 = b;
                                } catch (UnsupportedEncodingException e3) {
                                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e3, "", new Object[0]);
                                    str6 = b;
                                }
                            } else if (this.iBt.equals(C19410e.NAME)) {
                                str = lx.optString("package");
                                str6 = b;
                            } else if (this.iBt.equals(C19327bi.NAME)) {
                                str = C38450n.m65048xa(this.appId).gPc;
                                str6 = b;
                            } else if (this.iBt.equals(C45573as.NAME)) {
                                str = lx.optString("phoneNumber");
                                str6 = b;
                            } else if (this.iBt.equals(JsApiChooseVideo.NAME)) {
                                str = lx.optString("maxDuration");
                                str6 = b;
                            } else if (this.iBt.equals(C27106h.NAME)) {
                                str = lx.optString("src");
                                try {
                                    str = URLEncoder.encode(lx.optString("src"), "UTF-8");
                                    str6 = b;
                                } catch (Exception e22) {
                                    C4990ab.m7412e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e22.toString());
                                    str6 = b;
                                }
                            } else if (this.iBt.equals("showKeyboard")) {
                                str = lx.optString("confirmType");
                                str6 = b;
                            } else {
                                if (this.iBt.equals(C42473k.NAME)) {
                                    str = lx.optString("volume");
                                    if (C5046bo.isNullOrNil(str) || str.equalsIgnoreCase("1")) {
                                        C7060h.pYm.mo8378a(952, 1, 1, false);
                                        str6 = b;
                                    } else {
                                        C7060h.pYm.mo8378a(952, 0, 1, false);
                                    }
                                }
                                str6 = b;
                            }
                        } catch (C41724g e4) {
                            e = e4;
                            str6 = b;
                        }
                    } catch (C41724g e5) {
                        e = e5;
                    }
                }
                aLt = aLt();
                str2 = "";
                if (!C5046bo.isNullOrNil(this.csu) && this.csu.contains(".html")) {
                    str2 = this.csu.substring(0, this.csu.lastIndexOf(".html") + 5);
                }
                str3 = "";
                try {
                    str3 = URLEncoder.encode(C5046bo.nullAsNil(str2), "UTF-8");
                } catch (UnsupportedEncodingException e6) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e6, "encode page path error!", new Object[0]);
                }
                str4 = "";
                try {
                    str4 = URLEncoder.encode(C5046bo.nullAsNil(str), "UTF-8");
                } catch (UnsupportedEncodingException e7) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e7, "encode keyParam path error!", new Object[0]);
                }
                str5 = "";
                try {
                    str5 = URLEncoder.encode(C5046bo.nullAsNil(aLt), "UTF-8");
                } catch (UnsupportedEncodingException e8) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e8, "encode keyResult path error!", new Object[0]);
                }
                nullAsNil = C5046bo.nullAsNil(this.iBt);
                DF = C2445j.m4683DF(C2445j.m4682DE(this.cBp));
                nullAsNil2 = C5046bo.nullAsNil(wK.cst);
                cV = C19690c.m30503cV(C4996ah.getContext());
                if (wK.scene == 0) {
                    wK.scene = 1000;
                }
                wJ = C10048a.m17636wJ(this.appId);
                if (wJ != null) {
                    int i2 = wJ.hhd.gVu;
                    int i3 = wJ.hhd.gVt + 1;
                    int Dw = C19690c.m30493Dw(this.appId);
                    C4990ab.m7411d("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "jsapi invoke fields, scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d, appType %d, keyResult %s, keyRequest %s", Integer.valueOf(wK.scene), nullAsNil2, this.appId, Integer.valueOf(i2), Integer.valueOf(i3), str2, cV, nullAsNil, str, Integer.valueOf(DF), Integer.valueOf(this.iBu), Integer.valueOf(0), Long.valueOf(this.iBv), Integer.valueOf(0), r10, Integer.valueOf(wK.iAo), Integer.valueOf(Dw), aLt, str6);
                    Object[] objArr = new Object[]{Integer.valueOf(wK.scene), nullAsNil2, this.appId, Integer.valueOf(i2), Integer.valueOf(i3), str3, cV, nullAsNil, str4, Integer.valueOf(DF), Integer.valueOf(this.iBu), Integer.valueOf(0), Long.valueOf(this.iBv), Integer.valueOf(0), r10, Integer.valueOf(wK.iAo), Integer.valueOf(wK.cOq), wK.cOr, Integer.valueOf(Dw), str5, str6};
                    C7060h c7060h = C7060h.pYm;
                    str2 = C7060h.m11804s(objArr);
                    if (!C4996ah.bqo()) {
                        C7060h.m11795b(13542, str2, false, true);
                    } else if (C3730c.pXd) {
                        boolean z = C3730c.pXe;
                        C3744e.m6058a(13542, str2, z, z, true);
                    } else {
                        C3744e.m6058a(13542, str2, false, false, true);
                    }
                    if (C2445j.iBn.contains(nullAsNil)) {
                        C7060h.pYm.mo8381e(15761, objArr);
                    }
                }
            }
            AppMethodBeat.m2505o(132617);
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e, "get keyParam error!", new Object[0]);
            aLt = aLt();
            str2 = "";
            str2 = this.csu.substring(0, this.csu.lastIndexOf(".html") + 5);
            str3 = "";
            str3 = URLEncoder.encode(C5046bo.nullAsNil(str2), "UTF-8");
            str4 = "";
            str4 = URLEncoder.encode(C5046bo.nullAsNil(str), "UTF-8");
            str5 = "";
            str5 = URLEncoder.encode(C5046bo.nullAsNil(aLt), "UTF-8");
            nullAsNil = C5046bo.nullAsNil(this.iBt);
            DF = C2445j.m4683DF(C2445j.m4682DE(this.cBp));
            nullAsNil2 = C5046bo.nullAsNil(wK.cst);
            cV = C19690c.m30503cV(C4996ah.getContext());
            if (wK.scene == 0) {
            }
            wJ = C10048a.m17636wJ(this.appId);
            if (wJ != null) {
            }
            AppMethodBeat.m2505o(132617);
        }
    }

    public static void aLp() {
    }

    static {
        InputStream open;
        AppMethodBeat.m2504i(132629);
        try {
            open = C4996ah.getContext().getAssets().open("15007_api_list.txt");
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e, "open read 15007_api_list.txt", new Object[0]);
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
                    } else if (!C5046bo.isNullOrNil(readLine)) {
                        iBn.add(readLine);
                    }
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e2, "readLine()", new Object[0]);
                    C5046bo.m7527b(bufferedReader);
                    C5046bo.m7527b(inputStreamReader);
                } catch (Throwable th) {
                    C5046bo.m7527b(bufferedReader);
                    C5046bo.m7527b(inputStreamReader);
                    AppMethodBeat.m2505o(132629);
                }
            }
            C5046bo.m7527b(bufferedReader);
            C5046bo.m7527b(inputStreamReader);
        }
        AppMethodBeat.m2505o(132629);
    }

    /* renamed from: DD */
    public static boolean m4681DD(String str) {
        AppMethodBeat.m2504i(132625);
        if (iBp.contains(str)) {
            AppMethodBeat.m2505o(132625);
            return true;
        }
        AppMethodBeat.m2505o(132625);
        return false;
    }

    /* renamed from: a */
    public static void m4684a(String str, String str2, String str3, String str4, int i, long j, String str5) {
        AppMethodBeat.m2504i(132626);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(132626);
            return;
        }
        C2449a aLu = iBr.aLu();
        aLu.appId = str;
        aLu.csu = str2;
        aLu.iBt = str3;
        aLu.hAP = str4;
        aLu.iBu = i;
        aLu.iBv = j;
        aLu.cBp = str5;
        iBq.submit(aLu);
        AppMethodBeat.m2505o(132626);
    }

    /* renamed from: DE */
    public static String m4682DE(String str) {
        AppMethodBeat.m2504i(132627);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(132627);
            return str2;
        }
        Matcher matcher = iBs.matcher(str);
        if (matcher.matches()) {
            str2 = C5046bo.nullAsNil(matcher.group(1));
            AppMethodBeat.m2505o(132627);
            return str2;
        }
        str2 = "";
        AppMethodBeat.m2505o(132627);
        return str2;
    }

    /* renamed from: DF */
    static /* synthetic */ int m4683DF(String str) {
        AppMethodBeat.m2504i(132628);
        if (C5046bo.isNullOrNil(str) || str.startsWith("ok") || !str.startsWith("fail")) {
            AppMethodBeat.m2505o(132628);
            return 1;
        }
        AppMethodBeat.m2505o(132628);
        return 2;
    }
}
