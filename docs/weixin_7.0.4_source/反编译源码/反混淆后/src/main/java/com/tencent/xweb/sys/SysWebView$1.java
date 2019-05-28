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
import com.tencent.xweb.WebView.C46827a;
import com.tencent.xweb.sys.C36594c.C16397b;
import com.tencent.xweb.sys.C36594c.C36593c;
import com.tencent.xweb.sys.C36594c.C36595d;
import com.tencent.xweb.util.C24532f;
import org.xwalk.core.Log;

class SysWebView$1 extends WebChromeClient {
    final /* synthetic */ C16398e AQc;

    SysWebView$1(C16398e c16398e) {
        this.AQc = c16398e;
    }

    public void onProgressChanged(WebView webView, int i) {
        AppMethodBeat.m2504i(84671);
        if (this.AQc.APV != null) {
            this.AQc.APV.mo13205a(this.AQc.APS, i);
            AppMethodBeat.m2505o(84671);
            return;
        }
        super.onProgressChanged(webView, i);
        AppMethodBeat.m2505o(84671);
    }

    public void onReceivedTitle(WebView webView, String str) {
        AppMethodBeat.m2504i(84672);
        Log.m81049i("SysWebView", "onReceivedTitle: ".concat(String.valueOf(str)));
        if (this.AQc.APZ != null) {
            this.AQc.APZ.mo30114am(true, this.AQc.APS.getFullscreenVideoKind() == C46827a.HOOK_EVALUTE_JS);
        }
        if (this.AQc.APV != null) {
            this.AQc.APV.mo7557d(this.AQc.APS, str);
            AppMethodBeat.m2505o(84672);
            return;
        }
        super.onReceivedTitle(webView, str);
        AppMethodBeat.m2505o(84672);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.m2504i(84673);
        Log.m81049i("SysWebView", "onShowCustomView");
        if (this.AQc.APV != null) {
            this.AQc.APV.aJY();
        }
        C24532f.dUW();
        if (this.AQc.APZ != null) {
            this.AQc.APZ.onShowCustomView(view, customViewCallback);
            AppMethodBeat.m2505o(84673);
        } else if (this.AQc.APV != null) {
            this.AQc.APV.onShowCustomView(view, customViewCallback);
            AppMethodBeat.m2505o(84673);
        } else {
            super.onShowCustomView(view, customViewCallback);
            AppMethodBeat.m2505o(84673);
        }
    }

    public void onHideCustomView() {
        AppMethodBeat.m2504i(84674);
        Log.m81049i("SysWebView", "onHideCustomView");
        if (this.AQc.APV != null) {
            this.AQc.APV.aDI();
        }
        if (this.AQc.APZ != null) {
            this.AQc.APZ.onHideCustomView();
            AppMethodBeat.m2505o(84674);
        } else if (this.AQc.APV != null) {
            this.AQc.APV.onHideCustomView();
            AppMethodBeat.m2505o(84674);
        } else {
            super.onHideCustomView();
            AppMethodBeat.m2505o(84674);
        }
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.m2504i(84675);
        Log.m81049i("SysWebView", "onJsAlert");
        boolean a;
        if (this.AQc.APV != null) {
            a = this.AQc.APV.mo13207a(this.AQc.APS, str, str2, new C36595d(jsResult));
            AppMethodBeat.m2505o(84675);
            return a;
        }
        a = super.onJsAlert(webView, str, str2, jsResult);
        AppMethodBeat.m2505o(84675);
        return a;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.m2504i(84676);
        Log.m81049i("SysWebView", "onJsConfirm");
        boolean b;
        if (this.AQc.APV != null) {
            b = this.AQc.APV.mo13211b(this.AQc.APS, str, str2, new C36595d(jsResult));
            AppMethodBeat.m2505o(84676);
            return b;
        }
        b = super.onJsConfirm(webView, str, str2, jsResult);
        AppMethodBeat.m2505o(84676);
        return b;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.m2504i(84677);
        Log.m81049i("SysWebView", "onJsPrompt");
        boolean a;
        if (this.AQc.APV != null) {
            a = this.AQc.APV.mo13208a(this.AQc.APS, str, str2, str3, new C36593c(jsPromptResult));
            AppMethodBeat.m2505o(84677);
            return a;
        }
        a = super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        AppMethodBeat.m2505o(84677);
        return a;
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        AppMethodBeat.m2504i(84678);
        Log.m81049i("SysWebView", "onGeolocationPermissionsShowPrompt");
        if (this.AQc.APV != null) {
            this.AQc.APV.onGeolocationPermissionsShowPrompt(str, callback);
            AppMethodBeat.m2505o(84678);
            return;
        }
        super.onGeolocationPermissionsShowPrompt(str, callback);
        AppMethodBeat.m2505o(84678);
    }

    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.m2504i(84679);
        Log.m81049i("SysWebView", "onGeolocationPermissionsHidePrompt");
        if (this.AQc.APV == null) {
            super.onGeolocationPermissionsHidePrompt();
        }
        AppMethodBeat.m2505o(84679);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.m2504i(84680);
        Log.m81049i("SysWebView", "onConsoleMessage " + consoleMessage.message());
        boolean onConsoleMessage;
        if (this.AQc.APV != null) {
            onConsoleMessage = this.AQc.APV.onConsoleMessage(consoleMessage);
            AppMethodBeat.m2505o(84680);
            return onConsoleMessage;
        }
        onConsoleMessage = super.onConsoleMessage(consoleMessage);
        AppMethodBeat.m2505o(84680);
        return onConsoleMessage;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        AppMethodBeat.m2504i(84681);
        Log.m81049i("SysWebView", "openFileChooser with one param");
        if (this.AQc.APV != null) {
            this.AQc.APV.openFileChooser(valueCallback, null, null);
            AppMethodBeat.m2505o(84681);
            return;
        }
        valueCallback.onReceiveValue(null);
        AppMethodBeat.m2505o(84681);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        AppMethodBeat.m2504i(84682);
        Log.m81049i("SysWebView", "openFileChooser with two param");
        if (this.AQc.APV != null) {
            this.AQc.APV.openFileChooser(valueCallback, str, null);
            AppMethodBeat.m2505o(84682);
            return;
        }
        valueCallback.onReceiveValue(null);
        AppMethodBeat.m2505o(84682);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.m2504i(84683);
        Log.m81049i("SysWebView", "openFileChooser with three param");
        if (this.AQc.APV != null) {
            this.AQc.APV.openFileChooser(valueCallback, str, str2);
            AppMethodBeat.m2505o(84683);
            return;
        }
        valueCallback.onReceiveValue(null);
        AppMethodBeat.m2505o(84683);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        AppMethodBeat.m2504i(84684);
        Log.m81049i("SysWebView", "onShowFileChooser last method");
        boolean a;
        if (this.AQc.APV != null) {
            a = this.AQc.APV.mo13206a(this.AQc.APS, valueCallback, new C16397b(fileChooserParams));
            AppMethodBeat.m2505o(84684);
            return a;
        }
        a = super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        AppMethodBeat.m2505o(84684);
        return a;
    }

    public View getVideoLoadingProgressView() {
        AppMethodBeat.m2504i(84685);
        View videoLoadingProgressView;
        if (this.AQc.APV != null) {
            videoLoadingProgressView = this.AQc.APV.getVideoLoadingProgressView();
            AppMethodBeat.m2505o(84685);
            return videoLoadingProgressView;
        }
        videoLoadingProgressView = LayoutInflater.from(this.AQc.APS.getContext()).inflate(2130970993, null);
        AppMethodBeat.m2505o(84685);
        return videoLoadingProgressView;
    }
}
