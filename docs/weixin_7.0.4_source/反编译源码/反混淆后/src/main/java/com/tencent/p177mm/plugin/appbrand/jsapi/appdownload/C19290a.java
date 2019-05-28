package com.tencent.p177mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.model.C11511k;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.a */
public final class C19290a implements C11511k {
    public final void onTaskStarted(long j, String str) {
        AppMethodBeat.m2504i(130638);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            C4990ab.m7416i("MicroMsg.AppbrandFileDownloadCallback", "onTaskStarted, appId: " + hv.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_started";
            appbrandDownloadState.crZ = hv.field_downloadId;
            appbrandDownloadState.appId = hv.field_appId;
            if (hv.field_totalSize != 0) {
                appbrandDownloadState.progress = (long) ((((float) hv.field_downloadedSize) / ((float) hv.field_totalSize)) * 100.0f);
            }
            appbrandDownloadState.hzC = hv.field_totalSize;
            C42469b.m75231a(appbrandDownloadState);
        }
        AppMethodBeat.m2505o(130638);
    }

    /* renamed from: b */
    public final void mo7665b(long j, String str, boolean z) {
        AppMethodBeat.m2504i(130639);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            C4990ab.m7416i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFinished, appId: " + hv.field_appId);
            if (hv.field_downloadInWifi) {
                hv.field_downloadInWifi = false;
                C2895c.m5146e(hv);
            }
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_succ";
            appbrandDownloadState.crZ = hv.field_downloadId;
            appbrandDownloadState.appId = hv.field_appId;
            appbrandDownloadState.progress = 100;
            appbrandDownloadState.hzC = hv.field_totalSize;
            C42469b.m75231a(appbrandDownloadState);
        }
        AppMethodBeat.m2505o(130639);
    }

    /* renamed from: b */
    public final void mo7664b(long j, int i, boolean z) {
        AppMethodBeat.m2504i(130640);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            C4990ab.m7417i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFailed, appId: %s, downloadInWifi: %b, isWifi: %b", hv.field_appId, Boolean.valueOf(hv.field_downloadInWifi), Boolean.valueOf(C5023at.isWifi(C4996ah.getContext())));
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            if (!hv.field_downloadInWifi || C5023at.isWifi(C4996ah.getContext())) {
                appbrandDownloadState.state = "download_failed";
            } else {
                appbrandDownloadState.state = "download_wait_wifi";
            }
            appbrandDownloadState.crZ = hv.field_downloadId;
            appbrandDownloadState.appId = hv.field_appId;
            appbrandDownloadState.hzC = hv.field_totalSize;
            C42469b.m75231a(appbrandDownloadState);
        }
        AppMethodBeat.m2505o(130640);
    }

    public final void onTaskRemoved(long j) {
        AppMethodBeat.m2504i(130641);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            C4990ab.m7416i("MicroMsg.AppbrandFileDownloadCallback", "onTaskRemoved, appId: " + hv.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_removed";
            appbrandDownloadState.crZ = hv.field_downloadId;
            appbrandDownloadState.appId = hv.field_appId;
            appbrandDownloadState.hzC = hv.field_totalSize;
            C42469b.m75231a(appbrandDownloadState);
        }
        AppMethodBeat.m2505o(130641);
    }

    public final void onTaskPaused(long j) {
        AppMethodBeat.m2504i(130642);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            C4990ab.m7416i("MicroMsg.AppbrandFileDownloadCallback", "onTaskPaused, appId: " + hv.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            if (!hv.field_downloadInWifi || C5023at.isWifi(C4996ah.getContext())) {
                appbrandDownloadState.state = "download_paused";
            } else {
                appbrandDownloadState.state = "download_wait_wifi";
            }
            appbrandDownloadState.crZ = hv.field_downloadId;
            appbrandDownloadState.appId = hv.field_appId;
            appbrandDownloadState.hzC = hv.field_totalSize;
            if (hv.field_totalSize != 0) {
                appbrandDownloadState.progress = (long) ((((float) hv.field_downloadedSize) / ((float) hv.field_totalSize)) * 100.0f);
            }
            C42469b.m75231a(appbrandDownloadState);
        }
        AppMethodBeat.m2505o(130642);
    }

    /* renamed from: gm */
    public final void mo7667gm(long j) {
        AppMethodBeat.m2504i(130643);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_progress_changed";
            appbrandDownloadState.crZ = hv.field_downloadId;
            appbrandDownloadState.appId = hv.field_appId;
            if (hv.field_totalSize != 0) {
                appbrandDownloadState.progress = (long) ((((float) hv.field_downloadedSize) / ((float) hv.field_totalSize)) * 100.0f);
            }
            C4990ab.m7417i("MicroMsg.AppbrandFileDownloadCallback", "onTaskProgressChanged, appId: %s, progress: %d", hv.field_appId, Long.valueOf(appbrandDownloadState.progress));
            appbrandDownloadState.hzC = hv.field_totalSize;
            C42469b.m75231a(appbrandDownloadState);
        }
        AppMethodBeat.m2505o(130643);
    }

    /* renamed from: i */
    public final void mo7669i(long j, String str) {
    }

    /* renamed from: gn */
    public final void mo7668gn(long j) {
    }
}
