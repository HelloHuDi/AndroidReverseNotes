package com.google.firebase.components;

import com.google.firebase.p1372a.C25579a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.components.p */
final class C31251p<T> implements C25579a<T> {
    private static final Object bvh = new Object();
    private volatile Object bvi = bvh;
    private volatile C25579a<T> bvj;

    static {
        AppMethodBeat.m2504i(10628);
        AppMethodBeat.m2505o(10628);
    }

    C31251p(C41647d<T> c41647d, C45069b c45069b) {
        AppMethodBeat.m2504i(10625);
        this.bvj = new C8746q(c41647d, c45069b);
        AppMethodBeat.m2505o(10625);
    }

    /* renamed from: a */
    static final /* synthetic */ Object m50418a(C41647d c41647d, C45069b c45069b) {
        AppMethodBeat.m2504i(10627);
        Object a = c41647d.mo3695a(c45069b);
        AppMethodBeat.m2505o(10627);
        return a;
    }

    public final T get() {
        AppMethodBeat.m2504i(10626);
        T t = this.bvi;
        if (t == bvh) {
            synchronized (this) {
                try {
                    t = this.bvi;
                    if (t == bvh) {
                        t = this.bvj.get();
                        this.bvi = t;
                        this.bvj = null;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10626);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(10626);
        return t;
    }
}
