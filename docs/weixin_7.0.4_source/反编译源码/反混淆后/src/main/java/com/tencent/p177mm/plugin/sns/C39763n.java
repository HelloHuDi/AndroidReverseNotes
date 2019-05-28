package com.tencent.p177mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9465sc;
import com.tencent.p177mm.plugin.sns.p1558j.C39739a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.n */
public final class C39763n extends C4884c<C9465sc> {
    public C39763n() {
        AppMethodBeat.m2504i(35635);
        this.xxI = C9465sc.class.getName().hashCode();
        AppMethodBeat.m2505o(35635);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(35636);
        C9465sc c9465sc = (C9465sc) c4883b;
        if (c9465sc instanceof C9465sc) {
            c9465sc.cOa.cvi = C39739a.m67964b(c9465sc.cNZ.cOd, c9465sc.cNZ.url, c9465sc.cNZ.cOc);
            AppMethodBeat.m2505o(35636);
            return true;
        }
        C4990ab.m7414f("MicroMsg.SnsfillEventInfoListener", "mismatched event");
        AppMethodBeat.m2505o(35636);
        return false;
    }
}
