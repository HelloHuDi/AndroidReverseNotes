package com.bumptech.glide.e;

import android.support.v4.f.a;
import com.bumptech.glide.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class d {
    private final AtomicReference<h> aHb = new AtomicReference();
    public final a<h, List<Class<?>>> aHc = new a();

    public d() {
        AppMethodBeat.i(92438);
        AppMethodBeat.o(92438);
    }

    public final List<Class<?>> f(Class<?> cls, Class<?> cls2) {
        Object hVar;
        List<Class<?>> list;
        AppMethodBeat.i(92439);
        h hVar2 = (h) this.aHb.getAndSet(null);
        if (hVar2 == null) {
            hVar = new h(cls, cls2);
        } else {
            hVar2.d(cls, cls2, null);
            h hVar3 = hVar2;
        }
        synchronized (this.aHc) {
            try {
                list = (List) this.aHc.get(hVar3);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(92439);
            }
        }
        this.aHb.set(hVar3);
        return list;
    }
}
