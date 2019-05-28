package com.bumptech.glide.c.d;

import com.bumptech.glide.c.b.u;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a<T> implements u<T> {
    protected final T data;

    public a(T t) {
        AppMethodBeat.i(92176);
        this.data = i.d(t, "Argument must not be null");
        AppMethodBeat.o(92176);
    }

    public final Class<T> mK() {
        AppMethodBeat.i(92177);
        Class cls = this.data.getClass();
        AppMethodBeat.o(92177);
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
