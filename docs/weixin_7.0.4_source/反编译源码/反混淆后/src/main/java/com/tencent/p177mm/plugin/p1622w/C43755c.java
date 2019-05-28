package com.tencent.p177mm.plugin.p1622w;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.w.c */
public enum C43755c {
    ;
    
    public final SparseArray<C43754b> qwT;

    private C43755c(String str) {
        AppMethodBeat.m2504i(79171);
        this.qwT = new SparseArray();
        AppMethodBeat.m2505o(79171);
    }

    static {
        AppMethodBeat.m2505o(79173);
    }

    /* renamed from: a */
    public final boolean mo69466a(C43754b c43754b) {
        AppMethodBeat.m2504i(79172);
        this.qwT.put(c43754b.getType(), c43754b);
        AppMethodBeat.m2505o(79172);
        return true;
    }
}
