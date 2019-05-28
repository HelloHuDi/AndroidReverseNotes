package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.c;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.plugin.fts.ui.a.o;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class l extends k {
    public String mEq;

    public l(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_6;
    }

    public a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62092);
        this.mLK = false;
        i iVar = new i();
        iVar.query = this.query;
        iVar.mEv = e.mEY;
        iVar.mEq = this.mEq;
        iVar.mEw = this;
        iVar.handler = akVar;
        iVar.hbo = 10;
        a search = ((n) g.M(n.class)).search(3, iVar);
        AppMethodBeat.o(62092);
        return search;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62093);
        switch (jVar.bFZ) {
            case 0:
                if (jVar.mEy.size() <= 0) {
                    com.tencent.mm.plugin.fts.a.d.e.a aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
                    aVar.businessType = -2;
                    aVar.mDz = jVar.mDz;
                    aVar.mFc = false;
                    com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
                    lVar.mDx = "no_result​";
                    aVar.mFf = new ArrayList();
                    aVar.mFf.add(lVar);
                    this.mHp.add(aVar);
                    break;
                }
                int i = 0;
                while (i < jVar.mEy.size()) {
                    com.tencent.mm.plugin.fts.a.d.e.a aVar2 = new com.tencent.mm.plugin.fts.a.d.e.a();
                    aVar2.mFc = true;
                    aVar2.mFh = (com.tencent.mm.plugin.fts.a.a.l) jVar.mEy.get(i);
                    aVar2.mDz = jVar.mDz;
                    aVar2.mFf = (List) aVar2.mFh.userData;
                    if (aVar2.mFf.size() <= 3 || i == jVar.mEy.size() - 1) {
                        aVar2.mFg = false;
                        aVar2.mFe = false;
                    } else {
                        aVar2.mFg = true;
                        aVar2.mFe = true;
                    }
                    this.mHp.add(aVar2);
                    i++;
                }
                AppMethodBeat.o(62093);
                return;
                break;
        }
        AppMethodBeat.o(62093);
    }

    public k b(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        AppMethodBeat.i(62095);
        o oVar = new o(i);
        oVar.mKp = aVar.mFh;
        oVar.mDz = oVar.mKp.mDz;
        AppMethodBeat.o(62095);
        return oVar;
    }

    public final com.tencent.mm.plugin.fts.ui.a.n c(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        AppMethodBeat.i(62096);
        c cVar = new c(i);
        cVar.resId = R.string.c1r;
        cVar.mJY = aVar.mFg;
        AppMethodBeat.o(62096);
        return cVar;
    }

    public com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        int i2;
        AppMethodBeat.i(62097);
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (aVar.mFc) {
            i2 = (i - aVar.mFb) - 1;
        } else {
            i2 = i - aVar.mFb;
        }
        if (i2 >= 0 && i2 < aVar.mFf.size()) {
            com.tencent.mm.plugin.fts.a.a.l lVar = (com.tencent.mm.plugin.fts.a.a.l) aVar.mFf.get(i2);
            if (lVar.mDx.equals("no_result​")) {
                aVar2 = new com.tencent.mm.plugin.fts.ui.a.l(i);
            } else {
                com.tencent.mm.plugin.fts.a.d.a.a pVar = new p(i);
                pVar.hpS = lVar;
                pVar.mKp = aVar.mFh;
                pVar.mDz = pVar.hpS.mDz;
                pVar.mFl = -14;
                pVar.showType = 2;
                pVar.ej(lVar.type, lVar.mDw);
                aVar2 = pVar;
            }
        }
        AppMethodBeat.o(62097);
        return aVar2;
    }

    public final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(62098);
        super.a(view, aVar, z);
        if (aVar instanceof c) {
            int i = 0;
            while (i < this.mHp.size()) {
                com.tencent.mm.plugin.fts.a.d.e.a aVar2 = (com.tencent.mm.plugin.fts.a.d.e.a) this.mHp.get(i);
                if (aVar2.mFd == aVar.position) {
                    if (!aVar2.mFg) {
                        z2 = true;
                    }
                    aVar2.mFg = z2;
                } else {
                    i++;
                }
            }
        }
        AppMethodBeat.o(62098);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public int bBl() {
        return 2;
    }

    public final int vY(int i) {
        AppMethodBeat.i(62094);
        int size = this.mHp.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.mm.plugin.fts.a.d.e.a aVar = (com.tencent.mm.plugin.fts.a.d.e.a) this.mHp.get(i3);
            aVar.mFb = i2;
            if (aVar.mFc) {
                i2++;
            }
            if (aVar.mFf.size() > 3) {
                if (aVar.mFg) {
                    i2 += 3;
                } else {
                    i2 += aVar.mFf.size();
                }
                aVar.mFd = i2;
                if (aVar.mFe) {
                    i2++;
                }
            } else {
                i2 += aVar.mFf.size();
                aVar.mFd = i2;
            }
        }
        AppMethodBeat.o(62094);
        return i2;
    }
}
