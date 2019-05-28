package com.bumptech.glide.c.b.b;

import android.annotation.SuppressLint;
import com.bumptech.glide.c.b.b.h.a;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.h;
import com.bumptech.glide.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g extends f<h, u<?>> implements h {
    private a aDi;

    public final /* synthetic */ int W(Object obj) {
        AppMethodBeat.i(91989);
        u uVar = (u) obj;
        int W;
        if (uVar == null) {
            W = super.W(null);
            AppMethodBeat.o(91989);
            return W;
        }
        W = uVar.getSize();
        AppMethodBeat.o(91989);
        return W;
    }

    public final /* synthetic */ u a(h hVar, u uVar) {
        AppMethodBeat.i(91990);
        u uVar2 = (u) super.put(hVar, uVar);
        AppMethodBeat.o(91990);
        return uVar2;
    }

    public final /* synthetic */ u b(h hVar) {
        AppMethodBeat.i(91991);
        u uVar = (u) super.remove(hVar);
        AppMethodBeat.o(91991);
        return uVar;
    }

    public final /* synthetic */ void g(Object obj, Object obj2) {
        AppMethodBeat.i(91988);
        u uVar = (u) obj2;
        if (!(this.aDi == null || uVar == null)) {
            this.aDi.c(uVar);
        }
        AppMethodBeat.o(91988);
    }

    public g(long j) {
        super(j);
    }

    public final void a(a aVar) {
        this.aDi = aVar;
    }

    @SuppressLint({"InlinedApi"})
    public final void trimMemory(int i) {
        AppMethodBeat.i(91987);
        if (i >= 40) {
            mO();
            AppMethodBeat.o(91987);
            return;
        }
        if (i >= 20 || i == 15) {
            p(ol() / 2);
        }
        AppMethodBeat.o(91987);
    }
}
