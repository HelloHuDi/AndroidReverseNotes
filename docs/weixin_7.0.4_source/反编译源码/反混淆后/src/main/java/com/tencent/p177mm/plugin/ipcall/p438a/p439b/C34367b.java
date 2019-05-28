package com.tencent.p177mm.plugin.ipcall.p438a.p439b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C12244d.C12243a;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C12244d.C122451;
import com.tencent.p177mm.plugin.ipcall.p442ui.C21144j;
import com.tencent.p177mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.p177mm.plugin.voip.HeadsetPlugReceiver.C14032a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.ipcall.a.b.b */
public final class C34367b implements C1406a, C12243a, C14032a {
    public MMActivity crP;
    public C45293b gar = new C45293b(C4996ah.getContext());
    public HeadsetPlugReceiver kzs = new HeadsetPlugReceiver();
    public boolean kzt = false;
    public boolean kzu = false;
    public C39254a nxf = new C39254a();
    public C28327c nxg = new C28327c();
    public C12244d nxh = new C12244d();
    public C21144j nxi;
    private boolean nxj = false;
    public C34368a nxk;
    public long nxl = 0;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.b.b$a */
    public interface C34368a {
        /* renamed from: ir */
        void mo36472ir(boolean z);

        /* renamed from: is */
        void mo36473is(boolean z);
    }

    public C34367b() {
        AppMethodBeat.m2504i(21804);
        AppMethodBeat.m2505o(21804);
    }

    /* renamed from: a */
    public final void mo54895a(C21144j c21144j) {
        AppMethodBeat.m2504i(21805);
        this.nxi = c21144j;
        if (c21144j != null) {
            C21088i.bHv().bGT();
        }
        AppMethodBeat.m2505o(21805);
    }

    public final void bHI() {
        AppMethodBeat.m2504i(21806);
        this.nxh.nxu = this;
        C12244d c12244d = this.nxh;
        if (!c12244d.mfW.aGA) {
            c12244d.mfW.mo10258a(c12244d);
            if (c12244d.mfS.mo56732aj(new C122451())) {
                c12244d.mfT = 0;
                AppMethodBeat.m2505o(21806);
                return;
            }
            c12244d.mfT = -1;
        }
        AppMethodBeat.m2505o(21806);
    }

    /* renamed from: io */
    public final void mo54898io(boolean z) {
        AppMethodBeat.m2504i(21807);
        this.nxf.mo62156io(z);
        AppMethodBeat.m2505o(21807);
    }

    /* renamed from: iq */
    public final void mo24077iq(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(21808);
        C4990ab.m7417i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", Boolean.valueOf(z));
        if (this.crP != null) {
            MMActivity mMActivity = this.crP;
            if (z) {
                z2 = false;
            }
            mMActivity.setScreenEnable(z2);
        }
        if (C21088i.bHu().bHl()) {
            if (z) {
                this.nxj = C39254a.m66900KU();
                this.nxf.mo62156io(false);
                AppMethodBeat.m2505o(21808);
                return;
            }
            this.nxf.mo62156io(this.nxj);
        }
        AppMethodBeat.m2505o(21808);
    }

    /* renamed from: gE */
    public final void mo4815gE(int i) {
        AppMethodBeat.m2504i(21809);
        C4990ab.m7417i("MicroMsg.IPCallDeviceManager", "onAudioStatChange, status: %d", Integer.valueOf(i));
        switch (i) {
            case 1:
                this.kzu = true;
                if (!(this.nxk == null || this.kzt)) {
                    this.nxk.mo36473is(true);
                    AppMethodBeat.m2505o(21809);
                    return;
                }
            case 2:
            case 4:
                this.kzu = false;
                if (!(this.nxk == null || this.kzt)) {
                    this.nxk.mo36473is(false);
                    AppMethodBeat.m2505o(21809);
                    return;
                }
            case 3:
                C9638aw.m17191ZL().mo4817KM();
                if (C9638aw.m17191ZL().mo4819KP() && this.nxk != null) {
                    this.nxk.mo36472ir(true);
                    AppMethodBeat.m2505o(21809);
                    return;
                }
            case 5:
                C1407g.m2946KK().mo4817KM();
                break;
        }
        AppMethodBeat.m2505o(21809);
    }

    /* renamed from: fS */
    public final void mo9263fS(boolean z) {
        AppMethodBeat.m2504i(21810);
        C4990ab.m7417i("MicroMsg.IPCallDeviceManager", "onHeadsetState, on: %b", Boolean.valueOf(z));
        if (!(this.nxk == null || z == this.kzt)) {
            this.kzt = z;
            if (!this.kzu) {
                this.nxk.mo36472ir(z);
            }
        }
        AppMethodBeat.m2505o(21810);
    }

    public final int bHJ() {
        AppMethodBeat.m2504i(21811);
        C39254a c39254a = this.nxf;
        if (c39254a.kzq == null || !c39254a.cFy) {
            AppMethodBeat.m2505o(21811);
            return -1;
        }
        int cIt = c39254a.kzq.cIt();
        AppMethodBeat.m2505o(21811);
        return cIt;
    }
}
