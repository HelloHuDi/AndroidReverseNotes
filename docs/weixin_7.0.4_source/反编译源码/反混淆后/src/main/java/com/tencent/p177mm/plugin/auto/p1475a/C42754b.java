package com.tencent.p177mm.plugin.auto.p1475a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.auto.a.b */
public final class C42754b implements C1816at {
    private C42753a jqB = new C42753a();

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    public C42754b() {
        AppMethodBeat.m2504i(17106);
        AppMethodBeat.m2505o(17106);
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(17107);
        C4990ab.m7416i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
        C4879a.xxA.mo10052c(this.jqB.jqz);
        AppMethodBeat.m2505o(17107);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(17108);
        C4990ab.m7416i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
        C4879a.xxA.mo10053d(this.jqB.jqz);
        AppMethodBeat.m2505o(17108);
    }
}
