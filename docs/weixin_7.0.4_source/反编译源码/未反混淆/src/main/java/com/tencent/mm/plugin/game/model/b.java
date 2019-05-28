package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b {
    LinkedList<String> mVh = new LinkedList();
    LinkedList<f> mVi = new LinkedList();

    public b() {
        AppMethodBeat.i(111189);
        AppMethodBeat.o(111189);
    }

    public final void init(Context context) {
        AppMethodBeat.i(111190);
        if (this.mVi == null) {
            this.mVi = new LinkedList();
        } else {
            this.mVi.clear();
        }
        if (this.mVh == null) {
            this.mVh = new LinkedList();
        } else {
            this.mVh.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        dW(context);
        long currentTimeMillis2 = System.currentTimeMillis();
        bDO();
        long currentTimeMillis3 = System.currentTimeMillis();
        ab.i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis));
        AppMethodBeat.o(111190);
    }

    private void dW(Context context) {
        AppMethodBeat.i(111191);
        Cursor dhE = a.bYJ().dhE();
        if (dhE == null) {
            ab.e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
            AppMethodBeat.o(111191);
            return;
        }
        if (dhE.moveToFirst()) {
            do {
                f fVar = new f();
                fVar.d(dhE);
                if (g.a(context, fVar) && !this.mVh.contains(fVar.field_appId)) {
                    ab.i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", fVar.field_appName, fVar.field_appId);
                    this.mVi.add(fVar);
                    this.mVh.add(fVar.field_appId);
                }
            } while (dhE.moveToNext());
        }
        dhE.close();
        AppMethodBeat.o(111191);
    }

    public final void clearCache() {
        AppMethodBeat.i(111193);
        ab.i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
        if (this.mVi != null) {
            this.mVi.clear();
        }
        if (this.mVh != null) {
            this.mVh.clear();
        }
        AppMethodBeat.o(111193);
    }

    private void bDO() {
        AppMethodBeat.i(111192);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = ((d) com.tencent.mm.kernel.g.K(d.class)).XS().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
        if (rawQuery == null) {
            List list = arrayList;
        } else {
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.downloader.f.a aVar = new com.tencent.mm.plugin.downloader.f.a();
                aVar.d(rawQuery);
                if (!bo.isNullOrNil(aVar.field_appId) && aVar.field_appId.startsWith("wx") && aVar.field_status == 3 && e.ct(aVar.field_filePath) && !arrayList.contains(aVar.field_appId)) {
                    arrayList.add(aVar.field_appId);
                }
            }
            rawQuery.close();
            Object list2 = arrayList;
        }
        if (!list2.isEmpty()) {
            for (String str : list2) {
                if (!(bo.isNullOrNil(str) || this.mVh.contains(str))) {
                    f bT = g.bT(str, false);
                    if (!(bT == null || this.mVi.contains(bT))) {
                        this.mVi.add(bT);
                        this.mVh.add(str);
                    }
                }
            }
        }
        AppMethodBeat.o(111192);
    }
}
