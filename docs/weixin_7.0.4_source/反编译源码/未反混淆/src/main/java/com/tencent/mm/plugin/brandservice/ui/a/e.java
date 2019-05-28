package com.tencent.mm.plugin.brandservice.ui.a;

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

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        AppMethodBeat.i(14095);
        int i2 = (i - aVar.mFb) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.mFf.size() && i2 >= 0) {
            l lVar = (l) aVar.mFf.get(i2);
            com.tencent.mm.plugin.fts.a.d.a.a a = a(131076, i, lVar, aVar);
            a.ej(lVar.type, lVar.mDw);
            aVar2 = a;
        }
        if (aVar2 != null) {
            aVar2.mFn = i2 + 1;
        }
        AppMethodBeat.o(14095);
        return aVar2;
    }

    public final int getType() {
        return 96;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, l lVar, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        AppMethodBeat.i(14096);
        a aVar2 = new a(i2);
        aVar2.hpS = lVar;
        aVar2.mDz = aVar.mDz;
        aVar2.ej(lVar.type, lVar.mDw);
        AppMethodBeat.o(14096);
        return aVar2;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(14093);
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(2, i.a(this.query, new int[]{131076}, null, 4, hashSet, com.tencent.mm.plugin.fts.a.c.b.mEV, this, akVar));
        AppMethodBeat.o(14093);
        return search;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(14094);
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            com.tencent.mm.plugin.fts.a.d.e.a aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
            aVar.businessType = -7;
            aVar.mFf = jVar.mEy;
            aVar.mDz = jVar.mDz;
            if (aVar.mFf.size() > 3) {
                aVar.mFe = true;
                aVar.mFf = aVar.mFf.subList(0, 3);
            }
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(14094);
    }
}
