package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class n implements b {
    private final List<a<?>> bvc;
    private final Map<Class<?>, p<?>> bvd = new HashMap();

    public final Object x(Class cls) {
        AppMethodBeat.i(10622);
        Object a = c.a(this, cls);
        AppMethodBeat.o(10622);
        return a;
    }

    public final <T> a<T> z(Class<T> cls) {
        AppMethodBeat.i(10620);
        r.zza(cls, "Null interface requested.");
        a aVar = (a) this.bvd.get(cls);
        AppMethodBeat.o(10620);
        return aVar;
    }

    public n(Iterable<e> iterable, a<?>... aVarArr) {
        o oVar;
        o oVar2;
        AppMethodBeat.i(10619);
        ArrayList<a> arrayList = new ArrayList();
        for (e components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        Collections.addAll(arrayList, aVarArr);
        HashMap hashMap = new HashMap(arrayList.size());
        for (a aVar : arrayList) {
            o oVar3 = new o(aVar);
            for (Class put : aVar.buT) {
                if (hashMap.put(put, oVar3) != null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{(Class) r7.next()}));
                    AppMethodBeat.o(10619);
                    throw illegalArgumentException;
                }
            }
        }
        for (o oVar22 : hashMap.values()) {
            for (f fVar : oVar22.bve.buU) {
                if (fVar.uB()) {
                    oVar = (o) hashMap.get(fVar.buW);
                    if (oVar != null) {
                        oVar22.bvf.add(oVar);
                        oVar.bvg.add(oVar22);
                    }
                }
            }
        }
        HashSet<o> hashSet = new HashSet(hashMap.values());
        HashSet hashSet2 = new HashSet();
        for (o oVar222 : hashSet) {
            if (oVar222.uC()) {
                hashSet2.add(oVar222);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        while (!hashSet2.isEmpty()) {
            oVar222 = (o) hashSet2.iterator().next();
            hashSet2.remove(oVar222);
            arrayList2.add(oVar222.bve);
            for (o oVar4 : oVar222.bvf) {
                oVar4.bvg.remove(oVar222);
                if (oVar4.uC()) {
                    hashSet2.add(oVar4);
                }
            }
        }
        if (arrayList2.size() == arrayList.size()) {
            Collections.reverse(arrayList2);
            this.bvc = Collections.unmodifiableList(arrayList2);
            for (a aVar2 : this.bvc) {
                p pVar = new p(aVar2.buV, new s(aVar2.buU, this));
                for (Class put2 : aVar2.buT) {
                    this.bvd.put(put2, pVar);
                }
            }
            for (a aVar22 : this.bvc) {
                for (f fVar2 : aVar22.buU) {
                    int i;
                    if (fVar2.buX == 1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0 && !this.bvd.containsKey(fVar2.buW)) {
                        i iVar = new i(String.format("Unsatisfied dependency for component %s: %s", new Object[]{aVar22, fVar2.buW}));
                        AppMethodBeat.o(10619);
                        throw iVar;
                    }
                }
            }
            AppMethodBeat.o(10619);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (o oVar2222 : hashSet) {
            if (!(oVar2222.uC() || oVar2222.bvf.isEmpty())) {
                arrayList3.add(oVar2222.bve);
            }
        }
        g gVar = new g(arrayList3);
        AppMethodBeat.o(10619);
        throw gVar;
    }

    public final void aS(boolean z) {
        AppMethodBeat.i(10621);
        for (a aVar : this.bvc) {
            if (aVar.uy() || (aVar.uz() && z)) {
                c.a(this, (Class) aVar.buT.iterator().next());
            }
        }
        AppMethodBeat.o(10621);
    }
}
