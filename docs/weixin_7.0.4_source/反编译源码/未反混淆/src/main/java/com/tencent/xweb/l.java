package com.tencent.xweb;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.e;

public class l {
    e AMp;

    public static abstract class a {
        public abstract String[] getAcceptTypes();

        public abstract int getMode();

        public abstract boolean isCaptureEnabled();
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        AppMethodBeat.i(3818);
        callback.invoke(str, true, true);
        AppMethodBeat.o(3818);
    }

    public void onHideCustomView() {
        AppMethodBeat.i(3819);
        if (this.AMp != null) {
            this.AMp.onHideCustomView();
        }
        AppMethodBeat.o(3819);
    }

    public boolean a(WebView webView, String str, String str2, h hVar) {
        AppMethodBeat.i(3820);
        if (this.AMp != null) {
            boolean a = this.AMp.a(str, str2, hVar);
            AppMethodBeat.o(3820);
            return a;
        }
        AppMethodBeat.o(3820);
        return false;
    }

    public boolean b(WebView webView, String str, String str2, h hVar) {
        AppMethodBeat.i(3821);
        if (this.AMp != null) {
            boolean b = this.AMp.b(str, str2, hVar);
            AppMethodBeat.o(3821);
            return b;
        }
        AppMethodBeat.o(3821);
        return false;
    }

    public boolean a(WebView webView, String str, String str2, String str3, g gVar) {
        AppMethodBeat.i(3822);
        if (this.AMp != null) {
            boolean a = this.AMp.a(str, str2, str3, gVar);
            AppMethodBeat.o(3822);
            return a;
        }
        AppMethodBeat.o(3822);
        return false;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(3823);
        valueCallback.onReceiveValue(null);
        AppMethodBeat.o(3823);
    }

    public boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, a aVar) {
        return false;
    }

    public void a(WebView webView, int i) {
    }

    public void d(WebView webView, String str) {
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(3824);
        if (this.AMp != null) {
            this.AMp.onShowCustomView(view, customViewCallback);
        }
        AppMethodBeat.o(3824);
    }

    public void aJY() {
    }

    public void aDI() {
    }
}
