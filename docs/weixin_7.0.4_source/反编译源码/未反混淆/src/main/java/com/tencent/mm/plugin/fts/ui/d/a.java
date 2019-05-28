package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a extends com.tencent.mm.plugin.fts.ui.a {
    private boolean mLJ;

    public a(Context context, b bVar, int i) {
        boolean z;
        super(context, bVar, i);
        AppMethodBeat.i(62051);
        String str = (String) g.RP().Ry().get(6, null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.mLJ = z;
        ab.d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s]", Boolean.valueOf(this.mLJ));
        AppMethodBeat.o(62051);
    }

    private int[] bBk() {
        AppMethodBeat.i(62053);
        ArrayList arrayList = new ArrayList();
        if (this.mLJ) {
            arrayList.add(Integer.valueOf(16));
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                i = i2 + 1;
            } else {
                AppMethodBeat.o(62053);
                return iArr;
            }
        }
    }

    public final void a(j jVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62054);
        List list = jVar.mEy;
        this.mHp.clear();
        com.tencent.mm.plugin.fts.a.d.e.a aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
        aVar.businessType = -4;
        aVar.mFc = false;
        aVar.mFi = 1;
        aVar.mDz = jVar.mDz;
        aVar.mFf = new LinkedList();
        this.mHp.add(aVar);
        if (com.tencent.mm.plugin.fts.a.d.b.bX(list)) {
            list = d.a(list, c.mCq);
            if (com.tencent.mm.plugin.fts.a.d.b.bX(list)) {
                aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
                aVar.businessType = -11;
                aVar.mFf = list;
                aVar.mDz = jVar.mDz;
                this.mHp.add(aVar);
            }
        }
        AppMethodBeat.o(62054);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        AppMethodBeat.i(62055);
        int i2 = (i - aVar.mFb) - 1;
        com.tencent.mm.plugin.fts.a.d.a.a aVar2 = null;
        if (i2 < aVar.mFf.size() && i2 >= 0) {
            com.tencent.mm.plugin.fts.a.d.a.a a;
            l lVar = (l) aVar.mFf.get(i2);
            if (lVar.type == 131073 || lVar.type == 131074) {
                a = ((com.tencent.mm.plugin.fts.ui.a) ((n) g.M(n.class)).createFTSUIUnit(33, this.context, this.mEZ, this.mFa)).a(lVar.type, i, lVar, aVar);
            } else {
                a = null;
            }
            aVar2 = a;
        } else if (!aVar.mFc && i == 0) {
            aVar2 = new com.tencent.mm.plugin.fts.ui.a.a(i);
            aVar2.mDz = aVar.mDz;
        }
        if (aVar2 != null) {
            aVar2.mFn = i2 + 1;
        }
        AppMethodBeat.o(62055);
        return aVar2;
    }

    public final int getType() {
        return Utility.DEFAULT_STREAM_BUFFER_SIZE;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(ak akVar, HashSet<String> hashSet) {
        AppMethodBeat.i(62052);
        String str = this.query;
        ArrayList arrayList = new ArrayList();
        if (this.mLJ) {
            arrayList.add(Integer.valueOf(131073));
            arrayList.add(Integer.valueOf(131074));
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                i = i2 + 1;
            } else {
                com.tencent.mm.plugin.fts.a.a.a search = ((n) g.M(n.class)).search(9, i.a(str, iArr, bBk(), -1, hashSet, com.tencent.mm.plugin.fts.a.c.b.mEV, this, akVar));
                AppMethodBeat.o(62052);
                return search;
            }
        }
    }
}
