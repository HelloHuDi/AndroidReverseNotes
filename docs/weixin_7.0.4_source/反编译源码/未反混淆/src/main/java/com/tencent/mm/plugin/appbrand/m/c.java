package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static Set<String> ipR;

    static {
        AppMethodBeat.i(132327);
        HashSet hashSet = new HashSet();
        ipR = hashSet;
        hashSet.add(ag.ck("wx9a3998a6d8b89d42"));
        AppMethodBeat.o(132327);
    }

    public static boolean CU(String str) {
        AppMethodBeat.i(132326);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(132326);
            return true;
        }
        boolean contains = ipR.contains(ag.ck(str));
        AppMethodBeat.o(132326);
        return contains;
    }
}
