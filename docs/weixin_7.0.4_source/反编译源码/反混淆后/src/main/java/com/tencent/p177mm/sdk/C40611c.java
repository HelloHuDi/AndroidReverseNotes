package com.tencent.p177mm.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C35993bg;

/* renamed from: com.tencent.mm.sdk.c */
public class C40611c<T> extends C35993bg<T> {
    private final Object mLock = new Object();

    public C40611c(int i) {
        super(i);
        AppMethodBeat.m2504i(51962);
        AppMethodBeat.m2505o(51962);
    }

    /* renamed from: aA */
    public final T mo56734aA() {
        T aA;
        AppMethodBeat.m2504i(51963);
        synchronized (this.mLock) {
            try {
                aA = super.mo56734aA();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51963);
            }
        }
        return aA;
    }

    public final boolean release(T t) {
        boolean release;
        AppMethodBeat.m2504i(51964);
        synchronized (this.mLock) {
            try {
                release = super.release(t);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(51964);
            }
        }
        return release;
    }
}
