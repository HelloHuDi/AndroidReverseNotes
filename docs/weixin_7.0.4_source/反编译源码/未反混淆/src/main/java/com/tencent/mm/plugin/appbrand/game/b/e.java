package com.tencent.mm.plugin.appbrand.game.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class e extends a {
    public e(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(130084);
        i iVar = new i();
        iVar.query = this.query;
        iVar.mEv = d.mEX;
        iVar.mEw = this;
        iVar.handler = akVar;
        iVar.mEu = hashSet;
        iVar.mEv = h.hri;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(10, iVar);
        AppMethodBeat.o(130084);
        return search;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        AppMethodBeat.i(130086);
        int i2 = (i - aVar.mFb) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.mFf.size() && i2 >= 0) {
            l lVar = (l) aVar.mFf.get(i2);
            com.tencent.mm.plugin.fts.a.d.a.a cVar = new c(i);
            cVar.hpS = lVar;
            cVar.mDz = aVar.mDz;
            cVar.ej(lVar.type, lVar.mDw);
            aVar2 = cVar;
        }
        if (aVar2 != null) {
            aVar2.mFn = i2 + 1;
        }
        AppMethodBeat.o(130086);
        return aVar2;
    }

    public final int getType() {
        return 4240;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(130085);
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            com.tencent.mm.plugin.fts.a.d.e.a aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
            aVar.businessType = -15;
            aVar.mDz = jVar.mDz;
            aVar.mFf = jVar.mEy;
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(130085);
    }
}
