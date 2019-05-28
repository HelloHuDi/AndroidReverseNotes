package com.tencent.p177mm.p201az;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p201az.C32323b.C17966b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6976g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6976g.C3456a;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.bhr;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.az.a */
public final class C9062a implements C6976g {
    SparseArray<LinkedList<C3456a>> fLo = new SparseArray();

    public C9062a() {
        AppMethodBeat.m2504i(984);
        AppMethodBeat.m2505o(984);
    }

    /* renamed from: a */
    public final void mo15236a(final C3463b c3463b) {
        AppMethodBeat.m2504i(985);
        if (C1720g.m3535RO().eJo == null || C1720g.m3535RO().eJo.ftA == null) {
            AppMethodBeat.m2505o(985);
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(c3463b);
        C32323b c32323b = new C32323b(arrayList);
        C1720g.m3537RQ();
        c32323b.mo4456a(C1720g.m3535RO().eJo.ftA, new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                int i3 = -1;
                AppMethodBeat.m2504i(983);
                if (c1207m.getType() != 681) {
                    AppMethodBeat.m2505o(983);
                } else if (((C32323b) c1207m).fLr == null) {
                    AppMethodBeat.m2505o(983);
                } else {
                    bhr bhr = ((C32323b) c1207m).fLr.fLu.fLw;
                    int i4 = ((C40573tb) ((C17966b) ((C32323b) c1207m).fLr.acF()).fLv.wIw.jBw.getLast()).wat;
                    List<C3456a> list;
                    if (bhr == null || bhr.wKS == null || bhr.wKS.wof == null) {
                        list = (List) C9062a.this.fLo.get(i4);
                        if (list != null) {
                            for (C3456a a : list) {
                                a.mo7912a(-1, c3463b);
                            }
                        }
                        AppMethodBeat.m2505o(983);
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
                    list = (List) C9062a.this.fLo.get(i4);
                    if (list != null) {
                        for (C3456a a2 : list) {
                            a2.mo7912a(i3, c3463b);
                        }
                    }
                    AppMethodBeat.m2505o(983);
                }
            }
        });
        AppMethodBeat.m2505o(985);
    }

    /* renamed from: a */
    public final void mo15235a(int i, C3456a c3456a) {
        AppMethodBeat.m2504i(986);
        if (this.fLo.indexOfKey(i) < 0) {
            this.fLo.put(i, new LinkedList());
        }
        ((LinkedList) this.fLo.get(i)).add(c3456a);
        AppMethodBeat.m2505o(986);
    }

    /* renamed from: b */
    public final void mo15237b(int i, C3456a c3456a) {
        AppMethodBeat.m2504i(987);
        if (this.fLo.indexOfKey(i) >= 0) {
            ((LinkedList) this.fLo.get(i)).remove(c3456a);
        }
        AppMethodBeat.m2505o(987);
    }
}
