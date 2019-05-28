package com.tencent.mm.plugin.topstory.ui.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.s;
import java.io.ByteArrayInputStream;

public final class d extends s {
    private chn cPu;
    private c sHF;

    public d(chn chn, c cVar) {
        this.cPu = chn;
        this.sHF = cVar;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(2168);
        c.c(this.cPu, "pageStart", System.currentTimeMillis());
        ab.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", str, Long.valueOf(Thread.currentThread().getId()));
        super.b(webView, str, bitmap);
        AppMethodBeat.o(2168);
    }

    public final void b(WebView webView, String str) {
        AppMethodBeat.i(2169);
        ab.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageFinished %s  %d", str, Long.valueOf(Thread.currentThread().getId()));
        super.b(webView, str);
        c.c(this.cPu, "pageFinish", System.currentTimeMillis());
        AppMethodBeat.o(2169);
    }

    public final boolean a(WebView webView, String str) {
        AppMethodBeat.i(2170);
        ab.i("MicroMsg.TopStory.TopStoryWebViewClient", "shouldOverrideUrlLoading %s", str);
        boolean a = super.a(webView, str);
        AppMethodBeat.o(2170);
        return a;
    }

    public final o c(WebView webView, String str) {
        AppMethodBeat.i(2171);
        o abL = abL(str);
        if (abL == null) {
            abL = super.c(webView, str);
        }
        AppMethodBeat.o(2171);
        return abL;
    }

    public final o a(WebView webView, n nVar) {
        AppMethodBeat.i(2172);
        o abL = abL(nVar.getUrl().toString());
        if (abL == null) {
            abL = super.a(webView, nVar);
        }
        AppMethodBeat.o(2172);
        return abL;
    }

    public final o a(WebView webView, n nVar, Bundle bundle) {
        AppMethodBeat.i(2173);
        o abL = abL(nVar.getUrl().toString());
        if (abL == null) {
            abL = super.a(webView, nVar, bundle);
        }
        AppMethodBeat.o(2173);
        return abL;
    }

    private o abL(String str) {
        boolean z;
        o oVar = null;
        AppMethodBeat.i(2174);
        byte[] bArr;
        if (str.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/app.html")) {
            bArr = this.sHF.sHw;
            this.sHF.sHw = null;
            if (bArr != null) {
                oVar = new o("text/html", "utf8", new ByteArrayInputStream(bArr));
                z = true;
            }
            z = false;
        } else if (str.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/dist/style.css")) {
            bArr = this.sHF.sHy;
            this.sHF.sHy = null;
            if (bArr != null) {
                oVar = new o("text/css", "utf8", new ByteArrayInputStream(bArr));
                z = true;
            }
            z = false;
        } else {
            if (str.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/dist/build.js")) {
                bArr = this.sHF.sHx;
                this.sHF.sHx = null;
                if (bArr != null) {
                    oVar = new o("application/x-javascript", "utf8", new ByteArrayInputStream(bArr));
                    z = true;
                }
            }
            z = false;
        }
        if (z) {
            ab.i("MicroMsg.TopStory.TopStoryWebViewClient", "tryToGetResourceFromCache useMemoryCache: %b url: %s", Boolean.valueOf(z), str);
        }
        AppMethodBeat.o(2174);
        return oVar;
    }
}
