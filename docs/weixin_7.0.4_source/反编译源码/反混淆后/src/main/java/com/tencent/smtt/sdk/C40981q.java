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

/* renamed from: com.tencent.smtt.sdk.q */
class C40981q extends X5ProxyWebChromeClient {
    /* renamed from: a */
    private WebView f16307a;
    /* renamed from: b */
    private WebChromeClient f16308b;

    /* renamed from: com.tencent.smtt.sdk.q$a */
    class C40982a implements QuotaUpdater {
        /* renamed from: a */
        com.tencent.smtt.export.external.interfaces.QuotaUpdater f16309a;

        C40982a(com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
            this.f16309a = quotaUpdater;
        }

        public void updateQuota(long j) {
            AppMethodBeat.m2504i(64091);
            this.f16309a.updateQuota(j);
            AppMethodBeat.m2505o(64091);
        }
    }

    public C40981q(IX5WebChromeClient iX5WebChromeClient, WebView webView, WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.f16307a = webView;
        this.f16308b = webChromeClient;
    }

    public Bitmap getDefaultVideoPoster() {
        AppMethodBeat.m2504i(64093);
        Bitmap defaultVideoPoster = this.f16308b.getDefaultVideoPoster();
        AppMethodBeat.m2505o(64093);
        return defaultVideoPoster;
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        AppMethodBeat.m2504i(64094);
        this.f16307a.mo49872a(iX5WebViewBase);
        this.f16308b.onCloseWindow(this.f16307a);
        AppMethodBeat.m2505o(64094);
    }

    public void onConsoleMessage(String str, int i, String str2) {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.m2504i(64095);
        boolean onConsoleMessage = this.f16308b.onConsoleMessage(consoleMessage);
        AppMethodBeat.m2505o(64095);
        return onConsoleMessage;
    }

    public boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, Message message) {
        AppMethodBeat.m2504i(64096);
        WebView webView = this.f16307a;
        webView.getClass();
        WebViewTransport webViewTransport = new WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new C36440r(this, webViewTransport, message));
        obtain.obj = webViewTransport;
        boolean onCreateWindow = this.f16308b.onCreateWindow(this.f16307a, z, z2, obtain);
        AppMethodBeat.m2505o(64096);
        return onCreateWindow;
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        AppMethodBeat.m2504i(64092);
        this.f16308b.onExceededDatabaseQuota(str, str2, j, j2, j3, new C40982a(quotaUpdater));
        AppMethodBeat.m2505o(64092);
    }

    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.m2504i(64097);
        this.f16308b.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.m2505o(64097);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        AppMethodBeat.m2504i(64098);
        this.f16308b.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        AppMethodBeat.m2505o(64098);
    }

    public void onHideCustomView() {
        AppMethodBeat.m2504i(64099);
        this.f16308b.onHideCustomView();
        AppMethodBeat.m2505o(64099);
    }

    public boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.m2504i(64100);
        this.f16307a.mo49872a(iX5WebViewBase);
        boolean onJsAlert = this.f16308b.onJsAlert(this.f16307a, str, str2, jsResult);
        AppMethodBeat.m2505o(64100);
        return onJsAlert;
    }

    public boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.m2504i(64103);
        this.f16307a.mo49872a(iX5WebViewBase);
        boolean onJsBeforeUnload = this.f16308b.onJsBeforeUnload(this.f16307a, str, str2, jsResult);
        AppMethodBeat.m2505o(64103);
        return onJsBeforeUnload;
    }

    public boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.m2504i(64101);
        this.f16307a.mo49872a(iX5WebViewBase);
        boolean onJsConfirm = this.f16308b.onJsConfirm(this.f16307a, str, str2, jsResult);
        AppMethodBeat.m2505o(64101);
        return onJsConfirm;
    }

    public boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.m2504i(64102);
        this.f16307a.mo49872a(iX5WebViewBase);
        boolean onJsPrompt = this.f16308b.onJsPrompt(this.f16307a, str, str2, str3, jsPromptResult);
        AppMethodBeat.m2505o(64102);
        return onJsPrompt;
    }

    public boolean onJsTimeout() {
        AppMethodBeat.m2504i(64104);
        boolean onJsTimeout = this.f16308b.onJsTimeout();
        AppMethodBeat.m2505o(64104);
        return onJsTimeout;
    }

    public void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i) {
        AppMethodBeat.m2504i(64105);
        this.f16307a.mo49872a(iX5WebViewBase);
        this.f16308b.onProgressChanged(this.f16307a, i);
        AppMethodBeat.m2505o(64105);
    }

    public void onReachedMaxAppCacheSize(long j, long j2, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        AppMethodBeat.m2504i(64106);
        this.f16308b.onReachedMaxAppCacheSize(j, j2, new C40982a(quotaUpdater));
        AppMethodBeat.m2505o(64106);
    }

    public void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        AppMethodBeat.m2504i(64107);
        this.f16307a.mo49872a(iX5WebViewBase);
        this.f16308b.onReceivedIcon(this.f16307a, bitmap);
        AppMethodBeat.m2505o(64107);
    }

    public void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.m2504i(64109);
        this.f16307a.mo49872a(iX5WebViewBase);
        this.f16308b.onReceivedTitle(this.f16307a, str);
        AppMethodBeat.m2505o(64109);
    }

    public void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        AppMethodBeat.m2504i(64108);
        this.f16307a.mo49872a(iX5WebViewBase);
        this.f16308b.onReceivedTouchIconUrl(this.f16307a, str, z);
        AppMethodBeat.m2505o(64108);
    }

    public void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        AppMethodBeat.m2504i(64110);
        this.f16307a.mo49872a(iX5WebViewBase);
        this.f16308b.onRequestFocus(this.f16307a);
        AppMethodBeat.m2505o(64110);
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        AppMethodBeat.m2504i(64112);
        this.f16308b.onShowCustomView(view, i, customViewCallback);
        AppMethodBeat.m2505o(64112);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.m2504i(64111);
        this.f16308b.onShowCustomView(view, customViewCallback);
        AppMethodBeat.m2505o(64111);
    }

    public boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        AppMethodBeat.m2504i(64114);
        C36442t c36442t = new C36442t(this, valueCallback);
        C16154u c16154u = new C16154u(this, fileChooserParams);
        this.f16307a.mo49872a(iX5WebViewBase);
        boolean onShowFileChooser = this.f16308b.onShowFileChooser(this.f16307a, c36442t, c16154u);
        AppMethodBeat.m2505o(64114);
        return onShowFileChooser;
    }

    public void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(64113);
        this.f16308b.openFileChooser(new C36441s(this, valueCallback), str, str2);
        AppMethodBeat.m2505o(64113);
    }
}
