package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.c;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.j;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class i extends a {
    public i(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62081);
        com.tencent.mm.plugin.fts.a.a.i iVar = new com.tencent.mm.plugin.fts.a.a.i();
        iVar.query = this.query;
        iVar.handler = akVar;
        iVar.mEu = hashSet;
        iVar.mEw = this;
        iVar.mEv = c.mEW;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(4, iVar);
        AppMethodBeat.o(62081);
        return search;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        AppMethodBeat.i(62083);
        int i2 = (i - aVar.mFb) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.mFf.size() && i2 >= 0) {
            aVar2 = a(262144, i, (l) aVar.mFf.get(i2), aVar);
        }
        if (aVar2 != null) {
            aVar2.mFn = i2 + 1;
        }
        AppMethodBeat.o(62083);
        return aVar2;
    }

    public final int getType() {
        return 64;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, l lVar, e.a aVar) {
        AppMethodBeat.i(62084);
        j jVar = new j(i2);
        jVar.hpS = lVar;
        jVar.mDz = aVar.mDz;
        jVar.ej(lVar.type, lVar.mDw);
        AppMethodBeat.o(62084);
        return jVar;
    }

    public final void a(com.tencent.mm.plugin.fts.a.a.j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62082);
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            e.a aVar = new e.a();
            aVar.businessType = -6;
            aVar.mDz = jVar.mDz;
            aVar.mFf = jVar.mEy;
            if (aVar.mFf.size() > 3) {
                aVar.mFe = true;
                aVar.mFf = aVar.mFf.subList(0, 3);
            }
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(62082);
    }
}
