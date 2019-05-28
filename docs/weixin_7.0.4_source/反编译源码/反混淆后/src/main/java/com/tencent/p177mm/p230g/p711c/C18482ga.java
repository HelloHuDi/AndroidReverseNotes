package com.tencent.p177mm.p230g.p711c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.g.c.ga */
public final class C18482ga extends C7480h {
    private static HashMap<Integer, C1366d> eaA;
    private static C18482ga eaz = null;

    /* renamed from: com.tencent.mm.g.c.ga$5 */
    static class C65815 implements C1366d {
        C65815() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(51348);
            String[] strArr = new String[1];
            Class cls = C37838bm.class;
            strArr[0] = C7563j.m13217a(C37838bm.m63818Hm(), "FavConfigInfo");
            AppMethodBeat.m2505o(51348);
            return strArr;
        }
    }

    /* renamed from: com.tencent.mm.g.c.ga$4 */
    static class C95354 implements C1366d {
        C95354() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(51347);
            String[] strArr = new String[1];
            Class cls = C32684bl.class;
            strArr[0] = C7563j.m13217a(C32684bl.m53335Hm(), "FavCdnInfo");
            AppMethodBeat.m2505o(51347);
            return strArr;
        }
    }

    /* renamed from: com.tencent.mm.g.c.ga$2 */
    static class C184832 implements C1366d {
        C184832() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(51345);
            String[] strArr = new String[1];
            Class cls = C26300bp.class;
            strArr[0] = C7563j.m13217a(C26300bp.m41809Hm(), "FavSearchInfo");
            AppMethodBeat.m2505o(51345);
            return strArr;
        }
    }

    /* renamed from: com.tencent.mm.g.c.ga$3 */
    static class C184843 implements C1366d {
        C184843() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(51346);
            String[] strArr = new String[1];
            Class cls = C26299bn.class;
            strArr[0] = C7563j.m13217a(C26299bn.m41806Hm(), "FavEditInfo");
            AppMethodBeat.m2505o(51346);
            return strArr;
        }
    }

    /* renamed from: com.tencent.mm.g.c.ga$1 */
    static class C184851 implements C1366d {
        C184851() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(51344);
            String[] strArr = new String[1];
            Class cls = C9519bo.class;
            strArr[0] = C7563j.m13217a(C9519bo.m16961Hm(), "FavItemInfo");
            AppMethodBeat.m2505o(51344);
            return strArr;
        }
    }

    static {
        AppMethodBeat.m2504i(51352);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new C184851());
        eaA.put(Integer.valueOf("FavSearchInfo".hashCode()), new C184832());
        eaA.put(Integer.valueOf("FavEditInfo".hashCode()), new C184843());
        eaA.put(Integer.valueOf("FavCdnInfo".hashCode()), new C95354());
        eaA.put(Integer.valueOf("FavConfigInfo".hashCode()), new C65815());
        AppMethodBeat.m2505o(51352);
    }

    private C18482ga() {
        boolean z;
        AppMethodBeat.m2504i(51349);
        long currentTimeMillis = System.currentTimeMillis();
        C1720g.m3534RN();
        if (C1668a.m3383QF() != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        C4990ab.m7411d("MicroMsg.FavoriteDataBase", "db path", C1720g.m3536RP().cachePath + "enFavorite.db");
        C1720g.m3534RN();
        long QF = (long) C1668a.m3383QF();
        C1427q.m3026LK();
        if (mo16657a("", C1720g.m3536RP().cachePath + "enFavorite.db", QF, eaA)) {
            String str = this.ybS;
            if (!C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.FavoriteDataBase", "dbinit failed :".concat(String.valueOf(str)));
                C4872b.m7233A("init db Favorite Failed: [ " + str + "]", "DBinit");
            }
            C4990ab.m7411d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(51349);
            return;
        }
        C1819b c1819b = new C1819b((byte) 0);
        AppMethodBeat.m2505o(51349);
        throw c1819b;
    }

    /* renamed from: HI */
    public static C18482ga m28777HI() {
        AppMethodBeat.m2504i(51350);
        if (eaz == null) {
            eaz = new C18482ga();
        }
        C18482ga c18482ga = eaz;
        AppMethodBeat.m2505o(51350);
        return c18482ga;
    }

    /* renamed from: jC */
    public final void mo5708jC(String str) {
        AppMethodBeat.m2504i(51351);
        super.mo5708jC(str);
        eaz = null;
        AppMethodBeat.m2505o(51351);
    }
}
