package com.tencent.smtt.sdk;

import android.content.pm.ApplicationInfo;
import android.webkit.DownloadListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.p1104a.C24262d;

/* renamed from: com.tencent.smtt.sdk.bq */
class C16150bq implements DownloadListener {
    /* renamed from: a */
    final /* synthetic */ DownloadListener f3027a;
    /* renamed from: b */
    final /* synthetic */ WebView f3028b;

    C16150bq(WebView webView, DownloadListener downloadListener) {
        this.f3028b = webView;
        this.f3027a = downloadListener;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        AppMethodBeat.m2504i(64835);
        if (this.f3027a == null) {
            ApplicationInfo applicationInfo = this.f3028b.f13883i == null ? null : this.f3028b.f13883i.getApplicationInfo();
            if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                C24262d.m37417a(this.f3028b.f13883i, str, null, null);
            }
            AppMethodBeat.m2505o(64835);
            return;
        }
        this.f3027a.onDownloadStart(str, str2, str3, str4, j);
        AppMethodBeat.m2505o(64835);
    }
}
