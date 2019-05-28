package com.tencent.mm.plugin.appbrand.f;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.List;

public final class h extends a {
    public h(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(129980);
        i iVar = new i();
        iVar.query = this.query;
        iVar.mEv = d.mEX;
        iVar.mEw = this;
        iVar.handler = akVar;
        iVar.mEu = hashSet;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(7, iVar);
        AppMethodBeat.o(129980);
        return search;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(129981);
        List list = jVar.mEy;
        if (!(list == null || list.isEmpty())) {
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            String str = this.query;
            if (str != null) {
                str = str.replaceAll(",", " ");
            }
            dVar.l("20KeyWordId", str + ",");
            dVar.l("21ViewType", "1,");
            dVar.l("22OpType", "1,");
            dVar.l("23ResultCount", list.size() + ",");
            dVar.l("24ClickPos", ",");
            dVar.l("25ClickAppUserName", ",");
            ab.i("MicroMsg.FTSWeAppUIUnit", "report oreh LocalSearchWeApp(13963), %s", dVar.Fk());
            com.tencent.mm.plugin.report.service.h.pYm.e(13963, dVar);
        }
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            e.a aVar = new e.a();
            aVar.businessType = -13;
            aVar.mFf = jVar.mEy;
            aVar.mDz = jVar.mDz;
            if (aVar.mFf.size() > 3) {
                aVar.mFe = true;
                aVar.mFf = aVar.mFf.subList(0, 3);
            }
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(129981);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        AppMethodBeat.i(129982);
        int i2 = (i - aVar.mFb) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.mFf.size() && i2 >= 0) {
            l lVar = (l) aVar.mFf.get(i2);
            com.tencent.mm.plugin.fts.a.d.a.a dVar = new d(i);
            dVar.hpS = lVar;
            dVar.mDz = aVar.mDz;
            dVar.ej(lVar.type, lVar.mDw);
            aVar2 = dVar;
        }
        if (aVar2 != null) {
            aVar2.mFn = i2 + 1;
        }
        AppMethodBeat.o(129982);
        return aVar2;
    }

    public final int getType() {
        return 144;
    }
}
