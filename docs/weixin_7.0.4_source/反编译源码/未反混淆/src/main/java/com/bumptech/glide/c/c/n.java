package com.bumptech.glide.c.c;

import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.j;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public interface n<Model, Data> {

    public static class a<Data> {
        public final List<h> aEp;
        public final d<Data> aEq;
        public final h azW;

        public a(h hVar, d<Data> dVar) {
            this(hVar, Collections.emptyList(), dVar);
            AppMethodBeat.i(92098);
            AppMethodBeat.o(92098);
        }

        private a(h hVar, List<h> list, d<Data> dVar) {
            AppMethodBeat.i(92099);
            this.azW = (h) i.d(hVar, "Argument must not be null");
            this.aEp = (List) i.d(list, "Argument must not be null");
            this.aEq = (d) i.d(dVar, "Argument must not be null");
            AppMethodBeat.o(92099);
        }
    }

    boolean X(Model model);

    a<Data> b(Model model, int i, int i2, j jVar);
}
