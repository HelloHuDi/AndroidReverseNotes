package com.tencent.mm.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import junit.framework.Assert;

public final class ga extends h {
    private static HashMap<Integer, d> eaA;
    private static ga eaz = null;

    static {
        AppMethodBeat.i(51352);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new d() {
            public final String[] Af() {
                AppMethodBeat.i(51344);
                String[] strArr = new String[1];
                Class cls = bo.class;
                strArr[0] = j.a(bo.Hm(), "FavItemInfo");
                AppMethodBeat.o(51344);
                return strArr;
            }
        });
        eaA.put(Integer.valueOf("FavSearchInfo".hashCode()), new d() {
            public final String[] Af() {
                AppMethodBeat.i(51345);
                String[] strArr = new String[1];
                Class cls = bp.class;
                strArr[0] = j.a(bp.Hm(), "FavSearchInfo");
                AppMethodBeat.o(51345);
                return strArr;
            }
        });
        eaA.put(Integer.valueOf("FavEditInfo".hashCode()), new d() {
            public final String[] Af() {
                AppMethodBeat.i(51346);
                String[] strArr = new String[1];
                Class cls = bn.class;
                strArr[0] = j.a(bn.Hm(), "FavEditInfo");
                AppMethodBeat.o(51346);
                return strArr;
            }
        });
        eaA.put(Integer.valueOf("FavCdnInfo".hashCode()), new d() {
            public final String[] Af() {
                AppMethodBeat.i(51347);
                String[] strArr = new String[1];
                Class cls = bl.class;
                strArr[0] = j.a(bl.Hm(), "FavCdnInfo");
                AppMethodBeat.o(51347);
                return strArr;
            }
        });
        eaA.put(Integer.valueOf("FavConfigInfo".hashCode()), new d() {
            public final String[] Af() {
                AppMethodBeat.i(51348);
                String[] strArr = new String[1];
                Class cls = bm.class;
                strArr[0] = j.a(bm.Hm(), "FavConfigInfo");
                AppMethodBeat.o(51348);
                return strArr;
            }
        });
        AppMethodBeat.o(51352);
    }

    private ga() {
        boolean z;
        AppMethodBeat.i(51349);
        long currentTimeMillis = System.currentTimeMillis();
        g.RN();
        if (a.QF() != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ab.d("MicroMsg.FavoriteDataBase", "db path", g.RP().cachePath + "enFavorite.db");
        g.RN();
        long QF = (long) a.QF();
        q.LK();
        if (a("", g.RP().cachePath + "enFavorite.db", QF, eaA)) {
            String str = this.ybS;
            if (!bo.isNullOrNil(str)) {
                ab.e("MicroMsg.FavoriteDataBase", "dbinit failed :".concat(String.valueOf(str)));
                b.A("init db Favorite Failed: [ " + str + "]", "DBinit");
            }
            ab.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(51349);
            return;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b((byte) 0);
        AppMethodBeat.o(51349);
        throw bVar;
    }

    public static ga HI() {
        AppMethodBeat.i(51350);
        if (eaz == null) {
            eaz = new ga();
        }
        ga gaVar = eaz;
        AppMethodBeat.o(51350);
        return gaVar;
    }

    public final void jC(String str) {
        AppMethodBeat.i(51351);
        super.jC(str);
        eaz = null;
        AppMethodBeat.o(51351);
    }
}
