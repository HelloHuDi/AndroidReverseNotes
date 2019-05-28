package com.tencent.p177mm.audio.mix.p196e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C41771a;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C25836b;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import java.util.List;

/* renamed from: com.tencent.mm.audio.mix.e.d */
public final class C45168d implements C25842i {
    private C25841h cmO;
    private int cmP = 4;

    public final void init() {
        AppMethodBeat.m2504i(137115);
        if (this.cmO == null) {
            C25841h c41779n;
            switch (this.cmP) {
                case 1:
                    c41779n = new C41779n();
                    break;
                case 2:
                    c41779n = new C1295a();
                    break;
                case 3:
                    c41779n = new C25843k();
                    break;
                case 4:
                    c41779n = new C9053j();
                    break;
                case 5:
                    c41779n = new C46875m();
                    break;
                case 6:
                    c41779n = new C41780o();
                    break;
                case 7:
                    c41779n = new C17962l();
                    break;
                case 8:
                    c41779n = new C9051b();
                    break;
                default:
                    c41779n = new C9053j();
                    break;
            }
            this.cmO = c41779n;
        }
        AppMethodBeat.m2505o(137115);
    }

    /* renamed from: I */
    public final C25836b mo43832I(List<C45164d> list) {
        AppMethodBeat.m2504i(137116);
        if (this.cmO == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioMixer", "mixAlgorithm must be init, please call init() first");
            AppMethodBeat.m2505o(137116);
            return null;
        }
        C25836b Dh = C41771a.m73730Dg().mo67524Dh();
        if (this.cmO.mo43831a(Dh, list)) {
            AppMethodBeat.m2505o(137116);
            return Dh;
        }
        C45174b.m83207e("MicroMsg.Mix.AudioMixer", "mix audio fail");
        AppMethodBeat.m2505o(137116);
        return null;
    }
}
