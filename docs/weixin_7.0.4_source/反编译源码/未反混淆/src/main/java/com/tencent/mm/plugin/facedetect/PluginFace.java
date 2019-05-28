package com.tencent.mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.j.c;

public class PluginFace extends f implements a {
    public String name() {
        return "plugin-facedetect";
    }

    public void execute(g gVar) {
        AppMethodBeat.i(51);
        ab.i("MicroMsg.PluginFace", "hy: starting execute.");
        if (gVar.SG()) {
            com.tencent.mm.vending.g.f.dMn().d(new a()).a((d.a) new d.a<c<Integer, String>>() {
                public final /* synthetic */ void bi(Object obj) {
                    AppMethodBeat.i(50);
                    c cVar = (c) obj;
                    if (cVar != null) {
                        int a = bo.a((Integer) cVar.get(0), -1);
                        String bc = bo.bc((String) cVar.get(1), "unknown");
                        ab.e("MicroMsg.PluginFace", "hy: onInterrupt errCode: %d, errMsg: %s", Integer.valueOf(a), bc);
                        AppMethodBeat.o(50);
                        return;
                    }
                    ab.e("MicroMsg.PluginFace", "hy: null in on interrupt");
                    AppMethodBeat.o(50);
                }
            });
        }
        AppMethodBeat.o(51);
    }
}
