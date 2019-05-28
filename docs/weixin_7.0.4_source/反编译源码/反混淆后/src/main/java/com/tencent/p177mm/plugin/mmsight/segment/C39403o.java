package com.tencent.p177mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p838bj.C17987e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.o */
public final class C39403o {
    /* renamed from: k */
    public static C3493d m67249k(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(3688);
        C4990ab.m7417i("MicroMsg.ThumbFetcherFactory", "get thumb fetcher, ish265: %s", Boolean.valueOf(C17987e.m28307uD(str)));
        C12581k c12581k = new C12581k();
        c12581k.init(str, i, i2, i3);
        AppMethodBeat.m2505o(3688);
        return c12581k;
    }
}
