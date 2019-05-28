package com.tencent.xweb.sys;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.sys.c.b;
import com.tencent.xweb.sys.c.c;
import com.tencent.xweb.sys.c.d;
import com.tencent.xweb.util.f;
import org.xwalk.core.Log;

class SysWebView$1 extends WebChromeClient {
    final /* synthetic */ e AQc;

    SysWebView$1(e eVar) {
        this.AQc = eVar;
    }

    public void onProgressChanged(WebView webView, int i) {
        AppMethodBeat.i(84671);
        if (this.AQc.APV != null) {
            this.AQc.APV.a(this.AQc.APS, i);
            AppMethodBeat.o(84671);
            return;
        }
        super.onProgressChanged(webView, i);
        AppMethodBeat.o(84671);
    }

    public void onReceivedTitle(WebView webView, String str) {
        AppMethodBeat.i(84672);
        Log.i("SysWebView", "onReceivedTitle: ".concat(String.valueOf(str)));
        if (this.AQc.APZ != null) {
            this.AQc.APZ.am(true, this.AQc.APS.getFullscreenVideoKind() == a.HOOK_EVALUTE_JS);
        }
        if (this.AQc.APV != null) {
            this.AQc.APV.d(this.AQc.APS, str);
            AppMethodBeat.o(84672);
            return;
        }
        super.onReceivedTitle(webView, str);
        AppMethodBeat.o(84672);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(84673);
        Log.i("SysWebView", "onShowCustomView");
        if (this.AQc.APV != null) {
            this.AQc.APV.aJY();
        }
        f.dUW();
        if (this.AQc.APZ != null) {
            this.AQc.APZ.onShowCustomView(view, customViewCallback);
            AppMethodBeat.o(84673);
        } else if (this.AQc.APV != null) {
            this.AQc.APV.onShowCustomView(view, customViewCallback);
            AppMethodBeat.o(84673);
        } else {
            super.onShowCustomView(view, customViewCallback);
            AppMethodBeat.o(84673);
        }
    }

    public void onHideCustomView() {
        AppMethodBeat.i(84674);
        Log.i("SysWebView", "onHideCustomView");
        if (this.AQc.APV != null) {
            this.AQc.APV.aDI();
        }
        if (this.AQc.APZ != null) {
            this.AQc.APZ.onHideCustomView();
            AppMethodBeat.o(84674);
        } else if (this.AQc.APV != null) {
            this.AQc.APV.onHideCustomView();
            AppMethodBeat.o(84674);
        } else {
            super.onHideCustomView();
            AppMethodBeat.o(84674);
        }
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(84675);
        Log.i("SysWebView", "onJsAlert");
        boolean a;
        if (this.AQc.APV != null) {
            a = this.AQc.APV.a(this.AQc.APS, str, str2, new d(jsResult));
            AppMethodBeat.o(84675);
            return a;
        }
        a = super.onJsAlert(webView, str, str2, jsResult);
        AppMethodBeat.o(84675);
        return a;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(84676);
        Log.i("SysWebView", "onJsConfirm");
        boolean b;
        if (this.AQc.APV != null) {
            b = this.AQc.APV.b(this.AQc.APS, str, str2, new d(jsResult));
            AppMethodBeat.o(84676);
            return b;
        }
        b = super.onJsConfirm(webView, str, str2, jsResult);
        AppMethodBeat.o(84676);
        return b;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.i(84677);
        Log.i("SysWebView", "onJsPrompt");
        boolean a;
        if (this.AQc.APV != null) {
            a = this.AQc.APV.a(this.AQc.APS, str, str2, str3, new c(jsPromptResult));
            AppMethodBeat.o(84677);
            return a;
        }
        a = super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        AppMethodBeat.o(84677);
        return a;
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        AppMethodBeat.i(84678);
        Log.i("SysWebView", "onGeolocationPermissionsShowPrompt");
        if (this.AQc.APV != null) {
            this.AQc.APV.onGeolocationPermissionsShowPrompt(str, callback);
            AppMethodBeat.o(84678);
            return;
        }
        super.onGeolocationPermissionsShowPrompt(str, callback);
        AppMethodBeat.o(84678);
    }

    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.i(84679);
        Log.i("SysWebView", "onGeolocationPermissionsHidePrompt");
        if (this.AQc.APV == null) {
            super.onGeolocationPermissionsHidePrompt();
        }
        AppMethodBeat.o(84679);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(84680);
        Log.i("SysWebView", "onConsoleMessage " + consoleMessage.message());
        boolean onConsoleMessage;
        if (this.AQc.APV != null) {
            onConsoleMessage = this.AQc.APV.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(84680);
            return onConsoleMessage;
        }
        onConsoleMessage = super.onConsoleMessage(consoleMessage);
        AppMethodBeat.o(84680);
        return onConsoleMessage;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        AppMethodBeat.i(84681);
        Log.i("SysWebView", "openFileChooser with one param");
        if (this.AQc.APV != null) {
            this.AQc.APV.openFileChooser(valueCallback, null, null);
            AppMethodBeat.o(84681);
            return;
        }
        valueCallback.onReceiveValue(null);
        AppMethodBeat.o(84681);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        AppMethodBeat.i(84682);
        Log.i("SysWebView", "openFileChooser with two param");
        if (this.AQc.APV != null) {
            this.AQc.APV.openFileChooser(valueCallback, str, null);
            AppMethodBeat.o(84682);
            return;
        }
        valueCallback.onReceiveValue(null);
        AppMethodBeat.o(84682);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(84683);
        Log.i("SysWebView", "openFileChooser with three param");
        if (this.AQc.APV != null) {
            this.AQc.APV.openFileChooser(valueCallback, str, str2);
            AppMethodBeat.o(84683);
            return;
        }
        valueCallback.onReceiveValue(null);
        AppMethodBeat.o(84683);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        AppMethodBeat.i(84684);
        Log.i("SysWebView", "onShowFileChooser last method");
        boolean a;
        if (this.AQc.APV != null) {
            a = this.AQc.APV.a(this.AQc.APS, valueCallback, new b(fileChooserParams));
            AppMethodBeat.o(84684);
            return a;
        }
        a = super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        AppMethodBeat.o(84684);
        return a;
    }

    public View getVideoLoadingProgressView() {
        AppMethodBeat.i(84685);
        View videoLoadingProgressView;
        if (this.AQc.APV != null) {
            videoLoadingProgressView = this.AQc.APV.getVideoLoadingProgressView();
            AppMethodBeat.o(84685);
            return videoLoadingProgressView;
        }
        videoLoadingProgressView = LayoutInflater.from(this.AQc.APS.getContext()).inflate(R.layout.b1g, null);
        AppMethodBeat.o(84685);
        return videoLoadingProgressView;
    }
}
