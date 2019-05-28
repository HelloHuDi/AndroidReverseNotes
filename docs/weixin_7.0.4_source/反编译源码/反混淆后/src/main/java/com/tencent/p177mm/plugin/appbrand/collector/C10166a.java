package com.tencent.p177mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.collector.a */
final class C10166a<K, V> extends ConcurrentHashMap<K, V> {
    C10166a() {
    }

    public final V get(Object obj) {
        AppMethodBeat.m2504i(57020);
        if (obj == null) {
            AppMethodBeat.m2505o(57020);
            return null;
        }
        V v = super.get(obj);
        AppMethodBeat.m2505o(57020);
        return v;
    }

    public final V put(K k, V v) {
        AppMethodBeat.m2504i(57021);
        V remove;
        if (k == null) {
            AppMethodBeat.m2505o(57021);
            return null;
        } else if (v == null) {
            remove = super.remove(k);
            AppMethodBeat.m2505o(57021);
            return remove;
        } else {
            remove = super.put(k, v);
            AppMethodBeat.m2505o(57021);
            return remove;
        }
    }

    public final V remove(Object obj) {
        AppMethodBeat.m2504i(57022);
        if (obj == null) {
            AppMethodBeat.m2505o(57022);
            return null;
        }
        V remove = super.remove(obj);
        AppMethodBeat.m2505o(57022);
        return remove;
    }

    public final boolean containsValue(Object obj) {
        AppMethodBeat.m2504i(57023);
        if (obj == null) {
            AppMethodBeat.m2505o(57023);
            return false;
        }
        boolean containsValue = super.containsValue(obj);
        AppMethodBeat.m2505o(57023);
        return containsValue;
    }
}
