package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class a implements k {
    public final void onTaskStarted(long j, String str) {
        AppMethodBeat.i(130638);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskStarted, appId: " + hv.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_started";
            appbrandDownloadState.crZ = hv.field_downloadId;
            appbrandDownloadState.appId = hv.field_appId;
            if (hv.field_totalSize != 0) {
                appbrandDownloadState.progress = (long) ((((float) hv.field_downloadedSize) / ((float) hv.field_totalSize)) * 100.0f);
            }
            appbrandDownloadState.hzC = hv.field_totalSize;
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(130638);
    }

    public final void b(long j, String str, boolean z) {
        AppMethodBeat.i(130639);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFinished, appId: " + hv.field_appId);
            if (hv.field_downloadInWifi) {
                hv.field_downloadInWifi = false;
                c.e(hv);
            }
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_succ";
            appbrandDownloadState.crZ = hv.field_downloadId;
            appbrandDownloadState.appId = hv.field_appId;
            appbrandDownloadState.progress = 100;
            appbrandDownloadState.hzC = hv.field_totalSize;
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(130639);
    }

    public final void b(long j, int i, boolean z) {
        AppMethodBeat.i(130640);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFailed, appId: %s, downloadInWifi: %b, isWifi: %b", hv.field_appId, Boolean.valueOf(hv.field_downloadInWifi), Boolean.valueOf(at.isWifi(ah.getContext())));
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            if (!hv.field_downloadInWifi || at.isWifi(ah.getContext())) {
                appbrandDownloadState.state = "download_failed";
            } else {
                appbrandDownloadState.state = "download_wait_wifi";
            }
            appbrandDownloadState.crZ = hv.field_downloadId;
            appbrandDownloadState.appId = hv.field_appId;
            appbrandDownloadState.hzC = hv.field_totalSize;
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(130640);
    }

    public final void onTaskRemoved(long j) {
        AppMethodBeat.i(130641);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskRemoved, appId: " + hv.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_removed";
            appbrandDownloadState.crZ = hv.field_downloadId;
            appbrandDownloadState.appId = hv.field_appId;
            appbrandDownloadState.hzC = hv.field_totalSize;
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(130641);
    }

    public final void onTaskPaused(long j) {
        AppMethodBeat.i(130642);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskPaused, appId: " + hv.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            if (!hv.field_downloadInWifi || at.isWifi(ah.getContext())) {
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
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(130642);
    }

    public final void gm(long j) {
        AppMethodBeat.i(130643);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_progress_changed";
            appbrandDownloadState.crZ = hv.field_downloadId;
            appbrandDownloadState.appId = hv.field_appId;
            if (hv.field_totalSize != 0) {
                appbrandDownloadState.progress = (long) ((((float) hv.field_downloadedSize) / ((float) hv.field_totalSize)) * 100.0f);
            }
            ab.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskProgressChanged, appId: %s, progress: %d", hv.field_appId, Long.valueOf(appbrandDownloadState.progress));
            appbrandDownloadState.hzC = hv.field_totalSize;
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(130643);
    }

    public final void i(long j, String str) {
    }

    public final void gn(long j) {
    }
}
