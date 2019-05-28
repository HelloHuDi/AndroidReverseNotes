package com.tencent.luggage.webview.default_impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.luggage.webview.C37407a;
import com.tencent.luggage.webview.C37407a.C32193a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.tencent.luggage.webview.default_impl.a */
public class C25703a implements C37407a {
    private C32186k bPN;
    private DefaultWebView bRJ;
    private Handler bRK = new Handler(Looper.getMainLooper());
    private Context mContext;

    public C25703a(Context context) {
        AppMethodBeat.m2504i(90930);
        this.mContext = context;
        this.bRJ = new DefaultWebView(context);
        AppMethodBeat.m2505o(90930);
    }

    /* renamed from: a */
    public final void mo7543a(final C32193a c32193a) {
        AppMethodBeat.m2504i(90931);
        C257011 c257011 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(90919);
                C25703a.m40805a(C25703a.this, c32193a);
                AppMethodBeat.m2505o(90919);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            c257011.run();
            AppMethodBeat.m2505o(90931);
            return;
        }
        this.bRK.post(c257011);
        AppMethodBeat.m2505o(90931);
    }

    public void setContext(Context context) {
        AppMethodBeat.m2504i(90932);
        if (this.mContext instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.mContext).setBaseContext(context);
        }
        AppMethodBeat.m2505o(90932);
    }

    public void setWebCore(C32186k c32186k) {
        this.bPN = c32186k;
    }

    public View getView() {
        return this.bRJ;
    }

    public void loadUrl(final String str) {
        AppMethodBeat.m2504i(90933);
        C88792 c88792 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(90920);
                C25703a.this.bRJ.loadUrl(str);
                AppMethodBeat.m2505o(90920);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            c88792.run();
            AppMethodBeat.m2505o(90933);
            return;
        }
        this.bRK.post(c88792);
        AppMethodBeat.m2505o(90933);
    }

    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(90934);
        this.bRJ.loadUrl(str, map);
        AppMethodBeat.m2505o(90934);
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.m2504i(90935);
        this.bRJ.loadData(str, str2, str3);
        AppMethodBeat.m2505o(90935);
    }

    public void stopLoading() {
        AppMethodBeat.m2504i(90936);
        this.bRJ.stopLoading();
        AppMethodBeat.m2505o(90936);
    }

    public void goBack() {
        AppMethodBeat.m2504i(90937);
        this.bRJ.goBack();
        AppMethodBeat.m2505o(90937);
    }

    public boolean canGoBack() {
        AppMethodBeat.m2504i(90938);
        boolean canGoBack = this.bRJ.canGoBack();
        AppMethodBeat.m2505o(90938);
        return canGoBack;
    }

    public void destroy() {
        AppMethodBeat.m2504i(90939);
        this.bRJ.destroy();
        AppMethodBeat.m2505o(90939);
    }

    public Context getContext() {
        return this.mContext;
    }

    public void addJavascriptInterface(final Object obj, final String str) {
        AppMethodBeat.m2504i(90940);
        C257023 c257023 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(90921);
                C25703a.this.bRJ.addJavascriptInterface(obj, str);
                AppMethodBeat.m2505o(90921);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            c257023.run();
            AppMethodBeat.m2505o(90940);
            return;
        }
        this.bRK.post(c257023);
        AppMethodBeat.m2505o(90940);
    }

    /* renamed from: by */
    public final void mo43469by(final String str) {
        AppMethodBeat.m2504i(90941);
        C257044 c257044 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(90922);
                C25703a.this.bRJ.mo43469by(str);
                AppMethodBeat.m2505o(90922);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            c257044.run();
            AppMethodBeat.m2505o(90941);
            return;
        }
        this.bRK.post(c257044);
        AppMethodBeat.m2505o(90941);
    }

    /* renamed from: a */
    static /* synthetic */ void m40805a(C25703a c25703a, final C32193a c32193a) {
        AppMethodBeat.m2504i(90942);
        c25703a.bRJ.setWebViewClient(new WebViewClient() {
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                AppMethodBeat.m2504i(90923);
                boolean bD = c32193a.mo52839bD(str);
                AppMethodBeat.m2505o(90923);
                return bD;
            }

            @TargetApi(21)
            public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                AppMethodBeat.m2504i(90924);
                boolean bD = c32193a.mo52839bD(webResourceRequest.getUrl().toString());
                AppMethodBeat.m2505o(90924);
                return bD;
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.m2504i(90925);
                c32193a.mo52840bE(str);
                AppMethodBeat.m2505o(90925);
            }

            public final void onPageFinished(WebView webView, String str) {
                AppMethodBeat.m2504i(90926);
                c32193a.mo52841bF(str);
                AppMethodBeat.m2505o(90926);
            }

            @TargetApi(21)
            public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                AppMethodBeat.m2504i(90927);
                WebResourceResponse bG = c32193a.mo52842bG(webResourceRequest.getUrl().toString());
                AppMethodBeat.m2505o(90927);
                return bG;
            }

            public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                AppMethodBeat.m2504i(90928);
                WebResourceResponse bG = c32193a.mo52842bG(str);
                AppMethodBeat.m2505o(90928);
                return bG;
            }
        });
        c25703a.bRJ.setWebChromeClient(new DefaultWebCore$6(c25703a, c32193a));
        AppMethodBeat.m2505o(90942);
    }
}
