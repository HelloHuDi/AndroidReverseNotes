package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.Map;
import org.apache.commons.a.c;

public final class f {
    private static int uFW = -1;
    private static String uFX = null;
    private static final String uFY = (b.eSj + "/jscache/");
    private static String uGa = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    private d icy;
    public boolean uCf;
    private a uFS;
    private boolean uFT;
    public boolean uFU;
    public String uFV;
    private final ap uFZ;
    private d uhz;
    private WebView urJ;

    public interface a {
        void aYk();
    }

    public f(WebView webView, d dVar, a aVar) {
        this(webView, null, dVar, aVar, true);
    }

    public f(WebView webView, d dVar, d dVar2, a aVar, boolean z) {
        this(webView, dVar, dVar2, aVar, z, false);
    }

    public f(WebView webView, d dVar, d dVar2, a aVar, boolean z, boolean z2) {
        AppMethodBeat.i(9024);
        this.uFT = false;
        this.uFU = false;
        this.uFV = null;
        this.uFZ = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(9023);
                f.b(f.this);
                f.c(f.this);
                AppMethodBeat.o(9023);
                return false;
            }
        }, true);
        this.urJ = webView;
        this.icy = dVar;
        this.uhz = dVar2;
        this.uFS = aVar;
        this.uFT = z;
        this.uCf = z2;
        ab.d("MicroMsg.JsLoader", "JsLoader <init>, withoutDelay = %b,isWebViewPreload %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        ab.i("MicroMsg.JsLoader", "JsLoader <init>, jsapi: %d, this: %d", Integer.valueOf(dVar2.hashCode()), Integer.valueOf(hashCode()));
        AppMethodBeat.o(9024);
    }

    public final void detach() {
        AppMethodBeat.i(9025);
        ab.v("MicroMsg.JsLoader", "detach");
        this.urJ = null;
        this.uhz = null;
        this.uFS = null;
        AppMethodBeat.o(9025);
    }

    public final void dbY() {
        AppMethodBeat.i(9026);
        ab.v("MicroMsg.JsLoader", "onPageStarted");
        dct();
        if (this.uhz != null) {
            this.uhz.nZ(false);
        }
        AppMethodBeat.o(9026);
    }

    public final void dbZ() {
        AppMethodBeat.i(9027);
        ab.v("MicroMsg.JsLoader", "onPageFinished");
        dcs();
        AppMethodBeat.o(9027);
    }

    public final void dcq() {
        this.uCf = false;
    }

    static {
        AppMethodBeat.i(9036);
        AppMethodBeat.o(9036);
    }

    public static boolean c(WebView webView) {
        AppMethodBeat.i(9028);
        if (uFW == -1) {
            uFW = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_android_xweb_code_cache, 0);
        }
        if (((uFW & 1) != 0 || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.DEBUG) && webView.supportFeature(2002)) {
            AppMethodBeat.o(9028);
            return true;
        }
        AppMethodBeat.o(9028);
        return false;
    }

    private String dcr() {
        AppMethodBeat.i(9029);
        ab.i("MicroMsg.JsLoader", "WXJS: %s", "jsapi/wxjs.js");
        String str;
        try {
            str = new String(c.toByteArray(ah.getContext().getAssets().open("jsapi/wxjs.js")));
            if (!TextUtils.isEmpty(this.uhz.uFw)) {
                ab.i("MicroMsg.JsLoader", "getWXJS, ranDomStr = %s, jsapi: %d, jsLoader: %d", this.uhz.uFw, Integer.valueOf(this.uhz.hashCode()), Integer.valueOf(hashCode()));
                str = str.replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.uhz.uFw).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true");
            }
            AppMethodBeat.o(9029);
            return str;
        } catch (Exception e) {
            ab.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", e);
            str = "";
            AppMethodBeat.o(9029);
            return str;
        }
    }

    private String agu(String str) {
        String str2;
        AppMethodBeat.i(9030);
        ab.i("MicroMsg.JsLoader", "tryCopyAsset: %s", str);
        if (uFX != null) {
            str2 = uFX;
        } else {
            str2 = com.tencent.mm.sdk.platformtools.f.REV.substring(0, Math.min(com.tencent.mm.sdk.platformtools.f.REV.length(), 8));
            uFX = str2;
        }
        String str3 = uFY + str2 + "/" + str;
        if (e.ct(str3)) {
            AppMethodBeat.o(9030);
            return str3;
        }
        com.tencent.mm.plugin.webview.preload.a.ae(86, 1);
        File[] listFiles = new File(uFY).listFiles(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                AppMethodBeat.i(9022);
                if (str.equals(str2)) {
                    AppMethodBeat.o(9022);
                    return false;
                }
                AppMethodBeat.o(9022);
                return true;
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            for (File t : listFiles) {
                e.t(t);
            }
        }
        e.cx(str3);
        try {
            hm(str, str3);
            com.tencent.mm.plugin.webview.preload.a.ae(87, 1);
            AppMethodBeat.o(9030);
            return str3;
        } catch (Exception e) {
            ab.e("MicroMsg.JsLoader", "tryCopyAsset, failed, ", e);
            AppMethodBeat.o(9030);
            return null;
        }
    }

    private static void hm(String str, String str2) {
        AppMethodBeat.i(9031);
        InputStream open = ah.getContext().getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                open.close();
                fileOutputStream.close();
                ab.i("MicroMsg.JsLoader", "copy asset to:".concat(String.valueOf(str2)));
                AppMethodBeat.o(9031);
                return;
            }
        }
    }

    public final void dcs() {
        AppMethodBeat.i(9032);
        if (this.uFZ.doT()) {
            long j;
            if (!this.uFT) {
                try {
                    if (this.icy.g(106, null) != null) {
                        this.uFT = true;
                    }
                } catch (Exception e) {
                }
            }
            ap apVar = this.uFZ;
            if (this.uFT) {
                j = 0;
            } else {
                j = 1000;
            }
            apVar.ae(j, j);
            ab.i("MicroMsg.JsLoader", "tryStartTimer success %b", Boolean.valueOf(this.uFT));
            AppMethodBeat.o(9032);
            return;
        }
        ab.i("MicroMsg.JsLoader", "timer running");
        AppMethodBeat.o(9032);
    }

    private void dct() {
        AppMethodBeat.i(9033);
        if (!this.uFZ.doT()) {
            this.uFZ.stopTimer();
            ab.i("MicroMsg.JsLoader", "tryStopTimer success");
        }
        AppMethodBeat.o(9033);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(f fVar) {
        boolean z;
        AppMethodBeat.i(9034);
        if (fVar.uCf) {
            ab.i("MicroMsg.JsLoader", "jsapi init done by preload");
            if (fVar.uhz != null) {
                fVar.uhz.nZ(true);
            }
            z = true;
        } else if (fVar.urJ == null || fVar.uhz == null) {
            ab.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
            z = false;
        } else {
            d dVar;
            Map dbP;
            final long currentTimeMillis = System.currentTimeMillis();
            if (c(fVar.urJ)) {
                String agu = fVar.agu("jsapi/wxjs.js");
                if (agu != null) {
                    com.tencent.mm.plugin.webview.preload.a.ae(84, 1);
                    fVar.urJ.evaluateJavascript(new m(agu).toString(), new ValueCallback<String>() {
                        public final /* synthetic */ void onReceiveValue(Object obj) {
                            AppMethodBeat.i(9020);
                            String str = (String) obj;
                            com.tencent.mm.plugin.webview.preload.a.ae(81, System.currentTimeMillis() - currentTimeMillis);
                            if (str != null && str.contains("succ")) {
                                com.tencent.mm.plugin.webview.preload.a.ae(85, 1);
                            }
                            ab.i("MicroMsg.JsLoader", "loadJavaScript with WebCodeCache, evaluateJavascript cb, ret: %s, cost: %dms", str, Long.valueOf(r0));
                            AppMethodBeat.o(9020);
                        }
                    });
                    dVar = fVar.uhz;
                    ab.v("MicroMsg.JsApiHandler", "jsapi init");
                    dVar.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("sys:init", dVar.uFs, dVar.uFv, dVar.uFw) + ")", new ValueCallback<String>() {
                        public final /* synthetic */ void onReceiveValue(Object obj) {
                            AppMethodBeat.i(8886);
                            ab.i("MicroMsg.JsApiHandler", "sys:init back %s\t", (String) obj);
                            AppMethodBeat.o(8886);
                        }
                    });
                    dVar.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("sys:bridged", null, dVar.uFv, dVar.uFw) + ")", new ValueCallback<String>() {
                        public final /* synthetic */ void onReceiveValue(Object obj) {
                            AppMethodBeat.i(8896);
                            ab.i("MicroMsg.JsApiHandler", "sys:bridged back %s\t", (String) obj);
                            AppMethodBeat.o(8896);
                        }
                    });
                    dVar.nZ(true);
                    dVar.dcj();
                    if (!(bo.isNullOrNil(dVar.uFB) || dVar.uFo == null)) {
                        dVar.uFo.evaluateJavascript(dVar.dM(dVar.uFB, dVar.uFC), null);
                        dVar.uFB = null;
                        dVar.uFC = 0;
                    }
                    if (dVar.uFo.getContext() instanceof MutableContextWrapper) {
                        Context baseContext = ((MutableContextWrapper) dVar.uFo.getContext()).getBaseContext();
                        if (baseContext instanceof PreLoadWebViewUI) {
                            dbP = ((PreLoadWebViewUI) baseContext).dbP();
                            dVar.aK(dbP);
                            ab.i("MicroMsg.JsLoader", "jsapi init done");
                            z = true;
                        } else {
                            ab.i("MicroMsg.JsApiHandler", "webview.context is not PreloadWebviewUI， %s", baseContext.toString());
                        }
                    }
                    dbP = null;
                    dVar.aK(dbP);
                    ab.i("MicroMsg.JsLoader", "jsapi init done");
                    z = true;
                }
            }
            com.tencent.mm.plugin.webview.preload.a.ae(82, 1);
            fVar.urJ.evaluateJavascript(fVar.dcr(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(9021);
                    String str = (String) obj;
                    com.tencent.mm.plugin.webview.preload.a.ae(80, System.currentTimeMillis() - currentTimeMillis);
                    if (str != null && str.contains("succ")) {
                        com.tencent.mm.plugin.webview.preload.a.ae(83, 1);
                    }
                    ab.i("MicroMsg.JsLoader", "loadJavaScript, evaluateJavascript cb, ret: %s, cost: %dms", str, Long.valueOf(r0));
                    AppMethodBeat.o(9021);
                }
            });
            dVar = fVar.uhz;
            ab.v("MicroMsg.JsApiHandler", "jsapi init");
            dVar.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("sys:init", dVar.uFs, dVar.uFv, dVar.uFw) + ")", /* anonymous class already generated */);
            dVar.uFo.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("sys:bridged", null, dVar.uFv, dVar.uFw) + ")", /* anonymous class already generated */);
            dVar.nZ(true);
            dVar.dcj();
            dVar.uFo.evaluateJavascript(dVar.dM(dVar.uFB, dVar.uFC), null);
            dVar.uFB = null;
            dVar.uFC = 0;
            if (dVar.uFo.getContext() instanceof MutableContextWrapper) {
            }
            dbP = null;
            dVar.aK(dbP);
            ab.i("MicroMsg.JsLoader", "jsapi init done");
            z = true;
        }
        ab.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", Boolean.valueOf(z));
        if (z && fVar.uFS != null) {
            fVar.uFS.aYk();
        }
        h.pYm.a(156, 1, 1, false);
        if (!z) {
            h.pYm.a(156, 0, 1, false);
        }
        AppMethodBeat.o(9034);
    }
}
