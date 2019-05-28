package com.tencent.smtt.sdk;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.DownloadListener;
import com.tencent.smtt.sdk.p1104a.C24262d;

/* renamed from: com.tencent.smtt.sdk.b */
class C44453b implements DownloadListener {
    /* renamed from: a */
    private DownloadListener f17295a;
    /* renamed from: b */
    private WebView f17296b;

    public C44453b(WebView webView, DownloadListener downloadListener, boolean z) {
        this.f17295a = downloadListener;
        this.f17296b = webView;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        AppMethodBeat.m2504i(63901);
        onDownloadStart(str, null, null, str2, str3, str4, j, null, null);
        AppMethodBeat.m2505o(63901);
    }

    public void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j, String str6, String str7) {
        AppMethodBeat.m2504i(63900);
        if (this.f17295a != null) {
            this.f17295a.onDownloadStart(str, str3, str4, str5, j);
            AppMethodBeat.m2505o(63900);
        } else if (QbSdk.canOpenMimeFileType(this.f17296b.getContext(), str5)) {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            intent.setFlags(268435456);
            intent.putExtra("key_reader_sdk_url", str);
            intent.putExtra("key_reader_sdk_type", 1);
            intent.setData(Uri.parse(str));
            this.f17296b.getContext().startActivity(intent);
            AppMethodBeat.m2505o(63900);
        } else {
            ApplicationInfo applicationInfo = this.f17296b.getContext().getApplicationInfo();
            if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                C24262d.m37417a(this.f17296b.getContext(), str, null, null);
            }
            AppMethodBeat.m2505o(63900);
        }
    }

    public void onDownloadVideo(String str, long j, int i) {
    }
}
