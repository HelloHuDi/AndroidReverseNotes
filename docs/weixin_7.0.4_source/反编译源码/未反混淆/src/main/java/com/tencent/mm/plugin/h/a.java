package com.tencent.mm.plugin.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.r;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a extends q implements b {
    private static a kJF;

    private a() {
        super(r.class);
    }

    public static synchronized a bic() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(79089);
            if (kJF == null) {
                kJF = new a();
            }
            aVar = kJF;
            AppMethodBeat.o(79089);
        }
        return aVar;
    }

    public final List<String> collectStoragePaths() {
        AppMethodBeat.i(79090);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"package/"});
        AppMethodBeat.o(79090);
        return linkedList;
    }

    public static String Yd() {
        AppMethodBeat.i(79091);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("package/").toString();
        AppMethodBeat.o(79091);
        return stringBuilder2;
    }
}
