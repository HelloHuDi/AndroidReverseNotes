package com.tencent.mm.plugin.w;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    ;
    
    public final SparseArray<b> qwT;

    private c(String str) {
        AppMethodBeat.i(79171);
        this.qwT = new SparseArray();
        AppMethodBeat.o(79171);
    }

    static {
        AppMethodBeat.o(79173);
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(79172);
        this.qwT.put(bVar.getType(), bVar);
        AppMethodBeat.o(79172);
        return true;
    }
}
