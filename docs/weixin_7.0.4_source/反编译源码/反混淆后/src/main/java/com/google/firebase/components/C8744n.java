package com.google.firebase.components;

import com.google.firebase.p1372a.C25579a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.firebase.components.n */
public final class C8744n implements C45069b {
    private final List<C41645a<?>> bvc;
    private final Map<Class<?>, C31251p<?>> bvd = new HashMap();

    /* renamed from: x */
    public final Object mo19762x(Class cls) {
        AppMethodBeat.m2504i(10622);
        Object a = C41646c.m73018a(this, cls);
        AppMethodBeat.m2505o(10622);
        return a;
    }

    /* renamed from: z */
    public final <T> C25579a<T> mo19763z(Class<T> cls) {
        AppMethodBeat.m2504i(10620);
        C32092r.zza(cls, "Null interface requested.");
        C25579a c25579a = (C25579a) this.bvd.get(cls);
        AppMethodBeat.m2505o(10620);
        return c25579a;
    }

    public C8744n(Iterable<C41648e> iterable, C41645a<?>... c41645aArr) {
        C8745o c8745o;
        C8745o c8745o2;
        AppMethodBeat.m2504i(10619);
        ArrayList<C41645a> arrayList = new ArrayList();
        for (C41648e components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        Collections.addAll(arrayList, c41645aArr);
        HashMap hashMap = new HashMap(arrayList.size());
        for (C41645a c41645a : arrayList) {
            C8745o c8745o3 = new C8745o(c41645a);
            for (Class put : c41645a.buT) {
                if (hashMap.put(put, c8745o3) != null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{(Class) r7.next()}));
                    AppMethodBeat.m2505o(10619);
                    throw illegalArgumentException;
                }
            }
        }
        for (C8745o c8745o22 : hashMap.values()) {
            for (C25581f c25581f : c8745o22.bve.buU) {
                if (c25581f.mo43233uB()) {
                    c8745o = (C8745o) hashMap.get(c25581f.buW);
                    if (c8745o != null) {
                        c8745o22.bvf.add(c8745o);
                        c8745o.bvg.add(c8745o22);
                    }
                }
            }
        }
        HashSet<C8745o> hashSet = new HashSet(hashMap.values());
        HashSet hashSet2 = new HashSet();
        for (C8745o c8745o222 : hashSet) {
            if (c8745o222.mo19764uC()) {
                hashSet2.add(c8745o222);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        while (!hashSet2.isEmpty()) {
            c8745o222 = (C8745o) hashSet2.iterator().next();
            hashSet2.remove(c8745o222);
            arrayList2.add(c8745o222.bve);
            for (C8745o c8745o4 : c8745o222.bvf) {
                c8745o4.bvg.remove(c8745o222);
                if (c8745o4.mo19764uC()) {
                    hashSet2.add(c8745o4);
                }
            }
        }
        if (arrayList2.size() == arrayList.size()) {
            Collections.reverse(arrayList2);
            this.bvc = Collections.unmodifiableList(arrayList2);
            for (C41645a c41645a2 : this.bvc) {
                C31251p c31251p = new C31251p(c41645a2.buV, new C37303s(c41645a2.buU, this));
                for (Class put2 : c41645a2.buT) {
                    this.bvd.put(put2, c31251p);
                }
            }
            for (C41645a c41645a22 : this.bvc) {
                for (C25581f c25581f2 : c41645a22.buU) {
                    int i;
                    if (c25581f2.buX == 1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0 && !this.bvd.containsKey(c25581f2.buW)) {
                        C25583i c25583i = new C25583i(String.format("Unsatisfied dependency for component %s: %s", new Object[]{c41645a22, c25581f2.buW}));
                        AppMethodBeat.m2505o(10619);
                        throw c25583i;
                    }
                }
            }
            AppMethodBeat.m2505o(10619);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (C8745o c8745o2222 : hashSet) {
            if (!(c8745o2222.mo19764uC() || c8745o2222.bvf.isEmpty())) {
                arrayList3.add(c8745o2222.bve);
            }
        }
        C25582g c25582g = new C25582g(arrayList3);
        AppMethodBeat.m2505o(10619);
        throw c25582g;
    }

    /* renamed from: aS */
    public final void mo19761aS(boolean z) {
        AppMethodBeat.m2504i(10621);
        for (C41645a c41645a : this.bvc) {
            if (c41645a.mo67048uy() || (c41645a.mo67049uz() && z)) {
                C41646c.m73018a(this, (Class) c41645a.buT.iterator().next());
            }
        }
        AppMethodBeat.m2505o(10621);
    }
}
