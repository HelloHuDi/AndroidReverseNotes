package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

public class i extends f {
    public int fgg = 0;

    public final f Xz() {
        AppMethodBeat.i(16196);
        i iVar = new i();
        AppMethodBeat.o(16196);
        return iVar;
    }

    public final void a(StringBuilder stringBuilder, b bVar, String str, d dVar, int i, int i2) {
    }

    public final void a(Map<String, String> map, b bVar) {
        AppMethodBeat.i(16197);
        if (bVar.type == 2000) {
            this.fgg = 0;
            ab.i("MicroMsg.AppContentTransferMsgPiece", "hasTransferAddress: %s", Integer.valueOf(this.fgg));
        }
        AppMethodBeat.o(16197);
    }
}
