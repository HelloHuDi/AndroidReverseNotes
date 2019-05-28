package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.platformtools.ab;

public final class c implements k {
    public final void onTaskStarted(long j, String str) {
        AppMethodBeat.i(111498);
        e("onTaskStarted", j, true);
        AppMethodBeat.o(111498);
    }

    public final void b(long j, String str, boolean z) {
        AppMethodBeat.i(111499);
        ab.i("MicroMsg.GameSilentDownloadCallback", "onTaskFinished");
        a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
        if (hv != null && hv.field_autoDownload) {
            f.X(hv.field_appId, 0, 0);
            NZ(hv.field_appId);
        }
        AppMethodBeat.o(111499);
    }

    public final void b(long j, int i, boolean z) {
        AppMethodBeat.i(111500);
        ab.i("MicroMsg.GameSilentDownloadCallback", "onTaskFailed, errCode:%d", Integer.valueOf(i));
        if (i != com.tencent.mm.plugin.downloader.a.a.kJP) {
            a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
            if (hv != null && hv.field_autoDownload) {
                f.X(hv.field_appId, 1, i);
                NZ(hv.field_appId);
            }
        }
        AppMethodBeat.o(111500);
    }

    public final void onTaskRemoved(long j) {
        AppMethodBeat.i(111501);
        ab.i("MicroMsg.GameSilentDownloadCallback", "onTaskRemoved");
        a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
        if (hv != null && hv.field_autoDownload) {
            f.X(hv.field_appId, 2, 0);
            NZ(hv.field_appId);
        }
        AppMethodBeat.o(111501);
    }

    public final void onTaskPaused(long j) {
        AppMethodBeat.i(111502);
        e("onTaskPaused", j, false);
        AppMethodBeat.o(111502);
    }

    public final void gm(long j) {
        AppMethodBeat.i(111503);
        ab.d("MicroMsg.GameSilentDownloadCallback", "onTaskProgressChanged");
        AppMethodBeat.o(111503);
    }

    public final void i(long j, String str) {
        AppMethodBeat.i(111504);
        e("onTaskResumed", j, true);
        AppMethodBeat.o(111504);
    }

    public final void gn(long j) {
    }

    private static void NZ(String str) {
        AppMethodBeat.i(111505);
        d dVar = new d();
        dVar.field_appId = str;
        boolean a = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bDa().a((com.tencent.mm.sdk.e.c) dVar, new String[0]);
        ab.i("MicroMsg.GameSilentDownloadCallback", "removeSilentDownloadTask, appid:%s, ret:%b", str, Boolean.valueOf(a));
        AppMethodBeat.o(111505);
    }

    private static void e(String str, long j, boolean z) {
        AppMethodBeat.i(111506);
        ab.i("MicroMsg.GameSilentDownloadCallback", str);
        a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
        if (hv != null && hv.field_autoDownload) {
            boolean aQ = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bDa().aQ(hv.field_appId, z);
            ab.i("MicroMsg.GameSilentDownloadCallback", "%s. appid:%s, ret:%b", str, hv.field_appId, Boolean.valueOf(aQ));
        }
        AppMethodBeat.o(111506);
    }
}
