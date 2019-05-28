package com.tencent.p177mm.plugin.music.model.p998a;

import android.database.Cursor;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.music.cache.C21342b;
import com.tencent.p177mm.plugin.music.model.C39445e;
import com.tencent.p177mm.plugin.music.model.p1000e.C12680b;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.view.C31128d;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.music.model.a.a */
public final class C28569a implements C21342b {

    /* renamed from: com.tencent.mm.plugin.music.model.a.a$1 */
    class C285701 implements Runnable {
        C285701() {
        }

        public final void run() {
            AppMethodBeat.m2504i(104906);
            C28569a.bUo();
            AppMethodBeat.m2505o(104906);
        }
    }

    public final void bTy() {
        AppMethodBeat.m2504i(139141);
        bUn();
        AppMethodBeat.m2505o(139141);
    }

    public final void bUn() {
        AppMethodBeat.m2504i(104908);
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MUSIO_LAST_SCAN_MUSIC_FILE_TIME_LONG, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue < cls.longValue()) {
            C4990ab.m7412e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
            AppMethodBeat.m2505o(104908);
            return;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MUSIO_LAST_SCAN_MUSIC_FILE_TIME_LONG, Long.valueOf(currentTimeMillis));
        C7305d.m12298f(new C285701(), "ScanMusicThread");
        AppMethodBeat.m2505o(104908);
    }

    static /* synthetic */ void bUo() {
        AppMethodBeat.m2504i(104909);
        C4990ab.m7416i("MicroMsg.PieceCacheCleanController", "scanMusicFile");
        long currentTimeMillis = System.currentTimeMillis();
        C12680b bUk = C39445e.bUk();
        String format = String.format("SELECT * from %s WHERE updateTime < ? AND musicType <> ? limit 10", new Object[]{"Music"});
        long currentTimeMillis2 = System.currentTimeMillis() - 604800000;
        ArrayList<C28575a> arrayList = new ArrayList();
        Cursor rawQuery = bUk.bSd.rawQuery(format, new String[]{String.valueOf(currentTimeMillis2), "6"});
        while (rawQuery.moveToNext()) {
            C28575a c28575a = new C28575a();
            c28575a.mo8995d(rawQuery);
            arrayList.add(c28575a);
        }
        rawQuery.close();
        for (C28575a c28575a2 : arrayList) {
            String aW = C12673b.m20673aW(c28575a2.field_musicId, true);
            String aW2 = C12673b.m20673aW(c28575a2.field_musicId, false);
            String aY = C12673b.m20675aY(c28575a2.field_musicId, false);
            String aY2 = C12673b.m20675aY(c28575a2.field_musicId, true);
            C5730e.deleteFile(aW);
            C5730e.deleteFile(aW2);
            C5730e.deleteFile(aY);
            C5730e.deleteFile(aY2);
            C12680b bUk2 = C39445e.bUk();
            aW2 = c28575a2.field_musicId;
            bUk2.oNq.remove(aW2);
            bUk2.oNr.remove(aW2);
            bUk2 = C39445e.bUk();
            aW2 = c28575a2.field_musicId;
            int delete = bUk2.bSd.delete("Music", "musicId=?", new String[]{aW2});
            C4990ab.m7417i("MicroMsg.PieceCacheCleanController", "delete music %d %s", Integer.valueOf(delete), c28575a2.field_musicId);
        }
        C4990ab.m7417i("MicroMsg.PieceCacheCleanController", "scanMusic UseTime=%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        ArrayList arrayList2 = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(285);
        iDKey.SetKey(C31128d.MIC_PTU_ZIPAI_LIGHTRED);
        iDKey.SetValue((long) ((int) r0));
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(285);
        iDKey2.SetKey(255);
        iDKey2.SetValue(1);
        arrayList2.add(iDKey);
        arrayList2.add(iDKey2);
        C7060h.pYm.mo8379b(arrayList2, false);
        AppMethodBeat.m2505o(104909);
    }
}
