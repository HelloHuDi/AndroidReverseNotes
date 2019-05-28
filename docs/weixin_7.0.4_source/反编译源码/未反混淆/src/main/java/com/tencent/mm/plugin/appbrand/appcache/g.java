package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g {
    private static final byte[] gSj = new byte[0];

    public enum b {
        NO_NEED,
        TRIMMED,
        TRIM_FAIL;

        static {
            AppMethodBeat.o(129330);
        }
    }

    public interface a {
        public static final a gSm = new a() {
            public final boolean avo() {
                return false;
            }
        };

        boolean avo();
    }

    public static void an(String str, int i) {
        AppMethodBeat.i(129331);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129331);
            return;
        }
        f fVar = (f) f.E(f.class);
        if (fVar == null) {
            AppMethodBeat.o(129331);
            return;
        }
        synchronized (gSj) {
            try {
                h hVar = new h();
                hVar.field_appId = str;
                hVar.field_version = i;
                if (fVar.b((c) hVar, h.gSr)) {
                    hVar.field_hit++;
                    hVar.field_hitTimeMS = bo.anU();
                    fVar.c(hVar, h.gSr);
                } else {
                    hVar.field_hit = 1;
                    hVar.field_hitTimeMS = bo.anU();
                    fVar.b((c) hVar);
                }
            } finally {
                AppMethodBeat.o(129331);
            }
        }
    }

    /* JADX WARNING: Missing block: B:66:0x0215, code skipped:
            r4 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static b a(long j, a aVar) {
        b bVar;
        long blockSize;
        f fVar;
        LinkedList linkedList;
        AppMethodBeat.i(129332);
        if (j <= 0) {
            bVar = b.NO_NEED;
            AppMethodBeat.o(129332);
            return bVar;
        }
        StatFs statFs = new StatFs(ap.avY());
        blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        if (blockSize < 0 || blockSize > j) {
            bVar = b.NO_NEED;
            AppMethodBeat.o(129332);
            return bVar;
        }
        fVar = (f) f.E(f.class);
        if (fVar == null) {
            ab.e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "trimBy %d, lruStorage NULL", Long.valueOf(j));
            bVar = b.TRIM_FAIL;
            AppMethodBeat.o(129332);
            return bVar;
        }
        String format = String.format(Locale.US, " %s, %s ASC", new Object[]{"hit", "hitTimeMS"});
        linkedList = new LinkedList();
        synchronized (gSj) {
            Cursor a;
            try {
                a = fVar.bSd.a("CodeLibUsageLRURecord", new String[]{"appId", "version"}, null, null, null, null, format, 2);
                if (a == null) {
                    bVar = b.TRIM_FAIL;
                    AppMethodBeat.o(129332);
                    return bVar;
                } else if (a.moveToFirst()) {
                    do {
                        linkedList.add(Pair.create(a.getString(0), Integer.valueOf(a.getInt(1))));
                    } while (a.moveToNext());
                    a.close();
                } else {
                    a.close();
                    bVar = b.TRIM_FAIL;
                    AppMethodBeat.o(129332);
                    return bVar;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "trimBy, read from cursor e = %s", e);
                a.close();
            } catch (Throwable th) {
                AppMethodBeat.o(129332);
            }
        }
        ab.i("MicroMsg.AppBrand.CodeLibPruneLRULogic", "codelib size:%d", Integer.valueOf(linkedList.size()));
        ax auV = f.auV();
        if (auV == null) {
            ab.e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "trimBy %d, pkgStorage NULL", Long.valueOf(j));
            bVar = b.TRIM_FAIL;
            AppMethodBeat.o(129332);
            return bVar;
        }
        a(aVar);
        Iterator it = linkedList.iterator();
        long j2 = 0;
        int i = 0;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Iterator it2 = auV.b((String) pair.first, ((Integer) pair.second).intValue(), com.tencent.mm.plugin.appbrand.appcache.ax.a.ASC, "pkgPath").iterator();
            while (true) {
                long j3 = j2;
                if (!it2.hasNext()) {
                    break;
                }
                at atVar = (at) it2.next();
                j2 = ((long) e.cs(atVar.field_pkgPath)) + j3;
                ab.i("MicroMsg.AppBrand.CodeLibPruneLRULogic", "wxapkg appid:%s,delete path:%s", atVar.field_appId, atVar.field_pkgPath);
                e.deleteFile(atVar.field_pkgPath);
                String str = atVar.field_appId;
                final int i2 = atVar.field_version;
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "removeCodeCache appId null or nil!");
                } else {
                    str = str.substring(0, str.indexOf("$"));
                    f.avc();
                    am.a(new FilenameFilter() {
                        public final boolean accept(File file, String str) {
                            AppMethodBeat.i(129327);
                            boolean equals = str.equals(str + "_" + i2);
                            AppMethodBeat.o(129327);
                            return equals;
                        }
                    });
                }
                i++;
                fVar.am((String) pair.first, ((Integer) pair.second).intValue());
                a(aVar);
                if (j2 >= j) {
                    com.tencent.mm.g.b.a.bo boVar = new com.tencent.mm.g.b.a.bo();
                    boVar.dcY = 4;
                    boVar.ddb = (long) i;
                    if (r.avH()) {
                        blockSize = 1;
                    } else {
                        blockSize = 0;
                    }
                    boVar.dcW = blockSize;
                    boVar.ajK();
                    bVar = b.TRIMMED;
                    AppMethodBeat.o(129332);
                    return bVar;
                }
            }
        }
        bVar = b.TRIM_FAIL;
        AppMethodBeat.o(129332);
        return bVar;
    }

    private static void a(a aVar) {
        AppMethodBeat.i(129333);
        if (aVar == null || !aVar.avo()) {
            AppMethodBeat.o(129333);
            return;
        }
        InterruptedException interruptedException = new InterruptedException();
        AppMethodBeat.o(129333);
        throw interruptedException;
    }
}
