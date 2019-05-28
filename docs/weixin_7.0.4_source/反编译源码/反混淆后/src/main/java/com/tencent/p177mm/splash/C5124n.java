package com.tencent.p177mm.splash;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.splash.n */
public final class C5124n {
    public final ArrayList<long[]> eaV = new ArrayList();
    long mStartTimestamp = 0;
    public final ArrayList<String> xHG = new ArrayList();

    public C5124n() {
        AppMethodBeat.m2504i(114896);
        AppMethodBeat.m2505o(114896);
    }

    /* renamed from: m */
    public final void mo10503m(long j, long j2, long j3) {
        AppMethodBeat.m2504i(114897);
        this.eaV.add(new long[]{j, j2, j3});
        AppMethodBeat.m2505o(114897);
    }
}
