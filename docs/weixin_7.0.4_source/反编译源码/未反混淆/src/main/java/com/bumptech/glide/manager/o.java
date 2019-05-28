package com.bumptech.glide.manager;

import com.bumptech.glide.f.a.e;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class o implements i {
    public final Set<e<?>> aGW = Collections.newSetFromMap(new WeakHashMap());

    public o() {
        AppMethodBeat.i(92421);
        AppMethodBeat.o(92421);
    }

    public final void f(e<?> eVar) {
        AppMethodBeat.i(92422);
        this.aGW.remove(eVar);
        AppMethodBeat.o(92422);
    }

    public final void onStart() {
        AppMethodBeat.i(92423);
        for (e onStart : j.d(this.aGW)) {
            onStart.onStart();
        }
        AppMethodBeat.o(92423);
    }

    public final void onStop() {
        AppMethodBeat.i(92424);
        for (e onStop : j.d(this.aGW)) {
            onStop.onStop();
        }
        AppMethodBeat.o(92424);
    }

    public final void onDestroy() {
        AppMethodBeat.i(92425);
        for (e onDestroy : j.d(this.aGW)) {
            onDestroy.onDestroy();
        }
        AppMethodBeat.o(92425);
    }
}
