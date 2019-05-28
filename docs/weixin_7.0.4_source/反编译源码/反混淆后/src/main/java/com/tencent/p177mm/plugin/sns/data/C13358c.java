package com.tencent.p177mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.data.c */
public final class C13358c {
    public C39731e qFJ;
    public SparseArray<C39731e> qFK;
    public int requestType;

    public C13358c() {
        AppMethodBeat.m2504i(35787);
        this.qFK = new SparseArray();
        AppMethodBeat.m2505o(35787);
    }

    public C13358c(C39731e c39731e, int i) {
        this.qFJ = c39731e;
        this.requestType = i;
    }

    public C13358c(SparseArray<C39731e> sparseArray) {
        this.qFK = sparseArray;
        this.requestType = 9;
    }
}
