package com.tencent.xweb;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p1115c.C24524e;

/* renamed from: com.tencent.xweb.l */
public class C6031l {
    C24524e AMp;

    /* renamed from: com.tencent.xweb.l$a */
    public static abstract class C6032a {
        public abstract String[] getAcceptTypes();

        public abstract int getMode();

        public abstract boolean isCaptureEnabled();
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        AppMethodBeat.m2504i(3818);
        callback.invoke(str, true, true);
        AppMethodBeat.m2505o(3818);
    }

    public void onHideCustomView() {
        AppMethodBeat.m2504i(3819);
        if (this.AMp != null) {
            this.AMp.onHideCustomView();
        }
        AppMethodBeat.m2505o(3819);
    }

    /* renamed from: a */
    public boolean mo13207a(WebView webView, String str, String str2, C46945h c46945h) {
        AppMethodBeat.m2504i(3820);
        if (this.AMp != null) {
            boolean a = this.AMp.mo13220a(str, str2, c46945h);
            AppMethodBeat.m2505o(3820);
            return a;
        }
        AppMethodBeat.m2505o(3820);
        return false;
    }

    /* renamed from: b */
    public boolean mo13211b(WebView webView, String str, String str2, C46945h c46945h) {
        AppMethodBeat.m2504i(3821);
        if (this.AMp != null) {
            boolean b = this.AMp.mo13222b(str, str2, c46945h);
            AppMethodBeat.m2505o(3821);
            return b;
        }
        AppMethodBeat.m2505o(3821);
        return false;
    }

    /* renamed from: a */
    public boolean mo13208a(WebView webView, String str, String str2, String str3, C41127g c41127g) {
        AppMethodBeat.m2504i(3822);
        if (this.AMp != null) {
            boolean a = this.AMp.mo13221a(str, str2, str3, c41127g);
            AppMethodBeat.m2505o(3822);
            return a;
        }
        AppMethodBeat.m2505o(3822);
        return false;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.m2504i(3823);
        valueCallback.onReceiveValue(null);
        AppMethodBeat.m2505o(3823);
    }

    /* renamed from: a */
    public boolean mo13206a(WebView webView, ValueCallback<Uri[]> valueCallback, C6032a c6032a) {
        return false;
    }

    /* renamed from: a */
    public void mo13205a(WebView webView, int i) {
    }

    /* renamed from: d */
    public void mo7557d(WebView webView, String str) {
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.m2504i(3824);
        if (this.AMp != null) {
            this.AMp.onShowCustomView(view, customViewCallback);
        }
        AppMethodBeat.m2505o(3824);
    }

    public void aJY() {
    }

    public void aDI() {
    }
}
