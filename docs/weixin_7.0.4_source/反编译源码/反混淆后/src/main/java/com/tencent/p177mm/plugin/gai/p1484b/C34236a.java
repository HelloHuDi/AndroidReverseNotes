package com.tencent.p177mm.plugin.gai.p1484b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.gai.b.a */
public final class C34236a implements C1816at {
    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(21214);
        C4990ab.m7416i("MicroMsg.SubCoreGai", "SubCoreGai onAccountPostReset!");
        AppMethodBeat.m2505o(21214);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(21215);
        C4990ab.m7416i("MicroMsg.SubCoreGai", "SubCoreGai onAccountRelease!");
        AppMethodBeat.m2505o(21215);
    }
}
