package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class n implements f {
    public String gCk = null;
    public String hjp = null;
    public String igi = null;
    private String sLs = null;
    public int sLt = -1;
    public a sLv = null;

    public interface a {
        void abU(String str);

        void cHM();

        void cHO();

        void mh(boolean z);
    }

    public n() {
        AppMethodBeat.i(26114);
        aw.Rg().a((int) bb.CTRL_INDEX, (f) this);
        aw.Rg().a((int) bd.CTRL_INDEX, (f) this);
        aw.Rg().a((int) be.CTRL_INDEX, (f) this);
        AppMethodBeat.o(26114);
    }

    public final void cHN() {
        AppMethodBeat.i(26115);
        aw.Rg().a(new g(this.hjp), 0);
        AppMethodBeat.o(26115);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(26116);
        ab.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 || i2 == 0) {
            if (mVar.getType() == bb.CTRL_INDEX) {
                this.hjp = ((e) mVar).elr;
                ab.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", Boolean.valueOf(bo.isNullOrNil(this.hjp)));
                if (!bo.isNullOrNil(this.hjp)) {
                    cHN();
                }
            }
            if (mVar.getType() == bd.CTRL_INDEX) {
                g gVar = (g) mVar;
                this.sLt = gVar.sKX;
                this.sLs = gVar.sKW;
                ab.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", Integer.valueOf(this.sLt), Boolean.valueOf(bo.isNullOrNil(this.sLs)));
                if (this.sLv != null) {
                    this.sLv.abU(this.sLs);
                }
            }
            if (mVar.getType() == be.CTRL_INDEX) {
                h hVar = (h) mVar;
                if (hVar.Kt == 0) {
                    ab.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
                    this.gCk = hVar.gCk;
                    if (this.sLv != null) {
                        this.sLv.mh(true);
                        AppMethodBeat.o(26116);
                        return;
                    }
                }
                ab.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
                if (this.sLv != null) {
                    this.sLv.mh(false);
                }
            }
            AppMethodBeat.o(26116);
        } else if (i2 == -34 && mVar.getType() == be.CTRL_INDEX) {
            ab.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
            if (this.sLv != null) {
                this.sLv.cHO();
            }
            AppMethodBeat.o(26116);
        } else {
            if (this.sLv != null) {
                this.sLv.cHM();
            }
            AppMethodBeat.o(26116);
        }
    }
}
