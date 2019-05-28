package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.r;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class d extends a {
    public d(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62063);
        i iVar = new i();
        iVar.query = this.query;
        iVar.mEr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131081};
        iVar.mEv = com.tencent.mm.plugin.fts.a.c.b.mEV;
        iVar.mEu = hashSet;
        iVar.mEw = this;
        iVar.handler = akVar;
        iVar.hbo = 16;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(2, iVar);
        AppMethodBeat.o(62063);
        return search;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        AppMethodBeat.i(62065);
        int i2 = (i - aVar.mFb) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.mFf.size() && i2 >= 0) {
            l lVar = (l) aVar.mFf.get(i2);
            com.tencent.mm.plugin.fts.a.d.a.a rVar = new r(i);
            rVar.hpS = lVar;
            rVar.mDz = aVar.mDz;
            rVar.ej(lVar.type, lVar.mDw);
            aVar2 = rVar;
        }
        if (aVar2 != null) {
            aVar2.mFn = i2 + 1;
        }
        AppMethodBeat.o(62065);
        return aVar2;
    }

    public final int getType() {
        return 4112;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62064);
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            e.a aVar = new e.a();
            aVar.businessType = -4;
            aVar.mFf = jVar.mEy;
            aVar.mDz = jVar.mDz;
            aVar.mFe = false;
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(62064);
    }
}
