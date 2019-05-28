package com.tencent.xweb.p685x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;
import com.tencent.xweb.p685x5.sdk.C24548f.C24549a;

/* renamed from: com.tencent.xweb.x5.sdk.g */
public final class C44594g implements C24543b {

    /* renamed from: com.tencent.xweb.x5.sdk.g$a */
    static class C36600a implements TbsDownloaderCallback {
        C24549a ARa;

        public C36600a(C24549a c24549a) {
            this.ARa = c24549a;
        }

        public final void onNeedDownloadFinish(boolean z, int i) {
            AppMethodBeat.m2504i(85109);
            if (this.ARa != null) {
                this.ARa.onNeedDownloadFinish(z, i);
            }
            AppMethodBeat.m2505o(85109);
        }
    }

    /* renamed from: jA */
    public final boolean mo41290jA(Context context) {
        AppMethodBeat.m2504i(85110);
        boolean needSendRequest = TbsDownloader.needSendRequest(context, false);
        AppMethodBeat.m2505o(85110);
        return needSendRequest;
    }

    /* renamed from: a */
    public final boolean mo41287a(Context context, boolean z, boolean z2, C24549a c24549a) {
        AppMethodBeat.m2504i(85111);
        boolean needDownload;
        if (c24549a == null) {
            needDownload = TbsDownloader.needDownload(context, z, z2, null);
            AppMethodBeat.m2505o(85111);
            return needDownload;
        }
        needDownload = TbsDownloader.needDownload(context, z, z2, new C36600a(c24549a));
        AppMethodBeat.m2505o(85111);
        return needDownload;
    }

    public final void startDownload(Context context, boolean z) {
        AppMethodBeat.m2504i(85112);
        TbsDownloader.startDownload(context, z);
        AppMethodBeat.m2505o(85112);
    }

    public final void stopDownload() {
        AppMethodBeat.m2504i(85113);
        TbsDownloader.stopDownload();
        AppMethodBeat.m2505o(85113);
    }

    public final boolean isDownloading() {
        AppMethodBeat.m2504i(85114);
        boolean isDownloading = TbsDownloader.isDownloading();
        AppMethodBeat.m2505o(85114);
        return isDownloading;
    }

    public final boolean isDownloadForeground() {
        AppMethodBeat.m2504i(85115);
        boolean isDownloadForeground = TbsDownloader.isDownloadForeground();
        AppMethodBeat.m2505o(85115);
        return isDownloadForeground;
    }
}
