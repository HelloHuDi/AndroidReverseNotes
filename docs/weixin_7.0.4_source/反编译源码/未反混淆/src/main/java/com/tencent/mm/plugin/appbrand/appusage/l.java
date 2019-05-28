package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class l {
    private static volatile l gZk;
    public final Set<b> gZl = new HashSet();
    public volatile ari gZm = null;
    public final Object mLock = new Object();

    public enum c {
        WXAPP(1),
        H5(2);
        
        private int bTx;

        static {
            AppMethodBeat.o(129565);
        }

        private c(int i) {
            this.bTx = i;
        }

        public static c nz(int i) {
            AppMethodBeat.i(129564);
            for (c cVar : values()) {
                if (i == cVar.bTx) {
                    AppMethodBeat.o(129564);
                    return cVar;
                }
            }
            AppMethodBeat.o(129564);
            return null;
        }
    }

    public interface b {
        void axk();
    }

    public enum a {
        FORCE_OFF(0),
        FORCE_ON(1);
        
        int bTx;

        static {
            AppMethodBeat.o(129561);
        }

        private a(int i) {
            this.bTx = i;
        }

        public static a ny(int i) {
            AppMethodBeat.i(129560);
            for (a aVar : values()) {
                if (aVar.bTx == i) {
                    AppMethodBeat.o(129560);
                    return aVar;
                }
            }
            AppMethodBeat.o(129560);
            return null;
        }
    }

    public l() {
        AppMethodBeat.i(129566);
        AppMethodBeat.o(129566);
    }

    public static l axj() {
        AppMethodBeat.i(129567);
        if (gZk == null) {
            synchronized (l.class) {
                try {
                    if (gZk == null) {
                        gZk = new l();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(129567);
                    }
                }
            }
        }
        l lVar = gZk;
        AppMethodBeat.o(129567);
        return lVar;
    }

    public final void refresh() {
        AppMethodBeat.i(129568);
        this.gZm = null;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = 1841;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxagame";
        aVar.fsJ = new arh();
        aVar.fsK = new ari();
        w.a(aVar.acD(), new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(129557);
                if (i == 0 && i2 == 0 && bVar != null && bVar.fsH.fsP != null && (bVar.fsH.fsP instanceof ari)) {
                    l.a(l.this, (ari) bVar.fsH.fsP);
                } else {
                    ab.e("MicroMsg.AppBrandLauncherListWAGameLogic", "doRequest() cgi return errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    l.a(l.this, null);
                }
                AppMethodBeat.o(129557);
                return 0;
            }
        });
        AppMethodBeat.o(129568);
    }

    public static boolean enabled() {
        AppMethodBeat.i(129569);
        if (g.RK()) {
            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100328");
            if (ll.isValid()) {
                a ny = a.ny(bo.getInt((String) ll.dru().get("isOpenGameEntry"), 0));
                if (ny != null && ny == a.FORCE_ON) {
                    AppMethodBeat.o(129569);
                    return true;
                }
            }
        }
        AppMethodBeat.o(129569);
        return false;
    }

    static /* synthetic */ void a(l lVar, ari ari) {
        AppMethodBeat.i(129570);
        if (g.RK()) {
            lVar.gZm = ari;
            LinkedList linkedList = null;
            synchronized (lVar.mLock) {
                try {
                    if (lVar.gZl.size() != 0) {
                        linkedList = new LinkedList(lVar.gZl);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(129570);
                    }
                }
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).axk();
                }
            }
        }
        AppMethodBeat.o(129570);
    }
}
