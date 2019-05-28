package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.sdk.platformtools.aj */
public final class C4997aj {
    private static Set<String> xzg = new HashSet();

    static {
        AppMethodBeat.m2504i(52065);
        AppMethodBeat.m2505o(52065);
    }

    public static boolean amA(String str) {
        AppMethodBeat.m2504i(52062);
        if (C4997aj.amC(str)) {
            C4990ab.m7410d("MicroMsg.MMEntryLock", "locked-".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(52062);
            return false;
        }
        C4990ab.m7410d("MicroMsg.MMEntryLock", "lock-".concat(String.valueOf(str)));
        boolean add = xzg.add(str);
        AppMethodBeat.m2505o(52062);
        return add;
    }

    public static void amB(String str) {
        AppMethodBeat.m2504i(52063);
        xzg.remove(str);
        C4990ab.m7410d("MicroMsg.MMEntryLock", "unlock-".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(52063);
    }

    public static boolean amC(String str) {
        AppMethodBeat.m2504i(52064);
        boolean contains = xzg.contains(str);
        AppMethodBeat.m2505o(52064);
        return contains;
    }
}
