package com.tencent.mm.plugin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bh;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.m.a.a {
    private bh opq;

    public final bh XT() {
        AppMethodBeat.i(79102);
        g.RQ();
        g.RN().QU();
        bh bhVar = this.opq;
        AppMethodBeat.o(79102);
        return bhVar;
    }

    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(79103);
        this.opq = new bh(hVar);
        AppMethodBeat.o(79103);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final HashMap<Integer, h.d> collectDatabaseFactory() {
        AppMethodBeat.i(79104);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new h.d() {
            public final String[] Af() {
                return bh.fnj;
            }
        });
        AppMethodBeat.o(79104);
        return hashMap;
    }
}
