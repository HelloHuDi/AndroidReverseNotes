package com.tencent.p177mm.plugin.webview.luggage;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36588j;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.webview.luggage.f */
public class C46418f extends C36592s {
    private C36592s pih = new C36592s();

    public C46418f() {
        AppMethodBeat.m2504i(6106);
        AppMethodBeat.m2505o(6106);
    }

    /* renamed from: a */
    public final void mo74632a(C36592s c36592s) {
        if (c36592s != null) {
            this.pih = c36592s;
        }
    }

    /* renamed from: h */
    public void mo7563h(WebView webView, String str) {
        AppMethodBeat.m2504i(6107);
        this.pih.mo7563h(webView, str);
        AppMethodBeat.m2505o(6107);
    }

    /* renamed from: b */
    public void mo7562b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(6108);
        this.pih.mo7562b(webView, str, bitmap);
        AppMethodBeat.m2505o(6108);
    }

    /* renamed from: b */
    public void mo5992b(WebView webView, String str) {
        AppMethodBeat.m2504i(6109);
        this.pih.mo5992b(webView, str);
        AppMethodBeat.m2505o(6109);
    }

    /* renamed from: a */
    public void mo7559a(WebView webView, int i, String str, String str2) {
        AppMethodBeat.m2504i(6110);
        this.pih.mo7559a(webView, i, str, str2);
        AppMethodBeat.m2505o(6110);
    }

    /* renamed from: a */
    public boolean mo4762a(WebView webView, String str) {
        AppMethodBeat.m2504i(6111);
        boolean a = this.pih.mo4762a(webView, str);
        AppMethodBeat.m2505o(6111);
        return a;
    }

    /* renamed from: c */
    public C31147o mo5993c(WebView webView, String str) {
        AppMethodBeat.m2504i(6112);
        C31147o c = this.pih.mo5993c(webView, str);
        AppMethodBeat.m2505o(6112);
        return c;
    }

    /* renamed from: a */
    public C31147o mo5990a(WebView webView, C24530n c24530n) {
        AppMethodBeat.m2504i(6113);
        C31147o a = this.pih.mo5990a(webView, c24530n);
        AppMethodBeat.m2505o(6113);
        return a;
    }

    /* renamed from: a */
    public C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
        AppMethodBeat.m2504i(6114);
        C31147o a = this.pih.mo5991a(webView, c24530n, bundle);
        AppMethodBeat.m2505o(6114);
        return a;
    }

    /* renamed from: a */
    public final void mo26819a(WebView webView, String str, boolean z) {
        AppMethodBeat.m2504i(6115);
        this.pih.mo26819a(webView, str, z);
        AppMethodBeat.m2505o(6115);
    }

    /* renamed from: a */
    public void mo7560a(WebView webView, C36588j c36588j, SslError sslError) {
        AppMethodBeat.m2504i(6116);
        this.pih.mo7560a(webView, c36588j, sslError);
        AppMethodBeat.m2505o(6116);
    }

    /* renamed from: a */
    public final void mo37025a(WebView webView, float f, float f2) {
        AppMethodBeat.m2504i(6117);
        this.pih.mo37025a(webView, f, f2);
        AppMethodBeat.m2505o(6117);
    }

    /* renamed from: a */
    public void mo7561a(WebView webView, C24530n c24530n, C31147o c31147o) {
        AppMethodBeat.m2504i(6118);
        this.pih.mo7561a(webView, c24530n, c31147o);
        AppMethodBeat.m2505o(6118);
    }
}
