package com.tencent.xweb;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p1115c.C24524e;

/* renamed from: com.tencent.xweb.s */
public class C36592s {
    public C24524e AMp;

    /* renamed from: h */
    public void mo7563h(WebView webView, String str) {
    }

    /* renamed from: b */
    public void mo7562b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(3942);
        if (this.AMp == null) {
            AppMethodBeat.m2505o(3942);
            return;
        }
        this.AMp.mo13225w(str, bitmap);
        AppMethodBeat.m2505o(3942);
    }

    /* renamed from: b */
    public void mo5992b(WebView webView, String str) {
    }

    /* renamed from: a */
    public void mo7559a(WebView webView, int i, String str, String str2) {
    }

    /* renamed from: a */
    public boolean mo4762a(WebView webView, String str) {
        return false;
    }

    /* renamed from: c */
    public C31147o mo5993c(WebView webView, String str) {
        return null;
    }

    /* renamed from: a */
    public C31147o mo5990a(WebView webView, C24530n c24530n) {
        return null;
    }

    /* renamed from: a */
    public void mo26819a(WebView webView, String str, boolean z) {
    }

    /* renamed from: a */
    public void mo7560a(WebView webView, C36588j c36588j, SslError sslError) {
        AppMethodBeat.m2504i(3943);
        if (c36588j != null) {
            c36588j.cancel();
        }
        AppMethodBeat.m2505o(3943);
    }

    /* renamed from: a */
    public void mo37025a(WebView webView, float f, float f2) {
    }

    /* renamed from: a */
    public C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
        return null;
    }

    /* renamed from: a */
    public void mo7561a(WebView webView, C24530n c24530n, C31147o c31147o) {
    }
}
