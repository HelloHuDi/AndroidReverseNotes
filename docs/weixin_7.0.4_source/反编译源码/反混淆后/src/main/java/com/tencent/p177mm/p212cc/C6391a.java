package com.tencent.p177mm.p212cc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p212cc.C1349b.C1348a;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.cc.a */
public final class C6391a<T> implements C1348a<T> {
    private final String mName;
    private T mValue;
    private HashSet<Object<T>> xHH;
    private final Object xHI;

    private C6391a(String str) {
        AppMethodBeat.m2504i(58946);
        this.xHI = new Object();
        this.mName = str;
        this.xHH = new HashSet();
        AppMethodBeat.m2505o(58946);
    }

    C6391a(String str, T t) {
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
        AppMethodBeat.m2504i(58947);
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
                    AppMethodBeat.m2505o(58947);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(58947);
    }

    public final String toString() {
        AppMethodBeat.m2504i(58948);
        String str = "Status: " + this.mName;
        AppMethodBeat.m2505o(58948);
        return str;
    }
}
