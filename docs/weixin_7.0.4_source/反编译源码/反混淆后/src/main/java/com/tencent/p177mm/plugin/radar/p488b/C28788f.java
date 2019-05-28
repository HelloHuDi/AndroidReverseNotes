package com.tencent.p177mm.plugin.radar.p488b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.radar.p488b.C39550e.C39551f;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13})
/* renamed from: com.tencent.mm.plugin.radar.b.f */
public final /* synthetic */ class C28788f {
    public static final /* synthetic */ int[] eQZ;

    static {
        AppMethodBeat.m2504i(102917);
        int[] iArr = new int[C39551f.values().length];
        eQZ = iArr;
        iArr[C39551f.Stopped.ordinal()] = 1;
        eQZ[C39551f.Locating.ordinal()] = 2;
        eQZ[C39551f.RadarSearching.ordinal()] = 3;
        eQZ[C39551f.Waiting.ordinal()] = 4;
        AppMethodBeat.m2505o(102917);
    }
}
