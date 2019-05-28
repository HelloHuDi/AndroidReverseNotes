package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class b implements com.tencent.mm.compatible.b.g.a, com.tencent.mm.plugin.ipcall.a.b.d.a, com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a {
    public MMActivity crP;
    public com.tencent.mm.compatible.util.b gar = new com.tencent.mm.compatible.util.b(ah.getContext());
    public HeadsetPlugReceiver kzs = new HeadsetPlugReceiver();
    public boolean kzt = false;
    public boolean kzu = false;
    public a nxf = new a();
    public c nxg = new c();
    public d nxh = new d();
    public j nxi;
    private boolean nxj = false;
    public a nxk;
    public long nxl = 0;

    public interface a {
        void ir(boolean z);

        void is(boolean z);
    }

    public b() {
        AppMethodBeat.i(21804);
        AppMethodBeat.o(21804);
    }

    public final void a(j jVar) {
        AppMethodBeat.i(21805);
        this.nxi = jVar;
        if (jVar != null) {
            i.bHv().bGT();
        }
        AppMethodBeat.o(21805);
    }

    public final void bHI() {
        AppMethodBeat.i(21806);
        this.nxh.nxu = this;
        d dVar = this.nxh;
        if (!dVar.mfW.aGA) {
            dVar.mfW.a(dVar);
            if (dVar.mfS.aj(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21818);
                    d.this.mfT = bo.yz();
                    AppMethodBeat.o(21818);
                }
            })) {
                dVar.mfT = 0;
                AppMethodBeat.o(21806);
                return;
            }
            dVar.mfT = -1;
        }
        AppMethodBeat.o(21806);
    }

    public final void io(boolean z) {
        AppMethodBeat.i(21807);
        this.nxf.io(z);
        AppMethodBeat.o(21807);
    }

    public final void iq(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(21808);
        ab.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", Boolean.valueOf(z));
        if (this.crP != null) {
            MMActivity mMActivity = this.crP;
            if (z) {
                z2 = false;
            }
            mMActivity.setScreenEnable(z2);
        }
        if (i.bHu().bHl()) {
            if (z) {
                this.nxj = a.KU();
                this.nxf.io(false);
                AppMethodBeat.o(21808);
                return;
            }
            this.nxf.io(this.nxj);
        }
        AppMethodBeat.o(21808);
    }

    public final void gE(int i) {
        AppMethodBeat.i(21809);
        ab.i("MicroMsg.IPCallDeviceManager", "onAudioStatChange, status: %d", Integer.valueOf(i));
        switch (i) {
            case 1:
                this.kzu = true;
                if (!(this.nxk == null || this.kzt)) {
                    this.nxk.is(true);
                    AppMethodBeat.o(21809);
                    return;
                }
            case 2:
            case 4:
                this.kzu = false;
                if (!(this.nxk == null || this.kzt)) {
                    this.nxk.is(false);
                    AppMethodBeat.o(21809);
                    return;
                }
            case 3:
                aw.ZL().KM();
                if (aw.ZL().KP() && this.nxk != null) {
                    this.nxk.ir(true);
                    AppMethodBeat.o(21809);
                    return;
                }
            case 5:
                g.KK().KM();
                break;
        }
        AppMethodBeat.o(21809);
    }

    public final void fS(boolean z) {
        AppMethodBeat.i(21810);
        ab.i("MicroMsg.IPCallDeviceManager", "onHeadsetState, on: %b", Boolean.valueOf(z));
        if (!(this.nxk == null || z == this.kzt)) {
            this.kzt = z;
            if (!this.kzu) {
                this.nxk.ir(z);
            }
        }
        AppMethodBeat.o(21810);
    }

    public final int bHJ() {
        AppMethodBeat.i(21811);
        a aVar = this.nxf;
        if (aVar.kzq == null || !aVar.cFy) {
            AppMethodBeat.o(21811);
            return -1;
        }
        int cIt = aVar.kzq.cIt();
        AppMethodBeat.o(21811);
        return cIt;
    }
}
