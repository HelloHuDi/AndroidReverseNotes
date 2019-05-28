package com.tencent.p177mm.plugin.appbrand.p328r;

import android.support.p057v4.p065f.C6197a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.r.i */
public final class C27277i<K, V> {
    private final Map<K, Set<V>> iQZ = new C6197a();

    public C27277i() {
        AppMethodBeat.m2504i(91165);
        AppMethodBeat.m2505o(91165);
    }

    /* renamed from: f */
    public final void mo44963f(K k, V v) {
        AppMethodBeat.m2504i(91166);
        if (k == null || v == null) {
            AppMethodBeat.m2505o(91166);
            return;
        }
        Set b = mo44960b(k, true);
        synchronized (b) {
            try {
                b.add(v);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(91166);
            }
        }
    }

    /* renamed from: b */
    public final Set<V> mo44960b(K k, boolean z) {
        Set<V> set;
        AppMethodBeat.m2504i(91167);
        synchronized (this.iQZ) {
            try {
                set = (Set) this.iQZ.get(k);
                if (set == null && z) {
                    set = new HashSet();
                    this.iQZ.put(k, set);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(91167);
            }
        }
        return set;
    }

    /* renamed from: bC */
    public final Set<V> mo44961bC(K k) {
        AppMethodBeat.m2504i(91168);
        if (k == null) {
            AppMethodBeat.m2505o(91168);
            return null;
        }
        Set b = mo44960b(k, false);
        Set<V> emptySet;
        if (b == null) {
            emptySet = Collections.emptySet();
            AppMethodBeat.m2505o(91168);
            return emptySet;
        }
        synchronized (b) {
            try {
                emptySet = new HashSet(b);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(91168);
            }
        }
        return emptySet;
    }

    /* renamed from: bD */
    public final Set<V> mo44962bD(K k) {
        AppMethodBeat.m2504i(91169);
        if (k == null) {
            AppMethodBeat.m2505o(91169);
            return null;
        }
        Set<V> set;
        synchronized (this.iQZ) {
            try {
                set = (Set) this.iQZ.remove(k);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(91169);
            }
        }
        return set;
    }
}
