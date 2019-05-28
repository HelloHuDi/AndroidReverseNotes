package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.m.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;

public final class bw extends j<bv> implements m {
    public static final String[] fnj = new String[]{j.a(bv.ccO, "Stranger")};
    private e bSd;
    private final l<a, bv> xHV = new l<a, bv>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(1473);
            ((a) obj).a((bv) obj2);
            AppMethodBeat.o(1473);
        }
    };

    static {
        AppMethodBeat.i(1482);
        AppMethodBeat.o(1482);
    }

    private void b(bv bvVar) {
        AppMethodBeat.i(1474);
        if (this.xHV.cF(bvVar)) {
            this.xHV.doNotify();
        }
        AppMethodBeat.o(1474);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(1475);
        this.xHV.a(aVar, null);
        AppMethodBeat.o(1475);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(1476);
        this.xHV.remove(aVar);
        AppMethodBeat.o(1476);
    }

    public bw(e eVar) {
        super(eVar, bv.ccO, "Stranger", null);
        AppMethodBeat.i(1477);
        this.bSd = eVar;
        AppMethodBeat.o(1477);
    }

    public final bv RB(String str) {
        AppMethodBeat.i(1478);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(1478);
            return null;
        }
        bv bvVar = new bv();
        Cursor a = this.bSd.a("Stranger", null, "encryptUsername = ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            bvVar.d(a);
        }
        a.close();
        AppMethodBeat.o(1478);
        return bvVar;
    }

    public final int RC(String str) {
        AppMethodBeat.i(1479);
        int delete = this.bSd.delete("Stranger", "(encryptUsername=?)", new String[]{String.valueOf(str)});
        if (delete > 0) {
            doNotify();
        }
        ab.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + str + " result:" + delete);
        AppMethodBeat.o(1479);
        return delete;
    }
}
