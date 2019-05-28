package com.bumptech.glide.c.c;

import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.j;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v<Model> implements n<Model, Model> {
    private static final v<?> aEI = new v();

    static class b<Model> implements d<Model> {
        private final Model aEK;

        b(Model model) {
            this.aEK = model;
        }

        public final void a(g gVar, com.bumptech.glide.c.a.d.a<? super Model> aVar) {
            AppMethodBeat.i(92141);
            aVar.S(this.aEK);
            AppMethodBeat.o(92141);
        }

        public final void cleanup() {
        }

        public final void cancel() {
        }

        public final Class<Model> mg() {
            AppMethodBeat.i(92142);
            Class cls = this.aEK.getClass();
            AppMethodBeat.o(92142);
            return cls;
        }

        public final com.bumptech.glide.c.a mh() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }

    public static class a<Model> implements o<Model, Model> {
        private static final a<?> aEJ = new a();

        static {
            AppMethodBeat.i(92140);
            AppMethodBeat.o(92140);
        }

        public static <T> a<T> nl() {
            return aEJ;
        }

        public final n<Model, Model> a(r rVar) {
            AppMethodBeat.i(92139);
            v nk = v.nk();
            AppMethodBeat.o(92139);
            return nk;
        }
    }

    static {
        AppMethodBeat.i(92144);
        AppMethodBeat.o(92144);
    }

    public static <T> v<T> nk() {
        return aEI;
    }

    public final com.bumptech.glide.c.c.n.a<Model> b(Model model, int i, int i2, j jVar) {
        AppMethodBeat.i(92143);
        com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(new com.bumptech.glide.g.b(model), new b(model));
        AppMethodBeat.o(92143);
        return aVar;
    }

    public final boolean X(Model model) {
        return true;
    }
}
