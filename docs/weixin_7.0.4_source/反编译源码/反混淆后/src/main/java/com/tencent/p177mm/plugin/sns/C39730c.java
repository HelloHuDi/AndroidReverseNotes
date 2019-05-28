package com.tencent.p177mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C26136fo;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.p1024b.C39728h.C39729a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.c */
public final class C39730c extends C4884c<C26136fo> {
    public C39730c() {
        AppMethodBeat.m2504i(35600);
        this.xxI = C26136fo.class.getName().hashCode();
        AppMethodBeat.m2505o(35600);
    }

    /* renamed from: a */
    private boolean m67940a(final C26136fo c26136fo) {
        AppMethodBeat.m2504i(35601);
        if (c26136fo instanceof C26136fo) {
            C3890a cnv = C13373af.cnv();
            cnv.mo8617a(c26136fo.czp.type, c26136fo.czp.username, new C39729a() {
                /* renamed from: a */
                public final void mo17657a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j, String str2) {
                    AppMethodBeat.m2504i(35599);
                    if (c26136fo.czp != null) {
                        c26136fo.czp.czt.mo4918a(null);
                    }
                    AppMethodBeat.m2505o(35599);
                }

                /* renamed from: a */
                public final void mo17656a(boolean z, String str, boolean z2, boolean z3, int i, long j, String str2) {
                }
            });
            cnv.mo8618a(1, c26136fo.czp.username, c26136fo.czp.czr, c26136fo.czp.czs);
            AppMethodBeat.m2505o(35601);
            return true;
        }
        C4990ab.m7414f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
        AppMethodBeat.m2505o(35601);
        return false;
    }
}
