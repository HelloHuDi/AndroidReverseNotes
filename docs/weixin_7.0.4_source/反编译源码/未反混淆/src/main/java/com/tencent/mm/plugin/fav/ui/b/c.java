package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class c extends a {
    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(74500);
        i iVar = new i();
        iVar.hbo = 2;
        iVar.query = this.query;
        iVar.mEu = hashSet;
        iVar.handler = akVar;
        iVar.mEw = this;
        iVar.mEv = d.mEX;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(6, iVar);
        AppMethodBeat.o(74500);
        return search;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        AppMethodBeat.i(74502);
        int i2 = (i - aVar.mFb) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.mFf.size() && i2 >= 0) {
            l lVar = (l) aVar.mFf.get(i2);
            com.tencent.mm.plugin.fts.a.d.a.a aVar3 = new a(i);
            aVar3.hpS = lVar;
            aVar3.mDz = aVar.mDz;
            aVar3.ej(lVar.type, lVar.mDw);
            aVar2 = aVar3;
        }
        if (aVar2 != null) {
            aVar2.mFn = i2 + 1;
        }
        AppMethodBeat.o(74502);
        return aVar2;
    }

    public final int getType() {
        return 4192;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(74501);
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            e.a aVar = new e.a();
            aVar.businessType = -1;
            aVar.mDz = jVar.mDz;
            aVar.mFf = jVar.mEy;
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(74501);
    }
}
