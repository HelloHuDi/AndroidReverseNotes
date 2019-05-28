package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a extends j<c> implements q {
    private e bSd;
    private List<p> bkF = new CopyOnWriteArrayList();

    public final /* synthetic */ boolean c(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        AppMethodBeat.i(5419);
        boolean a = a((c) cVar, strArr);
        AppMethodBeat.o(5419);
        return a;
    }

    public final void a(p pVar) {
        AppMethodBeat.i(5402);
        if (pVar != null) {
            this.bkF.add(pVar);
        }
        AppMethodBeat.o(5402);
    }

    public final void b(p pVar) {
        AppMethodBeat.i(5403);
        if (pVar != null) {
            this.bkF.remove(pVar);
        }
        AppMethodBeat.o(5403);
    }

    public a(e eVar) {
        super(eVar, c.ccO, "FavCdnInfo", null);
        AppMethodBeat.i(5404);
        this.bSd = eVar;
        AppMethodBeat.o(5404);
    }

    public final void buL() {
        AppMethodBeat.i(5405);
        this.bSd.hY("FavCdnInfo", "update FavCdnInfo set status = 1 where status <> 3");
        AppMethodBeat.o(5405);
    }

    public final boolean e(c cVar) {
        AppMethodBeat.i(5406);
        if (cVar == null) {
            AppMethodBeat.o(5406);
            return false;
        } else if (super.b((com.tencent.mm.sdk.e.c) cVar)) {
            for (p pVar : this.bkF) {
                if (pVar != null) {
                    pVar.d(cVar);
                }
            }
            AppMethodBeat.o(5406);
            return true;
        } else {
            AppMethodBeat.o(5406);
            return false;
        }
    }

    public final boolean a(c cVar, String... strArr) {
        AppMethodBeat.i(5407);
        if (super.c(cVar, strArr)) {
            for (p pVar : this.bkF) {
                if (pVar != null) {
                    pVar.d(cVar);
                }
            }
            AppMethodBeat.o(5407);
            return true;
        }
        AppMethodBeat.o(5407);
        return false;
    }

    public final boolean b(c cVar, String... strArr) {
        AppMethodBeat.i(5408);
        if (super.a((com.tencent.mm.sdk.e.c) cVar, strArr)) {
            for (p pVar : this.bkF) {
                if (pVar != null) {
                    pVar.d(cVar);
                }
            }
            AppMethodBeat.o(5408);
            return true;
        }
        AppMethodBeat.o(5408);
        return false;
    }

    public final c LR(String str) {
        c cVar = null;
        AppMethodBeat.i(5409);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FavCdnStorage", "md5 null");
            AppMethodBeat.o(5409);
        } else {
            Cursor a = this.bSd.a("select * from FavCdnInfo where dataId = '" + str + "'", null, 2);
            if (a == null) {
                AppMethodBeat.o(5409);
            } else {
                if (a.moveToFirst()) {
                    cVar = new c();
                    cVar.d(a);
                }
                a.close();
                AppMethodBeat.o(5409);
            }
        }
        return cVar;
    }

    public final void x(g gVar) {
        AppMethodBeat.i(5410);
        this.bSd.hY("FavCdnInfo", "update FavCdnInfo set status = 1,modifyTime = " + bo.anU() + " where favLocalId = " + gVar.field_localId + " and type = 0 and status <> 3");
        AppMethodBeat.o(5410);
    }

    public final LinkedList<c> buM() {
        LinkedList<c> linkedList = null;
        AppMethodBeat.i(5411);
        Cursor a = this.bSd.a("select * from FavCdnInfo where status = 1 order by modifyTime desc " + " limit 1", null, 2);
        if (a == null) {
            AppMethodBeat.o(5411);
        } else if (a.moveToFirst()) {
            linkedList = new LinkedList();
            do {
                c cVar = new c();
                cVar.d(a);
                linkedList.add(cVar);
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.o(5411);
        } else {
            a.close();
            AppMethodBeat.o(5411);
        }
        return linkedList;
    }

    public final List<c> iz(long j) {
        AppMethodBeat.i(5412);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a("select * from FavCdnInfo where favLocalId = ".concat(String.valueOf(j)), null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                c cVar = new c();
                cVar.d(a);
                arrayList.add(cVar);
            }
            a.close();
        }
        ab.v("MicroMsg.FavCdnStorage", "getInfos size:%d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(5412);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<c> iA(long j) {
        AppMethodBeat.i(5413);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.bSd.a("select * from FavCdnInfo where favLocalId = " + j + " and type = 0 and status = 3", null, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            ab.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", Integer.valueOf(linkedList.size()));
            AppMethodBeat.o(5413);
            return linkedList;
        }
        do {
            c cVar = new c();
            cVar.d(a);
            linkedList.add(cVar);
        } while (a.moveToNext());
        if (a != null) {
        }
        ab.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(5413);
        return linkedList;
    }

    public final void iB(long j) {
        AppMethodBeat.i(5414);
        this.bSd.hY("FavCdnInfo", String.format("delete from %s where %s = %d and %s = %d", new Object[]{"FavCdnInfo", "favLocalId", Long.valueOf(j), "type", Integer.valueOf(0)}));
        AppMethodBeat.o(5414);
    }

    public final int r(long j, int i) {
        AppMethodBeat.i(5415);
        Cursor a = this.bSd.a("select status from FavCdnInfo where favLocalId = " + j + " and type = " + i, null, 2);
        if (a == null) {
            AppMethodBeat.o(5415);
            return 3;
        } else if (a.moveToFirst()) {
            int i2 = 1;
            int i3 = 1;
            int i4 = 1;
            do {
                int i5 = a.getInt(0);
                if (i5 == 1) {
                    a.close();
                    AppMethodBeat.o(5415);
                    return 1;
                }
                if (i5 != 4) {
                    i4 = 0;
                }
                if (i5 != 2) {
                    i3 = 0;
                }
                if (i5 != 3) {
                    i2 = 0;
                }
            } while (a.moveToNext());
            a.close();
            if (i3 != 0) {
                AppMethodBeat.o(5415);
                return 2;
            } else if (i4 != 0) {
                AppMethodBeat.o(5415);
                return 4;
            } else if (i2 != 0) {
                AppMethodBeat.o(5415);
                return 3;
            } else {
                AppMethodBeat.o(5415);
                return 0;
            }
        } else {
            a.close();
            AppMethodBeat.o(5415);
            return 3;
        }
    }

    public final Cursor buN() {
        AppMethodBeat.i(5416);
        Cursor rawQuery = this.bSd.rawQuery("select * from FavCdnInfo where type = 0 and status = 1", null);
        AppMethodBeat.o(5416);
        return rawQuery;
    }

    public final Cursor buO() {
        AppMethodBeat.i(5417);
        Cursor rawQuery = this.bSd.rawQuery("select * from FavCdnInfo where type = 1 and status = 1", null);
        AppMethodBeat.o(5417);
        return rawQuery;
    }

    public final boolean iC(long j) {
        AppMethodBeat.i(5418);
        c cVar = new c();
        cVar.field_favLocalId = j;
        boolean b = b(cVar, "favLocalId");
        AppMethodBeat.o(5418);
        return b;
    }
}
