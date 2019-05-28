package com.tencent.mm.plugin.music.model.a;

import android.database.Cursor;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.cache.b;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class a implements b {
    public final void bTy() {
        AppMethodBeat.i(139141);
        bUn();
        AppMethodBeat.o(139141);
    }

    public final void bUn() {
        AppMethodBeat.i(104908);
        long longValue = ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MUSIO_LAST_SCAN_MUSIC_FILE_TIME_LONG, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue < cls.longValue()) {
            ab.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
            AppMethodBeat.o(104908);
            return;
        }
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MUSIO_LAST_SCAN_MUSIC_FILE_TIME_LONG, Long.valueOf(currentTimeMillis));
        d.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(104906);
                a.bUo();
                AppMethodBeat.o(104906);
            }
        }, "ScanMusicThread");
        AppMethodBeat.o(104908);
    }

    static /* synthetic */ void bUo() {
        AppMethodBeat.i(104909);
        ab.i("MicroMsg.PieceCacheCleanController", "scanMusicFile");
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.plugin.music.model.e.b bUk = e.bUk();
        String format = String.format("SELECT * from %s WHERE updateTime < ? AND musicType <> ? limit 10", new Object[]{"Music"});
        long currentTimeMillis2 = System.currentTimeMillis() - 604800000;
        ArrayList<com.tencent.mm.plugin.music.model.e.a> arrayList = new ArrayList();
        Cursor rawQuery = bUk.bSd.rawQuery(format, new String[]{String.valueOf(currentTimeMillis2), "6"});
        while (rawQuery.moveToNext()) {
            com.tencent.mm.plugin.music.model.e.a aVar = new com.tencent.mm.plugin.music.model.e.a();
            aVar.d(rawQuery);
            arrayList.add(aVar);
        }
        rawQuery.close();
        for (com.tencent.mm.plugin.music.model.e.a aVar2 : arrayList) {
            String aW = com.tencent.mm.plugin.music.h.b.aW(aVar2.field_musicId, true);
            String aW2 = com.tencent.mm.plugin.music.h.b.aW(aVar2.field_musicId, false);
            String aY = com.tencent.mm.plugin.music.h.b.aY(aVar2.field_musicId, false);
            String aY2 = com.tencent.mm.plugin.music.h.b.aY(aVar2.field_musicId, true);
            com.tencent.mm.vfs.e.deleteFile(aW);
            com.tencent.mm.vfs.e.deleteFile(aW2);
            com.tencent.mm.vfs.e.deleteFile(aY);
            com.tencent.mm.vfs.e.deleteFile(aY2);
            com.tencent.mm.plugin.music.model.e.b bUk2 = e.bUk();
            aW2 = aVar2.field_musicId;
            bUk2.oNq.remove(aW2);
            bUk2.oNr.remove(aW2);
            bUk2 = e.bUk();
            aW2 = aVar2.field_musicId;
            int delete = bUk2.bSd.delete("Music", "musicId=?", new String[]{aW2});
            ab.i("MicroMsg.PieceCacheCleanController", "delete music %d %s", Integer.valueOf(delete), aVar2.field_musicId);
        }
        ab.i("MicroMsg.PieceCacheCleanController", "scanMusic UseTime=%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        ArrayList arrayList2 = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(285);
        iDKey.SetKey(com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTRED);
        iDKey.SetValue((long) ((int) r0));
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(285);
        iDKey2.SetKey(255);
        iDKey2.SetValue(1);
        arrayList2.add(iDKey);
        arrayList2.add(iDKey2);
        h.pYm.b(arrayList2, false);
        AppMethodBeat.o(104909);
    }
}
