package com.tencent.p177mm.p612ui.chatting.p616c.p1364c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.C44291a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40722a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.chatting.c.c.b */
public final class C41345b extends C44291a implements C40722a {
    private C40728a yTs;

    public C41345b(C40728a c40728a) {
        this.yTs = c40728a;
    }

    /* renamed from: a */
    public final void mo10944a(C46650a c46650a) {
        AppMethodBeat.m2504i(31898);
        super.mo10944a(c46650a);
        if (this.yTs != null) {
            this.yTs.mo10944a(c46650a);
        }
        AppMethodBeat.m2505o(31898);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31899);
        super.dDh();
        if (this.yTs != null) {
            this.yTs.dDh();
        }
        AppMethodBeat.m2505o(31899);
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31900);
        if (dFs()) {
            this.yTs.dxx();
        }
        AppMethodBeat.m2505o(31900);
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31901);
        if (dFs()) {
            this.yTs.dxy();
        }
        AppMethodBeat.m2505o(31901);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31902);
        if (dFs()) {
            this.yTs.dxz();
        }
        AppMethodBeat.m2505o(31902);
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31903);
        if (dFs()) {
            this.yTs.dxA();
        }
        AppMethodBeat.m2505o(31903);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31904);
        if (dFs()) {
            this.yTs.dxB();
        }
        AppMethodBeat.m2505o(31904);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31905);
        if (dFs()) {
            this.yTs.dxC();
        }
        AppMethodBeat.m2505o(31905);
    }

    public final void dxD() {
        AppMethodBeat.m2504i(31906);
        if (dFs()) {
            this.yTs.dxD();
        }
        AppMethodBeat.m2505o(31906);
    }

    public final void dEm() {
        AppMethodBeat.m2504i(31907);
        if (dFs()) {
            this.yTs.dEm();
        }
        AppMethodBeat.m2505o(31907);
    }

    public final void dFq() {
        AppMethodBeat.m2504i(31908);
        if (dFs()) {
            this.yTs.dFq();
        }
        AppMethodBeat.m2505o(31908);
    }

    public final String dFr() {
        AppMethodBeat.m2504i(31909);
        if (dFs()) {
            String dFr = this.yTs.dFr();
            AppMethodBeat.m2505o(31909);
            return dFr;
        }
        AppMethodBeat.m2505o(31909);
        return null;
    }

    private boolean dFs() {
        AppMethodBeat.m2504i(31910);
        if (C5046bo.isNullOrNil(this.cgL.getTalkerUserName())) {
            AppMethodBeat.m2505o(31910);
            return false;
        } else if (C1855t.m3922nH(this.cgL.getTalkerUserName())) {
            AppMethodBeat.m2505o(31910);
            return false;
        } else if (this.yTs != null) {
            AppMethodBeat.m2505o(31910);
            return true;
        } else {
            AppMethodBeat.m2505o(31910);
            return false;
        }
    }
}
