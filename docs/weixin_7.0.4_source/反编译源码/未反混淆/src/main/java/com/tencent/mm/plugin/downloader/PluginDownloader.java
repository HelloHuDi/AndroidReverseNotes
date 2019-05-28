package com.tencent.mm.plugin.downloader;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.cdndownloader.b.a;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.downloader.a.e;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginDownloader extends f implements c, e {
    private static a kJK;

    static /* synthetic */ void access$000(PluginDownloader pluginDownloader) {
        AppMethodBeat.i(2282);
        pluginDownloader.resumeDownloadTaskWhenProcessRestart();
        AppMethodBeat.o(2282);
    }

    public void configure(g gVar) {
    }

    public void execute(g gVar) {
        AppMethodBeat.i(2278);
        ab.d("MicroMsg.PluginDownloader", "execute");
        if (gVar.SG()) {
            com.tencent.mm.kernel.g.a(d.class, new b());
            com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.plugin.cdndownloader.a());
            a aVar = new a(com.tencent.mm.plugin.downloader.model.a.kMy);
            kJK = aVar;
            aVar.startWatching();
        }
        AppMethodBeat.o(2278);
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(2279);
        ab.i("MicroMsg.PluginDownloader", "onAccountInitialized");
        com.tencent.mm.plugin.downloader.e.a.bie();
        com.tencent.mm.plugin.cdndownloader.g.a.aNS().m(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2277);
                PluginDownloader.access$000(PluginDownloader.this);
                AppMethodBeat.o(2277);
            }
        }, 500);
        com.tencent.mm.plugin.downloader.b.a.bie();
        AppMethodBeat.o(2279);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(2280);
        ab.i("MicroMsg.PluginDownloader", "onAccountRelease");
        com.tencent.mm.plugin.downloader.e.a.bgr();
        com.tencent.mm.plugin.downloader.b.a.bgr();
        com.tencent.mm.plugin.downloader.a.c.clearCache();
        AppMethodBeat.o(2280);
    }

    private void resumeDownloadTaskWhenProcessRestart() {
        List list;
        AppMethodBeat.i(2281);
        b XS = com.tencent.mm.plugin.downloader.model.c.XS();
        if (XS == null) {
            list = null;
        } else {
            ab.i("MicroMsg.FileDownloadInfoStorage", "getRunningDownloadInfos: select * from FileDownloadInfo where status=1");
            Cursor rawQuery = XS.rawQuery("select * from FileDownloadInfo where status=1", new String[0]);
            if (rawQuery == null) {
                ab.i("MicroMsg.FileDownloadInfoStorage", "cursor is null");
                list = null;
            } else {
                list = new LinkedList();
                while (rawQuery.moveToNext()) {
                    com.tencent.mm.plugin.downloader.f.a aVar = new com.tencent.mm.plugin.downloader.f.a();
                    aVar.d(rawQuery);
                    list.add(aVar);
                }
                rawQuery.close();
            }
        }
        if (!bo.ek(list)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.f.a aVar2 = (com.tencent.mm.plugin.downloader.f.a) it.next();
                FileDownloadTaskInfo hm = com.tencent.mm.plugin.downloader.model.d.bij().hm(aVar2.field_downloadId);
                com.tencent.mm.plugin.downloader.model.d bij;
                long j;
                if (hm.status == 3) {
                    ab.i("MicroMsg.PluginDownloader", "has download finish");
                    aVar2.field_finishTime = System.currentTimeMillis();
                    aVar2.field_downloadedSize = aVar2.field_totalSize;
                    aVar2.field_status = 6;
                    ab.i("MicroMsg.PluginDownloader", "download succeed, downloadedSize = %d, startSize = %d", Long.valueOf(aVar2.field_downloadedSize), Long.valueOf(aVar2.field_startSize));
                    com.tencent.mm.plugin.downloader.model.c.e(aVar2);
                    bij = com.tencent.mm.plugin.downloader.model.d.bij();
                    j = aVar2.field_downloadId;
                    if (bij.kMT != null) {
                        bij.kMT.hu(j);
                    }
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.kNn, 1);
                    intent.setClass(ah.getContext(), FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, aVar2.field_downloadId);
                    try {
                        ah.getContext().startService(intent);
                    } catch (Exception e) {
                        ab.e("MicroMsg.PluginDownloader", e.getMessage());
                    }
                    h.pYm.a(710, 12, 1, false);
                } else if (hm.status != 1) {
                    h.pYm.a(710, 14, 1, false);
                    ab.i("MicroMsg.PluginDownloader", "download fail, all process dead, appId: " + aVar2.field_appId);
                    j = (System.currentTimeMillis() - aVar2.field_updateTime) / 1000;
                    ab.i("MicroMsg.PluginDownloader", "lastTime = ".concat(String.valueOf(j)));
                    if (j <= 1800) {
                        ab.i("MicroMsg.PluginDownloader", "in half hour, net: %s, downloadInWifi: %b, expt: %b", at.getNetTypeString(ah.getContext()), Boolean.valueOf(hm.kNt), Boolean.valueOf(((com.tencent.mm.game.report.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_download_resume_not_in_wifi)));
                        if (at.isWifi(ah.getContext())) {
                            ab.i("MicroMsg.PluginDownloader", "in half hour, in wifi, restart");
                            com.tencent.mm.plugin.downloader.model.d.bij().hp(aVar2.field_downloadId);
                            h.pYm.a(710, 15, 1, false);
                        } else if (hm.kNt || !r1) {
                            h.pYm.a(710, 17, 1, false);
                        } else {
                            ab.i("MicroMsg.PluginDownloader", "download not in wifi");
                            com.tencent.mm.plugin.downloader.model.d.bij().hp(aVar2.field_downloadId);
                            h.pYm.a(710, 19, 1, false);
                        }
                    } else {
                        h.pYm.a(710, 16, 1, false);
                        if (!at.isWifi(ah.getContext())) {
                            h.pYm.a(710, 17, 1, false);
                        }
                    }
                    aVar2.field_finishTime = System.currentTimeMillis();
                    aVar2.field_status = 4;
                    aVar2.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJU;
                    com.tencent.mm.plugin.downloader.model.c.e(aVar2);
                    bij = com.tencent.mm.plugin.downloader.model.d.bij();
                    j = aVar2.field_downloadId;
                    int i = aVar2.field_errCode;
                    if (bij.kMT != null) {
                        bij.kMT.d(j, i, false);
                    }
                } else {
                    ab.i("MicroMsg.PluginDownloader", "download process alive, still downloading: " + aVar2.field_appId);
                    h.pYm.a(710, 13, 1, false);
                }
            }
        }
        AppMethodBeat.o(2281);
    }
}
