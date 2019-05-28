package com.tencent.p177mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.p249m.C1763c;
import com.tencent.p177mm.p249m.C1767e;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.zero.a */
public final class C44036a implements C9562c, C7234a {
    private C1767e uZK = new C1767e();
    private C1763c uZL = new C1763c();

    public C44036a() {
        AppMethodBeat.m2504i(58738);
        AppMethodBeat.m2505o(58738);
    }

    /* renamed from: Nu */
    public final C1767e mo15608Nu() {
        AppMethodBeat.m2504i(58739);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C1767e c1767e = this.uZK;
        AppMethodBeat.m2505o(58739);
        return c1767e;
    }

    /* renamed from: Nv */
    public final C1763c mo15609Nv() {
        AppMethodBeat.m2504i(58740);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C1763c c1763c = this.uZL;
        AppMethodBeat.m2505o(58740);
        return c1763c;
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(58741);
        if (c1705c.eKe) {
            C1763c c1763c = this.uZL;
            File file = new File(C6457e.eSn + "configlist/");
            if (file.exists()) {
                File file2 = new File(C1763c.evW);
                if (!file2.exists()) {
                    C4990ab.m7410d("MicroMsg.ConfigListDecoder", "bugfix");
                    c1763c.mo5302d(file, file2);
                }
            }
        }
        this.uZK.mo5312sg();
        this.uZL.init();
        AppMethodBeat.m2505o(58741);
    }

    public final void onAccountRelease() {
    }
}
