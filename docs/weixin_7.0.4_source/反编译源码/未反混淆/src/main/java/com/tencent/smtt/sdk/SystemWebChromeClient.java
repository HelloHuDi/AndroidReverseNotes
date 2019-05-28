package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebStorage.QuotaUpdater;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

class SystemWebChromeClient extends WebChromeClient {
    private WebView a;
    private WebChromeClient b;

    class f implements QuotaUpdater {
        WebStorage.QuotaUpdater a;

        f(WebStorage.QuotaUpdater quotaUpdater) {
            this.a = quotaUpdater;
        }

        public void updateQuota(long j) {
            AppMethodBeat.i(64170);
            this.a.updateQuota(j);
            AppMethodBeat.o(64170);
        }
    }

    class e implements JsResult {
        android.webkit.JsResult a;

        e(android.webkit.JsResult jsResult) {
            this.a = jsResult;
        }

        public void cancel() {
            AppMethodBeat.i(64168);
            this.a.cancel();
            AppMethodBeat.o(64168);
        }

        public void confirm() {
            AppMethodBeat.i(64169);
            this.a.confirm();
            AppMethodBeat.o(64169);
        }
    }

    class d implements JsPromptResult {
        android.webkit.JsPromptResult a;

        d(android.webkit.JsPromptResult jsPromptResult) {
            this.a = jsPromptResult;
        }

        public void cancel() {
            AppMethodBeat.i(64165);
            this.a.cancel();
            AppMethodBeat.o(64165);
        }

        public void confirm() {
            AppMethodBeat.i(64166);
            this.a.confirm();
            AppMethodBeat.o(64166);
        }

        public void confirm(String str) {
            AppMethodBeat.i(64167);
            this.a.confirm(str);
            AppMethodBeat.o(64167);
        }
    }

    static class a implements ConsoleMessage {
        private MessageLevel a;
        private String b;
        private String c;
        private int d;

        a(android.webkit.ConsoleMessage consoleMessage) {
            AppMethodBeat.i(64162);
            this.a = MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.b = consoleMessage.message();
            this.c = consoleMessage.sourceId();
            this.d = consoleMessage.lineNumber();
            AppMethodBeat.o(64162);
        }

        a(String str, String str2, int i) {
            this.a = MessageLevel.LOG;
            this.b = str;
            this.c = str2;
            this.d = i;
        }

        public int lineNumber() {
            return this.d;
        }

        public String message() {
            return this.b;
        }

        public MessageLevel messageLevel() {
            return this.a;
        }

        public String sourceId() {
            return this.c;
        }
    }

    class c implements GeolocationPermissionsCallback {
        Callback a;

        c(Callback callback) {
            this.a = callback;
        }

        public void invoke(String str, boolean z, boolean z2) {
            AppMethodBeat.i(64164);
            this.a.invoke(str, z, z2);
            AppMethodBeat.o(64164);
        }
    }

    class b implements CustomViewCallback {
        WebChromeClient.CustomViewCallback a;

        b(WebChromeClient.CustomViewCallback customViewCallback) {
            this.a = customViewCallback;
        }

        public void onCustomViewHidden() {
            AppMethodBeat.i(64163);
            this.a.onCustomViewHidden();
            AppMethodBeat.o(64163);
        }
    }

    SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.a = webView;
        this.b = webChromeClient;
    }

    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        AppMethodBeat.i(64171);
        Bitmap defaultVideoPoster = this.b.getDefaultVideoPoster();
        if (defaultVideoPoster == null) {
            try {
                if (VERSION.SDK_INT >= 24) {
                    defaultVideoPoster = BitmapFactory.decodeResource(this.a.getResources(), 17301540);
                    AppMethodBeat.o(64171);
                    return defaultVideoPoster;
                }
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(64171);
        return defaultVideoPoster;
    }

    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        AppMethodBeat.i(64172);
        View videoLoadingProgressView = this.b.getVideoLoadingProgressView();
        AppMethodBeat.o(64172);
        return videoLoadingProgressView;
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        AppMethodBeat.i(64173);
        this.b.getVisitedHistory(new y(this, valueCallback));
        AppMethodBeat.o(64173);
    }

    public void onCloseWindow(WebView webView) {
        AppMethodBeat.i(64174);
        this.a.a(webView);
        this.b.onCloseWindow(this.a);
        AppMethodBeat.o(64174);
    }

    public void onConsoleMessage(String str, int i, String str2) {
        AppMethodBeat.i(64176);
        this.b.onConsoleMessage(new a(str, str2, i));
        AppMethodBeat.o(64176);
    }

    public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        AppMethodBeat.i(64175);
        boolean onConsoleMessage = this.b.onConsoleMessage(new a(consoleMessage));
        AppMethodBeat.o(64175);
        return onConsoleMessage;
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        AppMethodBeat.i(64177);
        WebView webView2 = this.a;
        webView2.getClass();
        WebViewTransport webViewTransport = new WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new z(this, webViewTransport, message));
        obtain.obj = webViewTransport;
        boolean onCreateWindow = this.b.onCreateWindow(this.a, z, z2, obtain);
        AppMethodBeat.o(64177);
        return onCreateWindow;
    }

    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(64178);
        this.b.onExceededDatabaseQuota(str, str2, j, j2, j3, new f(quotaUpdater));
        AppMethodBeat.o(64178);
    }

    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.i(64179);
        this.b.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(64179);
    }

    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        AppMethodBeat.i(64180);
        this.b.onGeolocationPermissionsShowPrompt(str, new c(callback));
        AppMethodBeat.o(64180);
    }

    @TargetApi(7)
    public void onHideCustomView() {
        AppMethodBeat.i(64181);
        this.b.onHideCustomView();
        AppMethodBeat.o(64181);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        AppMethodBeat.i(64182);
        this.a.a(webView);
        boolean onJsAlert = this.b.onJsAlert(this.a, str, str2, new e(jsResult));
        AppMethodBeat.o(64182);
        return onJsAlert;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        AppMethodBeat.i(64183);
        this.a.a(webView);
        boolean onJsBeforeUnload = this.b.onJsBeforeUnload(this.a, str, str2, new e(jsResult));
        AppMethodBeat.o(64183);
        return onJsBeforeUnload;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        AppMethodBeat.i(64184);
        this.a.a(webView);
        boolean onJsConfirm = this.b.onJsConfirm(this.a, str, str2, new e(jsResult));
        AppMethodBeat.o(64184);
        return onJsConfirm;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, android.webkit.JsPromptResult jsPromptResult) {
        AppMethodBeat.i(64185);
        this.a.a(webView);
        boolean onJsPrompt = this.b.onJsPrompt(this.a, str, str2, str3, new d(jsPromptResult));
        AppMethodBeat.o(64185);
        return onJsPrompt;
    }

    @TargetApi(7)
    public boolean onJsTimeout() {
        AppMethodBeat.i(64186);
        boolean onJsTimeout = this.b.onJsTimeout();
        AppMethodBeat.o(64186);
        return onJsTimeout;
    }

    public void onProgressChanged(WebView webView, int i) {
        AppMethodBeat.i(64187);
        this.a.a(webView);
        this.b.onProgressChanged(this.a, i);
        AppMethodBeat.o(64187);
    }

    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(64188);
        this.b.onReachedMaxAppCacheSize(j, j2, new f(quotaUpdater));
        AppMethodBeat.o(64188);
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        AppMethodBeat.i(64189);
        this.a.a(webView);
        this.b.onReceivedIcon(this.a, bitmap);
        AppMethodBeat.o(64189);
    }

    public void onReceivedTitle(WebView webView, String str) {
        AppMethodBeat.i(64190);
        this.a.a(webView);
        this.b.onReceivedTitle(this.a, str);
        AppMethodBeat.o(64190);
    }

    @TargetApi(7)
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        AppMethodBeat.i(64191);
        this.a.a(webView);
        this.b.onReceivedTouchIconUrl(this.a, str, z);
        AppMethodBeat.o(64191);
    }

    public void onRequestFocus(WebView webView) {
        AppMethodBeat.i(64192);
        this.a.a(webView);
        this.b.onRequestFocus(this.a);
        AppMethodBeat.o(64192);
    }

    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(64194);
        this.b.onShowCustomView(view, i, new b(customViewCallback));
        AppMethodBeat.o(64194);
    }

    @TargetApi(7)
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(64193);
        this.b.onShowCustomView(view, new b(customViewCallback));
        AppMethodBeat.o(64193);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        AppMethodBeat.i(64198);
        ab abVar = new ab(this, valueCallback);
        ac acVar = new ac(this, fileChooserParams);
        this.a.a(webView);
        boolean onShowFileChooser = this.b.onShowFileChooser(this.a, abVar, acVar);
        AppMethodBeat.o(64198);
        return onShowFileChooser;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        AppMethodBeat.i(64195);
        openFileChooser(valueCallback, null, null);
        AppMethodBeat.o(64195);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        AppMethodBeat.i(64196);
        openFileChooser(valueCallback, str, null);
        AppMethodBeat.o(64196);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(64197);
        this.b.openFileChooser(new aa(this, valueCallback), str, str2);
        AppMethodBeat.o(64197);
    }

    public void setupAutoFill(Message message) {
    }
}
