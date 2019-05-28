package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

final class a<K, V> extends ConcurrentHashMap<K, V> {
    a() {
    }

    public final V get(Object obj) {
        AppMethodBeat.i(57020);
        if (obj == null) {
            AppMethodBeat.o(57020);
            return null;
        }
        V v = super.get(obj);
        AppMethodBeat.o(57020);
        return v;
    }

    public final V put(K k, V v) {
        AppMethodBeat.i(57021);
        V remove;
        if (k == null) {
            AppMethodBeat.o(57021);
            return null;
        } else if (v == null) {
            remove = super.remove(k);
            AppMethodBeat.o(57021);
            return remove;
        } else {
            remove = super.put(k, v);
            AppMethodBeat.o(57021);
            return remove;
        }
    }

    public final V remove(Object obj) {
        AppMethodBeat.i(57022);
        if (obj == null) {
            AppMethodBeat.o(57022);
            return null;
        }
        V remove = super.remove(obj);
        AppMethodBeat.o(57022);
        return remove;
    }

    public final boolean containsValue(Object obj) {
        AppMethodBeat.i(57023);
        if (obj == null) {
            AppMethodBeat.o(57023);
            return false;
        }
        boolean containsValue = super.containsValue(obj);
        AppMethodBeat.o(57023);
        return containsValue;
    }
}
