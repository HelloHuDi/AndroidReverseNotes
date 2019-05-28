package com.tencent.p177mm.plugin.topstory.p541ui.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.protocal.protobuf.chn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.WebView;
import java.io.ByteArrayInputStream;

/* renamed from: com.tencent.mm.plugin.topstory.ui.webview.d */
public final class C14002d extends C36592s {
    private chn cPu;
    private C13995c sHF;

    public C14002d(chn chn, C13995c c13995c) {
        this.cPu = chn;
        this.sHF = c13995c;
    }

    /* renamed from: b */
    public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(2168);
        C4210c.m6561c(this.cPu, "pageStart", System.currentTimeMillis());
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", str, Long.valueOf(Thread.currentThread().getId()));
        super.mo7562b(webView, str, bitmap);
        AppMethodBeat.m2505o(2168);
    }

    /* renamed from: b */
    public final void mo5992b(WebView webView, String str) {
        AppMethodBeat.m2504i(2169);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageFinished %s  %d", str, Long.valueOf(Thread.currentThread().getId()));
        super.mo5992b(webView, str);
        C4210c.m6561c(this.cPu, "pageFinish", System.currentTimeMillis());
        AppMethodBeat.m2505o(2169);
    }

    /* renamed from: a */
    public final boolean mo4762a(WebView webView, String str) {
        AppMethodBeat.m2504i(2170);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewClient", "shouldOverrideUrlLoading %s", str);
        boolean a = super.mo4762a(webView, str);
        AppMethodBeat.m2505o(2170);
        return a;
    }

    /* renamed from: c */
    public final C31147o mo5993c(WebView webView, String str) {
        AppMethodBeat.m2504i(2171);
        C31147o abL = abL(str);
        if (abL == null) {
            abL = super.mo5993c(webView, str);
        }
        AppMethodBeat.m2505o(2171);
        return abL;
    }

    /* renamed from: a */
    public final C31147o mo5990a(WebView webView, C24530n c24530n) {
        AppMethodBeat.m2504i(2172);
        C31147o abL = abL(c24530n.getUrl().toString());
        if (abL == null) {
            abL = super.mo5990a(webView, c24530n);
        }
        AppMethodBeat.m2505o(2172);
        return abL;
    }

    /* renamed from: a */
    public final C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
        AppMethodBeat.m2504i(2173);
        C31147o abL = abL(c24530n.getUrl().toString());
        if (abL == null) {
            abL = super.mo5991a(webView, c24530n, bundle);
        }
        AppMethodBeat.m2505o(2173);
        return abL;
    }

    private C31147o abL(String str) {
        boolean z;
        C31147o c31147o = null;
        AppMethodBeat.m2504i(2174);
        byte[] bArr;
        if (str.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/app.html")) {
            bArr = this.sHF.sHw;
            this.sHF.sHw = null;
            if (bArr != null) {
                c31147o = new C31147o("text/html", "utf8", new ByteArrayInputStream(bArr));
                z = true;
            }
            z = false;
        } else if (str.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/dist/style.css")) {
            bArr = this.sHF.sHy;
            this.sHF.sHy = null;
            if (bArr != null) {
                c31147o = new C31147o("text/css", "utf8", new ByteArrayInputStream(bArr));
                z = true;
            }
            z = false;
        } else {
            if (str.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/dist/build.js")) {
                bArr = this.sHF.sHx;
                this.sHF.sHx = null;
                if (bArr != null) {
                    c31147o = new C31147o("application/x-javascript", "utf8", new ByteArrayInputStream(bArr));
                    z = true;
                }
            }
            z = false;
        }
        if (z) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebViewClient", "tryToGetResourceFromCache useMemoryCache: %b url: %s", Boolean.valueOf(z), str);
        }
        AppMethodBeat.m2505o(2174);
        return c31147o;
    }
}
