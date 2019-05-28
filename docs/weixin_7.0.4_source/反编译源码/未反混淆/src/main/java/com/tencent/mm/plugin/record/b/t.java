package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.a.g;
import java.util.HashMap;

public final class t implements at {
    private static HashMap<Integer, d> eaA;

    public final void iy(int i) {
    }

    static {
        AppMethodBeat.i(24189);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return g.fnj;
            }
        });
        eaA.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return e.fnj;
            }
        });
        AppMethodBeat.o(24189);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(24188);
        com.tencent.mm.kernel.g.a(f.class, new k());
        AppMethodBeat.o(24188);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
