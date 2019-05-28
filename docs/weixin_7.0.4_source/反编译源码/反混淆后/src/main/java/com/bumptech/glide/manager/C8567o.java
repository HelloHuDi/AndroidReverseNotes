package com.bumptech.glide.manager;

import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p791f.p1156a.C17551e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.o */
public final class C8567o implements C0784i {
    public final Set<C17551e<?>> aGW = Collections.newSetFromMap(new WeakHashMap());

    public C8567o() {
        AppMethodBeat.m2504i(92421);
        AppMethodBeat.m2505o(92421);
    }

    /* renamed from: f */
    public final void mo18680f(C17551e<?> c17551e) {
        AppMethodBeat.m2504i(92422);
        this.aGW.remove(c17551e);
        AppMethodBeat.m2505o(92422);
    }

    public final void onStart() {
        AppMethodBeat.m2504i(92423);
        for (C17551e onStart : C45002j.m82418d(this.aGW)) {
            onStart.onStart();
        }
        AppMethodBeat.m2505o(92423);
    }

    public final void onStop() {
        AppMethodBeat.m2504i(92424);
        for (C17551e onStop : C45002j.m82418d(this.aGW)) {
            onStop.onStop();
        }
        AppMethodBeat.m2505o(92424);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(92425);
        for (C17551e onDestroy : C45002j.m82418d(this.aGW)) {
            onDestroy.onDestroy();
        }
        AppMethodBeat.m2505o(92425);
    }
}
