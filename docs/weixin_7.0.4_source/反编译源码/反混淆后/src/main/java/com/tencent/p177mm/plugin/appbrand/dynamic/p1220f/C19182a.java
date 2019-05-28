package com.tencent.p177mm.plugin.appbrand.dynamic.p1220f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p653c.C46728g;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.f.a */
public class C19182a {
    private static volatile C46728g hob;
    private static volatile C46728g hoc;

    /* renamed from: nN */
    public static C46728g m29838nN(int i) {
        AppMethodBeat.m2504i(10908);
        C46728g azX;
        if (i == 1) {
            azX = C19182a.azX();
            AppMethodBeat.m2505o(10908);
            return azX;
        }
        azX = C19182a.azW();
        AppMethodBeat.m2505o(10908);
        return azX;
    }

    private static C46728g azW() {
        C46728g c46728g;
        AppMethodBeat.m2504i(10909);
        if (hob == null) {
            synchronized (C19182a.class) {
                try {
                    if (hob == null) {
                        c46728g = new C46728g();
                        c46728g.mo75145a(new C19183b(302));
                        c46728g.mo75145a(new C19184c(303));
                        c46728g.mo75145a(new C42424d(308));
                        c46728g.mo75145a(new C42426f());
                        c46728g.mo75145a(new C42427g());
                        hob = c46728g;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10909);
                    }
                }
            }
        }
        c46728g = hob;
        AppMethodBeat.m2505o(10909);
        return c46728g;
    }

    private static C46728g azX() {
        C46728g c46728g;
        AppMethodBeat.m2504i(10910);
        if (hoc == null) {
            synchronized (C19182a.class) {
                try {
                    if (hoc == null) {
                        c46728g = new C46728g();
                        c46728g.mo75145a(new C19183b(C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM));
                        c46728g.mo75145a(new C19184c(C31128d.MIC_PTU_ZIPAI_GRADIENT_FASHION));
                        c46728g.mo75145a(new C42424d(C31128d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI));
                        c46728g.mo75145a(new C42426f());
                        c46728g.mo75145a(new C42427g());
                        c46728g.mo75145a(new C42425e((byte) 0));
                        hoc = c46728g;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10910);
                    }
                }
            }
        }
        c46728g = hoc;
        AppMethodBeat.m2505o(10910);
        return c46728g;
    }
}
