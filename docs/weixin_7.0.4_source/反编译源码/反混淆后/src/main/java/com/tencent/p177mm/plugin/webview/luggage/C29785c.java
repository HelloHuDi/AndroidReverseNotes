package com.tencent.p177mm.plugin.webview.luggage;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C41127g;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.C6031l.C6032a;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.webview.luggage.c */
public class C29785c extends C6031l {
    private C6031l uhP = new C6031l();

    public C29785c() {
        AppMethodBeat.m2504i(5989);
        AppMethodBeat.m2505o(5989);
    }

    /* renamed from: a */
    public final void mo48031a(C6031l c6031l) {
        if (c6031l != null) {
            this.uhP = c6031l;
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.m2504i(5990);
        boolean onConsoleMessage = this.uhP.onConsoleMessage(consoleMessage);
        AppMethodBeat.m2505o(5990);
        return onConsoleMessage;
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        AppMethodBeat.m2504i(5991);
        this.uhP.onGeolocationPermissionsShowPrompt(str, callback);
        AppMethodBeat.m2505o(5991);
    }

    public final void onHideCustomView() {
        AppMethodBeat.m2504i(5992);
        this.uhP.onHideCustomView();
        AppMethodBeat.m2505o(5992);
    }

    /* renamed from: a */
    public final boolean mo13207a(WebView webView, String str, String str2, C46945h c46945h) {
        AppMethodBeat.m2504i(5993);
        boolean a = this.uhP.mo13207a(webView, str, str2, c46945h);
        AppMethodBeat.m2505o(5993);
        return a;
    }

    /* renamed from: b */
    public final boolean mo13211b(WebView webView, String str, String str2, C46945h c46945h) {
        AppMethodBeat.m2504i(5994);
        boolean b = this.uhP.mo13211b(webView, str, str2, c46945h);
        AppMethodBeat.m2505o(5994);
        return b;
    }

    /* renamed from: a */
    public final boolean mo13208a(WebView webView, String str, String str2, String str3, C41127g c41127g) {
        AppMethodBeat.m2504i(5995);
        boolean a = this.uhP.mo13208a(webView, str, str2, str3, c41127g);
        AppMethodBeat.m2505o(5995);
        return a;
    }

    public final View getVideoLoadingProgressView() {
        AppMethodBeat.m2504i(5996);
        View videoLoadingProgressView = this.uhP.getVideoLoadingProgressView();
        AppMethodBeat.m2505o(5996);
        return videoLoadingProgressView;
    }

    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.m2504i(5997);
        this.uhP.openFileChooser(valueCallback, str, str2);
        AppMethodBeat.m2505o(5997);
    }

    /* renamed from: a */
    public final boolean mo13206a(WebView webView, ValueCallback<Uri[]> valueCallback, C6032a c6032a) {
        AppMethodBeat.m2504i(5998);
        boolean a = this.uhP.mo13206a(webView, valueCallback, c6032a);
        AppMethodBeat.m2505o(5998);
        return a;
    }

    /* renamed from: a */
    public final void mo13205a(WebView webView, int i) {
        AppMethodBeat.m2504i(5999);
        this.uhP.mo13205a(webView, i);
        AppMethodBeat.m2505o(5999);
    }

    /* renamed from: d */
    public void mo7557d(WebView webView, String str) {
        AppMethodBeat.m2504i(6000);
        this.uhP.mo7557d(webView, str);
        AppMethodBeat.m2505o(6000);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.m2504i(6001);
        this.uhP.onShowCustomView(view, customViewCallback);
        AppMethodBeat.m2505o(6001);
    }
}
