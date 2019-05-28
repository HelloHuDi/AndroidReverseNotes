package com.tencent.p177mm.plugin.ipcall.p438a.p440c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.ipcall.a.c.b */
public final class C12250b {
    public String countryCode = "";
    public String gyD = "";
    public long nvh = 0;
    public int nwu = 0;
    public long nwv = 0;
    public int nwx = 0;
    public int nxE = 0;
    public int nxF = 0;
    public int nxG = 0;
    public int nxH = 0;
    public int nxI = 0;
    public long nxJ = 0;
    public long nxK = 0;
    public int nxL = 0;
    public long nxM = 0;
    public int nxN = 0;
    public long nxO = 0;
    public int nxP = 0;
    public String nxQ = "";
    public long nxR = 0;
    public long nxS = 0;
    public long nxT = 0;
    public long nxU = 0;
    public String nxV = "";
    public String nxW = "";
    public String nxX = "";
    public long nxY = 0;
    public long nxZ = 0;
    public long nya = 0;
    public int nyb = 0;
    public int nyc = 0;
    public int nyd = 0;
    public int nye = 0;

    public final void setCountryCode(String str) {
        AppMethodBeat.m2504i(21829);
        C4990ab.m7411d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", str);
        if (!C5046bo.isNullOrNil(str)) {
            this.countryCode = str;
        }
        AppMethodBeat.m2505o(21829);
    }

    /* renamed from: ep */
    public final void mo24086ep(int i, int i2) {
        AppMethodBeat.m2504i(21830);
        if (this.nwx == i) {
            C4990ab.m7411d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", Integer.valueOf(i2));
            this.nxP = i2;
        }
        AppMethodBeat.m2505o(21830);
    }

    public final void bHN() {
        AppMethodBeat.m2504i(21831);
        C4990ab.m7416i("MicroMsg.IPCallReportHelper", "selfShutdown");
        this.nxI = 1;
        AppMethodBeat.m2505o(21831);
    }

    public final void bHO() {
        AppMethodBeat.m2504i(21832);
        C4990ab.m7416i("MicroMsg.IPCallReportHelper", "selfCancel");
        this.nxH = 1;
        if (this.nya == 0 && this.nxR != 0) {
            this.nya = System.currentTimeMillis() - this.nxR;
            C4990ab.m7411d("MicroMsg.IPCallReportHelper", "cancelTime: %d", Long.valueOf(this.nya));
        }
        AppMethodBeat.m2505o(21832);
    }

    public final void bHP() {
        AppMethodBeat.m2504i(21833);
        C4990ab.m7416i("MicroMsg.IPCallReportHelper", "channelConnect");
        this.nxL = 1;
        AppMethodBeat.m2505o(21833);
    }

    public final void bHQ() {
        if (this.nyd == 0) {
            this.nyd = 1;
        }
    }

    public final void bHR() {
        AppMethodBeat.m2504i(21834);
        C4990ab.m7410d("MicroMsg.IPCallReportHelper", "markConnect");
        if (this.nxY == 0) {
            this.nxY = System.currentTimeMillis();
            this.nxZ = this.nxY - this.nxR;
            C4990ab.m7411d("MicroMsg.IPCallReportHelper", "connectTime: %d", Long.valueOf(this.nxZ));
        }
        AppMethodBeat.m2505o(21834);
    }

    public final void bHS() {
        AppMethodBeat.m2504i(21835);
        C4990ab.m7410d("MicroMsg.IPCallReportHelper", "markStartTalk");
        if (this.nxT == 0) {
            this.nxT = System.currentTimeMillis();
        }
        AppMethodBeat.m2505o(21835);
    }
}
