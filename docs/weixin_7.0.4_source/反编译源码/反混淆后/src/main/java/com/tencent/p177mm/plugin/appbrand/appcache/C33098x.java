package com.tencent.p177mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C18440bo;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C38105ax.C19041a;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.x */
public final class C33098x {
    private static final byte[] gSj = new byte[0];

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.x$a */
    public interface C33099a {
        public static final C33099a gTt = new C267491();

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.x$a$1 */
        static class C267491 implements C33099a {
            C267491() {
            }

            public final boolean avo() {
                return false;
            }
        }

        boolean avo();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.x$b */
    public enum C33100b {
        NO_NEED,
        TRIMMED,
        TRIM_FAIL;

        static {
            AppMethodBeat.m2505o(129401);
        }
    }

    /* renamed from: an */
    public static void m54093an(String str, int i) {
        AppMethodBeat.m2504i(129402);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129402);
            return;
        }
        String zm = C26842p.m42740zm(str);
        if (C5046bo.isNullOrNil(zm)) {
            AppMethodBeat.m2505o(129402);
            return;
        }
        C45511ad c45511ad = (C45511ad) C42340f.m74878E(C45511ad.class);
        if (c45511ad == null) {
            AppMethodBeat.m2505o(129402);
            return;
        }
        synchronized (gSj) {
            try {
                C42345ac c42345ac = new C42345ac();
                c42345ac.field_appId = zm;
                c42345ac.field_type = i;
                if (c45511ad.mo10102b((C4925c) c42345ac, C42345ac.gSr)) {
                    c42345ac.field_hit++;
                    c42345ac.field_hitTimeMS = C5046bo.anU();
                    c45511ad.mo10103c(c42345ac, C42345ac.gSr);
                } else {
                    c42345ac.field_hit = 1;
                    c42345ac.field_hitTimeMS = C5046bo.anU();
                    c45511ad.mo10101b((C4925c) c42345ac);
                }
            } finally {
                AppMethodBeat.m2505o(129402);
            }
        }
    }

    /* renamed from: gg */
    public static C33100b m54094gg(long j) {
        AppMethodBeat.m2504i(129403);
        C33100b a;
        try {
            a = C33098x.m54091a(j, C33099a.gTt);
            AppMethodBeat.m2505o(129403);
            return a;
        } catch (InterruptedException e) {
            C4990ab.m7413e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimOffSize with dummy check, get interrupted, e = %s", e);
            a = C33100b.TRIM_FAIL;
            AppMethodBeat.m2505o(129403);
            return a;
        }
    }

    /* JADX WARNING: Missing block: B:62:0x01ba, code skipped:
            r4 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static C33100b m54091a(long j, C33099a c33099a) {
        C33100b c33100b;
        long blockSize;
        C45511ad c45511ad;
        LinkedList linkedList;
        AppMethodBeat.m2504i(129404);
        if (j <= 0) {
            c33100b = C33100b.NO_NEED;
            AppMethodBeat.m2505o(129404);
            return c33100b;
        }
        StatFs statFs = new StatFs(C10072ap.avY());
        blockSize = (long) (statFs.getBlockSize() * statFs.getAvailableBlocks());
        if (blockSize < 0 || blockSize > j) {
            c33100b = C33100b.NO_NEED;
            AppMethodBeat.m2505o(129404);
            return c33100b;
        }
        c45511ad = (C45511ad) C42340f.m74878E(C45511ad.class);
        if (c45511ad == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, lruStorage NULL", Long.valueOf(j));
            c33100b = C33100b.TRIM_FAIL;
            AppMethodBeat.m2505o(129404);
            return c33100b;
        }
        String format = String.format(Locale.US, " %s, %s ASC", new Object[]{"hit", "hitTimeMS"});
        linkedList = new LinkedList();
        synchronized (gSj) {
            Cursor a;
            try {
                a = c45511ad.bSd.mo10105a("PkgUsageLRURecord", new String[]{"appId", "type"}, null, null, null, null, format, 2);
                if (a == null) {
                    c33100b = C33100b.TRIM_FAIL;
                    AppMethodBeat.m2505o(129404);
                    return c33100b;
                } else if (a.moveToFirst()) {
                    do {
                        linkedList.add(Pair.create(a.getString(0), Integer.valueOf(a.getInt(1))));
                    } while (a.moveToNext());
                    a.close();
                } else {
                    a.close();
                    c33100b = C33100b.TRIM_FAIL;
                    AppMethodBeat.m2505o(129404);
                    return c33100b;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy, read from cursor e = %s", e);
                a.close();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(129404);
            }
        }
        C38105ax auV = C42340f.auV();
        if (auV == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.PkgPruneLRULogic", "trimBy %d, pkgStorage NULL", Long.valueOf(j));
            c33100b = C33100b.TRIM_FAIL;
            AppMethodBeat.m2505o(129404);
            return c33100b;
        }
        C33098x.m54092a(c33099a);
        Iterator it = linkedList.iterator();
        long j2 = 0;
        int i = 0;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Iterator it2 = auV.mo60843a((String) pair.first, ((Integer) pair.second).intValue(), C19041a.ASC, "pkgPath").iterator();
            while (true) {
                long j3 = j2;
                if (!it2.hasNext()) {
                    break;
                }
                C31281at c31281at = (C31281at) it2.next();
                j2 = C5730e.asZ(c31281at.field_pkgPath) + j3;
                C5730e.deleteFile(c31281at.field_pkgPath);
                i++;
                c45511ad.mo73320am((String) pair.first, ((Integer) pair.second).intValue());
                C33098x.m54092a(c33099a);
                if (j2 >= j) {
                    C18440bo c18440bo = new C18440bo();
                    c18440bo.dcY = 3;
                    c18440bo.ddb = (long) i;
                    if (C19071r.avG()) {
                        blockSize = 1;
                    } else {
                        blockSize = 0;
                    }
                    c18440bo.dcW = blockSize;
                    c18440bo.ajK();
                    c33100b = C33100b.TRIMMED;
                    AppMethodBeat.m2505o(129404);
                    return c33100b;
                }
            }
        }
        c33100b = C33100b.TRIM_FAIL;
        AppMethodBeat.m2505o(129404);
        return c33100b;
    }

    /* renamed from: a */
    private static void m54092a(C33099a c33099a) {
        AppMethodBeat.m2504i(129405);
        if (c33099a == null || !c33099a.avo()) {
            AppMethodBeat.m2505o(129405);
            return;
        }
        InterruptedException interruptedException = new InterruptedException();
        AppMethodBeat.m2505o(129405);
        throw interruptedException;
    }
}
