package com.bumptech.glide.p095h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.h.f */
public class C0780f<T, Y> {
    private final long aCJ;
    private long aCL;
    private long axz;
    private final Map<T, Y> cache = new LinkedHashMap(100, 0.75f, true);

    public C0780f(long j) {
        AppMethodBeat.m2504i(92580);
        this.aCJ = j;
        this.axz = j;
        AppMethodBeat.m2505o(92580);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: W */
    public int mo2245W(Y y) {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: g */
    public void mo2246g(T t, Y y) {
    }

    /* renamed from: ol */
    public final synchronized long mo2249ol() {
        return this.axz;
    }

    public final synchronized Y get(T t) {
        Object obj;
        AppMethodBeat.m2504i(92581);
        obj = this.cache.get(t);
        AppMethodBeat.m2505o(92581);
        return obj;
    }

    public final synchronized Y put(T t, Y y) {
        Y y2;
        AppMethodBeat.m2504i(92582);
        int W = mo2245W(y);
        if (((long) W) >= this.axz) {
            mo2246g(t, y);
            y2 = null;
            AppMethodBeat.m2505o(92582);
        } else {
            if (y != null) {
                this.aCL = ((long) W) + this.aCL;
            }
            y2 = this.cache.put(t, y);
            if (y2 != null) {
                this.aCL -= (long) mo2245W(y2);
                if (!y2.equals(y)) {
                    mo2246g(t, y2);
                }
            }
            mo2250p(this.axz);
            AppMethodBeat.m2505o(92582);
        }
        return y2;
    }

    public final synchronized Y remove(T t) {
        Object remove;
        AppMethodBeat.m2504i(92583);
        remove = this.cache.remove(t);
        if (remove != null) {
            this.aCL -= (long) mo2245W(remove);
        }
        AppMethodBeat.m2505o(92583);
        return remove;
    }

    /* renamed from: mO */
    public final void mo2248mO() {
        AppMethodBeat.m2504i(92584);
        mo2250p(0);
        AppMethodBeat.m2505o(92584);
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    /* renamed from: p */
    public final synchronized void mo2250p(long j) {
        AppMethodBeat.m2504i(92585);
        while (this.aCL > j) {
            Iterator it = this.cache.entrySet().iterator();
            Entry entry = (Entry) it.next();
            Object value = entry.getValue();
            this.aCL -= (long) mo2245W(value);
            Object key = entry.getKey();
            it.remove();
            mo2246g(key, value);
        }
        AppMethodBeat.m2505o(92585);
    }
}
