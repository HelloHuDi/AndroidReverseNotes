package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.model.a.g;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.plugin.wepkg.b.b;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class e implements a, d, c {
    private r mTk;
    private w mTl;
    private g mTm;

    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(111172);
        ab.i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
        this.mTk = new r(hVar);
        this.mTm = new g(hVar);
        AppMethodBeat.o(111172);
    }

    public final HashMap<Integer, h.d> collectDatabaseFactory() {
        AppMethodBeat.i(111173);
        ab.i("MicroMsg.GameStorage", "GameStorage collectDatabaseFactory");
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new h.d() {
            public final String[] Af() {
                return r.fnj;
            }
        });
        hashMap.put(Integer.valueOf("GAME_CENTER_PB_CACHE_TABLE".hashCode()), new h.d() {
            public final String[] Af() {
                return w.fnj;
            }
        });
        hashMap.put(Integer.valueOf("GAME_CENTER_SILENT_DOWNLOAD_TABLE".hashCode()), new h.d() {
            public final String[] Af() {
                return g.fnj;
            }
        });
        hashMap.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new h.d() {
            public final String[] Af() {
                return f.fnj;
            }
        });
        hashMap.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new h.d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.wepkg.b.d.fnj;
            }
        });
        hashMap.put(Integer.valueOf("WEPKG_DIFF_PACK".hashCode()), new h.d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        AppMethodBeat.o(111173);
        return hashMap;
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final r bCY() {
        AppMethodBeat.i(111174);
        com.tencent.mm.kernel.g.RN().QU();
        if (this.mTk == null) {
            com.tencent.mm.kernel.g.RQ();
            this.mTk = new r(com.tencent.mm.kernel.g.RP().eJN);
        }
        r rVar = this.mTk;
        AppMethodBeat.o(111174);
        return rVar;
    }

    public final w bCZ() {
        AppMethodBeat.i(111175);
        com.tencent.mm.kernel.g.RN().QU();
        if (this.mTl == null) {
            com.tencent.mm.kernel.g.RQ();
            this.mTl = new w(com.tencent.mm.kernel.g.RP().eJN);
        }
        w wVar = this.mTl;
        AppMethodBeat.o(111175);
        return wVar;
    }

    public final g bDa() {
        AppMethodBeat.i(111176);
        com.tencent.mm.kernel.g.RN().QU();
        if (this.mTm == null) {
            com.tencent.mm.kernel.g.RQ();
            this.mTm = new g(com.tencent.mm.kernel.g.RP().eJN);
        }
        g gVar = this.mTm;
        AppMethodBeat.o(111176);
        return gVar;
    }
}
