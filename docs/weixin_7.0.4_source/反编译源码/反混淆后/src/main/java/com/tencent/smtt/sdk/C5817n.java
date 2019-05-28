package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.smtt.sdk.n */
final class C5817n implements TbsListener {
    C5817n() {
    }

    public final void onDownloadFinish(int i) {
        AppMethodBeat.m2504i(63991);
        if (TbsDownloader.needDownloadDecoupleCore()) {
            TbsLog.m80435i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
            TbsDownloader.f4486a = true;
            AppMethodBeat.m2505o(63991);
            return;
        }
        TbsLog.m80435i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
        TbsDownloader.f4486a = false;
        if (QbSdk.f16235D != null) {
            QbSdk.f16235D.onDownloadFinish(i);
        }
        if (QbSdk.f16236E != null) {
            QbSdk.f16236E.onDownloadFinish(i);
        }
        AppMethodBeat.m2505o(63991);
    }

    public final void onDownloadProgress(int i) {
        AppMethodBeat.m2504i(63993);
        if (QbSdk.f16236E != null) {
            QbSdk.f16236E.onDownloadProgress(i);
        }
        if (QbSdk.f16235D != null) {
            QbSdk.f16235D.onDownloadProgress(i);
        }
        AppMethodBeat.m2505o(63993);
    }

    public final void onInstallFinish(int i) {
        AppMethodBeat.m2504i(63992);
        QbSdk.setTBSInstallingStatus(false);
        TbsDownloader.f4486a = false;
        if (TbsDownloader.startDecoupleCoreIfNeeded()) {
            TbsDownloader.f4486a = true;
        } else {
            TbsDownloader.f4486a = false;
        }
        if (QbSdk.f16235D != null) {
            QbSdk.f16235D.onInstallFinish(i);
        }
        if (QbSdk.f16236E != null) {
            QbSdk.f16236E.onInstallFinish(i);
        }
        AppMethodBeat.m2505o(63992);
    }
}
