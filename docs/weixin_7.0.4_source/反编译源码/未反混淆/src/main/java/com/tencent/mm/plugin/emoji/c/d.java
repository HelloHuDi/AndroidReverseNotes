package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends c<pe> {
    public d() {
        AppMethodBeat.i(52818);
        this.xxI = pe.class.getName().hashCode();
        AppMethodBeat.o(52818);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(52819);
        pe peVar = (pe) bVar;
        if (peVar instanceof pe) {
            if (peVar.cLt.cvx == 0) {
                com.tencent.mm.plugin.emoji.model.d bkh = j.bkh();
                long j = peVar.cLt.cLw;
                bkh.kVf.put(Long.valueOf(j), peVar.cLt.cLu);
            } else {
                ab.i("MicroMsg.emoji.EmojiRevokeMsgListener", "has handle in sys cmd msg extension.");
            }
        }
        AppMethodBeat.o(52819);
        return false;
    }
}
