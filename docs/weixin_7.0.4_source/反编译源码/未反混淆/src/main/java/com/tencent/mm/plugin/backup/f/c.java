package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;

public final class c extends a {
    private static String TAG = "MicroMsg.BackupItemFactory";
    private static c jvu;
    private HashMap<Integer, l> jvv;

    public static c aTz() {
        c cVar;
        AppMethodBeat.i(17451);
        if (jvu == null) {
            cVar = new c();
            jvu = cVar;
            a.a(cVar);
        }
        cVar = jvu;
        AppMethodBeat.o(17451);
        return cVar;
    }

    public final void aSp() {
        jvu = null;
    }

    public final l rq(int i) {
        AppMethodBeat.i(17452);
        if (this.jvv == null) {
            aTA();
        }
        l lVar = (l) this.jvv.get(Integer.valueOf(i));
        AppMethodBeat.o(17452);
        return lVar;
    }

    private void aTA() {
        AppMethodBeat.i(17453);
        this.jvv = new HashMap();
        this.jvv.put(Integer.valueOf(3), new d());
        this.jvv.put(Integer.valueOf(47), new b());
        this.jvv.put(Integer.valueOf(49), new a());
        this.jvv.put(Integer.valueOf(34), new g());
        f fVar = new f();
        this.jvv.put(Integer.valueOf(43), fVar);
        this.jvv.put(Integer.valueOf(44), fVar);
        this.jvv.put(Integer.valueOf(62), fVar);
        e eVar = new e();
        this.jvv.put(Integer.valueOf(48), eVar);
        this.jvv.put(Integer.valueOf(42), eVar);
        this.jvv.put(Integer.valueOf(66), eVar);
        this.jvv.put(Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK), eVar);
        this.jvv.put(Integer.valueOf(1), eVar);
        this.jvv.put(Integer.valueOf(37), eVar);
        this.jvv.put(Integer.valueOf(40), eVar);
        this.jvv.put(Integer.valueOf(50), eVar);
        AppMethodBeat.o(17453);
    }
}
