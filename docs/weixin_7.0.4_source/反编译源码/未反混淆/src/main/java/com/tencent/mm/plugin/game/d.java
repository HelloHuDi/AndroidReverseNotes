package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.sdk.platformtools.ab;

public final class d implements c, b {
    private com.tencent.mm.plugin.game.model.b mTh;
    private t mTi;
    private q mTj;

    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(111167);
        ab.i("MicroMsg.GameService", "GameService onAccountInitialized");
        this.mTh = new com.tencent.mm.plugin.game.model.b();
        this.mTi = new t();
        this.mTj = new q();
        AppMethodBeat.o(111167);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(111168);
        ab.i("MicroMsg.GameService", "GameService onAccountRelease");
        if (this.mTi != null) {
            g.Rg().b(1223, this.mTi);
        }
        AppMethodBeat.o(111168);
    }

    public final com.tencent.mm.plugin.game.model.b bCV() {
        AppMethodBeat.i(111169);
        g.RN().QU();
        if (this.mTh == null) {
            this.mTh = new com.tencent.mm.plugin.game.model.b();
        }
        com.tencent.mm.plugin.game.model.b bVar = this.mTh;
        AppMethodBeat.o(111169);
        return bVar;
    }

    public final t bCW() {
        AppMethodBeat.i(111170);
        g.RN().QU();
        if (this.mTi == null) {
            this.mTi = new t();
        }
        t tVar = this.mTi;
        AppMethodBeat.o(111170);
        return tVar;
    }

    public final q bCX() {
        AppMethodBeat.i(111171);
        g.RN().QU();
        if (this.mTj == null) {
            this.mTj = new q();
        }
        q qVar = this.mTj;
        AppMethodBeat.o(111171);
        return qVar;
    }
}
