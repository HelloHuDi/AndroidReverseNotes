package com.tencent.p177mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.StatFs;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p232b.p233a.C18440bo;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C38105ax.C19041a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.g */
public final class C10091g {
    private static final byte[] gSj = new byte[0];

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.g$b */
    public enum C10092b {
        NO_NEED,
        TRIMMED,
        TRIM_FAIL;

        static {
            AppMethodBeat.m2505o(129330);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.g$a */
    public interface C10093a {
        public static final C10093a gSm = new C100941();

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.g$a$1 */
        static class C100941 implements C10093a {
            C100941() {
            }

            public final boolean avo() {
                return false;
            }
        }

        boolean avo();
    }

    /* renamed from: an */
    public static void m17687an(String str, int i) {
        AppMethodBeat.m2504i(129331);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129331);
            return;
        }
        C26747f c26747f = (C26747f) C42340f.m74878E(C26747f.class);
        if (c26747f == null) {
            AppMethodBeat.m2505o(129331);
            return;
        }
        synchronized (gSj) {
            try {
                C33096h c33096h = new C33096h();
                c33096h.field_appId = str;
                c33096h.field_version = i;
                if (c26747f.mo10102b((C4925c) c33096h, C33096h.gSr)) {
                    c33096h.field_hit++;
                    c33096h.field_hitTimeMS = C5046bo.anU();
                    c26747f.mo10103c(c33096h, C33096h.gSr);
                } else {
                    c33096h.field_hit = 1;
                    c33096h.field_hitTimeMS = C5046bo.anU();
                    c26747f.mo10101b((C4925c) c33096h);
                }
            } finally {
                AppMethodBeat.m2505o(129331);
            }
        }
    }

    /* JADX WARNING: Missing block: B:66:0x0215, code skipped:
            r4 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static C10092b m17685a(long j, C10093a c10093a) {
        C10092b c10092b;
        long blockSize;
        C26747f c26747f;
        LinkedList linkedList;
        AppMethodBeat.m2504i(129332);
        if (j <= 0) {
            c10092b = C10092b.NO_NEED;
            AppMethodBeat.m2505o(129332);
            return c10092b;
        }
        StatFs statFs = new StatFs(C10072ap.avY());
        blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        if (blockSize < 0 || blockSize > j) {
            c10092b = C10092b.NO_NEED;
            AppMethodBeat.m2505o(129332);
            return c10092b;
        }
        c26747f = (C26747f) C42340f.m74878E(C26747f.class);
        if (c26747f == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "trimBy %d, lruStorage NULL", Long.valueOf(j));
            c10092b = C10092b.TRIM_FAIL;
            AppMethodBeat.m2505o(129332);
            return c10092b;
        }
        String format = String.format(Locale.US, " %s, %s ASC", new Object[]{"hit", "hitTimeMS"});
        linkedList = new LinkedList();
        synchronized (gSj) {
            Cursor a;
            try {
                a = c26747f.bSd.mo10105a("CodeLibUsageLRURecord", new String[]{"appId", "version"}, null, null, null, null, format, 2);
                if (a == null) {
                    c10092b = C10092b.TRIM_FAIL;
                    AppMethodBeat.m2505o(129332);
                    return c10092b;
                } else if (a.moveToFirst()) {
                    do {
                        linkedList.add(Pair.create(a.getString(0), Integer.valueOf(a.getInt(1))));
                    } while (a.moveToNext());
                    a.close();
                } else {
                    a.close();
                    c10092b = C10092b.TRIM_FAIL;
                    AppMethodBeat.m2505o(129332);
                    return c10092b;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "trimBy, read from cursor e = %s", e);
                a.close();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(129332);
            }
        }
        C4990ab.m7417i("MicroMsg.AppBrand.CodeLibPruneLRULogic", "codelib size:%d", Integer.valueOf(linkedList.size()));
        C38105ax auV = C42340f.auV();
        if (auV == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "trimBy %d, pkgStorage NULL", Long.valueOf(j));
            c10092b = C10092b.TRIM_FAIL;
            AppMethodBeat.m2505o(129332);
            return c10092b;
        }
        C10091g.m17686a(c10093a);
        Iterator it = linkedList.iterator();
        long j2 = 0;
        int i = 0;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Iterator it2 = auV.mo60859b((String) pair.first, ((Integer) pair.second).intValue(), C19041a.ASC, "pkgPath").iterator();
            while (true) {
                long j3 = j2;
                if (!it2.hasNext()) {
                    break;
                }
                C31281at c31281at = (C31281at) it2.next();
                j2 = ((long) C1173e.m2560cs(c31281at.field_pkgPath)) + j3;
                C4990ab.m7417i("MicroMsg.AppBrand.CodeLibPruneLRULogic", "wxapkg appid:%s,delete path:%s", c31281at.field_appId, c31281at.field_pkgPath);
                C1173e.deleteFile(c31281at.field_pkgPath);
                String str = c31281at.field_appId;
                final int i2 = c31281at.field_version;
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.AppBrand.CodeLibPruneLRULogic", "removeCodeCache appId null or nil!");
                } else {
                    str = str.substring(0, str.indexOf("$"));
                    C42340f.avc();
                    C42348am.m74896a(new FilenameFilter() {
                        public final boolean accept(File file, String str) {
                            AppMethodBeat.m2504i(129327);
                            boolean equals = str.equals(str + "_" + i2);
                            AppMethodBeat.m2505o(129327);
                            return equals;
                        }
                    });
                }
                i++;
                c26747f.mo44526am((String) pair.first, ((Integer) pair.second).intValue());
                C10091g.m17686a(c10093a);
                if (j2 >= j) {
                    C18440bo c18440bo = new C18440bo();
                    c18440bo.dcY = 4;
                    c18440bo.ddb = (long) i;
                    if (C19071r.avH()) {
                        blockSize = 1;
                    } else {
                        blockSize = 0;
                    }
                    c18440bo.dcW = blockSize;
                    c18440bo.ajK();
                    c10092b = C10092b.TRIMMED;
                    AppMethodBeat.m2505o(129332);
                    return c10092b;
                }
            }
        }
        c10092b = C10092b.TRIM_FAIL;
        AppMethodBeat.m2505o(129332);
        return c10092b;
    }

    /* renamed from: a */
    private static void m17686a(C10093a c10093a) {
        AppMethodBeat.m2504i(129333);
        if (c10093a == null || !c10093a.avo()) {
            AppMethodBeat.m2505o(129333);
            return;
        }
        InterruptedException interruptedException = new InterruptedException();
        AppMethodBeat.m2505o(129333);
        throw interruptedException;
    }
}
