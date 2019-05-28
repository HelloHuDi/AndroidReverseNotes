package com.tencent.p177mm.compatible.p1597a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;

/* renamed from: com.tencent.mm.compatible.a.a */
public final class C41933a {

    /* renamed from: com.tencent.mm.compatible.a.a$a */
    public interface C41932a {
        void run();
    }

    /* renamed from: a */
    public static boolean m74069a(int i, C41932a c41932a) {
        AppMethodBeat.m2504i(51922);
        if (C1443d.m3068iW(i)) {
            c41932a.run();
            AppMethodBeat.m2505o(51922);
            return true;
        }
        AppMethodBeat.m2505o(51922);
        return false;
    }
}
