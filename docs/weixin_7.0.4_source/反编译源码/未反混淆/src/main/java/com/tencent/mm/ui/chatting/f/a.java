package com.tencent.mm.ui.chatting.f;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.f.d.b;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.l.e;
import java.util.LinkedList;
import java.util.List;

public final class a implements c<bi> {
    private SparseArray<bi> yYk;

    public a(SparseArray<bi> sparseArray) {
        this.yYk = sparseArray;
    }

    public final void a(com.tencent.mm.ui.chatting.f.d.a aVar, e<bi> eVar, d<bi> dVar, b bVar) {
        AppMethodBeat.i(32477);
        com.tencent.mm.ui.chatting.j.a aVar2 = com.tencent.mm.ui.chatting.j.a.yZE;
        int[] iArr;
        switch (com.tencent.mm.ui.chatting.j.a.AnonymousClass1.yZG[dVar.yYA.ordinal()]) {
            case 1:
                iArr = aVar2.yZF;
                iArr[0] = iArr[0] + 1;
                break;
            case 2:
                iArr = aVar2.yZF;
                iArr[1] = iArr[1] + 1;
                break;
            case 3:
                iArr = aVar2.yZF;
                iArr[2] = iArr[2] + 1;
                break;
            case 4:
                if (dVar.yYz != null && dVar.yYz.getInt("SCENE") == 1) {
                    iArr = aVar2.yZF;
                    iArr[3] = iArr[3] + 1;
                    break;
                }
                iArr = aVar2.yZF;
                iArr[4] = iArr[4] + 1;
                break;
                break;
        }
        if (eVar == null) {
            ab.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
            bVar.dY();
            AppMethodBeat.o(32477);
            return;
        }
        final e<bi> eVar2 = eVar;
        final d<bi> dVar2 = dVar;
        final com.tencent.mm.ui.chatting.f.d.a aVar3 = aVar;
        final b bVar2 = bVar;
        eVar.a(new b() {
            public final void dY() {
                AppMethodBeat.i(32476);
                eVar2.fk(dVar2.yYB);
                eVar2.close();
                dVar2.enb = eVar2.dCP();
                dVar2.yYC = dVar2.yYB.size();
                ab.i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + aVar3 + " addCount:" + dVar2.yYC + " totalCount:" + dVar2.enb);
                bVar2.dY();
                AppMethodBeat.o(32476);
            }
        });
        AppMethodBeat.o(32477);
    }

    public final SparseArray<bi> fd(List<bi> list) {
        AppMethodBeat.i(32478);
        if (list == null) {
            List list2 = new LinkedList();
            ab.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[fillData] list is null!");
        }
        this.yYk.clear();
        int i = 0;
        for (Object put : list2) {
            this.yYk.put(i, put);
            i++;
        }
        SparseArray sparseArray = this.yYk;
        AppMethodBeat.o(32478);
        return sparseArray;
    }
}
