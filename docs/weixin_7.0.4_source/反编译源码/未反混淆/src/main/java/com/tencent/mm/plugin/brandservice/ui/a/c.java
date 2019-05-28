package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
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

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        AppMethodBeat.i(14090);
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
        AppMethodBeat.o(14090);
        return aVar2;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, l lVar, e.a aVar) {
        AppMethodBeat.i(14091);
        a aVar2 = new a(i2);
        aVar2.hpS = lVar;
        aVar2.mDz = aVar.mDz;
        aVar2.ej(lVar.type, lVar.mDw);
        AppMethodBeat.o(14091);
        return aVar2;
    }

    public final int getType() {
        return 4208;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(14088);
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(2, i.a(this.query, new int[]{131076}, null, -1, hashSet, com.tencent.mm.plugin.fts.a.c.b.mEV, this, akVar));
        AppMethodBeat.o(14088);
        return search;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(14089);
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            e.a aVar = new e.a();
            aVar.businessType = -7;
            aVar.mDz = jVar.mDz;
            aVar.mFf = jVar.mEy;
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(14089);
    }
}
