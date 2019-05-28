package com.bumptech.glide.p086c.p092d;

import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.a */
public class C24648a<T> implements C17526u<T> {
    protected final T data;

    public C24648a(T t) {
        AppMethodBeat.m2504i(92176);
        this.data = C8561i.m15217d(t, "Argument must not be null");
        AppMethodBeat.m2505o(92176);
    }

    /* renamed from: mK */
    public final Class<T> mo2232mK() {
        AppMethodBeat.m2504i(92177);
        Class cls = this.data.getClass();
        AppMethodBeat.m2505o(92177);
        return cls;
    }

    public final T get() {
        return this.data;
    }

    public final int getSize() {
        return 1;
    }

    public final void recycle() {
    }
}
