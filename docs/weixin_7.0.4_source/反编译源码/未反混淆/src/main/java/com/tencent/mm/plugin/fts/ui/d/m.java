package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashSet;

public final class m extends a {
    private boolean mLJ = false;

    public m(Context context, b bVar, int i) {
        boolean z;
        super(context, bVar, i);
        AppMethodBeat.i(62099);
        String str = (String) g.RP().Ry().get(6, null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.mLJ = z;
        this.mLJ &= bo.gT(context);
        AppMethodBeat.o(62099);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        int[] iArr;
        AppMethodBeat.i(62100);
        i iVar = new i();
        if (this.mLJ) {
            iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131073, 131074, 262144, 131076};
        } else {
            iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 262144, 131076};
        }
        iVar.mEr = iArr;
        iVar.mEt = 3;
        iVar.mEw = this;
        iVar.handler = akVar;
        iVar.scene = 0;
        iVar.mEu = hashSet;
        com.tencent.mm.plugin.fts.a.a.a search;
        if (this.query.startsWith("@@")) {
            iVar.query = this.query.substring(2);
            search = ((n) g.M(n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, iVar);
            AppMethodBeat.o(62100);
            return search;
        }
        iVar.query = this.query;
        search = ((n) g.M(n.class)).search(1, iVar);
        AppMethodBeat.o(62100);
        return search;
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62101);
        for (l lVar : jVar.mEy) {
            hashSet.add(lVar.mDx);
        }
        if (com.tencent.mm.plugin.fts.a.d.b.bX(jVar.mEy)) {
            e.a aVar = new e.a();
            aVar.businessType = -8;
            aVar.mFf = com.tencent.mm.plugin.fts.a.d.b.bY(jVar.mEy);
            aVar.mFe = false;
            aVar.mDz = jVar.mDz;
            this.mHp.add(aVar);
        }
        d.bW(jVar.mEy);
        AppMethodBeat.o(62101);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, e.a aVar) {
        com.tencent.mm.plugin.fts.a.d.a.a a;
        AppMethodBeat.i(62102);
        int i2 = (i - aVar.mFb) - 1;
        if (i2 < aVar.mFf.size() && i2 >= 0) {
            l lVar = (l) aVar.mFf.get(i2);
            a aVar2 = lVar.type == 131075 ? (a) ((n) g.M(n.class)).createFTSUIUnit(48, this.context, this.mEZ, this.mFa) : (lVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || lVar.type == 131073 || lVar.type == 131074) ? (a) ((n) g.M(n.class)).createFTSUIUnit(32, this.context, this.mEZ, this.mFa) : lVar.type == 262144 ? (a) ((n) g.M(n.class)).createFTSUIUnit(64, this.context, this.mEZ, this.mFa) : lVar.type == 131076 ? (a) ((n) g.M(n.class)).createFTSUIUnit(96, this.context, this.mEZ, this.mFa) : null;
            if (aVar2 != null) {
                a = aVar2.a(lVar.type, i, lVar, aVar);
                if (a != null) {
                    a.mFn = i2 + 1;
                }
                AppMethodBeat.o(62102);
                return a;
            }
        }
        a = null;
        if (a != null) {
        }
        AppMethodBeat.o(62102);
        return a;
    }

    public final int getType() {
        return 16;
    }
}
