package com.tencent.mm.plugin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class a extends q implements com.tencent.mm.plugin.auth.a.a {
    private static a ksU;

    private a() {
        super(f.class);
    }

    public static synchronized a beP() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(79085);
            if (ksU == null) {
                ksU = new a();
            }
            aVar = ksU;
            AppMethodBeat.o(79085);
        }
        return aVar;
    }

    public final void a(j.f fVar, g gVar, boolean z) {
    }

    public final void a(b bVar, String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.i(79086);
        if (bVar.vyJ.luF != 0) {
            final mw mwVar = bVar.vyJ.vMl;
            final mw mwVar2 = bVar.vyJ.vMm;
            final mw mwVar3 = bVar.vyJ.vMn;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(79084);
                    com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                    long j = -1;
                    f.afu();
                    if (!(f.afw() == null || mwVar == null)) {
                        f.afu();
                        f.afw().a(mwVar, mwVar2, mwVar3);
                        j = aVar.Mr();
                    }
                    ab.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", Long.valueOf(aVar.Mr()), Long.valueOf(j));
                    AppMethodBeat.o(79084);
                }
            });
        }
        AppMethodBeat.o(79086);
    }
}
