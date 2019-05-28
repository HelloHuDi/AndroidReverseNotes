package com.tencent.p177mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C32629sf;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.bbom.p */
public final class C20010p {
    private static boolean jEw = false;

    /* renamed from: cR */
    public static synchronized void m30927cR(final Context context) {
        synchronized (C20010p.class) {
            AppMethodBeat.m2504i(18276);
            if (jEw) {
                AppMethodBeat.m2505o(18276);
            } else {
                jEw = true;
                C1720g.m3535RO().mo5187a(new C1924a() {
                    /* renamed from: gl */
                    public final void mo5192gl(int i) {
                        AppMethodBeat.m2504i(18275);
                        if (i == 4 || i == 6) {
                            C20010p.aVr();
                            AppMethodBeat.m2505o(18275);
                            return;
                        }
                        AppMethodBeat.m2505o(18275);
                    }
                });
                AppMethodBeat.m2505o(18276);
            }
        }
    }

    static /* synthetic */ void aVr() {
        AppMethodBeat.m2504i(18277);
        if (!C1720g.m3531RK() || C1668a.m3393QT()) {
            C4990ab.m7420w("MicroMsg.OnNetworkAvailableListener", "dealWithNetworkAvailable hasSetuin:" + C1720g.m3531RK() + " isHold:" + C1668a.m3393QT());
            AppMethodBeat.m2505o(18277);
            return;
        }
        C26500m.amc().run();
        C37961o.alq().run();
        C32291o.ahj().run();
        C14877am.dhP().run();
        if (C26417a.flx != null) {
            C26417a.flx.mo44185Zw();
        }
        C4879a.xxA.mo10055m(new C32629sf());
        AppMethodBeat.m2505o(18277);
    }
}
