package com.bumptech.glide.manager;

import com.bumptech.glide.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class n {
    public final Set<b> aGR = Collections.newSetFromMap(new WeakHashMap());
    public final List<b> aGS = new ArrayList();
    public boolean isPaused;

    public n() {
        AppMethodBeat.i(92408);
        AppMethodBeat.o(92408);
    }

    public final boolean a(b bVar, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(92409);
        if (bVar == null) {
            AppMethodBeat.o(92409);
        } else {
            boolean remove = this.aGR.remove(bVar);
            if (!(this.aGS.remove(bVar) || remove)) {
                z2 = false;
            }
            if (z2) {
                bVar.clear();
                if (z) {
                    bVar.recycle();
                }
            }
            AppMethodBeat.o(92409);
        }
        return z2;
    }

    public final String toString() {
        AppMethodBeat.i(92410);
        String str = super.toString() + "{numRequests=" + this.aGR.size() + ", isPaused=" + this.isPaused + "}";
        AppMethodBeat.o(92410);
        return str;
    }
}
