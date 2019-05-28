package com.tencent.p177mm.plugin.p369d.p370a.p371a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.d.a.a.a */
public final class C38824a {
    int[] jEI = null;

    public C38824a(int[] iArr) {
        AppMethodBeat.m2504i(18325);
        if (iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == aDataGroup || 0 == aDataGroup.length");
            AppMethodBeat.m2505o(18325);
            throw nullPointerException;
        }
        this.jEI = iArr;
        AppMethodBeat.m2505o(18325);
    }
}
