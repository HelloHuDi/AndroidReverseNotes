package com.tencent.p177mm.plugin.offline.p479ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C18395su;
import com.tencent.p177mm.plugin.offline.C39473i;
import com.tencent.p177mm.plugin.offline.C7007k;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.offline.ui.d */
public final class C7014d extends C4884c<C18395su> {
    private C7306ak mHandler;

    public C7014d() {
        AppMethodBeat.m2504i(43501);
        this.mHandler = new C7306ak(Looper.getMainLooper());
        this.xxI = C18395su.class.getName().hashCode();
        AppMethodBeat.m2505o(43501);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(43502);
        final C18395su c18395su = (C18395su) c4883b;
        if (C1720g.m3531RK() && (c18395su instanceof C18395su)) {
            C4990ab.m7416i("MicroMsg.SyncOfflineTokenListener", "SyncOfflineTokenListener -> updateToken()");
            boolean z = c18395su.cOT.cOU;
            final boolean z2 = c18395su.cOT.scene == 1;
            if (z2) {
                C7060h.pYm.mo8378a(135, 25, 1, true);
            }
            if (z) {
                this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(43500);
                        if (C1720g.m3531RK()) {
                            if (c18395su.cOT.cOV) {
                                C7007k.bXg();
                                C39473i bXj = C7007k.bXj();
                                int i = c18395su.cOT.cOW;
                                bXj.mo62419eO(i, i);
                                AppMethodBeat.m2505o(43500);
                                return;
                            }
                            C7007k.bXg();
                            C7007k.bXj().mo62421jF(z2);
                        }
                        AppMethodBeat.m2505o(43500);
                    }
                }, 10000);
            } else if (c18395su.cOT.cOV) {
                C7007k.bXg();
                C39473i bXj = C7007k.bXj();
                int i = c18395su.cOT.cOW;
                bXj.mo62419eO(i, i);
            } else {
                C7007k.bXg();
                C7007k.bXj().mo62421jF(z2);
            }
        }
        AppMethodBeat.m2505o(43502);
        return false;
    }
}
