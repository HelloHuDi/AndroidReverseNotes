package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.r;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class e extends a {
    public e(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62066);
        i iVar = new i();
        iVar.hbo = 64;
        iVar.query = this.query;
        iVar.mEr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131081};
        iVar.mEt = 3;
        iVar.mEv = com.tencent.mm.plugin.fts.a.c.b.mEV;
        iVar.mEu = hashSet;
        iVar.mEw = this;
        iVar.handler = akVar;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(2, iVar);
        AppMethodBeat.o(62066);
        return search;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        AppMethodBeat.i(62068);
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        int i2 = 0;
        if (aVar.mFc) {
            int i3 = (i - aVar.mFb) - 1;
            if (i3 < aVar.mFf.size() && i3 >= 0) {
                l lVar = (l) aVar.mFf.get(i3);
                aVar2 = a(lVar.type, i, lVar, aVar);
                if (aVar2 != null) {
                    aVar2.ej(lVar.type, lVar.mDw);
                }
            }
            i2 = i3;
        }
        if (aVar2 != null) {
            aVar2.mFn = i2 + 1;
        }
        AppMethodBeat.o(62068);
        return aVar2;
    }

    public final int getType() {
        return 32;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, l lVar, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        AppMethodBeat.i(62069);
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (lVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || lVar.type == 131081) {
            aVar2 = new r(i2);
            aVar2.hpS = lVar;
            aVar2.mDz = aVar.mDz;
            aVar2.ej(lVar.type, lVar.mDw);
        } else if (lVar.type == 131073 || lVar.type == 131074) {
            aVar2 = ((a) ((n) g.M(n.class)).createFTSUIUnit(33, this.context, this.mEZ, this.mFa)).a(i, i2, lVar, aVar);
        }
        AppMethodBeat.o(62069);
        return aVar2;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62067);
        com.tencent.mm.plugin.fts.a.d.e.a aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
        aVar.businessType = -4;
        aVar.mFf = jVar.mEy;
        aVar.mFc = com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy);
        aVar.mDz = jVar.mDz;
        if (aVar.mFf.size() > 3) {
            aVar.mFe = true;
            aVar.mFf = aVar.mFf.subList(0, 3);
        }
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(62067);
    }
}
