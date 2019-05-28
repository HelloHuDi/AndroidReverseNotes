package com.tencent.p177mm.vending.p641g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

/* renamed from: com.tencent.mm.vending.g.g */
final class C5701g {
    private static C5701g zYo;
    /* renamed from: b */
    ThreadLocal<Stack<C7361c>> f1348b = new ThreadLocal();

    private C5701g() {
        AppMethodBeat.m2504i(126069);
        AppMethodBeat.m2505o(126069);
    }

    static {
        AppMethodBeat.m2504i(126070);
        zYo = null;
        zYo = new C5701g();
        AppMethodBeat.m2505o(126070);
    }

    public static C5701g dMp() {
        return zYo;
    }
}
