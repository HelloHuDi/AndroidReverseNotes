package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.a;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class e extends q implements b {
    private static e kRr;

    private e() {
        super(a.class);
    }

    public static synchronized e bjc() {
        e eVar;
        synchronized (e.class) {
            AppMethodBeat.i(62315);
            if (kRr == null) {
                kRr = new e();
            }
            eVar = kRr;
            AppMethodBeat.o(62315);
        }
        return eVar;
    }

    public final List<String> collectStoragePaths() {
        AppMethodBeat.i(62316);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"emoji/"});
        AppMethodBeat.o(62316);
        return linkedList;
    }

    public static String bjd() {
        AppMethodBeat.i(62317);
        String str = g.RP().eJM + "emoji/";
        AppMethodBeat.o(62317);
        return str;
    }
}
