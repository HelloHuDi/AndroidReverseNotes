package com.tencent.mm.plugin.downloader;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b implements a, d, com.tencent.mm.plugin.downloader.a.d {
    private com.tencent.mm.plugin.downloader.f.b kJH;
    private long kJI = 0;

    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(2272);
        this.kJH = new com.tencent.mm.plugin.downloader.f.b(hVar);
        AppMethodBeat.o(2272);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final com.tencent.mm.plugin.downloader.f.b XS() {
        AppMethodBeat.i(2273);
        g.RQ();
        g.RN().QU();
        com.tencent.mm.plugin.downloader.f.b bVar = this.kJH;
        AppMethodBeat.o(2273);
        return bVar;
    }

    public final HashMap<Integer, h.d> collectDatabaseFactory() {
        AppMethodBeat.i(2274);
        ab.d("MicroMsg.FileDownloaderService", "collectDatabaseFactory");
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("FILEDOWNLOAD_TABLE".hashCode()), new h.d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.downloader.f.b.fnj;
            }
        });
        AppMethodBeat.o(2274);
        return hashMap;
    }

    public final void fZ(boolean z) {
        AppMethodBeat.i(2275);
        ab.i("MicroMsg.FileDownloaderService", "active: ".concat(String.valueOf(z)));
        if (!z && (System.currentTimeMillis() - this.kJI) / 1000 > 1800) {
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(2271);
                    b.bid();
                    AppMethodBeat.o(2271);
                }
            }, "checkDownloadFile");
            this.kJI = System.currentTimeMillis();
        }
        AppMethodBeat.o(2275);
    }

    static /* synthetic */ void bid() {
        List list;
        AppMethodBeat.i(2276);
        com.tencent.mm.plugin.downloader.f.b XS = c.XS();
        if (XS == null) {
            list = null;
        } else {
            String str = "select * from FileDownloadInfo";
            ab.i("MicroMsg.FileDownloadInfoStorage", "getAllTasks, sql = ".concat(String.valueOf(str)));
            Cursor rawQuery = XS.rawQuery(str, new String[0]);
            list = new LinkedList();
            if (rawQuery != null) {
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
                long currentTimeMillis = (System.currentTimeMillis() - aVar2.field_updateTime) / 1000;
                int i = aVar2.field_totalSize > 0 ? (int) ((aVar2.field_downloadedSize * 100) / aVar2.field_totalSize) : 0;
                if (aVar2.field_status != 1) {
                    boolean z;
                    if (aVar2.field_status == 3) {
                        if (currentTimeMillis >= 2592000) {
                            z = true;
                        }
                        z = false;
                    } else {
                        if (currentTimeMillis >= 172800) {
                            com.tencent.mm.plugin.report.service.h.pYm.a(710, 20, 1, false);
                            z = true;
                        }
                        z = false;
                    }
                    if (z) {
                        e.deleteFile(aVar2.field_filePath);
                        c.hw(aVar2.field_downloadId);
                        ((com.tencent.mm.plugin.downloader_app.a.d) g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).kP(aVar2.field_appId);
                    }
                    ab.i("MicroMsg.FileDownloaderService", "checkRemovedDownloadFile, appId: %s, interval: %d, percent: %d, delete: %b", aVar2.field_appId, Long.valueOf(currentTimeMillis), Integer.valueOf(i), Boolean.valueOf(z));
                }
            }
        }
        AppMethodBeat.o(2276);
    }
}
