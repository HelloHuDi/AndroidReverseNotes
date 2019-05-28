package com.bumptech.glide.c.c;

import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.b.p;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.j;
import com.bumptech.glide.g;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class q<Model, Data> implements n<Model, Data> {
    private final android.support.v4.f.k.a<List<Throwable>> aEv;
    private final List<n<Model, Data>> azX;

    static class a<Data> implements d<Data>, com.bumptech.glide.c.a.d.a<Data> {
        private g aAk;
        private final List<d<Data>> aEw;
        private com.bumptech.glide.c.a.d.a<? super Data> aEx;
        private List<Throwable> aEy;
        private final android.support.v4.f.k.a<List<Throwable>> awV;
        private int currentIndex = 0;

        a(List<d<Data>> list, android.support.v4.f.k.a<List<Throwable>> aVar) {
            AppMethodBeat.i(92106);
            this.awV = aVar;
            i.c(list);
            this.aEw = list;
            AppMethodBeat.o(92106);
        }

        public final void a(g gVar, com.bumptech.glide.c.a.d.a<? super Data> aVar) {
            AppMethodBeat.i(92107);
            this.aAk = gVar;
            this.aEx = aVar;
            this.aEy = (List) this.awV.aA();
            ((d) this.aEw.get(this.currentIndex)).a(gVar, this);
            AppMethodBeat.o(92107);
        }

        public final void cleanup() {
            AppMethodBeat.i(92108);
            if (this.aEy != null) {
                this.awV.release(this.aEy);
            }
            this.aEy = null;
            for (d cleanup : this.aEw) {
                cleanup.cleanup();
            }
            AppMethodBeat.o(92108);
        }

        public final void cancel() {
            AppMethodBeat.i(92109);
            for (d cancel : this.aEw) {
                cancel.cancel();
            }
            AppMethodBeat.o(92109);
        }

        public final Class<Data> mg() {
            AppMethodBeat.i(92110);
            Class mg = ((d) this.aEw.get(0)).mg();
            AppMethodBeat.o(92110);
            return mg;
        }

        public final com.bumptech.glide.c.a mh() {
            AppMethodBeat.i(92111);
            com.bumptech.glide.c.a mh = ((d) this.aEw.get(0)).mh();
            AppMethodBeat.o(92111);
            return mh;
        }

        public final void S(Data data) {
            AppMethodBeat.i(92112);
            if (data != null) {
                this.aEx.S(data);
                AppMethodBeat.o(92112);
                return;
            }
            nj();
            AppMethodBeat.o(92112);
        }

        public final void b(Exception exception) {
            AppMethodBeat.i(92113);
            ((List) i.d(this.aEy, "Argument must not be null")).add(exception);
            nj();
            AppMethodBeat.o(92113);
        }

        private void nj() {
            AppMethodBeat.i(92114);
            if (this.currentIndex < this.aEw.size() - 1) {
                this.currentIndex++;
                a(this.aAk, this.aEx);
                AppMethodBeat.o(92114);
                return;
            }
            i.d(this.aEy, "Argument must not be null");
            this.aEx.b(new p("Fetch failed", new ArrayList(this.aEy)));
            AppMethodBeat.o(92114);
        }
    }

    q(List<n<Model, Data>> list, android.support.v4.f.k.a<List<Throwable>> aVar) {
        this.azX = list;
        this.aEv = aVar;
    }

    public final com.bumptech.glide.c.c.n.a<Data> b(Model model, int i, int i2, j jVar) {
        AppMethodBeat.i(92115);
        int size = this.azX.size();
        ArrayList arrayList = new ArrayList(size);
        int i3 = 0;
        h hVar = null;
        while (i3 < size) {
            h hVar2;
            n nVar = (n) this.azX.get(i3);
            if (nVar.X(model)) {
                com.bumptech.glide.c.c.n.a b = nVar.b(model, i, i2, jVar);
                if (b != null) {
                    hVar2 = b.azW;
                    arrayList.add(b.aEq);
                    i3++;
                    hVar = hVar2;
                }
            }
            hVar2 = hVar;
            i3++;
            hVar = hVar2;
        }
        if (arrayList.isEmpty() || hVar == null) {
            AppMethodBeat.o(92115);
            return null;
        }
        com.bumptech.glide.c.c.n.a aVar = new com.bumptech.glide.c.c.n.a(hVar, new a(arrayList, this.aEv));
        AppMethodBeat.o(92115);
        return aVar;
    }

    public final boolean X(Model model) {
        AppMethodBeat.i(92116);
        for (n X : this.azX) {
            if (X.X(model)) {
                AppMethodBeat.o(92116);
                return true;
            }
        }
        AppMethodBeat.o(92116);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(92117);
        String str = "MultiModelLoader{modelLoaders=" + Arrays.toString(this.azX.toArray()) + '}';
        AppMethodBeat.o(92117);
        return str;
    }
}
