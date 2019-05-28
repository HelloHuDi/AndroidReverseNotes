package com.tencent.mm.plugin.wepkg.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private Map<String, b> uXQ;

    public class b {
        long fVz;
        int uXS;
    }

    public static class a {
        private static a uXR = new a();

        static {
            AppMethodBeat.i(63606);
            AppMethodBeat.o(63606);
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        AppMethodBeat.i(63607);
        this.uXQ = new ConcurrentHashMap();
        AppMethodBeat.o(63607);
    }

    public final void l(Set<String> set) {
        AppMethodBeat.i(63608);
        if (set.isEmpty()) {
            h.pYm.a(859, 20, 1, false);
            AppMethodBeat.o(63608);
            return;
        }
        h.pYm.a(859, 21, 1, false);
        b bVar = new b();
        bVar.uXS = set.size();
        bVar.fVz = 0;
        for (String put : set) {
            this.uXQ.put(put, bVar);
        }
        AppMethodBeat.o(63608);
    }

    public final void n(String str, String str2, long j) {
        AppMethodBeat.i(63609);
        b bVar = (b) this.uXQ.remove(ag.ck(str + str2));
        if (bVar != null) {
            bVar.uXS--;
            bVar.fVz += j;
            if (bVar.uXS == 0) {
                ab.i("MicroMsg.Wepkg.BatchUpdateReporter", "batch update size: %s", Long.valueOf(bVar.fVz));
                c.eBG.g(1, "", String.valueOf(bVar.fVz));
            }
        }
        AppMethodBeat.o(63609);
    }
}
