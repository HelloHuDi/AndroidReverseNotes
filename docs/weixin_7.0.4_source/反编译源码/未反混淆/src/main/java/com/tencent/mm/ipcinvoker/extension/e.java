package com.tencent.mm.ipcinvoker.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.g.b;
import junit.framework.Assert;

public final class e<T> {
    private volatile T eGy;
    private Class<T> targetClass;

    public e(Class<T> cls) {
        AppMethodBeat.i(114088);
        Assert.assertNotNull(cls);
        this.targetClass = cls;
        AppMethodBeat.o(114088);
    }

    public final T get() {
        AppMethodBeat.i(114089);
        if (this.eGy == null) {
            synchronized (this) {
                try {
                    if (this.eGy == null) {
                        this.eGy = b.H(this.targetClass);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(114089);
                    }
                }
            }
        }
        Object obj = this.eGy;
        AppMethodBeat.o(114089);
        return obj;
    }
}
