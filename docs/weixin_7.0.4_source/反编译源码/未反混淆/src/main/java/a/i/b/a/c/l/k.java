package a.i.b.a.c.l;

import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.c.ah;
import a.i.b.a.c.b.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;

public final class k {
    public static au a(List<ar> list, as asVar, l lVar, List<ar> list2) {
        AppMethodBeat.i(122517);
        au a = a(list, asVar, lVar, list2, null);
        if (a == null) {
            AssertionError assertionError = new AssertionError("Substitution failed");
            AppMethodBeat.o(122517);
            throw assertionError;
        }
        AppMethodBeat.o(122517);
        return a;
    }

    public static au a(List<ar> list, as asVar, l lVar, List<ar> list2, boolean[] zArr) {
        AppMethodBeat.i(122518);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i = 0;
        for (ar arVar : list) {
            int i2 = i + 1;
            ah a = ah.a(lVar, arVar.dYn(), arVar.dZi(), arVar.dZh(), arVar.dZg(), i, am.BeR);
            hashMap.put(arVar.dXY(), new ar(a.dZf()));
            hashMap2.put(arVar, a);
            list2.add(a);
            i = i2;
        }
        au b = au.b(asVar, ao.be(hashMap));
        for (ar arVar2 : list) {
            ah ahVar = (ah) hashMap2.get(arVar2);
            for (w wVar : arVar2.dWP()) {
                w c = b.c(wVar, ba.IN_VARIANCE);
                if (c == null) {
                    AppMethodBeat.o(122518);
                    return null;
                }
                if (!(c == wVar || zArr == null)) {
                    zArr[0] = true;
                }
                ahVar.L(c);
            }
            ahVar.setInitialized();
        }
        AppMethodBeat.o(122518);
        return b;
    }
}
