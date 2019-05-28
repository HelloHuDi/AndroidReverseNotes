package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class l extends k {
    d uJH;
    private m uJI;

    public l(MMWebView mMWebView, boolean z, d dVar) {
        this(mMWebView, z, dVar, null);
    }

    public l(MMWebView mMWebView, boolean z, d dVar, Bundle bundle) {
        super(mMWebView, z, bundle);
        this.uJH = null;
        this.uJI = null;
        this.uJH = dVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final m aGt() {
        AppMethodBeat.i(10023);
        if (this.uJI == null) {
            this.uJI = new m() {
                public final boolean c(int i, Bundle bundle) {
                    AppMethodBeat.i(10021);
                    boolean c;
                    if (l.this.uJH != null) {
                        c = l.this.uJH.c(i, bundle);
                        AppMethodBeat.o(10021);
                        return c;
                    }
                    c = super.c(i, bundle);
                    AppMethodBeat.o(10021);
                    return c;
                }

                public final void W(Bundle bundle) {
                    AppMethodBeat.i(10022);
                    if ((l.this.uJH instanceof e) && ((e) l.this.uJH).aba()) {
                        AppMethodBeat.o(10022);
                        return;
                    }
                    super.W(bundle);
                    AppMethodBeat.o(10022);
                }
            };
        }
        m mVar = this.uJI;
        AppMethodBeat.o(10023);
        return mVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(10024);
        super.a(webView, str, bitmap);
        if (this.uJH instanceof e) {
            ((e) this.uJH).abb();
        }
        AppMethodBeat.o(10024);
    }

    /* Access modifiers changed, original: protected|final */
    public final void e(WebView webView, String str) {
        AppMethodBeat.i(10025);
        super.e(webView, str);
        if (this.uJH instanceof e) {
            ((e) this.uJH).a((MMWebView) webView);
        }
        AppMethodBeat.o(10025);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean oZ(String str) {
        AppMethodBeat.i(10026);
        boolean oZ;
        if (this.uJH == null || !(this.uJH instanceof e)) {
            oZ = super.oZ(str);
            AppMethodBeat.o(10026);
            return oZ;
        }
        oZ = ((e) this.uJH).oZ(str);
        AppMethodBeat.o(10026);
        return oZ;
    }
}
