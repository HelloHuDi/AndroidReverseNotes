package com.tencent.p177mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.voip.model.f */
final class C43733f {
    private int pos;
    private char[] sOB = new char[50];

    public C43733f() {
        AppMethodBeat.m2504i(4353);
        AppMethodBeat.m2505o(4353);
    }

    public final String toString() {
        AppMethodBeat.m2504i(4354);
        String str = new String(this.sOB, 0, this.pos);
        AppMethodBeat.m2505o(4354);
        return str;
    }
}
