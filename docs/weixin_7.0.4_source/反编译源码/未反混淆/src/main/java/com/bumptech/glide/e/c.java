package com.bumptech.glide.e;

import android.support.v4.f.a;
import com.bumptech.glide.c.b.h;
import com.bumptech.glide.c.b.s;
import com.bumptech.glide.c.d.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public final class c {
    public static final s<?, ?, ?> aGY = new s(Object.class, Object.class, Object.class, Collections.singletonList(new h(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);
    public final a<com.bumptech.glide.h.h, s<?, ?, ?>> aGZ = new a();
    private final AtomicReference<com.bumptech.glide.h.h> aHa = new AtomicReference();

    public c() {
        AppMethodBeat.i(92434);
        AppMethodBeat.o(92434);
    }

    static {
        AppMethodBeat.i(92437);
        AppMethodBeat.o(92437);
    }

    public static boolean a(s<?, ?, ?> sVar) {
        AppMethodBeat.i(92435);
        boolean equals = aGY.equals(sVar);
        AppMethodBeat.o(92435);
        return equals;
    }

    public final <Data, TResource, Transcode> s<Data, TResource, Transcode> c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        com.bumptech.glide.h.h hVar;
        s<Data, TResource, Transcode> sVar;
        AppMethodBeat.i(92436);
        com.bumptech.glide.h.h hVar2 = (com.bumptech.glide.h.h) this.aHa.getAndSet(null);
        if (hVar2 == null) {
            hVar = new com.bumptech.glide.h.h();
        } else {
            hVar = hVar2;
        }
        hVar.d(cls, cls2, cls3);
        synchronized (this.aGZ) {
            try {
                sVar = (s) this.aGZ.get(hVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(92436);
            }
        }
        this.aHa.set(hVar);
        return sVar;
    }
}
