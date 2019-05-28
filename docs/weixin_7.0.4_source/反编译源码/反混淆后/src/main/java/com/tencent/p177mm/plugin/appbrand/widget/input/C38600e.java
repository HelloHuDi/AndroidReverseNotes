package com.tencent.p177mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C27277i;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.e */
public final class C38600e {
    private static final C27277i<C44709u, C45718aa> jdy = new C27277i();

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.e$a */
    public interface C19874a {
        /* renamed from: a */
        boolean mo35111a(C45718aa c45718aa);
    }

    static {
        AppMethodBeat.m2504i(123598);
        AppMethodBeat.m2505o(123598);
    }

    /* renamed from: a */
    public static void m65412a(C44709u c44709u, C45718aa c45718aa) {
        AppMethodBeat.m2504i(123595);
        jdy.mo44963f(c44709u, c45718aa);
        AppMethodBeat.m2505o(123595);
    }

    /* renamed from: t */
    public static void m65413t(C44709u c44709u) {
        AppMethodBeat.m2504i(123596);
        jdy.mo44962bD(c44709u);
        AppMethodBeat.m2505o(123596);
    }

    /* renamed from: a */
    public static C45718aa m65411a(C44709u c44709u, C19874a c19874a) {
        AppMethodBeat.m2504i(123597);
        if (c44709u == null) {
            AppMethodBeat.m2505o(123597);
            return null;
        }
        Set<C45718aa> bC = jdy.mo44961bC(c44709u);
        if (bC != null) {
            for (C45718aa c45718aa : bC) {
                if (c45718aa != null && c19874a.mo35111a(c45718aa)) {
                    AppMethodBeat.m2505o(123597);
                    return c45718aa;
                }
            }
        }
        AppMethodBeat.m2505o(123597);
        return null;
    }
}
