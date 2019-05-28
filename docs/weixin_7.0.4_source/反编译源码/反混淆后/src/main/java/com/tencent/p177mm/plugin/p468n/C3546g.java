package com.tencent.p177mm.plugin.p468n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.n.g */
public final class C3546g {
    public long aOw = 0;
    public long cTh = 0;
    private boolean eif;
    public boolean llI = true;
    public boolean llJ = false;
    public long orA = 0;
    public long orB = 0;
    public long orC = 10;
    public boolean orD = true;
    public boolean orE = false;
    boolean orF = false;
    boolean orG = false;
    public long orx = 0;
    public long ory = -1;
    public long orz = 0;

    public C3546g(boolean z) {
        this.eif = z;
    }

    public final String aZm() {
        AppMethodBeat.m2504i(117871);
        String str = hashCode();
        AppMethodBeat.m2505o(117871);
        return str;
    }

    /* renamed from: RH */
    public final void mo8069RH(String str) {
        AppMethodBeat.m2504i(117872);
        if (this.orD) {
            C7060h.pYm.mo8378a(354, 152, 1, false);
            C7060h.pYm.mo8381e(13836, Integer.valueOf(500), Long.valueOf(C5046bo.anT()), str);
            AppMethodBeat.m2505o(117872);
            return;
        }
        AppMethodBeat.m2505o(117872);
    }

    /* renamed from: RI */
    public final void mo8070RI(String str) {
        AppMethodBeat.m2504i(117873);
        if (this.orD) {
            C7060h.pYm.mo8378a(354, 153, 1, false);
            C7060h.pYm.mo8381e(13836, Integer.valueOf(501), Long.valueOf(C5046bo.anT()), str);
            AppMethodBeat.m2505o(117873);
            return;
        }
        AppMethodBeat.m2505o(117873);
    }

    public final void bOW() {
        AppMethodBeat.m2504i(117874);
        if (this.orD) {
            C7060h.pYm.mo8378a(354, 155, 1, false);
            C7060h.pYm.mo8381e(13836, Integer.valueOf(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS), Long.valueOf(C5046bo.anT()), "");
            AppMethodBeat.m2505o(117874);
            return;
        }
        AppMethodBeat.m2505o(117874);
    }
}
