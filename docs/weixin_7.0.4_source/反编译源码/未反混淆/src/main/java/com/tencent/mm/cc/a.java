package com.tencent.mm.cc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class a<T> implements com.tencent.mm.cc.b.a<T> {
    private final String mName;
    private T mValue;
    private HashSet<Object<T>> xHH;
    private final Object xHI;

    private a(String str) {
        AppMethodBeat.i(58946);
        this.xHI = new Object();
        this.mName = str;
        this.xHH = new HashSet();
        AppMethodBeat.o(58946);
    }

    a(String str, T t) {
        this(str);
        this.mValue = t;
    }

    public final String name() {
        return this.mName;
    }

    public final T get() {
        return this.mValue;
    }

    /* Access modifiers changed, original: final */
    public final void set(T t) {
        Object obj;
        AppMethodBeat.i(58947);
        T t2 = this.mValue;
        if (t == t2 || (t != null && t.equals(t2))) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            this.mValue = t;
            synchronized (this.xHI) {
                try {
                    Iterator it = this.xHH.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } finally {
                    AppMethodBeat.o(58947);
                }
            }
            return;
        }
        AppMethodBeat.o(58947);
    }

    public final String toString() {
        AppMethodBeat.i(58948);
        String str = "Status: " + this.mName;
        AppMethodBeat.o(58948);
        return str;
    }
}
