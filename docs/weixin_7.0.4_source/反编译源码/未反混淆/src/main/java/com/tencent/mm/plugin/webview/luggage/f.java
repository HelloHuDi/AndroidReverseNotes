package com.tencent.mm.plugin.webview.luggage;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.s;

public class f extends s {
    private s pih = new s();

    public f() {
        AppMethodBeat.i(6106);
        AppMethodBeat.o(6106);
    }

    public final void a(s sVar) {
        if (sVar != null) {
            this.pih = sVar;
        }
    }

    public void h(WebView webView, String str) {
        AppMethodBeat.i(6107);
        this.pih.h(webView, str);
        AppMethodBeat.o(6107);
    }

    public void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(6108);
        this.pih.b(webView, str, bitmap);
        AppMethodBeat.o(6108);
    }

    public void b(WebView webView, String str) {
        AppMethodBeat.i(6109);
        this.pih.b(webView, str);
        AppMethodBeat.o(6109);
    }

    public void a(WebView webView, int i, String str, String str2) {
        AppMethodBeat.i(6110);
        this.pih.a(webView, i, str, str2);
        AppMethodBeat.o(6110);
    }

    public boolean a(WebView webView, String str) {
        AppMethodBeat.i(6111);
        boolean a = this.pih.a(webView, str);
        AppMethodBeat.o(6111);
        return a;
    }

    public o c(WebView webView, String str) {
        AppMethodBeat.i(6112);
        o c = this.pih.c(webView, str);
        AppMethodBeat.o(6112);
        return c;
    }

    public o a(WebView webView, n nVar) {
        AppMethodBeat.i(6113);
        o a = this.pih.a(webView, nVar);
        AppMethodBeat.o(6113);
        return a;
    }

    public o a(WebView webView, n nVar, Bundle bundle) {
        AppMethodBeat.i(6114);
        o a = this.pih.a(webView, nVar, bundle);
        AppMethodBeat.o(6114);
        return a;
    }

    public final void a(WebView webView, String str, boolean z) {
        AppMethodBeat.i(6115);
        this.pih.a(webView, str, z);
        AppMethodBeat.o(6115);
    }

    public void a(WebView webView, j jVar, SslError sslError) {
        AppMethodBeat.i(6116);
        this.pih.a(webView, jVar, sslError);
        AppMethodBeat.o(6116);
    }

    public final void a(WebView webView, float f, float f2) {
        AppMethodBeat.i(6117);
        this.pih.a(webView, f, f2);
        AppMethodBeat.o(6117);
    }

    public void a(WebView webView, n nVar, o oVar) {
        AppMethodBeat.i(6118);
        this.pih.a(webView, nVar, oVar);
        AppMethodBeat.o(6118);
    }
}
