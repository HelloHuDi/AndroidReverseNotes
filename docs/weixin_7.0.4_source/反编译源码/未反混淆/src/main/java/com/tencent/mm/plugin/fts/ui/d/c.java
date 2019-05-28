package com.tencent.mm.plugin.fts.ui.d;

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
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class c extends a {
    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62059);
        i iVar = new i();
        iVar.hbo = 96;
        iVar.mEt = 3;
        iVar.query = this.query;
        iVar.mEu = hashSet;
        iVar.mEv = com.tencent.mm.plugin.fts.a.c.a.mEU;
        iVar.mEw = this;
        iVar.handler = akVar;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(2, iVar);
        AppMethodBeat.o(62059);
        return search;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        com.tencent.mm.plugin.fts.a.d.a.a hVar;
        AppMethodBeat.i(62061);
        int i2 = (i - aVar.mFb) - 1;
        if (i2 < aVar.mFf.size() && i2 >= 0) {
            l lVar = (l) aVar.mFf.get(i2);
            if (lVar.mDx.equals("create_chatroom​")) {
                hVar = new h(i);
                hVar.mDz = aVar.mDz;
            } else if (lVar.type == 131075) {
                com.tencent.mm.plugin.fts.a.d.a.a a = a(131075, i, lVar, aVar);
                a.ej(lVar.type, lVar.mDw);
                hVar = a;
            }
            if (hVar != null) {
                hVar.mFn = i2 + 1;
            }
            AppMethodBeat.o(62061);
            return hVar;
        }
        hVar = null;
        if (hVar != null) {
        }
        AppMethodBeat.o(62061);
        return hVar;
    }

    public final int getType() {
        return 48;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, l lVar, e.a aVar) {
        AppMethodBeat.i(62062);
        q qVar = new q(i2);
        qVar.hpS = lVar;
        qVar.mDz = aVar.mDz;
        qVar.ej(lVar.type, lVar.mDw);
        AppMethodBeat.o(62062);
        return qVar;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62060);
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            e.a aVar = new e.a();
            aVar.mFf = jVar.mEy;
            aVar.businessType = -3;
            aVar.mDz = jVar.mDz;
            if (aVar.mFf.size() > 3) {
                if (((l) aVar.mFf.get(3)).mDx.equals("create_chatroom​")) {
                    aVar.mFe = aVar.mFf.size() > 4;
                    aVar.mFf = aVar.mFf.subList(0, 4);
                } else {
                    aVar.mFe = true;
                    aVar.mFf = aVar.mFf.subList(0, 3);
                }
            }
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(62060);
    }
}
