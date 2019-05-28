package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;

public final class g implements b {

    static class a implements TbsDownloaderCallback {
        com.tencent.xweb.x5.sdk.f.a ARa;

        public a(com.tencent.xweb.x5.sdk.f.a aVar) {
            this.ARa = aVar;
        }

        public final void onNeedDownloadFinish(boolean z, int i) {
            AppMethodBeat.i(85109);
            if (this.ARa != null) {
                this.ARa.onNeedDownloadFinish(z, i);
            }
            AppMethodBeat.o(85109);
        }
    }

    public final boolean jA(Context context) {
        AppMethodBeat.i(85110);
        boolean needSendRequest = TbsDownloader.needSendRequest(context, false);
        AppMethodBeat.o(85110);
        return needSendRequest;
    }

    public final boolean a(Context context, boolean z, boolean z2, com.tencent.xweb.x5.sdk.f.a aVar) {
        AppMethodBeat.i(85111);
        boolean needDownload;
        if (aVar == null) {
            needDownload = TbsDownloader.needDownload(context, z, z2, null);
            AppMethodBeat.o(85111);
            return needDownload;
        }
        needDownload = TbsDownloader.needDownload(context, z, z2, new a(aVar));
        AppMethodBeat.o(85111);
        return needDownload;
    }

    public final void startDownload(Context context, boolean z) {
        AppMethodBeat.i(85112);
        TbsDownloader.startDownload(context, z);
        AppMethodBeat.o(85112);
    }

    public final void stopDownload() {
        AppMethodBeat.i(85113);
        TbsDownloader.stopDownload();
        AppMethodBeat.o(85113);
    }

    public final boolean isDownloading() {
        AppMethodBeat.i(85114);
        boolean isDownloading = TbsDownloader.isDownloading();
        AppMethodBeat.o(85114);
        return isDownloading;
    }

    public final boolean isDownloadForeground() {
        AppMethodBeat.i(85115);
        boolean isDownloadForeground = TbsDownloader.isDownloadForeground();
        AppMethodBeat.o(85115);
        return isDownloadForeground;
    }
}
