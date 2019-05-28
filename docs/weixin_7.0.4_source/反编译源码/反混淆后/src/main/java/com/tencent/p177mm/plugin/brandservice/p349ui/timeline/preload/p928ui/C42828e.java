package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C27539k;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p351b.C20082b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k.C40343b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C40342m;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43986f;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43986f.C35691a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.preload.C43924a;
import com.tencent.p177mm.plugin.webview.preload.TmplParams;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p1574f.C44216b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.WebView;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.e */
public class C42828e extends MMWebView {
    private C36592s iuo;
    public TmplParams jRb;
    private int jUG;
    public String jVi;
    public int jVj;
    public String jVk;
    private boolean jVl;
    private LinkedList<Pair<String, ValueCallback<String>>> jVm;
    protected C44786d jVn;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.e$2 */
    class C112592 extends C36592s {
        C112592() {
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(14426);
            C4990ab.m7417i(C42828e.m75970a(C42828e.this), "[onPageStarted] url:%s", str);
            super.mo7562b(webView, str, bitmap);
            C42828e.this.jVl = false;
            AppMethodBeat.m2505o(14426);
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(14427);
            C4990ab.m7417i(C42828e.m75970a(C42828e.this), "[onPageFinished] url:%s", str);
            super.mo5992b(webView, str);
            C42828e.m75973b(C42828e.this);
            C42828e.this.jVl = true;
            C42828e.this.aJq();
            AppMethodBeat.m2505o(14427);
        }

        /* renamed from: f */
        private C31147o m18969f(WebView webView, String str) {
            String str2;
            int i = 0;
            AppMethodBeat.m2504i(14428);
            C4990ab.m7417i(C42828e.m75970a(C42828e.this), "getResourceResponse, requrl:%s, url:%s", str, C42828e.this.jVi);
            if (str.equals(C42828e.this.jVi)) {
                str2 = C42828e.this.jVk;
            } else if (str.startsWith(C20082b.aXB())) {
                str2 = C27539k.m43702q(C42828e.this.jRb.jSV, C42828e.this.jRb.jSY, str.replaceFirst(C20082b.aXB(), ""));
                i = 1;
            } else if (str.startsWith(C20082b.getPrefix())) {
                str2 = C27539k.m43702q(C42828e.this.jRb.jSV, C42828e.this.jRb.jSY, str.replaceFirst(C20082b.getPrefix(), ""));
                i = 1;
            } else {
                C4990ab.m7412e(C42828e.m75970a(C42828e.this), "return null");
                AppMethodBeat.m2505o(14428);
                return null;
            }
            C4990ab.m7418v(C42828e.m75970a(C42828e.this), "response path:" + C5046bo.m7532bc(str2, BuildConfig.COMMAND));
            C31147o g = m18970g(webView, str2);
            if (g != null) {
                C4990ab.m7416i(C42828e.m75970a(C42828e.this), "return intercepted success");
                AppMethodBeat.m2505o(14428);
                return g;
            }
            C4990ab.m7412e(C42828e.m75970a(C42828e.this), "return intercepted null");
            C43924a.m78790e(C42828e.this.jRb.upQ, 126, 1, true);
            if (i != 0) {
                C43924a.m78790e(C42828e.this.jRb.upQ, C31128d.MIC_PTU_MEISHI, 1, true);
            }
            AppMethodBeat.m2505o(14428);
            return null;
        }

        /* renamed from: g */
        private C31147o m18970g(WebView webView, String str) {
            C31147o c31147o;
            Object obj = null;
            AppMethodBeat.m2504i(14429);
            String ako = C44216b.ako(str);
            String str2 = "UTF-8";
            if (str.endsWith(".js") && C43986f.m78916c(webView)) {
                obj = new C40342m(str).toString();
                c31147o = new C31147o(ako, str2, new ByteArrayInputStream(obj.getBytes(StandardCharsets.UTF_8)));
            } else {
                InputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (FileNotFoundException e) {
                    C4990ab.printErrStackTrace(C42828e.m75970a(C42828e.this), e, "", new Object[0]);
                    fileInputStream = null;
                }
                if (fileInputStream == null) {
                    C4990ab.m7412e(C42828e.m75970a(C42828e.this), "stream is null, err");
                    AppMethodBeat.m2505o(14429);
                    return null;
                }
                c31147o = new C31147o(ako, str2, fileInputStream);
            }
            HashMap hashMap = new HashMap();
            ako = Integer.toHexString(str.hashCode() & -1).toLowerCase();
            hashMap.put("Cache-Control", "max-age=31536000");
            hashMap.put("ETag", ako);
            if (obj != null) {
                hashMap.put("RunLocalJS", obj);
            }
            c31147o.mResponseHeaders = hashMap;
            C4990ab.m7417i("MicroMsg.TmplWxJsWebView", "readFileWebResp:%s\nETag:%s", str, ako);
            AppMethodBeat.m2505o(14429);
            return c31147o;
        }

        /* renamed from: c */
        public final C31147o mo5993c(WebView webView, String str) {
            AppMethodBeat.m2504i(14430);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i(C42828e.m75970a(C42828e.this), "shouldInterceptRequest, url is null");
                AppMethodBeat.m2505o(14430);
                return null;
            }
            C4990ab.m7419v(C42828e.m75970a(C42828e.this), "shouldInterceptRequest, url = %s", str);
            C31147o f = m18969f(webView, str);
            AppMethodBeat.m2505o(14430);
            return f;
        }

        /* renamed from: a */
        public final C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
            AppMethodBeat.m2504i(14431);
            if (c24530n == null || c24530n.getUrl() == null || C5046bo.isNullOrNil(c24530n.getUrl().toString())) {
                C4990ab.m7412e(C42828e.m75970a(C42828e.this), "shouldInterceptRequest, webResourceRequest is null");
                AppMethodBeat.m2505o(14431);
                return null;
            }
            C4990ab.m7419v(C42828e.m75970a(C42828e.this), "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", c24530n.getUrl(), c24530n.getMethod(), Boolean.valueOf(c24530n.isForMainFrame()));
            C4990ab.m7419v(C42828e.m75970a(C42828e.this), "shouldInterceptRequest, url = %s", c24530n.getUrl().toString());
            C31147o f = m18969f(webView, r0);
            AppMethodBeat.m2505o(14431);
            return f;
        }

        /* renamed from: a */
        public final C31147o mo5990a(WebView webView, C24530n c24530n) {
            AppMethodBeat.m2504i(14432);
            if (c24530n == null || c24530n.getUrl() == null || C5046bo.isNullOrNil(c24530n.getUrl().toString())) {
                C4990ab.m7412e(C42828e.m75970a(C42828e.this), "shouldInterceptRequest, url is null");
                AppMethodBeat.m2505o(14432);
                return null;
            }
            C4990ab.m7419v(C42828e.m75970a(C42828e.this), "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", c24530n.getUrl(), c24530n.getMethod(), Boolean.valueOf(c24530n.isForMainFrame()));
            C31147o f = m18969f(webView, c24530n.getUrl().toString());
            AppMethodBeat.m2505o(14432);
            return f;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.e$4 */
    class C275584 implements C40343b {
        C275584() {
        }

        public final String aYj() {
            return C42828e.this.jVi;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.e$5 */
    class C387135 implements C35691a {
        C387135() {
        }

        public final void aYk() {
            AppMethodBeat.m2504i(14435);
            C4990ab.m7416i(C42828e.m75970a(C42828e.this), "[initJsEnvironment] onLoadedSucc");
            C4990ab.m7416i(C42828e.m75970a(C42828e.this), "terry trace 1.3.1 initJsEnvironment Succ");
            AppMethodBeat.m2505o(14435);
        }
    }

    /* renamed from: a */
    static /* synthetic */ String m75970a(C42828e c42828e) {
        AppMethodBeat.m2504i(14444);
        String tagName = c42828e.getTagName();
        AppMethodBeat.m2505o(14444);
        return tagName;
    }

    /* renamed from: a */
    static /* synthetic */ void m75971a(C42828e c42828e, String str, ValueCallback valueCallback) {
        AppMethodBeat.m2504i(14443);
        super.evaluateJavascript(str, valueCallback);
        AppMethodBeat.m2505o(14443);
    }

    /* renamed from: b */
    static /* synthetic */ void m75973b(C42828e c42828e) {
        AppMethodBeat.m2504i(14445);
        c42828e.aYi();
        AppMethodBeat.m2505o(14445);
    }

    public C42828e(Context context, TmplParams tmplParams) {
        super(context);
        AppMethodBeat.m2504i(14436);
        this.jVm = new LinkedList();
        this.iuo = new C112592();
        this.jUG = (int) (System.currentTimeMillis() % 1000);
        this.inited = true;
        this.isX5Kernel = getIsX5Kernel();
        this.jVi = tmplParams.jVi;
        this.jVk = tmplParams.upO;
        this.jVj = tmplParams.version;
        this.jRb = tmplParams;
        C4990ab.m7417i(getTagName(), "[initParams]tmplParams:%s", this.jRb);
        if (C4996ah.bqo()) {
            C4990ab.m7416i(getTagName(), "[initWebviewCore] current process is mm");
            WebView.initWebviewCore(context, zNq, "mm", null);
        } else if (C4996ah.doF()) {
            C4990ab.m7416i(getTagName(), "[initWebviewCore] current process is tool");
            WebView.initWebviewCore(context, zNq, "tools", null);
        } else if (C4996ah.doG()) {
            C4990ab.m7416i(getTagName(), "[initWebviewCore] current process is toolmp");
            WebView.initWebviewCore(context, zNq, "toolsmp", null);
        }
        MMWebView.m49133il(context);
        C4990ab.m7416i(getTagName(), "[initWebViewSetting]");
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
        getSettings().setDatabasePath(C6457e.eSi + "databases/");
        C44576b.dTR().dTS();
        C44576b.dTR().mo71378f(this);
        getSettings().setUserAgentString(C30152u.m47747bh(getContext(), getSettings().getUserAgentString()));
        addJavascriptInterface(new Object() {
            @JavascriptInterface
            @org.xwalk.core.JavascriptInterface
            public final String getString() {
                AppMethodBeat.m2504i(14433);
                String pageString = this.getPageString();
                AppMethodBeat.m2505o(14433);
                return pageString;
            }

            @JavascriptInterface
            @org.xwalk.core.JavascriptInterface
            public final void __setInjectReady() {
                AppMethodBeat.m2504i(14434);
                this.aXO();
                AppMethodBeat.m2505o(14434);
            }
        }, "__tmpl_webview_inject_data");
        C4990ab.m7416i(getTagName(), "[initJsApiHandler]");
        C40344k c40344k = new C40344k(JsapiPermissionWrapper.vxI, GeneralControlWrapper.vxF, new C275584());
        HashMap hashMap = new HashMap();
        hashMap.put("webview_type", "1");
        hashMap.put("init_url", getUrl());
        hashMap.put("init_font_size", "1");
        this.jVn = new C44786d(this, c40344k, hashMap);
        addJavascriptInterface(this.jVn, "__wx");
        C4990ab.m7417i(getTagName(), "[initJsApiHandler]enableWvSHA1:%b", Boolean.valueOf(C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)));
        if (C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)) {
            this.jVn.dch();
            setRandomStr(this.jVn.uFw);
        }
        setWebViewClient(this.iuo);
        AppMethodBeat.m2505o(14436);
    }

    public synchronized void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(14437);
        if (this.jVl) {
            C275571 c275571 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(14425);
                    C42828e.m75971a(C42828e.this, str, valueCallback);
                    AppMethodBeat.m2505o(14425);
                }
            };
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                c275571.run();
                AppMethodBeat.m2505o(14437);
            } else {
                C5004al.m7441d(c275571);
                AppMethodBeat.m2505o(14437);
            }
        } else {
            this.jVm.add(new Pair(str, valueCallback));
            AppMethodBeat.m2505o(14437);
        }
    }

    public C36592s getWebViewClient() {
        return this.iuo;
    }

    private synchronized void aYi() {
        AppMethodBeat.m2504i(14438);
        Iterator it = this.jVm.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            super.evaluateJavascript((String) pair.first, (ValueCallback) pair.second);
            C4990ab.m7419v(getTagName(), "[evaluateJavascript]%s", pair.first);
        }
        this.jVm.clear();
        AppMethodBeat.m2505o(14438);
    }

    public void aXM() {
        AppMethodBeat.m2504i(14439);
        C4990ab.m7417i(getTagName(), "[loadUrlAndData] url:%s", this.jVi);
        loadUrl(this.jVi);
        AppMethodBeat.m2505o(14439);
    }

    public C44786d getJsApiHandler() {
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
        AppMethodBeat.m2504i(14440);
        C4990ab.m7416i(getTagName(), "[initJsEnvironment]");
        new C43986f(this, this.jVn, new C387135()).dcs();
        AppMethodBeat.m2505o(14440);
    }

    /* Access modifiers changed, original: protected */
    public void aJq() {
        AppMethodBeat.m2504i(14441);
        C4990ab.m7416i(getTagName(), "[onPageReady]");
        AppMethodBeat.m2505o(14441);
    }

    public final boolean isReady() {
        return this.jVl;
    }

    /* Access modifiers changed, original: protected */
    public int getTmplWebViewId() {
        return this.jUG;
    }

    private String getTagName() {
        AppMethodBeat.m2504i(14442);
        String str = "MicroMsg.TmplWxJsWebView:" + getTmplWebViewId();
        AppMethodBeat.m2505o(14442);
        return str;
    }
}
