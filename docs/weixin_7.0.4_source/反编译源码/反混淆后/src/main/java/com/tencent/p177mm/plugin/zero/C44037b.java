package com.tencent.p177mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.model.C18620by;
import com.tencent.p177mm.model.C18620by.C18621a;
import com.tencent.p177mm.modelmulti.C26460o;
import com.tencent.p177mm.plugin.zero.p757b.C35779b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.zero.b */
public final class C44037b implements C9562c, C35779b {
    private C18620by uZV;
    private C26460o xZZ;

    /* renamed from: com.tencent.mm.plugin.zero.b$1 */
    class C232291 implements C18621a {
        C232291() {
        }

        public final boolean aaC() {
            AppMethodBeat.m2504i(58742);
            if (C44037b.this.ahW().fJj == null) {
                AppMethodBeat.m2505o(58742);
                return true;
            }
            AppMethodBeat.m2505o(58742);
            return false;
        }
    }

    public final C26460o ahW() {
        AppMethodBeat.m2504i(58743);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        if (this.xZZ == null) {
            this.xZZ = new C26460o();
        }
        C26460o c26460o = this.xZZ;
        AppMethodBeat.m2505o(58743);
        return c26460o;
    }

    public final C18620by dgK() {
        AppMethodBeat.m2504i(58744);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        if (this.uZV == null) {
            this.uZV = new C18620by(new C232291());
        }
        C18620by c18620by = this.uZV;
        AppMethodBeat.m2505o(58744);
        return c18620by;
    }

    public final void onAccountInitialized(C1705c c1705c) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(58745);
        if (this.xZZ != null) {
            C26460o c26460o = this.xZZ;
            C4990ab.m7417i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", Integer.valueOf(c26460o.fJg.size()), Integer.valueOf(c26460o.fJh.size()), c26460o.fJj);
            c26460o.fJg.clear();
            c26460o.fJh.clear();
        }
        if (this.uZV != null) {
            this.uZV.aax();
        }
        AppMethodBeat.m2505o(58745);
    }
}
