package com.tencent.smtt.sdk;

import android.content.pm.ApplicationInfo;
import android.webkit.DownloadListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.a.d;

class bq implements DownloadListener {
    final /* synthetic */ DownloadListener a;
    final /* synthetic */ WebView b;

    bq(WebView webView, DownloadListener downloadListener) {
        this.b = webView;
        this.a = downloadListener;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        AppMethodBeat.i(64835);
        if (this.a == null) {
            ApplicationInfo applicationInfo = this.b.i == null ? null : this.b.i.getApplicationInfo();
            if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                d.a(this.b.i, str, null, null);
            }
            AppMethodBeat.o(64835);
            return;
        }
        this.a.onDownloadStart(str, str2, str3, str4, j);
        AppMethodBeat.o(64835);
    }
}
