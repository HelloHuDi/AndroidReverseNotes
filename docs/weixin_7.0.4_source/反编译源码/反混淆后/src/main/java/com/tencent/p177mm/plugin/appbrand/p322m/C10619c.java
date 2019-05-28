package com.tencent.p177mm.plugin.appbrand.p322m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.m.c */
public final class C10619c {
    private static Set<String> ipR;

    static {
        AppMethodBeat.m2504i(132327);
        HashSet hashSet = new HashSet();
        ipR = hashSet;
        hashSet.add(C4995ag.m7428ck("wx9a3998a6d8b89d42"));
        AppMethodBeat.m2505o(132327);
    }

    /* renamed from: CU */
    public static boolean m18306CU(String str) {
        AppMethodBeat.m2504i(132326);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(132326);
            return true;
        }
        boolean contains = ipR.contains(C4995ag.m7428ck(str));
        AppMethodBeat.m2505o(132326);
        return contains;
    }
}
