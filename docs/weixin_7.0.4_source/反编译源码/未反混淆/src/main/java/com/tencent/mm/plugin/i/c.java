package com.tencent.mm.plugin.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c implements b, com.tencent.mm.kernel.b.c {
    private static c nuF;

    private c() {
    }

    public static synchronized c bGE() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(79097);
            if (nuF == null) {
                nuF = new c();
            }
            cVar = nuF;
            AppMethodBeat.o(79097);
        }
        return cVar;
    }

    public final List<String> collectStoragePaths() {
        AppMethodBeat.i(79098);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"image/", "image2/", "sfs", "bizimg/"});
        AppMethodBeat.o(79098);
        return linkedList;
    }

    public static String XW() {
        AppMethodBeat.i(79099);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("image/").toString();
        AppMethodBeat.o(79099);
        return stringBuilder2;
    }

    public static String XX() {
        AppMethodBeat.i(79100);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("image2/").toString();
        AppMethodBeat.o(79100);
        return stringBuilder2;
    }

    public static String bGF() {
        AppMethodBeat.i(79101);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("bizimg/").toString();
        AppMethodBeat.o(79101);
        return stringBuilder2;
    }
}
