package com.tencent.p177mm.ipcinvoker.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p1384g.C26339b;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ipcinvoker.extension.e */
public final class C18510e<T> {
    private volatile T eGy;
    private Class<T> targetClass;

    public C18510e(Class<T> cls) {
        AppMethodBeat.m2504i(114088);
        Assert.assertNotNull(cls);
        this.targetClass = cls;
        AppMethodBeat.m2505o(114088);
    }

    public final T get() {
        AppMethodBeat.m2504i(114089);
        if (this.eGy == null) {
            synchronized (this) {
                try {
                    if (this.eGy == null) {
                        this.eGy = C26339b.m41911H(this.targetClass);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(114089);
                    }
                }
            }
        }
        Object obj = this.eGy;
        AppMethodBeat.m2505o(114089);
        return obj;
    }
}
