package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c extends q implements b {
    private static c jqC;

    private c() {
        super(o.class);
    }

    public static synchronized c aSm() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(79053);
            if (jqC == null) {
                jqC = new c();
            }
            cVar = jqC;
            AppMethodBeat.o(79053);
        }
        return cVar;
    }

    public final List<String> collectStoragePaths() {
        AppMethodBeat.i(79054);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"avatar/"});
        AppMethodBeat.o(79054);
        return linkedList;
    }

    public static String aSn() {
        AppMethodBeat.i(79055);
        String str = g.RP().cachePath + "avatar/";
        AppMethodBeat.o(79055);
        return str;
    }
}
