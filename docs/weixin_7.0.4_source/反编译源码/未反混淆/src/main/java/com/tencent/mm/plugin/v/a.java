package com.tencent.mm.plugin.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.g;
import java.util.List;

public final class a implements b, c {
    private static a pLk;

    private a() {
    }

    public final List<String> collectStoragePaths() {
        return null;
    }

    public static synchronized a ceU() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(136942);
            if (pLk == null) {
                pLk = new a();
            }
            aVar = pLk;
            AppMethodBeat.o(136942);
        }
        return aVar;
    }

    public static String ceV() {
        AppMethodBeat.i(136943);
        String str = g.RP().eJM + "remark/";
        AppMethodBeat.o(136943);
        return str;
    }
}
