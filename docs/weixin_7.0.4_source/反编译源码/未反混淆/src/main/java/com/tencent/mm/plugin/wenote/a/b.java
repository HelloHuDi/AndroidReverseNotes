package com.tencent.mm.plugin.wenote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends c<lz> {
    public b() {
        AppMethodBeat.i(26588);
        this.xxI = lz.class.getName().hashCode();
        AppMethodBeat.o(26588);
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(26589);
        lz lzVar = (lz) bVar;
        if (lzVar.cHO.cHc) {
            h.pYm.e(14789, Integer.valueOf(3));
        } else {
            h.pYm.e(14789, Integer.valueOf(2));
        }
        ab.i("MicroMsg.OpenNoteFromSessionListener", "do OpenNoteFromSessionListener");
        j jVar = new j();
        com.tencent.mm.plugin.wenote.model.c.ddG().uMN = jVar;
        abh abh = new abh();
        abh.scene = lzVar.cHO.scene;
        jVar.a(lzVar.cHO.cHP, Long.valueOf(lzVar.cHO.cvx), lzVar.cHO.cHc, lzVar.cHO.context, 0, 0, abh);
        AppMethodBeat.o(26589);
        return false;
    }
}
