package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.f;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class g extends l {
    public String mEp;
    public int showType;
    public String talker;

    public g(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final int getType() {
        return az.CTRL_INDEX;
    }

    public final a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62074);
        this.mLK = false;
        i iVar = new i();
        iVar.query = this.query;
        iVar.mEv = e.mEY;
        iVar.mEp = this.mEp;
        iVar.mEq = this.mEq;
        iVar.talker = this.talker;
        iVar.mEw = this;
        iVar.handler = akVar;
        iVar.hbo = 11;
        a search = ((n) com.tencent.mm.kernel.g.M(n.class)).search(3, iVar);
        AppMethodBeat.o(62074);
        return search;
    }

    public final k b(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        AppMethodBeat.i(62075);
        f fVar = new f(i);
        fVar.mKp = aVar.mFh;
        fVar.mEp = this.mEp;
        AppMethodBeat.o(62075);
        return fVar;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        int i2;
        AppMethodBeat.i(62076);
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (aVar.mFc) {
            i2 = (i - aVar.mFb) - 1;
        } else {
            i2 = i - aVar.mFb;
        }
        if (i2 >= 0 && i2 < aVar.mFf.size()) {
            l lVar = (l) aVar.mFf.get(i2);
            if (lVar.mDx.equals("no_result​")) {
                aVar2 = new com.tencent.mm.plugin.fts.ui.a.l(i);
            } else {
                com.tencent.mm.plugin.fts.a.d.a.a gVar = new com.tencent.mm.plugin.fts.ui.a.g(i);
                gVar.hpS = lVar;
                gVar.mDz = gVar.hpS.mDz;
                gVar.ej(lVar.type, lVar.mDw);
                aVar2 = gVar;
            }
        }
        AppMethodBeat.o(62076);
        return aVar2;
    }

    public final int bBl() {
        return this.showType;
    }
}
