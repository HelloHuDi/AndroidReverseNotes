package com.tencent.smtt.sdk;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.DownloadListener;
import com.tencent.smtt.sdk.a.d;

class b implements DownloadListener {
    private DownloadListener a;
    private WebView b;

    public b(WebView webView, DownloadListener downloadListener, boolean z) {
        this.a = downloadListener;
        this.b = webView;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        AppMethodBeat.i(63901);
        onDownloadStart(str, null, null, str2, str3, str4, j, null, null);
        AppMethodBeat.o(63901);
    }

    public void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j, String str6, String str7) {
        AppMethodBeat.i(63900);
        if (this.a != null) {
            this.a.onDownloadStart(str, str3, str4, str5, j);
            AppMethodBeat.o(63900);
        } else if (QbSdk.canOpenMimeFileType(this.b.getContext(), str5)) {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            intent.setFlags(268435456);
            intent.putExtra("key_reader_sdk_url", str);
            intent.putExtra("key_reader_sdk_type", 1);
            intent.setData(Uri.parse(str));
            this.b.getContext().startActivity(intent);
            AppMethodBeat.o(63900);
        } else {
            ApplicationInfo applicationInfo = this.b.getContext().getApplicationInfo();
            if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                d.a(this.b.getContext(), str, null, null);
            }
            AppMethodBeat.o(63900);
        }
    }

    public void onDownloadVideo(String str, long j, int i) {
    }
}
