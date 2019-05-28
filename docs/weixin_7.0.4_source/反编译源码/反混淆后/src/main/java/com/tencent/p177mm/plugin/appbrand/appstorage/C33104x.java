package com.tencent.p177mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.appstorage.p1535a.C38120a;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.x */
public interface C33104x {

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.x$a */
    public enum C19094a implements C38120a {
        ;

        private C19094a(String str) {
        }

        static {
            AppMethodBeat.m2505o(129526);
        }

        /* renamed from: ys */
        public final int mo34317ys(String str) {
            AppMethodBeat.m2504i(129525);
            C41243o wI = C10048a.m17635wI(str);
            if (wI == null || wI.atI() == null) {
                AppMethodBeat.m2505o(129525);
                return 0;
            }
            int i = wI.atI().uin;
            AppMethodBeat.m2505o(129525);
            return i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.x$b */
    public enum C33105b implements C38120a {
        ;

        private C33105b(String str) {
        }

        static {
            AppMethodBeat.m2505o(129530);
        }

        /* renamed from: ys */
        public final int mo34317ys(String str) {
            AppMethodBeat.m2504i(129529);
            C1720g.m3534RN();
            int QF = C1668a.m3383QF();
            AppMethodBeat.m2505o(129529);
            return QF;
        }
    }
}
