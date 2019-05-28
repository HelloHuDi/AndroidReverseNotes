package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class m implements f {
    private static boolean isRunning = false;
    private static int mWb = 20;
    private static LinkedList<h> mWc = new LinkedList();
    private static al mWd;
    private int offset = 0;

    static /* synthetic */ void b(m mVar) {
        AppMethodBeat.i(111285);
        mVar.bEk();
        AppMethodBeat.o(111285);
    }

    static {
        AppMethodBeat.i(111286);
        AppMethodBeat.o(111286);
    }

    public static void update() {
        AppMethodBeat.i(111282);
        if (!e.bDY()) {
            ab.i("MicroMsg.GameListUpdater", "No need to update");
            AppMethodBeat.o(111282);
        } else if (isRunning) {
            ab.e("MicroMsg.GameListUpdater", "Already running");
            AppMethodBeat.o(111282);
        } else {
            mWd = new al("GameListUpdate");
            mWc.clear();
            f mVar = new m();
            g.Rg().a(1215, mVar);
            g.Rg().a(new au(mVar.offset, mWb), 0);
            isRunning = true;
            AppMethodBeat.o(111282);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, final com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(111283);
        if (i == 0 && i2 == 0) {
            mWd.aa(new Runnable() {
                public final void run() {
                    String str;
                    AppMethodBeat.i(111281);
                    m.this.offset = m.this.offset + m.mWb;
                    bvb bvb = (bvb) ((au) mVar).lty.fsH.fsP;
                    if (bvb == null) {
                        ab.e("MicroMsg.NetSceneSearchGameList", "resp == null");
                        str = null;
                    } else {
                        str = bvb.wkG;
                    }
                    h hVar = new h(str);
                    hVar.bEf();
                    m.mWc.add(hVar);
                    ab.i("MicroMsg.GameListUpdater", "remainingCount: %d", Integer.valueOf(hVar.mVR.optInt("remainingCount")));
                    if (hVar.mVR.optInt("remainingCount") > 0) {
                        g.Rg().a(new au(m.this.offset, m.mWb), 0);
                        AppMethodBeat.o(111281);
                        return;
                    }
                    m.b(m.this);
                    e.bDZ();
                    LinkedList aWj = m.mWc;
                    if (!bo.ek(aWj)) {
                        g.RS().aa(new com.tencent.mm.plugin.game.model.h.AnonymousClass1(aWj));
                    }
                    AppMethodBeat.o(111281);
                }
            });
            AppMethodBeat.o(111283);
            return;
        }
        bEk();
        AppMethodBeat.o(111283);
    }

    private void bEk() {
        AppMethodBeat.i(111284);
        isRunning = false;
        mWd.oAl.quit();
        g.Rg().b(1215, (f) this);
        AppMethodBeat.o(111284);
    }
}
