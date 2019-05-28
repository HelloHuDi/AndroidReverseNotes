package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class b extends a {
    public b(Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i) {
        super(context, bVar, i);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62056);
        i iVar = new i();
        iVar.hbo = 32;
        iVar.query = this.query;
        iVar.mEu = hashSet;
        iVar.mEv = com.tencent.mm.plugin.fts.a.c.a.mEU;
        iVar.mEw = this;
        iVar.handler = akVar;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(2, iVar);
        AppMethodBeat.o(62056);
        return search;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        AppMethodBeat.i(62058);
        int i2 = (i - aVar.mFb) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.mFf.size() && i2 >= 0) {
            l lVar = (l) aVar.mFf.get(i2);
            if (lVar.mDx.equals("create_chatroom​")) {
                aVar2 = new h(i);
                aVar2.mDz = aVar.mDz;
            } else {
                com.tencent.mm.plugin.fts.a.d.a.a qVar = new q(i);
                qVar.hpS = lVar;
                qVar.mDz = aVar.mDz;
                qVar.ej(lVar.type, lVar.mDw);
                aVar2 = qVar;
            }
        }
        if (aVar2 != null) {
            aVar2.mFn = i2 + 1;
        }
        AppMethodBeat.o(62058);
        return aVar2;
    }

    public final int getType() {
        return 4128;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62057);
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            e.a aVar = new e.a();
            aVar.businessType = -3;
            aVar.mFf = jVar.mEy;
            aVar.mDz = jVar.mDz;
            aVar.mFe = false;
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(62057);
    }
}
