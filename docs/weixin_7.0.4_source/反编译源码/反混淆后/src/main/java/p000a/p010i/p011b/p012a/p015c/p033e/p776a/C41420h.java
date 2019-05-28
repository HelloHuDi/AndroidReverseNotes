package p000a.p010i.p011b.p012a.p015c.p033e.p776a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C25034m;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C25133aa;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C36999ag;

/* renamed from: a.i.b.a.c.e.a.h */
public final class C41420h {
    private final List<C25133aa> sBc;

    public C41420h(C36999ag c36999ag) {
        C25052j.m39376p(c36999ag, "typeTable");
        AppMethodBeat.m2504i(121096);
        List list = c36999ag.BvM;
        if (c36999ag.efN()) {
            int i = c36999ag.BvN;
            List list2 = c36999ag.BvM;
            C25052j.m39375o(list2, "typeTable.typeList");
            Iterable iterable = list2;
            Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
            int i2 = 0;
            for (Object next : iterable) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    C7987l.dWs();
                }
                Object next2 = (C25133aa) next2;
                if (i2 >= i) {
                    next2 = next2.efk().mo42001rN(true).efs();
                }
                arrayList.add(next2);
                i2 = i3;
            }
            list = (List) arrayList;
        } else {
            C25052j.m39375o(list, "originalTypes");
        }
        this.sBc = list;
        AppMethodBeat.m2505o(121096);
    }

    /* renamed from: Uk */
    public final C25133aa mo66063Uk(int i) {
        AppMethodBeat.m2504i(121095);
        C25133aa c25133aa = (C25133aa) this.sBc.get(i);
        AppMethodBeat.m2505o(121095);
        return c25133aa;
    }
}
