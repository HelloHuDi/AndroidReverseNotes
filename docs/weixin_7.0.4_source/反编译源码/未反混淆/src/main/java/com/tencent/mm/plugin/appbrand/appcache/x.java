package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class x {
    private static final byte[] gSj = new byte[0];

    public interface a {
        public static final a gTt = new a() {
            public final boolean avo() {
                return false;
            }
        };

        boolean avo();
    }

    public enum b {
        NO_NEED,
        TRIMMED,
        TRIM_FAIL;

        static {
            AppMethodBeat.o(129401);
        }
    }

    public static void an(String str, int i) {
        AppMethodBeat.i(129402);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129402);
            return;
        }
        String zm = p.zm(str);
        if (bo.isNullOrNil(zm)) {
            AppMethodBeat.o(129402);
            return;
        }
        ad adVar = (ad) f.E(ad.class);
        if (adVar == null) {
            AppMethodBeat.o(129402);
            return;
        }
        synchronized (gSj) {
            try {
                ac acVar = new ac();
                acVar.field_appId = zm;
                acVar.field_type = i;
                if (adVar.b((c) acVar, ac.gSr)) {
                    acVar.field_hit++;
                    acVar.field_hitTimeMS = bo.anU();
                    adVar.c(acVar, ac.gSr);
                } else {
                    acVar.field_hit = 1;
                    acVar.field_hitTimeMS = bo.anU();
                    adVar.b((c) acVar);
                }
            } finally {
                AppMethodBeat.o(129402);
            }
        }
    }

    public static b gg(long j) {
        AppMethodBeat.i(129403);
        b a;
        try {
            a = a(j, a.gTt);
            AppMethodBeat.o(129403);
            return a;
        } catch (InterruptedException e) {
            ab.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimOffSize with dummy check, get interrupted, e = %s", e);
            a = b.TRIM_FAIL;
            AppMethodBeat.o(129403);
            return a;
        }
    }

    /* JADX WARNING: Missing block: B:62:0x01ba, code skipped:
            r4 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static b a(long j, a aVar) {
        b bVar;
        long blockSize;
        ad adVar;
        LinkedList linkedList;
        AppMethodBeat.i(129404);
        if (j <= 0) {
            bVar = b.NO_NEED;
            AppMethodBeat.o(129404);
            return bVar;
        }
        StatFs statFs = new StatFs(ap.avY());
        blockSize = (long) (statFs.getBlockSize() * statFs.getAvailableBlocks());
        if (blockSize < 0 || blockSize > j) {
            bVar = b.NO_NEED;
            AppMethodBeat.o(129404);
            return bVar;
        }
        adVar = (ad) f.E(ad.class);
        if (adVar == null) {
            ab.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", Long.valueOf(j));
            bVar = b.TRIM_FAIL;
            AppMethodBeat.o(129404);
            return bVar;
        }
        String format = String.format(Locale.US, " %s, %s ASC", new Object[]{"hit", "hitTimeMS"});
        linkedList = new LinkedList();
        synchronized (gSj) {
            Cursor a;
            try {
                a = adVar.bSd.a("PkgUsageLRURecord", new String[]{"appId", "type"}, null, null, null, null, format, 2);
                if (a == null) {
                    bVar = b.TRIM_FAIL;
                    AppMethodBeat.o(129404);
                    return bVar;
                } else if (a.moveToFirst()) {
                    do {
                        linkedList.add(Pair.create(a.getString(0), Integer.valueOf(a.getInt(1))));
                    } while (a.moveToNext());
                    a.close();
                } else {
                    a.close();
                    bVar = b.TRIM_FAIL;
                    AppMethodBeat.o(129404);
                    return bVar;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", e);
                a.close();
            } catch (Throwable th) {
                AppMethodBeat.o(129404);
            }
        }
        ax auV = f.auV();
        if (auV == null) {
            ab.e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", Long.valueOf(j));
            bVar = b.TRIM_FAIL;
            AppMethodBeat.o(129404);
            return bVar;
        }
        a(aVar);
        Iterator it = linkedList.iterator();
        long j2 = 0;
        int i = 0;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Iterator it2 = auV.a((String) pair.first, ((Integer) pair.second).intValue(), com.tencent.mm.plugin.appbrand.appcache.ax.a.ASC, "pkgPath").iterator();
            while (true) {
                long j3 = j2;
                if (!it2.hasNext()) {
                    break;
                }
                at atVar = (at) it2.next();
                j2 = e.asZ(atVar.field_pkgPath) + j3;
                e.deleteFile(atVar.field_pkgPath);
                i++;
                adVar.am((String) pair.first, ((Integer) pair.second).intValue());
                a(aVar);
                if (j2 >= j) {
                    com.tencent.mm.g.b.a.bo boVar = new com.tencent.mm.g.b.a.bo();
                    boVar.dcY = 3;
                    boVar.ddb = (long) i;
                    if (r.avG()) {
                        blockSize = 1;
                    } else {
                        blockSize = 0;
                    }
                    boVar.dcW = blockSize;
                    boVar.ajK();
                    bVar = b.TRIMMED;
                    AppMethodBeat.o(129404);
                    return bVar;
                }
            }
        }
        bVar = b.TRIM_FAIL;
        AppMethodBeat.o(129404);
        return bVar;
    }

    private static void a(a aVar) {
        AppMethodBeat.i(129405);
        if (aVar == null || !aVar.avo()) {
            AppMethodBeat.o(129405);
            return;
        }
        InterruptedException interruptedException = new InterruptedException();
        AppMethodBeat.o(129405);
        throw interruptedException;
    }
}
