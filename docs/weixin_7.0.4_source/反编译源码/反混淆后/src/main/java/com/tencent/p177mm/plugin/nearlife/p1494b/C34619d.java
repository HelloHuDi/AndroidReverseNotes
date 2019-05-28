package com.tencent.p177mm.plugin.nearlife.p1494b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.story.api.C22173a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.nearlife.b.d */
public final class C34619d implements C1816at {

    /* renamed from: com.tencent.mm.plugin.nearlife.b.d$1 */
    class C346181 implements C22173a {
        C346181() {
        }
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(22935);
        C4990ab.m7416i("MicroMsg.SubCoreNearLife", "onAccountPostReset SubCoreNearLife");
        C1720g.m3542a(C22173a.class, new C346181());
        AppMethodBeat.m2505o(22935);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
