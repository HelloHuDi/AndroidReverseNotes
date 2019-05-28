package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public e qFJ;
    public SparseArray<e> qFK;
    public int requestType;

    public c() {
        AppMethodBeat.i(35787);
        this.qFK = new SparseArray();
        AppMethodBeat.o(35787);
    }

    public c(e eVar, int i) {
        this.qFJ = eVar;
        this.requestType = i;
    }

    public c(SparseArray<e> sparseArray) {
        this.qFK = sparseArray;
        this.requestType = 9;
    }
}
