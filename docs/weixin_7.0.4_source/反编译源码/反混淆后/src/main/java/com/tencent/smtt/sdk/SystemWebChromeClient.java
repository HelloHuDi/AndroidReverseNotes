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
    /* renamed from: a */
    private WebView f17969a;
    /* renamed from: b */
    private WebChromeClient f17970b;

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$f */
    class C24259f implements QuotaUpdater {
        /* renamed from: a */
        WebStorage.QuotaUpdater f4484a;

        C24259f(WebStorage.QuotaUpdater quotaUpdater) {
            this.f4484a = quotaUpdater;
        }

        public void updateQuota(long j) {
            AppMethodBeat.m2504i(64170);
            this.f4484a.updateQuota(j);
            AppMethodBeat.m2505o(64170);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$e */
    class C24996e implements JsResult {
        /* renamed from: a */
        android.webkit.JsResult f4959a;

        C24996e(android.webkit.JsResult jsResult) {
            this.f4959a = jsResult;
        }

        public void cancel() {
            AppMethodBeat.m2504i(64168);
            this.f4959a.cancel();
            AppMethodBeat.m2505o(64168);
        }

        public void confirm() {
            AppMethodBeat.m2504i(64169);
            this.f4959a.confirm();
            AppMethodBeat.m2505o(64169);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$d */
    class C30940d implements JsPromptResult {
        /* renamed from: a */
        android.webkit.JsPromptResult f13839a;

        C30940d(android.webkit.JsPromptResult jsPromptResult) {
            this.f13839a = jsPromptResult;
        }

        public void cancel() {
            AppMethodBeat.m2504i(64165);
            this.f13839a.cancel();
            AppMethodBeat.m2505o(64165);
        }

        public void confirm() {
            AppMethodBeat.m2504i(64166);
            this.f13839a.confirm();
            AppMethodBeat.m2505o(64166);
        }

        public void confirm(String str) {
            AppMethodBeat.m2504i(64167);
            this.f13839a.confirm(str);
            AppMethodBeat.m2505o(64167);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$a */
    static class C40967a implements ConsoleMessage {
        /* renamed from: a */
        private MessageLevel f16267a;
        /* renamed from: b */
        private String f16268b;
        /* renamed from: c */
        private String f16269c;
        /* renamed from: d */
        private int f16270d;

        C40967a(android.webkit.ConsoleMessage consoleMessage) {
            AppMethodBeat.m2504i(64162);
            this.f16267a = MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.f16268b = consoleMessage.message();
            this.f16269c = consoleMessage.sourceId();
            this.f16270d = consoleMessage.lineNumber();
            AppMethodBeat.m2505o(64162);
        }

        C40967a(String str, String str2, int i) {
            this.f16267a = MessageLevel.LOG;
            this.f16268b = str;
            this.f16269c = str2;
            this.f16270d = i;
        }

        public int lineNumber() {
            return this.f16270d;
        }

        public String message() {
            return this.f16268b;
        }

        public MessageLevel messageLevel() {
            return this.f16267a;
        }

        public String sourceId() {
            return this.f16269c;
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$c */
    class C40968c implements GeolocationPermissionsCallback {
        /* renamed from: a */
        Callback f16271a;

        C40968c(Callback callback) {
            this.f16271a = callback;
        }

        public void invoke(String str, boolean z, boolean z2) {
            AppMethodBeat.m2504i(64164);
            this.f16271a.invoke(str, z, z2);
            AppMethodBeat.m2505o(64164);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.SystemWebChromeClient$b */
    class C46733b implements CustomViewCallback {
        /* renamed from: a */
        WebChromeClient.CustomViewCallback f17967a;

        C46733b(WebChromeClient.CustomViewCallback customViewCallback) {
            this.f17967a = customViewCallback;
        }

        public void onCustomViewHidden() {
            AppMethodBeat.m2504i(64163);
            this.f17967a.onCustomViewHidden();
            AppMethodBeat.m2505o(64163);
        }
    }

    SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.f17969a = webView;
        this.f17970b = webChromeClient;
    }

    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        AppMethodBeat.m2504i(64171);
        Bitmap defaultVideoPoster = this.f17970b.getDefaultVideoPoster();
        if (defaultVideoPoster == null) {
            try {
                if (VERSION.SDK_INT >= 24) {
                    defaultVideoPoster = BitmapFactory.decodeResource(this.f17969a.getResources(), 17301540);
                    AppMethodBeat.m2505o(64171);
                    return defaultVideoPoster;
                }
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(64171);
        return defaultVideoPoster;
    }

    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        AppMethodBeat.m2504i(64172);
        View videoLoadingProgressView = this.f17970b.getVideoLoadingProgressView();
        AppMethodBeat.m2505o(64172);
        return videoLoadingProgressView;
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        AppMethodBeat.m2504i(64173);
        this.f17970b.getVisitedHistory(new C46742y(this, valueCallback));
        AppMethodBeat.m2505o(64173);
    }

    public void onCloseWindow(WebView webView) {
        AppMethodBeat.m2504i(64174);
        this.f17969a.mo49871a(webView);
        this.f17970b.onCloseWindow(this.f17969a);
        AppMethodBeat.m2505o(64174);
    }

    public void onConsoleMessage(String str, int i, String str2) {
        AppMethodBeat.m2504i(64176);
        this.f17970b.onConsoleMessage(new C40967a(str, str2, i));
        AppMethodBeat.m2505o(64176);
    }

    public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        AppMethodBeat.m2504i(64175);
        boolean onConsoleMessage = this.f17970b.onConsoleMessage(new C40967a(consoleMessage));
        AppMethodBeat.m2505o(64175);
        return onConsoleMessage;
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        AppMethodBeat.m2504i(64177);
        WebView webView2 = this.f17969a;
        webView2.getClass();
        WebViewTransport webViewTransport = new WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new C40983z(this, webViewTransport, message));
        obtain.obj = webViewTransport;
        boolean onCreateWindow = this.f17970b.onCreateWindow(this.f17969a, z, z2, obtain);
        AppMethodBeat.m2505o(64177);
        return onCreateWindow;
    }

    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        AppMethodBeat.m2504i(64178);
        this.f17970b.onExceededDatabaseQuota(str, str2, j, j2, j3, new C24259f(quotaUpdater));
        AppMethodBeat.m2505o(64178);
    }

    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.m2504i(64179);
        this.f17970b.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.m2505o(64179);
    }

    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        AppMethodBeat.m2504i(64180);
        this.f17970b.onGeolocationPermissionsShowPrompt(str, new C40968c(callback));
        AppMethodBeat.m2505o(64180);
    }

    @TargetApi(7)
    public void onHideCustomView() {
        AppMethodBeat.m2504i(64181);
        this.f17970b.onHideCustomView();
        AppMethodBeat.m2505o(64181);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        AppMethodBeat.m2504i(64182);
        this.f17969a.mo49871a(webView);
        boolean onJsAlert = this.f17970b.onJsAlert(this.f17969a, str, str2, new C24996e(jsResult));
        AppMethodBeat.m2505o(64182);
        return onJsAlert;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        AppMethodBeat.m2504i(64183);
        this.f17969a.mo49871a(webView);
        boolean onJsBeforeUnload = this.f17970b.onJsBeforeUnload(this.f17969a, str, str2, new C24996e(jsResult));
        AppMethodBeat.m2505o(64183);
        return onJsBeforeUnload;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        AppMethodBeat.m2504i(64184);
        this.f17969a.mo49871a(webView);
        boolean onJsConfirm = this.f17970b.onJsConfirm(this.f17969a, str, str2, new C24996e(jsResult));
        AppMethodBeat.m2505o(64184);
        return onJsConfirm;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, android.webkit.JsPromptResult jsPromptResult) {
        AppMethodBeat.m2504i(64185);
        this.f17969a.mo49871a(webView);
        boolean onJsPrompt = this.f17970b.onJsPrompt(this.f17969a, str, str2, str3, new C30940d(jsPromptResult));
        AppMethodBeat.m2505o(64185);
        return onJsPrompt;
    }

    @TargetApi(7)
    public boolean onJsTimeout() {
        AppMethodBeat.m2504i(64186);
        boolean onJsTimeout = this.f17970b.onJsTimeout();
        AppMethodBeat.m2505o(64186);
        return onJsTimeout;
    }

    public void onProgressChanged(WebView webView, int i) {
        AppMethodBeat.m2504i(64187);
        this.f17969a.mo49871a(webView);
        this.f17970b.onProgressChanged(this.f17969a, i);
        AppMethodBeat.m2505o(64187);
    }

    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        AppMethodBeat.m2504i(64188);
        this.f17970b.onReachedMaxAppCacheSize(j, j2, new C24259f(quotaUpdater));
        AppMethodBeat.m2505o(64188);
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        AppMethodBeat.m2504i(64189);
        this.f17969a.mo49871a(webView);
        this.f17970b.onReceivedIcon(this.f17969a, bitmap);
        AppMethodBeat.m2505o(64189);
    }

    public void onReceivedTitle(WebView webView, String str) {
        AppMethodBeat.m2504i(64190);
        this.f17969a.mo49871a(webView);
        this.f17970b.onReceivedTitle(this.f17969a, str);
        AppMethodBeat.m2505o(64190);
    }

    @TargetApi(7)
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        AppMethodBeat.m2504i(64191);
        this.f17969a.mo49871a(webView);
        this.f17970b.onReceivedTouchIconUrl(this.f17969a, str, z);
        AppMethodBeat.m2505o(64191);
    }

    public void onRequestFocus(WebView webView) {
        AppMethodBeat.m2504i(64192);
        this.f17969a.mo49871a(webView);
        this.f17970b.onRequestFocus(this.f17969a);
        AppMethodBeat.m2505o(64192);
    }

    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.m2504i(64194);
        this.f17970b.onShowCustomView(view, i, new C46733b(customViewCallback));
        AppMethodBeat.m2505o(64194);
    }

    @TargetApi(7)
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.m2504i(64193);
        this.f17970b.onShowCustomView(view, new C46733b(customViewCallback));
        AppMethodBeat.m2505o(64193);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        AppMethodBeat.m2504i(64198);
        C46735ab c46735ab = new C46735ab(this, valueCallback);
        C24265ac c24265ac = new C24265ac(this, fileChooserParams);
        this.f17969a.mo49871a(webView);
        boolean onShowFileChooser = this.f17970b.onShowFileChooser(this.f17969a, c46735ab, c24265ac);
        AppMethodBeat.m2505o(64198);
        return onShowFileChooser;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        AppMethodBeat.m2504i(64195);
        openFileChooser(valueCallback, null, null);
        AppMethodBeat.m2505o(64195);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        AppMethodBeat.m2504i(64196);
        openFileChooser(valueCallback, str, null);
        AppMethodBeat.m2505o(64196);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.m2504i(64197);
        this.f17970b.openFileChooser(new C40971aa(this, valueCallback), str, str2);
        AppMethodBeat.m2505o(64197);
    }

    public void setupAutoFill(Message message) {
    }
}
