package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.plugin.game.commlib.b.b;
import java.util.HashMap;

public final class d implements a, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.game.commlib.a.a {
    private b mTu;

    public final void a(String str, com.tencent.mm.bt.a aVar) {
        AppMethodBeat.i(59406);
        this.mTu.b(str, aVar);
        AppMethodBeat.o(59406);
    }

    public final byte[] NK(String str) {
        AppMethodBeat.i(59407);
        byte[] NK = this.mTu.NK(str);
        AppMethodBeat.o(59407);
        return NK;
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> collectDatabaseFactory() {
        AppMethodBeat.i(59408);
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        AppMethodBeat.o(59408);
        return hashMap;
    }

    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(59409);
        this.mTu = new b(hVar);
        AppMethodBeat.o(59409);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }
}
