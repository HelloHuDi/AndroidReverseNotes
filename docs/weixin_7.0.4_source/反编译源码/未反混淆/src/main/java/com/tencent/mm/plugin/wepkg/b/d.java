package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public class d extends j<c> {
    public static final String[] fnj = new String[]{j.a(c.fjX, "WepkgPreloadFiles")};
    private static volatile d uVK = null;
    private final h fni;
    public final boolean hrm;

    static {
        AppMethodBeat.i(63398);
        AppMethodBeat.o(63398);
    }

    public static d dgo() {
        AppMethodBeat.i(63392);
        d dVar;
        if (g.RK()) {
            if (uVK == null) {
                synchronized (d.class) {
                    try {
                        if (uVK == null || !uVK.hrm) {
                            uVK = new d(g.RP().eJN);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(63392);
                        }
                    }
                }
            }
            dVar = uVK;
            AppMethodBeat.o(63392);
            return dVar;
        }
        dVar = new d(null);
        AppMethodBeat.o(63392);
        return dVar;
    }

    private d(h hVar) {
        super(hVar, c.fjX, "WepkgPreloadFiles", c.diI);
        AppMethodBeat.i(63393);
        this.fni = hVar;
        this.hrm = hVar != null;
        if (!this.hrm) {
            ab.e("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "storage can not work!!!");
        }
        AppMethodBeat.o(63393);
    }

    public final c hu(String str, String str2) {
        AppMethodBeat.i(63394);
        if (!this.hrm || bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(63394);
            return null;
        }
        String hA = com.tencent.mm.plugin.wepkg.utils.d.hA(str, str2);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "key"}), hA);
        if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.d(rawQuery);
            rawQuery.close();
            ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid exist record in DB, pkgid:%s, rid:%s, version:%s", cVar.field_pkgId, cVar.field_rid, cVar.field_version);
            AppMethodBeat.o(63394);
            return cVar;
        }
        ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid pkgid:%s, rid:%s, no record in DB", str, str2);
        rawQuery.close();
        AppMethodBeat.o(63394);
        return null;
    }

    public final List<WepkgPreloadFile> ahD(String str) {
        List<WepkgPreloadFile> list = null;
        AppMethodBeat.i(63395);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63395);
        } else {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "pkgId"}), str);
            ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getPreLoadFileList queryStr:%s", r1);
            if (rawQuery == null) {
                ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
                AppMethodBeat.o(63395);
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                    c cVar = new c();
                    cVar.d(rawQuery);
                    wepkgPreloadFile.a(cVar);
                    list.add(wepkgPreloadFile);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", Integer.valueOf(list.size()));
                AppMethodBeat.o(63395);
            } else {
                rawQuery.close();
                ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
                AppMethodBeat.o(63395);
            }
        }
        return list;
    }

    public final boolean ahE(String str) {
        AppMethodBeat.i(63396);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(63396);
            return false;
        }
        c cVar = new c();
        cVar.field_pkgId = str;
        ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", str, Boolean.valueOf(super.a(cVar, "pkgId")));
        AppMethodBeat.o(63396);
        return super.a(cVar, "pkgId");
    }

    public final boolean h(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(63397);
        if (!this.hrm || bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(63397);
            return false;
        }
        c hu = hu(str, str2);
        if (hu == null) {
            AppMethodBeat.o(63397);
            return false;
        }
        hu.field_completeDownload = z;
        hu.field_filePath = str3;
        ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "updateDownloadCompleteState pkgid:%s, rid:%s, completeDownload:%s, filePath:%s, ret:%s", str, str2, Boolean.valueOf(z), str3, Boolean.valueOf(super.c(hu, new String[0])));
        AppMethodBeat.o(63397);
        return super.c(hu, new String[0]);
    }
}
