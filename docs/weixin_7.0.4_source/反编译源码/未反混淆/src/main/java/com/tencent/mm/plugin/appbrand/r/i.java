package com.tencent.mm.plugin.appbrand.r;

import android.support.v4.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class i<K, V> {
    private final Map<K, Set<V>> iQZ = new a();

    public i() {
        AppMethodBeat.i(91165);
        AppMethodBeat.o(91165);
    }

    public final void f(K k, V v) {
        AppMethodBeat.i(91166);
        if (k == null || v == null) {
            AppMethodBeat.o(91166);
            return;
        }
        Set b = b(k, true);
        synchronized (b) {
            try {
                b.add(v);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(91166);
            }
        }
    }

    public final Set<V> b(K k, boolean z) {
        Set<V> set;
        AppMethodBeat.i(91167);
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
                AppMethodBeat.o(91167);
            }
        }
        return set;
    }

    public final Set<V> bC(K k) {
        AppMethodBeat.i(91168);
        if (k == null) {
            AppMethodBeat.o(91168);
            return null;
        }
        Set b = b(k, false);
        Set<V> emptySet;
        if (b == null) {
            emptySet = Collections.emptySet();
            AppMethodBeat.o(91168);
            return emptySet;
        }
        synchronized (b) {
            try {
                emptySet = new HashSet(b);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(91168);
            }
        }
        return emptySet;
    }

    public final Set<V> bD(K k) {
        AppMethodBeat.i(91169);
        if (k == null) {
            AppMethodBeat.o(91169);
            return null;
        }
        Set<V> set;
        synchronized (this.iQZ) {
            try {
                set = (Set) this.iQZ.remove(k);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(91169);
            }
        }
        return set;
    }
}
