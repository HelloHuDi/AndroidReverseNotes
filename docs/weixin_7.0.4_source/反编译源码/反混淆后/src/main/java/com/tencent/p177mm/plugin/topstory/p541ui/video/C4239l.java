package com.tencent.p177mm.plugin.topstory.p541ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.plugin.topstory.p539a.C29431c;
import com.tencent.p177mm.plugin.topstory.p541ui.PluginTopStoryUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tinkerboots.sdk.p1355b.C24572a;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.l */
public final class C4239l {
    private C1924a kto = new C42401();
    public boolean sEM = false;
    C29431c sEN;
    public int sEO = C4239l.cGO();

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.l$1 */
    class C42401 extends C1924a {
        C42401() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(1742);
            final int i2 = C4239l.this.sEO;
            C4239l.this.sEO = C4239l.cGO();
            if (C4239l.this.sEO != i2) {
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", Integer.valueOf(i2), Integer.valueOf(C4239l.this.sEO));
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(1741);
                        if (C4239l.this.sEN != null) {
                            C4239l.this.sEN.mo47665fP(i2, C4239l.this.sEO);
                        }
                        AppMethodBeat.m2505o(1741);
                    }
                });
            }
            AppMethodBeat.m2505o(1742);
        }
    }

    public C4239l() {
        AppMethodBeat.m2504i(1743);
        C1720g.m3535RO().mo5187a(this.kto);
        AppMethodBeat.m2505o(1743);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(1744);
        C1720g.m3535RO().mo5188b(this.kto);
        this.sEN = null;
        this.sEO = 0;
        this.sEM = false;
        AppMethodBeat.m2505o(1744);
    }

    public final boolean bkJ() {
        return this.sEO == 1;
    }

    public final boolean cGN() {
        return this.sEO == 2;
    }

    public final boolean isConnected() {
        return this.sEO != 0;
    }

    public static int cGO() {
        AppMethodBeat.m2504i(1745);
        if (!C24572a.isConnected(C4996ah.getContext())) {
            AppMethodBeat.m2505o(1745);
            return 0;
        } else if (!C24572a.isWifi(C4996ah.getContext())) {
            AppMethodBeat.m2505o(1745);
            return 2;
        } else if (((PluginTopStoryUI) C1720g.m3530M(PluginTopStoryUI.class)).getTopStoryCommand().sBk) {
            AppMethodBeat.m2505o(1745);
            return 2;
        } else {
            AppMethodBeat.m2505o(1745);
            return 1;
        }
    }
}
