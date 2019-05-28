package com.tencent.xweb;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.e;

public class s {
    public e AMp;

    public void h(WebView webView, String str) {
    }

    public void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(3942);
        if (this.AMp == null) {
            AppMethodBeat.o(3942);
            return;
        }
        this.AMp.w(str, bitmap);
        AppMethodBeat.o(3942);
    }

    public void b(WebView webView, String str) {
    }

    public void a(WebView webView, int i, String str, String str2) {
    }

    public boolean a(WebView webView, String str) {
        return false;
    }

    public o c(WebView webView, String str) {
        return null;
    }

    public o a(WebView webView, n nVar) {
        return null;
    }

    public void a(WebView webView, String str, boolean z) {
    }

    public void a(WebView webView, j jVar, SslError sslError) {
        AppMethodBeat.i(3943);
        if (jVar != null) {
            jVar.cancel();
        }
        AppMethodBeat.o(3943);
    }

    public void a(WebView webView, float f, float f2) {
    }

    public o a(WebView webView, n nVar, Bundle bundle) {
        return null;
    }

    public void a(WebView webView, n nVar, o oVar) {
    }
}
