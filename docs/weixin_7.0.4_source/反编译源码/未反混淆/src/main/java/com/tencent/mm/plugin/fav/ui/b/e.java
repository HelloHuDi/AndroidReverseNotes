package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
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
        AppMethodBeat.i(74504);
        i iVar = new i();
        iVar.hbo = 1;
        iVar.query = this.query;
        iVar.mEt = 1;
        iVar.mEu = hashSet;
        iVar.handler = akVar;
        iVar.mEw = this;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(6, iVar);
        AppMethodBeat.o(74504);
        return search;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        AppMethodBeat.i(74506);
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
        AppMethodBeat.o(74506);
        return aVar2;
    }

    public final int getType() {
        return 128;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(74505);
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            com.tencent.mm.plugin.fts.a.d.e.a aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
            aVar.businessType = -1;
            aVar.mDz = jVar.mDz;
            aVar.mFf = jVar.mEy;
            if (aVar.mFf.size() > 1) {
                aVar.mFe = true;
                aVar.mFf = aVar.mFf.subList(0, 1);
            }
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(74505);
    }
}
