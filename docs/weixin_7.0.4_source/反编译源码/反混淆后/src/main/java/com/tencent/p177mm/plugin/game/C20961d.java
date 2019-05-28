package com.tencent.p177mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.plugin.game.model.C28225b;
import com.tencent.p177mm.plugin.game.model.C28236t;
import com.tencent.p177mm.plugin.game.model.C39215q;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.d */
public final class C20961d implements C9562c, C43156b {
    private C28225b mTh;
    private C28236t mTi;
    private C39215q mTj;

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(111167);
        C4990ab.m7416i("MicroMsg.GameService", "GameService onAccountInitialized");
        this.mTh = new C28225b();
        this.mTi = new C28236t();
        this.mTj = new C39215q();
        AppMethodBeat.m2505o(111167);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(111168);
        C4990ab.m7416i("MicroMsg.GameService", "GameService onAccountRelease");
        if (this.mTi != null) {
            C1720g.m3540Rg().mo14546b(1223, this.mTi);
        }
        AppMethodBeat.m2505o(111168);
    }

    public final C28225b bCV() {
        AppMethodBeat.m2504i(111169);
        C1720g.m3534RN().mo5159QU();
        if (this.mTh == null) {
            this.mTh = new C28225b();
        }
        C28225b c28225b = this.mTh;
        AppMethodBeat.m2505o(111169);
        return c28225b;
    }

    public final C28236t bCW() {
        AppMethodBeat.m2504i(111170);
        C1720g.m3534RN().mo5159QU();
        if (this.mTi == null) {
            this.mTi = new C28236t();
        }
        C28236t c28236t = this.mTi;
        AppMethodBeat.m2505o(111170);
        return c28236t;
    }

    public final C39215q bCX() {
        AppMethodBeat.m2504i(111171);
        C1720g.m3534RN().mo5159QU();
        if (this.mTj == null) {
            this.mTj = new C39215q();
        }
        C39215q c39215q = this.mTj;
        AppMethodBeat.m2505o(111171);
        return c39215q;
    }
}
