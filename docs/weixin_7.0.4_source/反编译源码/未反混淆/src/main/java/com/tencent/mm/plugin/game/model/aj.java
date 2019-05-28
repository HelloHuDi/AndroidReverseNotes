package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aj extends m implements k {
    public static f fur = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(111416);
            g.Rg().b(2641, (f) this);
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data success");
                final bg bET = ((aj) mVar).bET();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(111415);
                        aj.a(bET);
                        AppMethodBeat.o(111415);
                    }
                });
                AppMethodBeat.o(111416);
                return;
            }
            ab.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data fail");
            AppMethodBeat.o(111416);
        }
    };
    public static final String mYz = (b.eSn + "Game/TabNav/");
    private f ehi;
    private final com.tencent.mm.ai.b lty;

    interface a {
        void onComplete();
    }

    static /* synthetic */ void b(List list, a aVar) {
        AppMethodBeat.i(111425);
        a(list, aVar);
        AppMethodBeat.o(111425);
    }

    static {
        AppMethodBeat.i(111426);
        AppMethodBeat.o(111426);
    }

    public aj() {
        AppMethodBeat.i(111419);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bf();
        aVar.fsK = new bg();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4tabnav";
        this.lty = aVar.acD();
        AppMethodBeat.o(111419);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(111420);
        ab.i("MicroMsg.NetSceneGameIndex4TabNav", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111420);
    }

    public final int getType() {
        return 2641;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(111421);
        this.ehi = fVar;
        int a = a(eVar, this.lty, this);
        AppMethodBeat.o(111421);
        return a;
    }

    public final bg bET() {
        return (bg) this.lty.fsH.fsP;
    }

    public static void updateData() {
        AppMethodBeat.i(111422);
        ab.i("MicroMsg.NetSceneGameIndex4TabNav", "update gameIndexTabNav data");
        g.Rg().a(2641, fur);
        g.Rg().a(new aj(), 0);
        AppMethodBeat.o(111422);
    }

    public static void a(final bg bgVar) {
        AppMethodBeat.i(111423);
        if (bgVar == null) {
            AppMethodBeat.o(111423);
        } else if (bo.ek(bgVar.naO)) {
            ab.i("MicroMsg.NetSceneGameIndex4TabNav", "nav list is null");
            AppMethodBeat.o(111423);
        } else {
            List arrayList = new ArrayList();
            Iterator it = bgVar.naO.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.game.d.al alVar = (com.tencent.mm.plugin.game.d.al) it.next();
                if (alVar != null) {
                    arrayList.add(alVar.naY);
                    arrayList.add(alVar.naZ);
                }
            }
            a(arrayList, new a() {
                public final void onComplete() {
                    AppMethodBeat.i(111417);
                    ab.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
                    ((c) g.K(c.class)).bCZ().b("game_index4_tab_nav", bgVar);
                    AppMethodBeat.o(111417);
                }
            });
            AppMethodBeat.o(111423);
        }
    }

    private static void a(final List<String> list, final a aVar) {
        AppMethodBeat.i(111424);
        while (!bo.ek(list)) {
            final String str = (String) list.remove(0);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.NetSceneGameIndex4TabNav", "iconUrl is null");
            } else {
                String str2 = mYz + com.tencent.mm.a.g.x(str.getBytes());
                com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
                aVar2.ePH = true;
                aVar2.ePJ = str2;
                o.ahp().a(str, aVar2.ahG(), new com.tencent.mm.at.a.c.c() {
                    public final void a(boolean z, Object... objArr) {
                        AppMethodBeat.i(111418);
                        ab.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", Boolean.valueOf(z), str);
                        aj.b(list, aVar);
                        AppMethodBeat.o(111418);
                    }
                });
                AppMethodBeat.o(111424);
                return;
            }
        }
        if (aVar != null) {
            aVar.onComplete();
        }
        AppMethodBeat.o(111424);
    }
}
