package a.i.b.a.c.a;

import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.a;
import a.i.b.a.c.f.f;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class m {
    private static final Set<f> BcC;
    private static final HashMap<a, a> BcD = new HashMap();
    private static final HashMap<a, a> BcE = new HashMap();
    private static final Set<f> BcF;
    public static final m BcG = new m();

    static {
        int i = 0;
        AppMethodBeat.i(119123);
        l[] values = l.values();
        Collection arrayList = new ArrayList(values.length);
        for (l lVar : values) {
            arrayList.add(lVar.BbZ);
        }
        BcC = t.o((List) arrayList);
        values = l.values();
        arrayList = new LinkedHashSet();
        for (l lVar2 : values) {
            arrayList.add(lVar2.BcA.ByN.ByQ.ehK());
        }
        BcF = (Set) arrayList;
        l[] values2 = l.values();
        int length = values2.length;
        while (i < length) {
            l lVar3 = values2[i];
            BcD.put(lVar3.BcA, lVar3.BcB);
            BcE.put(lVar3.BcB, lVar3.BcA);
            i++;
        }
        AppMethodBeat.o(119123);
    }

    private m() {
    }

    public static boolean d(f fVar) {
        AppMethodBeat.i(119119);
        j.p(fVar, "name");
        boolean contains = BcF.contains(fVar);
        AppMethodBeat.o(119119);
        return contains;
    }

    public static a c(a aVar) {
        AppMethodBeat.i(119120);
        j.p(aVar, "arrayClassId");
        a aVar2 = (a) BcD.get(aVar);
        AppMethodBeat.o(119120);
        return aVar2;
    }

    public static a d(a aVar) {
        AppMethodBeat.i(119121);
        j.p(aVar, "arrayClassId");
        a aVar2 = (a) BcE.get(aVar);
        AppMethodBeat.o(119121);
        return aVar2;
    }

    public static boolean G(w wVar) {
        AppMethodBeat.i(119122);
        j.p(wVar, "type");
        if (av.ax(wVar)) {
            AppMethodBeat.o(119122);
            return false;
        }
        h dYs = wVar.ejw().dYs();
        if (dYs == null) {
            AppMethodBeat.o(119122);
            return false;
        }
        j.o(dYs, "type.constructor.declara…escriptor ?: return false");
        l lVar = dYs;
        j.p(lVar, "descriptor");
        l dXW = lVar.dXW();
        if ((dXW instanceof ab) && j.j(((ab) dXW).dZF(), g.AZV) && BcC.contains(lVar.dZg())) {
            AppMethodBeat.o(119122);
            return true;
        }
        AppMethodBeat.o(119122);
        return false;
    }
}
