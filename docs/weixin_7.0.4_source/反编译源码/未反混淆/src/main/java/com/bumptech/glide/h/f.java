package com.bumptech.glide.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class f<T, Y> {
    private final long aCJ;
    private long aCL;
    private long axz;
    private final Map<T, Y> cache = new LinkedHashMap(100, 0.75f, true);

    public f(long j) {
        AppMethodBeat.i(92580);
        this.aCJ = j;
        this.axz = j;
        AppMethodBeat.o(92580);
    }

    /* Access modifiers changed, original: protected */
    public int W(Y y) {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    public void g(T t, Y y) {
    }

    public final synchronized long ol() {
        return this.axz;
    }

    public final synchronized Y get(T t) {
        Object obj;
        AppMethodBeat.i(92581);
        obj = this.cache.get(t);
        AppMethodBeat.o(92581);
        return obj;
    }

    public final synchronized Y put(T t, Y y) {
        Y y2;
        AppMethodBeat.i(92582);
        int W = W(y);
        if (((long) W) >= this.axz) {
            g(t, y);
            y2 = null;
            AppMethodBeat.o(92582);
        } else {
            if (y != null) {
                this.aCL = ((long) W) + this.aCL;
            }
            y2 = this.cache.put(t, y);
            if (y2 != null) {
                this.aCL -= (long) W(y2);
                if (!y2.equals(y)) {
                    g(t, y2);
                }
            }
            p(this.axz);
            AppMethodBeat.o(92582);
        }
        return y2;
    }

    public final synchronized Y remove(T t) {
        Object remove;
        AppMethodBeat.i(92583);
        remove = this.cache.remove(t);
        if (remove != null) {
            this.aCL -= (long) W(remove);
        }
        AppMethodBeat.o(92583);
        return remove;
    }

    public final void mO() {
        AppMethodBeat.i(92584);
        p(0);
        AppMethodBeat.o(92584);
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void p(long j) {
        AppMethodBeat.i(92585);
        while (this.aCL > j) {
            Iterator it = this.cache.entrySet().iterator();
            Entry entry = (Entry) it.next();
            Object value = entry.getValue();
            this.aCL -= (long) W(value);
            Object key = entry.getKey();
            it.remove();
            g(key, value);
        }
        AppMethodBeat.o(92585);
    }
}
