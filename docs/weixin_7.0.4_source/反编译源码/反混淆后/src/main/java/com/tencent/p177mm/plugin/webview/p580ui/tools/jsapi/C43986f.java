package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.fts.PreLoadWebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C2299223;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C4397733;
import com.tencent.p177mm.plugin.webview.preload.C43924a;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.xweb.WebView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.Map;
import org.apache.commons.p1431a.C31203c;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.f */
public final class C43986f {
    private static int uFW = -1;
    private static String uFX = null;
    private static final String uFY = (C1761b.eSj + "/jscache/");
    private static String uGa = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    private C46434d icy;
    public boolean uCf;
    private C35691a uFS;
    private boolean uFT;
    public boolean uFU;
    public String uFV;
    private final C7564ap uFZ;
    private C44786d uhz;
    private WebView urJ;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.f$4 */
    class C72284 implements C5015a {
        C72284() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(9023);
            C43986f.m78914b(C43986f.this);
            C43986f.m78915c(C43986f.this);
            AppMethodBeat.m2505o(9023);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.f$a */
    public interface C35691a {
        void aYk();
    }

    public C43986f(WebView webView, C44786d c44786d, C35691a c35691a) {
        this(webView, null, c44786d, c35691a, true);
    }

    public C43986f(WebView webView, C46434d c46434d, C44786d c44786d, C35691a c35691a, boolean z) {
        this(webView, c46434d, c44786d, c35691a, z, false);
    }

    public C43986f(WebView webView, C46434d c46434d, C44786d c44786d, C35691a c35691a, boolean z, boolean z2) {
        AppMethodBeat.m2504i(9024);
        this.uFT = false;
        this.uFU = false;
        this.uFV = null;
        this.uFZ = new C7564ap(new C72284(), true);
        this.urJ = webView;
        this.icy = c46434d;
        this.uhz = c44786d;
        this.uFS = c35691a;
        this.uFT = z;
        this.uCf = z2;
        C4990ab.m7411d("MicroMsg.JsLoader", "JsLoader <init>, withoutDelay = %b,isWebViewPreload %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        C4990ab.m7417i("MicroMsg.JsLoader", "JsLoader <init>, jsapi: %d, this: %d", Integer.valueOf(c44786d.hashCode()), Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(9024);
    }

    public final void detach() {
        AppMethodBeat.m2504i(9025);
        C4990ab.m7418v("MicroMsg.JsLoader", "detach");
        this.urJ = null;
        this.uhz = null;
        this.uFS = null;
        AppMethodBeat.m2505o(9025);
    }

    public final void dbY() {
        AppMethodBeat.m2504i(9026);
        C4990ab.m7418v("MicroMsg.JsLoader", "onPageStarted");
        dct();
        if (this.uhz != null) {
            this.uhz.mo71939nZ(false);
        }
        AppMethodBeat.m2505o(9026);
    }

    public final void dbZ() {
        AppMethodBeat.m2504i(9027);
        C4990ab.m7418v("MicroMsg.JsLoader", "onPageFinished");
        dcs();
        AppMethodBeat.m2505o(9027);
    }

    public final void dcq() {
        this.uCf = false;
    }

    static {
        AppMethodBeat.m2504i(9036);
        AppMethodBeat.m2505o(9036);
    }

    /* renamed from: c */
    public static boolean m78916c(WebView webView) {
        AppMethodBeat.m2504i(9028);
        if (uFW == -1) {
            uFW = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_android_xweb_code_cache, 0);
        }
        if (((uFW & 1) != 0 || C5058f.IS_FLAVOR_RED || C5058f.DEBUG) && webView.supportFeature(2002)) {
            AppMethodBeat.m2505o(9028);
            return true;
        }
        AppMethodBeat.m2505o(9028);
        return false;
    }

    private String dcr() {
        AppMethodBeat.m2504i(9029);
        C4990ab.m7417i("MicroMsg.JsLoader", "WXJS: %s", "jsapi/wxjs.js");
        String str;
        try {
            str = new String(C31203c.toByteArray(C4996ah.getContext().getAssets().open("jsapi/wxjs.js")));
            if (!TextUtils.isEmpty(this.uhz.uFw)) {
                C4990ab.m7417i("MicroMsg.JsLoader", "getWXJS, ranDomStr = %s, jsapi: %d, jsLoader: %d", this.uhz.uFw, Integer.valueOf(this.uhz.hashCode()), Integer.valueOf(hashCode()));
                str = str.replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.uhz.uFw).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true");
            }
            AppMethodBeat.m2505o(9029);
            return str;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", e);
            str = "";
            AppMethodBeat.m2505o(9029);
            return str;
        }
    }

    private String agu(String str) {
        String str2;
        AppMethodBeat.m2504i(9030);
        C4990ab.m7417i("MicroMsg.JsLoader", "tryCopyAsset: %s", str);
        if (uFX != null) {
            str2 = uFX;
        } else {
            str2 = C5058f.REV.substring(0, Math.min(C5058f.REV.length(), 8));
            uFX = str2;
        }
        String str3 = uFY + str2 + "/" + str;
        if (C1173e.m2561ct(str3)) {
            AppMethodBeat.m2505o(9030);
            return str3;
        }
        C43924a.m78789ae(86, 1);
        File[] listFiles = new File(uFY).listFiles(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                AppMethodBeat.m2504i(9022);
                if (str.equals(str2)) {
                    AppMethodBeat.m2505o(9022);
                    return false;
                }
                AppMethodBeat.m2505o(9022);
                return true;
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            for (File t : listFiles) {
                C1173e.m2575t(t);
            }
        }
        C1173e.m2565cx(str3);
        try {
            C43986f.m78917hm(str, str3);
            C43924a.m78789ae(87, 1);
            AppMethodBeat.m2505o(9030);
            return str3;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsLoader", "tryCopyAsset, failed, ", e);
            AppMethodBeat.m2505o(9030);
            return null;
        }
    }

    /* renamed from: hm */
    private static void m78917hm(String str, String str2) {
        AppMethodBeat.m2504i(9031);
        InputStream open = C4996ah.getContext().getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                open.close();
                fileOutputStream.close();
                C4990ab.m7416i("MicroMsg.JsLoader", "copy asset to:".concat(String.valueOf(str2)));
                AppMethodBeat.m2505o(9031);
                return;
            }
        }
    }

    public final void dcs() {
        AppMethodBeat.m2504i(9032);
        if (this.uFZ.doT()) {
            long j;
            if (!this.uFT) {
                try {
                    if (this.icy.mo15575g(106, null) != null) {
                        this.uFT = true;
                    }
                } catch (Exception e) {
                }
            }
            C7564ap c7564ap = this.uFZ;
            if (this.uFT) {
                j = 0;
            } else {
                j = 1000;
            }
            c7564ap.mo16770ae(j, j);
            C4990ab.m7417i("MicroMsg.JsLoader", "tryStartTimer success %b", Boolean.valueOf(this.uFT));
            AppMethodBeat.m2505o(9032);
            return;
        }
        C4990ab.m7416i("MicroMsg.JsLoader", "timer running");
        AppMethodBeat.m2505o(9032);
    }

    private void dct() {
        AppMethodBeat.m2504i(9033);
        if (!this.uFZ.doT()) {
            this.uFZ.stopTimer();
            C4990ab.m7416i("MicroMsg.JsLoader", "tryStopTimer success");
        }
        AppMethodBeat.m2505o(9033);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    static /* synthetic */ void m78914b(C43986f c43986f) {
        boolean z;
        AppMethodBeat.m2504i(9034);
        if (c43986f.uCf) {
            C4990ab.m7416i("MicroMsg.JsLoader", "jsapi init done by preload");
            if (c43986f.uhz != null) {
                c43986f.uhz.mo71939nZ(true);
            }
            z = true;
        } else if (c43986f.urJ == null || c43986f.uhz == null) {
            C4990ab.m7412e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
            z = false;
        } else {
            C44786d c44786d;
            Map dbP;
            final long currentTimeMillis = System.currentTimeMillis();
            if (C43986f.m78916c(c43986f.urJ)) {
                String agu = c43986f.agu("jsapi/wxjs.js");
                if (agu != null) {
                    C43924a.m78789ae(84, 1);
                    c43986f.urJ.evaluateJavascript(new C40342m(agu).toString(), new ValueCallback<String>() {
                        public final /* synthetic */ void onReceiveValue(Object obj) {
                            AppMethodBeat.m2504i(9020);
                            String str = (String) obj;
                            C43924a.m78789ae(81, System.currentTimeMillis() - currentTimeMillis);
                            if (str != null && str.contains("succ")) {
                                C43924a.m78789ae(85, 1);
                            }
                            C4990ab.m7417i("MicroMsg.JsLoader", "loadJavaScript with WebCodeCache, evaluateJavascript cb, ret: %s, cost: %dms", str, Long.valueOf(r0));
                            AppMethodBeat.m2505o(9020);
                        }
                    });
                    c44786d = c43986f.uhz;
                    C4990ab.m7418v("MicroMsg.JsApiHandler", "jsapi init");
                    c44786d.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("sys:init", c44786d.uFs, c44786d.uFv, c44786d.uFw) + ")", new C2299223());
                    c44786d.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("sys:bridged", null, c44786d.uFv, c44786d.uFw) + ")", new C4397733());
                    c44786d.mo71939nZ(true);
                    c44786d.dcj();
                    if (!(C5046bo.isNullOrNil(c44786d.uFB) || c44786d.uFo == null)) {
                        c44786d.uFo.evaluateJavascript(c44786d.mo71919dM(c44786d.uFB, c44786d.uFC), null);
                        c44786d.uFB = null;
                        c44786d.uFC = 0;
                    }
                    if (c44786d.uFo.getContext() instanceof MutableContextWrapper) {
                        Context baseContext = ((MutableContextWrapper) c44786d.uFo.getContext()).getBaseContext();
                        if (baseContext instanceof PreLoadWebViewUI) {
                            dbP = ((PreLoadWebViewUI) baseContext).dbP();
                            c44786d.mo71894aK(dbP);
                            C4990ab.m7416i("MicroMsg.JsLoader", "jsapi init done");
                            z = true;
                        } else {
                            C4990ab.m7417i("MicroMsg.JsApiHandler", "webview.context is not PreloadWebviewUI， %s", baseContext.toString());
                        }
                    }
                    dbP = null;
                    c44786d.mo71894aK(dbP);
                    C4990ab.m7416i("MicroMsg.JsLoader", "jsapi init done");
                    z = true;
                }
            }
            C43924a.m78789ae(82, 1);
            c43986f.urJ.evaluateJavascript(c43986f.dcr(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.m2504i(9021);
                    String str = (String) obj;
                    C43924a.m78789ae(80, System.currentTimeMillis() - currentTimeMillis);
                    if (str != null && str.contains("succ")) {
                        C43924a.m78789ae(83, 1);
                    }
                    C4990ab.m7417i("MicroMsg.JsLoader", "loadJavaScript, evaluateJavascript cb, ret: %s, cost: %dms", str, Long.valueOf(r0));
                    AppMethodBeat.m2505o(9021);
                }
            });
            c44786d = c43986f.uhz;
            C4990ab.m7418v("MicroMsg.JsApiHandler", "jsapi init");
            c44786d.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("sys:init", c44786d.uFs, c44786d.uFv, c44786d.uFw) + ")", new C2299223());
            c44786d.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + C23124a.m35500b("sys:bridged", null, c44786d.uFv, c44786d.uFw) + ")", new C4397733());
            c44786d.mo71939nZ(true);
            c44786d.dcj();
            c44786d.uFo.evaluateJavascript(c44786d.mo71919dM(c44786d.uFB, c44786d.uFC), null);
            c44786d.uFB = null;
            c44786d.uFC = 0;
            if (c44786d.uFo.getContext() instanceof MutableContextWrapper) {
            }
            dbP = null;
            c44786d.mo71894aK(dbP);
            C4990ab.m7416i("MicroMsg.JsLoader", "jsapi init done");
            z = true;
        }
        C4990ab.m7417i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", Boolean.valueOf(z));
        if (z && c43986f.uFS != null) {
            c43986f.uFS.aYk();
        }
        C7060h.pYm.mo8378a(156, 1, 1, false);
        if (!z) {
            C7060h.pYm.mo8378a(156, 0, 1, false);
        }
        AppMethodBeat.m2505o(9034);
    }
}
