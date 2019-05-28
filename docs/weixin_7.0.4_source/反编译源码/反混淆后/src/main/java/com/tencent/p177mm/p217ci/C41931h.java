package com.tencent.p177mm.p217ci;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ci.h */
public final class C41931h<T> {
    private C32467c<T> Aix;
    private byte[] eHH = new byte[0];
    private volatile T mInstance;

    public C41931h(C32467c<T> c32467c) {
        AppMethodBeat.m2504i(59239);
        this.Aix = c32467c;
        AppMethodBeat.m2505o(59239);
    }

    public final T get() {
        AppMethodBeat.m2504i(59240);
        if (this.mInstance == null) {
            synchronized (this.eHH) {
                try {
                    if (this.mInstance == null) {
                        this.mInstance = this.Aix.get();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(59240);
                    }
                }
            }
        }
        Object obj = this.mInstance;
        AppMethodBeat.m2505o(59240);
        return obj;
    }
}
