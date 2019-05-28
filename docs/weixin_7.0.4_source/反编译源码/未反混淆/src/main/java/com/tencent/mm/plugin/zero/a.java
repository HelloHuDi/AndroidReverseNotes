package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

public final class a implements c, com.tencent.mm.plugin.zero.b.a {
    private e uZK = new e();
    private com.tencent.mm.m.c uZL = new com.tencent.mm.m.c();

    public a() {
        AppMethodBeat.i(58738);
        AppMethodBeat.o(58738);
    }

    public final e Nu() {
        AppMethodBeat.i(58739);
        g.RQ();
        g.RN().QU();
        e eVar = this.uZK;
        AppMethodBeat.o(58739);
        return eVar;
    }

    public final com.tencent.mm.m.c Nv() {
        AppMethodBeat.i(58740);
        g.RQ();
        g.RN().QU();
        com.tencent.mm.m.c cVar = this.uZL;
        AppMethodBeat.o(58740);
        return cVar;
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(58741);
        if (cVar.eKe) {
            com.tencent.mm.m.c cVar2 = this.uZL;
            File file = new File(com.tencent.mm.compatible.util.e.eSn + "configlist/");
            if (file.exists()) {
                File file2 = new File(com.tencent.mm.m.c.evW);
                if (!file2.exists()) {
                    ab.d("MicroMsg.ConfigListDecoder", "bugfix");
                    cVar2.d(file, file2);
                }
            }
        }
        this.uZK.sg();
        this.uZL.init();
        AppMethodBeat.o(58741);
    }

    public final void onAccountRelease() {
    }
}
