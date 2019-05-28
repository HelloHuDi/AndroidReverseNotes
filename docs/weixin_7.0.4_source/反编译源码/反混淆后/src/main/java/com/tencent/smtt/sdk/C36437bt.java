package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.bt */
class C36437bt extends Thread {
    /* renamed from: a */
    final /* synthetic */ WebView f15170a;

    C36437bt(WebView webView, String str) {
        this.f15170a = webView;
        super(str);
    }

    public void run() {
        AppMethodBeat.m2504i(64838);
        try {
            this.f15170a.mo49869a();
            AppMethodBeat.m2505o(64838);
        } catch (Exception e) {
            AppMethodBeat.m2505o(64838);
        }
    }
}
