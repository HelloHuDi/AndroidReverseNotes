package com.tencent.mm.plugin.webview.luggage;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.g;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.l.a;

public class c extends l {
    private l uhP = new l();

    public c() {
        AppMethodBeat.i(5989);
        AppMethodBeat.o(5989);
    }

    public final void a(l lVar) {
        if (lVar != null) {
            this.uhP = lVar;
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(5990);
        boolean onConsoleMessage = this.uhP.onConsoleMessage(consoleMessage);
        AppMethodBeat.o(5990);
        return onConsoleMessage;
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        AppMethodBeat.i(5991);
        this.uhP.onGeolocationPermissionsShowPrompt(str, callback);
        AppMethodBeat.o(5991);
    }

    public final void onHideCustomView() {
        AppMethodBeat.i(5992);
        this.uhP.onHideCustomView();
        AppMethodBeat.o(5992);
    }

    public final boolean a(WebView webView, String str, String str2, h hVar) {
        AppMethodBeat.i(5993);
        boolean a = this.uhP.a(webView, str, str2, hVar);
        AppMethodBeat.o(5993);
        return a;
    }

    public final boolean b(WebView webView, String str, String str2, h hVar) {
        AppMethodBeat.i(5994);
        boolean b = this.uhP.b(webView, str, str2, hVar);
        AppMethodBeat.o(5994);
        return b;
    }

    public final boolean a(WebView webView, String str, String str2, String str3, g gVar) {
        AppMethodBeat.i(5995);
        boolean a = this.uhP.a(webView, str, str2, str3, gVar);
        AppMethodBeat.o(5995);
        return a;
    }

    public final View getVideoLoadingProgressView() {
        AppMethodBeat.i(5996);
        View videoLoadingProgressView = this.uhP.getVideoLoadingProgressView();
        AppMethodBeat.o(5996);
        return videoLoadingProgressView;
    }

    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(5997);
        this.uhP.openFileChooser(valueCallback, str, str2);
        AppMethodBeat.o(5997);
    }

    public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, a aVar) {
        AppMethodBeat.i(5998);
        boolean a = this.uhP.a(webView, valueCallback, aVar);
        AppMethodBeat.o(5998);
        return a;
    }

    public final void a(WebView webView, int i) {
        AppMethodBeat.i(5999);
        this.uhP.a(webView, i);
        AppMethodBeat.o(5999);
    }

    public void d(WebView webView, String str) {
        AppMethodBeat.i(6000);
        this.uhP.d(webView, str);
        AppMethodBeat.o(6000);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(6001);
        this.uhP.onShowCustomView(view, customViewCallback);
        AppMethodBeat.o(6001);
    }
}
