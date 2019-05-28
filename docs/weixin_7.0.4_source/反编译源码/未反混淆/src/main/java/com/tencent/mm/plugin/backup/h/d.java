package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends a {
    private static String TAG = "MicroMsg.BackupStorageModel";
    private static d jyz;
    private b jyA;
    private a jyB;

    public static d aUr() {
        d dVar;
        AppMethodBeat.i(17706);
        if (jyz == null) {
            dVar = new d();
            jyz = dVar;
            a.a(dVar);
        }
        dVar = jyz;
        AppMethodBeat.o(17706);
        return dVar;
    }

    public final void aSp() {
        jyz = null;
    }

    public final b aUs() {
        AppMethodBeat.i(17707);
        if (this.jyA == null) {
            this.jyA = new b();
        }
        b bVar = this.jyA;
        AppMethodBeat.o(17707);
        return bVar;
    }

    public final a aUt() {
        AppMethodBeat.i(17708);
        if (this.jyB == null) {
            this.jyB = new a();
        }
        a aVar = this.jyB;
        AppMethodBeat.o(17708);
        return aVar;
    }

    public final void aUu() {
        AppMethodBeat.i(17709);
        ab.i(TAG, "backupInitStorage");
        b aUs = aUs();
        aw.ZK();
        String accPath = c.getAccPath();
        aw.ZK();
        aUs.bF(accPath, c.QF());
        AppMethodBeat.o(17709);
    }
}
