package com.tencent.p177mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.facedetect.p1259a.C20621a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p644j.C7583c;

/* renamed from: com.tencent.mm.plugin.facedetect.PluginFace */
public class PluginFace extends C7597f implements C20621a {

    /* renamed from: com.tencent.mm.plugin.facedetect.PluginFace$1 */
    class C279141 implements C5690a<C7583c<Integer, String>> {
        C279141() {
        }

        /* renamed from: bi */
        public final /* synthetic */ void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(50);
            C7583c c7583c = (C7583c) obj;
            if (c7583c != null) {
                int a = C5046bo.m7512a((Integer) c7583c.get(0), -1);
                String bc = C5046bo.m7532bc((String) c7583c.get(1), "unknown");
                C4990ab.m7413e("MicroMsg.PluginFace", "hy: onInterrupt errCode: %d, errMsg: %s", Integer.valueOf(a), bc);
                AppMethodBeat.m2505o(50);
                return;
            }
            C4990ab.m7412e("MicroMsg.PluginFace", "hy: null in on interrupt");
            AppMethodBeat.m2505o(50);
        }
    }

    public String name() {
        return "plugin-facedetect";
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(51);
        C4990ab.m7416i("MicroMsg.PluginFace", "hy: starting execute.");
        if (c1681g.mo5181SG()) {
            C5698f.dMn().mo15893d(new C43023a()).mo11586a((C5690a) new C279141());
        }
        AppMethodBeat.m2505o(51);
    }
}
