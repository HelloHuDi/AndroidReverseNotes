package com.tencent.p177mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C45313by;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;

/* renamed from: com.tencent.mm.console.a */
public final class C45300a extends C4884c<C45313by> {
    public C45300a() {
        AppMethodBeat.m2504i(16070);
        this.xxI = C45313by.class.getName().hashCode();
        AppMethodBeat.m2505o(16070);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(16071);
        C45313by c45313by = (C45313by) c4883b;
        c45313by.cvg.cvi = C1457b.m3088i(c45313by.cvf.context, c45313by.cvf.cvh, c45313by.cvf.username);
        AppMethodBeat.m2505o(16071);
        return false;
    }
}
