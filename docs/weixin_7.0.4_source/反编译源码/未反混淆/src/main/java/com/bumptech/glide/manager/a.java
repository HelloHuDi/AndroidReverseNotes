package com.bumptech.glide.manager;

import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

final class a implements h {
    private boolean aFV;
    private final Set<i> aGw = Collections.newSetFromMap(new WeakHashMap());
    private boolean aGx;

    a() {
        AppMethodBeat.i(92371);
        AppMethodBeat.o(92371);
    }

    public final void a(i iVar) {
        AppMethodBeat.i(92372);
        this.aGw.add(iVar);
        if (this.aGx) {
            iVar.onDestroy();
            AppMethodBeat.o(92372);
        } else if (this.aFV) {
            iVar.onStart();
            AppMethodBeat.o(92372);
        } else {
            iVar.onStop();
            AppMethodBeat.o(92372);
        }
    }

    public final void b(i iVar) {
        AppMethodBeat.i(92373);
        this.aGw.remove(iVar);
        AppMethodBeat.o(92373);
    }

    /* Access modifiers changed, original: final */
    public final void onStart() {
        AppMethodBeat.i(92374);
        this.aFV = true;
        for (i onStart : j.d(this.aGw)) {
            onStart.onStart();
        }
        AppMethodBeat.o(92374);
    }

    /* Access modifiers changed, original: final */
    public final void onStop() {
        AppMethodBeat.i(92375);
        this.aFV = false;
        for (i onStop : j.d(this.aGw)) {
            onStop.onStop();
        }
        AppMethodBeat.o(92375);
    }

    /* Access modifiers changed, original: final */
    public final void onDestroy() {
        AppMethodBeat.i(92376);
        this.aGx = true;
        for (i onDestroy : j.d(this.aGw)) {
            onDestroy.onDestroy();
        }
        AppMethodBeat.o(92376);
    }
}
