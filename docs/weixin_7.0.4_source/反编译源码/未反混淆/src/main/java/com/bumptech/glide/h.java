package com.bumptech.glide;

import com.bumptech.glide.c.b.s;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.o;
import com.bumptech.glide.c.c.p;
import com.bumptech.glide.c.k;
import com.bumptech.glide.c.l;
import com.bumptech.glide.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class h {
    private final p awM = new p(this.awV);
    public final com.bumptech.glide.e.a awN = new com.bumptech.glide.e.a();
    private final com.bumptech.glide.e.e awO = new com.bumptech.glide.e.e();
    public final f awP = new f();
    public final com.bumptech.glide.c.a.f awQ = new com.bumptech.glide.c.a.f();
    private final com.bumptech.glide.c.d.f.f awR = new com.bumptech.glide.c.d.f.f();
    final com.bumptech.glide.e.b awS = new com.bumptech.glide.e.b();
    private final com.bumptech.glide.e.d awT = new com.bumptech.glide.e.d();
    private final com.bumptech.glide.e.c awU = new com.bumptech.glide.e.c();
    private final android.support.v4.f.k.a<List<Throwable>> awV = com.bumptech.glide.h.a.a.op();

    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    public static class c extends a {
        public c(Object obj) {
            super("Failed to find any ModelLoaders for model: ".concat(String.valueOf(obj)));
            AppMethodBeat.i(91621);
            AppMethodBeat.o(91621);
        }

        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
            AppMethodBeat.i(91622);
            AppMethodBeat.o(91622);
        }
    }

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
            AppMethodBeat.i(91623);
            AppMethodBeat.o(91623);
        }
    }

    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: ".concat(String.valueOf(cls)));
            AppMethodBeat.i(91624);
            AppMethodBeat.o(91624);
        }
    }

    public h() {
        AppMethodBeat.i(91625);
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.awO.s(arrayList);
        AppMethodBeat.o(91625);
    }

    public final <Data> h a(Class<Data> cls, com.bumptech.glide.c.d<Data> dVar) {
        AppMethodBeat.i(91626);
        this.awN.b(cls, dVar);
        AppMethodBeat.o(91626);
        return this;
    }

    public final <Data, TResource> h a(Class<Data> cls, Class<TResource> cls2, k<Data, TResource> kVar) {
        AppMethodBeat.i(91627);
        a("legacy_append", cls, cls2, kVar);
        AppMethodBeat.o(91627);
        return this;
    }

    public final <Data, TResource> h a(String str, Class<Data> cls, Class<TResource> cls2, k<Data, TResource> kVar) {
        AppMethodBeat.i(91628);
        this.awO.a(str, kVar, cls, cls2);
        AppMethodBeat.o(91628);
        return this;
    }

    public final <TResource> h a(Class<TResource> cls, l<TResource> lVar) {
        AppMethodBeat.i(91629);
        this.awP.b(cls, lVar);
        AppMethodBeat.o(91629);
        return this;
    }

    public final h a(com.bumptech.glide.c.a.e.a<?> aVar) {
        AppMethodBeat.i(91630);
        this.awQ.b(aVar);
        AppMethodBeat.o(91630);
        return this;
    }

    public final <TResource, Transcode> h a(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.c.d.f.e<TResource, Transcode> eVar) {
        AppMethodBeat.i(91631);
        this.awR.b(cls, cls2, eVar);
        AppMethodBeat.o(91631);
        return this;
    }

    public final <Model, Data> h a(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        AppMethodBeat.i(91632);
        this.awM.b(cls, cls2, oVar);
        AppMethodBeat.o(91632);
        return this;
    }

    public final <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        AppMethodBeat.i(91633);
        s<Data, TResource, Transcode> c = this.awU.c(cls, cls2, cls3);
        if (com.bumptech.glide.e.c.a(c)) {
            AppMethodBeat.o(91633);
            return null;
        }
        if (c == null) {
            ArrayList arrayList = new ArrayList();
            for (Class cls4 : this.awO.h(cls, cls2)) {
                for (Class cls5 : this.awR.d(cls4, cls3)) {
                    arrayList.add(new com.bumptech.glide.c.b.h(cls, cls4, cls5, this.awO.g(cls, cls4), this.awR.c(cls4, cls5), this.awV));
                }
            }
            if (arrayList.isEmpty()) {
                c = null;
            } else {
                c = new s(cls, cls2, cls3, arrayList, this.awV);
            }
            com.bumptech.glide.e.c cVar = this.awU;
            synchronized (cVar.aGZ) {
                try {
                    cVar.aGZ.put(new com.bumptech.glide.h.h(cls, cls2, cls3), c != null ? c : com.bumptech.glide.e.c.aGY);
                } catch (Throwable th) {
                    AppMethodBeat.o(91633);
                }
            }
        }
        AppMethodBeat.o(91633);
        return c;
    }

    public final <Model, TResource, Transcode> List<Class<?>> b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        AppMethodBeat.i(91634);
        List<Class<?>> f = this.awT.f(cls, cls2);
        if (f == null) {
            ArrayList arrayList = new ArrayList();
            for (Class h : this.awM.r(cls)) {
                for (Class cls4 : this.awO.h(h, cls2)) {
                    if (!(this.awR.d(cls4, cls3).isEmpty() || arrayList.contains(cls4))) {
                        arrayList.add(cls4);
                    }
                }
            }
            com.bumptech.glide.e.d dVar = this.awT;
            List unmodifiableList = Collections.unmodifiableList(arrayList);
            synchronized (dVar.aHc) {
                try {
                    dVar.aHc.put(new com.bumptech.glide.h.h(cls, cls2), unmodifiableList);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(91634);
                    }
                }
            }
            f = arrayList;
        }
        AppMethodBeat.o(91634);
        return f;
    }

    public final <Model> List<n<Model, ?>> P(Model model) {
        AppMethodBeat.i(91635);
        List P = this.awM.P(model);
        if (P.isEmpty()) {
            c cVar = new c(model);
            AppMethodBeat.o(91635);
            throw cVar;
        }
        AppMethodBeat.o(91635);
        return P;
    }

    public final List<com.bumptech.glide.c.f> lF() {
        AppMethodBeat.i(91636);
        List nK = this.awS.nK();
        if (nK.isEmpty()) {
            b bVar = new b();
            AppMethodBeat.o(91636);
            throw bVar;
        }
        AppMethodBeat.o(91636);
        return nK;
    }
}
