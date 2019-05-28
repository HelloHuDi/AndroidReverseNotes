package a.i.b.a.c.e.a;

import a.a.l;
import a.a.m;
import a.f.b.j;
import a.i.b.a.c.e.a.aa;
import a.i.b.a.c.e.a.ag;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class h {
    private final List<aa> sBc;

    public h(ag agVar) {
        j.p(agVar, "typeTable");
        AppMethodBeat.i(121096);
        List list = agVar.BvM;
        if (agVar.efN()) {
            int i = agVar.BvN;
            List list2 = agVar.BvM;
            j.o(list2, "typeTable.typeList");
            Iterable iterable = list2;
            Collection arrayList = new ArrayList(m.d(iterable));
            int i2 = 0;
            for (Object next : iterable) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    l.dWs();
                }
                Object next2 = (aa) next2;
                if (i2 >= i) {
                    next2 = next2.efk().rN(true).efs();
                }
                arrayList.add(next2);
                i2 = i3;
            }
            list = (List) arrayList;
        } else {
            j.o(list, "originalTypes");
        }
        this.sBc = list;
        AppMethodBeat.o(121096);
    }

    public final aa Uk(int i) {
        AppMethodBeat.i(121095);
        aa aaVar = (aa) this.sBc.get(i);
        AppMethodBeat.o(121095);
        return aaVar;
    }
}
