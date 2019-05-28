package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class aj {
    private static Set<String> xzg = new HashSet();

    static {
        AppMethodBeat.i(52065);
        AppMethodBeat.o(52065);
    }

    public static boolean amA(String str) {
        AppMethodBeat.i(52062);
        if (amC(str)) {
            ab.d("MicroMsg.MMEntryLock", "locked-".concat(String.valueOf(str)));
            AppMethodBeat.o(52062);
            return false;
        }
        ab.d("MicroMsg.MMEntryLock", "lock-".concat(String.valueOf(str)));
        boolean add = xzg.add(str);
        AppMethodBeat.o(52062);
        return add;
    }

    public static void amB(String str) {
        AppMethodBeat.i(52063);
        xzg.remove(str);
        ab.d("MicroMsg.MMEntryLock", "unlock-".concat(String.valueOf(str)));
        AppMethodBeat.o(52063);
    }

    public static boolean amC(String str) {
        AppMethodBeat.i(52064);
        boolean contains = xzg.contains(str);
        AppMethodBeat.o(52064);
        return contains;
    }
}
