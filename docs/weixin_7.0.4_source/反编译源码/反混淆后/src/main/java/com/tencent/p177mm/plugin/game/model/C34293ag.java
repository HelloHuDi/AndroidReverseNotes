package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.game.p731d.C12120df;

/* renamed from: com.tencent.mm.plugin.game.model.ag */
public final class C34293ag extends C39216x {
    public C12120df mYl;

    public C34293ag(C1331a c1331a) {
        AppMethodBeat.m2504i(111389);
        if (c1331a == null) {
            this.mYl = new C12120df();
            AppMethodBeat.m2505o(111389);
            return;
        }
        this.mYl = (C12120df) c1331a;
        AppMethodBeat.m2505o(111389);
    }
}
