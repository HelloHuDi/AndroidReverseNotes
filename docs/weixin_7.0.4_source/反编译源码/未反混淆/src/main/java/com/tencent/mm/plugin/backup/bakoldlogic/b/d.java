package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;

public final class d extends a {
    private static String TAG = "MicroMsg.BakOldItemFactory";
    private static d jyU;
    private HashMap<Integer, j> jvv;

    public static d aUA() {
        d dVar;
        AppMethodBeat.i(17786);
        if (jyU == null) {
            dVar = new d();
            jyU = dVar;
            a.a(dVar);
        }
        dVar = jyU;
        AppMethodBeat.o(17786);
        return dVar;
    }

    public final void aSp() {
        jyU = null;
    }

    public final j rD(int i) {
        AppMethodBeat.i(17787);
        if (this.jvv == null) {
            this.jvv = new HashMap();
            this.jvv.put(Integer.valueOf(3), new e());
            this.jvv.put(Integer.valueOf(47), new c());
            this.jvv.put(Integer.valueOf(49), new b());
            this.jvv.put(Integer.valueOf(34), new h());
            g gVar = new g();
            this.jvv.put(Integer.valueOf(43), gVar);
            this.jvv.put(Integer.valueOf(44), gVar);
            this.jvv.put(Integer.valueOf(62), gVar);
            f fVar = new f();
            this.jvv.put(Integer.valueOf(48), fVar);
            this.jvv.put(Integer.valueOf(42), fVar);
            this.jvv.put(Integer.valueOf(66), fVar);
            this.jvv.put(Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK), fVar);
            this.jvv.put(Integer.valueOf(1), fVar);
            this.jvv.put(Integer.valueOf(37), fVar);
            this.jvv.put(Integer.valueOf(40), fVar);
            this.jvv.put(Integer.valueOf(50), fVar);
        }
        j jVar = (j) this.jvv.get(Integer.valueOf(i));
        AppMethodBeat.o(17787);
        return jVar;
    }
}
