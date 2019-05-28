package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

final class n implements TbsListener {
    n() {
    }

    public final void onDownloadFinish(int i) {
        AppMethodBeat.i(63991);
        if (TbsDownloader.needDownloadDecoupleCore()) {
            TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
            TbsDownloader.a = true;
            AppMethodBeat.o(63991);
            return;
        }
        TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
        TbsDownloader.a = false;
        if (QbSdk.D != null) {
            QbSdk.D.onDownloadFinish(i);
        }
        if (QbSdk.E != null) {
            QbSdk.E.onDownloadFinish(i);
        }
        AppMethodBeat.o(63991);
    }

    public final void onDownloadProgress(int i) {
        AppMethodBeat.i(63993);
        if (QbSdk.E != null) {
            QbSdk.E.onDownloadProgress(i);
        }
        if (QbSdk.D != null) {
            QbSdk.D.onDownloadProgress(i);
        }
        AppMethodBeat.o(63993);
    }

    public final void onInstallFinish(int i) {
        AppMethodBeat.i(63992);
        QbSdk.setTBSInstallingStatus(false);
        TbsDownloader.a = false;
        if (TbsDownloader.startDecoupleCoreIfNeeded()) {
            TbsDownloader.a = true;
        } else {
            TbsDownloader.a = false;
        }
        if (QbSdk.D != null) {
            QbSdk.D.onInstallFinish(i);
        }
        if (QbSdk.E != null) {
            QbSdk.E.onInstallFinish(i);
        }
        AppMethodBeat.o(63992);
    }
}
