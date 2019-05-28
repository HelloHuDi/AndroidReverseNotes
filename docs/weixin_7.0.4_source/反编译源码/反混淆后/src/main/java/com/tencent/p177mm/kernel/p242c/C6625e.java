package com.tencent.p177mm.kernel.p242c;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.kernel.c.e */
public final class C6625e<T extends C1694a> implements C1695b, C1696c<T> {
    private T eMH;

    public C6625e(T t) {
        this.eMH = t;
    }

    /* renamed from: SJ */
    public final T mo5204SJ() {
        return this.eMH;
    }

    /* renamed from: SH */
    public final void mo5202SH() {
        AppMethodBeat.m2504i(51937);
        if (this.eMH instanceof C1695b) {
            ((C1695b) this.eMH).mo5202SH();
        }
        AppMethodBeat.m2505o(51937);
    }

    /* renamed from: SI */
    public final void mo5203SI() {
        AppMethodBeat.m2504i(51938);
        if (this.eMH instanceof C1695b) {
            ((C1695b) this.eMH).mo5203SI();
        }
        AppMethodBeat.m2505o(51938);
    }
}
