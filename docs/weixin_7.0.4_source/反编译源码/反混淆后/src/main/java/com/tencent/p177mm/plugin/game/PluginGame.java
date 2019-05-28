package com.tencent.p177mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.game.model.C20998j;
import com.tencent.p177mm.plugin.game.model.p978a.C20986e;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1268a.C43157d;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.PluginGame */
public class PluginGame extends C7597f implements C9562c, C43157d {
    C20931c mTo;

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(111178);
        if (c1681g.mo5181SG()) {
            C4990ab.m7416i("MicroMsg.PluginGame", "PluginGame configure");
            C20928a.m32173a(new C20929b());
            if (this.mTo == null) {
                this.mTo = new C20931c();
            }
        }
        if (c1681g.mo5183lQ(":tools")) {
            C7060h.pYm.mo15419k(939, 1, 1);
        }
        AppMethodBeat.m2505o(111178);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(111179);
        if (c1681g.mo5181SG()) {
            C4990ab.m7416i("MicroMsg.PluginGame", "PluginGame execute");
            C9204c.aks("game");
            C1720g.m3542a(C45983c.class, new C34278e());
            C1720g.m3542a(C43156b.class, new C20961d());
        }
        AppMethodBeat.m2505o(111179);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(111180);
        C4990ab.m7416i("MicroMsg.PluginGame", "onAccountInitialized");
        if (this.mTo != null) {
            C20931c c20931c = this.mTo;
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("gamecenter", c20931c.luy, true);
            C4879a.xxA.mo10052c(c20931c.mSR);
            C4879a.xxA.mo10052c(c20931c.mSS);
            C4879a.xxA.mo10052c(c20931c.mST);
            C4879a.xxA.mo10052c(c20931c.egQ);
            C4879a.xxA.mo10052c(c20931c.mSU);
            C4879a.xxA.mo10052c(c20931c.mSV);
            C4879a.xxA.mo10052c(c20931c.mSW);
            C4879a.xxA.mo10052c(c20931c.mSX);
            C4879a.xxA.mo10052c(c20931c.mSY);
            C4879a.xxA.mo10052c(c20931c.mTb);
            C4879a.xxA.mo10052c(c20931c.mTc);
            C4879a.xxA.mo10052c(c20931c.mSZ);
            C4879a.xxA.mo10052c(c20931c.mTd);
            C4879a.xxA.mo10052c(c20931c.mTe);
            C4879a.xxA.mo10052c(c20931c.lOc);
            C4879a.xxA.mo10052c(c20931c.mTf);
            C20998j.bie();
            C20986e.bie();
        }
        AppMethodBeat.m2505o(111180);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(111181);
        C4990ab.m7416i("MicroMsg.PluginGame", "onAccountRelease");
        if (this.mTo != null) {
            C20931c c20931c = this.mTo;
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("gamecenter", c20931c.luy, true);
            C4879a.xxA.mo10053d(c20931c.mSR);
            C4879a.xxA.mo10053d(c20931c.mSS);
            C4879a.xxA.mo10053d(c20931c.mST);
            C4879a.xxA.mo10053d(c20931c.egQ);
            C4879a.xxA.mo10053d(c20931c.mSU);
            C4879a.xxA.mo10053d(c20931c.mSV);
            C4879a.xxA.mo10053d(c20931c.mSW);
            C4879a.xxA.mo10053d(c20931c.mSX);
            C4879a.xxA.mo10053d(c20931c.mSY);
            C4879a.xxA.mo10053d(c20931c.mTb);
            C4879a.xxA.mo10053d(c20931c.mTc);
            C4879a.xxA.mo10053d(c20931c.mSZ);
            C4879a.xxA.mo10053d(c20931c.mTd);
            C4879a.xxA.mo10053d(c20931c.mTe);
            C4879a.xxA.mo10053d(c20931c.lOc);
            C4879a.xxA.mo10053d(c20931c.mTf);
            C20998j.bgr();
            C20986e.bgr();
        }
        C46001c.aNR();
        AppMethodBeat.m2505o(111181);
    }
}
