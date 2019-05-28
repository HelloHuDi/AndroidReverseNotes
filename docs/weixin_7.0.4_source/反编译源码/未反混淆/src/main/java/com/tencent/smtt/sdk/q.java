package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;
import com.tencent.smtt.sdk.WebStorage.QuotaUpdater;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

class q extends X5ProxyWebChromeClient {
    private WebView a;
    private WebChromeClient b;

    class a implements QuotaUpdater {
        com.tencent.smtt.export.external.interfaces.QuotaUpdater a;

        a(com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
            this.a = quotaUpdater;
        }

        public void updateQuota(long j) {
            AppMethodBeat.i(64091);
            this.a.updateQuota(j);
            AppMethodBeat.o(64091);
        }
    }

    public q(IX5WebChromeClient iX5WebChromeClient, WebView webView, WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.a = webView;
        this.b = webChromeClient;
    }

    public Bitmap getDefaultVideoPoster() {
        AppMethodBeat.i(64093);
        Bitmap defaultVideoPoster = this.b.getDefaultVideoPoster();
        AppMethodBeat.o(64093);
        return defaultVideoPoster;
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        AppMethodBeat.i(64094);
        this.a.a(iX5WebViewBase);
        this.b.onCloseWindow(this.a);
        AppMethodBeat.o(64094);
    }

    public void onConsoleMessage(String str, int i, String str2) {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(64095);
        boolean onConsoleMessage = this.b.onConsoleMessage(consoleMessage);
        AppMethodBeat.o(64095);
        return onConsoleMessage;
    }

    public boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, Message message) {
        AppMethodBeat.i(64096);
        WebView webView = this.a;
        webView.getClass();
        WebViewTransport webViewTransport = new WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new r(this, webViewTransport, message));
        obtain.obj = webViewTransport;
        boolean onCreateWindow = this.b.onCreateWindow(this.a, z, z2, obtain);
        AppMethodBeat.o(64096);
        return onCreateWindow;
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(64092);
        this.b.onExceededDatabaseQuota(str, str2, j, j2, j3, new a(quotaUpdater));
        AppMethodBeat.o(64092);
    }

    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.i(64097);
        this.b.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(64097);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        AppMethodBeat.i(64098);
        this.b.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        AppMethodBeat.o(64098);
    }

    public void onHideCustomView() {
        AppMethodBeat.i(64099);
        this.b.onHideCustomView();
        AppMethodBeat.o(64099);
    }

    public boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(64100);
        this.a.a(iX5WebViewBase);
        boolean onJsAlert = this.b.onJsAlert(this.a, str, str2, jsResult);
        AppMethodBeat.o(64100);
        return onJsAlert;
    }

    public boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(64103);
        this.a.a(iX5WebViewBase);
        boolean onJsBeforeUnload = this.b.onJsBeforeUnload(this.a, str, str2, jsResult);
        AppMethodBeat.o(64103);
        return onJsBeforeUnload;
    }

    public boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(64101);
        this.a.a(iX5WebViewBase);
        boolean onJsConfirm = this.b.onJsConfirm(this.a, str, str2, jsResult);
        AppMethodBeat.o(64101);
        return onJsConfirm;
    }

    public boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.i(64102);
        this.a.a(iX5WebViewBase);
        boolean onJsPrompt = this.b.onJsPrompt(this.a, str, str2, str3, jsPromptResult);
        AppMethodBeat.o(64102);
        return onJsPrompt;
    }

    public boolean onJsTimeout() {
        AppMethodBeat.i(64104);
        boolean onJsTimeout = this.b.onJsTimeout();
        AppMethodBeat.o(64104);
        return onJsTimeout;
    }

    public void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i) {
        AppMethodBeat.i(64105);
        this.a.a(iX5WebViewBase);
        this.b.onProgressChanged(this.a, i);
        AppMethodBeat.o(64105);
    }

    public void onReachedMaxAppCacheSize(long j, long j2, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(64106);
        this.b.onReachedMaxAppCacheSize(j, j2, new a(quotaUpdater));
        AppMethodBeat.o(64106);
    }

    public void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        AppMethodBeat.i(64107);
        this.a.a(iX5WebViewBase);
        this.b.onReceivedIcon(this.a, bitmap);
        AppMethodBeat.o(64107);
    }

    public void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(64109);
        this.a.a(iX5WebViewBase);
        this.b.onReceivedTitle(this.a, str);
        AppMethodBeat.o(64109);
    }

    public void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        AppMethodBeat.i(64108);
        this.a.a(iX5WebViewBase);
        this.b.onReceivedTouchIconUrl(this.a, str, z);
        AppMethodBeat.o(64108);
    }

    public void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        AppMethodBeat.i(64110);
        this.a.a(iX5WebViewBase);
        this.b.onRequestFocus(this.a);
        AppMethodBeat.o(64110);
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(64112);
        this.b.onShowCustomView(view, i, customViewCallback);
        AppMethodBeat.o(64112);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(64111);
        this.b.onShowCustomView(view, customViewCallback);
        AppMethodBeat.o(64111);
    }

    public boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        AppMethodBeat.i(64114);
        t tVar = new t(this, valueCallback);
        u uVar = new u(this, fileChooserParams);
        this.a.a(iX5WebViewBase);
        boolean onShowFileChooser = this.b.onShowFileChooser(this.a, tVar, uVar);
        AppMethodBeat.o(64114);
        return onShowFileChooser;
    }

    public void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z) {
        AppMethodBeat.i(64113);
        this.b.openFileChooser(new s(this, valueCallback), str, str2);
        AppMethodBeat.o(64113);
    }
}
