package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.c.e;
import com.tencent.xweb.g;
import com.tencent.xweb.h;

public final class i implements e {
    c AQF = new c();
    b AQG = new b();
    WebView AQH;

    public i(WebView webView) {
        AppMethodBeat.i(84853);
        this.AQH = webView;
        AppMethodBeat.o(84853);
    }

    public final void w(String str, Bitmap bitmap) {
        AppMethodBeat.i(84854);
        this.AQF.b(this.AQH, str, bitmap);
        AppMethodBeat.o(84854);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public final void onHideCustomView() {
        AppMethodBeat.i(84855);
        this.AQG.dVA();
        AppMethodBeat.o(84855);
    }

    public final boolean a(String str, String str2, h hVar) {
        return false;
    }

    public final boolean b(String str, String str2, h hVar) {
        return false;
    }

    public final boolean a(String str, String str2, String str3, g gVar) {
        return false;
    }
}
