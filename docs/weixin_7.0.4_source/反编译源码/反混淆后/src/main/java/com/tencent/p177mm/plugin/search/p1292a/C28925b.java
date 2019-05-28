package com.tencent.p177mm.plugin.search.p1292a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.search.p741b.p742a.p743a.C34845a;
import com.tencent.p177mm.plugin.search.p741b.p742a.p743a.C7073b;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.search.a.b */
public final class C28925b implements C1816at {
    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(24404);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterItemClickHandler(3);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterItemClickHandler(6);
        AppMethodBeat.m2505o(24404);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(24403);
        ((C12029n) C1720g.m3530M(C12029n.class)).registerItemClickHandler(3, new C34845a());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerItemClickHandler(6, new C7073b());
        AppMethodBeat.m2505o(24403);
    }
}
