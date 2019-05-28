package com.tencent.p177mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.o */
public final class C45677o {

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.o$a */
    public enum C45676a {
        GUIDE_EXPOSE(1),
        GUIDE_CLOSE(2),
        TO_APP_LAUNCHER(3),
        GUIDE_CLOSE_BY_BACK(4);
        
        final int value;

        static {
            AppMethodBeat.m2505o(132662);
        }

        private C45676a(int i) {
            this.value = i;
        }
    }

    /* renamed from: a */
    public static void m84378a(C45676a c45676a, String str) {
        AppMethodBeat.m2504i(132663);
        C7053e.pXa.mo8381e(14750, Integer.valueOf(c45676a.value), str);
        AppMethodBeat.m2505o(132663);
    }
}
