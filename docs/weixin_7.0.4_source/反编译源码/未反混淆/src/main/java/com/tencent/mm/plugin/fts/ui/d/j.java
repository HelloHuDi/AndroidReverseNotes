package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class j extends k {
    public j(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62085);
        this.mLK = false;
        i iVar = new i();
        iVar.query = this.query;
        iVar.mEu = hashSet;
        iVar.mEw = this;
        iVar.handler = akVar;
        a search = ((n) g.M(n.class)).search(3, iVar);
        AppMethodBeat.o(62085);
        return search;
    }

    public final void a(com.tencent.mm.plugin.fts.a.a.j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62086);
        List list = jVar.mEy;
        if (com.tencent.mm.plugin.fts.a.d.b.bX(list)) {
            if (list.size() > 0) {
                l lVar = (l) list.get(0);
                if (lVar.mDx.equals("create_talker_message​")) {
                    e.a aVar = new e.a();
                    aVar.mFc = false;
                    aVar.mFf = new ArrayList();
                    aVar.mFf.add(lVar);
                    aVar.mDz = jVar.mDz;
                    aVar.businessType = -2;
                    this.mHp.add(aVar);
                    list.remove(0);
                }
            }
            e.a aVar2 = new e.a();
            aVar2.businessType = -2;
            aVar2.mDz = jVar.mDz;
            if (list.size() == 0) {
                aVar2.mFc = false;
                l lVar2 = new l();
                lVar2.mDx = "no_result​";
                aVar2.mFf = new ArrayList();
                aVar2.mFf.add(lVar2);
            } else {
                aVar2.mFf = list;
            }
            this.mHp.add(aVar2);
        }
        AppMethodBeat.o(62086);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        int i2;
        AppMethodBeat.i(62087);
        int i3 = i - aVar.mFb;
        if (aVar.mFc) {
            i2 = i3 - 1;
        } else {
            i2 = i3;
        }
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.mFf.size() && i2 >= 0) {
            l lVar = (l) aVar.mFf.get(i2);
            if (lVar.mDx.equals("create_talker_message​")) {
                aVar2 = new com.tencent.mm.plugin.fts.ui.a.i(i);
                aVar2.mFk = false;
                this.mLK = true;
            } else if (lVar.mDx.equals("no_result​")) {
                aVar2 = new com.tencent.mm.plugin.fts.ui.a.l(i);
            } else {
                com.tencent.mm.plugin.fts.a.d.a.a mVar = new m(i);
                mVar.hpS = lVar;
                mVar.ej(lVar.type, lVar.mDw);
                aVar2 = mVar;
            }
        }
        if (aVar2 != null) {
            aVar2.mFn = i2 + 1;
            aVar2.mDz = aVar.mDz;
        }
        AppMethodBeat.o(62087);
        return aVar2;
    }

    public final int getType() {
        return 4176;
    }
}
