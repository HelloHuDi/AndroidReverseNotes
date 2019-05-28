package com.tencent.mm.az;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.tb;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a implements g {
    SparseArray<LinkedList<com.tencent.mm.plugin.messenger.foundation.a.a.g.a>> fLo = new SparseArray();

    public a() {
        AppMethodBeat.i(984);
        AppMethodBeat.o(984);
    }

    public final void a(final b bVar) {
        AppMethodBeat.i(985);
        if (com.tencent.mm.kernel.g.RO().eJo == null || com.tencent.mm.kernel.g.RO().eJo.ftA == null) {
            AppMethodBeat.o(985);
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(bVar);
        b bVar2 = new b(arrayList);
        com.tencent.mm.kernel.g.RQ();
        bVar2.a(com.tencent.mm.kernel.g.RO().eJo.ftA, new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                int i3 = -1;
                AppMethodBeat.i(983);
                if (mVar.getType() != 681) {
                    AppMethodBeat.o(983);
                } else if (((b) mVar).fLr == null) {
                    AppMethodBeat.o(983);
                } else {
                    bhr bhr = ((b) mVar).fLr.fLu.fLw;
                    int i4 = ((tb) ((b) ((b) mVar).fLr.acF()).fLv.wIw.jBw.getLast()).wat;
                    List<com.tencent.mm.plugin.messenger.foundation.a.a.g.a> list;
                    if (bhr == null || bhr.wKS == null || bhr.wKS.wof == null) {
                        list = (List) a.this.fLo.get(i4);
                        if (list != null) {
                            for (com.tencent.mm.plugin.messenger.foundation.a.a.g.a a : list) {
                                a.a(-1, bVar);
                            }
                        }
                        AppMethodBeat.o(983);
                        return;
                    }
                    if (bhr.wKS.wof.size() > 0) {
                        i3 = ((Integer) bhr.wKS.wof.getLast()).intValue();
                    }
                    if (bhr.wKS.wKT.size() > 0) {
                        bhr.wKS.wKT.getLast();
                    }
                    if (bhr.wKS.wKT.size() > 0) {
                        bhr.wKS.wKT.getLast();
                    }
                    list = (List) a.this.fLo.get(i4);
                    if (list != null) {
                        for (com.tencent.mm.plugin.messenger.foundation.a.a.g.a a2 : list) {
                            a2.a(i3, bVar);
                        }
                    }
                    AppMethodBeat.o(983);
                }
            }
        });
        AppMethodBeat.o(985);
    }

    public final void a(int i, com.tencent.mm.plugin.messenger.foundation.a.a.g.a aVar) {
        AppMethodBeat.i(986);
        if (this.fLo.indexOfKey(i) < 0) {
            this.fLo.put(i, new LinkedList());
        }
        ((LinkedList) this.fLo.get(i)).add(aVar);
        AppMethodBeat.o(986);
    }

    public final void b(int i, com.tencent.mm.plugin.messenger.foundation.a.a.g.a aVar) {
        AppMethodBeat.i(987);
        if (this.fLo.indexOfKey(i) >= 0) {
            ((LinkedList) this.fLo.get(i)).remove(aVar);
        }
        AppMethodBeat.o(987);
    }
}
