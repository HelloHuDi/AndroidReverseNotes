package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.g.a.sr.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class p extends c<sr> {
    public p() {
        AppMethodBeat.i(41557);
        this.xxI = sr.class.getName().hashCode();
        AppMethodBeat.o(41557);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(41558);
        sr srVar = (sr) bVar;
        if (!g.RK()) {
            ab.e("MicroMsg.SupportFingerPrintEventListener", "SupportFingerPrintEventListener account is not ready");
        } else if (srVar instanceof sr) {
            ab.i("MicroMsg.SupportFingerPrintEventListener", "handle SupportFingerPrintEvent");
            boolean bxj = c.bxj();
            ab.i("MicroMsg.SupportFingerPrintEventListener", "isSupportFP is ".concat(String.valueOf(bxj)));
            a aVar = new a();
            aVar.cOQ = bxj;
            srVar.cOP = aVar;
            if (srVar.callback != null) {
                srVar.callback.run();
            }
            AppMethodBeat.o(41558);
            return true;
        }
        AppMethodBeat.o(41558);
        return false;
    }
}
