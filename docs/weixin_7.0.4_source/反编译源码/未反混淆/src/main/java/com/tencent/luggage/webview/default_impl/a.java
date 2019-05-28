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
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class a implements com.tencent.luggage.webview.a {
    private k bPN;
    private DefaultWebView bRJ;
    private Handler bRK = new Handler(Looper.getMainLooper());
    private Context mContext;

    public a(Context context) {
        AppMethodBeat.i(90930);
        this.mContext = context;
        this.bRJ = new DefaultWebView(context);
        AppMethodBeat.o(90930);
    }

    public final void a(final com.tencent.luggage.webview.a.a aVar) {
        AppMethodBeat.i(90931);
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(90919);
                a.a(a.this, aVar);
                AppMethodBeat.o(90919);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            anonymousClass1.run();
            AppMethodBeat.o(90931);
            return;
        }
        this.bRK.post(anonymousClass1);
        AppMethodBeat.o(90931);
    }

    public void setContext(Context context) {
        AppMethodBeat.i(90932);
        if (this.mContext instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.mContext).setBaseContext(context);
        }
        AppMethodBeat.o(90932);
    }

    public void setWebCore(k kVar) {
        this.bPN = kVar;
    }

    public View getView() {
        return this.bRJ;
    }

    public void loadUrl(final String str) {
        AppMethodBeat.i(90933);
        AnonymousClass2 anonymousClass2 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(90920);
                a.this.bRJ.loadUrl(str);
                AppMethodBeat.o(90920);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            anonymousClass2.run();
            AppMethodBeat.o(90933);
            return;
        }
        this.bRK.post(anonymousClass2);
        AppMethodBeat.o(90933);
    }

    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(90934);
        this.bRJ.loadUrl(str, map);
        AppMethodBeat.o(90934);
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(90935);
        this.bRJ.loadData(str, str2, str3);
        AppMethodBeat.o(90935);
    }

    public void stopLoading() {
        AppMethodBeat.i(90936);
        this.bRJ.stopLoading();
        AppMethodBeat.o(90936);
    }

    public void goBack() {
        AppMethodBeat.i(90937);
        this.bRJ.goBack();
        AppMethodBeat.o(90937);
    }

    public boolean canGoBack() {
        AppMethodBeat.i(90938);
        boolean canGoBack = this.bRJ.canGoBack();
        AppMethodBeat.o(90938);
        return canGoBack;
    }

    public void destroy() {
        AppMethodBeat.i(90939);
        this.bRJ.destroy();
        AppMethodBeat.o(90939);
    }

    public Context getContext() {
        return this.mContext;
    }

    public void addJavascriptInterface(final Object obj, final String str) {
        AppMethodBeat.i(90940);
        AnonymousClass3 anonymousClass3 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(90921);
                a.this.bRJ.addJavascriptInterface(obj, str);
                AppMethodBeat.o(90921);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            anonymousClass3.run();
            AppMethodBeat.o(90940);
            return;
        }
        this.bRK.post(anonymousClass3);
        AppMethodBeat.o(90940);
    }

    public final void by(final String str) {
        AppMethodBeat.i(90941);
        AnonymousClass4 anonymousClass4 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(90922);
                a.this.bRJ.by(str);
                AppMethodBeat.o(90922);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            anonymousClass4.run();
            AppMethodBeat.o(90941);
            return;
        }
        this.bRK.post(anonymousClass4);
        AppMethodBeat.o(90941);
    }

    static /* synthetic */ void a(a aVar, final com.tencent.luggage.webview.a.a aVar2) {
        AppMethodBeat.i(90942);
        aVar.bRJ.setWebViewClient(new WebViewClient() {
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                AppMethodBeat.i(90923);
                boolean bD = aVar2.bD(str);
                AppMethodBeat.o(90923);
                return bD;
            }

            @TargetApi(21)
            public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                AppMethodBeat.i(90924);
                boolean bD = aVar2.bD(webResourceRequest.getUrl().toString());
                AppMethodBeat.o(90924);
                return bD;
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(90925);
                aVar2.bE(str);
                AppMethodBeat.o(90925);
            }

            public final void onPageFinished(WebView webView, String str) {
                AppMethodBeat.i(90926);
                aVar2.bF(str);
                AppMethodBeat.o(90926);
            }

            @TargetApi(21)
            public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                AppMethodBeat.i(90927);
                WebResourceResponse bG = aVar2.bG(webResourceRequest.getUrl().toString());
                AppMethodBeat.o(90927);
                return bG;
            }

            public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                AppMethodBeat.i(90928);
                WebResourceResponse bG = aVar2.bG(str);
                AppMethodBeat.o(90928);
                return bG;
            }
        });
        aVar.bRJ.setWebChromeClient(new DefaultWebCore$6(aVar, aVar2));
        AppMethodBeat.o(90942);
    }
}
