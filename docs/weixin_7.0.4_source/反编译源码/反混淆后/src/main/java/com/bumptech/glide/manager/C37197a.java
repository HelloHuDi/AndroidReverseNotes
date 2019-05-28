package com.bumptech.glide.manager;

import com.bumptech.glide.p095h.C45002j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.a */
final class C37197a implements C0783h {
    private boolean aFV;
    private final Set<C0784i> aGw = Collections.newSetFromMap(new WeakHashMap());
    private boolean aGx;

    C37197a() {
        AppMethodBeat.m2504i(92371);
        AppMethodBeat.m2505o(92371);
    }

    /* renamed from: a */
    public final void mo2254a(C0784i c0784i) {
        AppMethodBeat.m2504i(92372);
        this.aGw.add(c0784i);
        if (this.aGx) {
            c0784i.onDestroy();
            AppMethodBeat.m2505o(92372);
        } else if (this.aFV) {
            c0784i.onStart();
            AppMethodBeat.m2505o(92372);
        } else {
            c0784i.onStop();
            AppMethodBeat.m2505o(92372);
        }
    }

    /* renamed from: b */
    public final void mo2255b(C0784i c0784i) {
        AppMethodBeat.m2504i(92373);
        this.aGw.remove(c0784i);
        AppMethodBeat.m2505o(92373);
    }

    /* Access modifiers changed, original: final */
    public final void onStart() {
        AppMethodBeat.m2504i(92374);
        this.aFV = true;
        for (C0784i onStart : C45002j.m82418d(this.aGw)) {
            onStart.onStart();
        }
        AppMethodBeat.m2505o(92374);
    }

    /* Access modifiers changed, original: final */
    public final void onStop() {
        AppMethodBeat.m2504i(92375);
        this.aFV = false;
        for (C0784i onStop : C45002j.m82418d(this.aGw)) {
            onStop.onStop();
        }
        AppMethodBeat.m2505o(92375);
    }

    /* Access modifiers changed, original: final */
    public final void onDestroy() {
        AppMethodBeat.m2504i(92376);
        this.aGx = true;
        for (C0784i onDestroy : C45002j.m82418d(this.aGw)) {
            onDestroy.onDestroy();
        }
        AppMethodBeat.m2505o(92376);
    }
}
