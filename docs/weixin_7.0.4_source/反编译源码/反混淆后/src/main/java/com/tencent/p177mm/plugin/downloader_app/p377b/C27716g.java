package com.tencent.p177mm.plugin.downloader_app.p377b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C42905a;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C42906b;
import com.tencent.p177mm.plugin.game.commlib.p977a.C34261a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.downloader_app.b.g */
public final class C27716g {
    public static C27717a kOX;
    static C27715f kOY;

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.g$1 */
    static class C203381 implements C1224a {
        C203381() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(136141);
            C4990ab.m7417i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                C27716g.kOY = new C27715f((C42906b) c7472b.fsH.fsP);
                if (C27716g.kOX != null) {
                    C27716g.kOX.mo23230gd(true);
                }
            } else if (C27716g.kOX != null) {
                C27716g.kOX.mo23230gd(false);
            }
            AppMethodBeat.m2505o(136141);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.b.g$a */
    public interface C27717a {
        /* renamed from: gd */
        void mo23230gd(boolean z);
    }

    public static C27715f biM() {
        AppMethodBeat.m2504i(136142);
        if (kOY == null) {
            byte[] NK = ((C34261a) C1720g.m3528K(C34261a.class)).mo23945NK("pb_appinfo");
            if (NK != null) {
                kOY = new C27715f(NK);
            }
        }
        C27715f c27715f = kOY;
        AppMethodBeat.m2505o(136142);
        return c27715f;
    }

    /* renamed from: a */
    public static void m44026a(LinkedList<String> linkedList, C27717a c27717a) {
        AppMethodBeat.m2504i(136143);
        C1196a c1196a = new C1196a();
        C42905a c42905a = new C42905a();
        c42905a.kKk = linkedList;
        c42905a.kKm = true;
        c1196a.fsJ = c42905a;
        c1196a.fsK = new C42906b();
        c1196a.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
        c1196a.fsI = 7797;
        kOX = c27717a;
        C1226w.m2654a(c1196a.acD(), new C203381());
        AppMethodBeat.m2505o(136143);
    }
}
