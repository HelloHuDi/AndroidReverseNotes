package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.downloader.c.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class g {
    public static a kOX;
    static f kOY;

    public interface a {
        void gd(boolean z);
    }

    public static f biM() {
        AppMethodBeat.i(136142);
        if (kOY == null) {
            byte[] NK = ((com.tencent.mm.plugin.game.commlib.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.game.commlib.a.a.class)).NK("pb_appinfo");
            if (NK != null) {
                kOY = new f(NK);
            }
        }
        f fVar = kOY;
        AppMethodBeat.o(136142);
        return fVar;
    }

    public static void a(LinkedList<String> linkedList, a aVar) {
        AppMethodBeat.i(136143);
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        com.tencent.mm.plugin.downloader.c.a.a.a aVar3 = new com.tencent.mm.plugin.downloader.c.a.a.a();
        aVar3.kKk = linkedList;
        aVar3.kKm = true;
        aVar2.fsJ = aVar3;
        aVar2.fsK = new b();
        aVar2.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
        aVar2.fsI = 7797;
        kOX = aVar;
        w.a(aVar2.acD(), new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(136141);
                ab.i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                if (i == 0 && i2 == 0) {
                    g.kOY = new f((b) bVar.fsH.fsP);
                    if (g.kOX != null) {
                        g.kOX.gd(true);
                    }
                } else if (g.kOX != null) {
                    g.kOX.gd(false);
                }
                AppMethodBeat.o(136141);
                return 0;
            }
        });
        AppMethodBeat.o(136143);
    }
}
