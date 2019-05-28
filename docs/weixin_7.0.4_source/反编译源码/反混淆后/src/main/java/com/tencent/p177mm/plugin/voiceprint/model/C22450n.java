package com.tencent.p177mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38271be;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45579bb;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45580bd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.n */
public final class C22450n implements C1202f {
    public String gCk = null;
    public String hjp = null;
    public String igi = null;
    private String sLs = null;
    public int sLt = -1;
    public C14016a sLv = null;

    /* renamed from: com.tencent.mm.plugin.voiceprint.model.n$a */
    public interface C14016a {
        void abU(String str);

        void cHM();

        void cHO();

        /* renamed from: mh */
        void mo26249mh(boolean z);
    }

    public C22450n() {
        AppMethodBeat.m2504i(26114);
        C9638aw.m17182Rg().mo14539a((int) C45579bb.CTRL_INDEX, (C1202f) this);
        C9638aw.m17182Rg().mo14539a((int) C45580bd.CTRL_INDEX, (C1202f) this);
        C9638aw.m17182Rg().mo14539a((int) C38271be.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(26114);
    }

    public final void cHN() {
        AppMethodBeat.m2504i(26115);
        C9638aw.m17182Rg().mo14541a(new C46316g(this.hjp), 0);
        AppMethodBeat.m2505o(26115);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26116);
        C4990ab.m7411d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 || i2 == 0) {
            if (c1207m.getType() == C45579bb.CTRL_INDEX) {
                this.hjp = ((C35343e) c1207m).elr;
                C4990ab.m7411d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", Boolean.valueOf(C5046bo.isNullOrNil(this.hjp)));
                if (!C5046bo.isNullOrNil(this.hjp)) {
                    cHN();
                }
            }
            if (c1207m.getType() == C45580bd.CTRL_INDEX) {
                C46316g c46316g = (C46316g) c1207m;
                this.sLt = c46316g.sKX;
                this.sLs = c46316g.sKW;
                C4990ab.m7411d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", Integer.valueOf(this.sLt), Boolean.valueOf(C5046bo.isNullOrNil(this.sLs)));
                if (this.sLv != null) {
                    this.sLv.abU(this.sLs);
                }
            }
            if (c1207m.getType() == C38271be.CTRL_INDEX) {
                C43717h c43717h = (C43717h) c1207m;
                if (c43717h.f17222Kt == 0) {
                    C4990ab.m7410d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
                    this.gCk = c43717h.gCk;
                    if (this.sLv != null) {
                        this.sLv.mo26249mh(true);
                        AppMethodBeat.m2505o(26116);
                        return;
                    }
                }
                C4990ab.m7410d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
                if (this.sLv != null) {
                    this.sLv.mo26249mh(false);
                }
            }
            AppMethodBeat.m2505o(26116);
        } else if (i2 == -34 && c1207m.getType() == C38271be.CTRL_INDEX) {
            C4990ab.m7410d("MicroMsg.VoicePrintLoginService", "blocked by limit");
            if (this.sLv != null) {
                this.sLv.cHO();
            }
            AppMethodBeat.m2505o(26116);
        } else {
            if (this.sLv != null) {
                this.sLv.cHM();
            }
            AppMethodBeat.m2505o(26116);
        }
    }
}
