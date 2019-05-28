package com.tencent.p177mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9428oe;
import com.tencent.p177mm.plugin.sns.model.C39747ab;
import com.tencent.p177mm.plugin.sns.model.C39747ab.C39748a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.k */
public final class C39740k extends C4884c<C9428oe> {
    public C39740k() {
        AppMethodBeat.m2504i(35626);
        this.xxI = C9428oe.class.getName().hashCode();
        AppMethodBeat.m2505o(35626);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(35627);
        C9428oe c9428oe = (C9428oe) c4883b;
        if (c9428oe instanceof C9428oe) {
            if (c9428oe.cKx.state == 0) {
                C4990ab.m7410d("MicroMsg.RemoveSnsTaskEventListener", "start clean");
                C39747ab.nLD = true;
                C39747ab c39747ab = new C39747ab();
                c39747ab.qKk = System.currentTimeMillis();
                if (!c39747ab.qKj) {
                    new C39748a().mo38881u("");
                }
            } else {
                C4990ab.m7410d("MicroMsg.RemoveSnsTaskEventListener", "stop clean");
                C39747ab.nLD = false;
            }
            AppMethodBeat.m2505o(35627);
            return true;
        }
        C4990ab.m7414f("MicroMsg.RemoveSnsTaskEventListener", "mismatched event");
        AppMethodBeat.m2505o(35627);
        return false;
    }
}
