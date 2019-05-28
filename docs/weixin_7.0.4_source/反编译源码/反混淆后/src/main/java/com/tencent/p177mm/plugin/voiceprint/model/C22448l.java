package com.tencent.p177mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.l */
public final class C22448l implements C1202f {
    public int sLf;
    public int sLr;
    private String sLs;
    public int sLt;
    public C22447a sLu;

    /* renamed from: com.tencent.mm.plugin.voiceprint.model.l$a */
    public interface C22447a {
        /* renamed from: E */
        void mo9255E(boolean z, int i);

        void abS(String str);

        void abT(String str);

        void cHM();
    }

    public C22448l() {
        AppMethodBeat.m2504i(26111);
        this.sLr = 71;
        this.sLs = null;
        this.sLt = 0;
        this.sLf = 0;
        this.sLu = null;
        C9638aw.m17182Rg().mo14539a(611, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(612, (C1202f) this);
        AppMethodBeat.m2505o(26111);
    }

    public C22448l(C22447a c22447a) {
        this();
        this.sLu = c22447a;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26112);
        C4990ab.m7411d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 || i2 == 0) {
            if (c1207m.getType() == 611) {
                C14014d c14014d = (C14014d) c1207m;
                this.sLt = c14014d.sKX;
                this.sLs = c14014d.sKW;
                C4990ab.m7411d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", Integer.valueOf(this.sLt), Boolean.valueOf(C5046bo.isNullOrNil(this.sLs)));
                if (this.sLu != null) {
                    if (this.sLr == 71) {
                        this.sLu.abS(this.sLs);
                    } else if (this.sLr == 72) {
                        this.sLu.abT(this.sLs);
                    }
                }
            }
            if (c1207m.getType() == 612) {
                C14015f c14015f = (C14015f) c1207m;
                int i3 = ((c14015f.sLh == 72 && c14015f.f2946Kt == 0) || c14015f.sLh == 71) ? 1 : 0;
                if (i3 != 0) {
                    C4990ab.m7411d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", Integer.valueOf(c14015f.sLh));
                    this.sLf = c14015f.sLf;
                    if (this.sLu != null) {
                        this.sLu.mo9255E(true, c14015f.sLh);
                    }
                } else {
                    C4990ab.m7411d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", Integer.valueOf(c14015f.sLh));
                    if (this.sLu != null) {
                        this.sLu.mo9255E(false, c14015f.sLh);
                    }
                }
                if (!(i3 == 0 || c14015f.sLh != 71 || this.sLu == null)) {
                    this.sLu.abT(this.sLs);
                }
            }
            AppMethodBeat.m2505o(26112);
            return;
        }
        if (this.sLu != null) {
            this.sLu.cHM();
        }
        AppMethodBeat.m2505o(26112);
    }
}
