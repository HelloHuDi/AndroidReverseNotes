package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.k;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.m;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.s;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class e extends MMWebView {
    private s iuo;
    public TmplParams jRb;
    private int jUG;
    public String jVi;
    public int jVj;
    public String jVk;
    private boolean jVl;
    private LinkedList<Pair<String, ValueCallback<String>>> jVm;
    protected d jVn;

    static /* synthetic */ String a(e eVar) {
        AppMethodBeat.i(14444);
        String tagName = eVar.getTagName();
        AppMethodBeat.o(14444);
        return tagName;
    }

    static /* synthetic */ void a(e eVar, String str, ValueCallback valueCallback) {
        AppMethodBeat.i(14443);
        super.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(14443);
    }

    static /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(14445);
        eVar.aYi();
        AppMethodBeat.o(14445);
    }

    public e(Context context, TmplParams tmplParams) {
        super(context);
        AppMethodBeat.i(14436);
        this.jVm = new LinkedList();
        this.iuo = new s() {
            public final void b(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(14426);
                ab.i(e.a(e.this), "[onPageStarted] url:%s", str);
                super.b(webView, str, bitmap);
                e.this.jVl = false;
                AppMethodBeat.o(14426);
            }

            public final void b(WebView webView, String str) {
                AppMethodBeat.i(14427);
                ab.i(e.a(e.this), "[onPageFinished] url:%s", str);
                super.b(webView, str);
                e.b(e.this);
                e.this.jVl = true;
                e.this.aJq();
                AppMethodBeat.o(14427);
            }

            private o f(WebView webView, String str) {
                String str2;
                int i = 0;
                AppMethodBeat.i(14428);
                ab.i(e.a(e.this), "getResourceResponse, requrl:%s, url:%s", str, e.this.jVi);
                if (str.equals(e.this.jVi)) {
                    str2 = e.this.jVk;
                } else if (str.startsWith(b.aXB())) {
                    str2 = k.q(e.this.jRb.jSV, e.this.jRb.jSY, str.replaceFirst(b.aXB(), ""));
                    i = 1;
                } else if (str.startsWith(b.getPrefix())) {
                    str2 = k.q(e.this.jRb.jSV, e.this.jRb.jSY, str.replaceFirst(b.getPrefix(), ""));
                    i = 1;
                } else {
                    ab.e(e.a(e.this), "return null");
                    AppMethodBeat.o(14428);
                    return null;
                }
                ab.v(e.a(e.this), "response path:" + bo.bc(str2, BuildConfig.COMMAND));
                o g = g(webView, str2);
                if (g != null) {
                    ab.i(e.a(e.this), "return intercepted success");
                    AppMethodBeat.o(14428);
                    return g;
                }
                ab.e(e.a(e.this), "return intercepted null");
                a.e(e.this.jRb.upQ, 126, 1, true);
                if (i != 0) {
                    a.e(e.this.jRb.upQ, com.tencent.view.d.MIC_PTU_MEISHI, 1, true);
                }
                AppMethodBeat.o(14428);
                return null;
            }

            private o g(WebView webView, String str) {
                o oVar;
                Object obj = null;
                AppMethodBeat.i(14429);
                String ako = com.tencent.mm.sdk.f.b.ako(str);
                String str2 = "UTF-8";
                if (str.endsWith(".js") && f.c(webView)) {
                    obj = new m(str).toString();
                    oVar = new o(ako, str2, new ByteArrayInputStream(obj.getBytes(StandardCharsets.UTF_8)));
                } else {
                    InputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(str);
                    } catch (FileNotFoundException e) {
                        ab.printErrStackTrace(e.a(e.this), e, "", new Object[0]);
                        fileInputStream = null;
                    }
                    if (fileInputStream == null) {
                        ab.e(e.a(e.this), "stream is null, err");
                        AppMethodBeat.o(14429);
                        return null;
                    }
                    oVar = new o(ako, str2, fileInputStream);
                }
                HashMap hashMap = new HashMap();
                ako = Integer.toHexString(str.hashCode() & -1).toLowerCase();
                hashMap.put("Cache-Control", "max-age=31536000");
                hashMap.put("ETag", ako);
                if (obj != null) {
                    hashMap.put("RunLocalJS", obj);
                }
                oVar.mResponseHeaders = hashMap;
                ab.i("MicroMsg.TmplWxJsWebView", "readFileWebResp:%s\nETag:%s", str, ako);
                AppMethodBeat.o(14429);
                return oVar;
            }

            public final o c(WebView webView, String str) {
                AppMethodBeat.i(14430);
                if (bo.isNullOrNil(str)) {
                    ab.i(e.a(e.this), "shouldInterceptRequest, url is null");
                    AppMethodBeat.o(14430);
                    return null;
                }
                ab.v(e.a(e.this), "shouldInterceptRequest, url = %s", str);
                o f = f(webView, str);
                AppMethodBeat.o(14430);
                return f;
            }

            public final o a(WebView webView, n nVar, Bundle bundle) {
                AppMethodBeat.i(14431);
                if (nVar == null || nVar.getUrl() == null || bo.isNullOrNil(nVar.getUrl().toString())) {
                    ab.e(e.a(e.this), "shouldInterceptRequest, webResourceRequest is null");
                    AppMethodBeat.o(14431);
                    return null;
                }
                ab.v(e.a(e.this), "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", nVar.getUrl(), nVar.getMethod(), Boolean.valueOf(nVar.isForMainFrame()));
                ab.v(e.a(e.this), "shouldInterceptRequest, url = %s", nVar.getUrl().toString());
                o f = f(webView, r0);
                AppMethodBeat.o(14431);
                return f;
            }

            public final o a(WebView webView, n nVar) {
                AppMethodBeat.i(14432);
                if (nVar == null || nVar.getUrl() == null || bo.isNullOrNil(nVar.getUrl().toString())) {
                    ab.e(e.a(e.this), "shouldInterceptRequest, url is null");
                    AppMethodBeat.o(14432);
                    return null;
                }
                ab.v(e.a(e.this), "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", nVar.getUrl(), nVar.getMethod(), Boolean.valueOf(nVar.isForMainFrame()));
                o f = f(webView, nVar.getUrl().toString());
                AppMethodBeat.o(14432);
                return f;
            }
        };
        this.jUG = (int) (System.currentTimeMillis() % 1000);
        this.inited = true;
        this.isX5Kernel = getIsX5Kernel();
        this.jVi = tmplParams.jVi;
        this.jVk = tmplParams.upO;
        this.jVj = tmplParams.version;
        this.jRb = tmplParams;
        ab.i(getTagName(), "[initParams]tmplParams:%s", this.jRb);
        if (ah.bqo()) {
            ab.i(getTagName(), "[initWebviewCore] current process is mm");
            WebView.initWebviewCore(context, zNq, "mm", null);
        } else if (ah.doF()) {
            ab.i(getTagName(), "[initWebviewCore] current process is tool");
            WebView.initWebviewCore(context, zNq, "tools", null);
        } else if (ah.doG()) {
            ab.i(getTagName(), "[initWebviewCore] current process is toolmp");
            WebView.initWebviewCore(context, zNq, "toolsmp", null);
        }
        MMWebView.il(context);
        ab.i(getTagName(), "[initWebViewSetting]");
        getSettings().setJavaScriptEnabled(true);
        getSettings().setPluginsEnabled(true);
        getSettings().dUh();
        getSettings().setBuiltInZoomControls(false);
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().dUc();
        getSettings().dUb();
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().dUj();
        getSettings().dUf();
        getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        getSettings().dUe();
        getSettings().dUi();
        getSettings().dUg();
        getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.eSi + "databases/");
        com.tencent.xweb.b.dTR().dTS();
        com.tencent.xweb.b.dTR().f(this);
        getSettings().setUserAgentString(u.bh(getContext(), getSettings().getUserAgentString()));
        addJavascriptInterface(new Object() {
            @JavascriptInterface
            @org.xwalk.core.JavascriptInterface
            public final String getString() {
                AppMethodBeat.i(14433);
                String pageString = this.getPageString();
                AppMethodBeat.o(14433);
                return pageString;
            }

            @JavascriptInterface
            @org.xwalk.core.JavascriptInterface
            public final void __setInjectReady() {
                AppMethodBeat.i(14434);
                this.aXO();
                AppMethodBeat.o(14434);
            }
        }, "__tmpl_webview_inject_data");
        ab.i(getTagName(), "[initJsApiHandler]");
        com.tencent.mm.plugin.webview.ui.tools.k kVar = new com.tencent.mm.plugin.webview.ui.tools.k(JsapiPermissionWrapper.vxI, GeneralControlWrapper.vxF, new com.tencent.mm.plugin.webview.ui.tools.k.b() {
            public final String aYj() {
                return e.this.jVi;
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("webview_type", "1");
        hashMap.put("init_url", getUrl());
        hashMap.put("init_font_size", "1");
        this.jVn = new d(this, kVar, hashMap);
        addJavascriptInterface(this.jVn, "__wx");
        ab.i(getTagName(), "[initJsApiHandler]enableWvSHA1:%b", Boolean.valueOf(ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)));
        if (ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)) {
            this.jVn.dch();
            setRandomStr(this.jVn.uFw);
        }
        setWebViewClient(this.iuo);
        AppMethodBeat.o(14436);
    }

    public synchronized void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(14437);
        if (this.jVl) {
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(14425);
                    e.a(e.this, str, valueCallback);
                    AppMethodBeat.o(14425);
                }
            };
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                anonymousClass1.run();
                AppMethodBeat.o(14437);
            } else {
                al.d(anonymousClass1);
                AppMethodBeat.o(14437);
            }
        } else {
            this.jVm.add(new Pair(str, valueCallback));
            AppMethodBeat.o(14437);
        }
    }

    public s getWebViewClient() {
        return this.iuo;
    }

    private synchronized void aYi() {
        AppMethodBeat.i(14438);
        Iterator it = this.jVm.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            super.evaluateJavascript((String) pair.first, (ValueCallback) pair.second);
            ab.v(getTagName(), "[evaluateJavascript]%s", pair.first);
        }
        this.jVm.clear();
        AppMethodBeat.o(14438);
    }

    public void aXM() {
        AppMethodBeat.i(14439);
        ab.i(getTagName(), "[loadUrlAndData] url:%s", this.jVi);
        loadUrl(this.jVi);
        AppMethodBeat.o(14439);
    }

    public d getJsApiHandler() {
        return this.jVn;
    }

    /* Access modifiers changed, original: protected */
    public String getPageString() {
        return "";
    }

    /* Access modifiers changed, original: protected */
    public void aXO() {
    }

    /* Access modifiers changed, original: protected|final */
    public final String getInjectAPI() {
        return "__tmpl_webview_inject_data.getString()";
    }

    /* Access modifiers changed, original: protected */
    public void aXN() {
        AppMethodBeat.i(14440);
        ab.i(getTagName(), "[initJsEnvironment]");
        new f(this, this.jVn, new f.a() {
            public final void aYk() {
                AppMethodBeat.i(14435);
                ab.i(e.a(e.this), "[initJsEnvironment] onLoadedSucc");
                ab.i(e.a(e.this), "terry trace 1.3.1 initJsEnvironment Succ");
                AppMethodBeat.o(14435);
            }
        }).dcs();
        AppMethodBeat.o(14440);
    }

    /* Access modifiers changed, original: protected */
    public void aJq() {
        AppMethodBeat.i(14441);
        ab.i(getTagName(), "[onPageReady]");
        AppMethodBeat.o(14441);
    }

    public final boolean isReady() {
        return this.jVl;
    }

    /* Access modifiers changed, original: protected */
    public int getTmplWebViewId() {
        return this.jUG;
    }

    private String getTagName() {
        AppMethodBeat.i(14442);
        String str = "MicroMsg.TmplWxJsWebView:" + getTmplWebViewId();
        AppMethodBeat.o(14442);
        return str;
    }
}
