package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class bn extends j<bm> {
    public static final String[] fnj = new String[]{j.a(bm.ccO, "NewTipsInfo")};
    public e bSd;

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(80291);
        boolean f = f((bm) cVar);
        AppMethodBeat.o(80291);
        return f;
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        AppMethodBeat.i(80290);
        boolean a = a((bm) cVar, strArr);
        AppMethodBeat.o(80290);
        return a;
    }

    static {
        AppMethodBeat.i(80292);
        AppMethodBeat.o(80292);
    }

    public bn(e eVar) {
        super(eVar, bm.ccO, "NewTipsInfo", null);
        this.bSd = eVar;
    }

    public final boolean f(bm bmVar) {
        boolean z = false;
        AppMethodBeat.i(80287);
        if (bmVar == null) {
            ab.e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
            AppMethodBeat.o(80287);
        } else if (bmVar.field_tipId <= 0) {
            ab.e("MicroMsg.NewTipsInfoStorage", "newTipsId is error, tipsId = %s", Integer.valueOf(bmVar.field_tipId));
            AppMethodBeat.o(80287);
        } else {
            z = a((c) bmVar, false);
            if (z) {
                b(bmVar.field_tipId, 2, Integer.valueOf(bmVar.field_tipId));
            }
            AppMethodBeat.o(80287);
        }
        return z;
    }

    public final boolean a(bm bmVar, String... strArr) {
        AppMethodBeat.i(80288);
        if (bmVar == null) {
            ab.e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
            AppMethodBeat.o(80288);
            return false;
        }
        boolean b = super.b(bmVar, false, strArr);
        if (b) {
            b(bmVar.field_tipId, 3, Integer.valueOf(bmVar.field_tipId));
        }
        ab.d("MicroMsg.NewTipsInfoStorage", "update result[%B]", Boolean.valueOf(b));
        AppMethodBeat.o(80288);
        return b;
    }

    public final bm Ms(int i) {
        AppMethodBeat.i(80289);
        if (this.bSd == null) {
            ab.e("MicroMsg.NewTipsInfoStorage", "getByTipsId, but db is null, return");
            AppMethodBeat.o(80289);
            return null;
        }
        Cursor a = this.bSd.a("NewTipsInfo", null, "tipId=?", new String[]{String.valueOf(i)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bm bmVar = new bm();
            try {
                bmVar.d(a);
                a.close();
                AppMethodBeat.o(80289);
                return bmVar;
            } catch (Exception e) {
                ab.e("MicroMsg.NewTipsInfoStorage", "getByTipsId convertFrom(cu) cause IlleagalStateException, return null");
                a.close();
                AppMethodBeat.o(80289);
                return null;
            }
        }
        ab.w("MicroMsg.NewTipsInfoStorage", "getByTipsId:%d, no data", Integer.valueOf(i));
        a.close();
        AppMethodBeat.o(80289);
        return null;
    }
}
