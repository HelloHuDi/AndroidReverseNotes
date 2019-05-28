package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.e;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends j<e> implements s {
    private com.tencent.mm.sdk.e.e bSd;

    public b(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, e.ccO, "FavConfigInfo", null);
        this.bSd = eVar;
    }

    public final void aV(byte[] bArr) {
        AppMethodBeat.i(5422);
        e bvt = bvt();
        boolean c;
        if (8216 == bvt.field_configId) {
            bvt.field_value = bo.cd(bArr);
            c = c(bvt, new String[0]);
            ab.i("MicroMsg.FavConfigStorage", "update sync key: %s, result %B", bvt.field_value, Boolean.valueOf(c));
            AppMethodBeat.o(5422);
            return;
        }
        bvt.field_configId = 8216;
        bvt.field_value = bo.cd(bArr);
        c = b((c) bvt);
        ab.i("MicroMsg.FavConfigStorage", "insert sync key: %s, result %B", bvt.field_value, Boolean.valueOf(c));
        AppMethodBeat.o(5422);
    }

    private e bvt() {
        AppMethodBeat.i(5423);
        e eVar = new e();
        ab.d("MicroMsg.FavConfigStorage", "get fav config sql %s", "select * from FavConfigInfo where configId = 8216");
        Cursor a = this.bSd.a("select * from FavConfigInfo where configId = 8216", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                eVar.d(a);
            }
            a.close();
        }
        AppMethodBeat.o(5423);
        return eVar;
    }

    public final byte[] buP() {
        byte[] anf;
        AppMethodBeat.i(5424);
        e bvt = bvt();
        if (8216 != bvt.field_configId) {
            ab.w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
            g.RQ();
            if (((Boolean) g.RP().Ry().get(8224, Boolean.FALSE)).booleanValue()) {
                ab.w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
            } else {
                g.RQ();
                ab.i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", bo.nullAsNil((String) g.RP().Ry().get(8216, (Object) "")));
                anf = bo.anf(r0);
                aV(anf);
                ab.w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
                g.RQ();
                g.RP().Ry().set(8224, Boolean.TRUE);
                AppMethodBeat.o(5424);
                return anf;
            }
        }
        ab.i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", Integer.valueOf(bvt.field_configId), bvt.field_value);
        anf = bo.anf(bvt.field_value);
        AppMethodBeat.o(5424);
        return anf;
    }
}
