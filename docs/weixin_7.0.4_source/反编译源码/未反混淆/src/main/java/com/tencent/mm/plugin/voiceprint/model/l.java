package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l implements f {
    public int sLf;
    public int sLr;
    private String sLs;
    public int sLt;
    public a sLu;

    public interface a {
        void E(boolean z, int i);

        void abS(String str);

        void abT(String str);

        void cHM();
    }

    public l() {
        AppMethodBeat.i(26111);
        this.sLr = 71;
        this.sLs = null;
        this.sLt = 0;
        this.sLf = 0;
        this.sLu = null;
        aw.Rg().a(611, (f) this);
        aw.Rg().a(612, (f) this);
        AppMethodBeat.o(26111);
    }

    public l(a aVar) {
        this();
        this.sLu = aVar;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(26112);
        ab.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 || i2 == 0) {
            if (mVar.getType() == 611) {
                d dVar = (d) mVar;
                this.sLt = dVar.sKX;
                this.sLs = dVar.sKW;
                ab.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", Integer.valueOf(this.sLt), Boolean.valueOf(bo.isNullOrNil(this.sLs)));
                if (this.sLu != null) {
                    if (this.sLr == 71) {
                        this.sLu.abS(this.sLs);
                    } else if (this.sLr == 72) {
                        this.sLu.abT(this.sLs);
                    }
                }
            }
            if (mVar.getType() == 612) {
                f fVar = (f) mVar;
                int i3 = ((fVar.sLh == 72 && fVar.Kt == 0) || fVar.sLh == 71) ? 1 : 0;
                if (i3 != 0) {
                    ab.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", Integer.valueOf(fVar.sLh));
                    this.sLf = fVar.sLf;
                    if (this.sLu != null) {
                        this.sLu.E(true, fVar.sLh);
                    }
                } else {
                    ab.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", Integer.valueOf(fVar.sLh));
                    if (this.sLu != null) {
                        this.sLu.E(false, fVar.sLh);
                    }
                }
                if (!(i3 == 0 || fVar.sLh != 71 || this.sLu == null)) {
                    this.sLu.abT(this.sLs);
                }
            }
            AppMethodBeat.o(26112);
            return;
        }
        if (this.sLu != null) {
            this.sLu.cHM();
        }
        AppMethodBeat.o(26112);
    }
}
