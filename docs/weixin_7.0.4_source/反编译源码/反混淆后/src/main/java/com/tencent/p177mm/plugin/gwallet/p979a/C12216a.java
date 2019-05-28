package com.tencent.p177mm.plugin.gwallet.p979a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VError;

/* renamed from: com.tencent.mm.plugin.gwallet.a.a */
public final class C12216a extends Exception {
    C28282c npI;

    private C12216a(C28282c c28282c) {
        this(c28282c, null);
    }

    public C12216a(int i, String str) {
        this(new C28282c(i, str));
        AppMethodBeat.m2504i(41689);
        AppMethodBeat.m2505o(41689);
    }

    public C12216a(String str, Exception exception) {
        this(new C28282c(VError.ERROR_FACE_TXT_INIT, str), exception);
        AppMethodBeat.m2504i(41690);
        AppMethodBeat.m2505o(41690);
    }

    private C12216a(C28282c c28282c, Exception exception) {
        super(c28282c.nqb, exception);
        this.npI = c28282c;
    }
}
