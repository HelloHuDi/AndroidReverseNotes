package com.tencent.p177mm.p707ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ba.q */
public final class C9069q extends C4884c<C6523mp> {
    private static long ecD = 86400000;

    public C9069q() {
        AppMethodBeat.m2504i(78504);
        this.xxI = C6523mp.class.getName().hashCode();
        AppMethodBeat.m2505o(78504);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(78507);
        boolean aiv = C9069q.aiv();
        AppMethodBeat.m2505o(78507);
        return aiv;
    }

    private static boolean aiv() {
        AppMethodBeat.m2504i(78505);
        C4990ab.m7410d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + C9069q.m16451Iv());
        if (C9069q.m16451Iv()) {
            C41785c.aiq().update();
        }
        AppMethodBeat.m2505o(78505);
        return false;
    }

    /* renamed from: Iv */
    private static boolean m16451Iv() {
        AppMethodBeat.m2504i(78506);
        if (C5046bo.m7549fp(C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(81938, null))) * 1000 > ecD) {
            AppMethodBeat.m2505o(78506);
            return true;
        }
        AppMethodBeat.m2505o(78506);
        return false;
    }
}
