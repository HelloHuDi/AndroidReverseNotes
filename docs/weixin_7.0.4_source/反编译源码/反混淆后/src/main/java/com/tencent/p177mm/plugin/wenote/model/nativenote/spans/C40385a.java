package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.a */
public final class C40385a {
    public final C44012q uRP;
    public int uRQ;
    public int uRR;

    public C40385a(C44012q c44012q, int i, int i2) {
        this.uRP = c44012q;
        this.uRQ = i;
        this.uRR = i2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(26930);
        String str = this.uRP.name() + " - " + this.uRQ + "/" + this.uRR;
        AppMethodBeat.m2505o(26930);
        return str;
    }
}
