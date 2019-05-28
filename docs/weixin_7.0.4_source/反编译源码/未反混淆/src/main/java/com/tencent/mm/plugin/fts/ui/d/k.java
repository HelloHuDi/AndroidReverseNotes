package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public class k extends a {
    protected boolean mLK = false;

    public k(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62088);
        this.mLK = false;
        i iVar = new i();
        iVar.query = this.query;
        iVar.mEu = hashSet;
        iVar.mEw = this;
        iVar.handler = akVar;
        iVar.hbo = 1;
        iVar.mEt = 3;
        com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(3, iVar);
        AppMethodBeat.o(62088);
        return search;
    }

    public void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62089);
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            e.a aVar = new e.a();
            aVar.businessType = -2;
            aVar.mDz = jVar.mDz;
            aVar.mFf = jVar.mEy;
            if (aVar.mFf.size() > 3) {
                if (((l) jVar.mEy.get(3)).mDx.equals("create_talker_message​")) {
                    aVar.mFe = false;
                    aVar.mFf = aVar.mFf.subList(0, 4);
                } else {
                    aVar.mFe = true;
                    aVar.mFf = aVar.mFf.subList(0, 3);
                }
            } else if (jVar.mEy.size() == 1 && ((l) jVar.mEy.get(0)).mDx.equals("create_talker_message​")) {
                aVar.mFc = false;
            }
            this.mHp.add(aVar);
        }
        AppMethodBeat.o(62089);
    }

    public com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        int i2;
        AppMethodBeat.i(62090);
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
                com.tencent.mm.plugin.fts.a.d.a.a iVar = new com.tencent.mm.plugin.fts.ui.a.i(i);
                iVar.mKF = aVar.mFf.size() == 1;
                this.mLK = true;
                aVar2 = iVar;
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
        AppMethodBeat.o(62090);
        return aVar2;
    }

    public int getType() {
        return 112;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        AppMethodBeat.i(62091);
        if (aVar instanceof m) {
            int bBl = bBl();
            boolean z2 = this.mLK;
            if (aVar.mFr == 65536) {
                switch (aVar.pageType) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        bBl = aVar.pageType;
                    case 5:
                        if (bBl == 1) {
                            bBl = 6;
                        } else if (bBl == 2) {
                            bBl = 5;
                        }
                        break;
                }
                String str = "%s,%s,%s";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(aVar.bAw());
                objArr[1] = Integer.valueOf(bBl);
                if (z2) {
                    bBl = 1;
                } else {
                    bBl = 0;
                }
                objArr[2] = Integer.valueOf(bBl);
                ab.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", Integer.valueOf(14756), String.format(str, objArr));
                h.pYm.X(14756, r0);
            }
        }
        AppMethodBeat.o(62091);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public int bBl() {
        return 0;
    }
}
